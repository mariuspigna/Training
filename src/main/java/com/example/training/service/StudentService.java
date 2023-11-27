package com.example.training.service;

import com.example.training.util.StudentUtil;
import com.example.training.dto.StudentDTO;
import com.example.training.dto.StudentDTOMapper;
import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentService {
	private  final StudentRepository studentRepository;
	private  final StudentUtil studentUtil;
	private  final StudentDTOMapper studentDTOMapper;



	public List<StudentDTO> getAllStudentsDTO() {
		return studentRepository.findAll().stream().map(studentDTOMapper).collect(Collectors.toList());
	}
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public StudentDTO getStudentById(Long studentId) {
		return studentRepository.findById(studentId).map(studentDTOMapper)
				.orElseThrow(() -> new IllegalStateException("Student with id %s doesn't exist".formatted(studentId)));
	}

	public void delAllStudents() {
		studentRepository.deleteAll();
	}

	public void delStudentById(Long studentId) {
		Student student = studentUtil.checkStudentExist(studentId);
		studentRepository.deleteById(student.getId());
	}

	@Transactional
	public void updateStudent(Long studentId, String firstname, String lastname, String email, String password) {
		Student student = studentUtil.checkStudentExist(studentId);
		if (firstname != null && firstname.length() > 0 && !Objects.equals(firstname, student.getFirstname())) {
			student.setFirstname(firstname);
		}
		if (lastname != null && lastname.length() > 0 && !Objects.equals(lastname, student.getLastname())) {
			student.setLastname(lastname);
		}
		if (email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())) {
			student.setEmail(email);
		}
		if (password != null && password.length() > 0 && !Objects.equals(password, student.getPassword())) {
			student.setPassword(password);
		}
	}
}
