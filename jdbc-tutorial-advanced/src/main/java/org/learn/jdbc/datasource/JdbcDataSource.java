package org.learn.jdbc.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDataSource {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test_database?useSSL=false"; // it is basically URL of our database server.
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Vish@1617";

    public static final Connection getConnection(){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
