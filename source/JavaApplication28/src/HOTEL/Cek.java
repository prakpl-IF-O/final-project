package HOTEL;

import java.sql.*;

public class Cek {
    
    String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";
    //method untuk mengecek ketersediaan kamar
    public boolean cekKamar(int noKamar) {
        boolean cek = false;
        try (
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stm = con.createStatement();) {
            String cari = "SELECT*FROM DATABASE_RUANGAN";
            ResultSet Cari = stm.executeQuery(cari);
            while (Cari.next()) {
                int noKam = Cari.getInt("NO_KAMAR");
                String JenKam = Cari.getString("JENIS_KAMAR");
                String Status = Cari.getString("STATUS");
                if ((noKam==noKamar)&&Status.equalsIgnoreCase("tersedia")) {
                    cek = true;
                }
            }
            
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
        return cek;
    }
    
    //method untuk mengecek jumlah ketersediaan kamar VIP
    public String cekVIP() {
        int jumlah=0;
        try (
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stm = con.createStatement();) {
            String cari = "SELECT*FROM DATABASE_RUANGAN";
            ResultSet Cari = stm.executeQuery(cari);
            while (Cari.next()) {
                int noKam = Cari.getInt("NO_KAMAR");
                String JenKam = Cari.getString("JENIS_KAMAR");
                String Status = Cari.getString("STATUS");
                if ((noKam>=1&&noKam<=10)&&Status.equalsIgnoreCase("tersedia")) {
                    jumlah++;
                }
            }
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
        return String.format("Tersedia %d Kamar", jumlah);
    }
    
    //method untuk mengecek jumlah ketersediaan kamar suite
    public String cekSuite() {
        int jumlah=0;
        try (
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stm = con.createStatement();) {
            String cari = "SELECT*FROM DATABASE_RUANGAN";
            ResultSet Cari = stm.executeQuery(cari);
            while (Cari.next()) {
                int noKam = Cari.getInt("NO_KAMAR");
                String JenKam = Cari.getString("JENIS_KAMAR");
                String Status = Cari.getString("STATUS");
                if ((noKam>=11&&noKam<=30)&&Status.equalsIgnoreCase("tersedia")) {
                    jumlah++;
                }
            }
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
        return String.format("Tersedia %d Kamar", jumlah);
    }
      
    //method untuk mengecek jumlah ketersediaan kamar premium
    public String cekPremium() {
        int jumlah=0;
        try (
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stm = con.createStatement();) {
            String cari = "SELECT*FROM DATABASE_RUANGAN";
            ResultSet Cari = stm.executeQuery(cari);
            while (Cari.next()) {
                int noKam = Cari.getInt("NO_KAMAR");
                String JenKam = Cari.getString("JENIS_KAMAR");
                String Status = Cari.getString("STATUS");
                if ((noKam>=31&&noKam<=50)&&Status.equalsIgnoreCase("tersedia")) {
                    jumlah++;
                }
            }
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
        return String.format("Tersedia %d Kamar", jumlah);
    }
        
    //method untuk mengecek jumlah ketersediaan kamar Reguler
    public String cekReguler() {
        int jumlah=0;
        try (
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stm = con.createStatement();) {
            String cari = "SELECT*FROM DATABASE_RUANGAN";
            ResultSet Cari = stm.executeQuery(cari);
            while (Cari.next()) {
                int noKam = Cari.getInt("NO_KAMAR");
                String JenKam = Cari.getString("JENIS_KAMAR");
                String Status = Cari.getString("STATUS");
                if ((noKam>=51&&noKam<=100)&&Status.equalsIgnoreCase("tersedia")) {
                    jumlah++;
                }
            }
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
        return String.format("Tersedia %d Kamar", jumlah);
    }
}
