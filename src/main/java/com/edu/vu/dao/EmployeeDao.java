package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.edu.vu.model.Employee;
import com.edu.vu.model.RegisteredStudent;
import com.edu.vu.model.User;

public class EmployeeDao {
	/** 
	 * getEmployee
	 * This method gets employee from the database
	 * @param user
	 * @return Employee object
	 * @throws ClassNotFoundException
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	public Employee getEmployee(String userId)throws ClassNotFoundException{
		int result =0;
		Connection connection = null;
		String GET_USER_SQL = "Select * from EMPLOYEE where EMPLOYEEID = " + userId;
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Employee employee = new Employee();
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(GET_USER_SQL);
						
			if(rs.next()) {
				
				employee.setEmployeeId(rs.getString("EMPLOYEEID"));
				employee.setFirstName(rs.getString("FIRST_NAME"));
				employee.setLastName(rs.getString("LAST_NAME"));
				employee.setDob(rs.getString("DOB"));
				employee.setDesignation(rs.getString("DESIGNATION"));
				employee.setStatus(rs.getString("STATUS"));
				
			}
			rs.close();

						
		}catch(Exception moae) {
			
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try{
				connection.close();
				}catch(Exception mo) {}
		}
		return employee;
	}
	
	public boolean addEmployee(Employee employee)throws ClassNotFoundException{
		boolean result =false;
		String ADD_STUDENT_SQL = "INSERT INTO EMPLOYEE(EMPLOYEEID, FIRST_NAME, LAST_NAME, DOB, DESIGNATION, STATUS)  VALUES (?,?,?,?,?,?) ";  
		                                                       
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection = null;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
						
			PreparedStatement pstatement = connection.prepareStatement(ADD_STUDENT_SQL);
			
			pstatement.setString(1,employee.getEmployeeId());
			pstatement.setString(2,employee.getFirstName());
			pstatement.setString(3,employee.getLastName());
			pstatement.setString(4,employee.getDob());
			pstatement.setString(5,employee.getDesignation());
			pstatement.setString(6,employee.getStatus());
			
			pstatement.execute();
						
				
			result= true;
						
		}catch(Exception moae) {
			
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try{
				connection.close();
			}catch(Exception mo) {}	
		}
		return result;
	}

}

