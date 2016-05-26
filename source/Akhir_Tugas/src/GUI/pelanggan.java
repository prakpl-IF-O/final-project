/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
public class pelanggan {
    String id_tamu,
            nama,ttl,tgldaftar,thari;
    int a;
public void tambahtamu() { 
        try { 
            String url = "jdbc:derby://localhost:1527/hotel"; 
            Connection conn = DriverManager.getConnection(url); 
            Statement st = conn.createStatement(); 
            st.executeUpdate("INSERT INTO pelanggan " + 
                "VALUES ('"+id_tamu+"', '"+nama+"', '"+ttl+"', '"+tgldaftar+"', '"+thari+"')");
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
  
    }
    public String getId_tamu() {
        return id_tamu;
    }

    public void setId_tamu(String id_tamu) {
        this.id_tamu = id_tamu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getTgldaftar() {
        return tgldaftar;
    }

    public void setTgldaftar(String tgldaftar) {
        this.tgldaftar = tgldaftar;
    }

    public String getThari() {
        return thari;
    }

    public void setThari(String thari) {
        this.thari += thari;
    }
}
