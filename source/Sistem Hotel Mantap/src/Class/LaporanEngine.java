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
 * untuk mengatur laporanBulanan
 * @author Andy Wiranto
 */
public class LaporanEngine {

    DateAndTime dt = new DateAndTime();

    private static LaporanBulanan DATABASE[];
    private static int DB_SIZE;
    Database db = new Database();

    // konstraktor LaporanEngine
    // inisialisasi LaporanEngine
    public LaporanEngine() {
        try {
            INIT_DB();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
// inisialisasi database laporan
    public void INIT_DB() throws Exception {
        db.READ_DATABASE("laporan", "database\\Laporan.database");
        DATABASE = db.GET_DB_LAPORAN();
        DB_SIZE = db.GET_DB_SIZE();
    }
// menambahkan transaksi
    public void TAMBAH_TRANSAKSI(int jumlah_trans, int pendapatan) {
        String BULAN_INI = dt.GET_CURRENT_DATE("M/Y");
        System.out.println("method tambah trans " + BULAN_INI);
        int index = FIND_INDEX_BY_BULAN(BULAN_INI);
        System.out.println("indexnya : " + index);
        DATABASE[index].TAMBAH_TRANSAKSI(jumlah_trans, pendapatan);
        System.out.println("sudah ditambah");
    }
//mencari index berdasarkan bulan
    public int FIND_INDEX_BY_BULAN(String bulan) {
        for (int i = 0; i < DB_SIZE; i++) {
            if (DATABASE[i].GET_BULAN_TRANSAKSI().equals(bulan)) {
                return i;
            }
        }
        //kalau gak ada, buat
        DATABASE[DB_SIZE] = new LaporanBulanan(bulan, "0", "0");
        DB_SIZE++;
        return DB_SIZE - 1;
    }
// mengembalikan nilai bulan berdasarkan index
    public String GET_STRING_BULAN_BY_INDEX(int index) {
        return DATABASE[index].STRING_BULAN();
    }
// mengembalikan nilai tahun berdasarkan index
    public String GET_TAHUN_BY_INDEX(int index) {
        return DATABASE[index].GET_TAHUN();
    }
// mengembalikan nilai total pendapatan berdasarkan index
    public int GET_TOTAL_PENDAPATAN_BY_INDEX(int index) {
        return DATABASE[index].GET_PENDAPATAN_BULANAN();
    }
// mengembalikan nilai jumlah transaksi berdasarkan index
    public int GET_JUMLAH_TRANSAKSI_BY_INDEX(int index) {
        return DATABASE[index].GET_JUMLAH_TRANSAKSI();
    }
//mengembalikan nilai jumlah database
    public int GET_JUMLAH_DB() {
        return DB_SIZE;
    }
//update master database laporan
    public void UPDATE_MASTER_DATABASE() {
        db.WRITE_DATABASE_LAPORAN(DATABASE, DB_SIZE);
    }
}
