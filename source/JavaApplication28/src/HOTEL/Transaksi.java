package HOTEL;

import java.sql.*;

public class Transaksi {
    
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
}
