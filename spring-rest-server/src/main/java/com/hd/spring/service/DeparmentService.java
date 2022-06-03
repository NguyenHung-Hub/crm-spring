package com.hd.spring.service;

import java.util.List;

import com.hd.spring.entity.Department;

public interface DeparmentService {
	public List<Department> getDepartments();
	public Department getDepartment(long id);
}
