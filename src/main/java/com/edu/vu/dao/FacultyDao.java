package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_FACULTY_SQL);

			while(rs.next()) {
				Faculty currentFaculty = new Faculty();
				currentFaculty.setEmployeeId(rs.getString("EMPLOYEEID"));
				currentFaculty.setFirstName(rs.getString("FIRST_NAME"));
				currentFaculty.setLastName(rs.getString("LAST_NAME"));
				currentFaculty.setGrades(rs.getString("GRADES"));
				currentFaculty.setSubjects(rs.getString("SUBJECTS"));
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
	
	
}
