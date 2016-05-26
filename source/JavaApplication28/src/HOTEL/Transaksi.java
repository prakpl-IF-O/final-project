package HOTEL;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaksi implements Interface{
    
    String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";
    
    private String tanggalMasuk, JamMasuk, tanggalKeluar, JamKeluar;
    private int jumlahHari, nomorKamar;

    public Transaksi(String tanggalMasuk, String jamMasuk, String tanggalKeluar, String jamKeluar, int jumlahHari, int nomorKamar) {
        this.tanggalMasuk = tanggalMasuk;
        this.JamMasuk = jamMasuk;
        this.tanggalKeluar = tanggalKeluar;
        this.JamKeluar = jamKeluar;
        this.jumlahHari = jumlahHari;
        this.nomorKamar = nomorKamar;
    }
    
    @Override
    public void Input() {
        try (
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stm = con.createStatement();) {
        SimpleDateFormat convert1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat convert2 = new SimpleDateFormat("H:mm");
        java.util.Date tgl = new java.util.Date();
        String tglMasuk = convert1.format(tgl);
        String jamMasuk = convert2.format(tgl);
        Calendar cal = Calendar.getInstance();
        cal.setTime(tgl);
        cal.add(Calendar.DATE, jumlahHari);
        java.util.Date b = cal.getTime();
        String tglKeluar = convert1.format(b);
        String jamKeluar = convert2.format(b);
            
            String in = String.format("update DATABASE_INPUT set "
                    + "TGL_MASUK='%s', JAM_MASUK='%s', TGL_KELUAR='%s', JAM_KELUAR='%s', JUMLAH_HARI=%d where NO_KAMAR=%d", tglMasuk, jamMasuk, tglKeluar, jamKeluar, jumlahHari, nomorKamar);
            stm.executeUpdate(in);
            
            String input=String.format("update DATABASE_RUANGAN set STATUS='sedang dihuni' where NO_KAMAR=%d", nomorKamar);
            stm.executeUpdate(input);
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    }
    
}
