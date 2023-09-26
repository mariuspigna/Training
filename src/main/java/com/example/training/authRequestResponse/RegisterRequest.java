package com.example.training.authRequestResponse;

import com.example.training.model.Fourniture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterRequest {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private LocalDate dob;
	private List<Fourniture> fournitureList;
}
