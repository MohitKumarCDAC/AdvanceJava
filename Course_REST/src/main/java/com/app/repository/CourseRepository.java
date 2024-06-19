package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	// List<Course> findByNameContainingIgnoreCase(String name);
	List<Course> findByCourseName(String courseName);
	 @Query("SELECT c FROM Course c WHERE YEAR(c.startDate) = :year AND MONTH(c.startDate) = :month")
	    List<Course> findByStartDateYearMonth(@Param("year") int year, @Param("month") int month);
}
