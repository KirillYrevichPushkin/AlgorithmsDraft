package WTG.draft;


import DataBase.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс для миграции данных с одной БД в другую
 *
 * */
public class ScriptMoving {
    public static void main(String[] args) {
        //подключение к локальной БД
        DBManager dbManagerLocal = new DBManager("jdbc:postgresql://localhost:5432/WTG?currentSchema=test", "postgres","1917");
        Connection connectionLocal;
        PreparedStatement psl;
        PreparedStatement psr;

        //подключение к удаленной БД
        DBManager dbManagerRemote = new DBManager("jdbc:postgresql://95.163.237.3:5432/wtg_db?currentSchema=public", "wtg","wtg");
        Connection connectionRemote;


        try {
            dbManagerLocal.connect();
            connectionLocal= dbManagerLocal.getConnection();
            ResultSet rs = connectionLocal.prepareStatement("SELECT * from test.locations where title != '' and id > 21 and latitude != 0 order by id asc;").executeQuery();
            System.out.println("connectionLocal " + connectionLocal.getMetaData());

            dbManagerRemote.connect();
            connectionRemote = dbManagerRemote.getConnection();
            System.out.println("\nconnectionRemote " + connectionRemote.getMetaData());

            while (rs.next()) {
                System.out.println("id = " + rs.getString("id") + " title =" + rs.getString("title") );
                psr = connectionRemote.prepareStatement("INSERT INTO locations (title,description,full_description,address,latitude,longitude,link_site) values(?,?,?,?,?,?,?);");
                psr.setString(1, rs.getString("title"));
                psr.setString(2, rs.getString("description"));
                psr.setString(3, rs.getString("full_description"));
                psr.setString(4, rs.getString("address"));
                psr.setDouble(5, rs.getDouble("latitude"));
                psr.setDouble(6, rs.getDouble("longitude"));
                psr.setString(7, rs.getString("link_site"));

                psr.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbManagerLocal.disconnect();
        dbManagerRemote.disconnect();

    }


}
