package com.edu.vu.model;

public class RegisteredStudent {
	private int studentId;
	private String firstName;
	private String lastName;
	private String dob;
	private int grade;
	private String parentId;
	private String status;
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 * Method getStudentId
	 * gets studentId
	 * @return java.lang.String
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * equals 
	 * return checks if the two objects are equal
	 * @param employee
	 * @return true if equal otherwise false
	 */ 
	public boolean isUserSame(User user) {
		 return (
				 this.dob.equalsIgnoreCase(user.getDob())&&
				 this.firstName.equalsIgnoreCase(user.getFirstName())&&
				 this.lastName.equalsIgnoreCase(user.getLastName()));
	}
    
    
    
}
