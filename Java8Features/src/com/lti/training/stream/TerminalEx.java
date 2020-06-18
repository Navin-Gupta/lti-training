package com.lti.training.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lti.training.repository.Student;
import com.lti.training.repository.StudentRepository;

public class TerminalEx {

	// group by gender
	public static void groupingByGender() {
		Map<String, List<Student>> studentMap =  StudentRepository.getStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGender));
		
		System.out.println(studentMap);
	}
	
	// group by gpa values
	public static void customGroupingByGpa() {
		Map<String, List<Student>> studentMap =  StudentRepository.getStudents()
		.stream()
		.collect(Collectors.groupingBy(student->student.getGpa() >= 3.5 ? "OUTSTANDING" : "AVERAGE" ));
		
		System.out.println(studentMap);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// groupingByGender();
		customGroupingByGpa();
	}

}
