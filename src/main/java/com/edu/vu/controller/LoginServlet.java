package com.edu.vu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.vu.dao.UserDao;
import com.edu.vu.model.User;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	/**
	 * No argument Constructor
	 */
	public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * doGet
	 * This method gets called by Tomcat after webServlet annotation is resolved
	 * Refer to line 16.In this method we present the user Login ui.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/UserLogin.jsp");
		 dispatcher.forward(request, response);
	
	}
	/**
	 * 	doPost 
	 * 
	 * This method will get user input. You may write the user input into database using Dao class and the Model. 
	 * From here you can navigate any other page using dispatcher.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			user =  userDao.getUser(userName, password);
		
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/WEB-INF/views/userError.jsp");
			dispatcher.forward(request, response);
			
		} catch(Exception ignore4now) {}
	}
}
