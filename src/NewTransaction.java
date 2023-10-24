import javax.swing.*;
import java.sql.*;

public class NewTransaction extends javax.swing.JFrame {

    public NewTransaction() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        accountNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        depositBtn = new javax.swing.JButton();
        withdrawBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 150, 190));

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK SC Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NEW TRANSACTION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Noto Sans CJK KR Medium", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Account Number:");

        jLabel3.setFont(new java.awt.Font("Noto Sans CJK KR Medium", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Amount:");

//        amount.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                amountActionPerformed(evt);
//            }
//        });

        depositBtn.setBackground(new java.awt.Color(39, 150, 190));
        depositBtn.setFont(new java.awt.Font("Noto Sans CJK JP Medium", 1, 14)); // NOI18N
        depositBtn.setForeground(new java.awt.Color(255, 255, 255));
        depositBtn.setText("DEPOSIT");

        withdrawBtn.setBackground(new java.awt.Color(39, 150, 190));
        withdrawBtn.setFont(new java.awt.Font("Noto Sans CJK JP Medium", 1, 14)); // NOI18N
        withdrawBtn.setForeground(new java.awt.Color(255, 255, 255));
        withdrawBtn.setText("WITHDRAW");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(148, 148, 148)
                                                .addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(withdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(accountNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(withdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 65, Short.MAX_VALUE))
        );

        depositBtn.addActionListener(e -> {
            if(e.getSource() == depositBtn){
                try {
                    String account = accountNumber.getText();
                    Double moneyAmount = Double.parseDouble(amount.getText());

                    // Connect to the database
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

                    // Prepare a SQL statement to retrieve the row with the given account number
                    String sql = "SELECT * FROM Accounts WHERE AccountNumber = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, account);

                    // Execute the SQL statement and get the result set
                    ResultSet rs = stmt.executeQuery();

                    // Print out the values of the columns in the retrieved row
                    if (rs.next()) {
                        Double totalBalance = rs.getDouble("Balance");
                        totalBalance = totalBalance + moneyAmount;

                        PreparedStatement updateStmt = conn.prepareStatement("UPDATE Accounts SET Balance = ? WHERE AccountNumber = ?");
                        updateStmt.setDouble(1, totalBalance);
                        updateStmt.setString(2, account);

                        int rowsUpdated = updateStmt.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("Record updated successfully.");
                            JOptionPane.showMessageDialog(null, "Transaction Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible(false);

                            String insertSql = "INSERT INTO Transactions (AccountNumber, TransactionType, Amount, Date, Description, CurrentBalance) " +
                                    "VALUES (?, ?, ?, ?, ?, ?)";
                            // Insert a new row into the Transactions table
                            PreparedStatement insertPstmt = conn.prepareStatement(insertSql);
                            insertPstmt.setString(1, account);
                            insertPstmt.setString(2, "Deposit");
                            insertPstmt.setDouble(3, moneyAmount); // Assuming the salary is in thousands
                            insertPstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                            insertPstmt.setString(5, "Deposit" );
                            insertPstmt.setDouble(6, totalBalance);
                            insertPstmt.executeUpdate();
                        } else {
                            System.out.println("No records were updated.");
                            JOptionPane.showMessageDialog(null, "Transaction Failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        System.out.println("No accounts found with account number " + account);
                        JOptionPane.showMessageDialog(null, "No accounts found with account number " + account, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Close the resources
                    rs.close();
                    stmt.close();
                    conn.close();

                } catch (SQLException evt) {
                    evt.printStackTrace();
                } catch (NumberFormatException evt) {
                    JOptionPane.showMessageDialog(null, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        withdrawBtn.addActionListener(e -> {
            if(e.getSource() == withdrawBtn){
                try {
                    String account = accountNumber.getText();
                    Double moneyAmount = Double.parseDouble(amount.getText());

                    // Connect to the database
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

                    // Prepare a SQL statement to retrieve the row with the given account number
                    String sql = "SELECT * FROM Accounts WHERE AccountNumber = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, account);

                    // Execute the SQL statement and get the result set
                    ResultSet rs = stmt.executeQuery();

                    // Print out the values of the columns in the retrieved row
                    if (rs.next()) {
                        Double totalBalance = rs.getDouble("Balance");

                        if (totalBalance + 100 <= moneyAmount){
                            System.out.println("Insufficient Balance!");
                            JOptionPane.showMessageDialog(null, "Insufficient Balance! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String expectedPin = rs.getString("PinNumber");
                            String pin = JOptionPane.showInputDialog(null, "Enter your PIN number:", "PIN NUMBER", JOptionPane.PLAIN_MESSAGE);
                            System.out.println("PIN entered: " + pin);
                            System.out.println("Expected PIN: " + expectedPin);

                            if (pin != null && pin.equals(expectedPin)) {
                                totalBalance = totalBalance - moneyAmount;
                                PreparedStatement updateStmt = conn.prepareStatement("UPDATE Accounts SET Balance = ? WHERE AccountNumber = ?");
                                updateStmt.setDouble(1, totalBalance);
                                updateStmt.setString(2, account);

                                int rowsUpdated = updateStmt.executeUpdate();

                                if (rowsUpdated > 0) {
                                    System.out.println("Record updated successfully.");
                                    JOptionPane.showMessageDialog(null, "Transaction Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    this.setVisible(false);
                                } else {
                                    System.out.println("No records were updated.");
                                    JOptionPane.showMessageDialog(null, "Transaction Failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                                String insertSql = "INSERT INTO Transactions (AccountNumber, TransactionType, Amount, Date, Description, CurrentBalance) " +
                                        "VALUES (?, ?, ?, ?, ?, ?)";
                                // Insert a new row into the Transactions table
                                PreparedStatement insertPstmt = conn.prepareStatement(insertSql);
                                insertPstmt.setString(1, account);
                                insertPstmt.setString(2, "Withdraw");
                                insertPstmt.setDouble(3, moneyAmount); // Assuming the salary is in thousands
                                insertPstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                                insertPstmt.setString(5, "withdraw" );
                                insertPstmt.setDouble(6, totalBalance);
                                insertPstmt.executeUpdate();
                            } else {
                                System.out.println("Wrong PIN entered.");
                                JOptionPane.showMessageDialog(null, "Wrong PIN Number! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        System.out.println("No accounts found with account number " + account);
                        JOptionPane.showMessageDialog(null, "No accounts found with account number " + account, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Close the resources
                    rs.close();
                    stmt.close();
                    conn.close();

                } catch (SQLException evt) {
                    evt.printStackTrace();
                } catch (NumberFormatException evt) {
                    JOptionPane.showMessageDialog(null, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
    }// </editor-fold>

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
            java.util.logging.Logger.getLogger(NewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField accountNumber;
    private javax.swing.JTextField amount;
    private javax.swing.JButton depositBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton withdrawBtn;
    // End of variables declaration
}
