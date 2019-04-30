package de.manager.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class JDBC_DB2ConnectorImpl implements JDBCConnector{

    // instance of Driver Manager
    private static JDBC_DB2ConnectorImpl _instance = null;

    // DB2 connection
    private Connection _con;

    /**
     * Erzeugt eine Datenbank-Verbindung
     */
    private JDBC_DB2ConnectorImpl() {
        try {
            String jdbcUser = "vsisp12";
            String jdbcPass = "h9QE2Vxc";
            String jdbcUrl = "jdbc:db2://vsisls4.informatik.uni-hamburg.de:50001/VSISP";

            // Verbindung zur DB2 herstellen
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            _con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Liefert eine Verbindung zur DB2 zurueck
     *
     * @return Connection
     */
    public Connection getConnection() {
        return _con;
    }
}
