package com.example.training.dto;

import com.example.training.dto.StudentDTO;
import com.example.training.model.Furniture;
import com.example.training.model.Student;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StudentDTOMapper implements Function<Student, StudentDTO> {

	@Override
	public StudentDTO apply(Student student) {
		return new StudentDTO(
				student.getId(),
				student.getLastName(),
				student.getFirstName(),
				student.getDob(),
				student.getEmail(),
				student.getAge(),
				student.getFurnitureList().stream().collect(Collectors.toList())
		);
	}
}
