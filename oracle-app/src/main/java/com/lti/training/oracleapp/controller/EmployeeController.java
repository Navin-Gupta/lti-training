package com.lti.training.oracleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.oracleapp.entity.Employee;
import com.lti.training.oracleapp.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> employees = this.repository.findAll();
		
		ResponseEntity<List<Employee>> response = 
				new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
		return response;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		// Employee new_employee = this.repository.save(employee);
		this.repository.SAVE_EMPLOYEE(employee.getName(), employee.getEmail());
		
		ResponseEntity<Employee> response = 
				new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
		return response;
	}
}
