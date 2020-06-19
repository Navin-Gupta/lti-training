package com.lti.training.service;

import org.springframework.stereotype.Component;

// @Component
public class ProfessionalFortune implements IFortuneService {

	@Override
	public String dailyFortune() {
		// TODO Auto-generated method stub
		return "Today is boss is on leave!!!";
	}

}
