package com.hd.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.spring.dao.DepartmentDao;
import com.hd.spring.entity.Department;
import com.hd.spring.service.DeparmentService;

@Service
public class DepartmentServiceImpl implements DeparmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> getDepartments() {
		return departmentDao.getDepartments();
	}

	@Override
	public Department getDepartment(long id) {
		return departmentDao.getDepartment(id);
	}

}
