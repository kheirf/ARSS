package javaapplication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

public class ClerkController 
{
	private ClerkMain clerk_view;
	private Main model;
	private String uid;
	private String role;
	private static int theRole;
	private List<String> list;
	private String selectedCustomerID;
	CardLayout content;
	
	public ClerkController(ClerkMain view, String uid)
	{
		this.uid = uid;
		clerk_view = view;
		clerk_view.buttonListener(new buttonListener());
		clerk_view.listSelectionListener(new valueChange());
		content = (CardLayout) clerk_view.ContentPanel.getLayout();
		Date d = new Date();
		try 
		{
			model = new Main();
			list = model.searchForID(this.uid, 1);
			clerk_view.userName.setText(list.get(1) + " " + list.get(2));
			clerk_view.currentDate.setText(d.toString());
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method to add car
	private void addCar()
	{
		if(clerk_view.Make_add.getText().isEmpty())
			JOptionPane.showMessageDialog(clerk_view, "Car Make cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		else
			if(clerk_view.Model_add.getText().isEmpty())
				JOptionPane.showMessageDialog(clerk_view, "Car Model cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
			else
				if(clerk_view.Regno_add.getText().isEmpty())
					JOptionPane.showMessageDialog(clerk_view, "Car Registration number cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
				else
				{
					List<String> list = new ArrayList<String>();
					list.add(clerk_view.Regno_add.getText());
					list.add(clerk_view.Make_add.getText());
					list.add(clerk_view.Model_add.getText());
					list.add(clerk_view.Year_add.getText());
	
					if((model.addCarCustomerBooking(list, 2)) > 0)
					{
						clerk_view.Regno_add.setText("");
						clerk_view.Make_add.setText("");
						clerk_view.Model_add.setText("");
						clerk_view.Year_add.setText("");
						JOptionPane.showMessageDialog(clerk_view, "Successfully Added");
					}
					else
						JOptionPane.showMessageDialog(clerk_view, "There was a problem adding car \nContact Customer Support", "Error", JOptionPane.ERROR_MESSAGE);
	
				}
			
	}
	
	//method to add customer
	private void addCustomer() 
	{
		if(clerk_view.Fname_add.getText().isEmpty())
			JOptionPane.showMessageDialog(clerk_view, "First Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		else
			if(clerk_view.Sname_add.getText().isEmpty())
				JOptionPane.showMessageDialog(clerk_view, "Surname cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
			else
				if(clerk_view.ContactNo_add.getText().isEmpty())
					JOptionPane.showMessageDialog(clerk_view, "Contact number cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
				else
					if(clerk_view.HomeAdd_add.getText().isEmpty())
						JOptionPane.showMessageDialog(clerk_view, "Home Address cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
					else
					{
		
						List<String> list = new ArrayList<String>();
						list.add(clerk_view.Fname_add.getText());
						list.add(clerk_view.Sname_add.getText());
						list.add(clerk_view.ContactNo_add.getText());
						list.add(clerk_view.EmailAdd_add.getText());
						list.add(clerk_view.HomeAdd_add.getText());
		
						if((model.addCarCustomerBooking(list, 1)) > 0)
						{
							clerk_view.Fname_add.setText("");
							clerk_view.Sname_add.setText("");
							clerk_view.ContactNo_add.setText("");
							clerk_view.EmailAdd_add.setText("");
							clerk_view.HomeAdd_add.setText("");
							JOptionPane.showMessageDialog(clerk_view, "Successfully Added");
						}
						else
							JOptionPane.showMessageDialog(clerk_view, "There was a problem adding customer \nContact Customer Support", "Error", JOptionPane.ERROR_MESSAGE);
		
					}
	}
	
	//method to populate the list on edit tab
	@SuppressWarnings("unchecked")
	private void populateCustomerList() throws SQLException 
	{
		ResultSet rs;
		rs = model.getBatchResult("Customer");
		if(rs.next())
		{
			rs.last();
			int lastRow = rs.getRow();
			final String[] string = new String[lastRow];
			rs.beforeFirst();
			for (int i = 0; i < lastRow; i++)
				if (rs.next())
					string[i] = rs.getString(3) + ", " + rs.getString(2);
			
			clerk_view.CustomerList_edit.setModel(new javax.swing.AbstractListModel() 
    		{
    			String[] strings = string;
    			public int getSize() 
    			{ return strings.length; }
            
    			public Object getElementAt(int i) 
    			{ return strings[i];} 
    		});
			rs.close();
		}
	}
	
	void showCustomerDetails(int position) throws SQLException
	{
		ResultSet rs;
		rs = model.getBatchResult("Customer");
		if (position >= 0)
		{
			rs.absolute(position + 1);
			clerk_view.ID_edit.setText(rs.getString(1));
			clerk_view.Fname_edit.setText(rs.getString(2));
			clerk_view.Sname_edit.setText(rs.getString(3));
			clerk_view.ContactNo_edit.setText(rs.getString(4));
			clerk_view.EmailAdd_edit.setText(rs.getString(5));
			clerk_view.HomeAdd_edit.setText(rs.getString(6));
			clerk_view.registered_edit.setText(rs.getString(7));
			selectedCustomerID = rs.getString(1);
		}
		else
		{
			clerk_view.ID_edit.setText("");
			clerk_view.Fname_edit.setText("");
			clerk_view.Sname_edit.setText("");
			clerk_view.ContactNo_edit.setText("");
			clerk_view.EmailAdd_edit.setText("");
			clerk_view.HomeAdd_edit.setText("");
			clerk_view.registered_edit.setText("");
			//selectedCustomerID = rs.getString(1);
		}
			
	}
	
	private void updateCustomer() 
	{
		list = new ArrayList<String>();
		list.add("Customer");
		list.add(clerk_view.ID_edit.getText());
		list.add(clerk_view.Fname_edit.getText());
		list.add(clerk_view.Sname_edit.getText());
		list.add(clerk_view.ContactNo_edit.getText());
		list.add(clerk_view.EmailAdd_edit.getText());
		list.add(clerk_view.HomeAdd_edit.getText());
		if((model.updateStaff(list)) > 0)
			JOptionPane.showMessageDialog(clerk_view, "Update Successful");
	}
	
	//method to delete customer from database
	private void deleteCustomer() 
	{
		int i = JOptionPane.showConfirmDialog(null, "Do you really wish to delete this person?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == JOptionPane.YES_OPTION)
		{
			if ((model.deletePerson(4, selectedCustomerID)) > 0)
			{
				JOptionPane.showMessageDialog(clerk_view, "Delete Successful");
				try 
				{
					populateCustomerList();
					showCustomerDetails(-1);
				} 
				catch (SQLException e) {e.printStackTrace();}
			}
			else
				JOptionPane.showMessageDialog(clerk_view, "There was a problem deleting a customer \nContact Customer Support", "Error", 
						JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	//method used to populate the list on booking tab
	private void populateAllListOnPanel() throws SQLException
	{
		ResultSet rs;
		rs = model.getBatchResult("Customer");
		if(rs.next())
		{
			rs.last();
			int lastRow = rs.getRow();
			final String[] string = new String[lastRow];
			rs.beforeFirst();
			for (int i = 0; i < lastRow; i++)
				if (rs.next())
					string[i] = rs.getString(3) + ", " + rs.getString(2);
			
			clerk_view.CustomerList_booking.setModel(new javax.swing.AbstractListModel() 
    		{
    			String[] strings = string;
    			public int getSize() 
    			{ return strings.length; }
            
    			public Object getElementAt(int i) 
    			{ return strings[i];} 
    		});
			
		}
		rs = model.getBatchResult("Car");
		if(rs.next())
		{
			rs.last();
			int lastRow = rs.getRow();
			final String[] string = new String[lastRow];
			rs.beforeFirst();
			for (int i = 0; i < lastRow; i++)
				if (rs.next())
					string[i] = rs.getString(1);
			
			clerk_view.CarList_booking.setModel(new javax.swing.AbstractListModel() 
    		{
    			String[] strings = string;
    			public int getSize() 
    			{ return strings.length; }
            
    			public Object getElementAt(int i) 
    			{ return strings[i];} 
    		});
			
		}
		rs = model.getBatchResult("Booking");
		if(rs.next())
		{
			rs.last();
			int lastRow = rs.getRow();
			final String[] string = new String[lastRow];
			rs.beforeFirst();
			for (int i = 0; i < lastRow; i++)
				if (rs.next())
					string[i] = rs.getString(1);
			
			clerk_view.BookingList_booking.setModel(new javax.swing.AbstractListModel() 
    		{
    			String[] strings = string;
    			public int getSize() 
    			{ return strings.length; }
            
    			public Object getElementAt(int i) 
    			{ return strings[i];} 
    		});
			
		}
	}
	
	//Method to add booking
	private void addBooking()
	{
		list = new ArrayList<String>();
		list.add(uid);
		list.add(clerk_view.customerID_booking.getText());
		list.add(clerk_view.carID_booking.getText());
		list.add(clerk_view.problem_booking.getText());
		if((model.addCarCustomerBooking(list, 3)) > 0)
		{
			try 
			{
				populateAllListOnPanel();
			}
			catch (SQLException e) {e.printStackTrace();}
			JOptionPane.showMessageDialog(clerk_view, "Booking Successful");
		}
		else
			JOptionPane.showMessageDialog(clerk_view, "There was a problem in booking\nContact Customer Support", "Error", 
					JOptionPane.ERROR_MESSAGE);
	}
	
	
	
	
	//Sets up the customer id text field in Booking panel
	@SuppressWarnings("unchecked")
	private void addValues_booking(int flag) throws SQLException
	{
		ResultSet rs = null;
		switch (flag)
		{
		case 1:
			rs = model.getBatchResult("Customer");
			if(rs.next())
			{
				rs.absolute(clerk_view.CustomerList_booking.getSelectedIndex() + 1);
				clerk_view.customerID_booking.setText(rs.getString(1));
				rs.close();
			}
			break;
			
		case 2:
				clerk_view.carID_booking.setText(clerk_view.CarList_booking.getSelectedValue().toString());
			break;
		}
		
	}
	
	//When view on booking panel is clicked
	private void popUpBooking(int position) throws SQLException
	{
		ResultSet rs = model.getBatchResult("Booking");
		rs.absolute(position + 1);
		String disp = "Booking ID: " + rs.getString(1) + "\nClerk ID: " + rs.getString(2) + "\nCustomer ID: " 
						+ rs.getString(3) + "\nCar ID: " + rs.getString(4) + "\nDate booked: " + rs.getString(5)
						+ "\nProblem: " + rs.getString(6);
		
		Object[] options = {"Delete this booking", "Go back"};
		int i = JOptionPane.showOptionDialog(clerk_view, disp, rs.getString(1), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
		if(i == JOptionPane.YES_OPTION)
		{
			int j = JOptionPane.showConfirmDialog(clerk_view, "Do you really want to delete this booking?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if(j == JOptionPane.YES_OPTION)
				if((model.deletePerson(5, rs.getString(1))) > 0)
				{
					populateAllListOnPanel();
					JOptionPane.showMessageDialog(clerk_view, "Booking successfully removed");
				}
				else
					JOptionPane.showMessageDialog(clerk_view, "Encountered some errors while deleting\nContact Customer Support", "Error", 
							JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//this method is used when the user wants to log out
	private void userLogout() throws SQLException
	{
		int i = JOptionPane.showConfirmDialog(clerk_view, "Log out?", "Please Confirm", JOptionPane.YES_NO_OPTION);
		if (i == JOptionPane.YES_OPTION)
		{
			model.closeConnection();
			clerk_view.setVisible(false);
			Login backTo = new Login(2);
			backTo.setVisible(true);
			new Controller(backTo);
		}
	}
	
	class valueChange implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			if(e.getSource() == clerk_view.CustomerList_booking)
			{
				if(clerk_view.CustomerList_booking.getSelectedIndex() < 0)
				{
					
				}
			}
			
			if(e.getSource() == clerk_view.CarList_booking)
			{
				if(clerk_view.CarList_booking.getSelectedIndex() < 0)
				{}
			}
			
			if(e.getSource() == clerk_view.CustomerList_edit)
			{
				if(clerk_view.CustomerList_edit.getSelectedValue() != null)
				{
					try 
					{
						showCustomerDetails(clerk_view.CustomerList_edit.getSelectedIndex());
					} 
					catch (SQLException e1) {e1.printStackTrace();}
				}
			}
			
			
		}
		
	}
	
	class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == clerk_view.add1_booking)
			{
				if(clerk_view.CustomerList_booking.getSelectedIndex() >= 0)
				{
					try 
					{
						addValues_booking(1);
					} 
					catch (SQLException e1) {e1.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(clerk_view, "Choose customer", "Error", 
							JOptionPane.ERROR_MESSAGE);
			}
			
			if(e.getSource() == clerk_view.add2_booking)
			{
				if(clerk_view.CarList_booking.getSelectedIndex() >= 0)
				{
					try 
					{
						addValues_booking(2);
					} 
					catch (SQLException e1) {e1.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(clerk_view, "Choose a car", "Error", 
							JOptionPane.ERROR_MESSAGE);
			}
			
			if(e.getSource() == clerk_view.addCar_add)
			{
				addCar();
			}
			
			if(e.getSource() == clerk_view.addCustomer)
			{
				content.show(clerk_view.ContentPanel, "card1");
			}
			
			if(e.getSource() == clerk_view.booking)
			{
				content.show(clerk_view.ContentPanel, "card3");
				try 
				{
					populateAllListOnPanel();
					clerk_view.carID_booking.setText("");
					clerk_view.customerID_booking.setText("");
					clerk_view.problem_booking.setText("");
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if(e.getSource() == clerk_view.editCustomer)
			{
				content.show(clerk_view.ContentPanel, "card2");
				try 
				{
					populateCustomerList();
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if(e.getSource() == clerk_view.addCustomer_add)
			{
				addCustomer();
			}
			
			if(e.getSource() == clerk_view.Save_edit)
			{
				updateCustomer();
			}
			
			if(e.getSource() == clerk_view.Delete_edit)
			{
				deleteCustomer();
			}
			
			if(e.getSource() == clerk_view.Save_booking)
			{
				addBooking();
			}
			
			if(e.getSource() == clerk_view.view_booking)
			{
				if(clerk_view.BookingList_booking.getSelectedIndex() >= 0)
				{
					try 
					{
						popUpBooking(clerk_view.BookingList_booking.getSelectedIndex());
					} 
					catch (SQLException e1) {e1.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(clerk_view, "Select on the list", "Error", 
							JOptionPane.ERROR_MESSAGE);
			}
			
			if(e.getSource() == clerk_view.logoutButton)
			{
				try 
				{
					userLogout();
				} 
				catch (SQLException e1){e1.printStackTrace();}
			}
			
		}

		
	}
}
