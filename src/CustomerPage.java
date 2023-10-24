import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.Swing.*;

public class CustomerPage extends javax.swing.JFrame {
    private static String accountNumber;
    private static String pinNumber;
    private static String fullName;
    private CardLayout cardLayout;
    private JPanel customerPanel;
    javax.swing.JPanel myTransactionPanel;

    /**
     * Creates new form CustomerPage
     */
    public CustomerPage(String accountNumber, String pinNumber, String fullName) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.fullName = fullName;
        initComponents();
        initCards();
    }


    private void initCards() {
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        customerPanel = new JPanel();
        customerPanel.add(new JLabel("Welcome to your page!!"));


        myTransactionPanel = new javax.swing.JPanel();
        javax.swing.JPanel TitlePanel = new javax.swing.JPanel();
        javax.swing.JLabel titleLabel = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTable jTable1 = new javax.swing.JTable();

        TitlePanel.setBackground(new java.awt.Color(39, 150, 190));

        titleLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("MY ACCOUNT TRANSACTIONS");

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
                TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TitlePanelLayout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TitlePanelLayout.setVerticalGroup(
                TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TitlePanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("AccountNumber");
        model.addColumn("TransactionType");
        model.addColumn("Amount");
        model.addColumn("Date");
        model.addColumn("Description");
        model.addColumn("CurrentBalance");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Transactions WHERE AccountNumber = '" + accountNumber + "'");

            while (rs.next()) {
                String transAccountNumber = rs.getString("AccountNumber");
                String transType = rs.getString("TransactionType");
                double transAmount = rs.getDouble("Amount");
                String transDate = rs.getString("Date");
                String transDesc = rs.getString("Description");
                double transBalance = rs.getDouble("CurrentBalance");
                model.addRow(new Object[]{transAccountNumber, transType, transAmount, transDate, transDesc, transBalance});
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            // Handle exceptions
        }


        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout myTransactionPanelLayout = new javax.swing.GroupLayout(myTransactionPanel);
        myTransactionPanel.setLayout(myTransactionPanelLayout);
        myTransactionPanelLayout.setHorizontalGroup(
                myTransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(myTransactionPanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        myTransactionPanelLayout.setVerticalGroup(
                myTransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(myTransactionPanelLayout.createSequentialGroup()
                                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }

    private void initComponents() {

        buttonsPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        myAccountBtn = new javax.swing.JButton();
        transferBtn = new javax.swing.JButton();
        welcomePanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonsPanel.setBackground(new java.awt.Color(39, 150, 190));

        jButton1.setBackground(new java.awt.Color(39, 150, 190));
        jButton1.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AirTime");

        myAccountBtn.setBackground(new java.awt.Color(39, 150, 190));
        myAccountBtn.setFont(new java.awt.Font("Noto Sans CJK SC Medium", 1, 18)); // NOI18N
        myAccountBtn.setForeground(new java.awt.Color(255, 255, 255));
        myAccountBtn.setText("My Account");

        transferBtn.setBackground(new java.awt.Color(39, 150, 190));
        transferBtn.setFont(new java.awt.Font("Noto Sans CJK SC Medium", 1, 18)); // NOI18N
        transferBtn.setForeground(new java.awt.Color(255, 255, 255));
        transferBtn.setText("Transfer");

        JPanel transferPanel = new javax.swing.JPanel();
        JPanel titlePanel = new javax.swing.JPanel();
        titlelabel = new javax.swing.JLabel("Transfer To");
        JLabel accountNumberLabel = new javax.swing.JLabel("Account Number: ");
        JTextField accountNumber1 = new javax.swing.JTextField();
        JLabel jLabel2 = new javax.swing.JLabel("Transfer Amount: ");
        JTextField amount = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel("Transfer Reason");
        JTextField reason = new javax.swing.JTextField();
        JButton confirmBtn = new javax.swing.JButton("CONFIRM");

        GroupLayout transferPanelLayout = new javax.swing.GroupLayout(transferPanel);
        transferPanel.setLayout(transferPanelLayout);

        transferPanelLayout.setHorizontalGroup(
                transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(transferPanelLayout.createSequentialGroup()
                                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(transferPanelLayout.createSequentialGroup()
                                                .addGap(109, 109, 109)
                                                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(accountNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(accountNumber1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                                        .addComponent(amount)
                                                        .addComponent(reason)))
                                        .addGroup(transferPanelLayout.createSequentialGroup()
                                                .addGap(264, 264, 264)
                                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        transferPanelLayout.setVerticalGroup(
                transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(transferPanelLayout.createSequentialGroup()
                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accountNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(accountNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                        .addComponent(amount))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                        .addComponent(reason))
                                .addGap(18, 18, 18)
                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 37, Short.MAX_VALUE))
        );

        javax.swing.JPanel buyAirTime;
        javax.swing.JButton buyAirTimeBtn;
        javax.swing.JLabel airTimeLabel;
        javax.swing.JLabel phonenNumLabel;
        javax.swing.JLabel amountLabel;
        javax.swing.JPanel jPanel1;
        javax.swing.JTextField airTimeAmount;
        javax.swing.JTextField phoneNumber;

        buyAirTime = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        airTimeLabel = new javax.swing.JLabel();
        phonenNumLabel = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        airTimeAmount = new javax.swing.JTextField();
        buyAirTimeBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(39, 150, 190));

        airTimeLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
        airTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        airTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        airTimeLabel.setText("BUY AIRTIME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(airTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()
                        )
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(airTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE)
                        )
        );

        phonenNumLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
        phonenNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        phonenNumLabel.setText("Phone Number:");

        amountLabel.setFont(new java.awt.Font("Fira Sans Medium", 1, 18)); // NOI18N
        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amountLabel.setText("Amount: ");

        buyAirTimeBtn.setBackground(new java.awt.Color(37, 150, 190));
        buyAirTimeBtn.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        buyAirTimeBtn.setForeground(new java.awt.Color(255, 255, 255));
        buyAirTimeBtn.setText("BUY AIRTIME");

        javax.swing.GroupLayout buyAirTimeLayout = new javax.swing.GroupLayout(buyAirTime);
        buyAirTime.setLayout(buyAirTimeLayout);

        buyAirTimeLayout.setHorizontalGroup(
                buyAirTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, buyAirTimeLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buyAirTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(buyAirTimeLayout.createSequentialGroup()
                                .addGroup(buyAirTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(buyAirTimeLayout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addGroup(buyAirTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(phonenNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(buyAirTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(phoneNumber)
                                                        .addComponent(airTimeAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
                                        .addGroup(buyAirTimeLayout.createSequentialGroup()
                                                .addGap(0, 140, Short.MAX_VALUE)))
                                .addContainerGap(115, Short.MAX_VALUE))
        );
        buyAirTimeLayout.setVerticalGroup(
                buyAirTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buyAirTimeLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(buyAirTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(phonenNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(phoneNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(buyAirTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(airTimeAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addComponent(buyAirTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 57, Short.MAX_VALUE))
        );


        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(myAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92))
        );
        buttonsPanelLayout.setVerticalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(myAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        welcomeLabel.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(39, 150, 190));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome " + fullName);

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(323, 323, 323))
        );
        welcomePanelLayout.setVerticalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(welcomeLabel)
                                .addContainerGap())
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 538, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(welcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);

        myAccountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                contentPanel.removeAll();
                contentPanel.add(myTransactionPanel);
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        transferBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPanel.removeAll();
                contentPanel.add(transferPanel);
                contentPanel.revalidate();
                contentPanel.repaint();

                confirmBtn.addActionListener(evt -> {
                    if (evt.getSource() == confirmBtn){
                        try {
                            if (!amount.getText().matches("[0-9]+") || accountNumber1.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null, "Please enter valid values!!.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            else{

                            String account = accountNumber1.getText();
                            Double moneyAmount = Double.parseDouble(amount.getText());

                            // Connect to the database
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

                            // Prepare a SQL statement to retrieve the row with the given account number
                            String sql = "SELECT * FROM Accounts WHERE AccountNumber = ?";
                            PreparedStatement stmt = conn.prepareStatement(sql);
                            stmt.setString(1, account);

                            // Execute the SQL statement and get the result set
                            ResultSet rs = stmt.executeQuery();   // recieciver

                            String select = "SELECT * FROM Accounts WHERE AccountNumber = ?";
                            PreparedStatement st = conn.prepareStatement(select);
                            st.setString(1, accountNumber);

                            ResultSet result = st.executeQuery();     // Sender
                            if (result.next()){
                                int totalBalance = result.getInt("Balance");
                                if(totalBalance - moneyAmount< 100){
                                    JOptionPane.showMessageDialog(null, "Insufficient Amount!!", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    totalBalance -= moneyAmount;
                                    PreparedStatement updateStmt = conn.prepareStatement("UPDATE Accounts SET Balance = ? WHERE AccountNumber = ?");
                                    updateStmt.setDouble(1, totalBalance);
                                    updateStmt.setString(2, accountNumber);

                                    int rowsUpdated = updateStmt.executeUpdate();

                                    if (rowsUpdated > 0) {
                                        System.out.println("Record updated successfully.");
                                        JOptionPane.showMessageDialog(null, "Transaction Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        System.out.println("No records were updated.");
                                        JOptionPane.showMessageDialog(null, "Transaction Failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }}
                                    String transaction = "INSERT INTO Transactions (AccountNumber, TransactionType, Amount, Date, Description, CurrentBalance) VALUES (?, ?, ?, ?, ?, ?)";
                                    PreparedStatement transSt = conn.prepareStatement(transaction);

                                    // Set the values of the parameters in the SQL statement
                                    transSt.setString(1, accountNumber);
                                    transSt.setString(2, "Money Transfer");
                                    transSt.setDouble(3, moneyAmount);
                                    transSt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                                    transSt.setString(5, reason.getText());
                                    transSt.setDouble(6, totalBalance);
                                    transSt.executeUpdate();
                                    transSt.close();
                            }
                            // Print out the values of the columns in the retrieved row
                            if (rs.next()) {
                                int totalBalance = rs.getInt("Balance");
                                totalBalance += moneyAmount;

                                PreparedStatement updateStmt = conn.prepareStatement("UPDATE Accounts SET Balance = ? WHERE AccountNumber = ?");
                                updateStmt.setDouble(1, totalBalance);
                                updateStmt.setString(2, account);

                                int rowsUpdated = updateStmt.executeUpdate();

                                if (rowsUpdated > 0) {
                                    System.out.println("Record updated successfully.");
                                    JOptionPane.showMessageDialog(null, "Transaction Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    System.out.println("No records were updated.");
                                    JOptionPane.showMessageDialog(null, "Transaction Failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                String transaction = "INSERT INTO Transactions (AccountNumber, TransactionType, Amount, Date, Description, CurrentBalance) VALUES (?, ?, ?, ?, ?, ?)";
                                PreparedStatement transSt = conn.prepareStatement(transaction);

                                // Set the values of the parameters in the SQL statement
                                transSt.setString(1, account);
                                transSt.setString(2, "Deposit");
                                transSt.setDouble(3, moneyAmount);
                                transSt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                                transSt.setString(5, "Money Transfer");
                                transSt.setDouble(6, rs.getInt("Balance") + moneyAmount);
                                transSt.executeUpdate();
                                transSt.close();
                            }
                            // Close the resources
                            result.close();
                            rs.close();
                            stmt.close();

                            conn.close();
                            }
                        } catch (SQLException event) {
                            event.printStackTrace();
                        } catch (NumberFormatException event) {
                            JOptionPane.showMessageDialog(null, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                contentPanel.removeAll();
                contentPanel.add(buyAirTime);
                contentPanel.revalidate();
                contentPanel.repaint();

                buyAirTimeBtn.addActionListener(e -> {
                    String phonenumber = phoneNumber.getText();
                    int airtimeAmount = Integer.parseInt(airTimeAmount.getText());
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");
                        String select = "SELECT * FROM Accounts WHERE AccountNumber = ?";
                        PreparedStatement st = conn.prepareStatement(select);
                        st.setString(1, accountNumber);

                        ResultSet result = st.executeQuery();
                        if (result.next()){
                            int totalBalance = result.getInt("Balance");
                            if(totalBalance - airtimeAmount< 100){
                                JOptionPane.showMessageDialog(null, "Insufficient Amount!!", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                String expectedPin = result.getString("PinNumber");
                                String pin = JOptionPane.showInputDialog(null, "Enter your PIN number:", "PIN NUMBER", JOptionPane.PLAIN_MESSAGE);
                                System.out.println("PIN entered: " + pin);
                                System.out.println("Expected PIN: " + expectedPin);

                                if (pin != null && pin.equals(expectedPin)) {
                                    totalBalance -= airtimeAmount;
                                    PreparedStatement updateStmt = conn.prepareStatement("UPDATE Accounts SET Balance = ? WHERE AccountNumber = ?");
                                    updateStmt.setDouble(1, totalBalance);
                                    updateStmt.setString(2, accountNumber);

                                    int rowsUpdated = updateStmt.executeUpdate();

                                    if (rowsUpdated > 0) {
                                        System.out.println("Record updated successfully.");
                                        JOptionPane.showMessageDialog(null, "Transaction Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                                        String transaction = "INSERT INTO Transactions (AccountNumber, TransactionType, Amount, Date, Description, CurrentBalance) VALUES (?, ?, ?, ?, ?, ?)";
                                        PreparedStatement transSt = conn.prepareStatement(transaction);

                                        // Set the values of the parameters in the SQL statement
                                        transSt.setString(1, accountNumber);
                                        transSt.setString(2, "WithDraw");
                                        transSt.setDouble(3, airtimeAmount);
                                        transSt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                                        transSt.setString(5, "Air Time");
                                        transSt.setDouble(6, totalBalance);
                                        transSt.executeUpdate();
                                        transSt.close();

                                    }else {
                                        System.out.println("No records were updated.");
                                        JOptionPane.showMessageDialog(null, "Transaction Failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    System.out.println("Wrong PIN entered.");
                                    JOptionPane.showMessageDialog(null, "Wrong PIN Number! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            }}} catch (SQLException ex) {
                        throw new RuntimeException(ex);
                }});
            }
        });

    }


    public static void main(String[] args) {
        new CustomerPage("4539045637", "129078", "Betelhem Getachew").setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton myAccountBtn;
    private javax.swing.JButton transferBtn;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel titlelabel;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration
}