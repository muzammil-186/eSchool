package com.edu.vu.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	/**
	 * getUser 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User getUser(String username, String password)throws Exception {
		User currentUser = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
	    if(rs.next())	{
	    	currentUser = new User();
			currentUser.setId(rs.getString("ID"));
			currentUser.setUserName(rs.getString("USERNAME"));
			currentUser.setPassword(rs.getString("PASSWORD"));
			currentUser.setFirstName(rs.getString("FIRST_NAME"));
			currentUser.setLastName(rs.getString("LAST_NAME"));
			currentUser.setDob(rs.getString("DOB"));
			currentUser.setRole(rs.getString("ROLE"));

	    }
	    connection.close();
	    return currentUser; 	
		
	}

}
