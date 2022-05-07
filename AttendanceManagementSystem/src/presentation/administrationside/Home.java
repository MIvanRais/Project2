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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    // 33, 72, 192 - primer
    // 38, 78, 202 - secondary
    JMenuBar menuBar;
    JMenu adminMenu;
    JMenuItem profileMenu, changePasswordMenu, logoutMenu;
    JPanel panelNorth;
    JLabel labelHeader;
    JTable tableUsers;
    DefaultTableModel defaultTableModel;
    JScrollPane scrollPane;
    JButton btnDelete;

    Home() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        profileMenu = new JMenuItem("Profile");
        profileMenu.addActionListener(this);
        changePasswordMenu = new JMenuItem("Change Password");
        changePasswordMenu.addActionListener(this);
        logoutMenu = new JMenuItem("Logout");
        logoutMenu.addActionListener(this);

        // **add component (menu item) to menu */
        adminMenu.add(profileMenu);
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

        // **create table*/
        Object dataColumns[] = { "No", "Username", "Registration Date" };
        Object dataRows[][] = {
                { "1", "Ivan", "2022-05-05" },
                { "2", "Jodi", "2022-05-05" },
                { "3", "Udin", "2022-05-05" },
                { "1", "Ivan", "2022-05-05" },
                { "2", "Jodi", "2022-05-05" }
        };

        // **create more flexible table than JTable by using DefaultTableModel*/
        defaultTableModel = new DefaultTableModel(dataRows, dataColumns);

        // **The JTable can be set up to display any data model so we can pass in
        // DefaultTableModel to JTable
        tableUsers = new JTable(defaultTableModel) {
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
        scrollPane.setBounds(200, 150, 800, 400);
        scrollPane.getViewport().setBackground(Color.white);

        // **create btnDelete */
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(880, 565, 100, 45);
        btnDelete.setFocusable(false);
        btnDelete.setBackground(new Color(38, 78, 202));
        btnDelete.setForeground(Color.white);

        // **add components to frame */
        this.add(btnDelete);
        this.add(scrollPane);
        this.setJMenuBar(menuBar);
        this.add(labelHeader);
        this.add(panelNorth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileMenu) {
            this.dispose();
            new Profile();
        } else if (e.getSource() == changePasswordMenu) {
            this.dispose();
            new ChangePassword();
        } else {
            int answer;
            answer = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                this.dispose();
            }
        }
    }
}