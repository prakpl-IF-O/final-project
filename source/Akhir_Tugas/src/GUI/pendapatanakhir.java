/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Husein
 */
public class pendapatanakhir extends Checkin{
    
    /**
     * Mengembalikan nilai Pendapatan Akhir
     * 
     * @return nilai Pendapatan Akhir
     */
    public double getPendapatanAhir(){
        try {
            String h = "jdbc:derby://localhost:1527/hotel";
            Connection con = DriverManager.getConnection(h);
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs;
            // Hasil yang didapat dari pendapatanakhir
            rs = st.executeQuery("SELECT * FROM pendapatanakhir");
            rs.next();
            // Menghitung nilai x
            int x = rs.getInt(1);
            // Mengembalikan nilai pendapatanakhir
            rs.updateInt(1, (int) (x+super.getTotal()));
            rs.updateRow();
            return x+super.getTotal();
        } catch (SQLException err) {
            // Jika terjadi error maka akan mencetak objek err pada method getMessage()
            System.out.println(err.getMessage());
            // Mengembalikan nilai pendapatanakhir
            return 0;
        }
    }
}
