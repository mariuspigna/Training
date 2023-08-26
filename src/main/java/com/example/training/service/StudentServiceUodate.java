package com.example.training.service;

import com.example.training.util.StudentUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class StudentServiceUodate {
	private final StudentUtil studentUtil;

	public StudentServiceUodate(StudentUtil studentUtil) {
		this.studentUtil = studentUtil;
	}

	@Transactional
	public void updateStudent(Long studentId, String firstName, String lastName, String email, LocalDate dob) {

		if (firstName != null && firstName.length()>0 && !Objects.equals(firstName, studentUtil.checkStudent(studentId).getFirstName())){
			studentUtil.checkStudent(studentId).setFirstName(firstName);
		}
		if (lastName != null && lastName.length()>0 && !Objects.equals(lastName, studentUtil.checkStudent(studentId).getLastName())){
			studentUtil.checkStudent(studentId).setLastName(lastName);
		}
		if (email != null && email.length()>0 && !Objects.equals(email, studentUtil.checkStudent(studentId).getEmail())){
			studentUtil.checkStudent(studentId).setEmail(email);
		}
		if (dob != null && !Objects.equals(dob, studentUtil.checkStudent(studentId).getDob())){
			studentUtil.checkStudent(studentId).setDob(dob);
		}
	}
}
