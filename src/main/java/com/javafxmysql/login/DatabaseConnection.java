package com.javafxmysql.login;

import java.sql.Connection;
import java.sql.DriverManager;

// Class with one of several ways to connect java app to db

public class DatabaseConnection {

    public Connection dbLink;

    public Connection getConnection() {
        String dbName = ""; // Enter mysql database name
        String dbUser = ""; // Enter your mysql database connection root or other user
        String dbPassword = ""; // Enter your mysql database connection
        String url = "jdbc:mysql://localhost:3306/" + dbName; // Eventually change if remote db

        try { // If driver exist and OK...
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect with above credentials..
            dbLink = DriverManager.getConnection(url, dbUser, dbPassword);

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return dbLink; // Return Connection dbLink
    }


}
