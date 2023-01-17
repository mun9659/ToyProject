package com.toyProject.models.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=30)
	private String username;
	
	@Column(nullable=false, length=100)
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDt;
	
	@LastModifiedDate
	@Column(insertable=false)
	private LocalDateTime modDt;
}
