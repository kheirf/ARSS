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
		case 4:
			Role = "Customer";
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
	
	//this method is used for activity list
	String [] getActivityList(String uid)
	{
		String [] thisList1 = {};
		ResultSet rs;
		
		try 
		{
			openConnection();
			if((rs = stm.executeQuery("SELECT * FROM sessionlog WHERE userID = " + uid)).next())
			{
			rs.last();
			int lastRow = rs.getRow();
			thisList1 = new String[lastRow];
			rs.first();
			thisList1[0] = rs.getString(1);
			
			for(int i = 1; i < lastRow; i++)
			{
				if(rs.next())
				{
					thisList1[i] = rs.getString(1);
				}
			}
			}
			
			rs.close();
		}
		catch (ClassNotFoundException | SQLException e) {e.printStackTrace();} 
			
		return thisList1;
	}
	
	
	ResultSet getBatchResult(String tablename)
	{
		//ResultSet rs = null;
		try 
		{
			openConnection();
			if(tablename.equals("Customer"))
				return stm.executeQuery("SELECT * FROM " + tablename + " ORDER BY sname");
			else
				if(tablename.equals("Car"))
					return stm.executeQuery("SELECT * FROM " + tablename + " ORDER BY Make");
				else
					if(tablename.equals("Booking"))
						return stm.executeQuery("SELECT * FROM " + tablename + " ORDER BY ID");
					//else
						//if(tablename.equals("All Staff"))
							//return stm.executeQuery("SELECT * FROM administrator UNION SELECT * FROM clerk UNION SELECT * FROM Mechanic ORDER BY ID");
		} 
		catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
		
		return null;
	}
	
	//this method is used to get all the staff
	String[] getContentsList()throws SQLException
	{
		ResultSet rs = null;
		String[] list = {};
		try {
			openConnection();
			rs = stm.executeQuery("SELECT * FROM administrator UNION SELECT * FROM clerk UNION SELECT * FROM Mechanic ORDER BY ID");
			
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
	
	List<String> searchForID(String ID, int flag)
	{
		ResultSet rs;
		List<String> list = new ArrayList<String>();

		switch (flag)
		{
		case 1:
			try 
			{
				list = new ArrayList<String>();
		
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
			break;

		case 2:
			list = new ArrayList<String>();
			try 
			{
				openConnection();
				rs = stm.executeQuery("SELECT * FROM sessionlog WHERE logtime = '" + ID + "'");
				if(rs.next())
				{
					for (int i = 1; i < 5; i++)
					{
						list.add(rs.getString(i));
					}
				}
				else
					if((rs = stm.executeQuery("SELECT * FROM activitylog WHERE activitytime = '" + ID + "'")).next())
					{
						for (int i = 1; i < 6; i++)
						{
							list.add(rs.getString(i));
						}
					}
					else
						rs.close();
			}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
			break;
			
		}

		return list;	
	}
	
	//update rows in staff
	int updateStaff(List<String> list)
	{
		int returnThis = -1;
		if(list.get(0).equals("1") || list.get(0).equals("2") || list.get(0).equals("3"))
		{
			String Role = identifyRole(Integer.parseInt(list.get(0)));
			try 
			{
				openConnection();
				returnThis = stm.executeUpdate("UPDATE " + Role + " SET fname = \"" + list.get(2) + "\", sname = \"" + list.get(3) + "\", contactno = \""
									+ list.get(4) + "\", emailaddress = \"" + list.get(5) + "\", homeaddress = \"" + list.get(6) + 
											"\", password = \"" + list.get(7) + "\" WHERE ID = " + list.get(1));
				closeConnection();
			} 
			catch (ClassNotFoundException | SQLException e){e.printStackTrace();}
		}
		else
			if(list.get(0).equals("Customer"))
			{
				try 
				{
					openConnection();
					returnThis = stm.executeUpdate("UPDATE customer SET fname = \"" + list.get(2) + "\", sname = \""
											+ list.get(3) + "\", contactno = \"" + list.get(4) + "\", emailaddress = \""
											+ list.get(5) + "\", homeaddress = \"" + list.get(6) + "\" WHERE customerid = " + list.get(1));
				} 
				catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
			}
		return returnThis;
	}
	
	//For Deleting Staff
	int deletePerson(int role, String ID)
	{
		int returnThis = -1;
		String Role = identifyRole(role);
		try 
		{
			openConnection();
			if (role == 1 || role == 2 || role == 3)
				returnThis = stm.executeUpdate("DELETE FROM " + Role + " WHERE ID = " + ID);
			else
				if(role == 4)
					returnThis = stm.executeUpdate("DELETE FROM " + Role + " WHERE customerID = " + ID);
			closeConnection();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{e.printStackTrace();}
		return returnThis;
	}
	
	//add customer
	int addCarCustomerBooking(List<String> list, int flag)
	{
		try 
		{
			openConnection();
			if(flag == 1)
				return stm.executeUpdate("INSERT INTO customer(fname, sname, contactno, emailaddress, homeaddress, dateregistered) " +
					"VALUES (\"" + list.get(0) + "\", \"" + list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3)
					+ "\", \"" + list.get(4) + "\", CURDATE())");
			else
				if(flag == 2)
					return stm.executeUpdate("INSERT INTO car VALUES (\"" + list.get(0) + "\", \"" + list.get(1) + "\", \"" + list.get(2) 
								+ "\", \"" + list.get(3) + "\", CURDATE())");
				else
					if(flag == 3)
					{
						return stm.executeUpdate("INSERT INTO booking ( clerkid, customerid, carid, bookingdate, problem ) " +
								"VALUES ( " + list.get(0) + ", " + list.get(1) + ", \"" + list.get(2) + "\", NOW(), \"" + list.get(3) + "\" )");
					}
			closeConnection();
		} 
		catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
	
		return 0;
	}
	
	//adding staff
	int addStaff(List<String> list) throws SQLException
	{
		try 
		{
			openConnection();
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
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		
		
		return -1;
	}
	
	
	//adding session to sessionlog table
	void sessionlogs(String uid, String role, String descr)
	{
		try
		{
			openConnection();
			stm.executeUpdate("INSERT INTO sessionlog " +
								"VALUES( NOW(), " + uid + ", \"" 
								+ role + "\", \"" + descr + "\");");
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
