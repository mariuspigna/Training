package com.example.training.controller;

import com.example.training.service.StudentServiceUodate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "api/v1/training/student")
public class StudentControllerUpdate {
	private final StudentServiceUodate studentServiceUodate;

	public StudentControllerUpdate(StudentServiceUodate studentServiceUodate) {
		this.studentServiceUodate = studentServiceUodate;
	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable Long studentId,
							  @RequestParam(required = false) String firstName,
							  @RequestParam(required = false) String lastName,
							  @RequestParam(required = false) String emailName,
							  @RequestParam(required = false) LocalDate dob) {
		studentServiceUodate.updateStudent(studentId, firstName, lastName, emailName, dob);
	}
}
