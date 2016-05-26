/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;// lokasi pada package finalproject

import java.sql.Connection; // mengimport class Connection dalam package java.sql
import java.sql.DriverManager; // mengimport class DriverManager dalam package java.sql
import java.sql.ResultSet; // mengimport class ResulSet dalam package java.sql
import java.sql.SQLException; // mengimport class SQLException dalam package java.sql
import java.sql.Statement; // mengimport class Statement dalam package java.sql
import java.text.SimpleDateFormat; // mengimport class SimpleDateFormat dalam package java.text
import java.util.Calendar; // mengimport class Calendar dalam package java.util

/**
 *
 * @author Faza Abdi
 */
public class Check_In {
    // Deklarasi variabel NIK, LAMA, NAMA, TTL, nmrKmr, id berupa String
    private String NIK, LAMA;
    private String NAMA, TTL;
    private String nmrKmr, id;

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
    
    // Method untuk menginputkan data check in kedalam database apabila kamar masih tersedia
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement
    // Deklarasi kelas Calendar dengan objek cal
    // Instansiasi kelas SimpleDateFormat dengan objek sdf dengan format parameter "dd-MM-yyyy HH:mm"
    // Mengambil tanggal saat method dieksekusi sesuai dengan format yang telah ditentukan kedalam variabel CI
    // Melakukan proses seleksi kondisi berdasarkan variabel JENIS, kemudian menginputkan data checkin kedalam database apabila kamar masih tersedia
    // Seluruh isi method tersebut berada didalam try catch untuk menangkap eksepsi atau kesalahan
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

    // Method untuk menampilkan ID yang digenerate secara otomatis
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement
    // Memasukkan statement berupa syntax SQL untuk mengambil data id berdasarkan NIK
    // Assignment data yang didapatkan dari database kedalam variabel id
    // Proses seleksi kondisi apakah id sama dengan null, apabila benar maka mengembalikan "ID Tidak Didapatkan" dan apabila salah maka mengembalikan 
    // nilai dari variabel id 
    
    public String getTampilID() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select id from datakamar where nik =" + NIK);
            while (hasil.next()) {
                id = hasil.getString("id");
            }
        }
        if (id == null) {
            return "ID Tidak Didapatkan";
        } else {
            return id;
        }
    }
    
    // Method untuk menampilkan nomor kamar yang digenerate secara otomatis
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement
    // Memasukkan statement berupa syntax SQL untuk mengambil data nomor kamar berdasarkan NIK
    // Assignment data yang didapatkan dari database kedalam variabel nmrKmr
    // Proses seleksi kondisi apakah nmrKmr sama dengan null, apabila benar maka mengembalikan "Kamar Penuh" dan apabila salah maka mengembalikan 
    // nilai dari variabel nmrKmr
    public String getTampilNmrKmr() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select nmrkmr from datakamar where nik =" + NIK);
            while (hasil.next()) {
                nmrKmr = hasil.getString("nmrkmr");
            }
        }
        if (nmrKmr == null) {
            return "Kamar Penuh";
        } else {
            return nmrKmr;
        }
    }
}
