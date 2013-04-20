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

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.jdbc.ResultSetMetaData;

public class ClerkController 
{
	private ClerkMain clerk_view;
	private Main model;
	private String uid;
	private String role;
	private static int theRole;
	private List<String> list;
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
	
					if((model.addCarCustomer(list, 2)) > 0)
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
		
						if((model.addCarCustomer(list, 1)) > 0)
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
		rs = model.getCustomers();
		if(rs.next())
		{
			rs.last();
			int lastRow = rs.getRow();
			final String[] string = new String[lastRow];
			rs.beforeFirst();
			for (int i = 0; i < lastRow; i++)
				if (rs.next())
					string[i] = rs.getString(3) + ", " + rs.getString(2);
			
			clerk_view.StaffList_edit.setModel(new javax.swing.AbstractListModel() 
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
		rs = model.getCustomers();
		
		rs.absolute(position + 1);
		clerk_view.ID_edit.setText(rs.getString(1));
		clerk_view.Fname_edit.setText(rs.getString(2));
		clerk_view.Sname_edit.setText(rs.getString(3));
		clerk_view.ContactNo_edit.setText(rs.getString(4));
		clerk_view.EmailAdd_edit.setText(rs.getString(5));
		clerk_view.HomeAdd_edit.setText(rs.getString(6));
	}
	
	private void updateCustomer() 
	{
		list = new ArrayList<String>();
		list.add("Customer");
		list.add(clerk_view.Fname_edit.getText());
		list.add(clerk_view.Sname_edit.getText());
		list.add(clerk_view.ContactNo_edit.getText());
		list.add(clerk_view.EmailAdd_edit.getText());
		list.add(clerk_view.HomeAdd_edit.getText());
		
	}
	
	class valueChange implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			if(e.getSource() == clerk_view.StaffList_edit)
			{
				try 
				{
					showCustomerDetails(clerk_view.StaffList_edit.getSelectedIndex());
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
		}
		
	}
	
	class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
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
			
			
		}

		
		
		
	}
}
