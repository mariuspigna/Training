package com.example.training.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity(name = "SchoolSupplies")
@Table
public class SchoolSupplies {
	@Id
	@SequenceGenerator(
			name = "supplies_sequence",
			sequenceName = "supplies_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "supplies_sequence"
	)
	@Column(updatable = false)
	private Long id;
	@NonNull
	@Column(columnDefinition = "TEXT")
	private String furnitureName;
	@NonNull
	@Column(columnDefinition = "TEXT")
	private Integer quantity;
	@NonNull
	@Column(columnDefinition = "bigint")
	private Integer price;

	/*@NonNull
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;*/

}

