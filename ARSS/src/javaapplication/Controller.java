package javaapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

// ========================= this class is for controlling the components of Login GUI class ===============================
public class Controller 
{
	private Login login_view;
	private Main model;
	protected String userID;
	protected String role;
	
	Controller(Login view)		// constructor
	{
		login_view = view;
		view.loginBListener(new buttonListener()); // specify steps to take when login button is pressed
		view.switchUserListener(new buttonListener()); // specify steps to take when switch button is pressed
	}
	
	class buttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == login_view.Login) // if login button was pressed
	    	 {	
	    		 try
	    		 {
	    			model = new Main(); // create an instance of Main.java class
					checkLogin(model.search(login_view.getUserID(), login_view.getPassword(), login_view.getRole())); //this is a method to if login details was correct
				 } 
	    		 catch (SQLException | ClassNotFoundException e1){e1.printStackTrace();} 
	    	
	    		
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
				new AdminController(adminMain, userID);
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
				userID = login_view.getUserID();
				role = model.identifyRole(login_view.getRole());
				model.sessionlogs(userID, role, "System Login");
				ClerkMain clerkMain = new ClerkMain();
				login_view.setVisible(false);
				clerkMain.setVisible(true);
				new ClerkController(clerkMain, userID);
				//JOptionPane.showMessageDialog(login_view, "This should get to clerk main", "Warning", JOptionPane.ERROR_MESSAGE);
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
		
		if(login_view.getRole() == 3)
		{
			switch (check) 
			{
			case 1:
				userID = login_view.getUserID();
				role = model.identifyRole(login_view.getRole());
				model.sessionlogs(userID, role, "System Login");
				MechanicMain mechanicMain = new MechanicMain();
				login_view.setVisible(false);
				mechanicMain.setVisible(true);
				new MechanicController(mechanicMain, userID);
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
	}
}
