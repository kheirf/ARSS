package javaapplication;

import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import javax.swing.DefaultComboBoxModel;
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
		this.uid = uid; //sets the global variable uid to the one provided by Controller.java class
		clerk_view = view; //sets which view class to show
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
					ResultSet rs = model.getBatchResult("Customer");
					String carOwnerID = null;
					try 
					{
						if(rs.next())
						{
							rs.absolute(clerk_view.carOwner_add.getSelectedIndex() + 1);
							carOwnerID = rs.getString(1);
						}
					} 
					catch (SQLException e) {e.printStackTrace();}
					
					List<String> list = new ArrayList<String>();
					list.add("Car");
					list.add(clerk_view.Regno_add.getText());
					list.add(clerk_view.Make_add.getText());
					list.add(clerk_view.Model_add.getText());
					list.add(carOwnerID);
					list.add(clerk_view.Year_add.getText());
	
					try {
						if((model.addTo(list)) > 0)
						{
							model.activitylogs(uid, "Clerk", "INSERT", "Car");
							clerk_view.Regno_add.setText("");
							clerk_view.Make_add.setText("");
							clerk_view.Model_add.setText("");
							clerk_view.Year_add.setText("");
							JOptionPane.showMessageDialog(clerk_view, "Successfully Added");
						}
						else
							JOptionPane.showMessageDialog(clerk_view, "There was a problem adding car \nContact Customer Support", "Error", JOptionPane.ERROR_MESSAGE);
					} 
					catch (HeadlessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
				}
			
	}
	
	//method to add customer
	private void addCustomer() throws HeadlessException, SQLException 
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
						list.add("Customer");
						list.add(clerk_view.Fname_add.getText());
						list.add(clerk_view.Sname_add.getText());
						list.add(clerk_view.ContactNo_add.getText());
						list.add(clerk_view.EmailAdd_add.getText());
						list.add(clerk_view.HomeAdd_add.getText());
		
						if((model.addTo(list)) > 0)
						{
							model.activitylogs(uid, "Clerk", "INSERT", "Customer");
							updateComboBox();
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
		}
			
	}
	
	//method used to update customer when the clerk edited the field and clicked save
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
		if (!clerk_view.ID_edit.getText().equals(""))
		{
			if((model.updateStaff(list)) > 0)
			{
				model.activitylogs(uid, "Clerk", "UPDATE", "Customer");
				JOptionPane.showMessageDialog(clerk_view, "Update Successful");
			}
		}
	}
	
	//method to delete customer from database
	private void deleteCustomer() 
	{
		int i = JOptionPane.showConfirmDialog(null, "Do you really wish to delete this person?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); //dialog opens to confirm
		if (i == JOptionPane.YES_OPTION)
		{
			if ((model.deletePerson(4, selectedCustomerID)) > 0)
			{
				JOptionPane.showMessageDialog(clerk_view, "Delete Successful");
				try 
				{
					model.activitylogs(uid, "Clerk", "DELETE", "Customer");
					populateCustomerList();
					showCustomerDetails(-1);
				} 
				catch (SQLException e) {e.printStackTrace();}
			}
			else
				JOptionPane.showMessageDialog(clerk_view, "Can't Delete this Customer as it is used in other table", "Error", 
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
			
			clerk_view.CustomerList_booking.setModel(new javax.swing.AbstractListModel() //populate the list from the data on resultset
    		{
    			String[] strings = string;
    			public int getSize() 
    			{ return strings.length; }
            
    			public Object getElementAt(int i) 
    			{ return strings[i];} 
    		});
			
		}
		else
			clerk_view.CustomerList_booking.setListData(new String[0]); //if no data returned from the query the list is set to empty
		
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
				else
					break;
			clerk_view.BookingList_booking.setModel(new javax.swing.AbstractListModel() 
    		{
    			String[] strings = string;
    			public int getSize() 
    			{ return strings.length; }
            
    			public Object getElementAt(int i) 
    			{ return strings[i];} 
    		});
			
		}
		else
			clerk_view.BookingList_booking.setListData(new String[0]); // if no results from the query, set the list to empty.
	}
	
	//Method to add booking
	private void addBooking() throws HeadlessException, SQLException
	{
		if(clerk_view.customerID_booking.getText().isEmpty())
			JOptionPane.showMessageDialog(clerk_view, "Must Provide Customer!", "Error", 
					JOptionPane.ERROR_MESSAGE);
		else
			if (clerk_view.carID_booking.getText().isEmpty())
				JOptionPane.showMessageDialog(clerk_view, "Must Provide Car!", "Error", 
						JOptionPane.ERROR_MESSAGE);
			else
			{
				list = new ArrayList<String>();
				list.add("Booking");
				list.add(uid);
				list.add(clerk_view.customerID_booking.getText());
				list.add(clerk_view.carID_booking.getText());
				list.add(clerk_view.problem_booking.getText());
				
				if((model.addTo(list)) > 0)
				{
					try 
					{
						model.activitylogs(uid, "Clerk", "INSERT", "Booking");
						populateAllListOnPanel();
						clerk_view.customerID_booking.setText("");
						clerk_view.carID_booking.setText("");
						clerk_view.problem_booking.setText("");
					}
					catch (SQLException e) {e.printStackTrace();}
					JOptionPane.showMessageDialog(clerk_view, "Booking Successful");
				}
				else
					JOptionPane.showMessageDialog(clerk_view, "There was a problem in booking\nContact Customer Support", "Error", 
							JOptionPane.ERROR_MESSAGE);
			}
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
						+ "\nProblem: " + rs.getString(6) + "\nStatus: " + rs.getString(7);
		
		if(rs.getString(7).equals("OPEN"))
		{
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
		else
			if((rs.getString(7).equals("PROCESSED")) || (rs.getString(7).equals("COMPLETED")))
			{
				JOptionPane.showMessageDialog(clerk_view, disp);
			}
	}
	
	//this method is used when the user wants to log out
	private void userLogout() throws SQLException
	{
		int i = JOptionPane.showConfirmDialog(clerk_view, "Log out?", "Please Confirm", JOptionPane.YES_NO_OPTION);
		if (i == JOptionPane.YES_OPTION)
		{
			model.sessionlogs(uid, "Mechanic", "System Logout");
			model.closeConnection();
			clerk_view.setVisible(false);
			Login backTo = new Login(2);
			backTo.setVisible(true);
			new Controller(backTo);
		}
	}
	
	//method to update combobox
	@SuppressWarnings("unchecked")
	private void updateComboBox() throws SQLException
	{
		ResultSet rs = model.getBatchResult("Customer");
		String [] forComboBox;
		if(rs.next())
		{
			rs.last();
			int lastRow = rs.getRow();
			forComboBox = new String[lastRow];
			rs.beforeFirst();
			for(int i = 0; i < lastRow; i++)
				if(rs.next())
					forComboBox[i] = rs.getString(2) + " " + rs.getString(3);
		}
		else
			forComboBox = new String[0];
		
		clerk_view.carOwnerCombo(forComboBox);
			
	}
	
	@SuppressWarnings("unchecked")
	private void populateCarList(String cid)
	{
		ResultSet rs;
		rs = model.getQueryResult("SELECT carregno, make FROM CAR where owner = " + cid);
		try {
			if(rs.next())
			{
				rs.last();
				int lastRow = rs.getRow();
				final String[] string = new String[lastRow];
				rs.beforeFirst();
				System.out.println(cid);
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
				clerk_view.carID_booking.setEditable(false);
			}
			else
			{
				clerk_view.CarList_booking.setListData(new String[0]);
				clerk_view.carID_booking.setEditable(true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class valueChange implements ListSelectionListener
	{


		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			if(e.getSource() == clerk_view.CustomerList_booking)
			{
				if(clerk_view.CustomerList_booking.getSelectedIndex() >= 0)
				{
					ResultSet rs = model.getBatchResult("Customer");
					String cid;
					try 
					{
						if (rs.next())
						{
							rs.absolute(clerk_view.CustomerList_booking.getSelectedIndex() + 1);
							cid = rs.getString(1);
							populateCarList(cid);
							//if(clerk_view.CustomerList_booking.getModel().getSize() < 0)
								//clerk_view.carID_booking.setEditable(true);
						//	else
							//	clerk_view.carID_booking.setEditable(false);
						}
						else
						{
							clerk_view.CarList_booking.setListData(new String[0]);
						}
					} 
					catch (SQLException e1) {e1.printStackTrace();}
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
						clerk_view.Fname_edit.setEditable(true);
						clerk_view.Sname_edit.setEditable(true);
						clerk_view.ContactNo_edit.setEditable(true);
						clerk_view.EmailAdd_edit.setEditable(true);
						clerk_view.HomeAdd_edit.setEditable(true);
						
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
						clerk_view.add1_booking.setEnabled(false);
						//if(clerk_view.CarList_booking.getSize().height <= 0)
							//clerk_view.carID_booking.
						
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
						clerk_view.add2_booking.setEnabled(false);
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
				try 
				{
					updateComboBox();
				} 
				catch (SQLException e1) {e1.printStackTrace();}
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
					clerk_view.Fname_edit.setEditable(false);
					clerk_view.Sname_edit.setEditable(false);
					clerk_view.ContactNo_edit.setEditable(false);
					clerk_view.EmailAdd_edit.setEditable(false);
					clerk_view.HomeAdd_edit.setEditable(false);
					populateCustomerList();
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if(e.getSource() == clerk_view.addCustomer_add)
			{
				try 
				{
					addCustomer(); // when add customer/car button is pressed then go to addCustomer function defined above
				} 
				catch (HeadlessException | SQLException e1) {e1.printStackTrace();}
			}
			
			if(e.getSource() == clerk_view.Save_edit)
			{
				updateCustomer(); //if Edit customer was pressed then call the function updateCustomer.
			}
			
			if(e.getSource() == clerk_view.Delete_edit)
			{
				deleteCustomer(); //if Delete customer button in options panel was pressed then call the function deleteCustomer
			}
			
			if(e.getSource() == clerk_view.Save_booking) //save button on booking panel
			{
				try 
				{
					addBooking();
					clerk_view.add1_booking.setEnabled(true);
					clerk_view.add2_booking.setEnabled(true);
					clerk_view.CustomerList_booking.setSelectedIndex(-1);
					clerk_view.CarList_booking.setSelectedIndex(-1);
				} 
				catch (HeadlessException | SQLException e1) {e1.printStackTrace();}
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
			
			if(e.getSource() == clerk_view.discardCar_add)
			{
				clerk_view.Model_add.setText("");
				clerk_view.Make_add.setText("");
				clerk_view.Year_add.setText("");
				clerk_view.Regno_add.setText("");
			}
			
			if(e.getSource() == clerk_view.discardCustomer_add)
			{
				clerk_view.Fname_add.setText("");
				clerk_view.Sname_add.setText("");
				clerk_view.ContactNo_add.setText("");
				clerk_view.EmailAdd_add.setText("");
				clerk_view.HomeAdd_add.setText("");
			}
			
			if(e.getSource() == clerk_view.Discard_edit)
			{
				try 
				{
					showCustomerDetails(clerk_view.CustomerList_edit.getSelectedIndex());
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if(e.getSource() == clerk_view.Discard_booking)
			{
				clerk_view.customerID_booking.setText("");
				clerk_view.carID_booking.setText("");
				clerk_view.problem_booking.setText("");
				clerk_view.add1_booking.setEnabled(true);
				clerk_view.add2_booking.setEnabled(true);
			}
		}

		
	}
}
