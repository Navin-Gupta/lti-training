package com.lti.training.bootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.bootapp.model.Employee;

@RestController
@RequestMapping("/api")
public class RestTestController {

	@GetMapping("/test")
	public Employee test() {
		Employee employee = new Employee("First", "first@mail.com", "IT");
		System.out.println(employee);
		return employee;
	}
}
