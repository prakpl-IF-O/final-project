/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
public class pelanggan {
public int getjumlah(){
    int a=0;
    try { 
            String url = "jdbc:derby://localhost:1527/hotel"; 
            Connection conn = DriverManager.getConnection(url); 
            Statement st = conn.createStatement(); 
            ResultSet rs=st.executeQuery("SELECT * FROM pelanggan");
            while(rs.next()){
                a++;
            }
        } catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
    return a;
}
}
