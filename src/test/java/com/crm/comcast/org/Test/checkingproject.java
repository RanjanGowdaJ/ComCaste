package com.crm.comcast.org.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class checkingproject{
	@Test
  
	public void unittest() throws Throwable{
		Connection conn=null;
		String projectname="mazewa";
		try{
			
		
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		Statement creat = conn.createStatement();
		String qury = "select * from project";
		
		ResultSet result = creat.executeQuery(qury);
		boolean flag=false;
		while(result.next())
		{
			String actre = result.getString(4);
			if(actre.equals(projectname))
			{
				flag=true;
			}
		}
		Assert.assertTrue(flag);
	}catch (Exception e) {
		
	}finally
		{
		conn.close();
		System.out.println("db connection closed");
		}
	}
}
	
	
	
	
	
	
	
	
	

