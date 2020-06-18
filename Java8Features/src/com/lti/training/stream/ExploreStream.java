package com.lti.training.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.lti.training.repository.Student;
import com.lti.training.repository.StudentRepository;

public class ExploreStream {

	static Predicate<Student> gradePredicate = student -> student.getGrade() >2 ; //&& student.getGpa() > 3.5;
	static Predicate<Student> gpaPredicate = student -> student.getGpa() > 3.5;
	
	public static void main(String args[]) {
		// blocking stream
		/*List<Student> filteredStudent = StudentRepository.getStudents()
			.stream().peek(student->System.out.println("Initiated : " + student)) // conveyer belt
			// .filter(gradePredicate).peek(student->System.out.println("IstFilter : " + student))  // only those records which satisfies condition
			.filter(student -> student.getGrade() >2).peek(student->System.out.println("IstFilter : " + student))  // only those records which satisfies condition
			
			.filter(gpaPredicate).peek(student->System.out.println("IIndFilter : " + student)) 
			.collect(Collectors.toList());// terminal*/
		
		// System.out.println(filteredStudent);
		
		Map<String, List<String>>  studentMap= StudentRepository.getStudents()
				.stream().peek(student->System.out.println("Initiated : " + student)) // conveyer belt
				// .filter(gradePredicate).peek(student->System.out.println("IstFilter : " + student))  // only those records which satisfies condition
				.filter(student -> student.getGrade() >2).peek(student->System.out.println("IstFilter : " + student))  // only those records which satisfies condition
				
				.filter(gpaPredicate).peek(student->System.out.println("IIndFilter : " + student)) 
				.collect(Collectors.toMap(Student::getName, Student::getActivities));// terminal
		
		System.out.println(studentMap);	
		
		
		StudentRepository.getStudents()
		.stream().peek(student->System.out.println("Initiated : " + student)) // conveyer belt
		
		.filter(gradePredicate).peek(student->System.out.println("IstFilter : " + student))  // only those records which satisfies condition
		.filter(gpaPredicate).peek(student->System.out.println("IIndFilter : " + student)); 
		// terminal activity
	}
}
