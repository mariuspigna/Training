package com.example.training.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Furniture {
	@Id
	@SequenceGenerator(
			name = "furniture_sequence",
			sequenceName = "furniture_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "furniture_sequence"
	)
	@Column(updatable = false)
	private Long id;
	@NonNull
	@Column(columnDefinition = "TEXT")
	private String name;
	@NonNull
	@Column(columnDefinition = "bigint")
	private Integer quantity;
	@NonNull
	@Column(columnDefinition = "bigint")
	private Integer price;
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;
}
