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
		return returnThis;
	}
	
	
	//this method is used for activity list
	String [] getActivityList(String uid)
	{
		String [] thisList1 = {};
		ResultSet rs;
		
		try 
		{
			if((rs = stm.executeQuery("SELECT * FROM sessionlog WHERE userID = " + uid)).next())
			{
				rs.last();
				int lastRow = rs.getRow();
				thisList1 = new String[lastRow];
				rs.first();
				thisList1[0] = rs.getString(1);
			
				for(int i = 1; i < lastRow; i++)
					if(rs.next())
						thisList1[i] = rs.getString(1);
			}
			
			rs.close();
		}
		catch (SQLException e) {e.printStackTrace();} 
			
		return thisList1;
	}
	
	//method used to execute the statemnent, point to the specified column and return with a single data
	String returnSingleData(String statement, int column)
	{
		try 
		{
			ResultSet rs = stm.executeQuery(statement);
			if(rs.next())
			{
				return rs.getString(column);
			}
		} 
		catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	//returns result set from specified query
	ResultSet getQueryResult(String statement)
	{
		try 
		{
			return stm.executeQuery(statement);
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	//Returns result set from query
	ResultSet getBatchResult(String tablename)
	{
		try 
		{
			//openConnection();
			if(tablename.equals("Customer"))
				return stm.executeQuery("SELECT * FROM " + tablename + " ORDER BY sname");
				
			if(tablename.equals("Car"))
				return stm.executeQuery("SELECT * FROM " + tablename + " ORDER BY Make");
				
			if(tablename.equals("Booking"))
				return stm.executeQuery("SELECT * FROM " + tablename + " ORDER BY ID");
			
			if(tablename.equals("Parts"))
				return stm.executeQuery("SELECT * FROM " + tablename + " ORDER BY ID");
		} 
		catch (SQLException e) {e.printStackTrace();}
		
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

				if((rs = stm.executeQuery("SELECT * FROM administrator WHERE ID = " + ID)).next())
				{
					for (int i = 1; i <= 7; i++)
						list.add(rs.getString(i));
	
					list.add("1");
				}
				else
					if((rs = stm.executeQuery("SELECT * FROM clerk WHERE ID = " + ID)).next())
					{
						for (int i = 1; i <= 7; i++)
							list.add(rs.getString(i));
			
						list.add("2");
					}
					else
						if((rs = stm.executeQuery("SELECT * FROM mechanic WHERE ID = " + ID)).next())
						{
							for (int i = 1; i <= 7; i++)
								list.add(rs.getString(i));

							list.add("3");
						}
				rs.close();
				} 
				catch (SQLException e) {e.printStackTrace();}
			break;

		case 2:
			list = new ArrayList<String>();
			try 
			{
				rs = stm.executeQuery("SELECT * FROM sessionlog WHERE logtime = '" + ID + "'");
				if(rs.next())
					for (int i = 1; i < 5; i++)
						list.add(rs.getString(i));
				else
					if((rs = stm.executeQuery("SELECT * FROM activitylog WHERE activitytime = '" + ID + "'")).next())
						for (int i = 1; i < 6; i++)
							list.add(rs.getString(i));
					else
						rs.close();
			}
			catch (SQLException e) {e.printStackTrace();}
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
				returnThis = stm.executeUpdate("UPDATE " + Role + " SET fname = \"" + list.get(2) + "\", sname = \"" + list.get(3) + "\", contactno = \""
									+ list.get(4) + "\", emailaddress = \"" + list.get(5) + "\", homeaddress = \"" + list.get(6) + 
											"\", password = \"" + list.get(7) + "\" WHERE ID = " + list.get(1));
			} 
			catch (SQLException e){e.printStackTrace();}
		}
		else
			if(list.get(0).equals("Customer"))
			{
				try 
				{
					returnThis = stm.executeUpdate("UPDATE customer SET fname = \"" + list.get(2) + "\", sname = \""
											+ list.get(3) + "\", contactno = \"" + list.get(4) + "\", emailaddress = \""
											+ list.get(5) + "\", homeaddress = \"" + list.get(6) + "\" WHERE customerid = " + list.get(1));
				} 
				catch (SQLException e) {e.printStackTrace();}
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
			if (role == 1 || role == 2 || role == 3)
				returnThis = stm.executeUpdate("DELETE FROM " + Role + " WHERE ID = " + ID);
			else
				if(role == 4)
					returnThis = stm.executeUpdate("DELETE FROM " + Role + " WHERE customerID = " + ID);
				else
					if(role == 5)
						returnThis = stm.executeUpdate("DELETE FROM booking WHERE ID = " + ID);
		} 
		catch (SQLException e) {e.printStackTrace();}
		
		return returnThis;
	}
	
	
	//updating a table using specified statement
	int updateStatement(String statement)
	{
		try 
		{
			return stm.executeUpdate(statement);
		} 
		catch (SQLException e) {e.printStackTrace();}
		
		return -1;
	}
	
	//adding staff
	int addTo(List<String> list) throws SQLException
	{
		if(list.get(0) == "Administrator")
			return stm.executeUpdate("INSERT INTO administrator(fname, sname, contactno, emailaddress, homeaddress, password) values(\"" 
										+ list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", \"" + list.get(4) + "\", \"" 
											+ list.get(5) + "\", \"" + list.get(6) + "\");");
		if(list.get(0) == "Clerk")
			return stm.executeUpdate("INSERT INTO clerk(fname, sname, contactno, emailaddress, homeaddress, password) values(\"" 
										+ list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", \"" + list.get(4) + "\", \"" 
											+ list.get(5) + "\", \"" + list.get(6) + "\");");
		
		if(list.get(0) == "Mechanic")
			return stm.executeUpdate("INSERT INTO mechanic(fname, sname, contactno, emailaddress, homeaddress, password) values(\"" 
										+ list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", \"" + list.get(4) + "\", \"" 
											+ list.get(5) + "\", \"" + list.get(6) + "\");");
		
		if(list.get(0) == "Car")
			return stm.executeUpdate("INSERT INTO car VALUES (\"" + list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) 
					+ "\", \"" + list.get(4) + "\", \"" + list.get(5) + "\", CURDATE())");
		
		if(list.get(0) == "Booking")
			return stm.executeUpdate("INSERT INTO booking ( clerkid, customerid, carid, bookingdate, problem ) " +
					"VALUES ( " + list.get(1) + ", " + list.get(2) + ", \"" + list.get(3) + "\", NOW(), \"" + list.get(4) + "\" )");
		
		if(list.get(0) == "Customer")
			return stm.executeUpdate("INSERT INTO customer(fname, sname, contactno, emailaddress, homeaddress, dateregistered) " +
					"VALUES (\"" + list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", \"" + list.get(4)
					+ "\", \"" + list.get(5) + "\", CURDATE())");
		
		if(list.get(0) == "Parts")
			return stm.executeUpdate("INSERT INTO parts(classification, productnumber, description, price) " +
					"VALUES (\"" + list.get(1) + "\", \"" + list.get(2) + "\", \"" + list.get(3) + "\", "
						+ list.get(4) + ")");
		
		if(list.get(0) == "Repair")
			return stm.executeUpdate("INSERT INTO repair(mechanicid, bookingid, carid, partid, startdate) VALUES ( " + list.get(1) + ", " + list.get(2) + ", \"" + list.get(3)
						+ "\", " + list.get(4) + ", NOW())");
		
		if(list.get(0) == "Orders")
			return stm.executeUpdate("INSERT INTO orders(partid, quantity, price, description) VALUES (" 
					+ list.get(1) + ", " + list.get(2) + ", " + list.get(3) + ", \"" + list.get(4) + "\")" );
		
		return -1;
	}
	
	
	//adding session to sessionlog table
	void sessionlogs(String uid, String role, String descr)
	{
		try
		{
			stm.executeUpdate("INSERT INTO sessionlog " +
								"VALUES( NOW(), " + uid + ", \"" 
								+ role + "\", \"" + descr + "\");");
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
	
	//closing connection
	void closeConnection() 
	{
		try 
		{
			stm.close();
			con.close();
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
}
