package com.song.song.demo.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.song.song.demo.entity.Department;
import com.song.song.demo.service.DepartmentService;

class Department_ControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp() throws Exception {
		department = Department.builder()
				.departmentAddress("Ahihi")
				.departmentCode("IT-01")
				.departmentName("IT")
				.departmentId(1L)
				.build();
	}

	@Test
	void testSaveDepartment() {
		Department in_department = Department.builder()
				.departmentAddress("Ahihi")
				.departmentCode("IT-01")
				.departmentName("IT")
				.departmentId(1L)
				.build();
	Mockito.when(departmentService.saveDepartment(in_department)).thenReturn(department);
	}

	@Test
	void testFetchDepartmentById() {
		fail("Not yet implemented");
	}

}
