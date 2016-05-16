/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irfandi
 */
public class UserEngine {
    private Pelanggan DATABASE[];
    private int DB_SIZE;
    Database db = new Database();
    
    public UserEngine() {
        try {
            INIT_DB();
        } catch (Exception ex) {
            Logger.getLogger(LoginEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int GET_JUMLAH_USER(){
        return DB_SIZE;
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
