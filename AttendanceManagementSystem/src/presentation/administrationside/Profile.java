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
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame implements ActionListener {

    JPanel panelNorth, panelCenter;
    JLabel labelHeader, labelHeaderPanelCenter, labelFirstName, labelLastName, labelFullName, labelEmail;
    JTextField textFieldFirstName, textFieldLastName, textFieldFullName, textFieldEmail;
    JMenuBar menuBar;
    JMenu adminMenu;
    JMenuItem changePasswordMenu, logoutMenu, homeMenu;
    JButton btnSave;

    Profile() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Profile");
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
        changePasswordMenu = new JMenuItem("Change Password");
        changePasswordMenu.addActionListener(this);
        logoutMenu = new JMenuItem("Logout");
        logoutMenu.addActionListener(this);

        // **add component (menu item) to menu */
        adminMenu.add(homeMenu);
        adminMenu.add(changePasswordMenu);
        adminMenu.add(logoutMenu);

        // **add component (menu) to menu bar */
        menuBar.add(adminMenu);

        // **create panelNorth */
        panelNorth = new JPanel();
        panelNorth.setBounds(0, 0, 1200, 100);
        panelNorth.setBackground(new Color(33, 72, 192));

        // **create labelHeader */
        labelHeader = new JLabel("Detail Profile");
        labelHeader.setBounds(0, 0, 1200, 100);
        labelHeader.setFont(new Font(null, Font.BOLD, 25));
        labelHeader.setForeground(Color.white);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);

        // **create panelCenter */
        panelCenter = new JPanel();
        panelCenter.setBounds(350, 150, 450, 500);
        panelCenter.setBackground(Color.white);
        panelCenter.setLayout(null);

        // **create labelHeaderPanelCenter */
        labelHeaderPanelCenter = new JLabel("Edit Profile");
        labelHeaderPanelCenter.setForeground(new Color(33, 72, 192));
        labelHeaderPanelCenter.setFont(new Font(null, Font.PLAIN, 18));
        labelHeaderPanelCenter.setBounds(25, 30, 100, 35);

        // **create labelFirstName */
        labelFirstName = new JLabel("First Name");
        labelFirstName.setFont(new Font(null, Font.PLAIN, 15));
        labelFirstName.setForeground(new Color(148, 164, 175));
        labelFirstName.setBounds(25, 90, 90, 45);

        // **create textFieldFirstName
        textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(25, 130, 180, 45);
        textFieldFirstName.setSize(180, 35);
        textFieldFirstName.setFont(new Font(null, Font.BOLD, 14));

        // **create labelLastName */
        labelLastName = new JLabel("Last Name");
        labelLastName.setFont(new Font(null, Font.PLAIN, 15));
        labelLastName.setForeground(new Color(148, 164, 175));
        labelLastName.setBounds(250, 90, 90, 45);

        // **create textFieldLastName
        textFieldLastName = new JTextField();
        textFieldLastName.setBounds(250, 130, 180, 45);
        textFieldLastName.setSize(180, 35);
        textFieldLastName.setFont(new Font(null, Font.BOLD, 14));

        // **create labelFullName */
        labelFullName = new JLabel("Full Name");
        labelFullName.setFont(new Font(null, Font.PLAIN, 15));
        labelFullName.setForeground(new Color(148, 164, 175));
        labelFullName.setBounds(25, 180, 90, 45);

        // **create textFieldFullName
        textFieldFullName = new JTextField();
        textFieldFullName.setBounds(25, 220, 180, 45);
        textFieldFullName.setSize(405, 35);
        textFieldFullName.setFont(new Font(null, Font.BOLD, 14));

        // **create labelEmail
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font(null, Font.PLAIN, 15));
        labelEmail.setForeground(new Color(148, 164, 175));
        labelEmail.setBounds(25, 270, 90, 45);

        // **create textFieldEmail
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(25, 310, 180, 45);
        textFieldEmail.setSize(405, 35);
        textFieldEmail.setFont(new Font(null, Font.BOLD, 14));

        // **create btnSave */
        btnSave = new JButton("Save");
        btnSave.setBounds(25, 360, 100, 35);
        btnSave.setFocusable(false);
        btnSave.setBackground(new Color(38, 78, 202));
        btnSave.setForeground(Color.white);

        // **add components to panelCenter */
        panelCenter.add(btnSave);
        panelCenter.add(textFieldEmail);
        panelCenter.add(labelEmail);
        panelCenter.add(textFieldFullName);
        panelCenter.add(labelFullName);
        panelCenter.add(textFieldLastName);
        panelCenter.add(labelLastName);
        panelCenter.add(textFieldFirstName);
        panelCenter.add(labelFirstName);
        panelCenter.add(labelHeaderPanelCenter);
        panelCenter.add(labelHeaderPanelCenter);

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
            // **when click homeMenu item, it is going to open home page */
            this.dispose();
            new Home();
        } else if (e.getSource() == changePasswordMenu) {
            // **when click changePasswordMenu item, it is going to open change password
            // page */
            this.dispose();
            new ChangePassword();
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