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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        int res = 0;
		try {
			res = AdminDAO.delete(id);
			System.out.println(res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("WEB-INF/views/ListView.jsp").include(request, response);
		//response.sendRedirect("admin");
		if(res > 0) {
		response.getWriter().println("<div class='alert alert-success' role='alert' style='text-align: center'>"
				+ "<b>Successfully Removed !</b>"
				+ "</div>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/ListView.jsp");
        dispatcher.include(request, response);
		}
		else {
			response.getWriter().println("<div class='alert alert-danger' role='alert' style='text-align: center'>"
					+ "<b>Sorry Can't Removed !</b>"
					+ "</div>");
			//response.sendRedirect("admin");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
