
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PayrollPage extends javax.swing.JFrame {

    public PayrollPage() {
        initComponents();
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selectAllBtn = new javax.swing.JButton();
        payWagesBtn = new javax.swing.JButton();
        employeeListPanel = new javax.swing.JPanel();

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 612, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 296, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 150, 190));

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYEES PAYROLL PAGE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(190, 190, 190))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selectAllBtn.setBackground(new java.awt.Color(37, 150, 190));
        selectAllBtn.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        selectAllBtn.setForeground(new java.awt.Color(255, 255, 255));
        selectAllBtn.setText("SELECT ALL");

        payWagesBtn.setBackground(new java.awt.Color(37, 150, 190));
        payWagesBtn.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        payWagesBtn.setForeground(new java.awt.Color(255, 255, 255));
        payWagesBtn.setText("PAY WAGES");

        javax.swing.GroupLayout employeeListPanelLayout = new javax.swing.GroupLayout(employeeListPanel);
        employeeListPanel.setLayout(employeeListPanelLayout);
        employeeListPanelLayout.setHorizontalGroup(
                employeeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 592, Short.MAX_VALUE)
        );
        employeeListPanelLayout.setVerticalGroup(
                employeeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 310, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(payWagesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(employeeListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(employeeListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(payWagesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
        );

        try{
            String url = "jdbc:mysql://localhost:3306/Cash_Flow_Bank";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Use FlowLayout for the checkbox panel with vertical alignment
            JPanel checkboxPanel = new JPanel();
            checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));

// Add each employee name as a checkbox to the panel
            while (rs.next()) {
                String employeeName = rs.getString("FirstName") + " " + rs.getString("LastName");
                JCheckBox checkbox = new JCheckBox(employeeName);
                checkbox.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 16));
                checkboxPanel.add(checkbox);
            }

            selectAllBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Component[] components = checkboxPanel.getComponents();
                    for (Component component : components) {
                        if (component instanceof JCheckBox) {
                            JCheckBox checkbox = (JCheckBox) component;
                            checkbox.setSelected(true);
                        }
                    }
                }
            });

// Add the checkbox panel to the content panel
            employeeListPanel.add(checkboxPanel);

// Set the layout manager of the content panel to BoxLayout for vertical alignment
            employeeListPanel.setLayout(new BoxLayout(employeeListPanel, BoxLayout.Y_AXIS));
            employeeListPanel.add(checkboxPanel);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        payWagesBtn.addActionListener(e -> {
            if (e.getSource() == payWagesBtn) {
                String url = "jdbc:mysql://localhost:3306/Cash_Flow_Bank";
                String user = "root";
                String password = "";

                try {
                    // Create a connection to the database
                    Connection conn = DriverManager.getConnection(url, user, password);

                    // Create a prepared statement for the update query
                    String updateSql = "UPDATE Accounts AS a " +
                            "INNER JOIN Employees AS e ON a.AccountNumber = e.AccountNumber " +
                            "SET a.Balance = a.Balance + e.Salary " +
                            "WHERE e.FirstName = ? AND e.LastName = ?";

                    // Create a prepared statement for the insert query
                    String insertSql = "INSERT INTO Transactions (AccountNumber, TransactionType, Amount, Date, Description, CurrentBalance) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";

                    // Get the selected checkboxes and execute the update and insert queries for each selected employee
                    Component[] components = employeeListPanel.getComponents();
                    int totalRowsUpdated = 0;
                    for (Component component : components) {
                        if (component instanceof JPanel) {
                            JPanel checkboxPanel = (JPanel) component;
                            Component[] checkboxComponents = checkboxPanel.getComponents();
                            for (Component checkboxComponent : checkboxComponents) {
                                if (checkboxComponent instanceof JCheckBox) {
                                    JCheckBox checkbox = (JCheckBox) checkboxComponent;
                                    if (checkbox.isSelected()) {
                                        String[] employeeName = checkbox.getText().split(" ");
                                        PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
                                        updatePstmt.setString(1, employeeName[0]);
                                        updatePstmt.setString(2, employeeName[1]);
                                        int rowsUpdated = updatePstmt.executeUpdate();
                                        totalRowsUpdated += rowsUpdated;
                                        System.out.println(rowsUpdated + " rows updated for " + checkbox.getText());

                                        // Insert a new row into the Transactions table
                                        PreparedStatement insertPstmt = conn.prepareStatement(insertSql);
                                        insertPstmt.setInt(1, getAccountNumberForEmployee(conn, checkbox.getText()));
                                        insertPstmt.setString(2, "Wages");
                                        insertPstmt.setDouble(3, rowsUpdated * 1000); // Assuming the salary is in thousands
                                        insertPstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                                        insertPstmt.setString(5, "Payment" );
                                        insertPstmt.setDouble(6, getCurrentBalanceForEmployee(conn, checkbox.getText()) + rowsUpdated * 1000);
                                        insertPstmt.executeUpdate();
                                    }
                                }
                            }
                        }
                    }

                    // Display a message dialog to show the number of rows updated
                    JOptionPane.showMessageDialog(null, "Transaction Successfull!!.");

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        pack();
    }
    private static int getAccountNumberForEmployee(Connection conn, String employeeName) throws SQLException {
        String[] names = employeeName.split(" ");
        String sql = "SELECT AccountNumber FROM Employees WHERE FirstName = ? AND LastName = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, names[0]);
        pstmt.setString(2, names[1]);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("AccountNumber");
        } else {
            throw new RuntimeException("No account number found for " + employeeName);
        }
    }

    private static double getCurrentBalanceForEmployee(Connection conn, String employeeName) throws SQLException {
        int accountNumber = getAccountNumberForEmployee(conn, employeeName);
        String sql = "SELECT Balance FROM Accounts WHERE AccountNumber = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, accountNumber);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("Balance");
        } else {
            throw new RuntimeException("No balance found for account number " + accountNumber);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayrollPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel employeeListPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton payWagesBtn;
    private javax.swing.JButton selectAllBtn;
    // End of variables declaration
}
