package org.learn.jdbc;

import java.sql.*;

public class JdbcApplication {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/test_database?useSSL=false"; // it is basically URL of our database server.
    static final String USER_NAME = "root";
    static final String PASSWORD = "Vish@1617";


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        CallableStatement callableStatement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            //System.out.println("DATABASE Connection Established : ");
            // once we open database we need to close that database too.

            statement = connection.createStatement();

            /*String sqlCreateTable = "CREATE TABLE EMPLOYEE("
                    + "ID INT NOT NULL PRIMARY KEY,"
                    + "NAME VARCHAR(100) NOT NULL"
                    +");";
            */

            /*String sqlInsert = "INSERT INTO EMPLOYEE"
                    + "(ID,NAME)"
                    + "VALUES(1002,'Sherlock Homes')";
              */

           // String sqlUpdate = "UPDATE EMPLOYEE SET NAME='John Smith' WHERE ID=1002";

           String sqlPreparedInsert = "INSERT INTO EMPLOYEE (ID,NAME) VALUES(?,?)";

            String sqlQuery = "SELECT * FROM EMPLOYEE";

            //String sqlDelete = "DELETE FROM EMPLOYEE WHERE ID=1001";
            //statement.execute(sqlCreateTable);
            //statement.executeUpdate(sqlInsert);
            //statement.executeUpdate(sqlUpdate);

            //ResultSet resultSet = statement.executeQuery(sqlQuery);

            /*while (resultSet.next()){
                System.out.println("ID = " + resultSet.getInt("ID") + " " + "NAME = " + resultSet.getString("NAME"));
                //System.out.println("ID = " + resultSet.getInt(1) + " " + "NAME = " + resultSet.getString(2));
                // WE CAN CALL THEM THROUGH NAME OR INDEX OF THE COLUMN.
                //System.out.println(resultSet.getMetaData());
                // This one is for to inspect what we are getting from database.
            }

            statement.executeUpdate(sqlDelete);
            */

           /* preparedStatement = connection.prepareStatement(sqlPreparedInsert);
            preparedStatement.setInt(1,1003);
            preparedStatement.setString(2,"Adam Smith");
            preparedStatement.executeUpdate();

            preparedStatement.setInt(1,1004);
            preparedStatement.setString(2,"Richard Knox");
            preparedStatement.executeUpdate(); */

            String sqlStoredProcedure = "{call our_test_procedure(?,?)}";
            callableStatement = connection.prepareCall(sqlStoredProcedure);
            callableStatement.setInt(1,1005);
            callableStatement.setString(2,"other name");
            callableStatement.executeUpdate();




            ResultSet resultSet2 = statement.executeQuery(sqlQuery);

            while (resultSet2.next()){
                System.out.println("ID = " + resultSet2.getInt("ID") + " " + "NAME = " + resultSet2.getString("NAME"));
                //System.out.println("ID = " + resultSet2.getInt(1) + " " + "NAME = " + resultSet2.getString(2));
                // WE CAN CALL THEM THROUGH NAME OR INDEX OF THE COLUMN.
                //System.out.println(resultSet2.getMetaData());
                // This one is for to inspect what we are getting from database.
            }

            //statement.executeUpdate(sqlInsert);




        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
