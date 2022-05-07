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
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame implements ActionListener {

    JPanel panelNorth, panelCenter;
    JLabel labelHeader, labelPassCurrent, labelPassNew, labelPassConfirm;
    JMenuBar menuBar;
    JMenu adminMenu;
    JMenuItem profileMenu, logoutMenu, homeMenu;
    JPasswordField passwordFieldCurrent, passwordFieldNew, passwordFieldConfirm;
    JButton btnChangePassword;

    ChangePassword() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Change Password");
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLayout(null);

        menuBar = new JMenuBar(); // **container for menu */
        menuBar.add(Box.createHorizontalGlue()); // **set menuBar position to right-align */

        // **create adminMenu */
        adminMenu = new JMenu("Mochammad Ivan Ra'is");
        Font setFont = new Font("sans-serif", Font.BOLD, 14);
        UIManager.put("Menu.font", setFont);

        // **create menuItem */
        homeMenu = new JMenuItem("Home");
        homeMenu.addActionListener(this);
        profileMenu = new JMenuItem("Profile");
        profileMenu.addActionListener(this);
        logoutMenu = new JMenuItem("Logout");
        logoutMenu.addActionListener(this);

        // **add component (menu item) to menu */
        adminMenu.add(homeMenu);
        adminMenu.add(profileMenu);
        adminMenu.add(logoutMenu);

        // **add component (menu) to menu bar */
        menuBar.add(adminMenu);

        // **create panelNorth */
        panelNorth = new JPanel();
        panelNorth.setBounds(0, 0, 1200, 100);
        panelNorth.setBackground(new Color(33, 72, 192));

        // **create labelHeader */
        labelHeader = new JLabel("Change Password");
        labelHeader.setBounds(0, 0, 1200, 100);
        labelHeader.setFont(new Font(null, Font.BOLD, 25));
        labelHeader.setForeground(Color.white);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);

        // **create panelCenter */
        panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBounds(400, 150, 400, 360);
        panelCenter.setBackground(Color.white);

        // **create labelPassCurrent */
        labelPassCurrent = new JLabel("Current Password");
        labelPassCurrent.setBounds(25, 25, 400, 45);
        labelPassCurrent.setFont(new Font(null, Font.PLAIN, 14));
        labelPassCurrent.setForeground(new Color(148, 164, 175));

        // **create passwordFieldCurrent */
        passwordFieldCurrent = new JPasswordField();
        passwordFieldCurrent.setBounds(25, 60, 350, 45);
        passwordFieldCurrent.setSize(350, 35);
        passwordFieldCurrent.setFont(new Font(null, Font.BOLD, 14));

        // **create labelPassNew */
        labelPassNew = new JLabel("New Password");
        labelPassNew.setFont(new Font(null, Font.PLAIN, 14));
        labelPassNew.setForeground(new Color(148, 164, 175));
        labelPassNew.setBounds(25, 100, 400, 45);

        // **create passwordFieldNew */
        passwordFieldNew = new JPasswordField();
        passwordFieldNew.setSize(350, 35);
        passwordFieldNew.setFont(new Font(null, Font.BOLD, 14));
        passwordFieldNew.setBounds(25, 135, 350, 35);

        // **create labelPassConfirm */
        labelPassConfirm = new JLabel("Confirm New Password");
        labelPassConfirm.setFont(new Font(null, Font.PLAIN, 14));
        labelPassConfirm.setForeground(new Color(148, 164, 175));
        labelPassConfirm.setBounds(25, 175, 400, 45);

        // **create passwordFieldConfirm */
        passwordFieldConfirm = new JPasswordField();
        passwordFieldConfirm.setSize(350, 35);
        passwordFieldConfirm.setFont(new Font(null, Font.BOLD, 14));
        passwordFieldConfirm.setBounds(25, 210, 350, 35);

        // **create btnChangePassword */
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setBounds(25, 260, 170, 35);
        btnChangePassword.setFocusable(false);
        btnChangePassword.setBackground(new Color(38, 78, 202));
        btnChangePassword.setForeground(Color.white);

        // **add components to panelCenter */
        panelCenter.add(btnChangePassword);
        panelCenter.add(passwordFieldConfirm);
        panelCenter.add(labelPassConfirm);
        panelCenter.add(passwordFieldNew);
        panelCenter.add(labelPassNew);
        panelCenter.add(passwordFieldCurrent);
        panelCenter.add(labelPassCurrent);

        // **add components to frame */
        this.add(panelCenter);
        this.setJMenuBar(menuBar);
        this.add(labelHeader);
        this.add(panelNorth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeMenu) {
            // **when click homeMenu item, it is going to open home page
            this.dispose();
            new Home();
        } else if (e.getSource() == profileMenu) {
            // **when click profileMenu item, it is going to open profile page */
            this.dispose();
            new Profile();
        } else {
            int answer;
            answer = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            // **if you click yes option, it is going to close the frame
            if (answer == 0) {
                this.dispose();
            }
        }

    }

}
