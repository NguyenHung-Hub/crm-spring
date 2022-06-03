package com.hd.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.spring.entity.Employee;
import com.hd.spring.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") long id) {
		Employee employee = employeeService.getEmployee(id);
		
		if (employee == null) throw new EmployeeNotFoundException("Employee id not found - " + id);
		
		return employee;
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}
	
	@PutMapping
	public Employee updateCustomer(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/{employeeId}")
	public String deleteCustomer(@PathVariable(name = "employeeId") long id) {
		Employee employee = employeeService.getEmployee(id);
		if (employee == null) throw new EmployeeNotFoundException("Employee id not found - " + id);
		employeeService.deleteEmployee(id);
		return "Deleted employee id - " + id;
 	}
}
