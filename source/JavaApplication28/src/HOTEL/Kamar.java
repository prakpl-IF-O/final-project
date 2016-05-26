package HOTEL;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Kamar {
    private double totalBayar, denda, sewa;
    private String jenisKamar,diskon="0%";

    String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";
    
    public Kamar(String jenisKamar, double sewa) {
        this.jenisKamar = jenisKamar;
        this.sewa = sewa;
    }
    
    public Kamar(){
    }
    
    public double hitungBayar(String id, String TglKeluar, String JamKeluar) throws ParseException {
        int jumlahHariInap = 0, jumlahHariAkumulasi = 0,noKam=0;
        String tglKeluar, jamKeluar;
        try (
                Connection con = DriverManager.getConnection(host, uName, uPass);
                Statement stm = con.createStatement();) {
            String carii = String.format("SELECT* FROM DATABASE_INPUT where ID='%s'", id);
            ResultSet get = stm.executeQuery(carii);
            while (get.next()) {
                int jumHar = get.getInt("JUMLAH_HARI");
                noKam = get.getInt("NO_KAMAR");
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
            denda =denda(noKam, TglKeluar, JamKeluar);
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
            
            Date temp1=convert.parse(a);
            Date temp2=convert.parse(b);
            
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
    return String.format("jenis kamar : %s\nharga (malam): %.0f\ndenda: %.0f\ndiskon: %s\ntotal tagihan: %.0f\n",
            jenisKamar,sewa,denda,diskon,totalBayar);
    }
}
