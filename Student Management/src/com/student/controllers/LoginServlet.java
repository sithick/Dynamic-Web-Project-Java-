package com.student.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.models.RegistrationModel;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    //Get method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/LoginView.jsp");
		dispatcher.forward(request, response);
	}

	//Post method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");
		System.out.println(useremail +" "+userpassword);
		try {
			RegistrationModel modal = StudentDAO.validUser(useremail,userpassword);
			if(modal != null) {
				if(modal.getFirstName().equals("admin")) {
					response.sendRedirect("admin");
				}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserDetailsView.jsp");
		        request.setAttribute("userDetail", modal);
		        dispatcher.forward(request, response);
				}
			}
			else {
				response.getWriter().println("<div class='alert alert-danger' role='alert' style='text-align: center'>"
						+ "<b>Sorry UserName or Password Error!</b>"
						+ "</div>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/LoginView.jsp");
		        dispatcher.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
