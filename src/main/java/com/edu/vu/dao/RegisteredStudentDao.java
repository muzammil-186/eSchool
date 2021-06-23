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
	 * This method gets registered student from the database
	 * @param user
	 * @return RegisteredStudent object
	 * @throws ClassNotFoundException
	 */
	public int getRegisteredStudent(User user)throws ClassNotFoundException{
		int result =0;
		String GET_USER_SQL = "Select * from user where STUDENTID = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		RegisteredStudent registeredstudent = new RegisteredStudent();
		try {
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_SQL);
			preparedStatement.setString(1, user.getId());
			rs = preparedStatement.executeQuery();
						
			if(rs.next()) {
				
				registeredstudent.setStudentId(rs.getString("REGSTUDENT"));
				registeredstudent.setFirstName(rs.getString("FIRST_NAME"));
				registeredstudent.setLastName(rs.getString("LAST_NAME"));
				registeredstudent.setDob(rs.getString("DOB"));
				registeredstudent.setStatus(rs.getString("STATUS"));
				
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

		
		
		
		
		
		