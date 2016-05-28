/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject; // lokasi pada package finalproject

import java.sql.Connection; // mengimport class Connection dalam package java.sql
import java.sql.DriverManager; // mengimport class DriverManager dalam package java.sql
import java.sql.ResultSet; // mengimport class ResulSet dalam package java.sql
import java.sql.SQLException; // mengimport class SQLException dalam package java.sql
import java.sql.Statement; // mengimport class Statement dalam package java.sql

/**
 *
 * @author Faza Abdi
 */
public class Cek_Data {

    //Deklarasi variabel idd , nmrKmr, jenis, id, nik, nama, ttl, ci, lama berupa String
    private String idd;
    private String nmrKmr, jenis, id, nik, nama, ttl, ci, lama;

    // Deklarasi Constructor dengan parameter idd
    // Assignment variable local idd kedalam variabel idd
    public Cek_Data(String idd) {
        this.idd = idd;
    }

    // Method untuk memberikan nilai kedalam variabel yang telah dibuat
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement 
    // Memasukkan statement berupa syntax SQL untuk mengambil seluruh data berdasarkan id
    // Assignment data yang diperoleh dari data base kedalam variabel-variabel yang telah dibuat
    public void pilah_data() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet rset = stmt.executeQuery("select * from faza.datakamar where id=" + idd);
            while (rset.next()) {
                this.nmrKmr = rset.getString("nmrKmr");
                this.jenis = rset.getString("jenis");
                this.id = rset.getString("id");
                this.nik = rset.getString("nik");
                this.nama = rset.getString("nama");
                this.ttl = rset.getString("ttl");
                this.ci = rset.getString("ci");
                this.lama = rset.getString("lama");

            }
        }
    }

    public String getNmrKmr() {
        return this.nmrKmr;
    }

    public String getJenis() {
        return this.jenis;
    }

    public String getId() {
        return this.id;
    }

    public String getNik() {
        return this.nik;
    }

    public String getNama() {
        return this.nama;
    }

    public String getTtl() {
        return this.ttl;
    }

    public String getCi() {
        return this.ci;
    }

    public String getLama() {
        return this.lama;
    }
}
