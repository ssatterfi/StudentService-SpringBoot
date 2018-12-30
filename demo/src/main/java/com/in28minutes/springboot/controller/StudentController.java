package com.in28minutes.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.service.StudentService;

@RestController
public class StudentController {

		@Autowired
		private StudentService studentservice;
		
		
		@GetMapping("/student/node")
		public String NodeIsOnline() {
			
			return "NodeOnline";
		}
		
		
		@GetMapping("/student")
		public List<Student> GetAllStudents() {
			
			return studentservice.retrieveAllStudents();
		}
		
		
		@GetMapping("/student/{studentId}/courses")
		public List<Course> retrieveCourses(@PathVariable String studentId) {
			
			return studentservice.retrieveCourses(studentId);
						
		}
		
		@GetMapping("/student/{studentId}/courses/{courseId}")
		public Course retrieveDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId) {
			
			return studentservice.retrieveCourse(studentId,courseId);			
			
		}
		
}
