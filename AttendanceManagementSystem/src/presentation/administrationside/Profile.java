package presentation.administrationside;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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

    Profile() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Profile");
        this.setSize(600, 700);
        this.setResizable(false);
        this.setLayout(null);

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
        panelEast.setLayout(null);
        // panelEast.setBackground(Color.cyan);

        // **create labelFullName
        labelFullName = new JLabel("Mochammad Ivan Ra'is");
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
        // labelFirstName.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create dataFirstName
        dataFirstName = new JLabel("Mochammad");
        dataFirstName.setBounds(140, 130, 190, 30);
        dataFirstName.setFont(new Font(null, Font.PLAIN, 15));
        dataFirstName.setForeground(Color.black);
        // dataFirstName.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create labelLastName
        labelLastName = new JLabel("Last Name     :");
        labelLastName.setBounds(20, 200, 115, 30);
        labelLastName.setFont(new Font(null, Font.PLAIN, 15));
        labelLastName.setForeground(Color.black);
        // labelLastName.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create dataLastName
        dataLastName = new JLabel("Ivan Ra'is");
        dataLastName.setBounds(140, 200, 190, 30);
        dataLastName.setFont(new Font(null, Font.PLAIN, 15));
        dataLastName.setForeground(Color.black);
        // dataLastName.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create labelGender
        labelGender = new JLabel("Gender          :");
        labelGender.setBounds(20, 270, 115, 30);
        labelGender.setFont(new Font(null, Font.PLAIN, 15));
        labelGender.setForeground(Color.black);
        // labelGender.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create btnMale
        btnMale = new JRadioButton("Male");
        btnMale.setBounds(140, 270, 95, 30);
        btnMale.setFont(new Font(null, Font.PLAIN, 15));
        btnFemale = new JRadioButton("Female");
        btnFemale.setBounds(240, 270, 95, 30);
        btnFemale.setFont(new Font(null, Font.PLAIN, 15));

        // **create btnGroup
        btnGroup = new ButtonGroup();

        // **add components to btnGroup
        btnGroup.add(btnMale);
        btnGroup.add(btnFemale);

        // **create labelNoTelephone
        labelNoTelephone = new JLabel("No. Telephone:");
        labelNoTelephone.setBounds(20, 340, 115, 30);
        labelNoTelephone.setFont(new Font(null, Font.PLAIN, 15));
        labelNoTelephone.setForeground(Color.black);
        // labelNoTelephone.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create dataNoTlp
        dataNoTlp = new JLabel("0857123456");
        dataNoTlp.setBounds(140, 340, 190, 30);
        dataNoTlp.setFont(new Font(null, Font.PLAIN, 15));
        dataNoTlp.setForeground(Color.black);
        // dataNoTlp.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create labelEmail
        labelEmail = new JLabel("Email             :");
        labelEmail.setBounds(20, 410, 115, 30);
        labelEmail.setFont(new Font(null, Font.PLAIN, 15));
        labelEmail.setForeground(Color.black);
        // labelEmail.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create dataEmail
        dataEmail = new JLabel("ivan@gmail.com");
        dataEmail.setBounds(140, 410, 190, 30);
        dataEmail.setFont(new Font(null, Font.PLAIN, 15));
        dataEmail.setForeground(Color.black);
        // dataEmail.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create btnUpdate
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(200, 500, 100, 35);
        btnUpdate.setFocusable(false);
        btnUpdate.setBackground(new Color(38, 78, 202));
        btnUpdate.setForeground(Color.white);
        btnUpdate.addActionListener(this);

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
        // panelEast.add(dataGender);
        panelEast.add(dataNoTlp);
        panelEast.add(dataEmail);
        panelEast.add(btnMale);
        panelEast.add(btnFemale);

        // **create panelSouth
        panelSouth = new JPanel();
        panelSouth.setBounds(0, 600, 600, 100);
        panelSouth.setBackground(new Color(33, 72, 192));
        panelSouth.setLayout(null);
        // panelSouth.setBackground(new Color(33, 72, 192));

        // **create labelFooter */
        labelFooter = new JLabel("Admin Attendance Management System");
        labelFooter.setBounds(0, 0, 600, 50);
        labelFooter.setFont(new Font(null, Font.BOLD, 20));
        labelFooter.setForeground(Color.white);
        labelFooter.setHorizontalAlignment(JLabel.CENTER);
        // labelFooter.setVerticalTextPosition((int) JLabel.CENTER_ALIGNMENT);
        // labelFooter.setBorder(BorderFactory.createLineBorder(Color.black));

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
        if(e.getSource()==btnUpdate){
            this.dispose();
            new UpdateProfile();
        }

    }

}
