package com.student.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AdminDAO;
import com.student.models.RegistrationModel;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			int userId = Integer.parseInt(id);
			RegistrationModel model = AdminDAO.getUser(userId);
			model.setStatus("Logout");
			AdminDAO.history(model);
			
			Cookie cookie = new Cookie("username","");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("login").forward(request, response);
	}

}
