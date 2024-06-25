package com.springsample.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springsample.springboot.exception.ResourceNotFoundException;
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



	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
	}



	@Override
	public Employee updateEmployee(Employee employee) {		
		return employeeRepository.save(employee);
	}



	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}

}
