package com.example.training.dto;

import com.example.training.model.Furniture;

import java.time.LocalDate;
import java.util.List;


public record StudentDTO(Long id,
						 String lastName,
						 String firstName,
						 LocalDate dob,
						 String email,
						 Integer age) {

}
