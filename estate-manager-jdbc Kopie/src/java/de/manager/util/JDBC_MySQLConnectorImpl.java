package de.manager.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class JDBC_MySQLConnectorImpl implements JDBCConnector{

    String jdbcURL = "jdbc:mysql://localhost:3306/estate_manager?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    @Override
    public Connection getConnection() {
        try {
            Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
            return myConn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
