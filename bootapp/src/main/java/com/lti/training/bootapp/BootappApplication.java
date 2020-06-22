package com.lti.training.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = {"com.extra.resource","com.lti.training.bootapp"})
@SpringBootApplication
public class BootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootappApplication.class, args);
	}

	// launch the tomcat
	// deploy the web application
	
	// dispatcher servlet config is done by default
	// this class itself is a config file
	
}
