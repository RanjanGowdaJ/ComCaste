package com.crm.comcast.org.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertQuery {
	public static void main(String[] args) throws Throwable {
	
			
		
		
		Driver driverref=new Driver();
		System.out.println("hii");
		DriverManager.registerDriver(driverref);
		System.out.println("hello");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("connection is done");
		Statement state = conn.createStatement();
		System.out.println("stmt created");
		
		String qry = "insert into project values('ty_proj_006','shankar','15/01/2022','signup','on going','05')";
		System.out.println("value inserted");
		
		int exe = state.executeUpdate(qry);
		
		System.out.println("qry done");
		conn.close();
		System.out.println("connection closed");
		
		
		
	}

}
