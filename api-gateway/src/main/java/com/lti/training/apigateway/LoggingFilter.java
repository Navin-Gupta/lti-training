package com.lti.training.apigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LoggingFilter extends ZuulFilter {

	private Logger log = LoggerFactory.getLogger(getClass());
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		// true : this filter to be active
		// false : inactive
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		// what to do in case request is intercepted
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("Zuul Intercepts : " + request.getRequestURL()) ;
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";  // "post"
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		// lower the value-higher the priority
		return 0;
	}

}
