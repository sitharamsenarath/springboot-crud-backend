package com.springsample.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsample.springboot.model.Employee;
import com.springsample.springboot.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	 
	@PostMapping
	public String saveEmployee(@ModelAttribute ("employee") Employee employee){
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping
	public String getAllEmployees(Model model){
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "employees";
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployeeForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}
	
	@PostMapping("{id}")
	public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee, Model model){
		Employee existingEmployee = employeeService.getEmployeeById(id);
//		Employee existingEmployee = new Employee();
//		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeService.saveEmployee(existingEmployee);
		return "redirect:/employees";
	}
	
	@GetMapping("delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
	
	@GetMapping("/new")
	public String createStudentForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
}
