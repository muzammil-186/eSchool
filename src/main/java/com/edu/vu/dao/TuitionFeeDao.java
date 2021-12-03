package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.vu.model.Faculty;
import com.edu.vu.model.TuitionFee;


public class TuitionFeeDao {
	
	/** 
	 * getTutionFee
	 * This method gets TuitionFee from the database and
	 * fills the model for TutionFee 
	 * @param TuitionFee
	 * @return TuitionFee object
	 * @throws ClassNotFoundException
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	public ArrayList <TuitionFee> getAllTuitionFee()throws ClassNotFoundException{
		ArrayList<TuitionFee> tuitionFeeList = new ArrayList<TuitionFee>();
		String GET_TUITIONFEE_SQL = "Select * from tuitionfee";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_TUITIONFEE_SQL);

			while(rs.next()) {
				TuitionFee currentTuitionFee = new TuitionFee();
				currentTuitionFee.setGrades(rs.getInt("GRADES"));
				currentTuitionFee.setFee(rs.getString("FEE"));
				currentTuitionFee.setMiscFee(rs.getString("MISC_FEE"));
				currentTuitionFee.setTuitionFeeRemark(rs.getString("TUITIONFEE_REMARK"));
				currentTuitionFee.setPayDueDate(rs.getString("PAY_DUEDATE"));
				
				tuitionFeeList.add(currentTuitionFee);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return tuitionFeeList;
	}
	


}
