package com.leonardo.app.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        Connection con = null;

        int port = 3306;
        String host = "localhost";

        String dbName = "crud";
        String user = "root";
        String pass = "toor";

        String url = "jdbc:mariadb://"+host+":" + port + "/" + dbName + "?user=" + user + "&password=" + pass + "";

        try {
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Connection success");
            }
        } catch (SQLException ex) {
            System.out.println("Connection failed");
            ex.printStackTrace();
        }
        return con;
    }
}
