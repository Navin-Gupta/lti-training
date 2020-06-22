package com.lti.training.mavenweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// enable the abstract Spring mvc architecture
@EnableWebMvc
@ComponentScan("com.lti.training.mavenweb")
public class ServletConfig {

	// add config for View Resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// location
		viewResolver.setPrefix("/WEB-INF/views/");
		// extension (template)
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
}
