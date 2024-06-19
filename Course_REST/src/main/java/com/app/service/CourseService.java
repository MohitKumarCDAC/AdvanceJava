package com.app.service;

import java.util.List;

import com.app.DTO.CourseDTO;
import com.app.entity.Course;

public interface CourseService {
   
	CourseDTO addnewCourse(CourseDTO coursedto);  
	String updateCourse(Long id,CourseDTO course);
	List<Course> findCoursesByCourseName(String courseName);
	List<CourseDTO> findAllcourse();
	List<Course> findCoursesByMonth(int year, int month);
}
