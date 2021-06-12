package com.student.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		if(useremail.equals("sithickbe99@gmail.com") && userpassword.equals("sithick@123")) {
			response.getWriter().println("Welcome "+useremail);
		}
	}

}
