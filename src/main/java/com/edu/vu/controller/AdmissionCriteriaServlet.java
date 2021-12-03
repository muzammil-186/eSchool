package com.edu.vu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.vu.dao.FacultyDao;
import com.edu.vu.dao.TuitionFeeDao;
import com.edu.vu.dao.AdmissionCriteriaDao;

import com.edu.vu.model.Course;
import com.edu.vu.model.Faculty;
import com.edu.vu.model.TuitionFee;
import com.edu.vu.model.AdmissionCriteria;

/**
 * Servlet implementation class AdmissionCriteriaServlet
 * 
 * @author Muzammil Ahmed
 * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
 * Virtual University ID MC180404448
 * @version 1.0 
 * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
 */
@WebServlet("/AdmissionCriteriaServlet")
public class AdmissionCriteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//  private TuitionFeeDao tuitionFeeDao = new TuitionFeeDao();
	private AdmissionCriteriaDao admissionCriteriaDao = new AdmissionCriteriaDao();
	
	public AdmissionCriteriaServlet() {
        super();
         // TODO Auto-generated constructor stub
    }

	/**
	 * doGet
	 * This method gets called by Tomcat after webServlet annotation is resolved
	 * Refer to line 16.In this method we present the user Login ui.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			  List<AdmissionCriteria> list = new ArrayList<AdmissionCriteria>();
		
			  list = admissionCriteriaDao.getAllAdmissionCriteria();
		
			  request.setAttribute("admissions", list);
		
			  request.getRequestDispatcher("/WEB-INF/views/AdmissionCriteria.jsp").forward(request, response);
		}catch(ClassNotFoundException cnfe) {}
	
		
	
	}
	/**
	 * 	doPost 
	 * 
	 * This method will get user input. You may write the user input into database using Dao class and the Model. 
	 * From here you can navigate any other page using dispatcher.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("EnrhServlet-doPost we r here!!:"+this.getServletContext().getContextPath());
   		//request.getRequestDispatcher("/WEB-INF/views/login/UserLogin.jsp").forward(request, response);

	}
	
	
}

		
		

