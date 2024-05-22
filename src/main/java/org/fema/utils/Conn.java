package org.fema.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static Connection cnn;

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        if (cnn == null) {
            Class.forName(ConnContants.DRIVE);
            cnn = DriverManager.getConnection(ConnContants.URL,
                    ConnContants.USER, ConnContants.PASSWORD);
        }
        return cnn;
    }
}
