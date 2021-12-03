package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.vu.controller.StudentResultServlet;
import com.edu.vu.model.Employee;
import com.edu.vu.model.ParentViewGrade;
import com.edu.vu.model.RegisteredStudent;
import com.edu.vu.model.StudentResult;
import com.edu.vu.model.User;

public class  StudentResultDao {
	private ParentViewGrade studentResult;
	/** 
	 * This method gets student grade from the database and
	 * fills the model for registered students
	 * @param user
	 * @return ParentViewGrade object
	 * @throws ClassNotFoundException
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 * @param <StudentResult>
	 * @param <StudentResult>
	 */
	public ArrayList<StudentResult> getStudentResult(String studentId, String parentId)throws ClassNotFoundException{
		int result =0;
		ArrayList<StudentResult>  studentResultsList = new ArrayList<StudentResult>();
		String GET_USER_SQL = "Select * from STUDENTRESULT where STUDENTID = " + studentId + "AND PARENTID =" + parentId;   
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection = null;
		StudentResult studentResult = new StudentResult();
		try {
			 connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
						
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(GET_USER_SQL);
						
			if(rs.next()) {
				studentResult.setStudentId(rs.getInt("STUDENTID"));
				studentResult.setGrade(rs.getInt("GRADE"));
				studentResult.setFirstName(rs.getString("FIRST_NAME"));
				studentResult.setLastName(rs.getString("LAST_NAME"));
				studentResult.setParentId(rs.getString("PARENTID"));
				studentResult.setDob(rs.getString("DOB"));
				studentResult.setResultGrade(rs.getString("RESULTGRADE"));
				studentResult.setStudentAttendance(Integer.parseInt(rs.getString("STUDENT_ATTENDANCE")));
				studentResultsList.add(studentResult);
			}
			rs.close();

						
		}catch(Exception moae) {
			
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try{
				connection.close();
			}catch(Exception mo) {}	
		}
		return studentResultsList;
	}
	private void setStudentAttendance(String string) {
		// TODO Auto-generated method stub
		
	}
	private void setResultGrade(String string) {
		// TODO Auto-generated method stub
		
	}
	private void setDob(String string) {
		// TODO Auto-generated method stub
		
	}
	private void setParentId(String string) {
		// TODO Auto-generated method stub
		
	}
	private void setLastName(String string) {
		// TODO Auto-generated method stub
		
	}
	private void setFirstName(String string) {
		// TODO Auto-generated method stub
		
	}
	private void setGrade(int int1) {
		// TODO Auto-generated method stub
		
	}
	private void setStudentId(int int1) {
		// TODO Auto-generated method stub
		
	}
	public boolean addGrade(ParentViewGrade parentViewGrade)throws ClassNotFoundException{
		boolean result =false;
		String ADD_STUDENT_SQL = "INSERT INTO STUDENTRESULT(STUDENTID,  GRADE, FIRST_NAME, LAST_NAME, PARENTID,  DOB, RESULTGRADE, STUDENT_ATTENDANCE)  VALUES (?,?,?,?,?,?,?,?)";  
		                                                       
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection = null;
		
		try {
			 connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
						
			PreparedStatement pstatement = connection.prepareStatement(ADD_STUDENT_SQL);
			
			pstatement.setInt(1,studentResult.getStudentId());
			pstatement.setInt(2,studentResult.getGrade());
			pstatement.setString(3,studentResult.getFirstName());
			pstatement.setString(4,studentResult.getLastName());
			pstatement.setString(5,studentResult.getParentId());
			pstatement.setString(6,studentResult.getDob());
			pstatement.setString(6,studentResult.getResultGrade());
			pstatement.setString(6,studentResult.getStudentAttendance());
			
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
	public <StudentResult> List<StudentResult> getAllStudentResult() {
		// TODO Auto-generated method stub
		return null;
	}


}
