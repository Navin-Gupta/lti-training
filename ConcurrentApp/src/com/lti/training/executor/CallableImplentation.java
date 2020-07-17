package com.lti.training.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableImplentation {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService executor =  Executors.newFixedThreadPool(4);
		
		Future<Double> fact1 = executor.submit(new Factorial(20));
		Future<Double> fact2 = executor.submit(new Factorial(25));
		Future<Double> fact3 = executor.submit(new Factorial(30));
		Future<Double> fact4 = executor.submit(new Factorial(35));
		
		// whenever need the value 
		System.out.println("Factorial of 20 : " + fact1.get());  // blocked : if the thread is still running
		System.out.println("Factorial of 25 : " + fact2.get());
		System.out.println("Factorial of 30 : " + fact3.get());
		System.out.println("Factorial of 35 : " + fact4.get());
		
		
		executor.shutdown();
	}

}
