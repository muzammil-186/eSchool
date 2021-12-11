package com.edu.vu.model;

public class Invoices {
	
	private String id;//   ID VARCHAR(20) NOT NULL,
    private int studentId;//STUDENTID INT NOT NULL,	
    private int grade;//GRADE int NOT NULL,
    private String parentId;//  PARENTID VARCHAR(20),
    private String invoiceType;//INVOICETYPE VARCHAR(16),
    private int amount;//AMOUNT int,
    private String description;// DESCR VARCHAR(100),
    private String invoiceDate;//INVOICEDATE VARCHAR(10),
    private String dueDate;//DUEDATE VARCHAR(10),
    private String paymentstatus;//PAYSTATUS VARCHAR(10),
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
    
    
    
	 

}
