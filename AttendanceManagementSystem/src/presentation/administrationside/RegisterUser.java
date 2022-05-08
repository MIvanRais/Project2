package presentation.administrationside;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser extends JFrame implements ActionListener {

    JPanel panelNorth, panelCenter;
    JLabel labelHeader, labelUsername, labelPassword, labelPassConfirm;
    JTextField textFieldUsername;
    JPasswordField passwordField, passwordFieldConfirm;
    JButton btnCreateAccount, btnBack;

    RegisterUser() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create User");
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLayout(null);

        // **create panelNorth */
        panelNorth = new JPanel();
        panelNorth.setBounds(0, 0, 1200, 100);
        panelNorth.setBackground(new Color(33, 72, 192));

        // **create labelHeader */
        labelHeader = new JLabel("Create User");
        labelHeader.setBounds(0, 0, 1200, 100);
        labelHeader.setFont(new Font(null, Font.BOLD, 25));
        labelHeader.setForeground(Color.white);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);

        // **create panelCenter */
        panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBounds(400, 150, 400, 360);
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

        // **create labelPassword */
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font(null, Font.PLAIN, 14));
        labelPassword.setForeground(new Color(148, 164, 175));
        labelPassword.setBounds(25, 100, 400, 45);

        // **create passwordField */
        passwordField = new JPasswordField();
        passwordField.setSize(350, 35);
        passwordField.setFont(new Font(null, Font.BOLD, 14));
        passwordField.setBounds(25, 135, 350, 35);

        // **create labelPassConfirm */
        labelPassConfirm = new JLabel("Confirm Password");
        labelPassConfirm.setFont(new Font(null, Font.PLAIN, 14));
        labelPassConfirm.setForeground(new Color(148, 164, 175));
        labelPassConfirm.setBounds(25, 175, 400, 45);

        // **create passwordFieldConfirm */
        passwordFieldConfirm = new JPasswordField();
        passwordFieldConfirm.setSize(350, 35);
        passwordFieldConfirm.setFont(new Font(null, Font.BOLD, 14));
        passwordFieldConfirm.setBounds(25, 210, 350, 35);

        // **create btnCreateAccount */
        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setBounds(25, 265, 170, 35);
        btnCreateAccount.setFocusable(false);
        btnCreateAccount.setBackground(new Color(38, 78, 202));
        btnCreateAccount.setForeground(Color.white);

        // **create btnBack */
        btnBack = new JButton("Back");
        btnBack.setBounds(200, 265, 100, 35);
        btnBack.setFocusable(false);
        btnBack.setBackground(new Color(38, 78, 202));
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);

        // **add components to panelCenter */
        panelCenter.add(btnBack);
        panelCenter.add(btnCreateAccount);
        panelCenter.add(passwordFieldConfirm);
        panelCenter.add(labelPassConfirm);
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
    }

}
