/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;
/*
deklarasi class dengan nama Transaksi yang mengextends Kamar
*/
public class Transaksi extends Kamar {

    int hari, hargakamar, hargakamarR = 100000, hargakamarP = 200000, hargakamarS = 350000, hargakamarV = 750000;
    double Pembayaran;
    String kodeTransaksi;
    java.util.Date skrng = new java.util.Date();
    java.text.SimpleDateFormat tampil = new java.text.SimpleDateFormat("dd/MM/yyyy");
    java.util.Date tglcheckin = new java.util.Date();
    java.util.Date tglcheckout = new java.util.Date();
    java.text.SimpleDateFormat tampilcheckout = new java.text.SimpleDateFormat("dd/MM/yyyy");

    /*
    menampilkan daftar menu
    */
    public void menu() {
        System.out.println("MENU : ");
        System.out.println("1.Daftar Kelas dan Harga kamar");
        System.out.println("2.Daftar Discount kelas kamar");
        System.out.println("3.Transaksi pemesanan kamar");
        System.out.println("4.Daftar kamar kosong");
        System.out.println("5.Mencetak transaksi");
        System.out.println("6.Keluar ");
    }

    /*
    menampilkan tanggal sekarang
    @return tanggal sekarangnya
    */
    public String gettgl() {
        return String.format(tampil.format(skrng));
    }

    /*
    menentukan kode Transaksi
    @parameter a merupakan kode Transaksinya
    */
    public void setkode(String a) {
        kodeTransaksi = a;
    }

    /*
    menampilkan harga kamar tiap jenis
    @return harga kamarnya
    */
    public int getHargakamar() {
        return hargakamar;
    }

    /*
    mengambil kode Transaksinya
    @return kode Transaksinya
    */
    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    /*
    menentukan tanggal check in pelanggan
    @parameter a,b,c disesuaikan format Date
    */
    public void setcheckin(int a, int b, int c) {
        tglcheckin.setDate(a);
        tglcheckin.setMonth(b);
        tglcheckin.setYear(c);
    }

    /*
    menampilkan tanggal check in pelanggan
    @return tanggal check in nya
    */
    public String getcheckin() {
        return String.format(tglcheckin.getDate() + "/" + tglcheckin.getMonth() + "/" + tglcheckin.getYear());
    }

    /*
    menentukan tanggal check out pelanggan
    @parameter a merupakan lama menginap pelanggan 
    */
    public void setcheckout(int a) {
        tglcheckout.setDate(tglcheckin.getDate() + a);
    }

    /*
    menampilkan tanggal check out pelanggan
    @return tanggal check out pelanggan
    */
    public String getcheckout() {
        return String.format(tampilcheckout.format(tglcheckout));
    }

    /*
    menampilkan lama menginap pelanggan
    @return lama menginapnya
    */
    public int getHari() {
        return hari;
    }

    /*
    menentukan lama menginap pelanggan
    @parameter hari merupakan lama menginap pelanggan
    */
    public void setHari(int hari) {
        this.hari = hari;
    }

    /*
    menampilkan harga kamar
    @return harga kamarnya
    */
    public int getHarga() {
        return hargakamar;
    }

    /*
    menampilkan harga kamar Reguler
    @return harga kamar Regulernya
    */
    public int getHargaR() {
        return hargakamarR;
    }

    /*
    menampilkan harga kamar Premium
    @return harga kamar Premiumnya
    */
    public int getHargaP() {
        return hargakamarP;
    }

    /*
    menampilkan harga kamar Suite
    @return harga kamar Suitenya
    */
    public int getHargaS() {
        return hargakamarS;
    }

    /*
    menampilkan harga kamar VIP
    @return harga kamar VIPnya
    */
    public int getHargaV() {
        return hargakamarV;
    }

    /*
    menentukan harga kamar
    @parameter a merupakan jenis kamarnya
    */
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

    /*
    menghitung harga yang harus dibayar
    @return total pembayarannya 
    */
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
}
