package com.lti.training.multipleviews.viewconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class ThymeleafViewResolverConfig {

	@Bean
	public ViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		
		viewResolver.setTemplateEngine(thymeleafTemplateEngine());
		viewResolver.setOrder(0);
		
		// need to explicitly define naming convention for thymeleaf
		viewResolver.setViewNames(new String[] {"th_*"});
		return viewResolver;
	}
	
	public SpringTemplateEngine thymeleafTemplateEngine() {
		// Thymeleaf template engine serving html 5
		SpringTemplateEngine engine = new SpringTemplateEngine();
		
		// require TemplateResolver
		ClassLoaderTemplateResolver templateResolver =
				new ClassLoaderTemplateResolver();
		
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		
		engine.setTemplateResolver(templateResolver);
		
		return engine;
		
	}
}
