package com.in28minutes.springboot.service;

import java.util.List;

import com.in28minutes.springboot.model.Course;

public interface StudentService {

	List<Course> retrieveCourses(String studentId);

	Course retrieveCourse(String studentId, String courseId);

}
