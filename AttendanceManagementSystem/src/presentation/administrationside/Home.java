package presentation.administrationside;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Home extends JFrame {
    // 33, 72, 192 - primer
    // 38, 78, 202 - secondary
    JMenuBar menuBar;
    JMenu userMenu;
    JMenuItem profileMenu, changePasswordMenu, logoutMenu;
    JPanel panelNorth;
    JLabel labelHeader;

    Home() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Home");
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLayout(null);

        menuBar = new JMenuBar(); // **container for menu */
        menuBar.add(Box.createHorizontalGlue()); //**set menuBar position to right-align */

        // **create userMenu */
        userMenu = new JMenu("Mochammad Ivan Ra'is");
        Font setFont = new Font("sans-serif", Font.BOLD, 14);
        UIManager.put("Menu.font", setFont);

        // **create menuItem */
        profileMenu = new JMenuItem("Profile");
        changePasswordMenu = new JMenuItem("Change Password");
        logoutMenu = new JMenuItem("Logout");

        // **add component (menu item) to menu */
        userMenu.add(profileMenu);
        userMenu.add(changePasswordMenu);
        userMenu.add(logoutMenu);

        // **add component (menu) to menu bar */
        menuBar.add(userMenu);

        // **create panelNorth */
        panelNorth = new JPanel();
        panelNorth.setBounds(0, 0, 1200, 100);
        panelNorth.setBackground(new Color(33, 72, 192));

        // **create labelHeader */
        labelHeader = new JLabel("Admin Attendance Management System");
        labelHeader.setBounds(0, 0, 1200, 100);
        labelHeader.setFont(new Font(null, Font.BOLD, 20));
        labelHeader.setForeground(Color.white);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);

        //**add components to frame */
        this.setJMenuBar(menuBar);
        this.add(labelHeader);
        this.add(panelNorth);
        this.setVisible(true);
    }
}