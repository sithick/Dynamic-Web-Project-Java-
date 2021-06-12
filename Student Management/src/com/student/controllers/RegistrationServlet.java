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


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//Registration model Object initialization
	private RegistrationModel registrationModel = null;
    //Get method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/RegistrationView.jsp");
		dispatcher.forward(request, response);
	}

	//Post method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//values get from user and stored.
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String password = request.getParameter("password");
		
		//Object creation
		registrationModel = new RegistrationModel();
		//set values to RegistrationModel.
		registrationModel.setFirstName(firstName);
		registrationModel.setLastName(lastName);
		registrationModel.setEmail(email);
		registrationModel.setGender(gender);
		registrationModel.setCity(city);
		registrationModel.setCountry(country);
		registrationModel.setPassword(password);
		
		System.out.println(registrationModel);
		try {
			StudentDAO.insert(registrationModel);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/LoginView.jsp");
		dispatcher.forward(request, response);
	}

}
