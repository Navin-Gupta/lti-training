package com.lti.training.styleapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyApp {

	public static void main(String args[]) {
		// Remove duplicates from list of integers
		List<Integer> numList = 
				Arrays.asList(1,2,3,4,4,4,5,5,6,7,7,7,8,8,8,9);
		
		// Imperative
		List<Integer> uniqueList = new ArrayList<Integer>();
		for(Integer num : numList) {
			if(!uniqueList.contains(num))
				uniqueList.add(num);
		}
		
		System.out.println("Unique Values : " + uniqueList);
		
		// Declarative
		List<Integer> uniqueListPro =
				numList.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique Values : " + uniqueListPro);
	}
}
