package gui.project.akhir;

import java.util.Date;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Pengunjung {

    private String NIK;
    private String noKamar;
    private String nama;
    private String tempatLahir;
    private Date tanggalLahir;
    private Date tanggalTerdaftar;
    private String IDPelanggan;
    private String in;
    private String lamaInap;

    public Pengunjung() {
    }

    public Pengunjung(String noKamar, String IDPelanggang, String nama, String NIK,
            String tempatLahir, Date tanggalLahir, String lamaInap, Date tanggalTerdaftar, String in) {
        this.NIK = NIK;
        this.noKamar = noKamar;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.tanggalTerdaftar = tanggalTerdaftar;
        this.IDPelanggan = IDPelanggan;
        this.in = in;
        this.lamaInap = lamaInap;
    }

    public String getNIK() {
        return NIK;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public String getNama() {
        return nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public Date getTanggalTerdaftar() {
        return tanggalTerdaftar;
    }

    public String getIDPelanggan() {
        return IDPelanggan;
    }

    public String getIn() {
        return in;
    }

    public String getLamaInap() {
        return lamaInap;
    }

    public void simpanData() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = ConnectionSql.ConnectDBS();
        try {
            String sql = "insert into data_pengunjung (Kamar, Nama, NIK, TempatLahir, TanggalLahir,ID, LamaInap, CheckIn, JamIn) values (?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, noKamar);
            ps.setString(2, nama);
            ps.setString(3, NIK);
            ps.setString(4, tempatLahir);
            ps.setDate(5, new java.sql.Date(tanggalLahir.getTime()));
            ps.setString(6, this.IDPelanggan);
            ps.setString(7, this.lamaInap);
            ps.setDate(8, new java.sql.Date(tanggalTerdaftar.getTime()));
            ps.setString(9, in);
            ps.execute();
        } catch (Exception ex) {

        }
    }
}
