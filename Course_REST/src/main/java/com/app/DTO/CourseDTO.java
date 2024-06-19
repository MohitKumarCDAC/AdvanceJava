package com.app.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.UpdateTimestamp;

import com.app.entity.Category;

public class CourseDTO {
	private Long id;
	
	
	private String courseName;
	@NotBlank(message = "couse Category can not Blank")
	private Category category;
	
	private LocalDate startDate;
	
	private LocalDate EndDate;
	@NotBlank(message = "couse fee can not Blank")
	private double fee;
	
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
	

}
