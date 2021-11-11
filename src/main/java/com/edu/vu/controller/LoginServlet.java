package com.edu.vu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.UserDao;
import com.edu.vu.model.User;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private final  int LOGGED_IN = 1;
	
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
	 * Refer to line 19.In this method we present the user Login ui.
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
		// Get the current session , set username and password to it and later use it in the LogoutServlet
		HttpSession sess= request.getSession();
		sess.setAttribute("userName", userName);
		sess.setAttribute("password", password);
		
		RequestDispatcher dispatcher = null;
		try {
			user =  userDao.getUser(userName, password);
			String id=user.getId();
			if(user != null ) {
				String userRole = user.getRole();
				
				if(userRole.equalsIgnoreCase("Student")) {
					userDao.updateUserStatus(id, LOGGED_IN);
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/StudentPage.jsp");					
				}else if(userRole.equalsIgnoreCase("Parent")) {
					userDao.updateUserStatus(id, LOGGED_IN);
				    dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/ParentPage.jsp");					
				}else if(userRole.equalsIgnoreCase("Faculty")) {
					userDao.updateUserStatus(id, LOGGED_IN);
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/FacultyPage.jsp");					
				}else if(userRole.equalsIgnoreCase("Employee")) {
					userDao.updateUserStatus(id, LOGGED_IN);
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/AdminPage.jsp");					
				}else {
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/RoleNotFound.jsp");					
				}
			}
			dispatcher.forward(request, response);

			
		} catch(Exception ignore4now) {}
	}
}
