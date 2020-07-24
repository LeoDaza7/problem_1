package com.truextend.problem_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.truextend.problem_1.entities.Class;
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
	public void createClassOk () throws Exception {
		Class testClass = new Class(7,"Math","virtual class");
		mvc.perform(MockMvcRequestBuilders
				.post("/api/class")
				.content(objectMapper.writeValueAsString(testClass))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void createClassWithError () throws Exception {
		Class testClass = new Class(1,"Math","virtual class");
		mvc.perform(MockMvcRequestBuilders
				.post("/api/class")
				.content(objectMapper.writeValueAsString(testClass))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(409));
	}

	@Test
	public void updateClassOk () throws Exception {
		Class testClass = new Class(1,"Math","virtual class");
		mvc.perform(MockMvcRequestBuilders
				.put("/api/class/1")
				.content(objectMapper.writeValueAsString(testClass))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void updateClassWithError () throws Exception {
		Class testClass = new Class(8,"Math","virtual class");
		mvc.perform(MockMvcRequestBuilders
				.put("/api/class/8")
				.content(objectMapper.writeValueAsString(testClass))
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void deleteClassOk () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.delete("/api/class/1")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteClassWithError () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.delete("/api/class/9")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void getClassOk () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/class/3")
				.contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getClassWithError () throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/class/10")
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

}
