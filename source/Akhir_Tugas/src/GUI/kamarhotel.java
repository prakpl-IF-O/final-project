/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Husein
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class kamarhotel {

    private int nk;
    private int har;
    private String k;
    private boolean stat;

    public void db() {
        try {
            String h = "jdbc:derby://localhost:1527/hotel";
            Connection con = DriverManager.getConnection(h);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM kamar";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                k = rs.getString(1);
                nk = rs.getInt(2);
                stat = rs.getBoolean(3);
                har = rs.getInt(4);
                if (stat) {
                    System.out.println(k + " " + nk + " " + har + " terisi");
                } else {
                    System.out.println(k + " " + nk + " " + har + " kosong");
                }
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public int getNk() {
        return nk;
    }

    public int getHar() {
        return har;
    }

    public String getK() {
        return k;
    }

    public boolean isStat() {
        return stat;
    }

}
