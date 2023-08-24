package com.example.training.service;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import com.example.training.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class StudentServiceUpdate {
	private final Util util;
	private final StudentRepository studentRepository;
	public StudentServiceUpdate(Util util, StudentRepository studentRepository){
		this.util = util;
		this.studentRepository = studentRepository;
	}
	@Transactional
	public void updateStudent(Long studentId, String newFirstName, String newLastName, String newEmail) {
		Student student = util.checkStudentExist(studentId);

		if(newFirstName!=null && newFirstName.length()>0 && !Objects.equals(newFirstName,student.getFirstName())){
			student.setFirstName(newFirstName);
		}
		if(newLastName!=null && newLastName.length()>0 && !Objects.equals(newLastName,student.getLastName())){
			student.setLastName(newLastName);
		}
		if(newEmail!=null && newEmail.length()>0 && !Objects.equals(newEmail,student.getEmail())){
			student.setEmail(newEmail);
		}
	}
}
