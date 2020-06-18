package com.lti.training.parallelstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InherentComplexity {

	public static int sequentialSum(List<Integer> numbers) {
		long start = System.currentTimeMillis();
		int total = numbers.stream()
			.reduce(0, (x,y)-> x+y);
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Sequential : " + diff);
		
		return total;
		
	}
	
	public static int parallelSum(List<Integer> numbers) {
		long start = System.currentTimeMillis();
		int total = numbers.parallelStream() // Stream<Integer>
			.reduce(0, (x,y)-> x+y);  // unboxing : Integer -> int
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Parallel : " + diff);
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = IntStream.rangeClosed(1, 1000)//Stream<primitive int>
								.boxed() //Stream<Integer>
								.collect(Collectors.toList());
		System.out.println("Sequential Sum : " + sequentialSum(numbers));
		System.out.println("Parallel Sum : " + parallelSum(numbers));
	}

}
