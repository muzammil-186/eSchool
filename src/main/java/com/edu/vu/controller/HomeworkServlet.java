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
import com.edu.vu.model.Attendence;
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
		try {
			User user = null;
			
			HttpSession sess= request.getSession(false);// Get current session
			String userName=(String) sess.getAttribute("userName");
			String password=(String) sess.getAttribute("password");
			user =  userDao.getUser(userName, password);
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy_HHmm").format(Calendar.getInstance().getTime());
			String justTheDate = timeStamp.substring(0, 10);
			List<HomeWork> list = new ArrayList<HomeWork>();
			list = assignDao.getAssignments(user.getGrade(), justTheDate);
			request.setAttribute("assignments", list);
		
			request.getRequestDispatcher("/WEB-INF/views/AssignmentsView.jsp").forward(request, response);
		}catch(Exception cnfe) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
