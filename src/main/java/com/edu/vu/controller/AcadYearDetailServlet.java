package com.edu.vu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.vu.dao.AcadYearDao;
//import com.edu.vu.dao.TuitionFeeDao;
import com.edu.vu.model.AcadYear;
//import com.edu.vu.model.TuitionFee;


@WebServlet("/AcadYearDetailServlet")
public class AcadYearDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AcadYearDao acadYearDao = new AcadYearDao();
	/**
	 * No argument Constructor
	 */
	public AcadYearDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * doGet
	 * This method gets called by Tomcat after webServlet annotation is resolved
	 * Refer to line 16.In this method we present the user Login ui.
	 * @param <AcadYearInfo>
	 * @param <AcadYearlist>
	 * @param <AcadYear>
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//List<model or  datatype> list = new ArrayList<model or  datatype>();			
			List<AcadYear> list = new ArrayList<AcadYear>();
			list = acadYearDao.getAllAcadyear();
			request.setAttribute("academics", list);
		//	System.out.println("EnrhServlet-doGet we r here!!");
		//	String pathInfo = request.getPathInfo();
			request.getRequestDispatcher("/WEB-INF/views/AcadYear.jsp").forward(request, response);
		}catch(ClassNotFoundException cnfe) {}
	
		
	
	}
	/**
	 * 	doPost 
	 * 
	 * This method will get user input. You may write the user input into database using Dao class and the Model. 
	 * From here you can navigate any other page using dispatcher.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("EnrhServlet-doPost we r here!!:"+this.getServletContext().getContextPath());
   		//request.getRequestDispatcher("/WEB-INF/views/login/UserLogin.jsp").forward(request, response);

	
	}
}