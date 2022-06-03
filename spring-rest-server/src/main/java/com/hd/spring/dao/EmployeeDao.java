package com.hd.spring.dao;

import java.util.List;

import com.hd.spring.entity.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployee(long id);
	public void addEmployee(Employee employee);
	public void deleteEmployee(long id);
}
