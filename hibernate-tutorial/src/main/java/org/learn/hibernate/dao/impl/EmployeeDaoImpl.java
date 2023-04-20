package org.learn.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.learn.hibernate.dao.EmployeeDao;
import org.learn.hibernate.datasource.DataSource;
import org.learn.hibernate.domain.Employee;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{


    @Override
    public void insert(Employee employee) {
        Session session = DataSource.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Employee employee) {
        Session session = DataSource.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();

    }

    @Override
    public Employee findByEmployeeId(Integer id) {

        Session session = DataSource.getSessionFactory().openSession();
        TypedQuery<Employee> query = session.createQuery("From Employee where id=:id", Employee.class);
        query.setParameter("id",id);
        Employee employee = query.getSingleResult();
        session.close();

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Session session = DataSource.getSessionFactory().openSession();

        List<Employee> employees =  session.createQuery("From Employee", Employee.class).getResultList();

        //List<Employee> employees = session.createCriteria(Employee.class).list();

        session.close();
        return employees;
    }

    @Override
    public void delete(Integer id) {

        Session session = DataSource.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.load(Employee.class,id);
        session.delete(employee);

        Query query = session.createQuery("delete Employee where id=:id");
        query.setParameter("id",id);
        int result = query.executeUpdate();
        System.out.println(result);

        transaction.commit();
        session.close();

    }
}
