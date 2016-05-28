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

// Deklarasi kelas dengan nama Vip yang merupakan sub class dari kelas Kamar
public class Vip extends Kamar {

    // Deklarasi variabel nmrKmr berupa integer
    // Deklarasi variabel harga sama dengan 750000 berupa double
    private int nmrKmr;
    private final double harga = 750000;

    // Constructor Vip dengan parameter Jenis
    // Memanggil constructor dari superclass 
    public Vip(String Jenis) {
        super(Jenis);
    }

    // Method untuk mendapatkan nomor kamar secara otomatis
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement
    // Memasukkan statement berupa syntax SQL untuk mengambil data nomor kamar berdasarkan nmrKmr lebih dari 90
    // Perulangan pertama untuk mengambil data nomor kamar dari database kedalam array v[]
    // Perulangan kedua untuk mengurutkan array v[] dari data terkecil ke data terbesar
    // Perulangan ketiga untuk menempatkan data nomor kamar yang kosong dibawah data nmrKmr yang telah memiliki nilai
    // Perulangan keempat untuk mendapatkan nomor kamar apabila antar nomor kamar yang telah diurutkan memiliki kemungkinan untuk diisi dan 
    // untuk mendapatkan nomor kamar setelah nomor kamar yang telah urut
    // Mengembalikan nilai nmrKmr yang telah diparse kedalam String
    public String getNmrKmr() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select nmrKmr from datakamar where nmrKmr > 90");
            int[] v = new int[10];
            for (int i = 0; i < 10; i++) {
                if (hasil.next()) {
                    v[i] = hasil.getInt("nmrkmr");
                }
            }
            for (int i = 0; i < v.length - 1; i++) {
                for (int z = i + 1; z < v.length; z++) {
                    if (v[z] < v[i]) {
                        int temp;
                        temp = v[z];
                        v[z] = v[i];
                        v[i] = temp;
                    }
                }
            }
            for (int i = 0; i < v.length - 1; i++) {
                for (int z = i + 1; z < v.length; z++) {
                    if (v[i] == 0 || v[z] == 0) {
                        int temp;
                        temp = v[z];
                        v[z] = v[i];
                        v[i] = temp;
                    }
                }
            }
            for (int i = 91; i <= 100; i++) {
                if (v[i - 91] != 0) {
                    if (v[i - 91] != i) {
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
