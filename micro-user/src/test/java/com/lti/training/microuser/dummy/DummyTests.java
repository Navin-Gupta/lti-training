package com.lti.training.microuser.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import com.lti.training.microuser.service.DummyService;

public class DummyTests {

	// test cases : method
	// register the method as a test
	/*@Test
	public void fun() {
		// setup
		// test
		// check (assert) : passed:failed
	}*/
	
	
	@BeforeClass
	public void setUpClass() {
		// execute before any of the test cases is executed (once)
	}
	
	@Before
	public void setUp() {
		// to setup before each test case
	}
	
	
	// @After : execute after every test case
	
	// @AfterAll : once at the last
	
	@Test
	public void testCalculateSum() {
		// setup
		DummyService service = new DummyService();
		
		// test
		int actual = service.calculateSum(new int[] {1, 2, 3});
		
		// check (assert)
		assertEquals(6, actual);
	}
	
	@Test
	public void testCalculateSumEmpty() {
		// setup
		DummyService service = new DummyService();
		
		// test
		int actual = service.calculateSum(new int[] {});
		
		int expected = 0;
		// check (assert)
		assertEquals(expected, actual);
	}
	
}
















