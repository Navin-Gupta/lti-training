package com.lti.training.parallelstream;


import java.util.List;
import java.util.stream.Collectors;

import org.omg.CORBA.ACTIVITY_COMPLETED;

import com.lti.training.repository.Student;
import com.lti.training.repository.StudentRepository;

public class ParallelStreamActivity {

	public static List<String> seqStreamEx() {
		
		System.out.println("Sequential : " + Thread.currentThread().getName());
		
		long start = System.currentTimeMillis();
		
		List<String> activities = StudentRepository.getStudents()
		.stream().peek(student -> System.out.println("Stream : " + student)) // Stream<Student>
		// goes inside : student object / comes out : List of activities
		// .map(student -> student.getActivities())  // Stream<List<String>>
		.map(Student :: getActivities).peek(list-> System.out.println("Map : " + list))  // Stream<List<String>>
		.flatMap(list -> list.stream()).peek(activity->System.out.println("FlatMap : " + activity))
		//.flatMap(List :: stream) // Stream<String>
		.collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		
		long diff = end - start;
		System.out.println("Sequential Time : " + diff);
		
		return activities;
	}
	
	public static List<String> parallelStreamEx() {
		
		System.out.println("Parallel : " + Thread.currentThread().getName());
		
		long start = System.currentTimeMillis();
		
		List<String> activities = StudentRepository.getStudents()
		.parallelStream().peek(student -> System.out.println("Stream : " + student)) // Stream<Student>
		.map(Student :: getActivities).peek(list-> System.out.println("Map : " + list))  // Stream<List<String>>
		.flatMap(List :: stream).peek(activity->System.out.println("FlatMap : " + activity)) // Stream<String>
		.collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		
		long diff = end - start;
		System.out.println("Parallel Time : " + diff);
		
		return activities;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sequential List : " + seqStreamEx());
		System.out.println("Parallel List : " + parallelStreamEx());
	}

}
