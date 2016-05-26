package gui.project.akhir;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwiyan
 */
import java.sql.*;

public class DataKamar {

    public static void main(String[] args) throws SQLException {
        Koneksi koneksi = new Koneksi();
        koneksi.Class();
        Kamar kamar;
        koneksi.state = koneksi.conec.createStatement();
        String sql = "Insert into data_kamar (NoKamar,KelasKamar,Harga,Status) values(?,?,?,?)";
        PreparedStatement prepared = (com.mysql.jdbc.PreparedStatement) koneksi.conec.prepareStatement(sql);
        try {
            for (int no = 1; no < 51; no++) {
                kamar = new RegulerKamar(no, "Reguler", 100000, "Kosong");
                prepared.setInt(1, kamar.getNo());
                prepared.setString(2, kamar.getKelas());
                prepared.setInt(3, kamar.getHarga());
                prepared.setString(4, kamar.getStatus());
                prepared.executeUpdate();
            }
            for (int no = 51; no < 71; no++) {
                kamar = new PremiumKamar(no, "Premium", 200000, "Kosong");
                prepared.setInt(1, kamar.getNo());
                prepared.setString(2, kamar.getKelas());
                prepared.setInt(3, kamar.getHarga());
                prepared.setString(4, kamar.getStatus());
                prepared.executeUpdate();
            }
            for (int no = 71; no < 91; no++) {
                kamar = new SuiteKamar(no, "Suite", 350000, "Kosong");
                prepared.setInt(1, kamar.getNo());
                prepared.setString(2, kamar.getKelas());
                prepared.setInt(3, kamar.getHarga());
                prepared.setString(4, kamar.getStatus());
                prepared.executeUpdate();
            }
            for (int no = 91; no < 101; no++) {

                kamar = new VIPKamar(no, "VIP", 750000, "Kosong");
                prepared.setInt(1, kamar.getNo());
                prepared.setString(2, kamar.getKelas());
                prepared.setInt(3, kamar.getHarga());
                prepared.setString(4, kamar.getStatus());
                prepared.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
