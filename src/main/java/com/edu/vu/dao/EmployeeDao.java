package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.edu.vu.model.Employee;
import com.edu.vu.model.User;

public class EmployeeDao {
	/** 
	 * getEmployee
	 * This method gets employee from the database
	 * @param user
	 * @return Employee object
	 * @throws ClassNotFoundException
	 */
	public int getEmployee(User user)throws ClassNotFoundException{
		int result =0;
		String GET_USER_SQL = "Select * from faculty where EMPLOYEEID = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs =null;
		Employee employee = new Employee();
		try {
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_SQL);
			preparedStatement.setString(1, user.getId());
			rs = preparedStatement.executeQuery();
						
			if(rs.next()) {
				
				employee.setEmployeeId(rs.getString("EMPLOYEEID"));
				employee.setFirstName(rs.getString("FIRST_NAME"));
				employee.setLastName(rs.getString("LAST_NAME"));
				employee.setDob(rs.getString("DOB"));
				employee.setDesignation(rs.getString("DESIGNATION"));
				employee.setStatus(rs.getString("STATUS"));
				
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

