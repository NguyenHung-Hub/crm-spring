package com.hd.spring.service;

import java.util.List;

import com.hd.spring.entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();
	public Employee getEmployee(long id);
	public void addEmployee(Employee employee);
	public void deleteEmployee(long id);
}
