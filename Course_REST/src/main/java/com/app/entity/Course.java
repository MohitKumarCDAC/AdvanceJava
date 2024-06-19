package com.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="course_name",length = 30)
	private String courseName;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate EndDate;
	private double fee;
	
	@UpdateTimestamp
	@Column(name="update_date_time")
	private LocalDateTime UpdateDAteTime;
	public LocalDateTime getUpdateDAteTime() {
		return UpdateDAteTime;
	}
	public void setUpdateDAteTime(LocalDateTime updateDAteTime) {
		UpdateDAteTime = updateDAteTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return EndDate;
	}
	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
	public Course(String courseName, Category category, LocalDate startDate, LocalDate endDate, double fee
			) {
		super();
		this.courseName = courseName;
		this.category = category;
		this.startDate = startDate;
		EndDate = endDate;
		this.fee = fee;
		this.UpdateDAteTime=LocalDateTime.now();
		
	}
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", CourseName=" + courseName + ", category=" + category + ", startDate=" + startDate
				+ ", EndDate=" + EndDate + ", fee=" + fee + ", UpdateDAteTime=" + UpdateDAteTime + "]";
	}
	
	
	
	
	
	
}
