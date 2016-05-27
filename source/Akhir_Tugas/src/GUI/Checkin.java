/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Husein
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Checkin{
    kamarhotel kh=new kamarhotel();
    double bayar;
    double denda = 30000;
    double kembali;
    static double total;
    byte lamasewa;
    
    public double getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public double getKembali() {
        return kembali;
    }

    public double getTotal() {
        return total;
    }

    public double getDiskon(byte a,String c) {
        String h = "jdbc:derby://localhost:1527/hotel";
        try {
            Connection con = DriverManager.getConnection(h);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pelanggan WHERE ID = '"+c+"'");
            rs.next();
            int b=rs.getInt(3);
        if (b+a > 60) {
            return 0.25;
        }
        if (b+a > 30) {
            return 0.15;
        }
        if (b+a > 9) {
            return 0.1;
        }else{
        return 0;
        }
    }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        if (a > 60) {
            return 0.25;
        }
        if (a > 30) {
            return 0.15;
        }
        if (a > 9) {
            return 0.1;
        }else{
        return 0;
        }
    }
    }

}
