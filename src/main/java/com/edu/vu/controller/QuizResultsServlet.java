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

import com.edu.vu.dao.QuizResultsDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.User;
import com.edu.vu.model.QuizResults;

@WebServlet("/QuizResultsServlet")
public class QuizResultsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private QuizResultsDao resultsDao = new QuizResultsDao();
	private UserDao userDao = new UserDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizResultsServlet() {
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
		//String password=(String) sess.getAttribute("password");
		try {
			user =  userDao.getUser(userName);//, password);
			List<QuizResults> results = new ArrayList<QuizResults>();
			results = resultsDao.getExamResults(Integer.parseInt(user.getId()), user.getGrade(), null, null, null);
			request.setAttribute("results", results);
			request.getRequestDispatcher("/WEB-INF/views/QuizResults.jsp").forward(request, response);
		}catch(Exception ignore4now) {
			System.out.println(ignore4now.getMessage());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
