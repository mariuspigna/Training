package com.example.training.service;

import com.example.training.dto.StudentDTO;
import com.example.training.dto.StudentDTOMapper;
import com.example.training.model.Student;
import com.example.training.repository.FurnitureRepository;
import com.example.training.repository.StudentRepository;
import com.example.training.util.StudentUtil;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record StudentService(StudentRepository studentRepository,
							 FurnitureRepository furnitureRepository,
							 StudentUtil studentUtil,
							 StudentDTOMapper studentDTOMapper) {
	public void createNewStudent(Student student) {
		studentRepository.save(student);
	}

	public StudentDTO readStudentById(Long studentId) {
		return studentRepository.findById(studentId).map(studentDTOMapper).orElseThrow(()->
				new IllegalStateException("Student with id  [%s] not found".formatted(studentId)));
	}

	public List<StudentDTO> readAllStudent() {
		return studentRepository.findAll()
				.stream()
				.map(studentDTOMapper).collect(Collectors.toList());
	}

	public void deleteStudentById(Long studentId) {
		Student student = studentUtil.checkStudentById(studentId);
		studentRepository.deleteById(student.getId());
	}

	public void deleteAllStudent() {
		studentRepository.deleteAll();
	}
}
