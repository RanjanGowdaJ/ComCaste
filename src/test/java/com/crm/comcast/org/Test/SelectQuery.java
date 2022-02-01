package com.crm.comcast.org.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQuery {
	public static void main(String[] args) throws Throwable  {
		Connection conn=null;
		
	  try{
		  Driver driveref=new Driver();
		  DriverManager.registerDriver(driveref);
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	System.out.println("hii how r u");
	Statement stmt = conn.createStatement();
	String qury = "select * from project";
	ResultSet qu1 = stmt.executeQuery(qury);
	  while(qu1.next())
	  {
		  System.out.println(qu1.getString(1)+"\t"+qu1.getString(2)+"\t"+qu1.getString(3)+"\t"+qu1.getString(4));
	  }
	  }
	  catch(Exception e)
	  {
	  }
	  finally
	  {
		  conn.close();
		  System.out.println("sry i am not gud");
	  }
	 
	  }
}
