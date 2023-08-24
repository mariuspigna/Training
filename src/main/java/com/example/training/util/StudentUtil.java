package com.example.training.util;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentUtil {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentUtil(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public Student checkStudentById(Long studentId){
		Student student = studentRepository.findById(studentId)
				.orElseThrow(()-> new IllegalStateException("The student with id " + studentId + " doesn't exist"));
		return  student;
	}
}
