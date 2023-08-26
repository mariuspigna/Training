package com.example.training.controller;

import com.example.training.dto.StudentDTO;
import com.example.training.model.Student;
import com.example.training.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/training/student")
public record StudentController(StudentService studentService) {
	@PostMapping
	public void createStudent(@RequestBody Student student){
		studentService.createStudent(student);
	}
	@GetMapping(path = "{studentId}")
	public StudentDTO getStudentById(@PathVariable Long studentId){
		return studentService.getStudentById(studentId);
	}
	@GetMapping
	public List<StudentDTO> getStudentAllStudents(){
		return studentService.getStudentAllStudents();
	}
	@DeleteMapping
	public void delStudentAllStudents(){
		studentService.delStudentAllStudents();
	}
	@DeleteMapping(path = "{studentId}")
	public void delStudentById(@PathVariable Long studentId){

		 studentService.delStudentById(studentId);
	}

}
