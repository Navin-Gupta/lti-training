package com.lti.training.executor;

import java.time.LocalDateTime;

public class FetchDataFromFile implements Runnable{

	private String fileName;
	
	public FetchDataFromFile(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Fetching data from " + fileName + " by " + Thread.currentThread().getName() + " | Start Time :  " + LocalDateTime.now());
			// read the file
			Thread.sleep(5000);
			System.out.println("File read successfull: " + fileName + " by " + Thread.currentThread().getName() + " | End Time :  " + LocalDateTime.now());
		}catch(Exception ex) {
			
		}
	}

}
