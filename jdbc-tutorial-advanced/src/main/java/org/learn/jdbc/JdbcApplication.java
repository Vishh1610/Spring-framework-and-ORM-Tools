package org.learn.jdbc;

import org.learn.jdbc.dao.EmployeeDao;
import org.learn.jdbc.dao.impl.EmployeeDaoImpl;
import org.learn.jdbc.domain.Employee;



public class JdbcApplication {

    public static void main(String[] args) {
        //Employee employee = new Employee(1010,"Erich Maria Remarque");
        //Employee employee1 = new Employee(1011,"Vishwesh");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        //employeeDao.insert(employee1);
        //employeeDao.delete(1011);
        //employeeDao.update(employee1);









    }
}
