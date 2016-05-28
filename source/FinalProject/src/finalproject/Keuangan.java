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
public class Keuangan {

    // Deklarasi array of integer pendapatan yang memiliki jumlah indeks 1000
    // Deklarasi variabel temp bertipe data double dan diberi nilai sama dengan 0 
    private int pendapatan[] = new int[1000];
    private double temp = 0;

    // Method untuk mengecek pendapatan berdasarkan tanggal atau bulan atau tahun
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement
    // Memasukkan statement berupa syntax SQL untuk mengambil data pendapatan berdasarkan nilai dari variabel pil sama dengan nilai dari variabel tipe
    // Assignment data pendapatan ke dalam array pendapatan
    // Update nilai dari variabel k
    // Proses perulangan untuk menjumlahkan seluruh nilai pada array pendapatan[] kedalam variabel temp 
    public void cek_keuangan(String pil, String tipe) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet rset = stmt.executeQuery("select pendapatan from faza.DATAKEUANGAN where " + pil + "='" + tipe + "'");
            int k = 0;
            while (rset.next()) {
                pendapatan[k] = rset.getInt("pendapatan");
                k++;
            }
            
            ResultSet rs = stmt.executeQuery("select " + pil + " from faza.DATAKEUANGAN where " + pil + "='" + tipe + "'");
            int z = 0;
            while (rs.next()) {
                temp += pendapatan[z];
                z++;
            }
        }
    }

    public void setBackValue(double temp) {
        this.temp = temp;
    }

    // Method untuk mendapatkan total pendapatan
    // Mengembalikan nilai dari variabel temp
    public double getTotalPendapatan() {
        return temp;
    }
}
