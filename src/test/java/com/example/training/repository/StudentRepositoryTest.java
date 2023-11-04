package com.example.training.repository;

import com.example.training.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	String email = "tatalia@gmail.com";
	//given
	Student student = new Student(
			"Tatalia",
			"Joe",
			email,
			"12345",
			LocalDate.now());
	@AfterEach
	void tearDown(){
		studentRepository.deleteAll();
	}
	@Test
	void selectExistsEmail() {
		studentRepository.save(student);
		// When
		boolean exists = studentRepository.selectExistsEmail(email);
		// Then
		Assertions.assertThat(exists).isTrue();
	}
	@Test
	void findByEmail(){
		studentRepository.save(student);
		Assertions.assertThat(studentRepository.findByEmail(email)).isNotEmpty();
	}
}