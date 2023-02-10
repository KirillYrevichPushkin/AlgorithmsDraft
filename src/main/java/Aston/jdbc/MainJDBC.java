package Aston.jdbc;

import java.sql.*;

public class MainJDBC {

    private static final String URL = "jdbc:sqlite:tempDBLite.db";
    private static final String login = "";
    private static final String password = "";

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet rs;


        try {


           // Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
            preparedStatement = connection.prepareStatement("select * from users");

            rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println("name = " + rs.getString("name"));
            }








        } catch (SQLException e) {
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
           // e.printStackTrace();
       // }
        finally {
            connection.close();
        }


    }


}
