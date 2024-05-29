package com.springsample.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsample.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
