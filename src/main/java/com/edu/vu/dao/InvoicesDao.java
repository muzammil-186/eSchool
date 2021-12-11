package com.edu.vu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.vu.model.Faculty;
import com.edu.vu.model.Invoices;



public class InvoicesDao {
	/** 
	 * getInvoice
	 * 
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	public ArrayList <Invoices> getAllInvoices(int studentId, String parentId, boolean outStandingOnly)throws ClassNotFoundException{
		ArrayList<Invoices> invoiceList = new ArrayList<Invoices>();
		StringBuffer sb = new StringBuffer(16);
		
		//Select * from Invoices where studentid=1001 and parentId='9999';
		sb.append("Select * from Invoices where studentid=").append(studentId).append(" ").append("AND parentId=").append('\'').append(parentId).append('\'');
		if(outStandingOnly) {
			sb.append(" ").append("AND PAYSTATUS=").append('\'').append("DUE").append('\'');
		}
		String GET_INV_SQL = sb.toString();
		System.out.println(GET_INV_SQL);
		
		
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/eschool?allowPublicKeyRetrieval=true&useSSL=false", "root", "abc123");
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_INV_SQL);

			while(rs.next()) {
				Invoices currentInvoice = new Invoices();
				currentInvoice.setId(rs.getString("ID"));
				currentInvoice.setStudentId(rs.getInt("STUDENTID"));
				currentInvoice.setGrade(rs.getInt("GRADE"));
				currentInvoice.setParentId(rs.getString("PARENTID"));
				currentInvoice.setInvoiceType(rs.getString("INVOICETYPE"));
				currentInvoice.setAmount(rs.getInt("AMOUNT"));
				currentInvoice.setDescription(rs.getString("DESCR"));
				currentInvoice.setInvoiceDate(rs.getString("INVOICEDATE"));
				currentInvoice.setDueDate(rs.getString("DUEDATE"));
				currentInvoice.setPaymentstatus(rs.getString("PAYSTATUS"));
				invoiceList.add(currentInvoice);
			}
			rs.close();
		}catch(Exception moae) {
			System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
		}finally {
			try {
				connection.close();
			}catch(Exception ignore) {}
		}
		return invoiceList;
	}
	
	
}
