package javaapplication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminController 
{
	private AdminMain admin_view;
	private Main model;
	private static int theRole;
	CardLayout content;
	AdminController(AdminMain view)
	{
		admin_view = view;
		admin_view.buttonListener(new buttonListener());
		admin_view.listSelectionListener(new valueChange());
		content = (CardLayout) admin_view.ContentPanel.getLayout();
		try {
			model = new Main();
		} catch (ClassNotFoundException | SQLException e) {
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
		List<String> l = new ArrayList<String>();
		
		if(!admin_view.Fname_add.getText().isEmpty())
		{
			if(!admin_view.Sname_add.getText().isEmpty())
			{
				if(!admin_view.Pwd_add.getText().isEmpty())
				{
					if(admin_view.RepeatPwd.getText().equals(admin_view.Pwd_add.getText()))
					{
						l.add(admin_view.DropDown_add.getSelectedItem().toString());
						l.add(admin_view.Fname_add.getText());
						l.add(admin_view.Sname_add.getText());
						l.add(admin_view.ContactNo_add.getText());
						l.add(admin_view.EmailAdd_add.getText());
						l.add(admin_view.HomeAdd_add.getText());
						l.add(admin_view.Pwd_add.getText());
						try 
						{
							if(model.addStaff(l) > 0)
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
		List<String> list = new ArrayList<String>();
		list = model.searchForID(ID);
		switch (flag)
		{
		case 1:
			admin_view.ID_edit.setText(list.get(0));
			admin_view.Fname_edit.setText(list.get(1));
			admin_view.Sname_edit.setText(list.get(2));
			admin_view.ContactNo_edit.setText(list.get(3));
			admin_view.EmailAdd_edit.setText(list.get(4));
			admin_view.HomeAdd_edit.setText(list.get(5));
			admin_view.OldPwd_edit.setText(list.get(6));
			theRole = Integer.parseInt(list.get(7));
		case 2:
			admin_view.ID1_delete.setText(list.get(0));
			admin_view.Fname_delete.setText(list.get(1));
			admin_view.Sname_delete.setText(list.get(2));
			admin_view.ContactNo_delete.setText(list.get(3));
			admin_view.EmailAdd_delete.setText(list.get(4));
			admin_view.HomeAdd_delete.setText(list.get(5));
			theRole = Integer.parseInt(list.get(7));
		}
	}
	
	private void updateStaff(int role)
	{
		List<String> list = new ArrayList<String>();
		list.add(admin_view.ID_edit.getText());
		list.add(admin_view.Fname_edit.getText());
		list.add(admin_view.Sname_edit.getText());
		list.add(admin_view.ContactNo_edit.getText());
		list.add(admin_view.EmailAdd_edit.getText());
		list.add(admin_view.HomeAdd_edit.getText());
		list.add(admin_view.NewPwd_edit.getText());
		if(!list.get(0).toString().equals(""))
		{
			if(model.updateStaff(role, list) > 0)
			{
				JOptionPane.showMessageDialog(admin_view, "Successful");
				admin_view.NewPwd_edit.setText("");
			}
			else
				JOptionPane.showMessageDialog(admin_view, "Failed to edit", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(admin_view, "No Such Person with that ID", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	class valueChange implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			if(admin_view.StaffList_edit.getSelectedValue() != null)
			{
				populateEditField(admin_view.StaffList_edit.getSelectedValue().toString(), 1);
				admin_view.NewPwd_edit.setText("");
				System.out.println(admin_view.StaffList_edit.getSelectedValue());
			}
			if(admin_view.StaffList_delete.getSelectedValue() != null)
			{
				populateEditField(admin_view.StaffList_delete.getSelectedValue().toString(), 2);
				System.out.println(admin_view.StaffList_delete.getSelectedValue());
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
					admin_view.populateList(model.getAllstaff());
				} catch (SQLException e1) {e1.printStackTrace();}
				
			}
			
			if (e.getSource() == admin_view.deleteMember)
			{
				try 
				{
					content.show(admin_view.ContentPanel, "card3");
					admin_view.populateList(model.getAllstaff());
				} catch (SQLException e1) {e1.printStackTrace();}
			}
			
			if (e.getSource() == admin_view.viewActivities)
			{
				content.show(admin_view.ContentPanel, "card4");
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
				if ((model.deleteStaff(theRole, admin_view.ID1_delete.getText())) > 0)
				{
					try {
						admin_view.populateList(model.getAllstaff());
						JOptionPane.showMessageDialog(admin_view, "Successfully Deleted");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				//populateEditField(admin_view.StaffList_delete.getSelectedValue().toString());
			}
			
		}//end of actionperformed
	}//end of button class
}//end of admin main class
