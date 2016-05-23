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
public class Premium extends Kamar {

    private int nmrKmr;

    public Premium(String Jenis) {
        super(Jenis);
    }

    public String getNmrKmr() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select nmrKmr from datakamar where nmrKmr > 50");
            int[] p = new int[20];
            for (int i = 0; i < 20; i++) {
                if (hasil.next()) {
                    p[i] = hasil.getInt("nmrkmr");
                }
            }
            for (int i = 0; i < p.length - 1; i++) {
                for (int z = i + 1; z < p.length; z++) {
                    if (p[z] < p[i]) {
                        int temp;
                        temp = p[z];
                        p[z] = p[i];
                        p[i] = temp;
                    }
                }
            }
            for (int i = 0; i < p.length - 1; i++) {
                for (int z = i + 1; z < p.length; z++) {
                    if (p[i] == 0 || p[z] == 0) {
                        int temp;
                        temp = p[z];
                        p[z] = p[i];
                        p[i] = temp;
                    }
                }
            }
            for (int i = 51; i <= 70; i++) {
                if (p[i - 51] != 0) {
                    if (p[i - 51] != i) {
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
