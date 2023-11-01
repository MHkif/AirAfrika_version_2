package com.yc.airafrika_version_2.Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostrgreSQLDatabase implements Database {
    private static  final String Driver_PATH = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/airafrika";
    private static final String username = "postgres";
    private static final String password = "password770";
    private static Connection connection;
    private static DataSource dataSource;

    public PostrgreSQLDatabase() {}

    public synchronized Connection getConnection(){
        if (connection == null){
            try {
                Class.forName(Driver_PATH);
                connection = DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}