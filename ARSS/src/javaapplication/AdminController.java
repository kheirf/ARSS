package javaapplication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController 
{
	private AdminMain admin_view;
	private Main model;
	CardLayout content;
	AdminController(AdminMain view)
	{
		admin_view = view;
		admin_view.addMemberBListener(new buttonListener());
		admin_view.editMemberBListener(new buttonListener());
		admin_view.deleteMemberBListener(new buttonListener());
		admin_view.viewBListener(new buttonListener());
		content = (CardLayout) admin_view.ContentPanel.getLayout();
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
				content.show(admin_view.ContentPanel, "card2");
			}
			
			if (e.getSource() == admin_view.deleteMember)
			{
				content.show(admin_view.ContentPanel, "card3");
			}
			
			if (e.getSource() == admin_view.viewActivities)
			{
				content.show(admin_view.ContentPanel, "card4");
			}
		}
	}
}
