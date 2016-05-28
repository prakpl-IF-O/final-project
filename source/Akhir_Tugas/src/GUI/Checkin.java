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

public class Checkin {

    kamarhotel kh = new kamarhotel();
    double bayar;
    double denda = 30000;
    double kembali;
    static double total;
    byte lamasewa;

    /**
     *
     * Method getBayar()
     *
     * @return nilai bayar
     */
    public double getBayar() {
        return bayar;
    }

    /**
     * Method setBayar()
     *
     * @param bayar Mengeset nilai bayar
     */
    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    /**
     * Method getDenda()
     *
     * @return denda
     */
    public double getDenda() {
        return denda;
    }

    /**
     * Method setDenda()
     *
     * @param denda Mengeset nilai denda
     */
    public void setDenda(int denda) {
        this.denda = denda;
    }

    /**
     * Method getKembali()
     *
     * @return kembali
     */
    public double getKembali() {
        return kembali;
    }

    /**
     * Method getTotal()
     *
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Method getDiskon()
     *
     * @param a
     * @param c
     * @return diskon
     */
    public double getDiskon(byte a, String c) {
        String h = "jdbc:derby://localhost:1527/hotel";
        try {
            Connection con = DriverManager.getConnection(h);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pelanggan WHERE ID = '" + c + "'");
            // Hasil didapat dari ID pelanggan
            rs.next();
            // Memberi nilai variabel b
            int b = rs.getInt(3);
            // Mengembalikan nilai berikut jika jumlah kedua variabel lebih dari 60
            if (b + a > 60) {
                return 0.25;
            }
            // Mengembalikan nilai berikut jika jumlah kedua variabel lebih dari 30
            if (b + a > 30) {
                return 0.15;
            }
            // Mengembalikan nilai berikut jika jumlah kedua variabel lebih dari 9
            if (b + a > 9) {
                return 0.1;
            } 
            // Mengembalikan nilai berikut jika kondisi yang terjadi tidak mencakup kondisi diatas
            else {
                return 0;
            }
        } catch (SQLException ex) {
            // Menampilkan pesan error Massage
            System.out.println(ex.getMessage());
            // Mengembalikan nilai jika nilai variabel a lebih dari 60
            if (a > 60) {
                return 0.25;
            } // Mengembalikan nilai jika nilai variabel a lebih dari 30
            if (a > 30) {
                return 0.15;
            } // Mengembalikan nilai jika nilai variabel a lebih dari 9
            if (a > 9) {
                return 0.1;
            } // Mengembalikan nilai berikut jika kondisi yang terjadi tidak mencakup kondisi diatas 
            else {
                return 0;
            }
        }
    }
}
