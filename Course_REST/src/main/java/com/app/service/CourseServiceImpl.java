package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.CourseDTO;
import com.app.entity.Course;
import com.app.repository.CourseRepository;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public CourseDTO addnewCourse(CourseDTO coursedto) {
		Course course=mapper.map(coursedto, Course.class);
		Course addcourse=courseRepository.save(course);
		return mapper.map(addcourse, CourseDTO.class);
	}

//	public List<Course> findCoursesByName(String name) {
//        return courseRepository.findByCourseName(name);
//    }
	
	@Override
	public String updateCourse(Long id, CourseDTO coursedto) {
		String msg="mismatched";
		if(courseRepository.existsById(id))
		{
			Course course=mapper.map(coursedto, Course.class);
			course.setId(id);
			courseRepository.save(course);
			msg="course updated...";
		}
		return msg;
		
	}

	@Override
	public List<CourseDTO> findAllcourse() {
		return courseRepository.findAll().stream().map(course->mapper.map(course, CourseDTO.class))
		.collect(Collectors.toList());
		
	}

	@Override
	public List<Course> findCoursesByMonth(int year, int month) {
        return courseRepository.findByStartDateYearMonth(year, month);
    }
	
	 public List<Course> findCoursesByCourseName(String courseName) {
	        return courseRepository.findByCourseName(courseName);
	    }

}
