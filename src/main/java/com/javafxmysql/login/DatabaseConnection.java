package com.javafxmysql.login;

import java.sql.Connection;
import java.sql.DriverManager;

// Class with one of several ways to connect java app to db

public class DatabaseConnection {

    public Connection dbLink;

    public Connection getConnection() {
        String dbName = "education"; // Currently only local on my computer
        String dbUser = "osho81";
        String dbPassword = "temporary123";
        String url = "jdbc:mysql://localhost:3306/" + dbName;

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
