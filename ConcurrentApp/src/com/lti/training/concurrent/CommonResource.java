package com.lti.training.concurrent;

public class CommonResource {

	private String names[];
	
	synchronized public void manageArray() {
		// array is being used/manipulated
	}
	
	synchronized public void changeArray() {
		// array is being used/manipulated
	}
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// obj : Object of CommonResource
		//synchronized(obj) {
		  obj.manageArray();
		  
		  
		//}
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// obj : (Same)Object of CommonResource
		// obj.manageArray();
		obj.changeArray();
	}
	
}