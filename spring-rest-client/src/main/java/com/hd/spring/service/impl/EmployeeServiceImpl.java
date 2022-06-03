package com.hd.spring.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hd.spring.entity.Employee;
import com.hd.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public EmployeeServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String url) {
		this.restTemplate = restTemplate;
		this.crmRestUrl = url;
		logger.info("Load property: crm.rest.url" + crmRestUrl);
	}

	@Override
	public List<Employee> getEmployees() {
		logger.info("in getEmployees(): Calling REST API" + crmRestUrl + "/employees");
		
		ResponseEntity<List<Employee>> responseEntity = 
				restTemplate.exchange(crmRestUrl + "/employees", HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Employee>>() {});
		
		List<Employee> employees = responseEntity.getBody();
		logger.info("in getEmployees(): employees" + employees);
		
		return employees;
	}

	@Override
	public Employee getEmployee(long id) {
		logger.info("in getEmployee(): Calling REST API " + crmRestUrl + "/employees");
		
		Employee employee = restTemplate.getForObject(crmRestUrl + "/employees/" + id, Employee.class);
		
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		logger.info("in addEmployee(): Calling REST API " + crmRestUrl + "/employees");
		
		long id = employee.getId();
		
		if (id == 0) {
			restTemplate.postForEntity(crmRestUrl + "/employees", employee, String.class);
		} else {
			restTemplate.put(crmRestUrl + "/employees", employee);
		}
		
		logger.info("in addEmployee(): success");
	}

	@Override
	public void deleteEmployee(long id) {
		logger.info("in deleteEmployee(): Calling REST API " + crmRestUrl + "/employees");
		
		restTemplate.delete(crmRestUrl + "/employees/" + id);
		
		logger.info("in deleteEmployee(): deleted employee id = " + id);
	}

}
