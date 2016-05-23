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
public class Vip extends Kamar {

    public Vip(String Jenis) {
        super(Jenis);
    }

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
}
