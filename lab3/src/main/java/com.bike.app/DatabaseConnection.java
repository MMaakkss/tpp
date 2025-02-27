package com.bike.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:8080/postgres";
    
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
        	try {
        	    Class.forName("org.postgresql.Driver");
        	} catch (ClassNotFoundException e) {
        	    throw new SQLException("PostgreSQL JDBC Driver не знайден.", e);
        	}

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Помилка при підключенні до бази даних: " + e.getMessage());
        }
        return connection;
    }
}
