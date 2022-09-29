package com.demo.springbootrestexample.controller;

import com.demo.springbootrestexample.entity.Employee;
import com.demo.springbootrestexample.exception.NoSuchEmployeeExistException;
import com.demo.springbootrestexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public String saveEmployeeDetails(@RequestBody  Employee employee){
         Employee newEmployee = employeeService.saveEmployeeDetails(employee);
         return newEmployee.getId().toString();
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable Long id) throws NoSuchEmployeeExistException {
        try {
            Employee employee = employeeService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }catch (NoSuchEmployeeExistException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Employee> update (@RequestBody Employee employee, @PathVariable Long id){
        Employee existingEmployee = employeeService.getEmployee(id);
        employeeService.saveEmployeeDetails(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "Deleted Employee with id "+id;
    }
}
