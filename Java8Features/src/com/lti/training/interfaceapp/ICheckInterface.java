package com.lti.training.interfaceapp;

public interface ICheckInterface {
	void test();
	
	default void testExtension() {
		System.out.println("Some default implementation");
	}
}
