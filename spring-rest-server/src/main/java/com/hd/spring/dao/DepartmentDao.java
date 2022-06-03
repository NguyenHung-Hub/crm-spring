package com.hd.spring.dao;

import java.util.List;

import com.hd.spring.entity.Department;

public interface DepartmentDao {
	public List<Department> getDepartments();
	public Department getDepartment(long id);
}
