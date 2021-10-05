package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.vu.model.AcadYear;
import com.edu.vu.model.TuitionFee;

public class AcadYearDao {

	/*** 
	 * getAcademic Year Calendar
	 * This method gets Academic Year from the database and
	 * fills the model for AcadYear 
	 * @param AcadYear
	 * @return AcadYear
	 * @throws ClassNotFoundException
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
     */
     
     public ArrayList<AcadYear> getAllAcadyear()throws ClassNotFoundException{
		ArrayList<AcadYear> AcadYearList = new ArrayList<AcadYear>();
		String GET_ACADYEAR_SQL = "Select * from acadyear";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_ACADYEAR_SQL);

			while(rs.next()) {
				AcadYear currentAcadYear = new AcadYear();
				currentAcadYear.setGrades(rs.getInt("GRADES"));
				currentAcadYear.setSemesterStartDate(rs.getString("SEMST_DATE"));
				currentAcadYear.setRegDate(rs.getString("REG_DATE"));
				currentAcadYear.setSemesterBreak(rs.getString("SEMBR"));
				currentAcadYear.setFinalExamDate(rs.getString("FEXAM_DATE"));
				currentAcadYear.setResultDate(rs.getString("RSLT_DATE"));
				
				AcadYearList.add(currentAcadYear);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return AcadYearList;
	}
	


}



