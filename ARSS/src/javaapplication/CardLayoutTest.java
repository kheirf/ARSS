package javaapplication;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardLayoutTest extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JButton button1;
	JButton button2;
	JPanel pane, card1, card2;

	public CardLayoutTest()
	{
		initialise();
	}
	
	void initialise()
	{
		JPanel mainPane = new JPanel(new BorderLayout());
		pane = new JPanel();
		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();
		button1= new JButton();
		button2 = new JButton();
		JPanel buttonPane = new JPanel(new GridLayout(1, 2));
		JTextField sometext1 = new JTextField();
		JTextField sometext2 = new JTextField();
		
		button1.setText("My Details");
		button2.setText("Add Details");
		sometext1.setText("Mama Mia!!");
		sometext2.setText("SOLIDADDDDDDD!!");
		
		card1.add(sometext1);
		card2.add(sometext2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		buttonPane.add(button1);
		buttonPane.add(button2);
		pane.setLayout(new CardLayout());
		pane.add(card1, "My Details");
		pane.add(card2, "Add Details");
		mainPane.add(pane, BorderLayout.CENTER);
		
		mainPane.add(buttonPane, BorderLayout.PAGE_START);
		getContentPane().add(mainPane);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(300, 300));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		CardLayout c = (CardLayout)(pane.getLayout());
		
		if(e.getSource() == button1)
		{
			c.show(pane, "My Details");
		}
		
		if(e.getSource() == button2)
		{
			c.show(pane, "Add Details");
		}
	}
	
	public static void main(String[] args0)
	{
		java.awt.EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
					new CardLayoutTest().setVisible(true);
			}
		});
	}
	

}


