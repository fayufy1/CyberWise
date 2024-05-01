package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Utility class for managing database connections.
 */
public class DBUtils {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/javafx-video";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "fayaaz2004";
    /**
     * Gets a connection to the database.
     * @return A Connection object representing the database connection.
     * @throws SQLException If a database access error occurs or the URL is null.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
