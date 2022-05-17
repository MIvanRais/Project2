package presentation.userside;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{

    JMenuBar menuBar;
    JMenu adminMenu;
    JMenuItem changePasswordMenu, logoutMenu, profileMenu;
    JPanel panelNorth;
    JLabel labelHeader;

    Home(){
        // this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Home");
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLayout(null);

        menuBar = new JMenuBar(); // **container for menu */
        menuBar.add(Box.createHorizontalGlue()); // **set menuBar position to right-align */

        // **create adminMenu */
        adminMenu = new JMenu("Mochammad Ivan Ra'is");

        // **set text to relevant data on the JMenu
        // **call LogicBuilding.getDataProfile method
        // Object getData[] = LogicBuilding.getDataProfile("SELECT * FROM admin_details WHERE admin_username ='" + Login.username + "';", 2);

        // adminMenu.setText(getData[0].toString() + " " + getData[1].toString());

        // Font setFont = new Font("sans-serif", Font.BOLD, 14);
        // UIManager.put("Menu.font", setFont);

        // **create menuItem */
        changePasswordMenu = new JMenuItem("Change Password");
        changePasswordMenu.addActionListener(this);
        profileMenu = new JMenuItem("Profile");
        profileMenu.addActionListener(this);
        logoutMenu = new JMenuItem("Logout");
        logoutMenu.addActionListener(this);

        // **add component (menu item) to menu */
        adminMenu.add(changePasswordMenu);
        adminMenu.add(profileMenu);
        adminMenu.add(logoutMenu);

        // **add component (menu) to menu bar */
        menuBar.add(adminMenu);

        // **create panelNorth */
        panelNorth = new JPanel();
        panelNorth.setBounds(0, 70, 1200, 30);
        panelNorth.setBackground(new Color(255,165,0));

        // **create labelHeader */
        labelHeader = new JLabel("Attendance Management System");
        labelHeader.setBounds(0, 0, 1200, 100);
        labelHeader.setFont(new Font(null, Font.BOLD, 25));
        labelHeader.setForeground(Color.black);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);

        this.setJMenuBar(menuBar);
        this.add(labelHeader);
        this.add(panelNorth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
