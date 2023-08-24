package com.example.training.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(
		name = "unique_email",
		columnNames = "email"
))
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			generator = "student_sequence",
			strategy = GenerationType.SEQUENCE
	)
	@Column(nullable = false)
	private Long id;
	@NonNull
	@Column(columnDefinition = "TEXT")
	private String lastName;
	@NonNull
	@Column(columnDefinition = "TEXT")
	private String firstName;
	@NonNull
	@Column(columnDefinition = "date")
	private LocalDate dob;
	@NonNull
	@Column(columnDefinition = "TEXT")
	private String email;
	@Transient
	private Integer age;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "sf_fk", referencedColumnName = "id")
	private List<Furniture> furnitureList;
	public Integer getAge() {
		return Period.between(this.dob,LocalDate.now()).getYears();
	}
}
