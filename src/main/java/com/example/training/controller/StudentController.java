package com.example.training.controller;

import com.example.training.dto.StudentDTO;
import com.example.training.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/training/student")
public class StudentController{
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping(path = "{studentId}")
	public StudentDTO getStudentById(@PathVariable Long studentId){
		return studentService.getStudentById(studentId);
	}
	@GetMapping(path = "hello")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("hello world from secured endpoint");
	}
	@GetMapping
	public List<StudentDTO> getAllStudents(){
		return studentService.getAllStudentsDTO();
	}
	@DeleteMapping
	public void delAllStudents(){
		studentService.delAllStudents();
	}
	@DeleteMapping(path = "{studentId}")
	public void delStudentById(@PathVariable Long studentId){

		studentService.delStudentById(studentId);
	}
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable Long studentId,
							  @RequestParam(required = false) String firstname,
							  @RequestParam(required = false) String lastname,
							  @RequestParam(required = false) String email,
							  @RequestParam(required = false) String password) {
		studentService.updateStudent(studentId,firstname,lastname,email, password);

		}
}
