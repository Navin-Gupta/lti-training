package com.lti.training.functionalprogs;

import java.util.List;
import java.util.function.Consumer;

import com.lti.training.repository.Student;
import com.lti.training.repository.StudentRepository;

public class ConsumerEx {

	// Consumer that consumes a student object and display name
	static Consumer<Student> nameDisplayLambda = 
			student ->System.out.println(student.getName());
			
	// Consumer that consumes a student object and display name
	static Consumer<Student> activityDisplayLambda = 
			student ->System.out.println(student.getActivities());		
	
			
	// need to display only names of all students
	public static void printNames() {
		StudentRepository.getStudents().forEach(nameDisplayLambda);
	}
	
	// need to display names and activities of all students
	// chaining of lambda
	public static void printNamesAndActivities() {
		StudentRepository.getStudents().forEach(nameDisplayLambda.andThen(activityDisplayLambda));
	}
	
	// need to display names and activities of all students with grade > 2
	// chaining of lambda
	public static void printNamesAndActivitiesUsingCondition() {
		List<Student> students = StudentRepository.getStudents();
		students.forEach(student->{
			if(student.getGrade() > 2) {
				// nameDisplayLambda.accept(student);
				// activityDisplayLambda.accept(student);
				nameDisplayLambda.andThen(activityDisplayLambda).accept(student);
			}
		});
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<String> toUpper = 
				str -> System.out.println(str.toUpperCase());
		
		toUpper.accept("Hello");
		// System.out.println(toUpper);
		
		
		// printNames();
		// printNamesAndActivities();
		
		printNamesAndActivitiesUsingCondition();
		
	}

}
