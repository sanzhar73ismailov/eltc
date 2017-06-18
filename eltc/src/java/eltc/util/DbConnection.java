package eltc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String HOST = "localhost";
    private final static String PORT = "3306";
    private final static String USER = "root";
    private final static String PASSWORD = "";
    private final static String DB_NAME = "dbtemp";

    public static Connection getConnection() {
        return getConnection(DB_NAME);
    }

    public static Connection getConnection(String dbName) {
        Connection connection = null;

        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/",
                    HOST, PORT) + dbName, USER, PASSWORD);

            if (!connection.isClosed()) {
                //System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;

    }

    public static void main(String[] args) {
        //ResourceBundle rb = ResourceBundle.getBundle("")
   //     Properties p = new Properties();
     //   File f = new File("hibernate.properties");
       // System.out.println("f = " + f.getAbsolutePath());
        //p.load(new FileInputStream("hibernate.properties"));
        
        System.out.println(System.getProperties().getProperty("hibernate.dialect"));
        
    }
    public static void main1(String[] args) {
        Connection con = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from t1");
            while (rs.next()) {
                System.out.println("" + rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
