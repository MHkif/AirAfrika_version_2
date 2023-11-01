package com.yc.airafrika_version_2.Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase implements Database {

    private static  final String Driver_PATH = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3303/{Db_name}";
    private static final String username = "root";
    private static final String password = "root";
    private static Connection connection;
    private static DataSource dataSource;

    private MySQLDatabase() {}

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