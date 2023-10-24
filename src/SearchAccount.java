import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SearchAccount extends javax.swing.JFrame {

    public SearchAccount() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        accountNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pinNumber = new javax.swing.JPasswordField();
        backBtn = new javax.swing.JButton();
        searchResult = new javax.swing.JPanel();
        searchBtn1 = new javax.swing.JButton();
        final String[] pinNum = new String[1];

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 150, 190));

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEARCH ACCOUNT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Noto Serif CJK KR Medium", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Account Number:");

        jLabel3.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Pin Number: ");

        backBtn.setBackground(new java.awt.Color(37, 150, 190));
        backBtn.setFont(new java.awt.Font("Noto Sans CJK SC Medium", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");

        javax.swing.GroupLayout searchResultLayout = new javax.swing.GroupLayout(searchResult);
        searchResult.setLayout(searchResultLayout);
        searchResultLayout.setHorizontalGroup(
                searchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 700, Short.MAX_VALUE)
        );
        searchResultLayout.setVerticalGroup(
                searchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 290, Short.MAX_VALUE)
        );

        searchBtn1.setBackground(new java.awt.Color(37, 150, 190));
        searchBtn1.setFont(new java.awt.Font("Noto Sans CJK SC Medium", 1, 14)); // NOI18N
        searchBtn1.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn1.setText("SEARCH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(pinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(searchResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(pinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(searchBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 13, Short.MAX_VALUE))
        );

        JButton updateBtn = new JButton("UPDATE");
        JTextField firstNameTextField = new JTextField();
        JTextField lastNameTextField = new JTextField();
        JTextField accountTypeTextField= new JTextField();
        JTextField balanceTextField = new JTextField();


        searchBtn1.addActionListener(e -> {
            if(e.getSource() == searchBtn1){
                String accountnumber = accountNumber.getText();
                char[] pinnumber = pinNumber.getPassword();
                pinNum[0] = new String(pinnumber);

                // Connect to the database
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

                    // Query the database
                    String sql = "SELECT * FROM Accounts WHERE AccountNumber = ? AND PinNumber = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, accountnumber);
                    stmt.setString(2, pinNum[0]);
                    ResultSet rs = stmt.executeQuery();

                    // Display the search results
                    JLabel searchResultLabel, firstNameLabel, lastNameLabel, phoneNumberLabel, addressLabel;

                    searchResultLabel = new JLabel("SEARCH RESULTS ");
                    searchResultLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
                    searchResultLabel.setBounds(200, 20, 200, 50);

                    firstNameLabel = new JLabel("First Name: ");
                    firstNameLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
                    firstNameLabel.setBounds(100, 70, 150, 40);

                    lastNameLabel = new JLabel("Last Name: ");
                    lastNameLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
                    lastNameLabel.setBounds(100, 120, 150, 40);

                    phoneNumberLabel = new JLabel("Phone Number: ");
                    phoneNumberLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
                    phoneNumberLabel.setBounds(100, 170, 150, 40);

                    addressLabel = new JLabel("Address: ");
                    addressLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
                    addressLabel.setBounds(100, 210, 150, 40);

                    updateBtn.setBounds(550, 220, 140, 40);
                    updateBtn.setBackground(new Color(39, 150, 190) );
                    updateBtn.setForeground(Color.WHITE);
                    updateBtn.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14));

                    while (rs.next()) {
                        firstNameTextField.setText(rs.getString("FirstName"));
                        firstNameTextField.setBounds(250, 70, 250,40);

                        lastNameTextField.setText(rs.getString("LastName"));
                        lastNameTextField.setBounds(250, 120, 250,40);

                        accountTypeTextField.setText(rs.getString("PhoneNumber"));
                        accountTypeTextField.setBounds(250, 170, 250,40);

                        balanceTextField.setText(rs.getString("Address"));
                        balanceTextField.setBounds(250, 220, 250,40);

                    }

                    searchResult.setLayout(null);
                    searchResult.setBackground(new Color(242, 242, 242) );

                    searchResult.add(searchResultLabel);
                    searchResult.add(firstNameLabel);
                    searchResult.add(firstNameTextField);
                    searchResult.add(lastNameLabel);
                    searchResult.add(lastNameTextField);
                    searchResult.add(phoneNumberLabel);
                    searchResult.add(accountTypeTextField);
                    searchResult.add(addressLabel);
                    searchResult.add(balanceTextField);
                    searchResult.add(updateBtn);

                    // Close the database connection
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });

        backBtn.addActionListener(e ->{
            if(e.getSource() == backBtn){
                EmployeePage employeePage = new EmployeePage();
                employeePage.setVisible(true);
                this.setVisible(false);
            }
        });

        updateBtn.addActionListener(e -> {
            if(e.getSource() == updateBtn){
                try {
                    // Create a connection to the database
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

                    // Create a PreparedStatement for the update query
                    PreparedStatement stmt = conn.prepareStatement("UPDATE Accounts SET FirstName = ?, LastName = ?, PhoneNumber = ?, Address = ? WHERE PinNumber = ?");

                    // Set the values for the update query parameters
                    stmt.setString(1, firstNameTextField.getText());
                    stmt.setString(2, lastNameTextField.getText());
                    stmt.setString(3, accountTypeTextField.getText());
                    stmt.setString(4, balanceTextField.getText());
                    stmt.setInt(5, Integer.parseInt(pinNum[0])); // set the value of the id parameter to the id of the record you want to update

                    // Execute the update query
                    int rowsUpdated = stmt.executeUpdate();

                    if (rowsUpdated > 0) {
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Record updated successfully.");
                        System.out.println("Record updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No records were updated.");
                        System.out.println("No records were updated.");
                    }

                    // Close the PreparedStatement and the database connection
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        pack();
    }// </editor-fold>


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField accountNumber;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pinNumber;
    private javax.swing.JButton searchBtn1;
    private javax.swing.JPanel searchResult;
    // End of variables declaration
}
