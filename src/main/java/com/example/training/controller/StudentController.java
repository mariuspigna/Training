package com.example.training.controller;

import com.example.training.model.Student;
import com.example.training.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/training/student")
public record StudentController(StudentService studentService) {

	@PostMapping
	public void createStudent(@RequestBody Student student){
		studentService.createStudent(student);
	}
	@GetMapping(path = "{studentId}")
	public Optional<Student> getStudentById(@PathVariable Long studentId){
		return studentService.getStudentById(studentId);
	}
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	@DeleteMapping(path = "{studentId}")
	public void deleteStudentById(@PathVariable Long studentId){
		studentService.deleteStudentById(studentId);
	}
	@DeleteMapping
	public void deleteAllStudents(){
		studentService.deleteAllSTudents();
	}
}
