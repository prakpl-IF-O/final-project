package HOTEL;

import java.sql.*;

public class Cek {
    
    String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";
    
    /*
    * Method cekKamar dengan parameter noKamar
    * untuk mengecek status sebuah kamar
    * nomor kamar yang dimasukkan oleh user akan di cek ke dalam database
    * jika di dalam database nomor kamar tersebut tersedia, maka program 
    * akan memberikan informasi bahwa kamar yang diminta tersedia atau tidak tersedia
    */
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
    
    /*
    * Method cekVIP
    * untuk menampilkan jumlah kamar VIP yang tersedia 
    * berdasarkan data yang ada di dalam database
    */
    public int cekVIP() {
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
        return jumlah;
    }
    
    /*
    * Method cekSuite
    * untuk menampilkan jumlah kamar bertipe Suite yang tersedia
    * berdasarkan data yang ada di dalam database
    */
    public int cekSuite() {
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
        return jumlah;
    }
    /*
    * Method cekPremium
    * untuk menampilkan jumlah kamar bertipe Premium yang tersedia
    * berdasarkan data yang ada di dalam database
    */
    public int cekPremium() {
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
        return jumlah;
    }
        
    public int cekReguler() {
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
        return jumlah;
    }
}
