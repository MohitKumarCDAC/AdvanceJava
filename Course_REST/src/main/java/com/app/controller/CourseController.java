package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CourseDTO;
import com.app.entity.Course;
import com.app.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/course")
public class CourseController {
  
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	@Operation(description = "Add Course...")
	public ResponseEntity<?> addCourse(@RequestBody CourseDTO coursedto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(courseService.addnewCourse(coursedto));
	}
//	 @GetMapping
//	    public List<Course> getCoursesByName(@RequestParam String name) {
//	        return courseService.findCoursesByName(name);
//	    }
//	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable Long id,@RequestBody CourseDTO coursedto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(id, coursedto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCourse()
	{
		return ResponseEntity.status(HttpStatus.OK).body(courseService.findAllcourse());
	}
	
	 @GetMapping("/by-month")
	    public List<Course> getCoursesByMonth(@RequestParam int year, @RequestParam int month) {
	        return courseService.findCoursesByMonth(year, month);
	    }
	 @GetMapping("/by-course-name")
	    public List<Course> getCoursesByCourseName(@RequestParam String courseName) {
	        return courseService.findCoursesByCourseName(courseName);
	    }
}
