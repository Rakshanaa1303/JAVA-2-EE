package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Prg2_passenger_class {
	
	public ArrayList getAllPassengers(String dest)
	{
		ArrayList al = new ArrayList();
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String jdbcURL = "jdbc:oracle:thin:127.0.0.1:1521:orcl";
		String username = "scott";
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(jdbcURL, username, password);
		
		PreparedStatement psmt = con.prepareStatement("SELECT * FROM PASSENGERS WHERE DESTINATION=?");
		
		psmt.setString(1, dest);
		ResultSet rs = psmt.executeQuery();
		
		
		while(rs.next()) 
		{
			String fname = rs.getString(1);
			String lname = rs.getString(2);
			String source = rs.getString(3);
			String des = rs.getString(4);
			String gen = rs.getString(5);
			
			Prg2_passengerVO pvo = new Prg2_passengerVO();
			
			pvo.setFirstname(fname);
			pvo.setLastname(lname);
			pvo.setSource(source);
			pvo.setDestination(des);
			pvo.setGender(gen);
			
			al.add(pvo);
		}	
		
		rs.close();
		psmt.close();
		con.close();
	}
		catch(SQLException sq)
		{
			System.out.println("SQLException");
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println("ClassNotFoundException"+ce.getMessage());
		}
		return al;
	}
}
