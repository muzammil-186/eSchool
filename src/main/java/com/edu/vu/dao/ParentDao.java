package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.edu.vu.model.Parent;
import com.edu.vu.model.User;


public class ParentDao {
	/** 
	 * getParent
	 * This method gets parent student from the database
	 * @param user
	 * @return Parent object
	 * @throws ClassNotFoundException
	 */
	public int getParent(User user)throws ClassNotFoundException{
		int result =0;
		String GET_USER_SQL = "Select * from PARENT where PARENTID = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Parent parent = new Parent();
		try {
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_SQL);
			preparedStatement.setString(1, user.getId());
			rs = preparedStatement.executeQuery();
						
			if(rs.next()) {
				
				parent.setParentId(rs.getString("PARENTID"));
				parent.setFirstName(rs.getString("FIRST_NAME"));
				parent.setLastName(rs.getString("LAST_NAME"));
				parent.setDob(rs.getString("DOB"));
				parent.setStatus(rs.getString("STATUS"));
				
			}
			rs.close();

			System.out.println("Executing query:" + preparedStatement);
			result = preparedStatement.executeUpdate();
			
		}catch(Exception moae) {
			try{
			rs.close();
			}catch(Exception mo) {}
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return result;
	}




}
