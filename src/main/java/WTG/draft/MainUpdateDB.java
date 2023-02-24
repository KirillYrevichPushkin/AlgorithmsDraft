package WTG.draft;

import DataBase.DBManager;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainUpdateDB {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager("jdbc:postgresql://95.163.237.3:5432/wtg_db?currentSchema=public", "wtg","wtg");
        Connection connection;
        PreparedStatement preparedStatement;

        dbManager.connect();

        connection= dbManager.getConnection();

        double[]coordinate = new double[2];
        try {
            ResultSet rs = connection.prepareStatement("select * from locations l where l.latitude isnull ").executeQuery();
        //while (rs.next()){
            for(int i =0; i < 80 && rs.next(); i++){

            System.out.println("id = "+ rs.getString("id") + "  title " + rs.getString("title") + " \t address " + rs.getString("address") + " \t link =" + rs.getString("link_site"));

            try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                coordinate = getCoordinate(rs.getString("address"));
            System.out.println("long = " + coordinate[0] + "  lat = " + coordinate[1]);

            preparedStatement = connection.prepareStatement("UPDATE locations SET longitude = ?, latitude = ? where id = ?;");
            preparedStatement.setInt(3, rs.getInt("id"));
            preparedStatement.setDouble(1, coordinate[0]);
            preparedStatement.setDouble(2,coordinate[1]);
            preparedStatement.executeUpdate();

        }





        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbManager.disconnect();
        }




        dbManager.disconnect();
    }

    //[0] - longitude;  [1] - latitude
    public static double[] getCoordinate(String address){
        String[]coordinates = new String[2];
        double[]coord = new double[2];
        String url = String.format("https://search-maps.yandex.ru/v1/?text=%s&type=geo&lang=ru_RU&apikey=56a66ddf-edfc-40a0-b66e-f59f7826e136", address.replace(" ", "_").replace("\"","").strip());
        System.out.println("++++URL " + url);
        List<Double> coordinateList = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url.replace(" ", "_")))
                    .headers("Content-Type", "text/plain;charset=UTF-8")
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body().toString());
            String[] coordinate = response.body().toString().split("coordinates\":\\[");
            String[] coordinatelast = coordinate[1].split("\\]");
            coordinates = coordinatelast[0].split(",");

            coordinateList = new ArrayList<>();
//            coordinateList =  Arrays.stream((response.body().toString().substring(response.body().toString().indexOf("coordinate") +14, response.body().toString().lastIndexOf("]},", response.body().toString().indexOf("coordinate") +14 + 21)))
//                            .split(","))
//                    .map( s -> {
//                        return Double.parseDouble(s);
//                    }).collect(Collectors.toList());


            Pattern p1 = Pattern.compile("(\\\"coordinates\\\")([:][\\[])([0-9.,]*)([\\]][\\}])");
            Matcher m1 = p1.matcher(response.body().toString());
            m1.find();
            String strCoordinate = m1.group();

            Pattern p2 = Pattern.compile("[0-9.]+");
            Matcher m2 = p2.matcher(strCoordinate);
            m2.find();
            coordinateList.add(Double.valueOf(m2.group()));

            m2.find();
            coordinateList.add(Double.valueOf(m2.group()));

            System.out.println(coordinateList.toString());


        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        coord[0] = Double.parseDouble(coordinates[0]);
//        coord[1] = Double.parseDouble(coordinates[1]);
        coord[0] = coordinateList.get(0);
        coord[1] = coordinateList.get(1);
        //[0] - longitude;  [1] - latitude




        //return coordinateList;

        return coord;
    }


}
