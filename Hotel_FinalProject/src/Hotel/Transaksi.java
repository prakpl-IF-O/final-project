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
    private double denda;
    private static int count;   
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Transaksi(){
        tamu = new Pelanggan();
        kamar = new Kamar();
        checkIn = Calendar.getInstance();
        batasCheckOut = Calendar.getInstance();
    }
    public Transaksi(int hari, Pelanggan tamu, Kamar kamar) throws SQLException {
        this.tamu = tamu;
        this.kamar = kamar;
        checkIn = Calendar.getInstance();
        batasCheckOut = Calendar.getInstance();
        batasCheckOut.add(Calendar.DATE, hari);
        totalHarga = hari;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select max(kode) from transaksi");
        ResultSet rset = stmt.executeQuery(select);
        if (rset.next()) {
            kodeTransaksi = rset.getInt(1) + 1;
        }
        savingData();
    }

    private void checkDenda() {
        checkOut = Calendar.getInstance();
        long selisih = checkOut.getTimeInMillis() - batasCheckOut.getTimeInMillis();
        long jam = TimeUnit.MILLISECONDS.toHours(selisih);
        if (jam > 0) {
            denda = jam * 30000;
        } else {
            denda = 0;
        }

    }

    public String toString() {
        return String.format("%d\n%s\n%s\n", kodeTransaksi, String.valueOf(sdf.format(checkIn.getTime())), String.valueOf(sdf.format(batasCheckOut.getTime())));
    }

    public void savingData() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String kode = String.valueOf(kodeTransaksi);
        String id = String.valueOf(tamu.getId());
        String tanggalMasuk = String.valueOf(sdf.format(checkIn.getTime()));
        String nomorKamar = String.valueOf(kamar.getNoKamar());
        String batasOut = String.valueOf(sdf.format(batasCheckOut.getTime()));
        String insert1 = String.format("insert into transaksi values (%s,%s,'%s')", kode, id, tanggalMasuk);
        String insert2 = String.format("insert into detailTransaksi(kodeTransaksi,idPelanggan,nomorKamar,checkIn,batas) values(%s,%s,%s,'%s','%s')",
                kode, id, nomorKamar, tanggalMasuk, batasOut);
        stmt.executeUpdate(insert1);
        stmt.executeUpdate(insert2);
    }

    public void CheckOut() throws SQLException {
        checkDenda();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        totalHarga = (totalHarga * kamar.getHarga()) + denda;
        String tanggalKeluar = String.valueOf(sdf.format(checkOut.getTime()));
        String update = String.format("update detailTransaksi set checkOut = '%s', total = %s where kodeTransaksi = %s", tanggalKeluar, totalHarga, kodeTransaksi);
        stmt.executeUpdate(update);
    }

    public void retrieveData(int id) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select * from detailTransaksi where kodeTransaksi = %s", id);
        ResultSet rset = stmt.executeQuery(select);
        int ID=0,nomor=0;
        while (rset.next()) {
            kodeTransaksi = rset.getInt("kodeTransaksi");
            ID = rset.getInt("idPelanggan");
            nomor = rset.getInt("nomorKamar");
            checkIn.setTime(rset.getTimestamp("checkIn"));
            batasCheckOut.setTime(rset.getTimestamp("batas"));
        }
        long selisih = batasCheckOut.getTimeInMillis() - checkIn.getTimeInMillis();
        long hari = TimeUnit.MILLISECONDS.toDays(selisih);
        totalHarga = hari; 
        kamar.retrieveData(nomor);
        tamu.retrieveData(ID);
    }

}
