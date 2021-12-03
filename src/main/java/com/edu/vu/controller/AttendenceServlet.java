package com.edu.vu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vu.dao.AttendenceDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.Attendence;
import com.edu.vu.model.User;





@WebServlet("/AttendenceServlet")
public class AttendenceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AttendenceDao attendenceDao = new AttendenceDao();
	private UserDao userDao = new UserDao();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AttendenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = null;
		Attendence attendence = new Attendence();
		HttpSession sess= request.getSession(false);// Get current session
		String userName=(String) sess.getAttribute("userName");
		String password=(String) sess.getAttribute("password");
		try {
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy_HHmm").format(Calendar.getInstance().getTime());
			String justTheDate = timeStamp.substring(0, 10);
			user =  userDao.getUser(userName, password);
			attendence.setAttendenceDate(justTheDate);// to add time validation
			attendence.setAttendenceStatus("P");
			attendence.setGrade(user.getGrade());
			attendence.setParentId(user.getParentId());
			attendence.setStudentId(Integer.parseInt(user.getId()));
			if(attendenceNotDoneForTheDay(user.getId(), justTheDate)) {
				attendenceDao.registerAttendence(attendence);
			}
			
		}catch(Exception ignore4now) {}
		request.getRequestDispatcher("/WEB-INF/views/login/StudentPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private boolean attendenceNotDoneForTheDay(String studentId, String date) throws Exception{
		boolean result = true;//this will prevent duplicate record exception from database
		ArrayList<Attendence> attendList = new ArrayList<Attendence>();
		attendList = attendenceDao.getAttendence(studentId, null, date);
		result = attendList.isEmpty();
		
		return result;
	}
}
