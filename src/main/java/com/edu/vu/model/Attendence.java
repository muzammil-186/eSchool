package com.edu.vu.model;

public class Attendence {

	private int studentId;
	private int grade;
	private String parentId;
	private String attendenceDate;
	private String attendenceStatus;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getAttendenceDate() {
		return attendenceDate;
	}
	public void setAttendenceDate(String attendenceDate) {
		this.attendenceDate = attendenceDate;
	}
	public String getAttendenceStatus() {
		return attendenceStatus;
	}
	public void setAttendenceStatus(String attendenceStatus) {
		this.attendenceStatus = attendenceStatus;
	}	
	
}
