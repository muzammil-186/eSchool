package com.edu.vu.model;

public class HomeWork {
	 private int grade;// GRADE int NOT NULL,
	 private String subject;//SUBJECTS VARCHAR(12),
	 private String assignDate;//ASSIGNDATE VARCHAR(10),
	 private String dueDate;//DUEDATE VARCHAR(10),
	 private  String task;//TASK VARCHAR(100),
	 
	 
	 
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	 
	 
}
