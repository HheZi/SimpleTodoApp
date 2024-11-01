package com.app.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Todo {

	@Id
	private Integer id;
	
	private String value;
	
//	@Column(name = "data_to_complete")
//	private Instant dateToComplete;
	
//	private Status status;
	
	@CreatedDate
	@Column(name = "created_at")
	private Instant createdAt;
	
	@LastModifiedDate
	@Column(name = "update_at")
	private Instant updateAt;
}
