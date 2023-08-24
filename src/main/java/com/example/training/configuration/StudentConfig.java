package com.example.training.configuration;

import com.example.training.model.SchoolSupplies;
import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){

		return args -> {
			studentRepository.saveAll(List.of(
				new Student("marius",
						"PIGNA",
						"mariuspigna@gmail.com",
						LocalDate.of(1981, Month.NOVEMBER, 24),
						new ArrayList<>()
				),
				new Student("carole",
						"PIGNA",
						"carolepigna@gmail.com",
						LocalDate.of(1992, Month.FEBRUARY,19),
						new ArrayList<>()
				)
			));
		};
	}
}
