package javaapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Controller 
{
	private Login login_view;
	private Main model;
	protected String userID;
	protected String role;
	
	Controller(Login view)
	{
		login_view = view;
		view.loginBListener(new buttonListener());
		view.switchUserListener(new buttonListener());
	}
	
	class buttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == login_view.Login) 
	    	 {	
	    		 try
	    		 {
	    			model = new Main();
					checkLogin(model.search(login_view.getUserID(), login_view.getPassword(), login_view.getRole()));
				 } 
	    		 catch (SQLException e1){e1.printStackTrace();} 
	    		 catch (ClassNotFoundException e1) 
	    		 {e1.printStackTrace();}
	    		
	    	 }
			
			if (e.getSource() == login_view.switchUser)
			{
				login_view.setVisible(false);
				new StartPage().setVisible(true);
			}
		}
	}
	
	void checkLogin(int check)
	{
		if(login_view.getRole() == 1)
		{
			switch (check) 
			{
			case 1:
				userID = login_view.getUserID();
				role = model.identifyRole(login_view.getRole());
				model.sessionlogs(userID, role, "System Login");
				AdminMain adminMain = new AdminMain();
				login_view.setVisible(false);
				adminMain.setVisible(true);
				new AdminController(adminMain, userID, role);
				break;
			case 2:
				JOptionPane.showMessageDialog(login_view, "Incorrect Password.", "Warning", JOptionPane.ERROR_MESSAGE);
				login_view.Password.setText("");
				break;
			case 3:
				JOptionPane.showMessageDialog(login_view, "No Data Found.", "Warning", JOptionPane.ERROR_MESSAGE);
				login_view.User_ID.setText("");
				login_view.Password.setText("");
				break;
			}
		}

		if(login_view.getRole() == 2)
		{
			switch (check) 
			{
			case 1:
				JOptionPane.showMessageDialog(login_view, "This should get to clerk main", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(login_view, "Incorrect Password.", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(login_view, "No Data Found.", "Warning", JOptionPane.ERROR_MESSAGE);
				login_view.User_ID.setText("");
				login_view.Password.setText("");
				break;
			}
		}
		
		if(login_view.getRole() == 3)
		{
			switch (check) 
			{
			case 1:
				JOptionPane.showMessageDialog(login_view, "This should get to mechanic main", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(login_view, "Incorrect Password.", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(login_view, "No Data Found.", "Warning", JOptionPane.ERROR_MESSAGE);
				login_view.User_ID.setText("");
				login_view.Password.setText("");
				break;
			}
		}
	}
}
