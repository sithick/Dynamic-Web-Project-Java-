package com.student.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.student.models.*;
public class AdminDAO {
	
	//List of all users
	public static ArrayList<RegistrationModel> list() throws Exception{
		ArrayList<RegistrationModel> lists = new ArrayList<RegistrationModel>();
		Connection conn = DbConnection.getConnection();
		
		String sql = "select * from registerUser";
		ResultSet rs=conn.createStatement().executeQuery(sql);
		while(rs.next()) {
			lists.add(new RegistrationModel(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("gender"), rs.getString("city"), rs.getString("country"), rs.getString("password")));
		}
		return lists;
		
	}

	public static RegistrationModel getUser(int id) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		
		String sql = "select * from registerUser where id = '"+id+"'";
		ResultSet rs=conn.createStatement().executeQuery(sql);
		RegistrationModel model = null;
		if(rs.next()) {
			model = new RegistrationModel(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("gender"), rs.getString("city"), rs.getString("country"), rs.getString("password"));
		}
		return model;
	}

	public static void update(RegistrationModel model) throws Exception {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stat = conn.prepareStatement("update registerUser set first_name = ?,last_name = ?,email = ?,gender = ?,city = ?,country = ?,password = ? where id = ?;");
		stat.setString(1, model.getFirstName());
		stat.setString(2, model.getLastName());
		stat.setString(3, model.getEmail());
		stat.setString(4, model.getGender());
		stat.setString(5, model.getCity());
		stat.setString(6, model.getCountry());
		stat.setString(7, model.getPassword());
		stat.setInt(8, model.getId());
		stat.executeUpdate();
		
	}

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
		stat.setDate(8, new java.sql.Date(System.currentTimeMillis()));
		stat.executeUpdate();
		
	}
	
	public static void delete (int id) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stat = conn.prepareStatement("delete from registerUser  where id = '"+id+"'");
		stat.executeUpdate();
	}
	
}
