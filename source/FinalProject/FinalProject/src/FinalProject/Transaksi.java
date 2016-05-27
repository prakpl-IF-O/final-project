/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

public class Transaksi extends Kamar {

    int hari, hargakamar;
    double Pembayaran;
    String kodeTransaksi;
    java.util.Date skrng = new java.util.Date();
    java.text.SimpleDateFormat tampil = new java.text.SimpleDateFormat("dd/MM/yyyy");
    java.util.Date tglcheckin = new java.util.Date();
    java.util.Date tglcheckout = new java.util.Date();
    java.text.SimpleDateFormat tampilcheckout = new java.text.SimpleDateFormat("dd/MM/yyyy");

    public String gettgl() {
        return String.format(tampil.format(skrng));
    }

    public void setkode(String a) {
        kodeTransaksi = a;
    }

    public int getHargakamar() {
        return hargakamar;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }
}
