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






@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private final  int LOGGED_OUT = 0;
	/**
	 * No argument Constructor
	 */
	public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * doGet
	 * This method gets called by Tomcat after webServlet annotation is resolved
	 * Refer to line 19.In this method we present the user Login ui.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		HttpSession sess= request.getSession(false);// Get current session
		String userName=(String) sess.getAttribute("userName");
		String password=(String) sess.getAttribute("password");
		try {
			user =  userDao.getUser(userName, password);
			String id=user.getId();
			userDao.updateUserStatus(id, LOGGED_OUT);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/UserLogin.jsp");
			dispatcher.forward(request, response);
		}catch(Exception ignore4now) {}
	}

}
