package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.edu.vu.model.HomeWork;
import com.edu.vu.model.QuizResults;

public class AssignmentsDao {
	
	public ArrayList <HomeWork> getAssignments(int grade, String assignDateFrom, String assignDateTo)throws ClassNotFoundException{
		ArrayList<HomeWork> hwList = new ArrayList<HomeWork>();
		StringBuffer sb = new StringBuffer(48);
		
		sb.append("Select * from ASSIGNMENTS where grade= ").append(grade);
		if(assignDateFrom.length()!= 10 && assignDateTo.length()!= 10){
			sb.append(" ").append("AND ASSIGNDATE BETWEEN").append(" ").append('\'').append(assignDateFrom).append('\'').append(" ").append("AND").append(" ").append('\'').append(assignDateTo).append('\'');
		}
		String GET_HW_SQL = sb.toString();//"Select * from ASSIGNMENTS where grade= "+ grade + " AND ASSIGNDATE= "+ assignDate;
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
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
	
	
	public ArrayList <HomeWork> getAssignmentsBySubject(int grade, String subject, String assignDate)throws ClassNotFoundException{
		ArrayList<HomeWork> hwList = new ArrayList<HomeWork>();
		StringBuffer sb = new StringBuffer(48);
		
		sb.append("Select * from ASSIGNMENTS where grade= ").append(grade);
		if(subject.length()>0 ){
			sb.append(" ").append("AND subjects=").append(" ").append('\'').append(subject).append('\'');
		}
		if(assignDate.length()== 10){
			sb.append(" ").append("AND ASSIGNDATE=").append(" ").append('\'').append(assignDate).append('\'');
		}
		
		String GET_HW_SQL = sb.toString();
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
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
	public int addAssignment(HomeWork hw)throws ClassNotFoundException{
		
		int result =0;
		Connection connection = null;
		String INSERT_USERS_SQL = "INSERT INTO ASSIGNMENTS " + 
		" (GRADE, SUBJECTS, ASSIGNDATE, DUEDATE, TASK) VALUES " +
	    "(?, ?, ?, ?, ?);";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setInt(1, hw.getGrade());
			preparedStatement.setString(2, hw.getSubject());
			preparedStatement.setString(3, hw.getAssignDate());
			preparedStatement.setString(4, hw.getDueDate());
			preparedStatement.setString(5, hw.getTask());
			
			
			System.out.println("Executing query:" + preparedStatement);
			result = preparedStatement.executeUpdate();
			
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return result;
	}


}
