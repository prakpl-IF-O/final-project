package Hotel;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class Pelanggan implements DB {

    private int id;
    private int nik;
    private String nama;
    private String tempatLahir;
    private Date tanggalLahir;
    private Date tanggalDaftar;
    private int akumulasi;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    public Pelanggan() {
    }

    public Pelanggan(int nik, String nama, String tempatLahir, String tanggalLahir) throws SQLException {
        this.nik = nik;
        this.nama = nama;
        this.tempatLahir = tempatLahir;

        try {
            this.tanggalLahir = sdf.parse(tanggalLahir);
        } catch (ParseException ex) {
        }
        this.tanggalDaftar = new Date();
        akumulasi = 0;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select max(id) from pelanggan");
        ResultSet rset = stmt.executeQuery(select);
        if (rset.next()) {
            id = rset.getInt(1) + 1;
        }
        savingData();
    }

    public int getId() {
        return id;
    }

    public int getNik() {
        return nik;
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

    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

    public int getAkumulasi() {
        return akumulasi;
    }

    public void setAkumulasi(int akumulasi) {
        this.akumulasi += akumulasi;

    }

    public String toString() {
        return String.format("%-21s: %d\n%-21s: %d\n%-21s: %s\n%-21s: %s, %s\n%-21s: %s\n%-21s: %d\n\n", "ID Pelanggan",
                id, "NIK", nik, "Nama", nama, "Tempat/Tanggal Lahir", tempatLahir, String.valueOf(sdf2.format(tanggalLahir)),
                "Tanggal Daftar", String.valueOf(sdf2.format(tanggalDaftar)), "Akumulasi", akumulasi);
    }

    public void savingData() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String id, nik, nama, tLahir, tglLahir, tglDaftar, akumulasi;
        id = String.valueOf(this.id);
        nik = String.valueOf(this.nik);
        nama = this.nama;
        tLahir = this.tempatLahir;
        tglLahir = String.valueOf(sdf.format(tanggalLahir));
        tglDaftar = String.valueOf(sdf.format(tanggalDaftar));
        akumulasi = String.valueOf(this.akumulasi);
        String insert = String.format("insert into pelanggan values (%s,%s,'%s','%s','%s','%s',%s)", id, nik, nama, tLahir, tglLahir, tglDaftar, akumulasi);
        stmt.executeUpdate(insert);
    }

    public void retrieveData(int id) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select * from pelanggan where id = %s", String.valueOf(id));
        ResultSet rset = stmt.executeQuery(select);
        while (rset.next()) {
            this.id = id;
            nik = rset.getInt("nik");
            nama = rset.getString("nama");
            tempatLahir = rset.getString("tempatlahir");
            tanggalLahir = rset.getDate("tglLahir");
            tanggalDaftar = rset.getDate("tglDaftar");
            akumulasi = rset.getInt("akumulasi");
        }
    }

    public void updateAkumulasi(int id, int update) throws SQLException {
        retrieveData(id);
        setAkumulasi(update);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String up = String.format("update pelanggan set akumulasi = %s where id = %s", String.valueOf(akumulasi), String.valueOf(this.id));
        stmt.executeUpdate(up);
    }

}
