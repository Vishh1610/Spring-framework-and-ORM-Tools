package org.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learn.hibernate.dao.EmployeeDao;
import org.learn.hibernate.dao.impl.EmployeeDaoImpl;
import org.learn.hibernate.datasource.DataSource;
import org.learn.hibernate.domain.Employee;

import java.util.List;


public class HibernateApplication {
    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        /*List<Employee> employees = employeeDao.findAll();
        for (Employee e : employees){
            System.out.println(e);
        }*/
        //System.out.println(employeeDao.findByEmployeeId(1005));
        /*Employee employee = new Employee("John smith");
        employeeDao.insert(employee);
        employeeDao.findAll().forEach(e -> System.out.println(e));*/

        employeeDao.delete(4);
        DataSource.closeSessionFactory();
    }
}
