package com.lti.training.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		// numbers.stream()
		IntStream intStream =  IntStream.range(1, 50);
		System.out.println("Total : " + intStream.count());
		intStream =  IntStream.range(1, 50);
		System.out.println("Sum :" + intStream.sum());
	}

}
