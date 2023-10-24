import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;
import java.util.Random;

public class NewAccount extends javax.swing.JFrame {

    public NewAccount() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        balance = new javax.swing.JTextField();
        female = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        address = new javax.swing.JTextField();
        accountType = new javax.swing.JComboBox<>();
        pinNumber = new javax.swing.JPasswordField();
        createAccButton = new javax.swing.JButton();
        final String[] gender = new String[1];

        jLabel1.setText("jLabel1");

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 150, 190));

        jLabel2.setFont(new java.awt.Font("Noto Serif CJK HK Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NEW ACCOUNT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("First Name:");

        jLabel4.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Phone Number:");

        jLabel5.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Last Name:");

        jLabel6.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Initial Deposite:");

        jLabel7.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Gender:");

        jLabel8.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Address:");

        jLabel9.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Account Type:");

        jLabel10.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Pin Number:");

        female.setText("female");
        male.setText("male");

        accountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saving Account", "Woman's Account", "Wedding Account", "Student Account" }));

        createAccButton.setBackground(new java.awt.Color(39, 150, 190));
        createAccButton.setFont(new java.awt.Font("Noto Sans CJK KR Medium", 1, 14)); // NOI18N
        createAccButton.setForeground(new java.awt.Color(255, 255, 255));
        createAccButton.setText("CREATE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(female)
                                                .addGap(18, 18, 18)
                                                .addComponent(male))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pinNumber))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(address))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(accountType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(197, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createAccButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(308, 308, 308))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(female)
                                        .addComponent(male))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(accountType, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(pinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addComponent(createAccButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 29, Short.MAX_VALUE))
                        ));

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(female);
        genderGroup.add(male);
//

        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender[0] = "Female";
            }
        });

        male.addActionListener(new ActionListener() {
            //            @Override
            public void actionPerformed(ActionEvent e) {
                gender[0] = "Male";
            }
        });
        createAccButton.addActionListener(e -> {
            if (e.getSource() == createAccButton){

                if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || phoneNumber.getText().isEmpty() || balance.getText().isEmpty() || gender[0].isEmpty() || address.getText().isEmpty() ||  new String(pinNumber.getPassword()).isEmpty()) {
                    // Handle the case where one or more variables are empty
                    System.out.println("One or more variables are empty");
                    JOptionPane.showMessageDialog(this, "Please Fill All Fields!! .", "Error", JOptionPane.WARNING_MESSAGE);
                } else if (phoneNumber.getText().length() != 10 || !phoneNumber.getText().matches("[0-9]+") || !new String(pinNumber.getPassword()).matches("[0-9]+"))
                {
                    System.out.println("Data insertion failed.");
                    JOptionPane.showMessageDialog(this, "Phone Number, Balance and PinNumber must be an Integer Values..", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    String firstname = firstName.getText();
                    String lastname = lastName.getText();
                    String phonenumber = phoneNumber.getText();
                    String balanceText = balance.getText();
                    int totalBalance = Integer.parseInt(balanceText);
                    String gendder = gender[0];
                    String addressOfPerson = address.getText();
                    String AccounType = (String) accountType.getSelectedItem();
                    char[] pinNum = pinNumber.getPassword();
                    String pinString = new String(pinNum);
                    Random random = new Random();
                    int accountNumber = (int) (random.nextDouble() * 10000000000L);
                    try {
                        // Establish a connection to the database
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cash_Flow_Bank", "root", "");

                        // Create a PreparedStatement for the insert statement
                        String insertSql = "INSERT INTO Accounts (FirstName, LastName, PhoneNumber, Balance, Gender, Address, AccountType, PinNumber, AccountNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pstmt = conn.prepareStatement(insertSql);

                        // Set the values of the parameters in the insert statement
                        pstmt.setString(1, firstname);
                        pstmt.setString(2, lastname);
                        pstmt.setString(3, phonenumber);
                        pstmt.setDouble(4, totalBalance);
                        pstmt.setString(5, gendder);
                        pstmt.setString(6, addressOfPerson);
                        pstmt.setString(7, AccounType);
                        pstmt.setString(8, pinString);
                        pstmt.setInt(9, accountNumber);

                        // Execute the insert statement
                        int rowsInserted = pstmt.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Account Created successfully! Your Account Number is " + accountNumber + ".");
                            JOptionPane.showMessageDialog(this, "Account created successfully! Your account number is " + accountNumber + ".", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            System.out.println("Data insertion failed.");
                            JOptionPane.showMessageDialog(this, "Data insertion failed.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        // Close the PreparedStatement and Connection
                        pstmt.close();
                        conn.close();
                        this.setVisible(false);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("Data insertion failed.");
                        JOptionPane.showMessageDialog(this, "Data insertion failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> accountType;
    private javax.swing.JTextField address;
    private javax.swing.JTextField balance;
    private javax.swing.JButton createAccButton;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField lastName;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JPasswordField pinNumber;
    // End of variables declaration
}
