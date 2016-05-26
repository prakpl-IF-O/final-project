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
    
    public double getPendapatanAhir(){
        try {
            String h = "jdbc:derby://localhost:1527/hotel";
            Connection con = DriverManager.getConnection(h);
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM pendapatanakhir");
            rs.next();
            int x = rs.getInt(1);
            return x+super.getTotal();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return 0;
        }
    }
}
