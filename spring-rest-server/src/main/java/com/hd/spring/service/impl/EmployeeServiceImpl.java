package com.hd.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.spring.dao.EmployeeDao;
import com.hd.spring.entity.Employee;
import com.hd.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public Employee getEmployee(long id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		employeeDao.deleteEmployee(id);
	}

}
