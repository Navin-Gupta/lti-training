package com.lti.training.microuser.dummy;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.lti.training.microuser.controller.dao.DummyRepository;
import com.lti.training.microuser.service.DummyService;

// Mockito engine to run these test cases
@RunWith(MockitoJUnitRunner.class)
public class DummyMockTest {

	// instance of original service (create a real object)
	// inject the mock
	@InjectMocks
	DummyService service;
	
	// dependency on repository (any other resource)
	// create a mock object
	@Mock
	DummyRepository repository;
	
	@Test
	public void testCalculateSumFromDataService() {
		// setup is done
		// mock the implementation
		when(repository.getNumberList()).thenReturn(new int[] {1, 2, 3});
		
		int actual = this.service.calculateSumFromDataService();
		int expected = 6;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSumFromDataServiceEmpty() {
		// setup is done
		// mock the implementation
		when(repository.getNumberList()).thenReturn(new int[] {});
		
		int actual = this.service.calculateSumFromDataService();
		int expected = 0;
		assertEquals(expected, actual);
	}
}














