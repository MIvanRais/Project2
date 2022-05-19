package presentation.userside;

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

public class UpdateProfile extends JFrame implements ActionListener{

    JPanel panelWest, panelEast, panelSouth, panelLineWest;
    JLabel labelProfile, labelFirstName, labelLastName, labelEmail, labelProject, labelGender, labelNoTelephone,
            labelFooter, labelWarnFirstName,
            labelWarnLastName, labelWarnGender, labelWarnNoTlp, labelWarnEmail;
    JTextField textFieldFirstName, textFieldLastName, textFieldNoTlp, textFieldEmail;
    JButton btnSave, btnBack;
    JRadioButton btnMale, btnFemale;
    ButtonGroup btnGroup;

    public static String getFirstName, getLastName, getGender, getNoTlphn, getEmail;

    UpdateProfile(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Update Profile");
        this.setSize(600, 650);
        this.setResizable(false);
        this.setLayout(null);

        // **create panelWest
        panelWest = new JPanel();
        panelWest.setBounds(0, 0, 250, 550);
        // panelWest.setBackground(new Color(33, 72, 192));
        panelWest.setLayout(null);

        // **create labelProfile
        labelProfile = new JLabel("Update Profile");
        labelProfile.setBounds(0, 250, 250, 50);
        labelProfile.setFont(new Font(null, Font.BOLD, 25));
        labelProfile.setForeground(Color.black);
        labelProfile.setHorizontalAlignment(JLabel.CENTER);

        // **create panelLineWest
        panelLineWest = new JPanel();
        panelLineWest.setBounds(100, 290, 80, 2);
        panelLineWest.setBackground(Color.black);

        // **add component to panelWest
        panelWest.add(labelProfile);
        panelWest.add(panelLineWest);

        // **create panelEast
        panelEast = new JPanel();
        panelEast.setBounds(250, 0, 350, 550);
        panelEast.setLayout(null);
        panelEast.setBackground(Color.white);

        // **create labelFirstName
        labelFirstName = new JLabel("First Name");
        labelFirstName.setBounds(20, 25, 115, 30);
        labelFirstName.setFont(new Font(null, Font.PLAIN, 15));
        labelFirstName.setForeground(new Color(148, 164, 175));

        // **create textFieldFirstName
        textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(20, 70, 300, 30);
        textFieldFirstName.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnFirstName
        labelWarnFirstName = new JLabel("Please Enter Your First Name");
        labelWarnFirstName.setBounds(20, 100, 290, 20);
        labelWarnFirstName.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnFirstName.setForeground(Color.red);

        // **create labelLastName
        labelLastName = new JLabel("Last Name");
        labelLastName.setBounds(20, 125, 115, 30);
        labelLastName.setFont(new Font(null, Font.PLAIN, 15));
        labelLastName.setForeground(new Color(148, 164, 175));

        // **create textFieldLastName
        textFieldLastName = new JTextField();
        textFieldLastName.setBounds(20, 165, 300, 30);
        textFieldLastName.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnLastName
        labelWarnLastName = new JLabel("Please Enter Your Last Name");
        labelWarnLastName.setBounds(20, 195, 290, 20);
        labelWarnLastName.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnLastName.setForeground(Color.red);

        // **create labelGender
        labelGender = new JLabel("Gender");
        labelGender.setBounds(20, 210, 115, 30);
        labelGender.setFont(new Font(null, Font.PLAIN, 15));
        labelGender.setForeground(new Color(148, 164, 175));

        // **create btnMale
        btnMale = new JRadioButton("Male");
        // btnMale.setSelected(true);
        btnMale.setBounds(20, 245, 95, 30);
        btnMale.setFont(new Font(null, Font.PLAIN, 15));
        btnMale.setBackground(Color.white);
        btnFemale = new JRadioButton("Female");
        btnFemale.setBounds(125, 245, 95, 30);
        btnFemale.setFont(new Font(null, Font.PLAIN, 15));
        btnFemale.setBackground(Color.white);

        // **create btnGroup
        btnGroup = new ButtonGroup();

        // **add components to btnGroup
        btnGroup.add(btnMale);
        btnGroup.add(btnFemale);

        // **create labelWarnGender
        labelWarnGender = new JLabel("Please Enter Your Gender");
        labelWarnGender.setBounds(20, 275, 290, 20);
        labelWarnGender.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnGender.setForeground(Color.red);

        // **create labelNoTelephone
        labelNoTelephone = new JLabel("No. Telephone");
        labelNoTelephone.setBounds(20, 295, 115, 30);
        labelNoTelephone.setFont(new Font(null, Font.PLAIN, 15));
        labelNoTelephone.setForeground(new Color(148, 164, 175));

        // **create textFieldNoTlp
        textFieldNoTlp = new JTextField();
        textFieldNoTlp.setBounds(20, 335, 300, 30);
        textFieldNoTlp.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnNoTlp
        labelWarnNoTlp = new JLabel("Please Enter Your No.Telephone");
        labelWarnNoTlp.setBounds(20, 365, 290, 20);
        labelWarnNoTlp.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnNoTlp.setForeground(Color.red);

        // **create labelEmail
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(20, 385, 115, 30);
        labelEmail.setFont(new Font(null, Font.PLAIN, 15));
        labelEmail.setForeground(new Color(148, 164, 175));

        // **create textFieldEmail
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(20, 425, 300, 30);
        textFieldEmail.setFont(new Font(null, Font.PLAIN, 15));

        // **create labelWarnEmail
        labelWarnEmail = new JLabel("Please Enter Your Email");
        labelWarnEmail.setBounds(20, 455, 290, 20);
        labelWarnEmail.setFont(new Font(null, Font.ITALIC, 12));
        labelWarnEmail.setForeground(Color.red);

        // **create btnUpdate
        btnSave = new JButton("Save");
        btnSave.setBounds(100, 500, 100, 35);
        btnSave.setFocusable(false);
        btnSave.setBackground(new Color(255,165,0));
        btnSave.setBorderPainted(false);
        btnSave.setForeground(Color.white);
        btnSave.addActionListener(this);

        // **create btnBack
        btnBack = new JButton("Back");
        btnBack.setBounds(217, 500, 100, 35);
        btnBack.setFocusable(false);
        btnBack.setBackground(new Color(255,193,77));
        btnBack.setBorderPainted(false);
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);

        // **set textField and radioButton to relevant data
        // **call LogicBuilding.getDataProfile method
        Object getData[] = LogicBuilding.getDataProfile("SELECT * FROM user_details WHERE user_username ='" + Login.username + "';", 5);

        textFieldFirstName.setText(getData[0].toString());
        textFieldLastName.setText(getData[1].toString());
        if(getData[2].equals("Male")){
            btnMale.setSelected(true);;
        } 
        if(getData[2].equals("Female")){
            btnFemale.setSelected(true);;
        }
        textFieldNoTlp.setText(getData[3].toString());
        textFieldEmail.setText(getData[4].toString());

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
        panelEast.add(btnBack);

        // **create panelSouth
        panelSouth = new JPanel();
        panelSouth.setBounds(0, 550, 600, 100);
        panelSouth.setBackground(new Color(255,165,0));
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
            new Profile();
        }

        if (e.getSource() == btnSave) {
            // if (textFieldFirstName.getText().trim().isEmpty() || textFieldLastName.getText().trim().isEmpty()
            //         || btnMale.toString().equalsIgnoreCase("null") || btnFemale.toString().equalsIgnoreCase("null")
            //         || textFieldNoTlp.getText().trim().isEmpty() || textFieldEmail.getText().trim().isEmpty()) {
                UpdateProfile.this.setVisible(false);

                if (textFieldFirstName.getText().trim().isEmpty()) {
                    panelEast.add(labelWarnFirstName);
                } else {
                    panelEast.remove(labelWarnFirstName);
                }

                if (textFieldLastName.getText().trim().isEmpty()) {
                    panelEast.add(labelWarnLastName);
                } else {
                    panelEast.remove(labelWarnLastName);
                }

                if (btnMale.isSelected() || btnFemale.isSelected()) {
                    panelEast.remove(labelWarnGender);
                } else {
                    panelEast.add(labelWarnGender);
                }

                if (textFieldNoTlp.getText().trim().isEmpty()) {
                    panelEast.add(labelWarnNoTlp);
                } else {
                    panelEast.remove(labelWarnNoTlp);
                }

                if (textFieldEmail.getText().trim().isEmpty()) {
                    panelEast.add(labelWarnEmail);
                } else {
                    panelEast.remove(labelWarnEmail);
                }

                UpdateProfile.this.setVisible(true);
            // }
            // **get all data from admin
            getFirstName =  textFieldFirstName.getText() ;
            getLastName = textFieldLastName.getText();
            if (btnMale.isSelected()) {
                getGender = btnMale.getText() ;
            } else if (btnFemale.isSelected()) {
                getGender = btnFemale.getText();
            }
            getNoTlphn = textFieldNoTlp.getText();
            getEmail = textFieldEmail.getText();

            if (LogicBuilding.updateProfile(
                "UPDATE user_details SET first_name = '" + getFirstName + "', last_name = '"+ getLastName +"', gender = '"+ getGender +"', no_telephone = '"+ getNoTlphn +"', email = '"+ getEmail +"' WHERE user_username = '"+ Login.username +"';"
                )
                ) {
                JOptionPane.showMessageDialog(null, "Change Profile Successfully", "Successful",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new Profile();
            } else {
                JOptionPane.showMessageDialog(null, "Change Profile Unsuccessfully", "Unsuccessful",
                        JOptionPane.ERROR_MESSAGE);
            }
        } 
        
    }
    
}
