package com.example.training.model;

import com.example.training.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
public class Student implements UserDetails {

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
	private Long id;
	@Column(columnDefinition = "TEXT")
	@NonNull
	private String firstname;
	@Column(columnDefinition = "TEXT")
	@NonNull
	private String lastname;
	@Column(columnDefinition = "TEXT")
	@NonNull
	private String email;
	@Column(columnDefinition = "TEXT", updatable = true)
	@NonNull
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
