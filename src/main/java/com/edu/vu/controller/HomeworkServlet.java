package com.edu.vu.controller;

import java.io.IOException;
import java.net.URL;
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


@WebServlet("/HomeworkServlet")
public class HomeworkServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private AssignmentsDao assignDao = new AssignmentsDao();
	private UserDao userDao = new UserDao();
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeworkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		
		HttpSession sess= request.getSession(false);// Get current session
		String userName=(String) sess.getAttribute("userName");
		String domain = request.getRequestURL().toString(); 
		try {
			user =  userDao.getUser(userName);
			if(user.getRole().equalsIgnoreCase("faculty") && user.getStatus() == 0) {
				
				request.getRequestDispatcher("/WEB-INF/views/AddAssignmentsView.jsp").forward(request, response);
				
			}else if(user.getRole().equalsIgnoreCase("Student") && user.getStatus() == 0) {
				request.getRequestDispatcher("/WEB-INF/views/AssignmentsView.jsp").forward(request, response);
			}
			
		}catch(Exception cnfe) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateFrom = null;
		String dateTo = null;
		
		
		User user = null;
		try {
			HttpSession sess= request.getSession(false);// Get current session
			String userName=(String) sess.getAttribute("userName");
			user =  userDao.getUser(userName);//, password);
			
			if(user.getRole().equalsIgnoreCase("faculty") && user.getStatus() == 0) {
				HomeWork hw = new HomeWork();
				hw.setGrade(Integer.parseInt(request.getParameter("grade")));
				hw.setSubject(request.getParameter("subject"));
				hw.setAssignDate(request.getParameter("assigndate"));
				hw.setDueDate(request.getParameter("duedate"));
				hw.setTask(request.getParameter("task"));
				assignDao.addAssignment(hw);
				request.getRequestDispatcher("/WEB-INF/views/AddAssignmentsView.jsp").forward(request, response);
				
			}else if(user.getRole().equalsIgnoreCase("student") && user.getStatus() == 0) {
				dateFrom = request.getParameter("from");
				dateTo = request.getParameter("to");//to add validation if date is in right format and sequence
				String justTheDate = dateFrom;
				
				if(dateFrom.length()==0 && dateTo.length() == 0) {
					String timeStamp = new SimpleDateFormat("MM/dd/yyyy_HHmm").format(Calendar.getInstance().getTime());
					justTheDate = timeStamp.substring(0, 10);
				}
				List<HomeWork> list = new ArrayList<HomeWork>();
				list = assignDao.getAssignments(user.getGrade(), dateFrom, dateTo);
				request.setAttribute("assignments", list);
				request.getRequestDispatcher("/WEB-INF/views/AssignmentReport.jsp").forward(request, response);
			}
			
			
		}catch(Exception cnfe) {}
		
	}

}
