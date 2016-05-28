/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Irfandi
 */

/**
 * MENGHITUNG LAPORAN BULANAN
 * 
 * @author Andy Wiranto
 */
public class LaporanBulanan {

    DateAndTime dt = new DateAndTime();

    private String BULAN_TRANSAKSI;
    private int JUMLAH_TRANSAKSI;
    private int PENDAPATAN_BULANAN;

    // KONSTRUKTOR CLASS LaporanBulanan
    public LaporanBulanan(String bulan_transaksi, String jumlah_transaksi, String pendapatan_bulanan) {
        this.BULAN_TRANSAKSI = bulan_transaksi;
        this.JUMLAH_TRANSAKSI = Integer.parseInt(jumlah_transaksi);
        this.PENDAPATAN_BULANAN = Integer.parseInt(pendapatan_bulanan);
    }
/**format bulan
 * pengkonversian bulan
 * @return bulan_
 */
    public String STRING_BULAN() {
        int bulan = Integer.parseInt(BULAN_TRANSAKSI.substring(0, 2));
        String bulan_ = dt.CONVERT_INDEX_OF_MONTH(bulan - 1);
        return bulan_;
    }
/**
 * format tahun
 * pengkonversian bulan transaksi ke tahun
 * @return tahun
 */
    public String GET_TAHUN() {
        String tahun = BULAN_TRANSAKSI.substring(3);
        return tahun;
    }
/**
 * MENAMBAHKAN TRANSAKSI DAN PENDAPATAN BULANAN
 * @param JUMLAH_TRANS
 * @param PENDAPATAN 
 */
    public void TAMBAH_TRANSAKSI(int JUMLAH_TRANS, int PENDAPATAN) {
        JUMLAH_TRANSAKSI += JUMLAH_TRANS;
        PENDAPATAN_BULANAN += PENDAPATAN;
    }

    /**MENDAPATKAN BULAN TRANSAKSI
     * @return the BULAN_TRANSAKSI
     */
    public String GET_BULAN_TRANSAKSI() {
        return BULAN_TRANSAKSI;
    }

    /**MENDAPATKAN JUMLAH TRANSAKSI
     * @return the JUMLAH_TRANSAKSI
     */
    public int GET_JUMLAH_TRANSAKSI() {
        return JUMLAH_TRANSAKSI;
    }

    /**MENDAPATKAN PENDAPATAN BULANAN
     * @return the PENDAPATAN_BULANAN
     */
    public int GET_PENDAPATAN_BULANAN() {
        return PENDAPATAN_BULANAN;
    }

}
