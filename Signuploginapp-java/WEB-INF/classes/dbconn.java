// package myapp.db;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class dbconn {
    final static String dbDriver = "com.mysql.cj.jdbc.Driver";
    final static String dbURL = "jdbc:mysql://localhost:3306/";

    static String dbName = "logregjava";
    static String dbUsername = "root";
    static String dbPassword = "Mehar@2762";

    static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (Exception e) {
            conn = null;
        } finally {
            return conn;
        }

    }
}
