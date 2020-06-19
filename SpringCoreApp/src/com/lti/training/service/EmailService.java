package com.lti.training.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Create an object(bean) of this class and expose it as bean
// @Component("msgService")
// @Component("emailService")
@Component
// @Scope("prototype")
public class EmailService implements IMessageService {

	// lifecycle hook methods
		// => can have any name
		// => can have any access modifier
		// => may return values
		// => cannot have param
	
	// set up callback method ( before bean is exposed)
	@PostConstruct
	private void setUp() {
		System.out.println("Bean Initiated");
	}
	
		
	// clean up callback method ( before bean is destroyed)
	@PreDestroy
	public void cleanUp() {
		System.out.println("Bean Cleaned Up");
	}
	
	// @Autowired //field
	private IFortuneService fortuneService;
	
	@Value("${mail.sender}")
	private String sender;
	
	 @Autowired // setter based 
	//  @Qualifier("professionalFortune")
	public void xyz(IFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	/*
	// @Autowired
	public EmailService(@Qualifier("professionalFortune") IFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	
	/*public EmailService() {
		// TODO Auto-generated constructor stub
		System.out.println("Email Instance created");
	}*/
	
	
	@Override
	public String sendMessage(String message, String to) {
		// TODO Auto-generated method stub
		return "Email send to " + to + "[" + message + "]" + "\n" + 
				"Sent By : " + this.sender + "\n" +
				this.fortuneService.dailyFortune();
	}

}
