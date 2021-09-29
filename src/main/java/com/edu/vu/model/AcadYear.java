package com.edu.vu.model;



public class AcadYear {
	private int grades;
	private String regDate;
	private String semesterStartDate;
	private String semesterBreak;
	private String finalExamDate;
	private String resultDate;
	public int getGrades() {
		return grades;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getSemesterStartDate() {
		return semesterStartDate;
	}
	public void setSemesterStartDate(String semesterStartDate) {
		this.semesterStartDate = semesterStartDate;
	}
	public String getSemesterBreak() {
		return semesterBreak;
	}
	public void setSemesterBreak(String semesterBreak) {
		this.semesterBreak = semesterBreak;
	}
	public String getFinalExamDate() {
		return finalExamDate;
	}
	public void setFinalExamDate(String finalExamDate) {
		this.finalExamDate = finalExamDate;
	}
	public String getResultDate() {
		return resultDate;
	}
	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
	public void setGrades(int grades) {
		this.grades = grades;
	}
	
}
