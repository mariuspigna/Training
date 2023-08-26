package com.example.training.service;

import com.example.training.dto.StudentDTO;
import com.example.training.dto.StudentDTOMapper;
import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import com.example.training.util.StudentUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record StudentService(StudentUtil studentUtil, StudentRepository studentRepository, StudentDTOMapper studentDTOMapper) {

	public void createStudent(Student student){
		studentRepository.save(student);
	}

	public StudentDTO getStudentById(Long studentId) {
		return studentRepository.findById(studentId).map(studentDTOMapper)
				.orElseThrow(() -> new IllegalStateException("Student with id %s doesn't exist".formatted(studentId)));
	}

	public List<StudentDTO> getStudentAllStudents() {
		return studentRepository.findAll().stream().map(studentDTOMapper).collect(Collectors.toList());
	}

	public void delStudentAllStudents() {
		studentRepository.deleteAll();
	}

	public void delStudentById(Long studentId) {
		studentRepository.deleteById(studentUtil.checkStudent(studentId).getId());
	}

}
