package com.lti.training.oracleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;


import com.lti.training.oracleapp.entity.Employee;

@Repository
public interface EmployeeRepository 
		extends JpaRepository<Employee, Integer>, CustomRepository{
	
	// add a method with the same name as the Procedure
	@Procedure
	void SAVE_EMPLOYEE(String uname, String email);
	
	// any custom name
	/*  
	 *void fun(String uname, String email); 
	 */
	
}
