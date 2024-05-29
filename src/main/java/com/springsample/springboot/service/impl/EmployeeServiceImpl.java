package com.springsample.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.springsample.springboot.model.Employee;
import com.springsample.springboot.repository.EmployeeRepository;
import com.springsample.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
