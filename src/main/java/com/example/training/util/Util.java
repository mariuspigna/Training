package com.example.training.util;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class Util {
	private final StudentRepository studentRepository;
	public Util(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student checkStudentExist(Long studentId) {
		 Student student = studentRepository.findById(studentId).orElseThrow(
				() -> new IllegalStateException("The student with id " + studentId + " does not exist"));
		return student;
	}
}
