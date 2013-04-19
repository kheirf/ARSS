package javaapplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
	private static String jdbcdriver = "com.mysql.jdbc.Driver";
	private static Connection con;
	private static Statement stm;
	
	Main() throws ClassNotFoundException, SQLException
	{
		openConnection();
	}
	
	void openConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName(jdbcdriver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		stm = con.createStatement();
	}
	
	String identifyRole(int role)
	{
		String Role = null;
		switch(role)
		{
		case 1:
			Role = "Administrator";
			break;
		case 2:
			Role = "Clerk";
			break;
		case 3:
			Role = "Mechanic";
			break;
		}
		return Role;
	}
	//Search for login
	protected int search(String uname, char [] password, int role) throws SQLException
	{
		String getPass;
		String convertedPass = new String(password);
		ResultSet rs = null;
		int returnThis;
		
		rs = stm.executeQuery("SELECT password FROM " + identifyRole(role) + " WHERE ID = '" + uname + "'");
		
		if(rs.next())
		{
			getPass = rs.getString(1);
			if(convertedPass.equals(getPass))
				returnThis = 1;
			else
				returnThis = 2;
		}
		else			
		    returnThis = 3;		    
		
		rs.close();
		closeConnection();
		return returnThis;
	}
	
	
	/*List<String> getActivityList(String uid)
	{
		String [] thisList1;
		ArrayList<String> thisList2 = new ArrayList<String>();
		ResultSet rs;
		
		try 
		{
			openConnection();
			rs = stm.executeQuery("SELECT * FROM sessionlog WHERE ID = " + uid);
			rs.last();
			int lastRow = rs.getRow();
			rs.first();
			thisList1[0] = rs.getString(1);
			thisList1[1] = rs.getString(2);
			thisList1[2] = rs.getString(3);
			thisList1[3] = rs.getString(4);
			thisList1[4] = rs.getString(5);
			
			for(int i = 1; i < lastRow; i++)
			{
				if(rs.next())
				{
					for(int j = 1; j < 6; j++)
					{
						thisList1.add(rs.getString(i));
					}
				}
				thisList2.add(thisList1);
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) {e.printStackTrace();} 
			
		return null;
	}*/
	
	String[] getContentsList()throws SQLException
	{
		ResultSet rs = null;
		String[] list = null;
		try {
			openConnection();
			rs = stm.executeQuery("SELECT * FROM administrator UNION SELECT * FROM clerk UNION SELECT * FROM Mechanic");
			
			rs.last();
			int lastRow = rs.getRow();
			list = new String[lastRow];
			rs.first();
			list[0] = rs.getString(1);
			for(int i = 1; i < lastRow; i++)
			{
				if(rs.next())
					list[i] = rs.getString(1);
			}
			rs.close();
			//closeConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
		
		
		return list;
	}
	
	List<String> searchForID(String ID)
	{
		ResultSet rs;
		List<String> list = new ArrayList<String>();
		try 
		{
			openConnection();
			if((rs = stm.executeQuery("SELECT * FROM administrator WHERE ID = " + ID)).next())
			{
				for (int i = 1; i <= 7; i++)
				{
					list.add(rs.getString(i));
				}
				list.add("1");
			}
			else
				if((rs = stm.executeQuery("SELECT * FROM clerk WHERE ID = " + ID)).next())
				{
					for (int i = 1; i <= 7; i++)
					{
						list.add(rs.getString(i));
					}
					list.add("2");
				}
				else
					if((rs = stm.executeQuery("SELECT * FROM mechanic WHERE ID = " + ID)).next())
					{
						for (int i = 1; i <= 7; i++)
						{
							list.add(rs.getString(i));
						}
						list.add("3");
					}
			rs.close();
			closeConnection();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{e.printStackTrace();}

		return list;	
	}
	
	
	
	//update rows in staff
	int updateStaff(int role, List<String> list)
	{
		int returnThis = -1;
		String Role = identifyRole(role);
		try 
		{
			openConnection();
			returnThis = stm.executeUpdate("UPDATE " + Role + " SET fname = \"" + list.get(1) + "\", sname = \"" + list.get(2) + "\", contactno = \""
									+ list.get(3) + "\", emailaddress = \"" + list.get(4) + "\", homeaddress = \"" + list.get(5) + 
											"\", password = \"" + list.get(6) + "\" WHERE ID = " + list.get(0));
			closeConnection();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{e.printStackTrace();}
		
		
		return returnThis;
	}
	
	//For Deleting Staff
	int deleteStaff(int role, String ID)
	{
		int returnThis = -1;
		String Role = identifyRole(role);
		try 
		{
			openConnection();
			returnThis = stm.executeUpdate("DELETE FROM " + Role + " WHERE ID = " + ID);
			closeConnection();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{e.printStackTrace();}
		return returnThis;
	}
	
	//adding staff
	int addStaff(List<String> list) throws SQLException
	{
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		if(list.get(0) == "Administrator")
		{
			return stm.executeUpdate("INSERT INTO administrator(fname, sname, contactno, emailaddress, homeaddress, password) values(\"" 
										+ list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", \"" + list.get(4) + "\", \"" 
											+ list.get(5) + "\", \"" + list.get(6) + "\");");
		}
		if(list.get(0) == "Clerk")
		{
			return stm.executeUpdate("INSERT INTO clerk(fname, sname, contactno, emailaddress, homeaddress, password) values(\"" 
										+ list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", \"" + list.get(4) + "\", \"" 
											+ list.get(5) + "\", \"" + list.get(6) + "\");");
		}
		if(list.get(0) == "Mechanic")
		{
			return stm.executeUpdate("INSERT INTO mechanic(fname, sname, contactno, emailaddress, homeaddress, password) values(\"" 
										+ list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", \"" + list.get(4) + "\", \"" 
											+ list.get(5) + "\", \"" + list.get(6) + "\");");
		}
		
		 closeConnection();
		return -1;
	}
	
	
	void sessionlogs(String uid, String role, String descr)
	{
		try
		{
			openConnection();
			stm.executeUpdate("INSERT INTO sessionlog(logintime, userid, userrole, description) " +
								"VALUES( NOW(), " + uid + ", \"" + role + "\", \"" + descr + "\");");
			closeConnection();
		} 
		catch (SQLException e) {e.printStackTrace();} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//closing connection
	void closeConnection() throws SQLException
	{
		stm.close();
		con.close();
	}
	
}
