package logic;

import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/attendance_db", "admin", "admin");
            // Statement statement = connection.createStatement();
            // ResultSet resultSet = statement.executeQuery("select * from users");
            // while (resultSet.next()){
            //     System.out.println(resultSet.getString("username"));
            //     System.out.println(resultSet.getString("password"));
            // }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}