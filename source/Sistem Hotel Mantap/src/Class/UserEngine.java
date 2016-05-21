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
public class UserEngine {
    private static Pelanggan DATABASE[];
    private static int DB_SIZE;
    Database db = new Database();
    
    public UserEngine() {
        try {
            INIT_DB();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    
    public String GET_TGL_DAFTAR_BY_INDEX(int index) {
        return DATABASE[index].STRING_TANGGAL_DAFTAR();
    }
    
    public int GET_AKUMULASI(int index){
        return DATABASE[index].GET_AKUMULASI();
    }
    public int GET_JUMLAH_USER(){
        return DB_SIZE;
    }
    public String GET_TEMPAT_LAHIR_BY_INDEX (int index){
        return DATABASE[index].GET_TEMPAT_LAHIR();
    }
    public String STRING_TANGGAL_LAHIR(int index) {
     return DATABASE[index].STRING_TANGGAL_LAHIR();
    }
    
    public String STRING_TANGGAL_DAFTAR(int index) {
        return DATABASE[index].STRING_TANGGAL_DAFTAR();
    }
    public void TAMBAH_PELANGGAN(String ID,String NIK,String NAMA,String TEMPAT_LAHIR,
                     String TANGGAL_LAHIR, String TANGGAL_DAFTAR, String AKUMULASI) {
        try {
            DATABASE[DB_SIZE] = new Pelanggan(ID, NIK, NAMA, TEMPAT_LAHIR,
                    TANGGAL_LAHIR, TANGGAL_DAFTAR, AKUMULASI);
            DB_SIZE++;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    public void DELETE_PELANGGAN (String ID){
        int index = -1 ;
        for (int i = 0; i < DB_SIZE; i++) {
            if (DATABASE[i].GET_ID().equalsIgnoreCase(ID)) {
                index =  i;
                break;
            }
        }
        
        if (index >= 0) {
            //menggeser user sesudahnya
            for (int i = index; i < (DB_SIZE - 1); i++) {
                DATABASE[i].SET_ID(DATABASE[i + 1].GET_ID());
                DATABASE[i].SET_NIK(DATABASE[i + 1].GET_NIK());
                DATABASE[i].SET_NAMA(DATABASE[i + 1].GET_NAMA());
                DATABASE[i].SET_TEMPAT_LAHIR(DATABASE[i + 1].GET_TEMPAT_LAHIR());
                DATABASE[i].SET_TANGGAL_LAHIR(DATABASE[i + 1].GET_TANGGAL_LAHIR());
                DATABASE[i].SET_TANGGAL_DAFTAR(DATABASE[i + 1].GET_TANGGAL_DAFTAR());
                DATABASE[i].SET_AKUMULASI(DATABASE[i + 1].GET_AKUMULASI());
            }
            DATABASE[DB_SIZE-1] = null;
            DB_SIZE--;
        }
        
    }
    public void INIT_DB() throws Exception {
        db.READ_DATABASE("pelanggan", "database\\Pelanggan.database");
        DATABASE = db.GET_DB_PELANGGAN();
        DB_SIZE = db.GET_DB_SIZE();
    }
    
    public String liat(){
                String a = "\n init ";
        for (int i = 0; i < DB_SIZE; i++) {
            a = a + "\n ID : " + DATABASE[i].GET_ID();
            a = a + "\n Nama : " + DATABASE[i].GET_NAMA();
            a = a + "\n NIK : " + DATABASE[i].GET_NIK();
            a = a + "\n Tgl daftar : " + DATABASE[i].STRING_TANGGAL_DAFTAR();
            a = a + "\nTgl Lahir : " + DATABASE[i].STRING_TANGGAL_LAHIR();
        }
        return a;
    }
}
