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
public class Cek_Data {

    private String idd;
    private String nmrKmr, jenis, id, nik, nama, ttl, ci, lama;

    public Cek_Data(String idd) {
        this.idd = idd;
    }

    public void pilah_data() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "faza", "aaaaa");
        Statement stmt = conn.createStatement();
        {
            ResultSet rset = stmt.executeQuery("select * from faza.datakamar where id=" + idd);
            while (rset.next()) {
                this.nmrKmr = rset.getString("nmrKmr");
                this.jenis = rset.getString("jenis");
                this.id = rset.getString("id");
                this.nik = rset.getString("nik");
                this.nama = rset.getString("nama");
                this.ttl = rset.getString("ttl");
                this.ci = rset.getString("ci");
                this.lama = rset.getString("lama");

            }
        }
    }

}
