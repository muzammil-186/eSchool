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
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.Attendence;
import com.edu.vu.model.Faculty;
import com.edu.vu.model.User;



@WebServlet("/AttendenceViewServlet")
public class AttendenceViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AttendenceDao attendDao = new AttendenceDao();
    private UserDao userDao = new UserDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendenceViewServlet() {
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
			//String password=(String) sess.getAttribute("password");
			user =  userDao.getUser(userName);//, password);
			
			List<Attendence> list = new ArrayList<Attendence>();
			list = attendDao.getAttendence(user.getId(), null, null);
			request.setAttribute("attendence", list);
		
			request.getRequestDispatcher("/WEB-INF/views/AttendenceView.jsp").forward(request, response);
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
