package com.lti.training.mavenweb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// AbstractAnnotationConfigDispatcherServletInitializer : auto register DS
public class WebXmlAlternate extends AbstractAnnotationConfigDispatcherServletInitializer{

	// spring specific config viz DB, security etc
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"}; // all request are mapped to DS
	}

}
