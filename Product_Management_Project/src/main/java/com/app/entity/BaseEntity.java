package com.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
	
	@CreationTimestamp
	@Column(name="creation_date")
 private LocalDate creationDate;
	
	@UpdateTimestamp
	@Column(name="updation_date")
 private LocalDateTime updationDate;
	
public BaseEntity(Long id, LocalDate creationDate, LocalDateTime updationDate) {
	super();
	this.id = id;
	this.creationDate = creationDate;
	this.updationDate = updationDate;
}
public BaseEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LocalDate getCreationDate() {
	return creationDate;
}
public void setCreationDate(LocalDate creationDate) {
	this.creationDate = creationDate;
}
public LocalDateTime getUpdationDate() {
	return updationDate;
}
public void setUpdationDate(LocalDateTime updationDate) {
	this.updationDate = updationDate;
}
@Override
public String toString() {
	return "BaseEntity [id=" + id + ", creationDate=" + creationDate + ", updationDate=" + updationDate + "]";
}
 
 
}
