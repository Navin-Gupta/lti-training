package com.lti.training.mavenweb.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// /employee/home
	// @RequestMapping("/home") // of any http verb (get,post,put)
	@RequestMapping(value =  {"/home","/dashboard"}) // of any http verb (get,post,put)
	public String home() {
		return "employee-home";
	}
	
	
	@GetMapping("/record")
	// @RequestMapping(value= "/record", method = RequestMethod.GET) // only get
	public String record() {
		return "employee-home";
	}
	
	@RequestMapping(value= "/record", method = {RequestMethod.POST, RequestMethod.PUT}) // only post and put
	public String recordPost() {
		return "employee-home";
	}
	
	// /employee : class level url
	@RequestMapping()
	public String defaultHandler() {
		return "employee-home";
	}
	
	// /employee/xyz
	// /xyz
	@RequestMapping("*")
	public String fallback() {
		return "error-page";
	}
	
	@RequestMapping("/check")
	@ResponseBody
	public String check() {
		return "<h1>HEllo</h1>";
	}
	
	
	
}
