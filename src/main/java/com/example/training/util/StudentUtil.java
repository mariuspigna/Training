package com.example.training.util;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentUtil {

	private  final StudentRepository studentRepository;

	public StudentUtil(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public Student checkStudent(Long studentId){
		return  studentRepository.findById(studentId).
				orElseThrow(()-> new IllegalStateException("the student with id %s does not exist".formatted(studentId)));
	}
}
