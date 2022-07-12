package com.phamquanghuy.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.phamquanghuy.model.Model;

public class AbstractModel {
	public static Connection getConnnection() {
		String url = "jdbc:mysql://localhost:3306/ttcs";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		AbstractModel a = new AbstractModel();
		if(a.getConnnection()!=null) System.out.println("ok");
	}
}
