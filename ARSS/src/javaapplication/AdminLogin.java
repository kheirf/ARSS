package javaapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends javax.swing.JFrame implements ActionListener

{
	private JButton Login;
	private JButton switchUser;
	private static JTextField User_ID; 
	private JPasswordField adminPassword;
    
	public AdminLogin() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() 
    {
    	// Variables declaration - do not modify                     
        JLabel ID;
        
        JLabel Main_Title;
        JLabel Admin_Title;
        //JTextField User_ID;
        JLabel background;
        JLabel icon;
        JLabel adminLabel;
        //JPasswordField adminPassword;
        JLabel password;
       
        // End of variables declaration   

        Main_Title = new JLabel();
        Admin_Title = new JLabel();
        adminLabel = new JLabel();
        adminPassword = new JPasswordField();
        password = new JLabel();
        ID = new JLabel();
        User_ID = new JTextField();
        Login = new JButton();
        switchUser = new JButton();
        icon = new JLabel();
        background = new JLabel();
        Login.addActionListener(this);
        switchUser.addActionListener(this);

        
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

        Admin_Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Admin_Title.setText("Administrator");
        getContentPane().add(Admin_Title);
        Admin_Title.setBounds(380, 280, 150, 20);

        adminLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        adminLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin.png"))); // NOI18N
        adminLabel.setToolTipText("Login as Mechanic");
        getContentPane().add(adminLabel);
        adminLabel.setBounds(330, 80, 330, 240);
        getContentPane().add(adminPassword);
        adminPassword.setBounds(430, 370, 110, 30);

        password.setText("Password:");
        getContentPane().add(password);
        password.setBounds(370, 370, 80, 40);

        ID.setText("ID:");
        getContentPane().add(ID);
        ID.setBounds(410, 340, 15, 14);

        User_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_IDActionPerformed(evt);
            }
        });
        getContentPane().add(User_ID);
        User_ID.setBounds(430, 330, 110, 30);

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
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

    private void User_IDActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

	@Override
	 public void actionPerformed(ActionEvent e) 
	    {                                      
	    	 if (e.getSource() == Login) 
	    	 {
	    		 //new AdminMain().setVisible(true);
	    		 //new AdminLogin().setVisible(true);
	    		 try 
	    		 {
					Main m = new Main();
					m.search(User_ID.getText(), adminPassword.getPassword());
				 } 
	    		 catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    	 }
	    	 if (e.getSource() == switchUser) 
	    	 {
	    		 this.setVisible(false);
	    		 new StartPage().setVisible(true); 
	    	 }
	    	 
	    } 
                    
}
