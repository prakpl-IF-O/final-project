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
public class Keuangan {

    private int pendapatan[] = new int[1000];
    private double temp = 0;

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
            for (int i = 0; i < 1000; i++) {
                temp += pendapatan[i];
            }
        }
    }

    public double getTotalPendapatan() {
        return temp;
    }
}
