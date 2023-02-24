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

public class MainUpdateDBLinkImage {

    public static void main(String[] args) {
        DBManager dbManager = new DBManager("jdbc:postgresql://95.163.237.3:5432/wtg_db?currentSchema=public", "wtg","wtg");
        Connection connection;
        PreparedStatement preparedStatement;

        dbManager.connect();

        connection= dbManager.getConnection();

    try{
        ResultSet rs = connection.prepareStatement("select * from locations l left join locations_categories lc on l.id  = lc.location_id \n" +
                "left join categories_for_locations cfl on lc.category_id = cfl .id where cfl.id = 2 and l.link_image isnull ").executeQuery();

 //       ResultSet rs = connection.prepareStatement("select * from locations l where id in (2848,2918,2941,2598,2263,2306,1727,2737,2285,1789,3001,2442,2020,2813,2870,2779) ").executeQuery();

        for (int i = 0; i < 100 && rs.next(); i++) {

            System.out.println("id = " + rs.getString("id") + "  title " + rs.getString("title") + " \t link =" + rs.getString("link_site") + " \t linkImage =" + rs.getString("link_image"));
            String linkImage = getLinkImage(rs.getString("link_site"));
            if(linkImage == null) break;
            System.out.println("new LI = " + linkImage);

           // if(!linkImage.equals("")) {
                preparedStatement = connection.prepareStatement("update locations set link_image = ? where id = ?;");
                preparedStatement.setString(1, linkImage);
                preparedStatement.setInt(2, rs.getInt("id"));
                preparedStatement.executeUpdate();
          //  }
          //  linkImage = "";
        }




    } catch (
    SQLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        dbManager.disconnect();
    }




        dbManager.disconnect();

    }


    public static String getLinkImage(String linkSite) throws IOException {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.connect(linkSite)
                //.userAgent("Chrome/4.0.249.0 Safari/532.5")
                .userAgent("Mozilla")
                .referrer("https://www.google.com")
                .get();

        Elements detected = doc.select("body >div.content > div > p");
        if(detected.text().startsWith("Our systems")) {
            System.out.println("detected " + detected.text().startsWith("Our systems"));
            return null;
        }else {
        Elements linkImage = doc.select(".collageWrapper > img");
        return   linkImage.attr("src");}

    }

}
