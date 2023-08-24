package com.example.training.controller;

import com.example.training.service.StudentServiceUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/training/student")
public class StudentControllerUpdate {
	private final StudentServiceUpdate studentServiceUpdate;

	public StudentControllerUpdate(StudentServiceUpdate studentServiceUpdate) {
		this.studentServiceUpdate = studentServiceUpdate;
	}
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable Long studentId,
							  @RequestParam(required = false) String firstName,
							  @RequestParam(required = false) String lastName,
							  @RequestParam(required = false) String email){
		studentServiceUpdate.updateStudent(studentId,firstName,lastName,email);

	}
}
