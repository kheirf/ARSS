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
	
	
	
	public void search(String uname, char [] password, int role) throws SQLException
	{
		String getPass;
		String convertedPass = new String(password);
		ResultSet rs = null;
		
		switch(role)
		{
		case 1:
			rs = stm.executeQuery("SELECT password FROM administrator WHERE ID = '" + uname + "'");
			break;
		case 2:
			rs = stm.executeQuery("SELECT password FROM clerk WHERE ID = '" + uname + "'");
			break;
		case 3:
			rs = stm.executeQuery("SELECT password FROM mechanic WHERE ID = '" + uname + "'");
			break;
		}
		
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
	
	void addStaff()
	{
		
	}
	
}
