package javaapplication;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;


//This class contains the main(). This is where the program starts off.
public class javaapplication
{

	public static void main(String args[]) 
	{
		//set the look and feels to specified type which is "NIMBUS"
		 try 
		 {
			 for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
	         {
	           if ("Nimbus".equals(info.getName())) 
	           {
	             UIManager.setLookAndFeel(info.getClassName());
	             break;
	           }
	         }
	     } 
		 catch (ClassNotFoundException ex) {Logger.getLogger(StartPage.class.getName()).log(Level.SEVERE, null, ex);} 
		 
		 catch (InstantiationException ex){Logger.getLogger(StartPage.class.getName()).log(Level.SEVERE, null, ex);} 
		 
		 catch (IllegalAccessException ex){Logger.getLogger(StartPage.class.getName()).log(Level.SEVERE, null, ex);} 
		 
		 catch (javax.swing.UnsupportedLookAndFeelException ex){Logger.getLogger(StartPage.class.getName()).log(Level.SEVERE, null, ex);}
		 
		 java.awt.EventQueue.invokeLater(new Runnable() 
		 {
	            public void run() 
	            {
						new StartPage().setVisible(true);
	            }
	     });
			
	}


}
