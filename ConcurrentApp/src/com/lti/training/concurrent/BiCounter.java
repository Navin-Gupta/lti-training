package com.lti.training.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounter {

	private int i = 0;
	private int j = 0;
	
	Lock lockI = new ReentrantLock();
	Lock lockJ = new ReentrantLock();
	
	// T1
	public void incrementI() {
		lockI.lock();
			i++;
			//----
			//----
		lockI.unlock();
		//----
		//----
	}
	
	public int getI() {
		return i;
	}
	
	// T2
	public void incrementJ() {
		lockJ.lock();
		j++;
		lockJ.unlock();
	}
	
	public int getJ() {
		return j;
	}

	
	
	/*
	// T1
	synchronized public void incrementI() {
		i++;
	}
	
	synchronized public int getI() {
		return i;
	}
	
	// T2
	synchronized public void incrementJ() {
		j++;
	}
	
	synchronized public int getJ() {
		return j;
	}*/
	
}
