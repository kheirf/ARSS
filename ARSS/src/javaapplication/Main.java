package javaapplication;

import java.sql.*;

public class Main 
{
	private static String jdbcdriver = "com.mysql.jdbc.Driver";
	private static Connection con;
	private static Statement stm;
	
	Main() throws ClassNotFoundException, SQLException
	{
		Class.forName(jdbcdriver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		stm = con.createStatement();
	}
	
	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		//Statement stm = con.createStatement();
		
		//String findThis = "1000";
		//String found = "";
		
		ResultSet rs = stm.executeQuery("SELECT * from administrator");
		
		while (rs.next())
		{
			//found = rs.getString(1);		
			
			System.out.print(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\n");
			
		}	
		
		rs.close();
		stm.close();
		con.close();
		
	}*/
	
	public void search(String uname, char [] password) throws SQLException
	{
		String getPass;
		String convertedPass = new String(password);
		ResultSet rs = stm.executeQuery("SELECT password FROM administrator WHERE AdminID = '" + uname + "'");
		if(rs.next())
		{
			getPass = rs.getString(1);
			if(convertedPass.equals(getPass))
			{
				System.out.println("Correct");
			}
			else
				System.out.println("Incorect");
		}
		else
			System.out.println("No data found");
		
		rs.close();
		stm.close();
		con.close();
	}
}
