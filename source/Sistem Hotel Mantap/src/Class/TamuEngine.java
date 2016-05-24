/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.nio.file.attribute.AclEntryPermission;
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

    public int scan_ID(String ID) {
        for (int i = 0; i < DB_SIZE; i++) {
            if (DATABASE[i].GET_ID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public String GET_ID_BY_INDEX(int index){
        return DATABASE[index].GET_ID();
    }
    
    public String GET_NIK_BY_INDEX(int index){
        return DATABASE[index].GET_NIK();
    }
    
    public String GET_NAMA_BY_INDEX(int index){
        return DATABASE[index].GET_NAMA();
    }
    
    public String GET_KAMAR_BY_INDEX(int index){
        return DATABASE[index].GET_NOMOR_KAMAR();
    }
    public int GET_AKUMULASI_BY_INDEX(int index){
        return DATABASE[index].GET_AKUMULASI();
    }
    public String GET_STRING_CHECK_IN_BY_INDEX(int index){
        return DATABASE[index].STRING_CHECK_IN();
    }
    public int GET_JAM_CHECK_IN_BY_INDEX(int index){
        return DATABASE[index].GET_JAM_CHECK_IN();
    }
    public String GET_STRING_CHECK_OUT_BY_INDEX(int index){
        return DATABASE[index].STRING_CHECK_OUT();
    }
    public int GET_LAMA_INAP_BY_INDEX (int index){
        return DATABASE[index].GET_LAMA_INAP();
    }
    public String GET_DISKON_BY_INDEX(int index){
        if (DATABASE[index].GET_AKUMULASI()<9){
            return "0 %";
        } else  if (DATABASE[index].GET_AKUMULASI()<=30){
            return "10 %";
        } else  if (DATABASE[index].GET_AKUMULASI()<=60){
            return "15 %";
        } else {
            return "25 %";
        }
    }
    public void TAMBAH_TAMU(String ID,String NIK,String NAMA,String TEMPAT_LAHIR,
                        String TANGGAL_LAHIR,String TANGGAL_DAFTAR,String AKUMULASI, 
                        String NO_KAMAR,String TGL_CHECK_IN,String TGL_CHECK_OUT, int jam_check_in){
        ue.DELETE_PELANGGAN(ID);
        try {
            DATABASE[DB_SIZE] = new Tamu(ID, NIK, NAMA, TEMPAT_LAHIR,
                    TANGGAL_LAHIR, TANGGAL_DAFTAR, AKUMULASI,
                    NO_KAMAR, TGL_CHECK_IN, TGL_CHECK_OUT, jam_check_in);
            DB_SIZE++;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        kamar.PESAN_KAMAR(NO_KAMAR);
    }
    public void CHECK_OUT (String ID){
        int index = FIND_TAMU_INDEX(ID);
        
        ue.TAMBAH_PELANGGAN(DATABASE[index].GET_ID(), DATABASE[index].GET_NIK(),
                DATABASE[index].GET_NAMA(), DATABASE[index].GET_TEMPAT_LAHIR(),
                DATABASE[index].STRING_TANGGAL_LAHIR(), DATABASE[index].STRING_TANGGAL_DAFTAR(),
                Integer.toString(DATABASE[index].GET_AKUMULASI()));
        DELETE_TAMU(ID);
    }
    
    public int FIND_TAMU_INDEX(String ID){
        int index = -1;
        for (int i = 0; i < DB_SIZE; i++) {
            if (DATABASE[i].GET_ID().equalsIgnoreCase(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void DELETE_TAMU(String ID){
        int index = FIND_TAMU_INDEX(ID);

        if (index >= 0) {
            for (int i = index; i < (DB_SIZE - 1); i++) {
                DATABASE[i].SET_ID(DATABASE[i + 1].GET_ID());
                DATABASE[i].SET_NIK(DATABASE[i + 1].GET_NIK());
                DATABASE[i].SET_NAMA(DATABASE[i + 1].GET_NAMA());
                DATABASE[i].SET_TEMPAT_LAHIR(DATABASE[i + 1].GET_TEMPAT_LAHIR());
                DATABASE[i].SET_TANGGAL_LAHIR(DATABASE[i + 1].GET_TANGGAL_LAHIR());
                DATABASE[i].SET_TANGGAL_DAFTAR(DATABASE[i + 1].GET_TANGGAL_DAFTAR());
                DATABASE[i].SET_AKUMULASI(DATABASE[i + 1].GET_AKUMULASI());
                DATABASE[i].SET_NOMOR_KAMAR(DATABASE[i + 1].GET_NOMOR_KAMAR());
                DATABASE[i].SET_CHECK_IN(DATABASE[i + 1].GET_CHECK_IN());
                DATABASE[i].SET_CHECK_OUT(DATABASE[i + 1].GET_CHECK_OUT());
            }
            DATABASE[DB_SIZE-1] = null;
            DB_SIZE--;
        }
        
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
        //return Tamu.GET_JUMLAH_TAMU();
        return DB_SIZE;
    }
    
    public Tamu[] GET_MASTER_DATABASE(){
        return DATABASE;
    }
    
    public void UPDATE_MASTER_DATABASE(){
        db.WRITE_DATABASE_TAMU(GET_MASTER_DATABASE(),GET_JUMLAH_TAMU());
    }
}
