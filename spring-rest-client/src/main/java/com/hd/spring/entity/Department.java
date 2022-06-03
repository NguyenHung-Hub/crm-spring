package com.hd.spring.entity;

import java.util.List;

public class Department {
	private long id;
	private String name;
	private List<Employee> employees;
	/**
	 * @param id
	 * @param name
	 * @param employees
	 */
	public Department(long id, String name, List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.employees = employees;
	}
	
	public Department() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
	
	
}
