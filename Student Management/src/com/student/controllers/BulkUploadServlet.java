package com.student.controllers;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class BulkUploadServlet
 */
@WebServlet("/bulkUpload")
@MultipartConfig
public class BulkUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY ="C:\\Users\\Abubakkar Sithick.G\\git\\Dynamic-Web-Project-Java-\\Student Management\\WebContent\\META-INF\\" ;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Welcome");
		
		//String filePath = request.getParameter("file");
		//Part part = request.getPart("file");
		
		/*
		 * for (Part part : request.getParts()) { String fileName =
		 * extractFileName(part); // refines the fileName in case it is an absolute path
		 * fileName = new File(fileName).getName(); part.write(savePath + File.separator
		 * + fileName); }
		 * 
		 * String fileName = part.getSubmittedFileName();
		 */
	}
}
