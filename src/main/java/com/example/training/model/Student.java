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
@Entity(name = "student")
@Table(uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
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
	@Column(updatable = false)
	@NonNull
	private Long id;
	@Column(columnDefinition = "TEXT")
	@NonNull
	private String lastName;
	@Column(columnDefinition = "TEXT")
	@NonNull
	private String firstName;
	@Column(columnDefinition = "TEXT")
	@NonNull
	private String email;
	@Column(columnDefinition = "TEXT")
	@NonNull
	private LocalDate dob;
	@Column(columnDefinition = "bigint")
	@Transient
	private Integer age;
	@OneToMany(targetEntity = Fourniture.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", name = "sf_fk")
	private List<Fourniture> fournitureList;

	public Integer getAge() {
		return Period.between(this.dob,LocalDate.now()).getYears();
	}
}
