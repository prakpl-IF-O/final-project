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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Faza Abdi
 */
public class Pembayaran {

    private int lama, temp = 0;
    private String jenis, CI, CO;
    private double bayar_hari, bonus;
    private long hari, jam, menit;

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

    public void selisihDateTime(String nik, String co) throws ParseException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet rset = stmt.executeQuery("select CI from faza.DATAKAMAR where nik=" + nik);
            while (rset.next()) {
                CI = rset.getString("CI");
            }
            CO = co;
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date a = sdf.parse(CI);
            Date b = sdf.parse(CO);
            long selisihMS = Math.abs(b.getTime() - a.getTime());
            long selisihMenit = selisihMS / (60 * 1000) % 60;
            long selisihJam = selisihMS / (60 * 60 * 1000) % 24;
            long selisihHari = selisihMS / (24 * 60 * 60 * 1000);
            hari = selisihHari;
            jam = selisihJam;
            menit = selisihMenit;
        }
    }

    public long getHari() {
        return hari;
    }

    public long getJam() {
        return jam;
    }

    public long getMenit() {
        return menit;
    }

    public double bonus(String nik) throws SQLException {
        int total_inap[] = new int[1000];
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet rset = stmt.executeQuery("select lama from faza.DATAPELANGGAN where nik=" + nik);
            for (int i = 0; i < 1000; i++) {
                if (rset.next()) {
                    total_inap[i] = rset.getInt("lama");
                }
            }
            for (int i = 0; i < 1000; i++) {
                temp += total_inap[i];
            }
            if (temp < 10) {
                return bonus = 0;
            } else if (temp >= 10 && temp <= 30) {
                return bonus = bayar_hari * 10 / 100;
            } else if (temp > 30 && temp <= 60) {
                return bonus = bayar_hari * 15 / 100;
            } else {
                return bonus = bayar_hari * 25 / 100;
            }
        }
    }
}