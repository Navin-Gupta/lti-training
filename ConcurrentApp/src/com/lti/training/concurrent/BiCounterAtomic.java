package com.lti.training.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class BiCounterAtomic {
	private AtomicInteger i = new AtomicInteger();
	
	public void incrementI() {
		i.incrementAndGet();
	}
	
	public int getI() {
		return i.get();
	}
}
