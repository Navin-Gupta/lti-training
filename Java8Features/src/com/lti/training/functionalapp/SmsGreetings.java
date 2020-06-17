package com.lti.training.functionalapp;

public class SmsGreetings implements Greetings {

	@Override
	public void sendGreetings(String message) {
		// TODO Auto-generated method stub
		System.out.println("Message Conveyed over SMS : " + message);
	}

}
