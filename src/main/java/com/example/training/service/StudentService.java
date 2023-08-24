package com.example.training.service;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import com.example.training.repository.SchoolSuppliesRepository;
import com.example.training.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record StudentService(StudentRepository studentRepository, SchoolSuppliesRepository schoolSuppliesRepository, Util util) {
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	public Optional<Student> getStudentById(Long studentId){
		util.checkStudentExist(studentId);
		return studentRepository.findById(studentId);
	}
	public void deleteStudentById(Long studentId) {
		util.checkStudentExist(studentId);
		studentRepository.deleteById(studentId);
	}

	public void deleteAllSTudents() {
		studentRepository.deleteAll();
	}
	public void createStudent(Student student) {
		studentRepository.save(student);
	}
}
