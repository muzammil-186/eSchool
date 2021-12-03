package com.edu.vu.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.vu.model.User;

public class UserDao {
	
	public int registerUser(User user)throws ClassNotFoundException{
		int result =0;
		Connection connection = null;
		String INSERT_USERS_SQL = "INSERT INTO USER " + 
		" (ID, STATUS, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME,DOB,PARENTID,GRADE, ROLE, VERSION) VALUES " +
	    "(?, ?, ?, ?, ?, ?, ?,?,?,?,?);";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");
		
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setInt(2, user.getStatus());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getFirstName());
			preparedStatement.setString(6, user.getLastName());
			preparedStatement.setString(7, user.getDob());
			preparedStatement.setString(8, user.getParentId());
			preparedStatement.setInt(9, user.getGrade());
			preparedStatement.setString(10, user.getRole());
			preparedStatement.setInt(11, user.getVersion());
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
		int gradeTest =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");
	
		try {
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
			currentUser.setParentId(rs.getString("PARENTID"));
			currentUser.setGrade(rs.getInt("GRADE"));
			currentUser.setRole(rs.getString("ROLE"));

	    }
	   
		}catch(SQLException ignore) {
			System.out.println(ignore.getMessage());
			throw new Exception(); // To be Further coded
			
		}finally {
		 
			   connection.close(); // Always called
			 
		}
	    
		  return currentUser; 	
		
	}
	/**
	 * getUser 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public void updateUserStatus(String id, int status)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");
	
		try {
				PreparedStatement stmt = connection.prepareStatement("UPDATE  user SET status=? WHERE ID=?");
				stmt.setInt(1, status);
				stmt.setString(2, id);
			    stmt.executeUpdate();
		}catch(SQLException ignore) {
			throw new Exception(); // To be Further coded
			
		}finally {
		 
			   connection.close(); // Always called
		
		}
		
	}

}
