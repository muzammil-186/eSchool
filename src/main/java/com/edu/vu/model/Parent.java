package com.edu.vu.model;

public class Parent {
	private String parentId;
	private String firstName;
	private String lastName;
	private String dob;
	private String status;
	
	/**
	 * Method getParentId
	 * gets parentId
	 * @return java.lang.String
	 */
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
