/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.*;
import java.util.*;

/**
 *
 * @author Irfandi
 */
public class Database {

    private Staff DB_STAFF[];
    private Pelanggan DB_PELANGGAN[];
    private int DB_SIZE = 0;

    public void READ_DATABASE(String Database, String db_file) throws Exception {
        File file = new File(db_file);
        BufferedReader READ = new BufferedReader(new FileReader(file));

        String SIGN;
        SIGN = READ.readLine();
        DB_SIZE = Integer.parseInt(SIGN);

        if (Database.equalsIgnoreCase("staff")) {
            DB_STAFF = new Staff[DB_SIZE];

            for (int i = 0; i < DB_SIZE; i++) {
                SIGN = READ.readLine();
                String ID = SIGN;
                SIGN = READ.readLine();
                String NAME = SIGN;
                SIGN = READ.readLine();
                String PASSWORD = SIGN;
                SIGN = READ.readLine();
                String PERTANYAAN = SIGN;
                SIGN = READ.readLine();
                String JAWABAN = SIGN;
                DB_STAFF[i] = new Staff(ID, NAME, PASSWORD, PERTANYAAN, JAWABAN);
            } 
        } else if (Database.equalsIgnoreCase("pelanggan")) {
            DB_PELANGGAN = new Pelanggan[DB_SIZE];
            
            for (int i = 0; i < DB_SIZE; i++) {
                SIGN = READ.readLine();
                String ID = SIGN;
                SIGN = READ.readLine();
                String NIK = SIGN;
                SIGN = READ.readLine();
                String NAMA = SIGN;
                SIGN = READ.readLine();
                String TEMPAT_LAHIR = SIGN;
                SIGN = READ.readLine();
                String TANGGAL_LAHIR = SIGN;
                SIGN = READ.readLine();
                String TANGGAL_DAFTAR = SIGN;
                SIGN = READ.readLine();
                String AKUMULASI = SIGN;
                DB_PELANGGAN[i] = new Pelanggan(ID, NIK, NAMA, TEMPAT_LAHIR,
                        TANGGAL_LAHIR, TANGGAL_DAFTAR, AKUMULASI);
            }
        }

    }

    public Staff[] GET_DB_STAFF() {
        return DB_STAFF;
    }
    
    public Pelanggan[] GET_DB_PELANGGAN(){
        return DB_PELANGGAN;
    }
    public int GET_DB_SIZE() {
        return DB_SIZE;
    }
}
