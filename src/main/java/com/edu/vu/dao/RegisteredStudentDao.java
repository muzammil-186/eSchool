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
	 */
	public RegisteredStudent getRegisteredStudent(String userId)throws ClassNotFoundException{
		int result =0;
		String GET_USER_SQL = "Select * from REGSTUDENT where STUDENTID = " + userId;   
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Connection connection = null;
		RegisteredStudent registeredStudent = new RegisteredStudent();
		try {
			 connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
						
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(GET_USER_SQL);
						
			if(rs.next()) {
				
				registeredStudent.setStudentId(rs.getString("STUDENTID"));
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


}
