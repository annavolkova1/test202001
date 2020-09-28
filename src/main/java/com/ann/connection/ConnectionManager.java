package com.ann.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    FileInputStream fis;
    Properties property = new Properties();

    public ConnectionManager() throws IOException {
        fis = new FileInputStream("src/main/resources/application.properties");
        property.load(fis);
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(property.getProperty("spring.datasource.url"));
        return connection;
    }

}
