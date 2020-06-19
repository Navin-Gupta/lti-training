package com.lti.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.lti.training.service.IFortuneService;
import com.lti.training.service.PersonalFortune;


// need to indicate spring to use this class as config class
@Configuration
// need to specify the location of resources to be managed
// @ComponentScan(basePackages = {"com.lti.training.service","",""})
@ComponentScan("com.lti.training.service")
// also scan for property file
@PropertySource("classpath:message-repo.properties")
public class ContextConfig {

	// logic to expose a bean programmatically
	@Bean
	public IFortuneService getFortune() {
		// logic and condition
		IFortuneService fortuneService = new PersonalFortune();
		return fortuneService;
	}
}
