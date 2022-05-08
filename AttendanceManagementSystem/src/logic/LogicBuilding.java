package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class LogicBuilding {

    private static Connection connect;
    private static Statement statement;

    // **getConnection method */
    private static void getConnection() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/attendance_db", "admin",
                    "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // **getAllData method */
    public static DefaultTableModel getAllData(String query, Object[] columnNames) {
        getConnection();

        DefaultTableModel getDataSet = new DefaultTableModel(null, columnNames);

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling execute() method */
            statement.execute(query);

            // **retrieve the result of the query */
            ResultSet resultSet = statement.getResultSet();

            int getNumber = 1;
            while (resultSet.next()) {
                Object rowData[] = {
                        getNumber, resultSet.getString("username"), resultSet.getDate("registration_date")
                };
                getDataSet.addRow(rowData);
                getNumber++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDataSet;
    }

    public static DefaultTableModel getSearchData(String query, Object[] columnNames) {
        getConnection();

        DefaultTableModel getDataSet = new DefaultTableModel(null, columnNames);

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling execute() method */
            statement.execute(query);

            // **retrieve the result of the query */
            ResultSet resultSet = statement.getResultSet();

            int getNumber = 1;
            while (resultSet.next()) {
                Object rowData[] = {
                        getNumber, resultSet.getString("username"), resultSet.getDate("registration_date")
                };
                getDataSet.addRow(rowData);
                getNumber++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDataSet;
    }
}