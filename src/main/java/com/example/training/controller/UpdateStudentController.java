package com.example.training.controller;

import com.example.training.service.UpdateStudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/training/student")
public class UpdateStudentController {
	private final UpdateStudentService updateStudentService;

	public UpdateStudentController(UpdateStudentService updateStudentService) {
		this.updateStudentService = updateStudentService;
	}
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable Long studentId,
							  @RequestParam(required = false) String lastName,
							  @RequestParam(required = false) String firstName,
							  @RequestParam(required = false) String email){
		updateStudentService.updateStudent(studentId,lastName,firstName,email);

	}
}
