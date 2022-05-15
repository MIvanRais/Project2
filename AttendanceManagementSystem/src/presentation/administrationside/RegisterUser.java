package presentation.administrationside;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import logic.LogicBuilding;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser extends JFrame implements ActionListener {

    JPanel panelWest, panelEast, panelSouth, panelLineWest;
    JLabel labelProfile, labelUsername, labelPassword, labelProject, 
            labelFooter, labelWarnUsername,
            labelWarnPassword;
    JTextField textFieldUsername, textFieldLastName, textFieldNoTlp, textFieldEmail;
    JPasswordField passwordField;
    JButton btnCreateAccount, btnBack;
    JRadioButton btnMale, btnFemale;
    ButtonGroup btnGroup;

    RegisterUser() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create Account User");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLayout(null);

        // **create panelWest
        panelWest = new JPanel();
        panelWest.setBounds(0, 0, 250, 300);
        panelWest.setBackground(new Color(33, 72, 192));
        panelWest.setLayout(null);

        // **create labelProfile
        labelProfile = new JLabel("Account User");
        labelProfile.setBounds(0, 100, 250, 50);
        labelProfile.setFont(new Font(null, Font.BOLD, 25));
        labelProfile.setForeground(Color.white);
        labelProfile.setHorizontalAlignment(JLabel.CENTER);

        // **create panelLineWest
        panelLineWest = new JPanel();
        panelLineWest.setBounds(100, 140, 80, 2);
        panelLineWest.setBackground(Color.white);

        // **add component to panelWest
        panelWest.add(labelProfile);
        panelWest.add(panelLineWest);

        // **create panelEast
        panelEast = new JPanel();
        panelEast.setBounds(250, 0, 350, 300);
        panelEast.setLayout(null);
        panelEast.setBackground(Color.white);

        // **create labelUsername
        labelUsername = new JLabel("Username");
        labelUsername.setBounds(20, 25, 115, 30);
        labelUsername.setFont(new Font(null, Font.PLAIN, 15));
        labelUsername.setForeground(new Color(148, 164, 175));

        // **create textFieldUsername
        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(20, 70, 300, 30);
        textFieldUsername.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnUsername
        labelWarnUsername = new JLabel("Please Enter Your Username");
        labelWarnUsername.setBounds(20, 100, 290, 20);
        labelWarnUsername.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnUsername.setForeground(Color.red);

        // **create labelPassword
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(20, 125, 115, 30);
        labelPassword.setFont(new Font(null, Font.PLAIN, 15));
        labelPassword.setForeground(new Color(148, 164, 175));

        // **create passwordField
        passwordField = new JPasswordField();
        passwordField.setBounds(20, 165, 300, 30);
        passwordField.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnPassword
        labelWarnPassword = new JLabel("Please Enter Your Password");
        labelWarnPassword.setBounds(20, 195, 290, 20);
        labelWarnPassword.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnPassword.setForeground(Color.red);

        // **create btnCreateAccount
        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setBounds(50, 230, 150, 35);
        btnCreateAccount.setFocusable(false);
        btnCreateAccount.setBackground(new Color(38, 78, 202));
        btnCreateAccount.setForeground(Color.white);
        btnCreateAccount.addActionListener(this);

        // **create btnBack
        btnBack = new JButton("Back");
        btnBack.setBounds(217, 230, 100, 35);
        btnBack.setFocusable(false);
        btnBack.setBackground(new Color(38, 78, 202));
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);

        // **add components to panelEast
        panelEast.add(labelUsername);
        panelEast.add(textFieldUsername);
        // panelEast.add(labelWarnUsername);
        panelEast.add(labelPassword);
        panelEast.add(passwordField);
        // panelEast.add(labelWarnPassword);
        panelEast.add(btnCreateAccount);
        panelEast.add(btnBack);

        // **create panelSouth
        panelSouth = new JPanel();
        panelSouth.setBounds(0, 300, 600, 100);
        panelSouth.setBackground(new Color(33, 72, 192));
        panelSouth.setLayout(null);

        // **create labelFooter */
        labelFooter = new JLabel("Admin Attendance Management System");
        labelFooter.setBounds(0, 0, 600, 50);
        labelFooter.setFont(new Font(null, Font.BOLD, 20));
        labelFooter.setForeground(Color.white);
        labelFooter.setHorizontalAlignment(JLabel.CENTER);

        // **add component to panelSouth
        panelSouth.add(labelFooter);

        // **add components to frame
        this.add(panelWest);
        this.add(panelEast);
        this.add(panelSouth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            this.dispose();
            new Home();
        }

        if (e.getSource() == btnCreateAccount) {
            RegisterUser.this.setVisible(false);

            // **registration form validation */
            if (textFieldUsername.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty()) {
                panelEast.add(labelWarnUsername);
                panelEast.add(labelWarnPassword);
            } else {
                panelEast.remove(labelWarnUsername);
                panelEast.remove(labelWarnPassword);
            }

            if (textFieldUsername.getText().trim().isEmpty()) {
                panelEast.add(labelWarnUsername);
            } else {
                panelEast.remove(labelWarnUsername);
            }

            if (passwordField.getText().trim().isEmpty()) {
                panelEast.add(labelWarnPassword);
            } else {
                panelEast.remove(labelWarnPassword);
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
