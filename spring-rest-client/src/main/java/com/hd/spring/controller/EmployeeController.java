package com.hd.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hd.spring.entity.Employee;
import com.hd.spring.service.DepartmentService;
import com.hd.spring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final DepartmentService departmentService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}
	
	
	@GetMapping("/")
	public String listCustomers(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		
		model.addAttribute("employees", employees);
		
		return "list-employee";
	}
	
	@GetMapping("/showFormAddEmployee")
	public String showFormAddEmployee(Model model) {
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentService.getDepartments());
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		
		return "redirect:/";
	}
	
	@GetMapping("/showFormUpdateEmployee")
	public String showFormUpdateEmployee(@RequestParam("employeeId") int id, Model model) {
		Employee employee = employeeService.getEmployee(id);
		
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentService.getDepartments());
		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}
