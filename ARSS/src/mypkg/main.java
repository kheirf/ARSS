package mypkg;

import java.awt.*;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;



public class main extends JFrame 
{

// Constructor for frame 

	public main (String myTitle) 
	{

		// Set the title of the window
		super (myTitle);

		// Set the default size of the window
		setSize(300,400);
		setLocation(100,100);

		// Say what to do when the window is closed
		setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);


		//Create the Pane and put it on the main window
		setContentPane(createPane());

		//Create the Menu and put it on the main window
		setJMenuBar(createMenu());


		// Show the window on the screen
		setVisible(true);
	}


	private Container createPane() 
        {

		Container pane = new JPanel();
		Icon saveIcon = new ImageIcon("./mypkg/save-icon.jpg");

		// Create a font object
		Font fancyFont = new Font ("Serif",Font.BOLD,32);


		// Create a label and a text field with a tool tip
		JLabel name = new JLabel ("Name");
		JTextField nameField = new JTextField (10);
		nameField.setToolTipText("Enter your Name here");

		// add the text details to the pane
		pane.add(name);
		pane.add(nameField);

		// Create 2 button, put them on their own panel
		JButton saveButton = new JButton("Save",saveIcon);
		JButton cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		// Change the font on one of the buttons
		saveButton.setFont(fancyFont);
		cancelButton.setFont(fancyFont);


		// Set the Panel Border type
		buttonPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

		// Add the button panel to the main pane
		pane.add(buttonPanel);

		return pane;
	}

	private JMenuBar createMenu() 
	{

		// Create a menu Bar
		JMenuBar menuBar = new JMenuBar();

		// Create 3 Menus to go on the MenuBar
		JMenu fileMenu = new JMenu("File");
		JMenu utilsMenu = new JMenu("Utils");
		JMenu otherMenu = new JMenu("Other");

		//Declare Menu Items and add them to the first menu

		JMenuItem openMenuItem = new JMenuItem ("Open file");
		JMenuItem closeMenuItem = new JMenuItem ("close file");
		JMenuItem newMenuItem = new JMenuItem ("New file");

		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(openMenuItem);
		fileMenu.add(closeMenuItem);


		//Add Mnenomics to the Menus
		fileMenu.setMnemonic('F');
		utilsMenu.setMnemonic('U');
		otherMenu.setMnemonic('O');

		//Add Accelerators to menu items
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.ALT_MASK));
		// Add each of the menus to the Menu Bar


		// Create 2 radio buttons, put them in a group and add to the filemenu
		JRadioButtonMenuItem firstRadioButton = new JRadioButtonMenuItem("First radion button");
		JRadioButtonMenuItem secondRadioButton = new JRadioButtonMenuItem("Second radion button");

		ButtonGroup myButtonGroup = new ButtonGroup();
		myButtonGroup.add(firstRadioButton);
		myButtonGroup.add(secondRadioButton);
		fileMenu.addSeparator();
		fileMenu.add(firstRadioButton);
		fileMenu.add(secondRadioButton);

		menuBar.add(fileMenu);
		menuBar.add(utilsMenu);
		menuBar.add(otherMenu);


		return menuBar;
	}


}
