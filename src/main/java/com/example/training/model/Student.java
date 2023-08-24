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
@Table(uniqueConstraints = @UniqueConstraint(
		name = "email_unique", columnNames = "email"
))
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	@Column(updatable = false)
	private Long id;
	@NonNull
	@Column(columnDefinition = "TEXT", updatable = true)
	private String firstName;
	@NonNull
	@Column(columnDefinition = "TEXT", updatable = true)
	private String lastName;
	@NonNull
	@Column(columnDefinition = "TEXT", updatable = true)
	private String email;
	@NonNull
	@Column(columnDefinition = "date")
	private LocalDate dob;
	@Transient
	private Integer age;
	@NonNull
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "ss_fk", referencedColumnName = "id", nullable = false)
	private List<SchoolSupplies> schoolSupplies;

	public Integer getAge() {
		return Period.between(this.dob,LocalDate.now()).getYears();
	}
}
