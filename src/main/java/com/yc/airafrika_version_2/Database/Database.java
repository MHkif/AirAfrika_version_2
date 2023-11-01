package com.yc.airafrika_version_2.Database;

import java.sql.Connection;

public interface Database{

    public Connection getConnection();

    public void closeConnection();
}