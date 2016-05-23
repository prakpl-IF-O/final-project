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
public class Suite extends Kamar {

    private int nmrKmr;

    public Suite(String Jenis) {
        super(Jenis);
    }

    public String getNmrKmr() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet hasil = stmt.executeQuery("select nmrKmr from datakamar where nmrKmr > 70");
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
}
