package com.lti.training.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallable {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService executor =  Executors.newFixedThreadPool(4);
		List<Factorial> tasks = new ArrayList<Factorial>();
		tasks.add(new Factorial(20));
		tasks.add(new Factorial(25));
		tasks.add(new Factorial(30));
		tasks.add(new Factorial(35));
		
		List<Future<Double>> results = executor.invokeAll(tasks);
		Double response =  executor.invokeAny(tasks);  // blocking : wait till any of thread
		
		for(Future<Double> result : results) {
			// result.get(); // block ~ join
		}
		
		
		
		
				
	}
}
