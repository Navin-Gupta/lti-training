package com.lti.training.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorFixed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		
		for(int i = 1; i<= 10; i++) {
			FetchDataFromFile fetch = new FetchDataFromFile("File-" + i);
			// submitting this task to Thread Pool
			executor.execute(fetch);
		}
		
		// shutdown the executor
		executor.shutdown();
	}

}
