package com.song.song.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.song.song.demo.entity.Department;
import com.song.song.demo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentservice;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = 
				Department.builder()
				.departmentName("IT")
				.departmentAddress("Ahihi")
				.departmentCode("IT-91")
				.departmentId(1L)
				.build();
		Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
	}
	


	@Test
	@DisplayName("Get Data based on V Department Name")
//	@Disabled
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = 
						departmentservice.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}

}
