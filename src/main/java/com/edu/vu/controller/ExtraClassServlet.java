package com.edu.vu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.vu.dao.ExtraClassesDao;
import com.edu.vu.model.Course;


@WebServlet("/ExtraClassServlet")
public class ExtraClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExtraClassesDao courseDao = new ExtraClassesDao();

	/**
	 * No argument Constructor
	 */
	public ExtraClassServlet() {
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
			List<Course> list = new ArrayList<Course>();
			list = courseDao.getCourses("ENRICHMENT");
			request.setAttribute("courses", list);
		//	System.out.println("EnrhServlet-doGet we r here!!");
		//	String pathInfo = request.getPathInfo();
			request.getRequestDispatcher("/WEB-INF/views/ExtraClasses.jsp").forward(request, response);
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
   		request.getRequestDispatcher("/WEB-INF/views/login/UserLogin.jsp").forward(request, response);

	}
}
