package presentation.userside;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import logic.LogicBuilding;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbsentForm extends JFrame implements ActionListener {

    JPanel panelWest, panelEast, panelSouth, panelLineWest;
    JLabel labelFirstName, labelLastName, labelEmail, labelProject, labelAbsent, labelNoTelephone,
            labelFooter, labelWarnGender;
    JTextField textFieldFirstName, textFieldLastName, textFieldNoTlp, textFieldEmail;
    JButton btnSave, btnBack;
    JRadioButton btnPresent, btnPermit, btnAbsent;
    ButtonGroup btnGroup;

    public static String getFirstName, getLastName, getGender, getNoTlphn, getEmail;

    AbsentForm() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Absent");
        this.setSize(600, 500);
        this.setResizable(false);
        this.setLayout(null);

        // **create panelWest
        panelWest = new JPanel();
        panelWest.setBounds(0, 0, 250, 400);
        panelWest.setLayout(null);

        // **create labelAbsent
        labelAbsent = new JLabel("Absent");
        labelAbsent.setBounds(0, 150, 250, 50);
        labelAbsent.setFont(new Font(null, Font.BOLD, 25));
        labelAbsent.setForeground(Color.black);
        labelAbsent.setHorizontalAlignment(JLabel.CENTER);

        // **create panelLineWest
        panelLineWest = new JPanel();
        panelLineWest.setBounds(100, 190, 80, 2);
        panelLineWest.setBackground(Color.black);

        // **add component to panelWest
        panelWest.add(labelAbsent);
        panelWest.add(panelLineWest);

        // **create panelEast
        panelEast = new JPanel();
        panelEast.setBounds(250, 0, 350, 400);
        panelEast.setLayout(null);
        panelEast.setBackground(Color.white);

        // **create labelFirstName
        labelFirstName = new JLabel("First Name");
        labelFirstName.setBounds(20, 25, 115, 30);
        labelFirstName.setFont(new Font(null, Font.PLAIN, 15));
        labelFirstName.setForeground(new Color(148, 164, 175));

        // **create textFieldFirstName
        textFieldFirstName = new JTextField();
        textFieldFirstName.setEditable(false);
        textFieldFirstName.setBounds(20, 70, 300, 30);
        textFieldFirstName.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelLastName
        labelLastName = new JLabel("Last Name");
        labelLastName.setBounds(20, 125, 115, 30);
        labelLastName.setFont(new Font(null, Font.PLAIN, 15));
        labelLastName.setForeground(new Color(148, 164, 175));

        // **create textFieldLastName
        textFieldLastName = new JTextField();
        textFieldLastName.setEditable(false);
        textFieldLastName.setBounds(20, 165, 300, 30);
        textFieldLastName.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelAbsent
        labelAbsent = new JLabel("Absent");
        labelAbsent.setBounds(20, 210, 115, 30);
        labelAbsent.setFont(new Font(null, Font.PLAIN, 15));
        labelAbsent.setForeground(new Color(148, 164, 175));

        // **create radio button
        btnPresent = new JRadioButton("Present");
        // btnPresent.setSelected(true);
        btnPresent.setBounds(20, 245, 80, 30);
        btnPresent.setFont(new Font(null, Font.PLAIN, 15));
        btnPresent.setBackground(Color.white);
        btnPresent.setBorder(BorderFactory.createLineBorder(Color.black));

        btnPermit = new JRadioButton("Permit");
        btnPermit.setBounds(125, 245, 80, 30);
        btnPermit.setFont(new Font(null, Font.PLAIN, 15));
        btnPermit.setBackground(Color.white);
        btnPermit.setBorder(BorderFactory.createLineBorder(Color.black));

        btnAbsent = new JRadioButton("Absent");
        btnAbsent.setBounds(220, 245, 80, 30);
        btnAbsent.setFont(new Font(null, Font.PLAIN, 15));
        btnAbsent.setBackground(Color.white);
        btnAbsent.setBorder(BorderFactory.createLineBorder(Color.black));

        // **create btnGroup
        btnGroup = new ButtonGroup();

        // **add components to btnGroup
        btnGroup.add(btnPresent);
        btnGroup.add(btnPermit);
        btnGroup.add(btnAbsent);

        // **create labelWarnGender
        labelWarnGender = new JLabel("Please Enter Your Absent");
        labelWarnGender.setBounds(20, 275, 290, 20);
        labelWarnGender.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnGender.setForeground(Color.red);

        // **create btnUpdate
        btnSave = new JButton("Save");
        btnSave.setBounds(100, 330, 100, 35);
        btnSave.setFocusable(false);
        btnSave.setBackground(new Color(255, 165, 0));
        btnSave.setBorderPainted(false);
        btnSave.setForeground(Color.white);
        btnSave.addActionListener(this);

        // **create btnBack
        btnBack = new JButton("Back");
        btnBack.setBounds(217, 330, 100, 35);
        btnBack.setFocusable(false);
        btnBack.setBackground(new Color(255, 193, 77));
        btnBack.setBorderPainted(false);
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);

        // **set textField and radioButton to relevant data
        // **call LogicBuilding.getDataProfile method
        Object getData[] = LogicBuilding.getDataPerson(
                "SELECT * FROM person WHERE CONCAT(first_name, ' ', last_name)='" + Home.getUsername + "';");

        textFieldFirstName.setText(getData[0].toString());
        textFieldLastName.setText(getData[1].toString());
        if (getData[2].equals("Present")) {
            btnPresent.setSelected(true);
            ;
        } else if (getData[2].equals("Permit")) {
            btnPermit.setSelected(true);
            ;
        } else if (getData[2].equals("Absent")) {
            btnAbsent.setSelected(true);
        } else {
            btnAbsent.setSelected(false);
            btnPermit.setSelected(false);
            btnPresent.setSelected(false);
        }

        // **add components to panelEast
        panelEast.add(labelFirstName);
        panelEast.add(labelLastName);
        panelEast.add(labelAbsent);
        panelEast.add(btnSave);
        panelEast.add(textFieldFirstName);
        panelEast.add(textFieldLastName);
        panelEast.add(btnPresent);
        panelEast.add(btnPermit);
        panelEast.add(btnAbsent);
        panelEast.add(btnBack);

        // **create panelSouth
        panelSouth = new JPanel();
        panelSouth.setBounds(0, 400, 600, 100);
        panelSouth.setBackground(new Color(255, 165, 0));
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
            this.dispose();
            new Home();
        }

        if (e.getSource() == btnSave) {
            // if (btnAbsent.toString().equals("null") ||
            // btnPresent.toString().equals("null")
            // || btnPermit.toString().equals("null")) {

            AbsentForm.this.setVisible(false);

            if (btnAbsent.isSelected() || btnPermit.isSelected() || btnPresent.isSelected()) {
                panelEast.remove(labelWarnGender);
            } else {
                panelEast.add(labelWarnGender);
            }

            AbsentForm.this.setVisible(true);
            // }
            // else {
            if (btnAbsent.isSelected()) {
                getGender = btnAbsent.getText();
            } else if (btnPermit.isSelected()) {
                getGender = btnPermit.getText();
            } else if (btnPresent.isSelected()) {
                getGender = btnPresent.getText();
            }

            if (btnAbsent.isSelected() || btnPermit.isSelected() || btnPresent.isSelected()) {
                if (LogicBuilding.insertAbsent(
                        "UPDATE person SET status='" + getGender + "' WHERE CONCAT(first_name, ' ', last_name)='"
                                + Home.getUsername + "';")) {
                    JOptionPane.showMessageDialog(null, "Insert Absent Successfully", "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Absent Unsuccessfully", "Unsuccessful",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            // }
        }
    }
}