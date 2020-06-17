package com.lti.training.functionalapp;

@FunctionalInterface // compile time annotation
public interface Greetings {

	void sendGreetings(String message);
	
	// void test(String message);
}
