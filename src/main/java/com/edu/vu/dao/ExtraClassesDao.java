package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.vu.model.Course;

public class ExtraClassesDao {
		
	public ArrayList <Course> getAllCourses()throws ClassNotFoundException{
		ArrayList<Course> users = new ArrayList<Course>();
		String GET_COURSE_SQL = "Select * from course";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_COURSE_SQL);

			while(rs.next()) {
				Course currentCourse = new Course();
				currentCourse.setCourseId(rs.getString("COURSEID"));
				currentCourse.setCourseTitle(rs.getString("TITLE"));
				currentCourse.setCourseLevel(rs.getString("LEVEL"));
				currentCourse.setCourseType(rs.getString("TYPE"));
				currentCourse.setStartDate(rs.getString("STARTDATE"));
				currentCourse.setEndDate(rs.getString("ENDDATE"));
				currentCourse.setCoursePrequisite(rs.getString("PREREQ"));
				currentCourse.setEnrollmentLimit(rs.getInt("ENRLMNTLIMIT"));
				currentCourse.setCurrentEnrollement(rs.getInt("ENROLLED"));
				currentCourse.setOpenSeats(rs.getInt("OPENSEATS"));
				currentCourse.setTuition(rs.getString("TUITION"));
				users.add(currentCourse);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return users;
	}
	
	
	public ArrayList <Course> getCourses(String courseType)throws ClassNotFoundException{
		ArrayList<Course> courses = new ArrayList<Course>();
		String GET_COURSE_SQL = "Select * from course where type = '"+ courseType+"'";
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_COURSE_SQL);

			while(rs.next()) {
				Course currentCourse = new Course();
				currentCourse.setCourseId(rs.getString("COURSEID"));
				currentCourse.setCourseTitle(rs.getString("TITLE"));
				currentCourse.setCourseLevel(rs.getString("LEVEL"));
				currentCourse.setCourseType(rs.getString("TYPE"));
				currentCourse.setStartDate(rs.getString("STARTDATE"));
				currentCourse.setEndDate(rs.getString("ENDDATE"));
				currentCourse.setCoursePrequisite(rs.getString("PREREQ"));
				currentCourse.setEnrollmentLimit(rs.getInt("ENRLMNTLIMIT"));
				currentCourse.setCurrentEnrollement(rs.getInt("ENROLLED"));
				currentCourse.setOpenSeats(rs.getInt("OPENSEATS"));
				currentCourse.setTuition(rs.getString("TUITION"));
					
				courses.add(currentCourse);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return courses;
	}

	
	
	
}
