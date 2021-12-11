package com.edu.vu.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.QuizResultsDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.QuizResults;
import com.edu.vu.model.User;

@WebServlet("/AddQuizResultController")
public class AddQuizResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuizResultsDao resultsDao = new QuizResultsDao();
	private UserDao userDao = new UserDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuizResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/AddQuizGrades.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		HttpSession sess= request.getSession(false);// Get current session
		String userName=(String) sess.getAttribute("userName");
		try {
			user =  userDao.getUser(userName);
			if(user.getRole().equalsIgnoreCase("faculty") && user.getStatus() == 0) {
				QuizResults result = new QuizResults();
				result.setStudentId(Integer.parseInt(request.getParameter("studentId")));
				result.setGrade(Integer.parseInt(request.getParameter("grade")));
				result.setParentId(request.getParameter("pnic"));
				result.setResultGrade(request.getParameter("grade"));
				result.setSubject(request.getParameter("subject"));
				result.setExamType(request.getParameter("extype"));
				result.setExamDate(request.getParameter("exdate"));
				resultsDao.addExamResult(result);
			}
	
			request.getRequestDispatcher("/WEB-INF/views/AddQuizGrades.jsp").forward(request, response);
		}catch(Exception ignore4now) {
			System.out.println(ignore4now.getMessage());
		}
		
	}


}
