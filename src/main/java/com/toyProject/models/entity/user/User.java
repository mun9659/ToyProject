package com.toyProject.models.entity.user;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
// @DynamicInsert - Insert 시에 Null 값인 필드 제외
public class User {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=30, unique=true)
	private String username;
	
	@Column(nullable=false, length=100)
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDt;
	
	@LastModifiedDate
	@Column(insertable=false)
	private LocalDateTime modDt;
}
