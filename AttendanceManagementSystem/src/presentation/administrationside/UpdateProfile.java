package presentation.administrationside;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProfile extends JFrame implements ActionListener {

    JPanel panelWest, panelEast, panelSouth, panelLineWest;
    JLabel labelProfile, labelFirstName, labelLastName, labelEmail, labelProject, labelGender, labelNoTelephone, labelFooter;
    JTextField textFieldFirstName, textFieldLastName, textFieldNoTlp, textFieldEmail;
    JButton btnSave;
    JRadioButton btnMale, btnFemale;
    ButtonGroup btnGroup;

    UpdateProfile() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Update Profile");
        this.setSize(600, 650);
        this.setResizable(false);
        this.setLayout(null);

        // **create panelWest
        panelWest = new JPanel();
        panelWest.setBounds(0, 0, 250, 550);
        panelWest.setBackground(new Color(33, 72, 192));
        panelWest.setLayout(null);

        // **create labelProfile
        labelProfile = new JLabel("Update Profile");
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
        panelEast.setBounds(250, 0, 350, 550);
        panelEast.setLayout(null);
        panelEast.setBackground(Color.white);
        // panelEast.setBackground(Color.cyan);

        // **create labelFirstName
        labelFirstName = new JLabel("First Name     :");
        labelFirstName.setBounds(20, 50, 115, 30);
        labelFirstName.setFont(new Font(null, Font.PLAIN, 15));
        labelFirstName.setForeground(Color.black);
        // labelFirstName.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create textFieldFirstName
        textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(20, 95, 300, 30);
        textFieldFirstName.setFont(new Font(null,Font.PLAIN,15));

        // **create labelLastName
        labelLastName = new JLabel("Last Name     :");
        labelLastName.setBounds(20, 140, 115, 30);
        labelLastName.setFont(new Font(null, Font.PLAIN, 15));
        labelLastName.setForeground(Color.black);
        // labelLastName.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create textFieldLastName
        textFieldLastName = new JTextField();
        textFieldLastName.setBounds(20, 180, 300, 30);
        textFieldLastName.setFont(new Font(null,Font.PLAIN,15));

        // **create labelGender
        labelGender = new JLabel("Gender          :");
        labelGender.setBounds(20, 225, 115, 30);
        labelGender.setFont(new Font(null, Font.PLAIN, 15));
        labelGender.setForeground(Color.black);
        // labelGender.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create btnMale
        btnMale = new JRadioButton("Male");
        btnMale.setBounds(20, 270, 95, 30);
        btnMale.setFont(new Font(null, Font.PLAIN, 15));
        btnMale.setBackground(Color.white);
        btnFemale = new JRadioButton("Female");
        btnFemale.setBounds(125, 270, 95, 30);
        btnFemale.setFont(new Font(null, Font.PLAIN, 15));
        btnFemale.setBackground(Color.white);

        // **create btnGroup
        btnGroup = new ButtonGroup();

        // **add components to btnGroup
        btnGroup.add(btnMale);
        btnGroup.add(btnFemale);

        // **create labelNoTelephone
        labelNoTelephone = new JLabel("No. Telephone:");
        labelNoTelephone.setBounds(20, 310, 115, 30);
        labelNoTelephone.setFont(new Font(null, Font.PLAIN, 15));
        labelNoTelephone.setForeground(Color.black);
        // labelNoTelephone.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create textFieldNoTlp
        textFieldNoTlp = new JTextField();
        textFieldNoTlp.setBounds(20, 355, 300, 30);
        textFieldNoTlp.setFont(new Font(null,Font.PLAIN,15));

        // **create labelEmail
        labelEmail = new JLabel("Email             :");
        labelEmail.setBounds(20, 400, 115, 30);
        labelEmail.setFont(new Font(null, Font.PLAIN, 15));
        labelEmail.setForeground(Color.black);
        // labelEmail.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create textFieldEmail
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(20, 445, 300, 30);
        textFieldEmail.setFont(new Font(null,Font.PLAIN,15));

        // **create btnUpdate
        btnSave = new JButton("Save");
        btnSave.setBounds(217, 500, 100, 35);
        btnSave.setFocusable(false);
        btnSave.setBackground(new Color(38, 78, 202));
        btnSave.setForeground(Color.white);

        // **add components to panelEast
        panelEast.add(labelFirstName);
        panelEast.add(labelLastName);
        panelEast.add(labelGender);
        panelEast.add(labelNoTelephone);
        panelEast.add(labelEmail);
        panelEast.add(btnSave);
        panelEast.add(textFieldFirstName);
        panelEast.add(textFieldLastName);
        panelEast.add(textFieldNoTlp);
        panelEast.add(textFieldEmail);
        panelEast.add(btnMale);
        panelEast.add(btnFemale);

        // **create panelSouth
        panelSouth = new JPanel();
        panelSouth.setBounds(0, 550, 600, 100);
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
        // TODO Auto-generated method stub

    }

}
