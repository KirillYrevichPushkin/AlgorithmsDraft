package selenium;

import DataBase.DBManager;
import WTG.draft.scriptDB.LocationDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement ps;


    public static void main(String[] args) {
        File fileHref = new File("src/main/java/selenium/href.txt");
        List<LocationDTO> locationDTOList = new LinkedList<>();

        DBManager dbManager = new DBManager("jdbc:postgresql://localhost:5432/WTG?currentSchema=test", "postgres","1917");
        dbManager.connect();
        connection = dbManager.getConnection();
        ResultSet rs = dbManager.executeQuery("SELECT * FROM locations");

        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileHref))){
            LocationDTO locationDTO;
            String s = dis.readUTF();
            while (s!=null) {

                Thread.sleep(2000);
                System.out.println("s " + s);
                locationDTO = getLocationDTO(s);
                System.out.println(locationDTO.toString());
                if(locationDTO.getTitle().equals("")){
                    break;
                }
                locationDTOList.add(locationDTO) ;

                ps = connection.prepareStatement("INSERT INTO locations (title, link_site, address) values(?,?,?);");
                ps.setString(1,locationDTO.getTitle());
                ps.setString(2,locationDTO.getLinkSite());
                ps.setString(3,locationDTO.getAddress());

                ps.executeUpdate();

                s = dis.readUTF();
            }
           // }

//            for (LocationDTO l:locationDTOList ) {
//                System.out.println(l.toString());
//            }



//        try {
//            while (rs.next()) {
//                System.out.println(rs.getString("title"));
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            dbManager.disconnect();
//        }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            System.out.println("File end");
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dbManager.disconnect();
        }


        dbManager.disconnect();

    }

    public static LocationDTO getLocationDTO(String url) throws IOException {
        LocationDTO locationDTO = new LocationDTO();

        Document doc = Jsoup.connect(url)
                //.userAgent("Chrome/4.0.249.0 Safari/532.5")
                .userAgent("Mozilla")
                .referrer("https://www.google.com")
                .get();

        Elements name = doc.select(".title_container > .notranslate > a");
        System.out.println("Название " + name.text()); //название ресторана

//        Elements description = doc.select(".title_container > .notranslate > a");
//        System.out.println("Название " + name.text()); //описание ресторана

        Elements address = doc.select("#info_location > div");
        System.out.println("Адрес " + address.text()); //Адрес ресторана

        Elements workTime = doc.select(".short_info > .days");
        //      System.out.println("Время работы " + workTime.text()); //время работы ресторана

        locationDTO.setLinkSite(url);
        locationDTO.setTitle(name.text());
        locationDTO.setAddress(  address.text().replace("Адрес ",""));

        return locationDTO;
    }


}
