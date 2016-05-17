/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.ParseException;

/**
 *
 * @author Irfandi
 */
public class TamuEngine {

    private static Tamu DATABASE[];
    private static int DB_SIZE;
    Database db = new Database();
    UserEngine ue = new UserEngine();
    KamarEngine kamar = new KamarEngine();
    
    public TamuEngine() {
        try {
            INIT_DB();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void TAMBAH_TAMU(String ID,String NIK,String NAMA,String TEMPAT_LAHIR,
                        String TANGGAL_LAHIR,String TANGGAL_DAFTAR,String AKUMULASI, 
                        String NO_KAMAR,String TGL_CHECK_IN,String TGL_CHECK_OUT){
        ue.DESTROY_DUPLICATE(ID);
        try {
            DATABASE[DB_SIZE] = new Tamu(ID, NIK, NAMA, TEMPAT_LAHIR,
                    TANGGAL_LAHIR, TANGGAL_DAFTAR, AKUMULASI,
                    NO_KAMAR, TGL_CHECK_IN, TGL_CHECK_OUT);
            DB_SIZE++;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        kamar.PESAN_KAMAR(NO_KAMAR);
    }
    public void INIT_DB() throws Exception {
        db.READ_DATABASE("tamu", "database\\Tamu.database");
        DATABASE = db.GET_DB_TAMU();
        DB_SIZE = db.GET_DB_SIZE();
        for (int i = 0; i < DB_SIZE; i++) {
            kamar.PESAN_KAMAR(DATABASE[i].GET_NOMOR_KAMAR());
        }
    }

    public int GET_JUMLAH_TAMU() {
        return Tamu.GET_JUMLAH_TAMU();
    }
}
