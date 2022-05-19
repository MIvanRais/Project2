package presentation.userside;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import logic.LogicBuilding;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{

    Object dataColumns[] = {"No", "Full Name", "Status"};
    Object dataRows[][] = {
        {1, "Mochammad Ivan Ra'is", ""},
        {2, "Muhammad Sidqi Mukhlisin", ""},
        {3, "Muhammad Fauzan Arsyi", ""}
    };

    JTable tablePersons;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu adminMenu;
    JMenuItem changePasswordMenu, logoutMenu, profileMenu;
    JPanel panelNorth;
    JLabel labelHeader;
    JTextField textFieldSearch;
    JButton btnAbsent;

    public static String getUsername;

    Home(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Home");
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLayout(null);

        menuBar = new JMenuBar(); // **container for menu */
        menuBar.add(Box.createHorizontalGlue()); // **set menuBar position to right-align */

        // **create adminMenu */
        adminMenu = new JMenu();

        // **set text to relevant data on the JMenu
        // **call LogicBuilding.getDataProfile method
        Object getData[] = LogicBuilding.getDataProfile("SELECT * FROM user_details WHERE user_username ='" + Login.username + "';", 2);

        adminMenu.setText(getData[0].toString() + " " + getData[1].toString());

        Font setFont = new Font("sans-serif", Font.BOLD, 14);
        UIManager.put("Menu.font", setFont);

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

        // **create textFieldSearch */
        textFieldSearch = new JTextField();
        textFieldSearch.setSize(178, 35);
        textFieldSearch.setFont(new Font(null, Font.BOLD, 14));
        textFieldSearch.setBounds(820, 130, 178, 30);
        textFieldSearch.setText("Search");
        textFieldSearch.addActionListener(this);

         // **create table*/
        // **The JTable can be set up to display any data model so we can pass in
        // ** DefaultTableModel to JTable
        tablePersons = new JTable(LogicBuilding.getAllDataPerson("SELECT first_name, last_name, status FROM person;", dataColumns) ) {
            @Override
            // **set to false in order to cells can't edit */
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // **set automatically width of column to fit content */
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(
                        Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        // **set styles to table header */
        tablePersons.getTableHeader().setReorderingAllowed(false);
        tablePersons.getTableHeader().setResizingAllowed(false);
        tablePersons.getTableHeader().setBackground(new Color(255,165,0));
        tablePersons.getTableHeader().setForeground(Color.white);
        tablePersons.getTableHeader().setFont(new Font(null, Font.BOLD, 18));

        // **set styles to cells */
        tablePersons.setFont(new Font(null, Font.PLAIN, 14));
        tablePersons.setRowHeight(22);
        tablePersons.setShowVerticalLines(false);

        // **as a container for the table */
        scrollPane = new JScrollPane(tablePersons);
        scrollPane.setBounds(200, 170, 800, 400);
        scrollPane.getViewport().setBackground(Color.white);

        // **create btnAbsent */
        btnAbsent = new JButton("Absent");
        btnAbsent.setBounds(900, 580, 100, 35);
        btnAbsent.setFocusable(false);
        btnAbsent.setBorderPainted(false);
        btnAbsent.setBackground(new Color(255,165,0));
        btnAbsent.setForeground(Color.white);
        btnAbsent.addActionListener(this);

        // **add components to frame
        this.add(btnAbsent);
        this.add(scrollPane);
        this.add(textFieldSearch);
        this.setJMenuBar(menuBar);
        this.add(labelHeader);
        this.add(panelNorth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePasswordMenu) {
            // **when click changePasswordMenu item, it is going to open ChangePassword page
            this.dispose();
            new ChangePassword();
        }

        if (e.getSource() == profileMenu) {
            // **when click profileMenu item, it is going to open Profile page
            this.dispose();
            new Profile();
        }

        if (e.getSource() == logoutMenu) {
            // **when click logoutMenu item, it is going to close the page */
            int answer;
            answer = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                this.dispose();
            }
        }

        if (e.getSource() == textFieldSearch) {
            // **when hit enter, it is going to search depending on your keyword
            String keyword = textFieldSearch.getText();
            tablePersons.setModel(
                    LogicBuilding.getSearchDataPerson("SELECT first_name, last_name, status FROM person WHERE first_name LIKE '%"
                            + keyword + "%' OR last_name LIKE '%" + keyword + "%' OR status LIKE '%"+ keyword +"%';", dataColumns));
        }

        if(e.getSource()==btnAbsent){
            // **get selected row on tablePersons table
            int selectedRow = tablePersons.getSelectedRow();

            if (selectedRow != -1) {
                // ** when you already selected row, it is going to open AbsentForm page. 
                getUsername = tablePersons.getValueAt(selectedRow, 1).toString();
                this.dispose();
                new AbsentForm();
            } 
            else {
                // **if unsuccessful delete the row, the popup will be appear */
                JOptionPane.showMessageDialog(null, "Firstly Please Select A Data", "Unsuccessful",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }
    
}
