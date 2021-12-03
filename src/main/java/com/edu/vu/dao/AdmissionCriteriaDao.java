package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.vu.model.AdmissionCriteria;
import com.edu.vu.model.Faculty;
import com.edu.vu.model.TuitionFee;

public class AdmissionCriteriaDao {
	
	/** 
	 * getAdmissionCriteria
	 * This method gets AdmissionCriteria from the database and
	 * fills the model for AdmissionCriteria 
	 * @param AdmissionCriteria
	 * @return AdmissionCriteria object
	 * @throws ClassNotFoundException
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */	
	
	public ArrayList <AdmissionCriteria> getAllAdmissionCriteria()throws ClassNotFoundException{
	
		ArrayList<AdmissionCriteria> admissionCriteriaList = new ArrayList<AdmissionCriteria>();
	
		String GET_ADMISSIONCRITERIA_SQL = "Select * from ADMISSION_CRITERIA";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
	
			ResultSet rs = statement.executeQuery(GET_ADMISSIONCRITERIA_SQL);

			while(rs.next()) {
			
				AdmissionCriteria currentAdmissionCriteria = new AdmissionCriteria();
		
				currentAdmissionCriteria.setClassLevel(rs.getInt("CLASS_Level"));
				currentAdmissionCriteria.setAge(rs.getString("AGE"));
				currentAdmissionCriteria.setEligibleCriteria(rs.getString("ELIGIBLE_CRITERIA"));
				currentAdmissionCriteria.setParentNic("PARENT_NIC");
								
				admissionCriteriaList.add(currentAdmissionCriteria);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return admissionCriteriaList;
	}
	


}
