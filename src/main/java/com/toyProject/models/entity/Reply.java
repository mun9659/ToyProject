package com.toyProject.models.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reply {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=200)
	private String content;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDt;
	
	@LastModifiedDate
	@Column(insertable=false)
	private LocalDateTime modDt;
}
