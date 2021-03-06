package com.student.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AdminDAO;
import com.student.dao.StudentDAO;
import com.student.models.RegistrationModel;

/**
 * Servlet implementation class AddNewServlet
 */
@WebServlet("/addNew")
public class AddNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/AddNewView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		RegistrationModel registrationModel = new RegistrationModel();
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
			AdminDAO.insert(registrationModel);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//request.getRequestDispatcher("WEB-INF/views/ListView.jsp").include(request, response);
		response.sendRedirect("admin");
		
	}

}
