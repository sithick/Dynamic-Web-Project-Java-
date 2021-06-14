package com.student.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import com.student.models.*;
public class AdminDAO {
	
	//List of all users
	public static List<RegistrationModel> list() throws Exception{
		ArrayList<RegistrationModel> lists = new ArrayList<RegistrationModel>();
		Connection conn = DbConnection.getConnection();
		
		String sql = "select * from registerUser";
		ResultSet rs=conn.createStatement().executeQuery(sql);
		if(rs.next()) {
			lists.add(new RegistrationModel(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("gender"), rs.getString("city"), rs.getString("country"), rs.getString("password")));
		}
		return lists;
		
	}
	
}
