package com.in28minutes.springboot.contoller;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.springboot.controller.StudentController;
import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value =  StudentController.class)
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean 
	private StudentService studentService;
	
	//Course mockCourse = new Course("Course1", "Spring" , "10 Step", null);
	Course mockCourse = new Course("Course1", "Spring", "10 Steps",
			Arrays.asList("Learn Maven", "Import Project", "First Example",
					"Second Example"));
	
	
	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {
		
		Mockito.when(studentService.retrieveCourse(Mockito.anyString(), Mockito.anyString())).thenReturn(mockCourse);
		RequestBuilder requestBuilder =  MockMvcRequestBuilders.get("/student/Student1/courses/Course1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		
		//String expected = "{id:Course1,name:Spring,description:10 steps}";
		
		//  {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(exampleCourseJson, result.getResponse() 
							.getContentAsString(),false);
	
		
	//	System.out.println();
	//	System.out.println();
	//	System.out.println(exampleCourseJson);
	//	System.out.println(result.getResponse().getContentAsString());
		
	}
	
}
