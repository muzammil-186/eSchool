package com.edu.vu.model;

public class ParentViewGrade {
	private int studentId;
	private int grade;
	private String firstName;
	private String lastName;
	private String parentId;
	private String dob;
	private String resultGrade;
	private String studentAttendance;
	
		
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getResultGrade() {
		return resultGrade;
	}
	public void setResultGrade(String resultGrade) {
		this.resultGrade = resultGrade;
	}
	public String getStudentAttendance() {
		return studentAttendance;
	}
	public void setStudentAttendance(String studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
	
	
	public boolean isUserSame(User user) {
		 return (
				 this.dob.equalsIgnoreCase(user.getDob())&&
				 this.firstName.equalsIgnoreCase(user.getFirstName())&&
				 this.lastName.equalsIgnoreCase(user.getLastName()));
	}
	public void SetAddress(String parameter) {
		// TODO Auto-generated method stub
		
	}
   
   
   
}

	
	
	
	
	
	
	
	
	
