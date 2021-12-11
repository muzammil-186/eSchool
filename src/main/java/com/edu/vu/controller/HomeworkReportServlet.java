package com.edu.vu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.AssignmentsDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.HomeWork;
import com.edu.vu.model.User;



@WebServlet("/HomeworkReportServlet")
public class HomeworkReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssignmentsDao assignDao = new AssignmentsDao();
	private UserDao userDao = new UserDao();
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeworkReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("/WEB-INF/views/HomeworkReport.jsp").forward(request, response);
						
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = null;
		try {
			HttpSession sess= request.getSession(false);// Get current session
			String userName=(String) sess.getAttribute("userName");
			user =  userDao.getUser(userName);//, password);
			
			if(user.getRole().equalsIgnoreCase("faculty") && user.getStatus() == 0) {
				List <HomeWork> assignments = new ArrayList<HomeWork>();
				int grade = Integer.parseInt(request.getParameter("grade"));
				String subject = request.getParameter("subject");
				String assignDate = request.getParameter("assigndate");
				
				
				assignments =assignDao.getAssignmentsBySubject(grade, subject, assignDate);
				request.setAttribute("assignments", assignments);
				request.getRequestDispatcher("/WEB-INF/views/AssignmentReport.jsp").forward(request, response);
				
			}
			
			
		}catch(Exception cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
	}

}
