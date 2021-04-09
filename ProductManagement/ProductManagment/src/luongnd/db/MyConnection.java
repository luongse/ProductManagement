/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luongnd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class MyConnection {
      public static Connection getConnection() throws ClassNotFoundException, SQLException{
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:2311; database=ItemManagement;";
            Connection con= DriverManager.getConnection(url, "sa", "23112015");
            return con;
        } catch (Exception e) {
            System.out.println("Connection faile.");
            e.printStackTrace();
        }
        return null;
    }
}
