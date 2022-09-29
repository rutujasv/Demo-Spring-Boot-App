package com.demo.springbootrestexample.repository;

import com.demo.springbootrestexample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
