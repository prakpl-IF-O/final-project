/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Faza Abdi
 */
public class Pembayaran {

    private int lama;
    private String jenis;
    private double bayar_hari;

    public void bayar_hari(String nik) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet bayar = stmt.executeQuery("select lama, jenis from faza.DATAKAMAR where nik=" + nik);
            while (bayar.next()) {
                lama = bayar.getInt("lama");
                jenis = bayar.getString("jenis");
            }
            if (jenis.equalsIgnoreCase("reguler")) {
                Reguler r = new Reguler("reguler");
                bayar_hari = lama * r.getHarga();
            } else if (jenis.equalsIgnoreCase("premium")) {
                Premium p = new Premium("premium");
                bayar_hari = lama * p.getHarga();
            } else if (jenis.equalsIgnoreCase("suite")) {
                Suite s = new Suite("suite");
                bayar_hari = lama * s.getHarga();
            } else if (jenis.equalsIgnoreCase("vip")) {
                Vip v = new Vip("vip");
                bayar_hari = lama * v.getHarga();
            }
        }
    }

    public double getBayar_hari() {
        return bayar_hari;
    }
}
