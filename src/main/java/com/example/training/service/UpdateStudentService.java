package com.example.training.service;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import com.example.training.util.StudentUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UpdateStudentService {
	private final StudentRepository studentRepository;
	private final StudentUtil studentUtil;
	public UpdateStudentService(StudentRepository studentRepository, StudentUtil studentUtil) {
		this.studentRepository = studentRepository;
		this.studentUtil = studentUtil;
	}

	@Transactional
	public void updateStudent(Long studentId, String newLastName, String newFirstName, String newEmail) {
		Student student = studentUtil.checkStudentById(studentId);
		if(newLastName!=null && newLastName.length()>0 && !Objects.equals(newLastName,student.getLastName())){
			student.setLastName(newLastName);
		}
		if(newFirstName!=null && newFirstName.length()>0 && !Objects.equals(newFirstName,student.getFirstName())){
			student.setFirstName(newFirstName);
		}
		if(newEmail!=null && newEmail.length()>0 && !Objects.equals(newEmail,student.getEmail())){
			student.setEmail(newEmail);
		}
	}
}
