package com.song.song.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.song.demo.entity.Department;
import com.song.song.demo.error.DepartmentNotFoundException;
import com.song.song.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class Department_Controller {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(Department_Controller.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		LOGGER.info("Insider saveDepartment"); 
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("departments/{id}")
	public Department fetchDepartmentById(@Valid @PathVariable("id") Long DepartmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(DepartmentId);
	}
	
	@DeleteMapping("departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long DepartmentId) {
		departmentService.deleteDepartmentById(DepartmentId);
		return "Department Delete Success";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long DepartmentId,
									   @RequestBody Department department) {
		return departmentService.updateDepartment(DepartmentId, department);
		
	}
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String DepartmentName){
		return departmentService.fetchDepartmentByName(DepartmentName);
	}
}
