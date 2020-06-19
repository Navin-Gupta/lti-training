package com.lti.training.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lti.training.config.ContextConfig;
import com.lti.training.service.IMessageService;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ask bean factory to make us available the service
		
		// ApplicationContext
		// Initiate the Bean Factory (explicitly) based on config 
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfig.class);// Singleton
	
		// demand an bean object
		// IMessageService service =  context.getBean("msgService", IMessageService.class);
		IMessageService service =  context.getBean("emailService", IMessageService.class);// Prototype
		
		/*AnnotationConfigApplicationContext contextPro =
				new AnnotationConfigApplicationContext(ContextConfig.class);*/

		IMessageService servicePro =  context.getBean("emailService", IMessageService.class);
		// call the service API
		String ack = service.sendMessage("Hello", "someone");
		System.out.println(ack);
		
		
		// closing the context explicitly
		context.close();
	}	

}
