package com.student.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.models.RegistrationModel;
import com.student.dao.*;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update User</h1>");  
        String sid=request.getParameter("id");  
        HttpSession session = request.getSession();
        session.setAttribute("sId", sid);
        int id=Integer.parseInt(sid);
        RegistrationModel model = null;
		try {
			model = AdminDAO.getUser(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.print("<form action='edit' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Id</td><td><input type='hidden' name='id' value='"+model.getId()+"'/></td></tr>");
        out.print("<tr><td>First Name</td><td><input type='text' name='first_name' value='"+model.getFirstName()+"'/></td></tr>");  
        out.print("<tr><td>Last Name:</td><td><input type='text' name='last_name' value='"+model.getLastName()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+model.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Gender:</td><td>");
        out.print("<select name='gender'>"); 
        out.print("<option>Female</option>"); 
        out.print("<option>Male</option>"); 
        out.print("</select>");
        out.print("<tr><td>City:</td><td><input type='text' name='city' value='"+model.getCity()+"'/></td></tr>");
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+model.getPassword()+"'</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
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
		HttpSession session=request.getSession(false);  
        int nId=Integer.parseInt((String)session.getAttribute("sId"));  
		registrationModel.setId(nId);
		registrationModel.setFirstName(firstName);
		registrationModel.setLastName(lastName);
		registrationModel.setEmail(email);
		registrationModel.setGender(gender);
		registrationModel.setCity(city);
		registrationModel.setCountry(country);
		registrationModel.setPassword(password);
		
		System.out.println(registrationModel);
		try {
			AdminDAO.update(registrationModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("admin"); 
        
        
	}
}
