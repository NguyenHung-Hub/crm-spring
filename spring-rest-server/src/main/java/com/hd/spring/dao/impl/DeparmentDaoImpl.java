package com.hd.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hd.spring.dao.DepartmentDao;
import com.hd.spring.entity.Department;

@Repository
@Transactional
public class DeparmentDaoImpl implements DepartmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Department> getDepartments() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Department> departments = session.createQuery("from Department order by name", Department.class)
				.getResultList();
		return departments;
	}

	@Override
	public Department getDepartment(long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Department department = session.get(Department.class, id);
		
		return department;
	}

}
