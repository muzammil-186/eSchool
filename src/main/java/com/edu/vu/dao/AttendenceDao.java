package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.edu.vu.model.Attendence;


public class AttendenceDao {

	
	 public ArrayList<Attendence> getAttendence(String studentId, String parentId, String attenDate)throws ClassNotFoundException{
			ArrayList<Attendence> attendList = new ArrayList<Attendence>();
			StringBuffer sqlsb = new StringBuffer(24);
			sqlsb.append("Select * from ATTENDENCE where STUDENTID=").append(studentId);
			if(attenDate != null) {
				sqlsb.append(" and ATTENDATE=").append(attenDate);
			}
			if(parentId !=null) {
				sqlsb.append(" and PARENTID=").append(parentId);
			}
			String GET_ATTEND_SQL = sqlsb.toString();//"Select * from ATTENDENCE where STUDENTID=" + studentId;
			System.out.println("SQL for Attendence date:"+ GET_ATTEND_SQL);
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				connection = 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
			
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(GET_ATTEND_SQL);

				while(rs.next()) {
					Attendence currentAttend = new Attendence();
					currentAttend.setStudentId(rs.getInt("STUDENTID"));
					currentAttend.setGrade(rs.getInt("GRADE"));
					currentAttend.setParentId(rs.getString("PARENTID"));
					currentAttend.setAttendenceDate(rs.getString("ATTENDATE"));
					currentAttend.setAttendenceStatus(rs.getString("ATTENDSTATUS"));
					
					
					attendList.add(currentAttend);
				}
				rs.close();
			}catch(Exception moae) {
				System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
			}finally {
				try {
					connection.close();
				}catch(Exception ignore) {}
			}
			return attendList;
		}
	 
	 
	 public boolean registerAttendence(Attendence attendence)throws ClassNotFoundException{
			boolean result =false;
			String REG_ATTEND_SQL = "INSERT INTO ATTENDENCE (STUDENTID, GRADE, PARENTID, ATTENDATE, ATTENDSTATUS)  VALUES (?,?,?,?,?) ";  
			                                                       
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = null;
			
			try {
				//Class.forName("com.mysql.cj.jdbc.Driver");
				
				connection = 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
			
							
				PreparedStatement pstatement = connection.prepareStatement(REG_ATTEND_SQL);
				
				pstatement.setInt(1,attendence.getStudentId());
				pstatement.setInt(2,attendence.getGrade());
				pstatement.setString(3,attendence.getParentId());
				pstatement.setString(4,attendence.getAttendenceDate());
				pstatement.setString(5,attendence.getAttendenceStatus());
				
				
				pstatement.execute();
							
					
				result= true;
							
			}catch(Exception moae) {
				
				System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
			}finally {
				try{
					connection.close();
				}catch(Exception mo) {}	
			}
			return result;
		}

}
