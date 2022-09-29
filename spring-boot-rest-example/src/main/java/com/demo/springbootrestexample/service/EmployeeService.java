package com.demo.springbootrestexample.service;

import com.demo.springbootrestexample.entity.Employee;
import com.demo.springbootrestexample.exception.NoSuchEmployeeExistException;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface EmployeeService {

    public Employee saveEmployeeDetails(Employee employee);
    public List<Employee> getAllEmployees();
    Employee getEmployee(Long id) throws NoSuchEmployeeExistException;
    void deleteEmployee(Long id);
}


