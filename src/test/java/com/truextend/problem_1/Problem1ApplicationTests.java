package com.truextend.problem_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.truextend.problem_1.entities.AssignmentCourseStudent;
import com.truextend.problem_1.entities.Course;
import com.truextend.problem_1.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class Problem1ApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void createCourseOk () throws Exception {
		Course testCourse = new Course(7,"Math","virtual course");
		mvc.perform(MockMvcRequestBuilders
				.post("/api/course")
				.content(objectMapper.writeValueAsString(testCourse))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void createCourseWithError () throws Exception {
		Course testCourse = new Course(1,"Math","virtual course");
		mvc.perform(MockMvcRequestBuilders
				.post("/api/course")
				.content(objectMapper.writeValueAsString(testCourse))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(409));
	}

	@Test
	public void updateCourseOk () throws Exception {
		Course testCourse = new Course(1,"Math","virtual course");
		mvc.perform(MockMvcRequestBuilders
				.put("/api/course/1")
				.content(objectMapper.writeValueAsString(testCourse))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void updateCourseWithError () throws Exception {
		Course testCourse = new Course(8,"Math","virtual course");
		mvc.perform(MockMvcRequestBuilders
				.put("/api/course/8")
				.content(objectMapper.writeValueAsString(testCourse))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void deleteCourseOk () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.delete("/api/course/1")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteCourseWithError () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.delete("/api/course/9")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void getCourseOk () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/course/3")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getCourseWithError () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/course/10")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void createStudentOk () throws Exception {
		Student testStudent = new Student(7,"Test","User");
		mvc.perform(MockMvcRequestBuilders
				.post("/api/student")
				.content(objectMapper.writeValueAsString(testStudent))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void createStudentWithError () throws Exception {
		Student testStudent = new Student(0,"Test","User");
		mvc.perform(MockMvcRequestBuilders
				.post("/api/student")
				.content(objectMapper.writeValueAsString(testStudent))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(409));
	}

	@Test
	public void UpdateStudentOk () throws Exception {
		Student testStudent = new Student(0,"Test","User");
		mvc.perform(MockMvcRequestBuilders
				.put("/api/student/0")
				.content(objectMapper.writeValueAsString(testStudent))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void UpdateStudentWithError () throws Exception {
		Student testStudent = new Student(10,"Test","User");
		mvc.perform(MockMvcRequestBuilders
				.put("/api/student/10")
				.content(objectMapper.writeValueAsString(testStudent))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void deleteStudentOk () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.delete("/api/student/2")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteStudentWithError () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.delete("/api/student/9")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void getStudentOk () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/student/0")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getStudentWithError () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/student/10")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void getStudentAssignmentOk() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/assignment/student/0")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getStudentAssignmentWithError() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/assignment/student/11")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void getCourseAssignmentOk() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/assignment/course/2")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getCourseAssignmentWithError() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/assignment/course/12")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void postAssignmentOk() throws Exception {
		AssignmentCourseStudent newAssignment = new AssignmentCourseStudent (2,new Student(7,"Test","User"),new Course(8,"Math","virtual course"));
		mvc.perform(MockMvcRequestBuilders
				.post("/api/assignment")
				.content(objectMapper.writeValueAsString(newAssignment))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void postAssignmentWithError() throws Exception {
		AssignmentCourseStudent newAssignment = new AssignmentCourseStudent (0,new Student(7,"Test","User"),new Course(8,"Math","virtual course"));
		mvc.perform(MockMvcRequestBuilders
				.post("/api/assignment")
				.content(objectMapper.writeValueAsString(newAssignment))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(409));
	}

}
