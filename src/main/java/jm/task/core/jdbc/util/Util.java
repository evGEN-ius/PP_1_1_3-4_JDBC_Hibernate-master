package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public final static String URL = "jdbc:mysql://localhost:3306/test";
    public final static String USER = "root";
    public final static String PASS = "admin";

    public static Connection getConnect() {
        Connection con;
        {
            try {
                con = DriverManager.getConnection(URL,USER,PASS);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

}
