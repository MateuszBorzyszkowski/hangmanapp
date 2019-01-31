package com.mateusz.client;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class SqlClientDB {

    private static Connection connection;

    public static Connection getConnection() {
//        try {
//            Class.forName("org.sqlite.JDBC");
//            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Mateusz/Desktop/pwilogin.db");
//            connection.setAutoCommit(false);
//            System.out.println("Opened database successfully");
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Operation done successfully");


        InputStream inputStream = SqlClientDB.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection toBeClosed) {
        if (toBeClosed == null) return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

