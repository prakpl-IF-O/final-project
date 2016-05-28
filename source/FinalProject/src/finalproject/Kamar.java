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

// Berupa class abstract 
public abstract class Kamar {

    // Deklarasi variabel Jenis berupa String
    // Deklarasi variabel idPelanggan berupa integer
    private String Jenis;
    private int idPelanggan;

    // Constructor Kamar dengan parameter Jenis
    // Assignment variabel local Jenis kedalam variabel Jenis
    public Kamar(String Jenis) {
        this.Jenis = Jenis;
    }

    // Method untuk menggenerate id secara otomatis
    // Memasukkan syntax untuk mengakses data base
    // Deklarasi statement
    // Memasukkan statement berupa syntax SQL untuk mengambil data id berdasarkan data id yang lebih dari 0
    // Perulangan pertama untuk mengambil data id dari database kedalam array id[]
    // Perulangan kedua untuk mengurutkan array id[] dari data terkecil ke data terbesar
    // Perulangan ketiga untuk menempatkan data id yang kosong dibawah data id yang telah memiliki nilai
    // Perulangan keempat untuk mendapatkan id apabila antar id yang telah diurutkan memiliki kemungkinan untuk diisi
    // Perulangan kelima untuk mendapatkan id setelah id yang telah urut
    // Mengembalikan nilai idPelanggan yang telah diparse kedalam String
    public String getIdPelanggan() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select id from datakamar where id > 0");
            int[] id = new int[100];
            for (int i = 0; i < 100; i++) {
                if (hasil.next()) {
                    id[i] = hasil.getInt("id");
                }
            }
            for (int i = 0; i < id.length - 1; i++) {
                for (int z = i + 1; z < id.length; z++) {
                    if (id[z] < id[i]) {
                        int temp;
                        temp = id[z];
                        id[z] = id[i];
                        id[i] = temp;
                    }
                }
            }
            for (int i = 0; i < id.length - 1; i++) {
                for (int z = i + 1; z < id.length; z++) {
                    if (id[i] == 0 || id[z] == 0) {
                        int temp;
                        temp = id[z];
                        id[z] = id[i];
                        id[i] = temp;
                    }
                }
            }
            for (int i = 0; i < 100; i++) {
                if (id[i] != 0) {
                    if (id[i] != i) {
                        idPelanggan = i;
                        break;
                    }
                } else {
                    idPelanggan = i;
                    break;
                }
            }
            for (int i = 0; i < 100; i++) {
                if (id[i] != i + 1) {
                    idPelanggan = i + 1;
                    break;
                }
            }
        }
        return String.valueOf(idPelanggan);
    }

    // Method yang belum diimplementasikan untuk mendapatkan Harga 
    public abstract double getHarga();
}
