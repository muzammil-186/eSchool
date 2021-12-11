package com.edu.vu.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.UserDao;
import com.edu.vu.model.User;



@WebServlet("/GoToClassServlet")
public class GoToClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = null;
		HttpSession sess= request.getSession(false);// Get current session
		String userName=(String) sess.getAttribute("userName");
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		hour = 8;
		int period = 0;
		switch(hour) {
		case 8:
			period = 1;
			break;
		case 9:
			period = 2;
			break;
		case 10:
			period = 3;
			break;
		case 11:
			period = 4;
			break;
		case 12:
			period = 5;
			break;
		case 13:
			period = 6;
			break;
		case 14:
			period = 7;
			break;
		case 15:
			period = 8;
			break;
		case 16:
			period = 1;
			break;
		default:
			period =1;
		}
		
		/*
		if(hour<8 || hour >16) {
			request.getRequestDispatcher("/WEB-INF/views/grades/NotInSession.jsp").forward(request, response);
			return;
		}
		*/
		try {
			user =  userDao.getUser(userName);
			int grade = user.getGrade();
			String strGrade = null;
			if(grade <9) {
				strGrade = "0"+grade;
			}
			String periodstr = null;
			if(hour <10) {
				periodstr = "session0";
			}else {
				periodstr = "session";
			}
			if(user.getRole().equalsIgnoreCase("Student")) {
				StringBuffer sb = new StringBuffer(24);
				sb.append("/WEB-INF/views/grades/grade").append(strGrade).append("/").append(periodstr).append(period).append("/").append("GoToClass.jsp");
				String url = sb.toString();
				System.out.println(url);
				request.getRequestDispatcher(url).forward(request, response);
				
			}
		}catch(Exception motherOfAllExceptions) {
			System.out.println(motherOfAllExceptions.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
