package com.lti.training.concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurentMapImpl {
	public static void main(String args[]) {
		ConcurrentHashMap<String, String> countryCapitals =
				new ConcurrentHashMap<String, String>();
		
		countryCapitals.put("India", "Delhi");
		countryCapitals.put("Japan", "Tokyo");
		// atomic operations
		// countryCapitals.computeIfAbsent(key, mappingFunction);
		
		
		Iterator<String> iterator = countryCapitals.keySet().iterator();
		
		///
	}
}
