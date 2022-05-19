package presentation.userside;

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

public class Login extends JFrame implements ActionListener{

    JLabel labelLogin, labelUsername, labelPassword, labelWarnUsername, labelWarnPass;
    JButton btnClear, btnLogin;
    JPanel panelLine;
    static JTextField textFieldUsername;
    static JPasswordField passwordField;

    public static String username, password;

    Login(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        // **create labelLogin */
        labelLogin = new JLabel("Login");
        labelLogin.setBounds(25, 50, 100, 50);
        labelLogin.setFont(new Font(null, Font.BOLD, 20));
        labelLogin.setForeground(Color.black);
        labelLogin.setHorizontalTextPosition(JLabel.CENTER);
        labelLogin.setVerticalTextPosition(JLabel.CENTER);

        // **create panelLine
        panelLine = new JPanel();
        panelLine.setBounds(40, 90, 50, 2);
        panelLine.setBackground(new Color(255,165,0));

        // **create labelUsername */
        labelUsername = new JLabel("Username");
        labelUsername.setBounds(25, 100, 100, 50);
        labelUsername.setFont(new Font(null, Font.PLAIN, 15));
        labelUsername.setForeground(new Color(148, 164, 175));

        // **create textFieldUsername */
        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(25, 140, 350, 45);
        textFieldUsername.setSize(350, 35);
        textFieldUsername.setFont(new Font(null, Font.BOLD, 14));

        // **create labelWarnUsername */
        labelWarnUsername = new JLabel("Please Enter Your Username");
        labelWarnUsername.setBounds(25, 160, 300, 50);
        labelWarnUsername.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnUsername.setForeground(Color.red);

        // **create labelPassword */
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(25, 190, 100, 50);
        labelPassword.setFont(new Font(null, Font.PLAIN, 15));
        labelPassword.setForeground(new Color(148, 164, 175));

        // **create passwordField */
        passwordField = new JPasswordField();
        passwordField.setBounds(25, 230, 350, 45);
        passwordField.setSize(350, 35);
        passwordField.setFont(new Font(null, Font.BOLD, 14));

        // **create labelWarnUsername
        labelWarnPass = new JLabel("Please Enter Your Password");
        labelWarnPass.setBounds(25, 250, 300, 50);
        labelWarnPass.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnPass.setForeground(Color.red);

        // **create btnClear */
        btnClear = new JButton("Clear");
        btnClear.setBounds(25, 300, 160, 35);
        btnClear.setBackground(new Color(255,193,77));
        btnClear.setBorderPainted(false);
        btnClear.setForeground(Color.white);
        btnClear.setFocusable(false);
        btnClear.addActionListener(this);

        // **create btnLogin */
        btnLogin = new JButton("Login");
        btnLogin.setBounds(213, 300, 160, 35);
        btnLogin.setBackground(new Color(255,165,0));
        btnLogin.setBorderPainted(false);
        btnLogin.setForeground(Color.white);
        btnLogin.setFocusable(false);
        btnLogin.addActionListener(this);

        // **add components to frame */
        this.add(btnLogin);
        this.add(btnClear);
        this.add(passwordField);
        this.add(labelPassword);
        this.add(textFieldUsername);
        this.add(labelUsername);
        this.add(labelLogin);
        this.add(panelLine);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnClear){
            // **when click btnClear, it is going to clear those */
            textFieldUsername.setText("");
            passwordField.setText("");
        }
        
        if(e.getSource()==btnLogin){
            // if(textFieldUsername.getText().trim().isEmpty() || passwordField.getPassword().length == 0){
                Login.this.setVisible(false);

                // **login form validation
                if(textFieldUsername.getText().trim().isEmpty()){
                    this.add(labelWarnUsername);
                }else{
                    this.remove(labelWarnUsername);
                }

                if (passwordField.getPassword().length == 0) {
                    this.add(labelWarnPass);
                }

                if (passwordField.getPassword().length > 0) {
                    this.remove(labelWarnPass);
                }

                Login.this.setVisible(true);
            // }
            username = textFieldUsername.getText();
            password = String.valueOf(passwordField.getPassword()); 
            
            if (LogicBuilding.checkLogin("SELECT COUNT(*) FROM users WHERE username ='" + username
                        + "' AND password ='" + password + "';")) {
                    JOptionPane.showMessageDialog(null, "Login Successfully", "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Unsuccessfully", "Unsuccessful",
                            JOptionPane.ERROR_MESSAGE);
                }

        }
    }
    
}
