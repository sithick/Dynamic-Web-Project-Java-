package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.student.models.RegistrationModel;

public class StudentDAO {
	
	@SuppressWarnings("deprecation")
	public static void insert(RegistrationModel model) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stat = conn.prepareStatement("insert into registerUser (first_name,last_name,email,gender,city,country,password,createdDate) values(?,?,?,?,?,?,?,?)");
		stat.setString(1, model.getFirstName());
		stat.setString(2, model.getLastName());
		stat.setString(3, model.getEmail());
		stat.setString(4, model.getGender());
		stat.setString(5, model.getCity());
		stat.setString(6, model.getCountry());
		stat.setString(7, model.getPassword());
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//		Date date = new Date();
		stat.setDate(8, new java.sql.Date(System.currentTimeMillis()));
		stat.executeUpdate();
		
	}

}
