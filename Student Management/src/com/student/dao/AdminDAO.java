package com.student.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		//String joinSql = "SELECT RU.id RU.first_name, RU.last_name,RU.email,RU.gender,RU.city,RU.country,RU.password,UF.fileName FROM registeruser as RU INNER JOIN uploadedfiles as UF ON RU.id = UF.registeruserId";
		String sql = "select * from registerUser";
		String sqlJoin = "select id, first_name, last_name,email,gender,city,country,password,fileName from registerUser r inner join uploadedfiles u on r.id = u.registeruserId";
		String naturalJoin = "SELECT id, first_name, last_name,email,gender,city,country,password,fileName"
				+ " FROM registeruser"
				+ " LEFT OUTER JOIN uploadedfiles"
				+ " ON registeruser.id = uploadedfiles.registeruserId"
				+ " UNION"
				+ " SELECT id, first_name, last_name,email,gender,city,country,password,fileName"
				+ " FROM registeruser"
				+ " RIGHT OUTER JOIN uploadedfiles"
				+ " ON registeruser.id = uploadedfiles.registeruserId;";
		ResultSet rs=conn.createStatement().executeQuery(naturalJoin);
		while(rs.next()) {
			//lists.add(new RegistrationModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9)));
			//lists.add(new RegistrationModel(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("gender"), rs.getString("city"), rs.getString("country"), rs.getString("password"),rs.getString("fileName")));
			lists.add(new RegistrationModel(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("gender"), rs.getString("city"), rs.getString("country"), rs.getString("password"),rs.getString("fileName")));
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
	
	public static int delete (int id) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stat = conn.prepareStatement("delete from registerUser  where id = '"+id+"'");
		int res = stat.executeUpdate();
		return res;
	}
	
	public static ArrayList<RegistrationModel> BulkUploadFile(String path) throws IOException {
		ArrayList<RegistrationModel> list = new ArrayList<RegistrationModel>();
	
		BufferedReader buff = new BufferedReader(new FileReader(path));
		String str = "";
		while((str = buff.readLine()) !=null){
			String[] arr = str.split(",");
			list.add(new RegistrationModel(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));
		}
		return list;
	}
	
	public static void bulkInsert(ArrayList<RegistrationModel> list) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		for(RegistrationModel model : list) {
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
		conn.close();
		
	}
	public static void fileInsert(UploadModel model) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stat = conn.prepareStatement("insert into uploadedfiles (fileName,fullFilePath,fileType,registeruserId) values(?,?,?,?)");
		stat.setString(1, model.getFileName());
		stat.setString(2, model.getFilePath());
		stat.setString(3, model.getFileType());
		stat.setInt(4, model.getRegisteruserId());
		
		stat.executeUpdate();
	}

	public static UploadModel getUserFile(int id) throws ClassNotFoundException, SQLException {
		Connection conn = DbConnection.getConnection();
		
		String sql = "select fileId,fileName,fullFilePath,fileType,registeruserId from uploadedfiles where registeruserId = '"+id+"'";
		ResultSet rs=conn.createStatement().executeQuery(sql);
		UploadModel model = null;
		if(rs.next()) {
			model = new UploadModel(rs.getInt("fileId"), rs.getString("fileName"), rs.getString("fullFilePath"), rs.getString("fileType"), rs.getInt("registeruserId"));
		}
		return model;
		
	}
	
	public static boolean history(RegistrationModel model) throws IOException {
		FileWriter fileWriter = new FileWriter("C:\\Users\\Abubakkar Sithick.G\\git\\Dynamic-Web-Project-Java-\\Student Management\\WebContent\\files\\history.txt",true);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		String val = String.format("%-20s %-20s %-20s %-20s\n",model.getId(),model.getFirstName(),model.getStatus(),new Date());
		bWriter.write(val);
		//bWriter.newLine();
		bWriter.flush();
		bWriter.close();
		return true;
	}
}
