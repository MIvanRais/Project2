package presentation.administrationside;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import logic.LogicBuilding;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    // 33, 72, 192 - primer
    // 38, 78, 202 - secondary
    Object dataColumns[] = { "No", "Username", "Registration Date" };
    JMenuBar menuBar;
    JMenu adminMenu;
    JMenuItem changePasswordMenu, logoutMenu;
    JPanel panelNorth;
    JLabel labelHeader;
    JTable tableUsers;
    DefaultTableModel defaultTableModel;
    JScrollPane scrollPane;
    JButton btnDelete, btnAdd;
    JTextField textFieldSearch;

    Home() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Home");
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
        changePasswordMenu = new JMenuItem("Change Password");
        changePasswordMenu.addActionListener(this);
        logoutMenu = new JMenuItem("Logout");
        logoutMenu.addActionListener(this);

        // **add component (menu item) to menu */
        adminMenu.add(changePasswordMenu);
        adminMenu.add(logoutMenu);

        // **add component (menu) to menu bar */
        menuBar.add(adminMenu);

        // **create panelNorth */
        panelNorth = new JPanel();
        panelNorth.setBounds(0, 0, 1200, 100);
        panelNorth.setBackground(new Color(33, 72, 192));

        // **create labelHeader */
        labelHeader = new JLabel("Admin Attendance Management System");
        labelHeader.setBounds(0, 0, 1200, 100);
        labelHeader.setFont(new Font(null, Font.BOLD, 25));
        labelHeader.setForeground(Color.white);
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
        // ** */ DefaultTableModel to JTable
        tableUsers = new JTable(
                LogicBuilding.getAllData("SELECT username, registration_date FROM users;", dataColumns)) {
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
        tableUsers.getTableHeader().setReorderingAllowed(false);
        tableUsers.getTableHeader().setResizingAllowed(false);
        tableUsers.getTableHeader().setBackground(new Color(30, 76, 216));
        tableUsers.getTableHeader().setForeground(Color.white);
        tableUsers.getTableHeader().setFont(new Font(null, Font.BOLD, 18));

        // **set styles to cells */
        tableUsers.setFont(new Font(null, Font.PLAIN, 14));
        tableUsers.setRowHeight(22);
        tableUsers.setShowVerticalLines(false);

        // **as a container for the table */
        scrollPane = new JScrollPane(tableUsers);
        scrollPane.setBounds(200, 170, 800, 400);
        scrollPane.getViewport().setBackground(Color.white);

        // **create btnAdd */
        btnAdd = new JButton("Create");
        btnAdd.setBounds(750, 580, 100, 35);
        btnAdd.setFocusable(false);
        btnAdd.setBackground(new Color(38, 78, 202));
        btnAdd.setForeground(Color.white);
        btnAdd.addActionListener(this);

        // **create btnDelete */
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(880, 580, 100, 35);
        btnDelete.setFocusable(false);
        btnDelete.setBackground(new Color(38, 78, 202));
        btnDelete.setForeground(Color.white);
        btnDelete.addActionListener(this);

        // **add components to frame */
        this.add(btnAdd);
        this.add(textFieldSearch);
        this.add(btnDelete);
        this.add(scrollPane);
        this.setJMenuBar(menuBar);
        this.add(labelHeader);
        this.add(panelNorth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePasswordMenu) {
            // **when click changePasswordMenu item, it is going to open ChangePassword page
            // */
            this.dispose();
            new ChangePassword();
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
            tableUsers.setModel(
                    LogicBuilding.getSearchData("SELECT username, registration_date FROM users WHERE username LIKE '%"
                            + keyword + "%' OR registration_date LIKE '%" + keyword + "%';", dataColumns));

        }

        if (e.getSource() == btnAdd) {
            // **when click btnAdd, it is going to open RegisterUser page */
            this.dispose();
            new RegisterUser();
        }

        if (e.getSource() == btnDelete) {
            // *get selected row on tableUsers table
            int selectedRow = tableUsers.getSelectedRow();

            if (selectedRow != -1) {
                // ** when you already selected row, it is going to delete the row depend on
                // your selected row */
                String getUsername = tableUsers.getValueAt(selectedRow, 1).toString();
                if (LogicBuilding.deleteData("DELETE FROM users WHERE username ='" + getUsername + "';")) {
                    JOptionPane.showMessageDialog(null, "Delete Data User Successful", "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Home();
                }
            } else {
                // **if unsuccessful delete the row, the popup will be appear */
                JOptionPane.showMessageDialog(null, "Firstly Please Select A Data", "Unsuccessful",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}