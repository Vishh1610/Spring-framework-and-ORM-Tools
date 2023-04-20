package org.learn.jdbc.dao.impl;

import org.learn.jdbc.dao.EmployeeDao;
import org.learn.jdbc.domain.Employee;

import java.sql.*;
import java.util.List;

import static org.learn.jdbc.datasource.JdbcDataSource.getConnection;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String INSERT = "INSERT INTO EMPLOYEE (ID,NAME) VALUES(?,?)";

    @Override
    public void insert(Employee employee) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(2,employee.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
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

    @Override
    public void update(Employee employee) {
       /* Connection connection = getConnection();
        Statement statement = null;
        String SqlUpdate = "UPDATE EMPLOYEE SET NAME='John Smith' WHERE ID=1011";

        try {
            statement = connection.createStatement();
            statement.executeUpdate(SqlUpdate);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

    }

    @Override
    public void findByEmployeeId(Integer id) {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

        /*Connection connection = getConnection();
        Statement statement = null;
        String SqlDelete = "DELETE FROM EMPLOYEE WHERE ID = 1011";
        try {
         preparedStatement = connection.prepareStatement(SqlDelete);
          preparedStatement.setInt(1,1010);
          preparedStatement.executeUpdate();


            statement = connection.createStatement();
            statement.executeUpdate(SqlDelete);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } */

    }
}
