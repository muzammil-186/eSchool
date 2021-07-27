package com.edu.vu.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 * 
 * @author Muzammil Ahmed
 * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
 * Virtual University ID MC180404448
 * @version 1.0 
 * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/homePage.jsp");
		//dispatcher.forward(request, response);
		System.out.println("HomePageServlet-doGet");
		String pathInfo = request.getPathInfo();
		request.getRequestDispatcher("/WEB-INF/views/homePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
