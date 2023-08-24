package com.example.training.controller;

import com.example.training.model.Student;
import com.example.training.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/training/student")
public record StudentController(StudentService studentService) {
	@PostMapping
	public void createNewStudent(@RequestBody Student student){
		studentService.createNewStudent(student);
	}
	@GetMapping(path = "{studentId}")
	public Student readStudentById(@PathVariable Long studentId){
		return studentService.readStudentById(studentId);
	}
	@GetMapping
	public List<Student> readAllStudent(){
		return studentService.readAllStudent();
	}
	@DeleteMapping(path = "{studentId}")
	public void deleteStudentById(@PathVariable Long studentId){
		studentService.deleteStudentById(studentId);
	}
	@DeleteMapping
	public void deleteAllStudent(){
		studentService.deleteAllStudent();
	}
}
