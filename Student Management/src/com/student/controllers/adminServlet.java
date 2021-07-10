package com.student.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.student.dao.AdminDAO;


@WebServlet("/admin")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Cookie[] ck = request.getCookies();
			if(ck != null && ! ck[0].getValue().equals("")) {
			System.out.println(AdminDAO.list());
			request.setAttribute("list", AdminDAO.list());
			request.setAttribute("user", request.getParameter("id"));
			System.out.println(AdminDAO.list());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ListView.jsp");
			dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/LoginView.jsp");
				dispatcher.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
