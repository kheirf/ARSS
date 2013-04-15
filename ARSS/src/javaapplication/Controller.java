package javaapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Controller 
{
	private Login login_view;
	private Main model;
	
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
					model.search(login_view.getUserID(), login_view.getPassword(), login_view.getRole());
				 } 
	    		 catch (SQLException e1) 
	    		 {
					e1.printStackTrace();
				 } 
	    		 catch (ClassNotFoundException e1) 
	    		 {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    	 }
			
			if (e.getSource() == login_view.switchUser)
			{
				login_view.setVisible(false);
				new StartPage().setVisible(true);
			}
		}
	}
}
