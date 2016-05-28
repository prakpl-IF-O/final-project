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

// Deklarasi kelas dengan nama Suite yang merupakan sub class dari kelas Kamar
public class Suite extends Kamar {

    // Deklarasi variabel nmrKmr berupa integer
    // Deklarasi variabel harga sama dengan 350000 berupa double
    private int nmrKmr;
    private final double harga = 350000;

    // Constructor Suite dengan parameter Jenis
    // Memanggil constructor dari superclass
    public Suite(String Jenis) {
        super(Jenis);
    }

    // Method untuk mendapatkan nomor kamar secara otomatis
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement
    // Memasukkan statement berupa syntax SQL untuk mengambil data nomor kamar berdasarkan nmrKmr lebih dari 70 dan nmrKmr kurang dari 91
    // Perulangan pertama untuk mengambil data nomor kamar dari database kedalam array s[]
    // Perulangan kedua untuk mengurutkan array s[] dari data terkecil ke data terbesar
    // Perulangan ketiga untuk menempatkan data nomor kamar yang kosong dibawah data nmrKmr yang telah memiliki nilai
    // Perulangan keempat untuk mendapatkan nomor kamar apabila antar nomor kamar yang telah diurutkan memiliki kemungkinan untuk diisi dan 
    // untuk mendapatkan nomor kamar setelah nomor kamar yang telah urut
    // Mengembalikan nilai nmrKmr yang telah diparse kedalam String
    public String getNmrKmr() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select nmrKmr from datakamar where nmrKmr > 70 and nmrKmr < 91");
            int[] s = new int[20];
            for (int i = 0; i < 20; i++) {
                if (hasil.next()) {
                    s[i] = hasil.getInt("nmrkmr");
                }
            }
            for (int i = 0; i < s.length - 1; i++) {
                for (int z = i + 1; z < s.length; z++) {
                    if (s[z] < s[i]) {
                        int temp;
                        temp = s[z];
                        s[z] = s[i];
                        s[i] = temp;
                    }
                }
            }
            for (int i = 0; i < s.length - 1; i++) {
                for (int z = i + 1; z < s.length; z++) {
                    if (s[i] == 0 || s[z] == 0) {
                        int temp;
                        temp = s[z];
                        s[z] = s[i];
                        s[i] = temp;
                    }
                }
            }
            for (int i = 71; i <= 90; i++) {
                if (s[i - 71] != 0) {
                    if (s[i - 71] != i) {
                        nmrKmr = i;
                        break;
                    }
                } else {
                    nmrKmr = i;
                    break;
                }
            }
        }
        return String.valueOf(nmrKmr);
    }

    // Method yang mengimplementasikan method abstract dari kelas Kamar
    // Mengembalikan nilai dari variabel harga
    @Override
    public double getHarga() {
        return harga;
    }
}
