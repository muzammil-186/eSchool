package com.edu.vu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.ParentDao;
import com.edu.vu.dao.RegisteredStudentDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.RegisteredStudent;
import com.edu.vu.model.User;





@WebServlet("/AddAdmissionServlet")
public class AddAdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisteredStudentDao regStudentDao= new RegisteredStudentDao();
	
	
	/**
	 * No argument Constructor
	 */
	public AddAdmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * doGet
	 * This method gets called by Tomcat after webServlet annotation is resolved
	 * Refer to line 19.In this method we present the user Login ui.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/AddAdmissionCriteria.jsp");
		 dispatcher.forward(request, response);
	
	}
	/**
	 * 	doPost 
	 * 
	 * This method will get user input. You may write the user input into database using Dao class and the Model. 
	 * From here you can navigate any other page using dispatcher.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RegisteredStudent student = new RegisteredStudent();
			//student.setStudentId("0");
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			student.setDob(request.getParameter("dob"));
			student.setGrade(Integer.parseInt(request.getParameter("grade")));
			student.setParentId(request.getParameter("pnic"));
			student.setStatus("admitted");// Status can be "admitted","suspended"
			regStudentDao.addRegisteredStudent(student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/AddAdmissionCriteria.jsp");
			dispatcher.forward(request, response);
		}catch(Exception ignore4now) {}	
		
	}
}
