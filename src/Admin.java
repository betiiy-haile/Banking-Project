
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;

public class Admin extends javax.swing.JFrame {

    public Admin() {
        initComponents();
    }

    private void initComponents() {

        leftSide = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        ImageLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        transButton = new javax.swing.JButton();
        empButton = new javax.swing.JButton();
        accButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        empTable = new javax.swing.JMenuItem();
        empPayroll = new javax.swing.JMenuItem();
        newEmployee = new javax.swing.JMenuItem();
        accountMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        transactionMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        String url = "jdbc:mysql://localhost:3306/Cash_Flow_Bank";
        String username = "root";
        String password = "";

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        leftSide.setBackground(new java.awt.Color(37, 150, 190));

        jLabel1.setFont(new java.awt.Font("Noto Serif CJK TC Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CASH FLOW BANK");

        ImageIcon icon = new ImageIcon("images/museum.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel ImageLabel = new JLabel(scaledIcon);


        javax.swing.GroupLayout leftSideLayout = new javax.swing.GroupLayout(leftSide);
        leftSide.setLayout(leftSideLayout);
        leftSideLayout.setHorizontalGroup(
                leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftSideLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addGroup(leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                                .addComponent(jSeparator1)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        leftSideLayout.setVerticalGroup(
                leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftSideLayout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
        );

        transButton.setBackground(new java.awt.Color(37, 150, 190));
        transButton.setFont(new java.awt.Font("Noto Serif CJK SC Medium", 1, 14)); // NOI18N
        transButton.setForeground(new java.awt.Color(255, 255, 255));
        transButton.setText("Transaction");

        empButton.setBackground(new java.awt.Color(37, 150, 190));
        empButton.setFont(new java.awt.Font("Noto Serif CJK TC Medium", 1, 14)); // NOI18N
        empButton.setForeground(new java.awt.Color(255, 255, 255));
        empButton.setText("Employee");

        accButton.setBackground(new java.awt.Color(37, 150, 190));
        accButton.setFont(new java.awt.Font("Noto Serif CJK TC Medium", 1, 14)); // NOI18N
        accButton.setForeground(new java.awt.Color(255, 255, 255));
        accButton.setText("Accounts");

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                .addContainerGap(86, Short.MAX_VALUE)
                                .addComponent(empButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(accButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(transButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );
        buttonsPanelLayout.setVerticalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                                .addContainerGap(34, Short.MAX_VALUE)
                                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(empButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(accButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(transButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
        );

        contentPanel = new JPanel(new CardLayout());

        // Create the employee table panel
        JPanel employeeTablePanel = new JPanel(new BorderLayout());
        String query = "SELECT * FROM Employees";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // create a new DefaultTableModel and add columns to it
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("EmpID");
            model.addColumn("FirstName");
            model.addColumn("LastName");
            model.addColumn("JobTitle");
            model.addColumn("HireDate");
            model.addColumn("Salary");
            model.addColumn("AccountNumber");

            // iterate over the ResultSet and add rows to the model
            while(resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("EmpID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("JobTitle"),
                        resultSet.getString("HireDate"),
                        resultSet.getInt("Salary"),
                        resultSet.getString("AccountNumber")
                };
                model.addRow(row);
            }

            employeeTable = new JTable(model);
            JScrollPane employeeScrollPane = new JScrollPane(employeeTable);
            employeeTablePanel.add(employeeScrollPane, BorderLayout.CENTER);

            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        // Create the accounts table panel
        JPanel accountsTablePanel = new JPanel(new BorderLayout());

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

            // Prepare an SQL statement to select all rows from the Accounts table
            String sql = "SELECT * FROM Accounts";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Execute the SQL statement and get the result set
            ResultSet rs = stmt.executeQuery();

            // Get the metadata of the result set to determine the column count and column names
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i-1] = rsmd.getColumnName(i);
            }

            // Create a new new table model with the column names
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            // Add each row from the result set to the table model
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i-1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            // Create a new JTable with the table model
            accountsTable = new JTable(model);
            JScrollPane accountsScrollPane = new JScrollPane(accountsTable);
            accountsTablePanel.add(accountsScrollPane, BorderLayout.CENTER);

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Create the transactions table panel
        JPanel transactionsTablePanel = new JPanel(new BorderLayout());

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

            // Prepare an SQL statement to select all rows from the transaction table
            String sql = "SELECT * FROM Transactions";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Execute the SQL statement and get the result set
            ResultSet rs = stmt.executeQuery();

            // Get the metadata of the result set to determine the column count and column names
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i-1] = rsmd.getColumnName(i);
            }

            // Create a new table model with the column names
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            // Add each row from the result set to the table model
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i-1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }
            transactionsTable = new JTable(model);
            JScrollPane transactionsScrollPane = new JScrollPane(transactionsTable);
            transactionsTablePanel.add(transactionsScrollPane, BorderLayout.CENTER);

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Create the admin panel
        JPanel adminPanel = new JPanel(new BorderLayout());
        JLabel ourSlogan = new JLabel("\"Make your financial dreams reality with us\"");
        adminPanel.add(ourSlogan);

        // Add the employee, accounts, and transactions panels to the content panel
        contentPanel.add(adminPanel, "Admin");
        contentPanel.add(employeeTablePanel, "Employees");
        contentPanel.add(accountsTablePanel, "Accounts");
        contentPanel.add(transactionsTablePanel, "Transactions");

        // Add action listeners to the buttons
        empButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "Employees");
            }
        });

        accButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "Accounts");
            }
        });

        transButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "Transactions");
            }
        });

        jMenu1.setText("Employees");

        empTable.setText("Employees Table");
        jMenu1.add(empTable);

        empPayroll.setText("Payroll");
        jMenu1.add(empPayroll);

        newEmployee.setText("New Employee");
        jMenu1.add(newEmployee);

        jMenuBar1.add(jMenu1);

        accountMenu.setText("Customers");

        jMenuItem1.setText("Accounts");
        accountMenu.add(jMenuItem1);

        transactionMenu.setText("Transactions");
        accountMenu.add(transactionMenu);

        jMenuBar1.add(accountMenu);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(leftSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(leftSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        empTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "Employees");
            }
        });

        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "Accounts");
            }
        });

        transactionMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "Transactions");
            }
        });

        empPayroll.addActionListener(e -> {
            if(e.getSource() == empPayroll){
                PayrollPage payrollPage = new PayrollPage();
                payrollPage.setVisible(true);
            }
        });

        newEmployee.addActionListener(e -> {
            if(e.getSource() == newEmployee){
                NewEmployee newEmp = new NewEmployee();
                newEmp.setVisible(true);
            }
        });

        pack();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JMenu accountMenu;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton accButton;
    private javax.swing.JButton empButton;
    private javax.swing.JMenuItem empPayroll;
    private javax.swing.JMenuItem empTable;
    private javax.swing.JMenuItem newEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel leftSide;
    private javax.swing.JButton transButton;
    private javax.swing.JMenuItem transactionMenu;
    private JTable employeeTable;
    private JTable accountsTable;
    private JTable transactionsTable;
    // End of variables declaration
}
