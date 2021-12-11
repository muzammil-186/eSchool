package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.vu.model.Employee;
import com.edu.vu.model.Faculty;



public class FacultyDao {
	/** 
	 * getFaculty
	 * This method gets Faculty from the database and
	 * fills the model for Faculty
	 * @param faculty
	 * @return Faculty object
	 * @throws ClassNotFoundException
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	public ArrayList <Faculty> getAllFaculty()throws ClassNotFoundException{
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
		String GET_FACULTY_SQL = "Select * from faculty";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_FACULTY_SQL);

			while(rs.next()) {
				Faculty currentFaculty = new Faculty();
				currentFaculty.setEmployeeId(rs.getString("EMPLOYEEID"));
				currentFaculty.setFirstName(rs.getString("FIRST_NAME"));
				currentFaculty.setLastName(rs.getString("LAST_NAME"));
				currentFaculty.setGrades(rs.getString("GRADES"));
				currentFaculty.setSubjects(rs.getString("SUBJECTS"));
				currentFaculty.setStatus(rs.getString("STATUS"));
				currentFaculty.setEmail(rs.getString("EMAIL"));
				facultyList.add(currentFaculty);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return facultyList;
	}
	
	public boolean addFaculty(Faculty faculty)throws ClassNotFoundException{
		boolean result =false;
		String ADD_STUDENT_SQL = "INSERT INTO FACULTY(EMPLOYEEID, FIRST_NAME, LAST_NAME, GRADES, SUBJECTS, STATUS, EMAIL)  VALUES (?,?,?,?,?,?,?) ";  
		                                                       
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection = null;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
						
			PreparedStatement pstatement = connection.prepareStatement(ADD_STUDENT_SQL);
			
			pstatement.setString(1,faculty.getEmployeeId());
			pstatement.setString(2,faculty.getFirstName());
			pstatement.setString(3,faculty.getLastName());
			pstatement.setString(4,faculty.getGrades());
			pstatement.setString(5,faculty.getSubjects());
			pstatement.setString(6,faculty.getStatus());
			pstatement.setString(7,faculty.getEmail());
			
			
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
