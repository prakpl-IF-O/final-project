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
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Faza Abdi
 */
public class Check_In {

    private String NIK, LAMA;
    private String NAMA, TTL;

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public void setLAMA(String LAMA) {
        this.LAMA = LAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public void proses(String JENIS) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
                Statement stmt = conn.createStatement();) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String CI = sdf.format(cal.getTime());
            if (JENIS.equalsIgnoreCase("reguler")) {
                Reguler r = new Reguler("Reguler");
                if (!r.getNmrKmr().equalsIgnoreCase("0")) {
                    int inputD = stmt.executeUpdate("INSERT INTO datakamar VALUES (" + r.getNmrKmr() + ", '" + JENIS + "', " + r.getIdPelanggan() + ", " + NIK + ", '" + NAMA + "', '" + TTL + "', '" + CI + "', " + LAMA + ")");
                    int inputP = stmt.executeUpdate("INSERT INTO datapelanggan VALUES (" + NIK + ", '" + NAMA + "', '" + TTL + "', " + LAMA + ")");
                }
            } else if (JENIS.equalsIgnoreCase("premium")) {
                Premium p = new Premium("Premium");
                if (!p.getNmrKmr().equalsIgnoreCase("0")) {
                    int inputD = stmt.executeUpdate("INSERT INTO datakamar VALUES (" + p.getNmrKmr() + ", '" + JENIS + "', " + p.getIdPelanggan() + ", " + NIK + ", '" + NAMA + "', '" + TTL + "', '" + CI + "', " + LAMA + ")");
                    int inputP = stmt.executeUpdate("INSERT INTO datapelanggan VALUES (" + NIK + ", '" + NAMA + "', '" + TTL + "', " + LAMA + ")");
                }
            } else if (JENIS.equalsIgnoreCase("suite")) {
                Suite s = new Suite("Suite");
                if (!s.getNmrKmr().equalsIgnoreCase("0")) {
                    int inputD = stmt.executeUpdate("INSERT INTO datakamar VALUES (" + s.getNmrKmr() + ", '" + JENIS + "', " + s.getIdPelanggan() + ", " + NIK + ", '" + NAMA + "', '" + TTL + "', '" + CI + "', " + LAMA + ")");
                    int inputP = stmt.executeUpdate("INSERT INTO datapelanggan VALUES (" + NIK + ", '" + NAMA + "', '" + TTL + "', " + LAMA + ")");
                }
            } else if (JENIS.equalsIgnoreCase("vip")) {
                Vip v = new Vip("Vip");
                if (!v.getNmrKmr().equalsIgnoreCase("0")) {
                    int inputD = stmt.executeUpdate("INSERT INTO datakamar VALUES (" + v.getNmrKmr() + ", '" + JENIS + "', " + v.getIdPelanggan() + ", " + NIK + ", '" + NAMA + "', '" + TTL + "', '" + CI + "', " + LAMA + ")");
                    int inputP = stmt.executeUpdate("INSERT INTO datapelanggan VALUES (" + NIK + ", '" + NAMA + "', '" + TTL + "', " + LAMA + ")");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
