package com.song.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.song.springdatajpa.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface Student_repository extends JpaRepository<Student, Long>{
	List<Student> studentList findByFirstName(String firstName);
	
	@Query("Select s from Student s where s.emailID = ?1")
	Student getStudentByEmailAddress(String emailID);
	
	@Query(
			value = "SELECT * FROM tbl_student s where s.email_address = ?1",
			nativeQuery = true
	)
	Student getStudentByEmailAddresNative(String emailID);
	
	@Query(
			value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
			nativeQuery = true
	)
	Student getStudentByEmailAddresNativeParam(
			@Param("emailID") String emailID);
	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_student set firstname = ?1 where email_address = ?2",
			nativeQuery = true
			)
	int updateStudentNameByEmailId(String firstname, String emailId);
}

