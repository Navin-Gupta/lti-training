package com.lti.training.multipleviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/jsp")
	public String homeJsp() {
		// add business logic 
		return "testJsp";
	}
	
	@GetMapping("/freemarker")
	public String homeMarker() {
		return "testFreeMarker";
	}
	
	@GetMapping("/thymeleaf")
	public String homeThymeleaf() {
		return "th_testThymeleaf";
	}
}
