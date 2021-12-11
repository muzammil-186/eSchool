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

import com.edu.vu.dao.InvoicesDao;
import com.edu.vu.dao.QuizResultsDao;
import com.edu.vu.dao.UserDao;
import com.edu.vu.model.Invoices;
import com.edu.vu.model.QuizResults;
import com.edu.vu.model.User;

@WebServlet("/ParentViewBillsController")
public class ParentViewBillsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDao();
	private InvoicesDao invoicesDao= new InvoicesDao();
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public ParentViewBillsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/ParentViewBills.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User parentUser = null;
		String invoiceTypeSelection =request.getParameter("paystat"); 
		boolean paymentDueOnly = invoiceTypeSelection.equalsIgnoreCase("Due");
		HttpSession sess= request.getSession(false);// Get current session
		String userName=(String) sess.getAttribute("userName");
		//String password=(String) sess.getAttribute("password");
		String studentId = request.getParameter("studentId");
		String studentGrade = request.getParameter("studentGrade");
		try {
			
			parentUser =  userDao.getUser(userName);//, password);
			User student = userDao.getUserByParent(studentId, parentUser.getId());
			List<Invoices> results = new ArrayList<Invoices>();
			results = invoicesDao.getAllInvoices(Integer.parseInt(studentId), parentUser.getId(), paymentDueOnly);
			request.setAttribute("invoices", results);
			request.getRequestDispatcher("/WEB-INF/views/Invoices.jsp").forward(request, response);
			
		}catch(Exception ignore4now) {
			System.out.println(ignore4now.getMessage());
		}
		
	}
}
