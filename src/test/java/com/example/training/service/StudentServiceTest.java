package com.example.training.service;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

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
	String email = "tatalia@gmail.com";

	@Test
	void addStudent() {
		Student student1 = new Student(
				"Tatalia",
				"Joe",
				email,
				"12345",
				LocalDate.now());
		studentService.createNewStudent(student1);

		ArgumentCaptor<Student> studentArgumentCaptor =
				ArgumentCaptor.forClass(Student.class);
		Mockito.verify(studentRepository).save(studentArgumentCaptor.capture());
		Student capturedStudent = studentArgumentCaptor.getValue();
		Assertions.assertThat(capturedStudent).isEqualTo(student1);
	}

	@Test
	void addStudentCheck() {
		Student student2 = new Student(
				"Tatalia22",
				"Joe",
				email,
				"1234555",
				LocalDate.now());

		BDDMockito.given(studentRepository.selectExistsEmail(ArgumentMatchers.anyString())).willReturn(true);
		Assertions.assertThatThrownBy(()->studentService.createNewStudent(student2))
				.isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("Email %s is not uniq".formatted(student2.getEmail()));

		Mockito.verify(studentRepository, Mockito.never()).save(ArgumentMatchers.any());
	}
}