package HOTEL;
public class Transaksi {
    private String tanggalMasuk, JamMasuk, tanggalKeluar, JamKeluar;
    private int jumlahHari, nomorKamar;

    public Transaksi(String tanggalMasuk, String jamMasuk, String tanggalKeluar, String jamKeluar, int jumlahHari, int nomorKamar) {
        this.tanggalMasuk = tanggalMasuk;
        this.JamMasuk = jamMasuk;
        this.tanggalKeluar = tanggalKeluar;
        this.JamKeluar = jamKeluar;
        this.jumlahHari = jumlahHari;
        this.nomorKamar = nomorKamar;
    }
}
