package gui.project.akhir;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwiyan
 */
import java.sql.*;
import javax.swing.*;

public class ConnectionSql {

    Connection conn = null;
    public Connection conec;
    public Statement state;
    public ResultSet reset;

    public static Connection ConnectDBS() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kamar_hotel", "root", "");
            JOptionPane.showMessageDialog(null, conn);
            return conn;
        } catch (Exception e) {
            return null;
        }

    }

    public void Class() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conec = DriverManager.getConnection("jdbc:mysql://localhost/kamar_hotel", "root", "");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("DisC");
        }

    }

}
