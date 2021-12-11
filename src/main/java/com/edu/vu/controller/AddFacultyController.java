package com.edu.vu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.FacultyDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.Faculty;
import com.edu.vu.model.RegisteredStudent;
import com.edu.vu.model.User;


@WebServlet("/AddFacultyController")
public class AddFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private FacultyDao facultyDao = new FacultyDao();
	
	/**
	 * No argument Constructor
	 */
	public AddFacultyController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * doGet
	 * This method gets called by Tomcat after webServlet annotation is resolved
	 * Refer to line 19.In this method we present the user Login ui.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddFaculty.jsp");
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
			User user = null;
			
			HttpSession sess= request.getSession(false);// Get current session
			String userName=(String) sess.getAttribute("userName");
			user =  userDao.getUser(userName);
			RequestDispatcher dispatcher=null;
			if(user.getRole().equalsIgnoreCase("admin")){
				Faculty faculty = new Faculty();
				
				faculty.setFirstName(request.getParameter("FirstName"));
				faculty.setLastName(request.getParameter("lastName"));
				faculty.setEmployeeId(request.getParameter("nic"));
				faculty.setGrades(request.getParameter("grades"));
				faculty.setSubjects(request.getParameter("subjects"));
				faculty.setEmail(request.getParameter("email"));
				faculty.setStatus("active");// Status can be "admitted","suspended"
				facultyDao.addFaculty(faculty);
				dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddFaculty.jsp");
			}else {
				dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/AdminPage.jsp");
			}
			dispatcher.forward(request, response);
		}catch(Exception ignore4now) {
			System.out.println(ignore4now.getMessage());
		}	
		
	}

}
