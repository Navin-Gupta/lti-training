package com.lti.training.microuser.service;

import com.lti.training.microuser.controller.dao.DummyRepository;

public class DummyService {
	
	// Dependency over repository
	private DummyRepository repository;
	
	public void setDummyRepository(DummyRepository repository) {
		this.repository = repository;
	}
	
	// business logic
	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value : data) {
			sum += value;
		}
		return sum;
	}
	
	// business logic
	public int calculateSumFromDataService() {
		// dependent on data service : mock dependency
		int[] data = this.repository.getNumberList();
		int sum = 0;
		for(int value : data) {
			sum += value;
		}
		return sum;
	}
}


















