package presentation.administrationside;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
    // 33, 72, 192 - primer
    // 38, 78, 202 - secondary

    JLabel labelLogin, labelUsername, labelPassword;
    JTextField textFieldUsername;
    JPasswordField passwordField;
    JButton btnClear, btnLogin;

    Login() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        // **create labelLogin */
        labelLogin = new JLabel("LOGIN");
        labelLogin.setBounds(25, 50, 100, 50);
        labelLogin.setFont(new Font(null, Font.BOLD, 20));
        labelLogin.setForeground(new Color(33, 72, 192));
        labelLogin.setHorizontalTextPosition(JLabel.CENTER);
        labelLogin.setVerticalTextPosition(JLabel.CENTER);

        // **create labelUsername */
        labelUsername = new JLabel("Username");
        labelUsername.setBounds(25, 100, 100, 50);
        labelUsername.setFont(new Font(null, Font.PLAIN, 15));

        // **create textFieldUsername */
        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(25, 140, 350, 45);
        textFieldUsername.setSize(350, 35);
        textFieldUsername.setFont(new Font(null, Font.BOLD, 14));

        // **create labelPassword */
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(25, 170, 100, 50);
        labelPassword.setFont(new Font(null, Font.PLAIN, 15));

        // **create passwordField */
        passwordField = new JPasswordField();
        passwordField.setBounds(25, 210, 350, 45);
        passwordField.setSize(350, 35);
        passwordField.setFont(new Font(null, Font.BOLD, 14));

        // **create btnClear */
        btnClear = new JButton("Clear");
        btnClear.setBounds(25, 260, 160, 35);
        btnClear.setBackground(new Color(38, 78, 202));
        btnClear.setForeground(Color.white);
        btnClear.setFocusable(false);

        // **create btnLogin */
        btnLogin = new JButton("Login");
        btnLogin.setBounds(213, 260, 160, 35);
        btnLogin.setBackground(new Color(38, 78, 202));
        btnLogin.setForeground(Color.white);
        btnLogin.setFocusable(false);

        this.add(btnLogin);
        this.add(btnClear);
        this.add(passwordField);
        this.add(labelPassword);
        this.add(textFieldUsername);
        this.add(labelUsername);
        this.add(labelLogin);
        this.setVisible(true);
    }
}