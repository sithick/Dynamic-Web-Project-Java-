package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.student.models.RegistrationModel;

public class StudentDAO {
	
	
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
	
	public static RegistrationModel validUser(String mail,String psw) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		
		String sql = "select id,first_name,last_name,email,gender,city,country,password from registerUser where email = ? and password = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, mail);
		stmt.setString(2, psw);
		ResultSet rs=stmt.executeQuery();
		RegistrationModel model = null;
		if(rs.next()) {
			model = new RegistrationModel(rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("gender"), rs.getString("city"), rs.getString("country"), rs.getString("password"));
		}
		return model;
	}

}
