package com.lti.training.executor;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Double>{

	private double value;
	
	public Factorial(double value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	@Override
	public Double call() throws Exception {
		System.out.println("Calculating Factorial : " + Thread.currentThread().getName());
		Thread.sleep(5000);
		double fact = 1;
		for(int i=1;i<=value;i++) {
			fact*=i;
		}
		return fact;
	}

}
