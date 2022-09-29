package com.demo.springbootrestexample.service;

import com.demo.springbootrestexample.entity.Employee;
import com.demo.springbootrestexample.exception.NoSuchEmployeeExistException;
import com.demo.springbootrestexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) throws NoSuchEmployeeExistException {
        Employee employeeExist = null;
        if(employeeRepository.findById(id).isEmpty()){
                  throw new NoSuchEmployeeExistException("Employee not found");
        }else
            employeeExist = employeeRepository.findById(id).get();
        return employeeExist;  }

    @Override
    public void deleteEmployee(Long id){
         employeeRepository.deleteById(id);
    }
}
