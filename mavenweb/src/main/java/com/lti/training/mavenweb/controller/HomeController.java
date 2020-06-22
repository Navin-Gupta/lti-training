package com.lti.training.mavenweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// container to hold request methods
@Controller
public class HomeController {
	
	// request methods
	// public , shall return a String, shall be mapped to a particular URL
	@RequestMapping("/") // root request
	public String home() {
		// view page name
		// /WEB-INF/views/index.jsp
		return "index";
	}
}
