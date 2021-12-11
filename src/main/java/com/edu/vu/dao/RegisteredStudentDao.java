package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.edu.vu.model.Employee;
import com.edu.vu.model.RegisteredStudent;
import com.edu.vu.model.User;

public class RegisteredStudentDao {
	/** 
	 * getRegisteredStudent
	 * This method gets registered student from the database and
	 * fills the model for registered students
	 * @param user
	 * @return RegisteredStudent object
	 * @throws ClassNotFoundException
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	public RegisteredStudent getRegisteredStudent(String userId)throws ClassNotFoundException{
		int result =0;
		String GET_USER_SQL = "Select * from ADMITTEDSTUDENT where STUDENTID = " + userId;   
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection = null;
		RegisteredStudent registeredStudent = new RegisteredStudent();
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
						
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(GET_USER_SQL);
						
			if(rs.next()) {
				
				registeredStudent.setStudentId(rs.getInt("STUDENTID"));
				registeredStudent.setFirstName(rs.getString("FIRST_NAME"));
				registeredStudent.setLastName(rs.getString("LAST_NAME"));
				registeredStudent.setDob(rs.getString("DOB"));
				registeredStudent.setGrade(rs.getInt("GRADE"));
				registeredStudent.setParentId(rs.getString("PARENTID"));
				registeredStudent.setStatus(rs.getString("STATUS"));
				
			}
			rs.close();

						
		}catch(Exception moae) {
			
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try{
				connection.close();
			}catch(Exception mo) {}	
		}
		return registeredStudent;
	}
	public boolean addRegisteredStudent(RegisteredStudent registeredStudent)throws ClassNotFoundException{
		boolean result =false;
		String ADD_STUDENT_SQL = "INSERT INTO ADMITTEDSTUDENT(FIRST_NAME, LAST_NAME, DOB, GRADE, PARENTID, STATUS)  VALUES (?,?,?,?,?,?) ";  
		                                                       
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection = null;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
						
			PreparedStatement pstatement = connection.prepareStatement(ADD_STUDENT_SQL);
			
			pstatement.setString(1,registeredStudent.getFirstName());
			pstatement.setString(2,registeredStudent.getLastName());
			pstatement.setString(3,registeredStudent.getDob());
			pstatement.setInt(4,registeredStudent.getGrade());
			pstatement.setString(5,registeredStudent.getParentId());
			pstatement.setString(6,registeredStudent.getStatus());
			
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
