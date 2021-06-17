package com.student.controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.student.dao.AdminDAO;
import com.student.models.RegistrationModel;

/**
 * Servlet implementation class BulkUploadServlet
 */
@WebServlet("/bulkUpload")
@MultipartConfig
public class BulkUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String UPLOAD_DIRECTORY ="C:\\Users\\Abubakkar Sithick.G\\git\\Dynamic-Web-Project-Java-\\Student Management\\WebContent\\META-INF\\" ;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().println("Welcome");
		
		Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write("D:\\upload\\" + fileName);
	    }
	    String filePath = "D:\\upload\\" + fileName;
	    ArrayList<RegistrationModel> list = AdminDAO.BulkUploadFile(filePath);
	    try {
			AdminDAO.bulkInsert(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //response.getWriter().print("The file uploaded sucessfully.");
	    request.getRequestDispatcher("admin").include(request, response);
	  
	}
}
