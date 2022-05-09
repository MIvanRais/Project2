package presentation.administrationside;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import logic.LogicBuilding;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser extends JFrame implements ActionListener {

    JPanel panelNorth, panelCenter;
    JLabel labelHeader, labelUsername, labelPassword, labelPassConfirm, labelWarnUsername, labelWarnPassword,
            labelWarnConfirmPassword;
    JTextField textFieldUsername;
    JPasswordField passwordField, passwordFieldConfirm;
    JButton btnCreateAccount, btnBack;

    RegisterUser() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create Account User");
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLayout(null);

        // **create panelNorth */
        panelNorth = new JPanel();
        panelNorth.setBounds(0, 0, 1200, 100);
        panelNorth.setBackground(new Color(33, 72, 192));

        // **create labelHeader */
        labelHeader = new JLabel("Create Account User");
        labelHeader.setBounds(0, 0, 1200, 100);
        labelHeader.setFont(new Font(null, Font.BOLD, 25));
        labelHeader.setForeground(Color.white);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);

        // **create panelCenter */
        panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBounds(400, 150, 400, 400);
        panelCenter.setBackground(Color.white);

        // **create labelUsername */
        labelUsername = new JLabel("Username");
        labelUsername.setBounds(25, 25, 400, 45);
        labelUsername.setFont(new Font(null, Font.PLAIN, 14));
        labelUsername.setForeground(new Color(148, 164, 175));

        // **create textFieldUsername */
        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(25, 60, 350, 45);
        textFieldUsername.setSize(350, 35);
        textFieldUsername.setFont(new Font(null, Font.BOLD, 14));

        // **create labelWarnUsername */
        labelWarnUsername = new JLabel("Please Enter Your Username");
        labelWarnUsername.setBounds(25, 80, 300, 50);
        labelWarnUsername.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnUsername.setForeground(Color.red);

        // **create labelPassword */
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font(null, Font.PLAIN, 14));
        labelPassword.setForeground(new Color(148, 164, 175));
        labelPassword.setBounds(25, 120, 400, 45);

        // **create passwordField */
        passwordField = new JPasswordField();
        passwordField.setSize(350, 35);
        passwordField.setFont(new Font(null, Font.BOLD, 14));
        passwordField.setBounds(25, 155, 350, 35);

        // **create labelWarnPassword */
        labelWarnPassword = new JLabel("Please Enter Your Password");
        labelWarnPassword.setBounds(25, 175, 300, 50);
        labelWarnPassword.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnPassword.setForeground(Color.red);

        // **create btnCreateAccount */
        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setBounds(25, 220, 170, 35);
        btnCreateAccount.setFocusable(false);
        btnCreateAccount.setBackground(new Color(38, 78, 202));
        btnCreateAccount.setForeground(Color.white);
        btnCreateAccount.addActionListener(this);

        // **create btnBack */
        btnBack = new JButton("Back");
        btnBack.setBounds(200, 220, 100, 35);
        btnBack.setFocusable(false);
        btnBack.setBackground(new Color(38, 78, 202));
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);

        // **add components to panelCenter */
        panelCenter.add(btnBack);
        panelCenter.add(btnCreateAccount);
        panelCenter.add(passwordField);
        panelCenter.add(labelPassword);
        panelCenter.add(textFieldUsername);
        panelCenter.add(labelUsername);

        // **add components to frame */
        this.add(panelCenter);
        this.add(labelHeader);
        this.add(panelNorth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // **when click the btnBack, it is going to open home page */
        if (e.getSource() == btnBack) {
            this.dispose();
            new Home();
        }

        if (e.getSource() == btnCreateAccount) {

            RegisterUser.this.setVisible(false);

            // **registration form validation */
            if (textFieldUsername.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty()) {
                panelCenter.add(labelWarnUsername);
                panelCenter.add(labelWarnPassword);
            } else {
                panelCenter.remove(labelWarnUsername);
                panelCenter.remove(labelWarnPassword);
            }

            if (textFieldUsername.getText().trim().isEmpty()) {
                panelCenter.add(labelWarnUsername);
            } else {
                panelCenter.remove(labelWarnUsername);
            }

            if (passwordField.getText().trim().isEmpty()) {
                panelCenter.add(labelWarnPassword);
            } else {
                panelCenter.remove(labelWarnPassword);
            }

            RegisterUser.this.setVisible(true);

            if (textFieldUsername.getText().length() > 0 && passwordField.getText().length() > 0) {
                // **INSERT statement */
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword()) ;
                
                if(LogicBuilding.insertData("INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "');")){
                    JOptionPane.showMessageDialog(null, "Add User Succesfully", "Add User", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Home();
                }else{
                    JOptionPane.showMessageDialog(null, "Add User Unsuccessful", "Add User", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

}
