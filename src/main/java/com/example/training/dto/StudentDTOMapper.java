package com.example.training.dto;

import com.example.training.model.Fourniture;
import com.example.training.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public record StudentDTOMapper() implements Function<Student, StudentDTO> {
	@Override
	public StudentDTO apply(Student student) {
		return new StudentDTO(
				student.getId(),
				student.getFirstName(),
				student.getLastName(),
				student.getAge(),
				new ArrayList<>(student.getFournitureList()));
	}
}
