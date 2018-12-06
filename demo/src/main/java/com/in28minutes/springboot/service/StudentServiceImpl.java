package com.in28minutes.springboot.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;

@Component
public class StudentServiceImpl implements StudentService {

	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Course> retrieveCourses(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course retrieveCourse(String studentId, String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
