package com.example.training.repository;

import com.example.training.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
