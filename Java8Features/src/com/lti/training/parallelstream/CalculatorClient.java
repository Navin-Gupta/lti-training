package com.lti.training.parallelstream;

import java.util.stream.IntStream;

public class CalculatorClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// external mutable object
		Calculator calculator = new Calculator();
		
		// Seq : Stream of thousand numbers :
		/*IntStream.rangeClosed(1, 1000)
			.forEach(value -> calculator.performSum(value));
		System.out.println("Sequential Sum : " + calculator.getResult());*/
		
		// Seq : Stream of thousand numbers :
		IntStream.rangeClosed(1, 1000).parallel()
			.forEach(value -> calculator.performSum(value));
		System.out.println("Parallel Sum : " + calculator.getResult());
	}

}
