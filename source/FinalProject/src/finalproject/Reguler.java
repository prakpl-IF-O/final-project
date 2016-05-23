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
public class Reguler extends Kamar {

    private int nmrKmr;

    public Reguler(String Jenis) {
        super(Jenis);
    }

    public String getNmrKmr() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select nmrKmr from datakamar where nmrKmr > 0");
            int[] r = new int[50];
            for (int i = 0; i < 50; i++) {
                if (hasil.next()) {
                    r[i] = hasil.getInt("nmrkmr");
                }
            }
            for (int i = 0; i < r.length - 1; i++) {
                for (int z = i + 1; z < r.length; z++) {
                    if (r[z] < r[i]) {
                        int temp;
                        temp = r[z];
                        r[z] = r[i];
                        r[i] = temp;
                    }
                }
            }
            for (int i = 0; i < r.length - 1; i++) {
                for (int z = i + 1; z < r.length; z++) {
                    if (r[i] == 0 || r[z] == 0) {
                        int temp;
                        temp = r[z];
                        r[z] = r[i];
                        r[i] = temp;
                    }
                }
            }
            for (int i = 1; i <= 50; i++) {
                if (r[i - 1] != 0) {
                    if (r[i - 1] != i) {
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
