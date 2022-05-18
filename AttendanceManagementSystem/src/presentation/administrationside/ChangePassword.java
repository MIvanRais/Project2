package presentation.administrationside;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import logic.LogicBuilding;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame implements ActionListener {

    JPanel panelWest, panelEast, panelSouth, panelLineWest;
    JLabel labelProfile, labelFooter, labelCurrentPassword, labelNewPassword, labelConfirmPassword, labelWarnCurrPass,
            labelWarnNewPass,
            labelWarnConfrimPass;
    JPasswordField passwordFieldCurrent, passwordFieldNew, passwordFieldConfirm;
    JButton btnChangePassword, btnBack;
    JRadioButton btnMale, btnFemale;
    ButtonGroup btnGroup;

    public static String newPass, confirmPass;

    ChangePassword() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Change Password");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLayout(null);

        // **create panelWest
        panelWest = new JPanel();
        panelWest.setBounds(0, 0, 270, 500);
        panelWest.setBackground(new Color(33, 72, 192));
        panelWest.setLayout(null);

        // **create labelProfile
        labelProfile = new JLabel("Change Password");
        labelProfile.setBounds(0, 200, 270, 50);
        labelProfile.setFont(new Font(null, Font.BOLD, 25));
        labelProfile.setForeground(Color.white);
        labelProfile.setHorizontalAlignment(JLabel.CENTER);

        // **create panelLineWest
        panelLineWest = new JPanel();
        panelLineWest.setBounds(100, 240, 80, 2);
        panelLineWest.setBackground(Color.white);

        // **add component to panelWest
        panelWest.add(labelProfile);
        panelWest.add(panelLineWest);

        // **create panelEast
        panelEast = new JPanel();
        panelEast.setBounds(270, 0, 330, 500);
        panelEast.setLayout(null);
        panelEast.setBackground(Color.white);

        // **create labelCurrentPassword
        labelCurrentPassword = new JLabel("Current Password");
        labelCurrentPassword.setBounds(20, 55, 140, 30);
        labelCurrentPassword.setFont(new Font(null, Font.PLAIN, 15));
        labelCurrentPassword.setForeground(new Color(148, 164, 175));

        // **create passwordFieldCurrent
        passwordFieldCurrent = new JPasswordField();
        passwordFieldCurrent.setBounds(20, 100, 290, 30);
        passwordFieldCurrent.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnCurrPass
        labelWarnCurrPass = new JLabel("Please Enter Your Current Password");
        labelWarnCurrPass.setBounds(20, 130, 290, 20);
        labelWarnCurrPass.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnCurrPass.setForeground(Color.red);

        // **create labelNewPassword
        labelNewPassword = new JLabel("New Password");
        labelNewPassword.setBounds(20, 155, 140, 30);
        labelNewPassword.setFont(new Font(null, Font.PLAIN, 15));
        labelNewPassword.setForeground(new Color(148, 164, 175));

        // **create passwordFieldNew
        passwordFieldNew = new JPasswordField();
        passwordFieldNew.setBounds(20, 200, 290, 30);
        passwordFieldNew.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnNewPass
        labelWarnNewPass = new JLabel("Please Enter Your New Password");
        labelWarnNewPass.setBounds(20, 230, 290, 20);
        labelWarnNewPass.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnNewPass.setForeground(Color.red);

        // **create labelConfirmPassword
        labelConfirmPassword = new JLabel("Confirm New Password");
        labelConfirmPassword.setBounds(20, 255, 180, 30);
        labelConfirmPassword.setFont(new Font(null, Font.PLAIN, 15));
        labelConfirmPassword.setForeground(new Color(148, 164, 175));

        // **create passwordFieldConfirm
        passwordFieldConfirm = new JPasswordField();
        passwordFieldConfirm.setBounds(20, 300, 290, 30);
        passwordFieldConfirm.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnConfrimPass
        labelWarnConfrimPass = new JLabel("Please Re-enter Your New Password");
        labelWarnConfrimPass.setBounds(20, 330, 290, 20);
        labelWarnConfrimPass.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnConfrimPass.setForeground(Color.red);

        // **create btnChangePassword
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setBounds(30, 370, 165, 35);
        btnChangePassword.setFocusable(false);
        btnChangePassword.setBackground(new Color(38, 78, 202));
        btnChangePassword.setForeground(Color.white);
        btnChangePassword.addActionListener(this);

        // **create btnBack
        btnBack = new JButton("Back");
        btnBack.setBounds(210, 370, 100, 35);
        btnBack.setFocusable(false);
        btnBack.setBackground(new Color(38, 78, 202));
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);

        // **add components to panelEast
        panelEast.add(btnChangePassword);
        panelEast.add(btnBack);
        panelEast.add(labelCurrentPassword);
        panelEast.add(passwordFieldCurrent);
        panelEast.add(labelNewPassword);
        panelEast.add(passwordFieldNew);
        panelEast.add(labelConfirmPassword);
        panelEast.add(passwordFieldConfirm);

        // **create panelSouth
        panelSouth = new JPanel();
        panelSouth.setBounds(0, 500, 600, 100);
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
            // **when click homeMenu item, it is going to open home page
            this.dispose();
            new Home();
        }

        if (e.getSource() == btnChangePassword) {
            // **when click btnChangePassword, what will happen? */
            if (passwordFieldNew.getPassword().length == 0 || passwordFieldCurrent.getPassword().length == 0
                    || passwordFieldConfirm.getPassword().length == 0) {
                // **if one of each password fields empty, the specific condition will be
                // happening */
                ChangePassword.this.setVisible(false);

                // //**change password form validation */
                if (passwordFieldCurrent.getPassword().length == 0) {
                    panelEast.add(labelWarnCurrPass);
                }
                if (passwordFieldCurrent.getPassword().length > 1) {
                    panelEast.remove(labelWarnCurrPass);
                }

                if (passwordFieldNew.getPassword().length == 0) {
                    panelEast.add(labelWarnNewPass);
                }
                if (passwordFieldNew.getPassword().length > 1) {
                    panelEast.remove(labelWarnNewPass);
                }

                if (passwordFieldConfirm.getPassword().length == 0) {
                    panelEast.add(labelWarnConfrimPass);
                }
                if (passwordFieldConfirm.getPassword().length > 1) {
                    panelEast.remove(labelWarnConfrimPass);
                }

                ChangePassword.this.setVisible(true);
            } else {
                // **if all of password fields are not empty, the LogicBuilding.chngePassword is
                // going to called */
                String currentPass = String.valueOf(passwordFieldCurrent.getPassword());
                newPass = String.valueOf(passwordFieldNew.getPassword());
                confirmPass = String.valueOf(passwordFieldConfirm.getPassword());

                if (LogicBuilding.chngePasswordAdmin("SELECT COUNT(*) FROM admins WHERE username ='" + Login.username
                        + "'AND (password ='" + Login.password + "' AND password = '" + currentPass + "');",
                        "UPDATE admins SET password ='" + newPass + "' WHERE username ='"
                                + Login.username + "' AND password ='" + Login.password + "';")) {
                    JOptionPane.showMessageDialog(null, "Change Password Successfully", "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Change Password Unsuccessfully", "Unsuccessful",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
