package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.edu.vu.model.Parent;
import com.edu.vu.model.User;


public class ParentDao {
	/** 
	 * getParent
	 * This method gets parent student from the database
	 * @param user
	 * @return Parent object
	 * @throws ClassNotFoundException
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	public Parent getParent(String userId)throws ClassNotFoundException{
		int result =0;
		String GET_USER_SQL = "Select * from PARENT where PARENTID = " + userId;
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection =null;
		Parent parent = new Parent();
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");
		
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(GET_USER_SQL);
						
			if(rs.next()) {
				
				parent.setParentId(rs.getString("PARENTID"));
				parent.setFirstName(rs.getString("FIRST_NAME"));
				parent.setLastName(rs.getString("LAST_NAME"));
				parent.setDob(rs.getString("DOB"));
				parent.setStatus(rs.getString("STATUS"));
				
			}
			rs.close();

						
		}catch(Exception moae) {
			
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try{
				connection.close();
				}catch(Exception mo) {}
		}
		return parent;
	}




}
