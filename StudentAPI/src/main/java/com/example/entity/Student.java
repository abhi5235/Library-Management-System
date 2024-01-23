package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.dto.StudentDTO;

@Entity
public class Student {

	@Id
	private int studentId;
	private String name;
	private String emailId;
	private int phoneNumber;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public StudentDTO convertToDTO() {
		StudentDTO studentDto=new StudentDTO();
		studentDto.setStudentId(this.getStudentId());
		studentDto.setEmailId(this.getEmailId());
		studentDto.setName(this.getName());
		studentDto.setPhoneNumber(this.getPhoneNumber());
		return studentDto;
		
	}
}
