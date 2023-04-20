package org.learn.hibernate.dao;

import org.learn.hibernate.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    public void insert(Employee employee);
    public void update(Employee employee);
    public Employee findByEmployeeId(Integer id);
    public List<Employee> findAll();
    public void delete(Integer id);
}
