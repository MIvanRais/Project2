package presentation.administrationside;

import logic.LogicBuilding;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame implements ActionListener {

    JPanel panelWest, panelEast, panelSouth, panelLineWest, panelLineEast;
    JLabel labelProfile, labelFullName, labelFirstName, labelLastName, labelEmail, labelProject, labelGender, labelNoTelephone, labelFooter, dataFirstName, dataLastName, dataGender, dataNoTlp, dataEmail;
    JButton btnUpdate;
    JRadioButton btnMale, btnFemale;
    ButtonGroup btnGroup;
    JMenuBar menuBar;
    JMenu adminMenu;
    JMenuItem homeMenu, logoutMenu, changePasswordMenu;

    Profile() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Profile");
        this.setSize(600, 710);
        this.setResizable(false);
        this.setLayout(null);

        menuBar = new JMenuBar(); // **container for menu */
        menuBar.setBackground(Color.white);
        menuBar.add(Box.createHorizontalGlue()); // **set menuBar position to right-align */

        // **create adminMenu
        adminMenu = new JMenu();
        Font setFont = new Font("sans-serif", Font.BOLD, 14);
        UIManager.put("Menu.font", setFont);

        // **create menuItem
        homeMenu = new JMenuItem("Home");
        homeMenu.setBackground(Color.white);
        homeMenu.addActionListener(this);
        changePasswordMenu = new JMenuItem("Change Password");
        changePasswordMenu.setBackground(Color.white);
        changePasswordMenu.addActionListener(this);
        logoutMenu = new JMenuItem("Logout");
        logoutMenu.setBackground(Color.white);
        logoutMenu.addActionListener(this);

        // **add components to adminMenu
        adminMenu.add(homeMenu);
        adminMenu.add(changePasswordMenu);
        adminMenu.add(logoutMenu);

        menuBar.add(adminMenu);

        // **create panelWest
        panelWest = new JPanel();
        panelWest.setBounds(0, 0, 250, 600);
        panelWest.setBackground(new Color(33, 72, 192));
        panelWest.setLayout(null);

        // **create labelProfile
        labelProfile = new JLabel("Profile");
        labelProfile.setBounds(0, 250, 250, 50);
        labelProfile.setFont(new Font(null, Font.BOLD, 25));
        labelProfile.setForeground(Color.white);
        labelProfile.setHorizontalAlignment(JLabel.CENTER);

        // **create panelLineWest
        panelLineWest = new JPanel();
        panelLineWest.setBounds(100, 290, 80, 2);
        panelLineWest.setBackground(Color.white);

        // **add component to panelWest
        panelWest.add(labelProfile);
        panelWest.add(panelLineWest);

        // **create panelEast
        panelEast = new JPanel();
        panelEast.setBounds(250, 0, 350, 600);
        panelEast.setBackground(Color.white);
        panelEast.setLayout(null);

        // **create labelFullName
        labelFullName = new JLabel();
        labelFullName.setBounds(0, 50, 350, 50);
        labelFullName.setFont(new Font(null, Font.BOLD, 20));
        labelFullName.setForeground(Color.black);
        labelFullName.setHorizontalAlignment(JLabel.CENTER);

        // **create panelLineEast
        panelLineEast = new JPanel();
        panelLineEast.setBounds(0, 90, 350, 2);
        panelLineEast.setBackground(new Color(33, 72, 192));

        // **create labelFirstName
        labelFirstName = new JLabel("First Name     :");
        labelFirstName.setBounds(20, 130, 115, 30);
        labelFirstName.setFont(new Font(null, Font.PLAIN, 15));
        labelFirstName.setForeground(Color.black);

        // **create dataFirstName
        dataFirstName = new JLabel();
        dataFirstName.setBounds(140, 130, 190, 30);
        dataFirstName.setFont(new Font(null, Font.PLAIN, 15));
        dataFirstName.setForeground(Color.black);

        // **create labelLastName
        labelLastName = new JLabel("Last Name     :");
        labelLastName.setBounds(20, 200, 115, 30);
        labelLastName.setFont(new Font(null, Font.PLAIN, 15));
        labelLastName.setForeground(Color.black);

        // **create dataLastName
        dataLastName = new JLabel();
        dataLastName.setBounds(140, 200, 190, 30);
        dataLastName.setFont(new Font(null, Font.PLAIN, 15));
        dataLastName.setForeground(Color.black);

        // **create labelGender
        labelGender = new JLabel("Gender          :");
        labelGender.setBounds(20, 270, 115, 30);
        labelGender.setFont(new Font(null, Font.PLAIN, 15));
        labelGender.setForeground(Color.black);


        // **create dataGender
        dataGender = new JLabel();
        dataGender.setBounds(140, 270, 190, 30);
        dataGender.setFont(new Font(null, Font.PLAIN, 15));
        dataGender.setForeground(Color.black);

        // **create labelNoTelephone
        labelNoTelephone = new JLabel("No. Telephone:");
        labelNoTelephone.setBounds(20, 340, 115, 30);
        labelNoTelephone.setFont(new Font(null, Font.PLAIN, 15));
        labelNoTelephone.setForeground(Color.black);

        // **create dataNoTlp
        dataNoTlp = new JLabel();
        dataNoTlp.setBounds(140, 340, 190, 30);
        dataNoTlp.setFont(new Font(null, Font.PLAIN, 15));
        dataNoTlp.setForeground(Color.black);

        // **create labelEmail
        labelEmail = new JLabel("Email             :");
        labelEmail.setBounds(20, 410, 115, 30);
        labelEmail.setFont(new Font(null, Font.PLAIN, 15));
        labelEmail.setForeground(Color.black);

        // **create dataEmail
        dataEmail = new JLabel();
        dataEmail.setBounds(140, 410, 190, 30);
        dataEmail.setFont(new Font(null, Font.PLAIN, 15));
        dataEmail.setForeground(Color.black);

        // **create btnUpdate
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(200, 500, 100, 35);
        btnUpdate.setFocusable(false);
        btnUpdate.setBackground(new Color(38, 78, 202));
        btnUpdate.setForeground(Color.white);
        btnUpdate.addActionListener(this);

        // **set text to relevant data
        // **call LogicBuilding.getDataProfile method
        Object getData[] = LogicBuilding.getDataProfile("SELECT * FROM admin_details WHERE admin_username ='" + Login.username + "';", 5);

        adminMenu.setText(getData[0].toString() + " " + getData[1].toString());
        labelFullName.setText(getData[0].toString() + " " + getData[1].toString());
        dataFirstName.setText(getData[0].toString());
        dataLastName.setText(getData[1].toString());
        dataGender.setText(getData[2].toString());
        dataNoTlp.setText(getData[3].toString());
        dataEmail.setText(getData[4].toString());

        // **add components to panelEast
        panelEast.add(labelFullName);
        panelEast.add(panelLineEast);
        panelEast.add(labelFirstName);
        panelEast.add(labelLastName);
        panelEast.add(labelGender);
        panelEast.add(labelNoTelephone);
        panelEast.add(labelEmail);
        panelEast.add(btnUpdate);
        panelEast.add(dataFirstName);
        panelEast.add(dataLastName);
        panelEast.add(dataGender);
        panelEast.add(dataNoTlp);
        panelEast.add(dataEmail);

        // **create panelSouth
        panelSouth = new JPanel();
        panelSouth.setBounds(0, 600, 600, 100);
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
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnUpdate){
            this.dispose();
            new UpdateProfile();
        }

        if(e.getSource()==homeMenu){
            this.dispose();
            new Home();
        }

        if(e.getSource()==changePasswordMenu){
            this.dispose();
            new ChangePassword();
        }

        if(e.getSource()==logoutMenu){
            // **when click logoutMenu item, it is going to close the page */
            int answer;
            answer = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                this.dispose();
            }
        }
    }

}
