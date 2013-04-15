package javaapplication;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame //implements ActionListener

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton Login;
	public JButton switchUser;
	private static JTextField User_ID; 
	private JPasswordField Password;
	private static int Role;
    
	public Login(int role) 
    {
		Role = role;
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() 
    {
    	// Variables declaration - do not modify                     
        JLabel ID;
        
        JLabel Main_Title;
        JLabel Login_Title;
        JLabel background;
        JLabel icon;
        JLabel LoginLabel;
        JLabel password;
       
        // End of variables declaration   

        Main_Title = new JLabel();
        Login_Title = new JLabel();
        LoginLabel = new JLabel();
        Password = new JPasswordField();
        password = new JLabel();
        ID = new JLabel();
        User_ID = new JTextField();
        Login = new JButton();
        switchUser = new JButton();
        icon = new JLabel();
        background = new JLabel();
        
        switch(Role)
        {
        
        case 1:
    		Login_Title.setText("Administrator");
    		LoginLabel.setToolTipText("Login as Administrator");
    		LoginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin.png"))); // NOI18N
    		break;
        case 2:
    		Login_Title.setText("Clerk");
    		LoginLabel.setToolTipText("Login as Clerk");
    		LoginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clerk.png"))); // NOI18N
    	    break;
        case 3:
    		Login_Title.setText("Mechanic");
    		LoginLabel.setToolTipText("Login as Mechanic");
    		LoginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mechanic.png"))); // NOI18N
    	    break;
        }
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auto Repair Shop System");
        setBackground(new java.awt.Color(255, 255, 102));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(938, 580));
        getContentPane().setLayout(null);

        Main_Title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Main_Title.setText("Auto Repair Shop System");
        getContentPane().add(Main_Title);
        Main_Title.setBounds(250, 0, 560, 40);
        Main_Title.getAccessibleContext().setAccessibleName("Main_Title\n");

        Login_Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(Login_Title);
        Login_Title.setBounds(380, 280, 150, 20);

        LoginLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(LoginLabel);
        LoginLabel.setBounds(330, 80, 330, 240);
        getContentPane().add(Password);
        Password.setBounds(430, 370, 110, 30);

        password.setText("Password:");
        getContentPane().add(password);
        password.setBounds(370, 370, 80, 40);

        ID.setText("ID:");
        getContentPane().add(ID);
        ID.setBounds(410, 340, 15, 14);

      
        getContentPane().add(User_ID);
        User_ID.setBounds(430, 330, 110, 30);

        Login.setText("Login");
        
        getContentPane().add(Login);
        Login.setBounds(360, 410, 80, 30);

        switchUser.setText("Switch User");
        getContentPane().add(switchUser);
        switchUser.setBounds(440, 410, 150, 30);

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arss.png"))); // NOI18N
        getContentPane().add(icon);
        icon.setBounds(820, 420, 170, 180);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 970, 580);

        setBounds(150, 70, 954, 618);
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    
    public String getUserID()
    {
		return User_ID.getText();
    }
    
    public char [] getPassword()
    {
    	return Password.getPassword();
    }
    
    public int getRole()
    {
    	return Role;
    }
    
    void loginBListener(ActionListener login)
    {
    	Login.addActionListener(login);
    }
    
    void switchUserListener(ActionListener SUL)
    {
    	switchUser.addActionListener(SUL);
    }
}
