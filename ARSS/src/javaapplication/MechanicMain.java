
package javaapplication;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;


public class MechanicMain extends javax.swing.JFrame 
{

    private javax.swing.JLabel jLabel14;
	protected javax.swing.JButton view1_add;
	protected javax.swing.JTextField endDate_view;
	private javax.swing.JLabel jLabel16;
	protected javax.swing.JTextField startDate_view;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel40;
	public MechanicMain() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        HeaderPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        userName = new javax.swing.JLabel();
        currentDate = new javax.swing.JLabel();
        OptionPanel = new javax.swing.JPanel();
        addRepair = new javax.swing.JButton();
        viewRepair = new javax.swing.JButton();
        orderParts = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        StartingPanel = new javax.swing.JPanel();
        startPanelLabel = new javax.swing.JLabel();
        addRepairPanel = new javax.swing.JPanel();
        addNewRepair = new javax.swing.JPanel();
        LabelForFName2 = new javax.swing.JLabel();
        LabelForSName2 = new javax.swing.JLabel();
        LabelForID1 = new javax.swing.JLabel();
        partsID_add = new javax.swing.JTextField();
        carID_add = new javax.swing.JTextField();
        Save_add = new javax.swing.JButton();
        Discard_add = new javax.swing.JButton();
        add1_add = new javax.swing.JButton();
        add2_add = new javax.swing.JButton();
        bookingID_add = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BookingList_add = new javax.swing.JList();
        view_add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PartsList_add = new javax.swing.JList();
        orderPartsPanel = new javax.swing.JPanel();
        orderPanel = new javax.swing.JPanel();
        save_order = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        description_order = new javax.swing.JTextArea();
        addNewParts = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        productNoAdd_order = new javax.swing.JTextField();
        descriptionAdd_order = new javax.swing.JTextField();
        priceAdd_order = new javax.swing.JTextField();
        typeAdd_order = new javax.swing.JComboBox();
        add_order = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PartsList_order = new javax.swing.JList();
        viewRepairsPanel = new javax.swing.JPanel();
        viewRepairsPane = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        repairList_view = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ID_view = new javax.swing.JTextField();
        bookingID_view = new javax.swing.JTextField();
        carID_view = new javax.swing.JTextField();
        partID_view = new javax.swing.JTextField();
        totalCharge_view = new javax.swing.JTextField();
        status_view = new javax.swing.JTextField();
        repairLength_view = new javax.swing.JTextField();
        completeButton_view = new javax.swing.JButton();
        FooterPanel = new javax.swing.JPanel();
        copyrights = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        view1_add = new javax.swing.JButton();
        startDate_view = new javax.swing.JTextField();
        endDate_view = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        
        jLabel2.setText("jLabel2");
        bookingID_add.setEditable(false);
        ID_view.setEditable(false);
        carID_view.setEditable(false);
        partID_view.setEditable(false);
        startDate_view.setEditable(false);
        endDate_view.setEditable(false);
        repairLength_view.setEditable(false);
        totalCharge_view.setEditable(false);
        bookingID_view.setEditable(false);
        status_view.setEditable(false);
        
   
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(938, 580));
        setPreferredSize(new java.awt.Dimension(916, 421));
        setTitle("ARSS - Mechanic");
        setResizable(false);
        
        //------------------------------------------------------Header Panel Starts--------------------------------------------------//
        HeaderPanel.setBackground(new java.awt.Color(255, 255, 204));

        welcomeLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        welcomeLabel.setText("Welcome: ");

        logoutButton.setText("Logout");

        userName.setText("namegoeshere");

        currentDate.setText("dateandtimegoeshere");

        jLabel40.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel40.setText("Mechanic");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderPanelLayout.createSequentialGroup()
                        .addComponent(currentDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton)
                        .addContainerGap())
                    .addGroup(HeaderPanelLayout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
                        .addComponent(jLabel40))))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(welcomeLabel)
                            .addComponent(userName)))
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(currentDate))
                .addContainerGap())
        );

        getContentPane().add(HeaderPanel, java.awt.BorderLayout.PAGE_START);

        
        //------------------------------------------------------Options Panel Starts--------------------------------------------------//
        OptionPanel.setBackground(new java.awt.Color(255, 255, 204));
        OptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));
        OptionPanel.setMaximumSize(new java.awt.Dimension(200, 301));
        OptionPanel.setMinimumSize(new java.awt.Dimension(200, 301));
        OptionPanel.setName(""); // NOI18N
        OptionPanel.setPreferredSize(new java.awt.Dimension(200, 301));
        OptionPanel.setLayout(new java.awt.GridLayout(0, 1, 1, 1));

        addRepair.setText("New Repair");
        OptionPanel.add(addRepair);

        viewRepair.setText("View Repairs");
        OptionPanel.add(viewRepair);

        orderParts.setText("Order Parts");
        OptionPanel.add(orderParts);

        getContentPane().add(OptionPanel, java.awt.BorderLayout.LINE_START);

        
        //------------------------------------------------------Content Panel Starts--------------------------------------------------//
        ContentPanel.setLayout(new java.awt.CardLayout());

        
        //------------------------------------------------------Starting Panel Starts--------------------------------------------------//
        StartingPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StartingPanel.setPreferredSize(new java.awt.Dimension(602, 247));

        startPanelLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startPanelLabel.setText("Click on the buttons on the left hand side to see specific views");

        javax.swing.GroupLayout StartingPanelLayout = new javax.swing.GroupLayout(StartingPanel);
        StartingPanel.setLayout(StartingPanelLayout);
        StartingPanelLayout.setHorizontalGroup(
            StartingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartingPanelLayout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(startPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        StartingPanelLayout.setVerticalGroup(
            StartingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartingPanelLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(startPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        ContentPanel.add(StartingPanel, "card0");

        //------------------------------------------------------Add Repair Panel Starts--------------------------------------------------//
        addRepairPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addRepairPanel.setPreferredSize(new java.awt.Dimension(506, 311));

        addNewRepair.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add new repair", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        LabelForFName2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForFName2.setText("Car Reg Number:");

        LabelForSName2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForSName2.setText("Booking ID:");

        LabelForID1.setText("Parts ID :");

        partsID_add.setEditable(false);
        partsID_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partsID_addActionPerformed(evt);
            }
        });

        Save_add.setText("Save");
        Save_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_addActionPerformed(evt);
            }
        });

        Discard_add.setText("Discard");

        add1_add.setText("Add");

        add2_add.setText("Add");

        jLabel1.setText("(For cars not on database)");

        javax.swing.GroupLayout addNewRepairLayout = new javax.swing.GroupLayout(addNewRepair);
        addNewRepair.setLayout(addNewRepairLayout);
        addNewRepairLayout.setHorizontalGroup(
            addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNewRepairLayout.createSequentialGroup()
                .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addNewRepairLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Discard_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Save_add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addNewRepairLayout.createSequentialGroup()
                        .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add1_add)
                            .addComponent(add2_add))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNewRepairLayout.createSequentialGroup()
                                .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LabelForSName2)
                                    .addComponent(LabelForFName2))
                                .addGap(18, 18, 18)
                                .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bookingID_add)
                                    .addComponent(carID_add, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNewRepairLayout.createSequentialGroup()
                                .addComponent(LabelForID1)
                                .addGap(18, 18, 18)
                                .addComponent(partsID_add, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(75, 75, 75))
        );
        addNewRepairLayout.setVerticalGroup(
            addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewRepairLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add1_add)
                        .addComponent(LabelForID1)
                        .addComponent(partsID_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addNewRepairLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelForSName2)
                            .addComponent(bookingID_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelForFName2)
                            .addComponent(carID_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add2_add)
                .addGap(42, 42, 42)
                .addGroup(addNewRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save_add)
                    .addComponent(Discard_add))
                .addGap(26, 26, 26))
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Booking List"));

        jScrollPane3.setViewportView(BookingList_add);

        view_add.setText("View");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("All Parts List"));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 50));

        PartsList_add.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(PartsList_add);

        view1_add.setText("View");

        javax.swing.GroupLayout addRepairPanelLayout = new javax.swing.GroupLayout(addRepairPanel);
        addRepairPanel.setLayout(addRepairPanelLayout);
        addRepairPanelLayout.setHorizontalGroup(
            addRepairPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRepairPanelLayout.createSequentialGroup()
                .addGroup(addRepairPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(view_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(view1_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNewRepair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addRepairPanelLayout.setVerticalGroup(
            addRepairPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addNewRepair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(addRepairPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(view1_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_add))
        );

        
        ContentPanel.add(addRepairPanel, "card1");

        
        //------------------------------------------------------Order Parts Panel Starts--------------------------------------------------//
        orderPartsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        orderPartsPanel.setPreferredSize(new java.awt.Dimension(602, 247));

        orderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order Parts", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        save_order.setText("Place Order");
        save_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_orderActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        description_order.setEditable(false);
        description_order.setColumns(20);
        description_order.setRows(5);
        jScrollPane4.setViewportView(description_order);

        addNewParts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add new parts", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel3.setText("Product Number :");

        jLabel4.setText("Description :");

        jLabel5.setText("Price (€):");

        jLabel6.setText("Type :");

        descriptionAdd_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionAdd_orderActionPerformed(evt);
            }
        });

        priceAdd_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceAdd_orderActionPerformed(evt);
            }
        });

        typeAdd_order.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Body Parts", "Brake Parts", "Cooling/Heating Parts", "Electrica Parts", "Exhaust Parts", "Engine Parts", "Hydraulics Parts", "Transmission Parts", "Fluids" }));

        add_order.setText("Add");

        javax.swing.GroupLayout addNewPartsLayout = new javax.swing.GroupLayout(addNewParts);
        addNewParts.setLayout(addNewPartsLayout);
        addNewPartsLayout.setHorizontalGroup(
            addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewPartsLayout.createSequentialGroup()
                .addGroup(addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productNoAdd_order)
                    .addComponent(descriptionAdd_order)
                    .addComponent(priceAdd_order)
                    .addComponent(typeAdd_order, 0, 163, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNewPartsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(add_order, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        addNewPartsLayout.setVerticalGroup(
            addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewPartsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productNoAdd_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(typeAdd_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionAdd_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priceAdd_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(add_order))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Part Details");

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(save_order, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(addNewParts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(save_order))
                    .addComponent(addNewParts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("All Parts List"));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 50));

        PartsList_order.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(PartsList_order);

        javax.swing.GroupLayout orderPartsPanelLayout = new javax.swing.GroupLayout(orderPartsPanel);
        orderPartsPanel.setLayout(orderPartsPanelLayout);
        orderPartsPanelLayout.setHorizontalGroup(
            orderPartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPartsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orderPartsPanelLayout.setVerticalGroup(
            orderPartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentPanel.add(orderPartsPanel, "card3");

        
        //------------------------------------------------------View Repairs Panel Starts--------------------------------------------------//
        viewRepairsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewRepairsPanel.setPreferredSize(new java.awt.Dimension(602, 247));

        viewRepairsPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Repairs", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Repair List"));
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        repairList_view.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(repairList_view);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Repair Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("ID :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Booking ID :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Car ID :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Part ID :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Total Charge (€) :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Status :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Repair Length (hours) :");

        partID_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partID_viewActionPerformed(evt);
            }
        });

        status_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_viewActionPerformed(evt);
            }
        });

        completeButton_view.setText("Complete");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Start Date :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("End Date :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carID_view, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(partID_view, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bookingID_view, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(totalCharge_view)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ID_view, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(repairLength_view, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startDate_view, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(endDate_view)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status_view, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(completeButton_view, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ID_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(repairLength_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(carID_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(totalCharge_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(partID_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(bookingID_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(startDate_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(endDate_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(status_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(completeButton_view, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout viewRepairsPaneLayout = new javax.swing.GroupLayout(viewRepairsPane);
        viewRepairsPane.setLayout(viewRepairsPaneLayout);
        viewRepairsPaneLayout.setHorizontalGroup(
            viewRepairsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewRepairsPaneLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewRepairsPaneLayout.setVerticalGroup(
            viewRepairsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout viewRepairsPanelLayout = new javax.swing.GroupLayout(viewRepairsPanel);
        viewRepairsPanel.setLayout(viewRepairsPanelLayout);
        viewRepairsPanelLayout.setHorizontalGroup(
            viewRepairsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewRepairsPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(viewRepairsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewRepairsPanelLayout.setVerticalGroup(
            viewRepairsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewRepairsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentPanel.add(viewRepairsPanel, "card2");

        getContentPane().add(ContentPanel, java.awt.BorderLayout.CENTER);

        
        //------------------------------------------------------Footer Panel Starts--------------------------------------------------//
        FooterPanel.setBackground(new java.awt.Color(204, 204, 204));

        copyrights.setText("Copyrights 2013, DIT E-Soft Division");

        javax.swing.GroupLayout FooterPanelLayout = new javax.swing.GroupLayout(FooterPanel);
        FooterPanel.setLayout(FooterPanelLayout);
        FooterPanelLayout.setHorizontalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterPanelLayout.createSequentialGroup()
                .addContainerGap(399, Short.MAX_VALUE)
                .addComponent(copyrights)
                .addGap(364, 364, 364))
        );
        FooterPanelLayout.setVerticalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(copyrights))
        );

        getContentPane().add(FooterPanel, java.awt.BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }// </editor-fold>                        

    private void partsID_addActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void Save_addActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void save_orderActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void descriptionAdd_orderActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void priceAdd_orderActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void partID_viewActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void status_viewActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    void buttonListener(ActionListener listen)
    {
    	Discard_add.addActionListener(listen);
    	logoutButton.addActionListener(listen);
    	Save_add.addActionListener(listen);
    	add1_add.addActionListener(listen);
    	add2_add.addActionListener(listen);
    	addRepair.addActionListener(listen);
    	add_order.addActionListener(listen);
    	completeButton_view.addActionListener(listen);
    	orderParts.addActionListener(listen);
    	save_order.addActionListener(listen);
    	viewRepair.addActionListener(listen);
    	view_add.addActionListener(listen);
    	view1_add.addActionListener(listen);
    }
    
    void listSelectionListener(ListSelectionListener listen)
    {
    	BookingList_add.addListSelectionListener(listen);
    	PartsList_add.addListSelectionListener(listen);
    	PartsList_order.addListSelectionListener(listen);
    	repairList_view.addListSelectionListener(listen);
    }
    
    // Variables declaration - do not modify                     
    protected javax.swing.JList BookingList_add;
    protected javax.swing.JPanel ContentPanel;
    protected javax.swing.JButton Discard_add;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    protected javax.swing.JTextField ID_view;
    private javax.swing.JLabel LabelForFName2;
    private javax.swing.JLabel LabelForID1;
    private javax.swing.JLabel LabelForSName2;
    private javax.swing.JPanel OptionPanel;
    protected javax.swing.JList PartsList_add;
    protected javax.swing.JList PartsList_order;
    protected javax.swing.JButton Save_add;
    private javax.swing.JPanel StartingPanel;
    protected javax.swing.JButton add1_add;
    protected javax.swing.JButton add2_add;
    private javax.swing.JPanel addNewParts;
    private javax.swing.JPanel addNewRepair;
    protected javax.swing.JButton addRepair;
    private javax.swing.JPanel addRepairPanel;
    protected javax.swing.JButton add_order;
    protected javax.swing.JTextField bookingID_add;
    protected javax.swing.JTextField bookingID_view;
    protected javax.swing.JTextField carID_add;
    protected javax.swing.JTextField carID_view;
    protected javax.swing.JButton completeButton_view;
    private javax.swing.JLabel copyrights;
    protected javax.swing.JLabel currentDate;
    protected javax.swing.JTextField descriptionAdd_order;
    protected javax.swing.JTextArea description_order;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    protected javax.swing.JButton logoutButton;
    private javax.swing.JPanel orderPanel;
    protected javax.swing.JButton orderParts;
    private javax.swing.JPanel orderPartsPanel;
    protected javax.swing.JTextField partID_view;
    protected javax.swing.JTextField partsID_add;
    protected javax.swing.JTextField priceAdd_order;
    protected javax.swing.JTextField productNoAdd_order;
    protected javax.swing.JTextField repairLength_view;
    protected javax.swing.JList repairList_view;
    protected javax.swing.JButton save_order;
    private javax.swing.JLabel startPanelLabel;
    protected javax.swing.JTextField status_view;
    protected javax.swing.JTextField totalCharge_view;
    protected javax.swing.JComboBox typeAdd_order;
    protected javax.swing.JLabel userName;
    protected javax.swing.JButton viewRepair;
    private javax.swing.JPanel viewRepairsPane;
    private javax.swing.JPanel viewRepairsPanel;
    protected javax.swing.JButton view_add;
    protected javax.swing.JLabel welcomeLabel;
    // End of variables declaration                   
}
