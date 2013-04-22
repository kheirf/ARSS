package javaapplication;

import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MechanicController 
{
	private MechanicMain mechanic_view;
	private Main model;
	private String uid;
	private String role;
	private static int theRole;
	private List<String> list;
	CardLayout content;
	
	public MechanicController(MechanicMain view, String uid)
	{
		this.uid = uid;
		mechanic_view = view;
		mechanic_view.buttonListener(new buttonListener());
		mechanic_view.listSelectionListener(new valueChange());
		content = (CardLayout) mechanic_view.ContentPanel.getLayout();
		Date d = new Date();
		try 
		{
			model = new Main();
			list = model.searchForID(this.uid, 1);
			mechanic_view.userName.setText(list.get(1) + " " + list.get(2));
			mechanic_view.currentDate.setText(d.toString());
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void userLogout() throws SQLException
	{
		int i = JOptionPane.showConfirmDialog(mechanic_view, "Log out?", "Please Confirm", JOptionPane.YES_NO_OPTION);
		if (i == JOptionPane.YES_OPTION)
		{
			model.sessionlogs(uid, "Mechanic", "System Logout");
			model.closeConnection();
			mechanic_view.setVisible(false);
			Login backTo = new Login(3);
			backTo.setVisible(true);
			new Controller(backTo);
		}
	}
	
	
	//This method is used to populate all list on add panel
	@SuppressWarnings("unchecked")
	private void populateList(int flag, JList jList)
	{
		switch(flag)
		{
		
		case 1:
			ResultSet rs;
			//String statement = "SELECT booking.id, car.make, car.model FROM booking, car WHERE booking.carid = car.carregno AND booking.status = 'OPEN' ORDER BY booking.id";
			String statement = "SELECT id FROM booking WHERE status = 'OPEN'";
			rs = model.getQueryResult(statement);
			try {
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
				
					jList.setModel(new javax.swing.AbstractListModel() 
					{
						String[] strings = string;
						public int getSize() 
						{ return strings.length; }
				
						public Object getElementAt(int i) 
						{ return strings[i];} 
					});
				}
				else
					jList.setModel(new javax.swing.AbstractListModel() 
					{
						String[] strings = {};
						public int getSize() 
						{ return strings.length; }
				
						public Object getElementAt(int i) 
						{ return strings[i];} 
					});
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			rs = model.getBatchResult("Parts");
			try {
				if(rs.next())
				{
					rs.last();
					int lastRow = rs.getRow();
					final String[] string = new String[lastRow];
					rs.beforeFirst();
					for (int i = 0; i < lastRow; i++)
						if (rs.next())
							string[i] = rs.getString(1) + ": " + rs.getString(2);
						else
							break;
				
					jList.setModel(new javax.swing.AbstractListModel() 
					{
						String[] strings = string;
						public int getSize() 
						{ return strings.length; }
				
						public Object getElementAt(int i) 
						{ return strings[i];} 
					});
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			rs = model.getQueryResult("SELECT * FROM repair WHERE mechanicid = " + uid);
			try {
				if(rs.next())
				{
					rs.last();
					int lastRow = rs.getRow();
					final String [] string = new String[lastRow];
					rs.beforeFirst();
					for(int i = 0; i < lastRow; i++)
						if(rs.next())
							string[i] = rs.getString(1) + ": " + rs.getString(7);
						else
							break;
					
					jList.setModel(new javax.swing.AbstractListModel(){
						String[] strings = string;
						public int getSize()
						{ return strings.length; }
						public Object getElementAt(int i)
						{ return strings[i];}
					});
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	
	//this method is used to add parts on database
	private void addParts()
	{
		if(mechanic_view.productNoAdd_order.getText().isEmpty())
			JOptionPane.showMessageDialog(mechanic_view, "Must Provide Product Number", "Error", 
					JOptionPane.ERROR_MESSAGE);
		else
		{
			List<String> list = new ArrayList<String>();
			list.add("Parts");
			list.add(mechanic_view.typeAdd_order.getSelectedItem().toString());
			list.add(mechanic_view.productNoAdd_order.getText());
			list.add(mechanic_view.descriptionAdd_order.getText());
			list.add(mechanic_view.priceAdd_order.getText());
		
			try 
			{
				if((model.addTo(list)) > 0)
				{
					model.activitylogs(uid, "Mechanic", "INSERT", "Parts");
					mechanic_view.productNoAdd_order.setText("");
					mechanic_view.descriptionAdd_order.setText("");
					mechanic_view.priceAdd_order.setText("");
					mechanic_view.typeAdd_order.setSelectedIndex(0);
					JOptionPane.showMessageDialog(mechanic_view, "New part successfully added!");
					populateList(2, mechanic_view.PartsList_order);
				}
				else
					JOptionPane.showMessageDialog(mechanic_view, "System experienced some errors \nContact customer service!", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	private void popUps(int position, String tablename)
	{
		ResultSet rs;
		if (tablename.equals("Booking"))
		{
			rs = model.getQueryResult("SELECT * FROM booking WHERE status = 'OPEN' ORDER BY id");
			try 
			{
				if(rs.next())
				{
					rs.absolute(position + 1);
					String disp = "Booking ID: " + rs.getString(1) + "\nClerk ID: " + rs.getString(2) + "\nCustomer ID: " 
							+ rs.getString(3) + "\nCar ID: " + rs.getString(4) + "\nDate booked: " + rs.getString(5)
							+ "\nProblem: " + rs.getString(6) + "\nStatus: " + rs.getString(7);
					JOptionPane.showMessageDialog(mechanic_view, disp, rs.getString(1), JOptionPane.PLAIN_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(mechanic_view, "Encountered some errors\nPlease contact Customer Support", "Error", 
							JOptionPane.ERROR_MESSAGE);
			} 
			catch (HeadlessException | SQLException e) {e.printStackTrace();}
		}
		
		if(tablename.equals("Parts"))
		{
			rs = model.getBatchResult(tablename);
			try 
			{
				if(rs.next())
				{
					rs.absolute(position + 1);
					String disp = "Part ID: " + rs.getString(1) + "\nType: " + rs.getString(2) + "\nProduct Number: "
							+ rs.getString(3) + "\nDescription: " + rs.getString(4) + "\nPrice: " + rs.getString(5)
							+ "\nQuantity: " + rs.getString(6);
					JOptionPane.showMessageDialog(mechanic_view, disp, rs.getString(1), JOptionPane.PLAIN_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(mechanic_view, "Encountered some errors\nPlease contact Customer Support", "Error", 
							JOptionPane.ERROR_MESSAGE);
			} 
			catch (SQLException e) {e.printStackTrace();}
		}	
	}
	
	private void addValues_repair(String tablename) throws SQLException
	{
		ResultSet rs = null;
		if(tablename.equals("Parts"))
		{
			rs = model.getBatchResult("Parts");
			if(rs.next())
			{
				rs.absolute(mechanic_view.PartsList_add.getSelectedIndex() + 1);
				if(Integer.parseInt(rs.getString(6)) <= 0)
				{
					int i = JOptionPane.showConfirmDialog(mechanic_view, "Insufficient quantity...\nOrder this part?", 
							"Parts not available", JOptionPane.YES_NO_OPTION);
					if(i == JOptionPane.YES_OPTION)
					{
						content.show(mechanic_view.ContentPanel, "card3");
						populateList(2, mechanic_view.PartsList_order);
						mechanic_view.PartsList_order.setSelectedIndex(mechanic_view.PartsList_add.getSelectedIndex());
						System.out.println(mechanic_view.PartsList_add.getSelectedValue().toString());
					}
				}
				else
					mechanic_view.partsID_add.setText(rs.getString(1));
			}
			rs.close();
		}
			
		if(tablename.equals("Booking"))
		{
			rs = model.getQueryResult("SELECT id FROM booking WHERE status = 'OPEN' ORDER BY ID");
			if(rs.next())
			{
				rs.absolute(mechanic_view.BookingList_add.getSelectedIndex() + 1);
					mechanic_view.bookingID_add.setText(rs.getString(1));
			}
			
		}
		
	}
	
	//this method is used to add repairs to database
	private void addRepair()
	{
		List<String> list = new ArrayList<String>();
		list.add("Repair");
		
		list.add(uid);
		if(mechanic_view.bookingID_add.getText().isEmpty())
			list.add(null);
		else
			list.add(mechanic_view.bookingID_add.getText());
		
		if(mechanic_view.carID_add.getText().isEmpty())
			list.add(null);
		else
			list.add(mechanic_view.carID_add.getText());
		
		if(mechanic_view.partsID_add.getText().isEmpty())
			list.add(null);
		else
			list.add(mechanic_view.partsID_add.getText());
		
		try 
		{
			if((model.addTo(list)) > 0)
			{
				model.activitylogs(uid, "Mechanic", "INSERT", "Repair");
				mechanic_view.bookingID_add.setText("");
				mechanic_view.partsID_add.setText("");
				mechanic_view.carID_add.setText("");
				JOptionPane.showMessageDialog(mechanic_view, "New repair added!");
				
				populateList(1, mechanic_view.BookingList_add);
				populateList(2, mechanic_view.PartsList_add);
			}
			else
				JOptionPane.showMessageDialog(mechanic_view, "Encountered some errors\nPlease contact Customer Support", "Error", 
						JOptionPane.ERROR_MESSAGE);
		} 
		catch (HeadlessException | SQLException e) {e.printStackTrace();}
	}
	
	
	//this method is used to show the details of the part selected
	private void showPartsDetails(int pos)
	{
		ResultSet rs;
		rs = model.getBatchResult("Parts");
		try 
		{
			if(rs.next())
			{
				rs.absolute(pos + 1);
				String disp = "ID:\n" + rs.getString(1) +
							  "\n\nType:\n" + rs.getString(2) +
							  "\n\nProduct No:\n" + rs.getString(3) +
							  "\n\nDescription:\n" + rs.getString(4) +
							  "\n\nPrice:\n" + rs.getString(5) +
							  "\n\nQuantity:\n" + rs.getString(6);
				
				mechanic_view.description_order.setText(disp);
			}
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
	
	//this method is for adding orders on database
	private void placeOrder()
	{
		final String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15"};
		String i = (String) JOptionPane.showInputDialog(mechanic_view, "Quantity: ", 
				"Order Process", JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
		if(!i.isEmpty())
		{
			if(JOptionPane.showConfirmDialog(mechanic_view, "Confirm ordering " + i + " pieces?", 
					"Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				List<String> l = new ArrayList<String>();
				String partID, price, description;
				ResultSet rs = model.getBatchResult("Parts");
				try 
				{
					if(rs.next())
					{
						rs.absolute(mechanic_view.PartsList_order.getSelectedIndex() + 1);
						partID = rs.getString(1);
						price = rs.getString(5);
						description = rs.getString(4);
						
						l.add("Orders");
						l.add(partID);
						l.add(i);
						l.add(price);
						l.add(description);
						
						
						if((model.addTo(l)) > 0)
						{
							model.activitylogs(uid, "Mechanic", "INSERT", "Orders");
							model.activitylogs(uid, "Mechanic", "UPDATE", "Parts");
							JOptionPane.showMessageDialog(mechanic_view, "Order processed successfully");
						}
						else
							JOptionPane.showMessageDialog(mechanic_view, "Encountered some errors\nPlease contact Customer Support", "Error", 
									JOptionPane.ERROR_MESSAGE);
					}
				} 
				catch (SQLException e) {e.printStackTrace();}
				
				
				
			}
		}
		
	}
	
	
	private void showRepairsDetails(int position) 
	{
		ResultSet rs = model.getQueryResult("SELECT * FROM repair WHERE mechanicid = " + uid);
		try 
		{
			if(rs.next())
			{
				rs.absolute(position + 1);
				mechanic_view.ID_view.setText(rs.getString(1));
				mechanic_view.bookingID_view.setText(rs.getString(3));
				mechanic_view.carID_view.setText(rs.getString(4));
				mechanic_view.partID_view.setText(rs.getString(5));
				mechanic_view.totalCharge_view.setText(rs.getString(6));
				mechanic_view.status_view.setText(rs.getString(7));
				mechanic_view.repairLength_view.setText(rs.getString(8));
				mechanic_view.startDate_view.setText(rs.getString(9));
				mechanic_view.endDate_view.setText(rs.getString(10));
				
				if(rs.getString(7).equals("IN PROGRESS"))
					mechanic_view.completeButton_view.setEnabled(true);
				else
					mechanic_view.completeButton_view.setEnabled(false);
			}
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
	private void completeRepair() 
	{
		String id = mechanic_view.ID_view.getText();
		if(!id.isEmpty())
		{
			Object [] Option = {"Fixed", "Not Fixed", "Cancel"};
			int i = JOptionPane.showOptionDialog(mechanic_view, "Provide the outcome of your job...", "Repair Complete", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					Option, Option[2]);
		
			if(i == 0 || i == 1)
			{
				System.out.println(i);
				String result;
				if(i == 0)
					result = "FIXED";
				else
					result = "NOT FIXED";
				
				String calculateMin = model.returnSingleData("SELECT TIMESTAMPDIFF(MINUTE, startdate, now()) " +
									"FROM repair WHERE repairID = " + id, 1);
			
				float c = Float.parseFloat(calculateMin) / 60.0f;
			
				String getPartPrice = model.returnSingleData("SELECT price FROM parts JOIN repair ON parts.id = repair.partid " +
						"WHERE repair.repairid = " + id, 1);
			
				float totalCharge = (10.3f * c) + Float.parseFloat(getPartPrice);
			
				if ((model.updateStatement("UPDATE repair SET enddate = NOW(), repairlength = " 
						+ String.valueOf(c) + ", totalCharge = " + String.valueOf(totalCharge) + 
						", status = '" + result + "' WHERE repairID = " + id)) > 0)
					model.activitylogs(uid, "Mechanic", "UPDATE", "Repair");
				else
					JOptionPane.showMessageDialog(mechanic_view, "Error updating Repair data", "Error", 
							JOptionPane.ERROR_MESSAGE);
				
				
				if((model.updateStatement("UPDATE booking JOIN repair ON booking.id = repair.bookingid " +
						"SET booking.status = 'COMPLETED' WHERE repair.repairid = " + id)) > 0)
					model.activitylogs(uid, "Mechanic", "UPDATE", "Booking");
				else
					JOptionPane.showMessageDialog(mechanic_view, "Error updating Booking data", "Error", 
							JOptionPane.ERROR_MESSAGE);
				
				showRepairsDetails(mechanic_view.repairList_view.getSelectedIndex());
				populateList(3, mechanic_view.repairList_view);
			}
			
			
		}
	}
	
	class valueChange implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			if(e.getSource() == mechanic_view.PartsList_order)
			{
				if(mechanic_view.PartsList_order.getSelectedIndex() >= 0)
				{
					showPartsDetails(mechanic_view.PartsList_order.getSelectedIndex());
				}
			}
			
			if(e.getSource() == mechanic_view.repairList_view)
			{
				if(mechanic_view.repairList_view.getSelectedIndex() >= 0)
				{
					showRepairsDetails(mechanic_view.repairList_view.getSelectedIndex());
				}
			}
		}

		
	}
	
	class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == mechanic_view.addRepair)
			{
				content.show(mechanic_view.ContentPanel, "card1");
				populateList(2, mechanic_view.PartsList_add);
				populateList(1, mechanic_view.BookingList_add);
			}
			
			if(e.getSource() == mechanic_view.viewRepair)
			{
				content.show(mechanic_view.ContentPanel, "card2");
				mechanic_view.completeButton_view.setEnabled(false);
				populateList(3, mechanic_view.repairList_view);
			}
			
			if(e.getSource() == mechanic_view.orderParts)
			{
				content.show(mechanic_view.ContentPanel, "card3");
				populateList(2, mechanic_view.PartsList_order);
			}
			
			if(e.getSource() == mechanic_view.logoutButton)
			{
				try 
				{
					userLogout();
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if(e.getSource() == mechanic_view.add_order)
			{
				addParts();
			}
			
			if(e.getSource() == mechanic_view.view_add)
			{
				if (mechanic_view.BookingList_add.getSelectedIndex() >= 0)
					popUps(mechanic_view.BookingList_add.getSelectedIndex(), "Booking");
			}
			
			if(e.getSource() == mechanic_view.view1_add)
			{
				if (mechanic_view.PartsList_add.getSelectedIndex() >= 0)
					popUps(mechanic_view.PartsList_add.getSelectedIndex(), "Parts");
			}
			
			if(e.getSource() == mechanic_view.add1_add)
			{
				try 
				{
					addValues_repair("Parts");
					mechanic_view.add1_add.setEnabled(false);
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if(e.getSource() == mechanic_view.add2_add)
			{
				if(mechanic_view.carID_add.getText().isEmpty())
				{
					try 
					{
						addValues_repair("Booking");
						mechanic_view.carID_add.setEditable(false);
						mechanic_view.add2_add.setEnabled(false);
					} 
					catch (SQLException e1) {e1.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(mechanic_view, "You already provided a car", "Error", 
							JOptionPane.ERROR_MESSAGE);
			}
			
			if(e.getSource() == mechanic_view.Save_add)
			{
				if(mechanic_view.bookingID_add.getText().isEmpty() && mechanic_view.carID_add.getText().isEmpty())
					JOptionPane.showMessageDialog(mechanic_view, "Must provide a car or Choose from the booking", "Error", 
							JOptionPane.ERROR_MESSAGE);
				else
				{
					mechanic_view.carID_add.setEditable(true);
					addRepair();
					mechanic_view.add1_add.setEnabled(true);
					mechanic_view.add2_add.setEnabled(true);
				}
			}
			
			if(e.getSource() == mechanic_view.Discard_add)
			{
				mechanic_view.bookingID_add.setText("");
				mechanic_view.carID_add.setText("");
				mechanic_view.partsID_add.setText("");
				mechanic_view.carID_add.setEditable(true);
				mechanic_view.add1_add.setEnabled(true);
				mechanic_view.add2_add.setEnabled(true);
			}
			
			if (e.getSource() == mechanic_view.save_order)
			{
				if(!mechanic_view.description_order.getText().isEmpty())
					placeOrder();
				else
					JOptionPane.showMessageDialog(mechanic_view, "No Parts selected.\nChoose from the list", "Error", 
							JOptionPane.ERROR_MESSAGE);
			}
			
			if (e.getSource() == mechanic_view.completeButton_view)
			{
				completeRepair();
			}
		}

		
	}

}
