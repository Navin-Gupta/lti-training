package com.lti.training.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class RejectedHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		FetchDataFromFile fetch = (FetchDataFromFile) task;
		System.out.println("Sorry! Could not read file : " + fetch.getFileName());
	}
	
}


public class ThreadPoolExecutorFixedCustom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int coreSize = 1;
		final int maxSize = 2;
		final int queueCapacity = 4;
		final long keepAliveTime = 10L;
		
		
		BlockingQueue queue = new LinkedBlockingQueue(queueCapacity);
		RejectedHandler rejectedHandler = new RejectedHandler();
		ThreadFactory factory = Executors.defaultThreadFactory();
		
		
		
		ThreadPoolExecutor executor = 
				new ThreadPoolExecutor(coreSize, 
									   maxSize, 
									   keepAliveTime, 
									   TimeUnit.MILLISECONDS, 
									   queue, 
									   factory, 
									   rejectedHandler);
		
		for(int i = 1; i<= 10; i++) {
			FetchDataFromFile fetch = new FetchDataFromFile("File-" + i);
			// submitting this task to Thread Pool
			executor.execute(fetch);
		}
		
		// shutdown the executor
		executor.shutdown();
		
	}

}
