package com.edu.vu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.vu.dao.EmployeeDao;
import com.edu.vu.dao.ParentDao;
import com.edu.vu.dao.RegisteredStudentDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.Employee;
import com.edu.vu.model.Parent;
import com.edu.vu.model.RegisteredStudent;
import com.edu.vu.model.User;


/**
 * Servlet implementation class UserServlet
 * This Servlet provides controller functionality in the MVC pattern
 * It handles user registration.
 * 
 * @author Muzammil Ahmed
 * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
 * Virtual University ID MC180404448
 * @version 1.0 
 * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
 * 
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private RegisteredStudentDao studentDao = new RegisteredStudentDao();
	private ParentDao parentDao = new ParentDao();
	private EmployeeDao employeeDao = new EmployeeDao();
	//add parent and employee Dao
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UserRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User aUser = new User();// Creating Model to fill in from user entered data
		
		String variableRole =request.getParameter("roles"); 
		aUser.setRole(variableRole);
		String variableId =request.getParameter("id"); 
		aUser.setId(variableId);
		//To do add verification
		boolean result = false;
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
	
		aUser.setFirstName(firstName);
		aUser.setLastName(lastName);
		aUser.setPassword(password);
		aUser.setUserName(userName);
		aUser.setDob(request.getParameter("dob"));
		
		
		aUser.setVersion(0);
		aUser.setStatus(0);
		if (variableRole.equalsIgnoreCase("student")) {
			    aUser.setParentId(request.getParameter("pid"));
			    aUser.setGrade(Integer.parseInt(request.getParameter("grade")));
				result = isValidStudent(aUser);
        }else if(variableRole.equalsIgnoreCase("parent")) {
        	    result = isValidParent(aUser);	       
        }else if(variableRole.equalsIgnoreCase("employee") || variableRole.equalsIgnoreCase("admin")) {
        	    result = isValidEmployee(aUser);      
        }
			//End of verification
		if (result == true) {
			try {
				userDao.registerUser(aUser);
			}catch(Exception moae) {
				System.out.println("Encountered Exception:" + moae.getClass().getName()+ " With message:"+ moae.getMessage());
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userSuccess.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userError.jsp");
			dispatcher.forward(request, response);
		}
	}
	/**
	 * isValidStudent
	 * checks if the user exists in the database	
	 * @param userId
	 * @return true if user exists false otherwise
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	private boolean isValidStudent(User user) {
		boolean result = false;// result of method
		try {
			 RegisteredStudent regStudent = studentDao.getRegisteredStudent(user.getId());
			 if(regStudent == null) {
				 result = false;
			 }else {
				 result = regStudent.isUserSame(user);
				 				 
			 }
				 
		}catch(Exception ignore) {}
		
		
		return result;
	}
	
	/**
	 * isValidParent
	 * checks if the user exists in the database	
	 * @param userId
	 * @return true if user exists false otherwise
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	private boolean isValidParent(User user) {
		boolean result = false;// result of method
		try {
			 Parent parent = parentDao.getParent(user.getId());
			 if(parent == null) {
				 result = false;
			 }else {
				 result = parent.isUserSame(user);
				 
			   }
				 
	       	}catch(Exception ignore) {}
		
		
		return result;
	}

	/**
	 * isValidEmployee
	 * checks if the user exists in the database	
	 * @param userId
	 * @return true if user exists false otherwise
	 * 
	 * @author Muzammil Ahmed
     * Project Advisor Humaira Naeem    (humairanaeem@vu.edu.pk)
     * Virtual University ID MC180404448
     * @version 1.0 
     * Copyright (C) 2021 Muzammil Ahmed. All Rights Reserved.
	 */
	private boolean isValidEmployee(User user) {
		boolean result = false;// result of method
		try {
			 Employee employee = employeeDao.getEmployee(user.getId());
			 if(employee == null) {
				 result = false;
			 }else {
				 result = employee.isUserSame(user);
				 
			 }
				 
		}catch(Exception ignore) {}
		
		
		return result;
	}
}
