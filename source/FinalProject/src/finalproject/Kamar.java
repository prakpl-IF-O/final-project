/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Faza Abdi
 */
public abstract class Kamar {

    private String Jenis;
    private int idPelanggan;

    public Kamar(String Jenis) {
        this.Jenis = Jenis;
    }

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

    public abstract double getHarga();
}
