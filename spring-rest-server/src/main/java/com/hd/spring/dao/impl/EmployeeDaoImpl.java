package com.hd.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hd.spring.dao.EmployeeDao;
import com.hd.spring.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Employee> employees = session.createQuery("from Employee order by lastName", Employee.class)
				.getResultList();
		
		return employees;
	}

	@Override
	public Employee getEmployee(long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(session.get(Employee.class, id));
	}

}
