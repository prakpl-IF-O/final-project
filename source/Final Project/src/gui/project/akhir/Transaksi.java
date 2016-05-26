package gui.project.akhir;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dwiyan
 */
public class Transaksi extends Pengunjung {
    
    private String status;
    private String JamOut;
    private String out;
    private int tagihan;
    
    public Transaksi(String status, String JamOut, String out, int tagihan) {
        this.status = status;
        this.JamOut = JamOut;
        this.out = out;
        this.tagihan = tagihan;
    }
    
    public Transaksi() {
    }
    
    public double diskonKamar(int lamaInap) {
        if (lamaInap > 61) {
            return 0.25;
        } else if (lamaInap > 31) {
            return 0.15;
        } else if (lamaInap > 10) {
            return 0.1;
        } else {
            return 0;
        }
    }
    
    public String dayOut(int lamaInap, String in) {
        String out[] = in.split("-");
        int year = Integer.parseInt(out[0]);
        int month = Integer.parseInt(out[1]);
        int day = Integer.parseInt(out[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        c.add(Calendar.DATE, lamaInap);
        String output = sdf.format(c.getTime());
        return output;
    }
    
    public int dendaHotel(String in, String out) {
        int ni = Integer.parseInt(in);
        int tou = Integer.parseInt(out);
        if (ni > tou) {
            return 0;
        } else {
            return ((tou - ni) / 100) * 30000;
        }
    }
    
    public double hargaTotal(int no, int lamaInap) {
        if (no >= 91) {
            return 750000 * lamaInap - (750000 * lamaInap * diskonKamar(lamaInap));
        } else if (no >= 71) {
            return 350000 * lamaInap - (350000 * lamaInap * diskonKamar(lamaInap));
        } else if (no >= 51) {
            return 200000 * lamaInap - (200000 * lamaInap * diskonKamar(lamaInap));
        } else {
            return 100000 * lamaInap - (100000 * lamaInap * diskonKamar(lamaInap));
        }
    }
    
    public void simpanData2() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = ConnectionSql.ConnectDBS();
        
        String sql3 = "insert data_transaksi (ID,JamOut,CheckOut,Status,Tagihan) values (?,?,?,?,?)";
        ps = conn.prepareStatement(sql3);
        ps.setString(1, getIDPelanggan());
        ps.setString(2, JamOut);
        ps.setString(3, out);
        ps.setString(4, "Out");
        ps.setString(5, String.valueOf(tagihan));
        ps.execute();
        
    }
    
}
