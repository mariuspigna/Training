package com.example.training.service;

import com.example.training.model.Student;
import com.example.training.repository.FurnitureRepository;
import com.example.training.repository.StudentRepository;
import com.example.training.util.StudentUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record StudentService(StudentRepository studentRepository, FurnitureRepository furnitureRepository, StudentUtil studentUtil) {
	public void createNewStudent(Student student) {
		studentRepository.save(student);
	}

	public Student readStudentById(Long studentId) {
		Student student = studentUtil.checkStudentById(studentId);
		return student;
	}

	public List<Student> readAllStudent() {
		return studentRepository.findAll();
	}

	public void deleteStudentById(Long studentId) {
		Student student = studentUtil.checkStudentById(studentId);
		studentRepository.deleteById(student.getId());
	}

	public void deleteAllStudent() {
		studentRepository.deleteAll();
	}
}
