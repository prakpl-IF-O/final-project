package HOTEL;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaksi implements Interface {

    String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";

    private String tanggalMasuk, JamMasuk, tanggalKeluar, JamKeluar;
    private int jumlahHari, nomorKamar;

/*
* Method konstruktor Transaksi
* dengan parameter tanggalMasuk, jamMasuk, tanggalKeluar, jamKeluar, jumlahHari dan nomorKamar
*/
    public Transaksi(String tanggalMasuk, String jamMasuk, String tanggalKeluar, String jamKeluar, int jumlahHari, int nomorKamar) {
        this.tanggalMasuk = tanggalMasuk;
        this.JamMasuk = jamMasuk;
        this.tanggalKeluar = tanggalKeluar;
        this.JamKeluar = jamKeluar;
        this.jumlahHari = jumlahHari;
        this.nomorKamar = nomorKamar;
    }

/*
* Method override Input
* 
*/
    @Override
    public void Input() {
        try (
                Connection con = DriverManager.getConnection(host, uName, uPass);
                Statement stm = con.createStatement();) {
            SimpleDateFormat convert1 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat convert2 = new SimpleDateFormat("H:mm");
            java.util.Date tgl = new java.util.Date();
            String tglMasuk = convert1.format(tgl);
            String jamMasuk = convert2.format(tgl);
            Calendar cal = Calendar.getInstance();
            cal.setTime(tgl);
            cal.add(Calendar.DATE, jumlahHari);
            java.util.Date b = cal.getTime();
            String tglKeluar = convert1.format(b);
            String jamKeluar = convert2.format(b);

            String in = String.format("update DATABASE_INPUT set "
                    + "TGL_MASUK='%s', JAM_MASUK='%s', TGL_KELUAR='%s', JAM_KELUAR='%s', JUMLAH_HARI=%d where NO_KAMAR=%d", tglMasuk, jamMasuk, tglKeluar, jamKeluar, jumlahHari, nomorKamar);
            stm.executeUpdate(in);

            String input = String.format("update DATABASE_RUANGAN set STATUS='sedang dihuni' where NO_KAMAR=%d", nomorKamar);
            stm.executeUpdate(input);
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    }

/*
* Method clear dengan parameter kamar
* untuk merubah atau mengupdate database status kamar.
* jika user telah melakukan check out, maka secara otomatis database mengubah status kamar tersebut menjadi tersedia
*/
    public void clear(int kamar) {
        try (
                Connection con = DriverManager.getConnection(host, uName, uPass);
                Statement stm = con.createStatement();) {
            String in = String.format("update DATABASE_INPUT set "
                    + "NAMAD=null, NAMAB=null, TTL=null, ID=null, NIK=0, "
                    + "TGL_MASUK=null, JAM_MASUK=null, TGL_KELUAR=null, JAM_KELUAR=null, JUMLAH_HARI=0 where NO_KAMAR=%d", kamar);
            stm.executeUpdate(in);
            String input = String.format("update DATABASE_RUANGAN set STATUS='tersedia' where NO_KAMAR=%d", kamar);
            stm.executeUpdate(input);
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    }

/*
* Method saveToLaporan dengan parameter kamar, totalBayar dan denda
* untuk menyimpan segala transaksi yang terjadi ke dalam database
*/
    public void saveToLaporan(int kamar, double totalBayar, double denda) {
        String namaD = null, namaB = null, tglMasuk = null, jamMasuk = null, tglKeluar = null, jamKeluar = null, ID = null;
        int NIK = 0, jumlahHari = 0;
        try (
                Connection con = DriverManager.getConnection(host, uName, uPass);
                Statement stm = con.createStatement();) {
            String search = String.format("SELECT* FROM DATABASE_INPUT where NO_KAMAR=%d", kamar);
            ResultSet ss = stm.executeQuery(search);
            while (ss.next()) {
                namaD = ss.getString("NAMAD");
                namaB = ss.getString("NAMAB");
                tglMasuk = ss.getString("TGL_MASUK");
                jamMasuk = ss.getString("JAM_MASUK");
                tglKeluar = ss.getString("TGL_KELUAR");
                jamKeluar = ss.getString("JAM_KELUAR");
                ID = ss.getString("ID");
                NIK = ss.getInt("NIK");
                jumlahHari = ss.getInt("JUMLAH_HARI");
            }
            String in = String.format("insert into DATABASE_TRANSAKSI values ('%s',%d,'%s','%s','%s','%s','%s','%s',%d,%f,%f,%d)",
                    ID, NIK, namaD, namaB, tglMasuk, jamMasuk, tglKeluar, jamKeluar, jumlahHari, denda, totalBayar, kamar);
            stm.executeUpdate(in);
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    }

/*
* Method generate dengan parameter bulan
* untuk mendapatkan laporan transaksi selama satu bulan
*/
    public double generate(String bulan) {
        double totalBayar=0;
        try (
                Connection con = DriverManager.getConnection(host, uName, uPass);
                Statement stm = con.createStatement();) {
            String cari = "SELECT* FROM DATABASE_TRANSAKSI";
            ResultSet gett = stm.executeQuery(cari);
            while (gett.next()) {
                String tglKeluar = gett.getString("TGL_KELUAR");
                double temp=gett.getDouble("TOTAL_BAYAR");
                String [] a= tglKeluar.split("-");
                if (a[1].equalsIgnoreCase(bulan)) {
                    totalBayar+=temp;
                }
            }
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
        return totalBayar;
    }
}
