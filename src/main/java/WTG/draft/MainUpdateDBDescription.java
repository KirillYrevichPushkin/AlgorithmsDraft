package WTG.draft;

import DataBase.DBManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainUpdateDBDescription {
   static String[] descriptions = new String[2];

    public static void main(String[] args) {
        DBManager dbManager = new DBManager("jdbc:postgresql://localhost:5432/WTG?currentSchema=test", "postgres","1917");
        Connection connection;
        PreparedStatement preparedStatement;
    try{
        dbManager.connect();
        connection= dbManager.getConnection();

        ResultSet rs = connection.prepareStatement("SELECT * from test.locations where title != '' and id > 1845 order by id asc;").executeQuery();

        for(int i =0; i < 96 && rs.next(); i++){

            System.out.println("id = "+ rs.getString("id") + "  title " + rs.getString("title") + " \t address " + rs.getString("address") + " \t link =" + rs.getString("link_site"));

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            descriptions = getDescriptions(rs.getString("link_site"));
//
//            System.out.println("descriptions1 = " + descriptions[0] + "\ndescriptions2 = " + descriptions[1]);
//
//            preparedStatement = connection.prepareStatement("UPDATE test.locations SET description = ?, full_description = ? where id = ?;");
//            preparedStatement.setInt(3, rs.getInt("id"));
//            preparedStatement.setString(1, descriptions[0]);
//            preparedStatement.setString(2,descriptions[1]);
//            preparedStatement.executeUpdate();

        }



    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        dbManager.disconnect();
    }
        dbManager.disconnect();
    }

private static String[] getDescriptions (String url) throws IOException {
   // String[] desc = new String[2];
    Document doc = Jsoup.connect(url)
            //.userAgent("Chrome/4.0.249.0 Safari/532.5")
            .userAgent("Mozilla")
            //.userAgent("Chromium")
            //.referrer("https://www.google.com")
            .referrer("https://www.yandex.ru")
            .get();

    Elements name = doc.select(".title_container > .notranslate > a");
    System.out.println("Название " + name.text()); //название ресторана

    Elements address2 = doc.select("#info_location > div");
    System.out.println("Адрес " + address2.text()); //Адрес ресторана

    Elements workTime = doc.select(".short_info > .days");
    System.out.println("Время работы " + workTime.text()); //время работы ресторана

    Elements description = doc.select(".description > div > p");
    System.out.println("description full " + description.text()); //описание ресторана

    Elements description1 = doc.select(".description > div > p");
    //System.out.println("description " + description.get(0).text()); //описание ресторана короткое

    Elements description2 = doc.select(".description > div > p");
    if(description.size()>1 && description.size()!=0) {
        System.out.println("description 2 " + description.get(1).text()); //описание ресторана полное
    }
//    String[] timeString = workTime.text().split(" - ");
//    System.out.println("t1 = " + timeString[0] + " t2 " + timeString[1]);
//
//    String[] timeStartString = timeString[0].split(":");
//    String[] timeEndString = timeString[1].split(":");
//
//    System.out.println("ts1 = " + timeStartString[0] + " ts2 " + timeStartString[1]);
//    System.out.println("te1 = " + timeEndString[0] + " te2 " + timeEndString[1]);
    if(address2.text().equals("")){
        throw new IOException("Пустой адрес");
    }

    if(description.size()==0){
        descriptions[0] = null;
        descriptions[1] = null;
    }
    else if(description.size()>1) {
        descriptions[0] = description.get(0).text();
        descriptions[1] = description.get(1).text();
    } else {
        descriptions[0] = description.get(0).text();
        descriptions[1] = null;
    }
        return descriptions;
}




}
