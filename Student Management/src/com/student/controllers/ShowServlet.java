package com.student.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AdminDAO;
import com.student.models.RegistrationModel;


@WebServlet("/show")
public class ShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>User Details</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        try {
			RegistrationModel model = AdminDAO.getUser(id);
			request.setAttribute("userDetail", model);
			//request.setAttribute("firstname",model.getFirstName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("WEB-INF/views/UserDetailsView.jsp").include(request, response);
	}


}
