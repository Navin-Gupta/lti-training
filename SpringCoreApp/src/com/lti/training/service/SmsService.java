package com.lti.training.service;

import org.springframework.stereotype.Component;

// @Component("smsService")
@Component
public class SmsService implements IMessageService {

	@Override
	public String sendMessage(String message, String to) {
		// TODO Auto-generated method stub
		return "Sms send to " + to + "[" + message + "]";
	}

}
