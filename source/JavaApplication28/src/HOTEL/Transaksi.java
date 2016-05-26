package HOTEL;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Transaksi implements Interface {

    String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";

    private String tanggalMasuk, JamMasuk, tanggalKeluar, JamKeluar,checkIn,checkOut,jenisKamar,diskon="0%";
    private int jumlahHari, nomorKamar,NIK;
    private String namaD,namaB, nama, id,TTL;
    private double totalBayar, denda;

    public Transaksi(int jumlahHari, int nomorKamar) {
        this.jumlahHari = jumlahHari;
        this.nomorKamar = nomorKamar;
    }
    public Transaksi(){
    
    }
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
    
    public double hitungBayar(String id, String TglKeluar, String JamKeluar, double sewa) throws ParseException {
        int jumlahHariInap = 0, jumlahHariAkumulasi = 0;
        String tglKeluar, jamKeluar;
        try (
                Connection con = DriverManager.getConnection(host, uName, uPass);
                Statement stm = con.createStatement();) {
            String carii = String.format("SELECT* FROM DATABASE_INPUT where ID='%s'", id);
            ResultSet get = stm.executeQuery(carii);
            while (get.next()) {
                int jumHar = get.getInt("JUMLAH_HARI");
                nomorKamar = get.getInt("NO_KAMAR");
                this.id=get.getString("ID");
                NIK=get.getInt("NIK");
                namaD=get.getString("NAMAD");
                namaB=get.getString("NAMAB");
                nama=namaD+" "+namaB;
                tanggalMasuk=get.getString("TGL_MASUK");
                JamMasuk=get.getString("JAM_MASUK");
                checkIn=tanggalMasuk+" "+JamMasuk;
                jumlahHari=get.getInt("JUMLAH_HARI");
                checkOut=TglKeluar+" "+JamKeluar;
                TTL=get.getString("TTL");
                jumlahHariInap = jumHar;
            }
            
            String cari = String.format("SELECT* FROM DATABASE_TRANSAKSI where ID='%s'", id);
            ResultSet gett = stm.executeQuery(cari);
            while (gett.next()) {
                int jumHar = gett.getInt("JUMLAH_HARI");
                jumlahHariAkumulasi += jumHar;
            }
            
            totalBayar=sewa*jumlahHariInap;
            if (jumlahHariAkumulasi+jumlahHariInap>=10&&jumlahHariAkumulasi+jumlahHariInap<=30) {
                totalBayar=sewa*jumlahHariInap*0.9;
                diskon="10%";
            }
            else if (jumlahHariAkumulasi+jumlahHariInap>=31&&jumlahHariAkumulasi+jumlahHariInap<=60) {
                totalBayar=sewa*jumlahHariInap*0.85;
                diskon="15%";
            }
            else if (jumlahHariAkumulasi+jumlahHariInap>=61){
                totalBayar=sewa*jumlahHariInap*0.75;
                diskon="25%";
            }
            denda =denda(nomorKamar, TglKeluar, JamKeluar);
            totalBayar+=denda;
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
        return totalBayar;
    }
    
    public double denda(int kamar, String tglKeluar, String jamKeluar) throws ParseException{
        String TglKeluar=null, JamKeluar=null;
        try (
                Connection con = DriverManager.getConnection(host, uName, uPass);
                Statement stm = con.createStatement();) {
            String cari = String.format("SELECT* FROM DATABASE_INPUT where NO_KAMAR=%d", kamar);
            ResultSet get = stm.executeQuery(cari);
            while (get.next()) {
                TglKeluar = get.getString("TGL_KELUAR");
                JamKeluar = get.getString("JAM_KELUAR");
            }
            SimpleDateFormat convert= new SimpleDateFormat("dd-MM-yyyy H:mm");
            String a=String.format(TglKeluar+" "+JamKeluar);
            String b=String.format(tglKeluar+" "+jamKeluar);
            
            java.util.Date temp1=convert.parse(a);
            java.util.Date temp2=convert.parse(b);
            
            if (temp2.compareTo(temp1)<=0) {
                denda=0;
            }
            else {
                long selisih=temp1.getTime()-temp2.getTime();
                double temp = TimeUnit.MILLISECONDS.toHours(selisih)*30000;
                denda = Math.abs(temp);
            }
        }
        catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    return denda;
    }
    
    public String toString(){
    return String.format("nama: %s\nTTL: %s\nid: %s\nNIK: %d\ncheck in: %s\ncheckOut: %s\nlama menginap: %s\nnomor kamar: %s\n"
            + "denda: %.0f\ndiskon: %s\ntotal tagihan: %.0f\n",
            nama,TTL,id,NIK,checkIn,checkOut,jumlahHari,nomorKamar,denda,diskon,totalBayar);
    }
}
