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

import com.hd.spring.entity.Department;
import com.hd.spring.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public DepartmentServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String url) {
		this.restTemplate = restTemplate;
		this.crmRestUrl = url;
		logger.info("Load property: crm.rest.url" + crmRestUrl);
	}

	@Override
	public List<Department> getDepartments() {
		logger.info("in getDepartments(): Calling REST API" + crmRestUrl + "/departments");

		ResponseEntity<List<Department>> responseEntity = restTemplate.exchange(crmRestUrl + "/departments",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Department>>() {
				});

		List<Department> departments = responseEntity.getBody();
		logger.info("in getDepartments(): departments" + departments);

		return departments;
	}

	@Override
	public Department getDepartment(long id) {
		logger.info("in getDepartment(): Calling REST API " + crmRestUrl + "/departments/");

		Department department = restTemplate.getForObject(crmRestUrl + "/departments/" + id, Department.class);

		return department;
	}

}
