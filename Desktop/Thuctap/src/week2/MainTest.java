package week2;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Test results = new Test();
        String url = "jdbc:mysql://localhost:3306/testCC";
        String userName = "root";
        String pass = "password";
        try {
            Connection connections = DriverManager.getConnection(url, userName, pass);
            if (connections != null) {
                results.getTest1(connections, "Viet Nam");
                results.getTest2(connections, "A");
                results.getTest3(connections);
                results.getTest4(connections, "A");
                results.getTest5(connections);
                results.getTest6(connections);
                connections.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}