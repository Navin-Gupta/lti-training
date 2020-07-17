package com.lti.training.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ScheduledExecutorService executor =  Executors.newScheduledThreadPool(3);
		for(int i = 1; i<= 5; i++) {
			FetchDataFromFile fetch = new FetchDataFromFile("File-" + i);
			// submitting this task to Thread Pool
			// executor.schedule(fetch, 5, TimeUnit.SECONDS);
			executor.scheduleAtFixedRate(fetch, 5, 10, TimeUnit.SECONDS);
		}
		
		Thread.sleep(100000);
		// shutdown the executor
		executor.shutdownNow();
		System.out.println("Completed all tasks...");
	}

}
