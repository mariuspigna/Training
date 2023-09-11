package com.example.training.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/training/demo-controller")
public class StudentController {

	@GetMapping
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("hello world from secured endpoint");
	}
}
