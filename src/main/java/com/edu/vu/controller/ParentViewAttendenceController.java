package com.edu.vu.controller;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.AttendenceDao;
import com.edu.vu.dao.QuizResultsDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.Attendence;
import com.edu.vu.model.QuizResults;
import com.edu.vu.model.User;

@WebServlet("/ParentViewAttendenceController")
public class ParentViewAttendenceController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AttendenceDao attendDao = new AttendenceDao();
	private UserDao userDao = new UserDao();
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public ParentViewAttendenceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/ParentViewAttendence.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User parentUser = null;
		HttpSession sess= request.getSession(false);// Get current session
		String userName=(String) sess.getAttribute("userName");
		//String password=(String) sess.getAttribute("password");
		String studentId = request.getParameter("studentId");
		String studentGrade = request.getParameter("studentGrade");
		try {
			
			parentUser =  userDao.getUser(userName);//, password);
			if(parentUser.getRole().equalsIgnoreCase("parent")) {
				User student = userDao.getUserByParent(studentId, parentUser.getId());
				List<Attendence> results = new ArrayList<Attendence>();
				results = attendDao.getAttendence(student.getId(), parentUser.getId(), null);
				request.setAttribute("attendence", results);
				
				request.getRequestDispatcher("/WEB-INF/views/AttendenceView.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/views/ParentViewAttendence.jsp").forward(request, response);
			}
			
			
		}catch(Exception ignore4now) {
			System.out.println(ignore4now.getMessage());
		}
		
	}
}
