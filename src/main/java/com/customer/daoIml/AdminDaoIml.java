package com.customer.daoIml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.dao.AdminDao;
import com.customer.module.Admin;

public class AdminDaoIml  implements AdminDao{

	private static Connection connection =null;
	private Statement statement =null;
	private ResultSet res =null;
	private final static String SELECT_ALL_QUERY ="select * from `login`";
	public AdminDaoIml() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	 
	
	
	@Override
	public List<Admin> getAllUser() {
ArrayList<Admin> userList = new ArrayList();
		
		try {
			 statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  while(res.next()) {
				  int userId = res.getInt("UserId");
				  String admin = res.getString("UserName");
				  String password = res.getString("Password");
				  
				  Admin ad = new Admin(userId, admin, password);
				  userList.add(ad);
				  
				  
				  
					
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return userList;
	}

}
