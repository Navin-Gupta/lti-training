package com.lti.training.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionVsStream {

	public static void main(String args[]) {
		List<String> names = new ArrayList<String>();
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Fourth");
		names.add("Fifth");
		
		// collection : mutable
			
		// non-stream iteration
		names.forEach(System.out::println);
		System.out.println("\n\n");
		
		names.forEach(System.out::println);
		System.out.println("\n\n");
		
		
		
		/*for(String name : names) {
			System.out.println(name);
		}*/
		
		System.out.println("\n\n");
		// streamed approach
		
		// Streams : immutable : Thread-safe
		// Streams : non-reusable
		
		Stream<String> namesStream = names.stream();
		namesStream.forEach(System.out::println);
		System.out.println("\n\n");
		namesStream.forEach(System.out::println);
		
		
		
	}
}
