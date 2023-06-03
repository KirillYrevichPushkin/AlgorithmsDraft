package WTG.draft;

import DataBase.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCAston {



    public static void main(String[] args) throws SQLException {

        DBManager dbManager = new DBManager("jdbc:postgresql://95.163.237.3:5432/wtg_db?currentSchema=public", "wtg","wtg");
        Connection connection = null;
        PreparedStatement preparedStatement;
        System.out.println(connection);
        dbManager.connect();
        connection = dbManager.getConnection();
        System.out.println(connection);


        connection.close();
        dbManager.disconnect();


    }


}
