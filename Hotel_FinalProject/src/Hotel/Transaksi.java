package Hotel;

import java.util.Calendar;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Transaksi implements DB {

    private int kodeTransaksi;
    Pelanggan tamu;
    Kamar kamar;
    private Calendar checkIn;
    private Calendar batasCheckOut;
    private Calendar checkOut;
    private double totalHarga;
    private static int count;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Transaksi(int hari,Pelanggan tamu, Kamar kamar) {
        kodeTransaksi = ++count;
        this.tamu = tamu;
        this.kamar = kamar;
        checkIn = Calendar.getInstance();
        batasCheckOut = Calendar.getInstance();
        batasCheckOut.add(Calendar.DATE, hari);
    }

    private double checkDenda() {
        double a = 0;
        checkOut = Calendar.getInstance();
        long selisih = checkOut.getTimeInMillis() - batasCheckOut.getTimeInMillis();
        long jam = TimeUnit.MILLISECONDS.toHours(selisih);
        if (jam > 0) {
            a = jam * 30000;
        }
        return a;
    }

    public void savingData() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String kode = String.valueOf(kodeTransaksi);
        String id = String.valueOf(tamu.getId());
        String tanggalMasuk = String.valueOf(sdf.format(checkIn.getTime()));
        String nomorKamar = String.valueOf(kamar.getNoKamar());
        String batasOut = String.valueOf(sdf.format(batasCheckOut.getTime()));
        String insert1 = String.format("insert into transaksi values (%s,%s,'%s')", kode,id,tanggalMasuk);
        String insert2 = String.format("insert into detailTransaksi(kodeTransaksi,idPelanggan,nomorKamar,checkIn,batas) values(%s,%s,%s,'%s','%s')", 
                kode,id,nomorKamar,tanggalMasuk,batasOut);
        stmt.executeUpdate(insert1);
        stmt.executeUpdate(insert2);
    }

    public void CheckOut() {

    }

    public void retrieveData(int id) throws SQLException {

    }

}
