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
    
    public String getJenisKamar(){
    return jenisKamar;
    }
    
    public double Sewa(){
    return sewa;
    }
    
    public Kamar(){
    }
    
    public String toString(){
    return String.format("jenis kamar : %s\nharga (malam): %.0f\ndenda: %.0f\ndiskon: %s\ntotal tagihan: %.0f\n",
            jenisKamar,sewa,denda,diskon,totalBayar);
    }
}
