package com.hd.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.spring.entity.Department;
import com.hd.spring.service.DeparmentService;

@RestController
@RequestMapping("/api/departments")
public class DeparmentRestController {
	@Autowired
	private DeparmentService deparmentService;
	
	@GetMapping
	public List<Department> getDeparments() {
		return deparmentService.getDepartments();
	}
}
