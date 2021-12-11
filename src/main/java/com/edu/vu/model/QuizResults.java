package com.edu.vu.model;

public class QuizResults {

	private int studentId; //STUDENTID INT NOT NULL,	
    private int grade; //GRADE int NOT NULL,
    private String parentId;//PARENTID VARCHAR(20),
    private String resultGrade;//RESULTGRADE VARCHAR(02),
    private String subject;//SBJCT VARCHAR(20),
    private String examType;//EXAMTYPE VARCHAR(20),
    private String examDate;
    
    
    
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
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
	public String getResultGrade() {
		return resultGrade;
	}
	public void setResultGrade(String resultGrade) {
		this.resultGrade = resultGrade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
    
    
}
