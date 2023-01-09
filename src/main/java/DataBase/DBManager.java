package DataBase;

import java.sql.*;

public class DBManager {
    private final String jdbcUrl;
    private final String user;
    private final String password;
    private Connection connection;
    private Statement stmt;


    public DBManager(String jdbcUrl,String user, String password) {
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
    }


    public  void connect()  {
        try {
            connection = DriverManager.getConnection(jdbcUrl, user,password);
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql){
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            disconnect();
            return null;
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public Statement getStatement(){
        return stmt;
    }

}
