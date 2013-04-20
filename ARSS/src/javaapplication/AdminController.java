package javaapplication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminController 
{
	private AdminMain admin_view;
	private Main model;
	private String uid;
	private static int theRole;
	CardLayout content;
	private List<String> list;
	AdminController(AdminMain view, String uid)
	{
		this.uid = uid;
		admin_view = view;
		admin_view.buttonListener(new buttonListener());
		admin_view.listSelectionListener(new valueChange());
		content = (CardLayout) admin_view.ContentPanel.getLayout();
		Date d = new Date();
		
		try 
		{
			model = new Main();
			list = model.searchForID(this.uid, 1);
			admin_view.userName.setText(list.get(1) + " " + list.get(2));
			admin_view.currentDate.setText(d.toString());
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	void clearDataOn()
	{
		admin_view.Fname_add.setText("");
		admin_view.Sname_add.setText("");
		admin_view.ContactNo_add.setText("");
		admin_view.EmailAdd_add.setText("");
		admin_view.HomeAdd_add.setText("");
		admin_view.Pwd_add.setText("");
		admin_view.RepeatPwd.setText("");
	}
	
	void addData()
	{
		list = new ArrayList<String>();
		
		if(!admin_view.Fname_add.getText().isEmpty())
		{
			if(!admin_view.Sname_add.getText().isEmpty())
			{
				if(!admin_view.Pwd_add.getText().isEmpty())
				{
					if(admin_view.RepeatPwd.getText().equals(admin_view.Pwd_add.getText()))
					{
						list.add(admin_view.DropDown_add.getSelectedItem().toString());
						list.add(admin_view.Fname_add.getText());
						list.add(admin_view.Sname_add.getText());
						list.add(admin_view.ContactNo_add.getText());
						list.add(admin_view.EmailAdd_add.getText());
						list.add(admin_view.HomeAdd_add.getText());
						list.add(admin_view.Pwd_add.getText());
						try 
						{
							if(model.addStaff(list) > 0)
							{
								clearDataOn();
								JOptionPane.showMessageDialog(admin_view, "Successfully Added New Data");
							}
							else
								JOptionPane.showMessageDialog(admin_view, "Error Adding New Data", "Error", JOptionPane.ERROR_MESSAGE);
						} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(admin_view, "Password does not match", "Error", JOptionPane.ERROR_MESSAGE);	
				}
				else
					JOptionPane.showMessageDialog(admin_view, "Password can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(admin_view, "Surname Cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(admin_view, "Name Cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void populateEditField(String ID, int flag)
	{
		list = new ArrayList<String>();
		
		switch (flag)
		{
		case 1:
			list = model.searchForID(ID, 1);
			admin_view.ID_edit.setText(list.get(0));
			admin_view.Fname_edit.setText(list.get(1));
			admin_view.Sname_edit.setText(list.get(2));
			admin_view.ContactNo_edit.setText(list.get(3));
			admin_view.EmailAdd_edit.setText(list.get(4));
			admin_view.HomeAdd_edit.setText(list.get(5));
			admin_view.OldPwd_edit.setText(list.get(6));
			theRole = Integer.parseInt(list.get(7));
			break;
		case 2:
			list = model.searchForID(ID, 1);
			admin_view.ID1_delete.setText(list.get(0));
			admin_view.Fname_delete.setText(list.get(1));
			admin_view.Sname_delete.setText(list.get(2));
			admin_view.ContactNo_delete.setText(list.get(3));
			admin_view.EmailAdd_delete.setText(list.get(4));
			admin_view.HomeAdd_delete.setText(list.get(5));
			theRole = Integer.parseInt(list.get(7));
			break;
		case 3:
			list = model.searchForID(ID, 2);
			admin_view.textArea_activities.setText("Time: " +list.get(0) 
					+ "\nUser ID: " + list.get(1) + "\nRole: " + list.get(2) +
					"\nDescription: " + list.get(3));
			break;
		}
	}
	
	private void updateStaff(int role)
	{
		List<String> l = new ArrayList<String>();
		l.add("" + role);
		l.add(admin_view.ID_edit.getText());
		l.add(admin_view.Fname_edit.getText());
		l.add(admin_view.Sname_edit.getText());
		l.add(admin_view.ContactNo_edit.getText());
		l.add(admin_view.EmailAdd_edit.getText());
		l.add(admin_view.HomeAdd_edit.getText());
		l.add(admin_view.NewPwd_edit.getText());
		
		if(!l.get(1).toString().equals(""))
		{
			if(model.updateStaff(l) > 0)
			{
				populateEditField(admin_view.StaffList_edit.getSelectedValue().toString(), 1);
				JOptionPane.showMessageDialog(admin_view, "Successful");
				admin_view.NewPwd_edit.setText("");
			}
			else
				JOptionPane.showMessageDialog(admin_view, "Failed to edit", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(admin_view, "No Such Person with that ID", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	//void populateDateList(List<String> list)
	//{
		//String [] dList = {};
		//dList = model.getActivityList(uid);
	//}
	
	 @SuppressWarnings("unchecked")
	void populateList(final String [] string, int flag)
	    {
	    	switch(flag)
	    	{
	    	case 1:
	    		admin_view.StaffList_edit.setModel(new javax.swing.AbstractListModel() 
	    		{
	    			String[] strings = string;
	    			public int getSize() 
	    			{ return strings.length; }
	            
	    			public Object getElementAt(int i) 
	    			{ return strings[i];} 
	    		});
	    		break;
	    		
	    	case 2:
	    		admin_view.StaffList_delete.setModel(new javax.swing.AbstractListModel() 
	    		{
	    			String[] strings = string;
	    			public int getSize() 
	    			{ return strings.length; }
	            
	    			public Object getElementAt(int i) 
	    			{ return strings[i];} 
	    		});
	    		break;
	    		
	    	case 3:
	    		admin_view.StaffList_activities.setModel(new javax.swing.AbstractListModel() 
	    		{
	    			String[] strings = string;
	    			public int getSize() 
	            	{ return strings.length; }
	            
	    			public Object getElementAt(int i) 
	    			{ return strings[i];} 
	    		});
	    		break;
	    	case 4:
	    		admin_view.Datelist_activities.setModel(new javax.swing.AbstractListModel() 
	    		{
	    			String[] strings = string;
	    			public int getSize() 
	            	{ return strings.length; }
	            
	    			public Object getElementAt(int i) 
	    			{ return strings[i];} 
	    		});
	    		if(string.length == 0)
	    		{
	    			admin_view.textArea_activities.setText("The User has no activity");
	    		}
	    		break;
	    	}
	    }
	
	class valueChange implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			if(admin_view.Datelist_activities.getSelectedValue() != null)
			{
				populateEditField(admin_view.Datelist_activities.getSelectedValue().toString(), 3);
			}
			
			if(admin_view.StaffList_edit.getSelectedValue() != null)
			{
				populateEditField(admin_view.StaffList_edit.getSelectedValue().toString(), 1);
				admin_view.NewPwd_edit.setText("");
			}
			if(admin_view.StaffList_delete.getSelectedValue() != null)
			{
				populateEditField(admin_view.StaffList_delete.getSelectedValue().toString(), 2);
			}
			
			if(admin_view.StaffList_activities.getSelectedValue() != null)
			{
				populateList(model.getActivityList(admin_view.StaffList_activities.getSelectedValue().toString()), 4);
			}

		}
	}
	
	class buttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == admin_view.addMember) 
	    	{
				content.show(admin_view.ContentPanel, "card1");
	    	}
			
			if (e.getSource() == admin_view.editMember)
			{
				try 
				{
					content.show(admin_view.ContentPanel, "card2");
					populateList(model.getContentsList(), 1);
				} catch (SQLException e1) {e1.printStackTrace();}
				
			}
			
			if (e.getSource() == admin_view.deleteMember)
			{
				try 
				{
					content.show(admin_view.ContentPanel, "card3");
					populateList(model.getContentsList(), 2);
				} catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if (e.getSource() == admin_view.viewActivities)
			{
				try 
				{
					content.show(admin_view.ContentPanel, "card4");
					populateList(model.getContentsList(), 3);
				} catch (SQLException e1) 
				{e1.printStackTrace();}
				
			}
			
			if (e.getSource() == admin_view.Discard_add)
			{
				clearDataOn();
			}
			
			if (e.getSource() == admin_view.Save_add)
			{
				addData();
			}
			
			if(e.getSource() == admin_view.Save_edit)
			{
				if(!admin_view.NewPwd_edit.getText().isEmpty())
					updateStaff(theRole);
				else
					JOptionPane.showMessageDialog(admin_view, "New Password can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);	
			}
			
			if(e.getSource() == admin_view.Discard_edit)
			{
				populateEditField(admin_view.StaffList_edit.getSelectedValue().toString(), 1);
			}
			
			if(e.getSource() == admin_view.deleteButton)
			{
				if ((model.deletePerson(theRole, admin_view.ID1_delete.getText())) > 0)
				{
					try {
						populateList(model.getContentsList(), 2);
						JOptionPane.showMessageDialog(admin_view, "Successfully Deleted");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
			
			
			
		}//end of actionperformed
	}//end of button class
}//end of admin main class
