package javaapplication;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;

public class AdminMain extends JFrame
{

    public AdminMain() 
    {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
                      
    private void initComponents() {

        HeaderPanel = new javax.swing.JPanel();
        OptionPanel = new javax.swing.JPanel();
        addMember = new javax.swing.JButton();
        editMember = new javax.swing.JButton();
        deleteMember = new javax.swing.JButton();
        viewActivities = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        StaffActivities = new javax.swing.JPanel();
        jScrollPaneForStaffList2 = new javax.swing.JScrollPane();
        StaffList_activities = new javax.swing.JList();
        StaffActivitiesPanel = new javax.swing.JPanel();
        findButton_activities = new javax.swing.JButton();
        LabelForFind1 = new javax.swing.JLabel();
        find_activities = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DateSummary = new javax.swing.JScrollPane();
        Datelist_activities = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_activities = new javax.swing.JTextArea();
        DeleteStaff = new javax.swing.JPanel();
        jScrollPaneForStaffList1 = new javax.swing.JScrollPane();
        StaffList_delete = new javax.swing.JList();
        DeleteStaffPanel = new javax.swing.JPanel();
        LabelForFName2 = new javax.swing.JLabel();
        LabelForSName2 = new javax.swing.JLabel();
        LabelForConNumber2 = new javax.swing.JLabel();
        LabelForID1 = new javax.swing.JLabel();
        LabelForEmailAdd_delete = new javax.swing.JLabel();
        LabelForHomeAdd_delete = new javax.swing.JLabel();
        ID1_delete = new javax.swing.JLabel();
        Fname_delete = new javax.swing.JLabel();
        Sname_delete = new javax.swing.JLabel();
        ContactNo_delete = new javax.swing.JLabel();
        EmailAdd_delete = new javax.swing.JLabel();
        HomeAdd_delete = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        findButton_delete = new javax.swing.JButton();
        LabelForFind = new javax.swing.JLabel();
        find_delete = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        AddStaff = new javax.swing.JPanel();
        AddField = new javax.swing.JPanel();
        LabelForFname_add = new javax.swing.JLabel();
        LabelForSname_add = new javax.swing.JLabel();
        LabelForConNumber1 = new javax.swing.JLabel();
        LabelForEmailAdd_add = new javax.swing.JLabel();
        LabelForHomeAdd_add = new javax.swing.JLabel();
        LabelForPrevPwd_add = new javax.swing.JLabel();
        Fname_add = new javax.swing.JTextField();
        Sname_add = new javax.swing.JTextField();
        ContactNo_add = new javax.swing.JTextField();
        EmailAdd_add = new javax.swing.JTextField();
        HomeAdd_add = new javax.swing.JTextField();
        Pwd_add = new javax.swing.JTextField();
        LabelForNewPwd_add = new javax.swing.JLabel();
        RepeatPwd = new javax.swing.JTextField();
        Save_add = new javax.swing.JButton();
        Discard_add = new javax.swing.JButton();
        DropDown_add = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        EditStaff = new javax.swing.JPanel();
        jScrollPaneForStaffList = new javax.swing.JScrollPane();
        StaffList_edit = new javax.swing.JList();
        EditField = new javax.swing.JPanel();
        LabelForFName = new javax.swing.JLabel();
        LabelForSName = new javax.swing.JLabel();
        LabelForConNumber = new javax.swing.JLabel();
        LabelForID = new javax.swing.JLabel();
        LabelForEmailAdd = new javax.swing.JLabel();
        LabelForHomeAdd = new javax.swing.JLabel();
        LabelForPrevPwd = new javax.swing.JLabel();
        ID_edit = new javax.swing.JLabel();
        Fname_edit = new javax.swing.JTextField();
        Sname_edit = new javax.swing.JTextField();
        ContactNo_edit = new javax.swing.JTextField();
        EmailAdd_edit = new javax.swing.JTextField();
        HomeAdd_edit = new javax.swing.JTextField();
        OldPwd_edit = new javax.swing.JLabel();
        LabelForNewPwd = new javax.swing.JLabel();
        NewPwd_edit = new javax.swing.JTextField();
        Save_edit = new javax.swing.JButton();
        Discard_edit = new javax.swing.JButton();
        FooterPanel = new javax.swing.JPanel();
        copyrights = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        userName = new javax.swing.JLabel();
        currentDate = new javax.swing.JLabel();
        StartingPanel = new javax.swing.JPanel();
        startPanelLabel = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ARSS - Administrator");
        setMinimumSize(new java.awt.Dimension(938, 580));
        

        HeaderPanel.setBackground(new java.awt.Color(255, 255, 204));

        welcomeLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        welcomeLabel.setText("Welcome: ");

        logoutButton.setText("Logout");

        userName.setText("namegoeshere");

        currentDate.setText("dateandtimegoeshere");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderPanelLayout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderPanelLayout.createSequentialGroup()
                        .addComponent(currentDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 726, Short.MAX_VALUE)
                        .addComponent(logoutButton)))
                .addContainerGap())
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeLabel)
                    .addComponent(userName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(currentDate))
                .addContainerGap())
        );

        getContentPane().add(HeaderPanel, java.awt.BorderLayout.PAGE_START);

        OptionPanel.setBackground(new java.awt.Color(255, 255, 204));
        OptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));
        OptionPanel.setMaximumSize(new java.awt.Dimension(200, 301));
        OptionPanel.setMinimumSize(new java.awt.Dimension(200, 301));
        OptionPanel.setName(""); // NOI18N
        OptionPanel.setPreferredSize(new java.awt.Dimension(200, 301));
        OptionPanel.setLayout(new java.awt.GridLayout(0, 1, 1, 1));

        addMember.setText("Add Member");
        OptionPanel.add(addMember);

        editMember.setText("Edit Member");
        OptionPanel.add(editMember);
        
        deleteMember.setText("Delete Member");
        OptionPanel.add(deleteMember);

        viewActivities.setText("View Activities");
        OptionPanel.add(viewActivities);

        getContentPane().add(OptionPanel, java.awt.BorderLayout.LINE_START);

        ContentPanel.setLayout(new java.awt.CardLayout());
        
        StartingPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StartingPanel.setPreferredSize(new java.awt.Dimension(602, 247));

        startPanelLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startPanelLabel.setText("Click on the buttons on the left hand side to see specific views");

        javax.swing.GroupLayout StartingPanelLayout = new javax.swing.GroupLayout(StartingPanel);
        StartingPanel.setLayout(StartingPanelLayout);
        StartingPanelLayout.setHorizontalGroup(
            StartingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartingPanelLayout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(startPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        StartingPanelLayout.setVerticalGroup(
            StartingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartingPanelLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(startPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        ContentPanel.add(StartingPanel, "card0");

        StaffActivities.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StaffActivities.setPreferredSize(new java.awt.Dimension(602, 247));

        jScrollPaneForStaffList2.setPreferredSize(new java.awt.Dimension(50, 130));
        jScrollPaneForStaffList2.setRequestFocusEnabled(false);

        StaffList_activities.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Staff List", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        StaffList_activities.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StaffList_activities.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        jScrollPaneForStaffList2.setViewportView(StaffList_activities);

        StaffActivitiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Activities", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        findButton_activities.setText("Find");

        LabelForFind1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForFind1.setText("Find :");

        find_activities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find1ActionPerformed(evt);
            }
        });

        jLabel3.setText("(ID/First Name/Surname)");

        Datelist_activities.setBorder(javax.swing.BorderFactory.createTitledBorder("Date :"));
        Datelist_activities.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateSummary.setViewportView(Datelist_activities);

        textArea_activities.setColumns(20);
        textArea_activities.setRows(5);
        jScrollPane1.setViewportView(textArea_activities);

        javax.swing.GroupLayout StaffActivitiesPanelLayout = new javax.swing.GroupLayout(StaffActivitiesPanel);
        StaffActivitiesPanel.setLayout(StaffActivitiesPanelLayout);
        StaffActivitiesPanelLayout.setHorizontalGroup(
            StaffActivitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffActivitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StaffActivitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(StaffActivitiesPanelLayout.createSequentialGroup()
                        .addComponent(LabelForFind1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(StaffActivitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(findButton_activities, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(find_activities, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DateSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StaffActivitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        StaffActivitiesPanelLayout.setVerticalGroup(
            StaffActivitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffActivitiesPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(StaffActivitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForFind1)
                    .addComponent(find_activities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findButton_activities)
                .addGap(18, 18, 18)
                .addGroup(StaffActivitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(DateSummary, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout StaffActivitiesLayout = new javax.swing.GroupLayout(StaffActivities);
        StaffActivities.setLayout(StaffActivitiesLayout);
        StaffActivitiesLayout.setHorizontalGroup(
            StaffActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffActivitiesLayout.createSequentialGroup()
                .addComponent(jScrollPaneForStaffList2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StaffActivitiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        StaffActivitiesLayout.setVerticalGroup(
            StaffActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneForStaffList2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(StaffActivitiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentPanel.add(StaffActivities, "card4");

        DeleteStaff.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteStaff.setPreferredSize(new java.awt.Dimension(602, 247));

        jScrollPaneForStaffList1.setPreferredSize(new java.awt.Dimension(50, 40));
        jScrollPaneForStaffList1.setRequestFocusEnabled(false);

        StaffList_delete.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Staff List", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        StaffList_delete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StaffList_delete.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneForStaffList1.setViewportView(StaffList_delete);

        DeleteStaffPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delete Staff", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        LabelForFName2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForFName2.setText("First Name :");

        LabelForSName2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForSName2.setText("Surname :");

        LabelForConNumber2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForConNumber2.setText("Contact No :");

        LabelForID1.setText("ID :");

        LabelForEmailAdd_delete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForEmailAdd_delete.setText("Email Address :");

        LabelForHomeAdd_delete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForHomeAdd_delete.setText("Home Address :");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        findButton_delete.setText("Find");

        LabelForFind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForFind.setText("Find :");

        find_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });

        jLabel2.setText("(ID/First Name/Surname)");

        javax.swing.GroupLayout DeleteStaffPanelLayout = new javax.swing.GroupLayout(DeleteStaffPanel);
        DeleteStaffPanel.setLayout(DeleteStaffPanelLayout);
        DeleteStaffPanelLayout.setHorizontalGroup(
            DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteStaffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelForEmailAdd_delete)
                    .addComponent(LabelForHomeAdd_delete)
                    .addComponent(LabelForConNumber2)
                    .addComponent(LabelForSName2)
                    .addComponent(LabelForFName2)
                    .addComponent(LabelForID1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelForFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HomeAdd_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailAdd_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContactNo_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sname_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID1_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DeleteStaffPanelLayout.createSequentialGroup()
                        .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(findButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(find_delete, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Fname_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        DeleteStaffPanelLayout.setVerticalGroup(
            DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteStaffPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForFind)
                    .addComponent(find_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findButton_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForID1)
                    .addComponent(ID1_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fname_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelForFName2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForSName2)
                    .addComponent(Sname_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForConNumber2)
                    .addComponent(ContactNo_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForEmailAdd_delete)
                    .addComponent(EmailAdd_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DeleteStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForHomeAdd_delete)
                    .addComponent(HomeAdd_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout DeleteStaffLayout = new javax.swing.GroupLayout(DeleteStaff);
        DeleteStaff.setLayout(DeleteStaffLayout);
        DeleteStaffLayout.setHorizontalGroup(
            DeleteStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteStaffLayout.createSequentialGroup()
                .addComponent(jScrollPaneForStaffList1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteStaffPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        DeleteStaffLayout.setVerticalGroup(
            DeleteStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneForStaffList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DeleteStaffPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentPanel.add(DeleteStaff, "card3");

        AddStaff.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddStaff.setPreferredSize(new java.awt.Dimension(602, 247));

        AddField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Staff", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        LabelForFname_add.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForFname_add.setText("First Name :");

        LabelForSname_add.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForSname_add.setText("Surname :");

        LabelForConNumber1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForConNumber1.setText("Contact No :");

        LabelForEmailAdd_add.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForEmailAdd_add.setText("Email Address :");

        LabelForHomeAdd_add.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForHomeAdd_add.setText("Home Address :");

        LabelForPrevPwd_add.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForPrevPwd_add.setText("Password :");

        LabelForNewPwd_add.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForNewPwd_add.setText("Repeat Password :");

        Save_add.setText("Save");
        Save_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_addActionPerformed(evt);
            }
        });

        Discard_add.setText("Discard");

        DropDown_add.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Clerk", "Mechanic" }));
        DropDown_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropDown_addActionPerformed(evt);
            }
        });

        jLabel1.setText("Role :");

        javax.swing.GroupLayout AddFieldLayout = new javax.swing.GroupLayout(AddField);
        AddField.setLayout(AddFieldLayout);
        AddFieldLayout.setHorizontalGroup(
            AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddFieldLayout.createSequentialGroup()
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddFieldLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelForConNumber1)
                            .addComponent(LabelForSname_add)
                            .addComponent(LabelForFname_add)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fname_add, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(Sname_add, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(ContactNo_add, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(DropDown_add, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(AddFieldLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelForEmailAdd_add)
                        .addGap(18, 18, 18)
                        .addComponent(EmailAdd_add, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddFieldLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(LabelForHomeAdd_add)
                        .addGap(18, 18, 18)
                        .addComponent(HomeAdd_add, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddFieldLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(Save_add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(Discard_add)))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(AddFieldLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LabelForPrevPwd_add)
                .addGap(18, 18, 18)
                .addComponent(Pwd_add, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelForNewPwd_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RepeatPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        AddFieldLayout.setVerticalGroup(
            AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DropDown_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForFname_add)
                    .addComponent(Fname_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForSname_add)
                    .addComponent(Sname_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForConNumber1)
                    .addComponent(ContactNo_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForEmailAdd_add)
                    .addComponent(EmailAdd_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForHomeAdd_add)
                    .addComponent(HomeAdd_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForPrevPwd_add)
                    .addComponent(Pwd_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelForNewPwd_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RepeatPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(AddFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save_add)
                    .addComponent(Discard_add))
                .addContainerGap())
        );

        javax.swing.GroupLayout AddStaffLayout = new javax.swing.GroupLayout(AddStaff);
        AddStaff.setLayout(AddStaffLayout);
        AddStaffLayout.setHorizontalGroup(
            AddStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStaffLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(AddField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        AddStaffLayout.setVerticalGroup(
            AddStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentPanel.add(AddStaff, "card1");

        EditStaff.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EditStaff.setPreferredSize(new java.awt.Dimension(602, 247));

        jScrollPaneForStaffList.setPreferredSize(new java.awt.Dimension(50, 130));
        jScrollPaneForStaffList.setRequestFocusEnabled(false);

        StaffList_edit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Staff List", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        StaffList_edit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPaneForStaffList.setViewportView(StaffList_edit);

        EditField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Staff", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        LabelForFName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForFName.setText("First Name :");

        LabelForSName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForSName.setText("Surname :");

        LabelForConNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForConNumber.setText("Contact No :");

        LabelForID.setText("ID :");

        LabelForEmailAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForEmailAdd.setText("Email Address :");

        LabelForHomeAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForHomeAdd.setText("Home Address :");

        LabelForPrevPwd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForPrevPwd.setText("Old Password :");

        LabelForNewPwd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelForNewPwd.setText("New Password :");

        Save_edit.setText("Save");
        Save_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Discard_edit.setText("Discard");

        javax.swing.GroupLayout EditFieldLayout = new javax.swing.GroupLayout(EditField);
        EditField.setLayout(EditFieldLayout);
        EditFieldLayout.setHorizontalGroup(
            EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditFieldLayout.createSequentialGroup()
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditFieldLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelForConNumber)
                            .addComponent(LabelForSName)
                            .addComponent(LabelForFName)
                            .addComponent(LabelForID, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fname_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sname_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ContactNo_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EditFieldLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelForEmailAdd)
                        .addGap(18, 18, 18)
                        .addComponent(EmailAdd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditFieldLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(LabelForHomeAdd)
                        .addGap(18, 18, 18)
                        .addComponent(HomeAdd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditFieldLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelForPrevPwd)
                            .addComponent(LabelForNewPwd))
                        .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditFieldLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Save_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Discard_edit))
                            .addGroup(EditFieldLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(OldPwd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditFieldLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NewPwd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        
        EditFieldLayout.setVerticalGroup(
            EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditFieldLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForID)
                    .addComponent(ID_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForFName)
                    .addComponent(Fname_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForSName)
                    .addComponent(Sname_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForConNumber)
                    .addComponent(ContactNo_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForEmailAdd)
                    .addComponent(EmailAdd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForHomeAdd)
                    .addComponent(HomeAdd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForPrevPwd)
                    .addComponent(OldPwd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelForNewPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPwd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(EditFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save_edit)
                    .addComponent(Discard_edit))
                .addContainerGap())
        );

        LabelForEmailAdd.getAccessibleContext().setAccessibleName("Email Address");

        javax.swing.GroupLayout EditStaffLayout = new javax.swing.GroupLayout(EditStaff);
        EditStaff.setLayout(EditStaffLayout);
        EditStaffLayout.setHorizontalGroup(
            EditStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditStaffLayout.createSequentialGroup()
                .addComponent(jScrollPaneForStaffList, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        EditStaffLayout.setVerticalGroup(
            EditStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneForStaffList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EditField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentPanel.add(EditStaff, "card2");
        
        

        getContentPane().add(ContentPanel, BorderLayout.CENTER);

        copyrights.setText("Copyrights 2013, DIT E-Soft Division");

        javax.swing.GroupLayout FooterPanelLayout = new javax.swing.GroupLayout(FooterPanel);
        FooterPanel.setLayout(FooterPanelLayout);
        FooterPanelLayout.setHorizontalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterPanelLayout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
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

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {}                                    

    private void Save_addActionPerformed(java.awt.event.ActionEvent evt) {}                                     

    private void DropDown_addActionPerformed(java.awt.event.ActionEvent evt) {}                                          

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {}                                            

    private void findActionPerformed(java.awt.event.ActionEvent evt) {}                                    

    private void find1ActionPerformed(java.awt.event.ActionEvent evt) {}
    
    //@SuppressWarnings({ "unchecked", "rawtypes" })
	
    
    void buttonListener(ActionListener listen)
    {
    	addMember.addActionListener(listen);
    	Save_add.addActionListener(listen);
    	Discard_add.addActionListener(listen);
    	deleteMember.addActionListener(listen);
    	viewActivities.addActionListener(listen);
    	editMember.addActionListener(listen);
    	Save_edit.addActionListener(listen);
    	Discard_edit.addActionListener(listen);
    	deleteButton.addActionListener(listen);
    	
    }
    
    void listSelectionListener(ListSelectionListener listen)
    {
    	Datelist_activities.addListSelectionListener(listen);
    	StaffList_edit.addListSelectionListener(listen);
    	StaffList_delete.addListSelectionListener(listen);
    	StaffList_activities.addListSelectionListener(listen);
    	StaffList_delete.addListSelectionListener(listen);
    }
 
  
    // Variables declaration - do not modify                     
    private javax.swing.JPanel AddField;
    private javax.swing.JPanel AddStaff;
    protected javax.swing.JTextField ContactNo_edit;
    protected javax.swing.JTextField ContactNo_add;
    protected javax.swing.JLabel ContactNo_delete;
    protected javax.swing.JPanel ContentPanel;
    @SuppressWarnings("rawtypes")
	protected javax.swing.JList Datelist_activities;
    private javax.swing.JScrollPane DateSummary;
    private javax.swing.JPanel DeleteStaff;
    private javax.swing.JPanel DeleteStaffPanel;
    protected javax.swing.JButton Discard_edit;
    protected javax.swing.JButton Discard_add;
    private javax.swing.JPanel EditField;
    private javax.swing.JPanel EditStaff;
    protected javax.swing.JTextField EmailAdd_edit;
    protected javax.swing.JTextField EmailAdd_add;
    protected javax.swing.JLabel EmailAdd_delete;
    protected javax.swing.JTextField Fname_edit;
    protected javax.swing.JTextField Fname_add;
    protected javax.swing.JLabel Fname_delete;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    protected javax.swing.JTextField HomeAdd_edit;
    protected javax.swing.JTextField HomeAdd_add;
    protected javax.swing.JLabel HomeAdd_delete;
    protected javax.swing.JLabel ID_edit;
    protected javax.swing.JLabel ID1_delete;
    private javax.swing.JLabel LabelForConNumber;
    private javax.swing.JLabel LabelForConNumber1;
    private javax.swing.JLabel LabelForConNumber2;
    private javax.swing.JLabel LabelForEmailAdd;
    private javax.swing.JLabel LabelForEmailAdd_add;
    private javax.swing.JLabel LabelForEmailAdd_delete;
    private javax.swing.JLabel LabelForFName;
    private javax.swing.JLabel LabelForFname_add;
    private javax.swing.JLabel LabelForFName2;
    private javax.swing.JLabel LabelForFind;
    private javax.swing.JLabel LabelForFind1;
    private javax.swing.JLabel LabelForHomeAdd;
    private javax.swing.JLabel LabelForHomeAdd_add;
    private javax.swing.JLabel LabelForHomeAdd_delete;
    private javax.swing.JLabel LabelForID;
    private javax.swing.JLabel LabelForID1;
    private javax.swing.JLabel LabelForNewPwd;
    private javax.swing.JLabel LabelForNewPwd_add;
    private javax.swing.JLabel LabelForPrevPwd;
    private javax.swing.JLabel LabelForPrevPwd_add;
    private javax.swing.JLabel LabelForSName;
    private javax.swing.JLabel LabelForSname_add;
    private javax.swing.JLabel LabelForSName2;
    protected javax.swing.JTextField NewPwd_edit;
    protected javax.swing.JLabel OldPwd_edit;
    private javax.swing.JPanel OptionPanel;
    protected javax.swing.JTextField Pwd_add;
    protected javax.swing.JTextField RepeatPwd;
    protected javax.swing.JButton Save_edit;
    protected javax.swing.JButton Save_add;
    protected javax.swing.JTextField Sname_edit;
    protected javax.swing.JTextField Sname_add;
    protected javax.swing.JLabel Sname_delete;
    private javax.swing.JPanel StaffActivities;
    private javax.swing.JPanel StaffActivitiesPanel;
    @SuppressWarnings("rawtypes")
	protected javax.swing.JList StaffList_edit;
    @SuppressWarnings("rawtypes")
	protected javax.swing.JList StaffList_delete;
    @SuppressWarnings("rawtypes")
	protected javax.swing.JList StaffList_activities;
    protected javax.swing.JButton addMember;
    protected javax.swing.JButton deleteButton;
    protected javax.swing.JButton deleteMember;
    protected javax.swing.JButton editMember;
    protected javax.swing.JTextField find_delete;
    protected javax.swing.JTextField find_activities;
    protected javax.swing.JButton findButton_delete;
    protected javax.swing.JButton findButton_activities;
    @SuppressWarnings("rawtypes")
	protected javax.swing.JComboBox DropDown_add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneForStaffList;
    private javax.swing.JScrollPane jScrollPaneForStaffList1;
    private javax.swing.JScrollPane jScrollPaneForStaffList2;
    protected javax.swing.JTextArea textArea_activities;
    protected javax.swing.JButton viewActivities;
    private javax.swing.JLabel copyrights;
    private javax.swing.JPanel StartingPanel;
	private javax.swing.JLabel welcomeLabel;
	protected javax.swing.JLabel userName;
	protected javax.swing.JLabel currentDate;
	protected javax.swing.JButton logoutButton;
	private javax.swing.JLabel startPanelLabel;
    // End of variables declaration   
    

}
