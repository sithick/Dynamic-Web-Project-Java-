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
import com.student.models.UploadModel;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>User Details</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        try {
			RegistrationModel model = AdminDAO.getUser(id);
			UploadModel uploadModel = AdminDAO.getUserFile(id);
			//model.setUploadModel(uploadModel);
			//System.out.println(model);
			request.setAttribute("userDetail", model);
			//request.setAttribute("fileName", model.getUploadModel().getFileName());
			//System.out.println("hi" + request.getAttribute("fileName"));
			request.setAttribute("firstname",model.getFirstName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("WEB-INF/views/UserDetailsView.jsp").include(request, response);
	}


}
