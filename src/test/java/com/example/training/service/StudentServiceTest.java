package com.example.training.service;

import com.example.training.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

	@Mock
	private StudentRepository studentRepository;
	private StudentService studentService;

	@BeforeEach
	void setUp(){
		studentService = new StudentService(studentRepository,null,null);

	}
	@Test
	void getAllStudents() {
		studentService.getAllStudents();
		Mockito.verify(studentRepository).findAll();
	}

	@Test
	@Disabled
	void delStudentById() {
	}
}