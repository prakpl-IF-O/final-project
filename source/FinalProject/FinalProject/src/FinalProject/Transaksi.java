/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

public class Transaksi extends Kamar {

    int hari, hargakamar, hargakamarR = 100000, hargakamarP = 200000, hargakamarS = 350000, hargakamarV = 750000;
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

    public void setcheckin(int a, int b, int c) {
        tglcheckin.setDate(a);
        tglcheckin.setMonth(b);
        tglcheckin.setYear(c);
    }

    public String getcheckin() {
        return String.format(tglcheckin.getDate() + "/" + tglcheckin.getMonth() + "/" + tglcheckin.getYear());
    }

    public void setcheckout(int a) {
        tglcheckout.setDate(tglcheckin.getDate() + a);
    }

    public String getcheckout() {
        return String.format(tampilcheckout.format(tglcheckout));
    }

    public int getHari() {
        return hari;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }

    public int getHarga() {
        return hargakamar;
    }

    public int getHargaR() {
        return hargakamarR;
    }

    public int getHargaP() {
        return hargakamarP;
    }

    public int getHargaS() {
        return hargakamarS;
    }

    public int getHargaV() {
        return hargakamarV;
    }

    public void setHarga(String a) {
        if ("Reguler".equals(a)) {
            hargakamar = 100000;
        } else if ("Premium".equals(a)) {
            hargakamar = 200000;
        } else if ("Suite".equals(a)) {
            hargakamar = 350000;
        } else if ("VIP".equals(a)) {
            hargakamar = 750000;
        }
    }

    public double getPembayaran() {
        Kamar kmr = new Kamar();
        if ((kmr.getJumlh() >= 0) && (kmr.getJumlh() <= 9)) {
            Pembayaran = hari * hargakamar;
        } else if ((kmr.getJumlh() > 9) && (kmr.getJumlh() <= 30)) {
            Pembayaran = hari * hargakamar * 0.9;
        } else if ((kmr.getJumlh() > 30) && (kmr.getJumlh() <= 60)) {
            Pembayaran = hari * hargakamar * 0.85;
        } else if (kmr.getJumlh() > 60) {
            Pembayaran = hari * hargakamar * 0.75;
        }
        return Pembayaran;
    }

    public void menu() {
        System.out.println("MENU : ");
        System.out.println("1.Daftar Kelas dan Harga kamar");
        System.out.println("2.Daftar Discount kelas kamar");
        System.out.println("3.Daftar kamar kosong");
        System.out.println("4.Transaksi pemesanan kamar");
        System.out.println("5.Cetak transaksi");
        System.out.println("6.Keluar ");
    }
}
