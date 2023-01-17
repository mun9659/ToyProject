package com.toyProject.models.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.toyProject.models.entity.user.User;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@OneToMany(mappedBy="board", fetch=FetchType.EAGER)
	private List<Reply> reply;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDt;
	
	@LastModifiedDate
	@Column(insertable=false)
	private LocalDateTime modDt;
}
