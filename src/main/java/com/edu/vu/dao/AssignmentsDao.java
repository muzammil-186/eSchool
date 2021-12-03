package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.vu.model.Faculty;
import com.edu.vu.model.HomeWork;

public class AssignmentsDao {
	
	public ArrayList <HomeWork> getAssignments(int grade, String assignDate)throws ClassNotFoundException{
		ArrayList<HomeWork> hwList = new ArrayList<HomeWork>();
		
		String GET_HW_SQL = "Select * from ASSIGNMENTS where grade= "+ grade + "AND ASSIGNDATE= "+ assignDate;
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_HW_SQL);

			while(rs.next()) {
				HomeWork currentHomeWork = new HomeWork();
				currentHomeWork.setGrade(rs.getInt("GRADE"));
				currentHomeWork.setSubject(rs.getString("SUBJECTS"));
				currentHomeWork.setAssignDate(rs.getString("ASSIGNDATE"));
				currentHomeWork.setDueDate(rs.getString("DUEDATE"));
				currentHomeWork.setTask(rs.getString("TASK"));
				hwList.add(currentHomeWork);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return hwList;
	}

}
