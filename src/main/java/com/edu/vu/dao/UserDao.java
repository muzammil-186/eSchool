package com.edu.vu.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.edu.vu.model.User;

public class UserDao {
	
	public int registerUser(User user)throws ClassNotFoundException{
		int result =0;
		String INSERT_USERS_SQL = "INSERT INTO USER " + 
		" (ID, STATUS, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME,DOB,ROLE, VERSION) VALUES " +
	    "(?, ?, ?, ?, ?, ?, ?,?,?);";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setInt(2, user.getStatus());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getFirstName());
			preparedStatement.setString(6, user.getLastName());
			preparedStatement.setString(7, user.getDob());
			preparedStatement.setString(8, user.getRole());
			preparedStatement.setInt(9, user.getVersion());
			System.out.println("Executing query:" + preparedStatement);
			result = preparedStatement.executeUpdate();
			
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return result;
	}

}
