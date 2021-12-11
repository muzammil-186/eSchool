package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.edu.vu.model.QuizResults;
import com.edu.vu.model.User;


public class QuizResultsDao {
	public ArrayList <QuizResults> getExamResults(int studentId,int grade, String parentId, String subject, String examDate  )throws ClassNotFoundException{
		ArrayList<QuizResults> resultList = new ArrayList<QuizResults>();
		StringBuffer sb = new StringBuffer(48);
		
		sb.append("Select * from QUIZRESULTS where STUDENTID= ").append(studentId).append(" ").append("AND grade =" ).append(grade);
		if(parentId!= null){
			sb.append(" ").append("AND PARENTID =").append(" ").append(parentId);
		}
		if(subject!= null){
			sb.append(" ").append("AND SBJCT =").append(" ").append(subject);
		}
		if(examDate!= null){
			sb.append(" ").append("AND EXAMDATE =").append(" ").append(examDate);
		}
		String GET_RES_SQL = sb.toString();
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_RES_SQL);

			while(rs.next()) {
				QuizResults currentQuizResult = new QuizResults();
				currentQuizResult.setStudentId(rs.getInt("STUDENTID"));
				currentQuizResult.setGrade(rs.getInt("GRADE"));
				currentQuizResult.setParentId(rs.getString("PARENTID"));
				currentQuizResult.setResultGrade(rs.getString("RESULTGRADE"));
				currentQuizResult.setSubject(rs.getString("SBJCT"));
				currentQuizResult.setExamType(rs.getString("EXAMTYPE"));
				currentQuizResult.setExamDate(rs.getString("EXAMDATE"));
				
				resultList.add(currentQuizResult);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return resultList;
	}
	public ArrayList <QuizResults> getAllExamResults(String studentId )throws ClassNotFoundException{
		ArrayList<QuizResults> resultList = new ArrayList<QuizResults>();
		StringBuffer sb = new StringBuffer(24);
		
		sb.append("Select * from QUIZRESULTS where STUDENTID= ").append(studentId);
		String GET_RES_SQL = sb.toString();
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_RES_SQL);

			while(rs.next()) {
				QuizResults currentQuizResult = new QuizResults();
				currentQuizResult.setStudentId(rs.getInt("STUDENTID"));
				currentQuizResult.setGrade(rs.getInt("GRADE"));
				currentQuizResult.setParentId(rs.getString("PARENTID"));
				currentQuizResult.setResultGrade(rs.getString("RESULTGRADE"));
				currentQuizResult.setSubject(rs.getString("SBJCT"));
				currentQuizResult.setExamType(rs.getString("EXAMTYPE"));
				currentQuizResult.setExamDate(rs.getString("EXAMDATE"));
				
				resultList.add(currentQuizResult);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return resultList;
	}
	public int addExamResult(QuizResults qResult)throws ClassNotFoundException{
		
		int result =0;
		Connection connection = null;
		String INSERT_USERS_SQL = "INSERT INTO QUIZRESULTS " + 
		" (STUDENTID, GRADE, PARENTID, RESULTGRADE, SBJCT, EXAMTYPE,EXAMDATE) VALUES " +
	    "(?, ?, ?, ?, ?, ?, ?);";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setInt(1, qResult.getStudentId());
			preparedStatement.setInt(2, qResult.getGrade());
			preparedStatement.setString(3, qResult.getParentId());
			preparedStatement.setString(4, qResult.getResultGrade());
			preparedStatement.setString(5, qResult.getSubject());
			preparedStatement.setString(6, qResult.getExamType());
			preparedStatement.setString(7, qResult.getExamDate());
			
			System.out.println("Executing query:" + preparedStatement);
			result = preparedStatement.executeUpdate();
			
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}
		return result;
	}

}
