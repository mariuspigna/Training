package com.example.training.dto;

import com.example.training.model.Fourniture;

import java.util.List;

public record StudentDTO(Long id,String firstName, String lastName, Integer age, List<Fourniture> fournitureList) {
}
