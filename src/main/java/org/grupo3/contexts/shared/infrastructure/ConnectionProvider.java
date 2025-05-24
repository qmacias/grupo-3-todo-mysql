package org.grupo3.contexts.shared.infrastructure;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
    private static String url;
    private static String user;
    private static String password;
    private static String className;
    private static Connection connection;

    static {
        Properties properties = new Properties();
        try {
            properties.load(ConnectionProvider.class.getResourceAsStream("/env.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        className = properties.getProperty("className");
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }

        if (connection == null) {
            connection = DriverManager.getConnection(url, user, password);
        }

        return connection;
    }

}
