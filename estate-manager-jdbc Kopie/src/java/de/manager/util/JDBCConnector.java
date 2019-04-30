package de.manager.util;

import java.sql.Connection;

public interface JDBCConnector {

    Connection getConnection();
}
