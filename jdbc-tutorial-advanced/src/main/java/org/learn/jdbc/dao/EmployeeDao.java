package org.learn.jdbc.dao;

import org.learn.jdbc.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    public void insert(Employee employee);
    public void update(Employee employee);
    public void findByEmployeeId(Integer id);
    public List<Employee> findAll();
    public void delete(Integer id);
}
