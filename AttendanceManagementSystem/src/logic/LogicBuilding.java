package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import presentation.administrationside.ChangePassword;
import presentation.administrationside.Login;
import presentation.administrationside.UpdateProfile;

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

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDataSet;
    }

    // **getSearchData method */
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

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDataSet;
    }

    // **insertData method */
    public static boolean insertData(String query) {
        boolean resultQuery = false;

        getConnection();

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling execute() method */
            if (statement.executeUpdate(query) > 0) {
                resultQuery = true;
            }

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultQuery;
    }

    // **deleteData method */
    public static boolean deleteData(String queryParent, String queryChild) {
        boolean resultQuery = false;

        getConnection();

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling execute() method */
            if (statement.executeUpdate(queryChild) > 0) {
                if(statement.executeUpdate(queryParent) > 0){
                    resultQuery = true;
                }
            }

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultQuery;
    }

    // **checkLogin method */
    public static boolean checkLogin(String query) {
        boolean resultQuery = false;

        getConnection();

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling execute() method */
            statement.execute(query);

            // **retrieve the result of the query */
            ResultSet resultSet = statement.getResultSet();

            resultSet.next();
            if (resultSet.getInt(1) == 1) {
                resultQuery = true;
            }

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultQuery;
    }

    // **changePassword method
    public static boolean chngePassword(String query) {
        boolean resultQuery = false;

        getConnection();

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling execute() method */
            statement.execute(query);

            // **retrieve the result of the query */
            ResultSet resultSet = statement.getResultSet();

            resultSet.next();
            if (resultSet.getInt(1) == 1) {
                if (ChangePassword.newPass.equals(ChangePassword.confirmPass)) {
                    if (statement.executeUpdate(
                            "UPDATE admins SET password ='" + ChangePassword.newPass + "' WHERE username ='"
                                    + Login.username + "' AND password ='" + Login.password + "';") > 0) {
                        resultQuery = true;
                    }
                }
            }

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultQuery;
    }

    // **updateProfile method
    public static boolean updateProfile(String query) {
        boolean resultQuery = false;

        getConnection();

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling executeUpdate() method */
            if(statement.executeUpdate(query) > 0){
                resultQuery = true;
            }

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultQuery;
    }

    // **getDataProfile method
    public static Object[] getDataProfile(String query, int lengthArray) {
        getConnection();

        Object rowData[] = new Object[lengthArray];

        try {
            // **create Statement object to allow execute a query */
            statement = connect.createStatement();

            // **execute query by calling execute() method */
            statement.execute(query);

            // **retrieve the result of the query */
            ResultSet resultSet = statement.getResultSet();

            if(lengthArray == 5){
            resultSet.next();
            rowData[0] = resultSet.getString("first_name");
            rowData[1] = resultSet.getString("last_name");
            rowData[2] = resultSet.getString("gender");
            rowData[3] = resultSet.getString("no_telephone");
            rowData[4] = resultSet.getString("email");
            }
            if(lengthArray == 2){
                resultSet.next();
                rowData[0] = resultSet.getString("first_name");
                rowData[1] = resultSet.getString("last_name");
            }

            // **close statement and connect */
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }


}