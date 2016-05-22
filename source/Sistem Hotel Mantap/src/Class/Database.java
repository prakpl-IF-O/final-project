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
    private Kamar DB_KAMAR[];
    private Tamu DB_TAMU[];
    
    private int DB_SIZE = 0;
    
    public void WRITE_DATABASE_TAMU(Tamu[] LIST, int max) {
        
        try {
            File inputFile = new File("database\\Tamu.database");
            File tempFile = new File("database\\TamuTemp.database");
            FileWriter writer = new FileWriter(tempFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            System.out.println("max : "+max);
            bufferedWriter.write(Integer.toHexString(max));
            
            for (int i = 0; i < max; i++) {
                System.out.println("write 1 + "+LIST[i].GET_ID());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_ID());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_NIK());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_NAMA());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_TEMPAT_LAHIR());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].FORMATED_TANGGAL_LAHIR());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].FORMATED_TANGGAL_DAFTAR());
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(LIST[i].GET_AKUMULASI()));
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_NOMOR_KAMAR());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].FORMATED_CHECK_IN());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].FORMATED_CHECK_OUT());
            }
            
            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void READ_DATABASE(String Database, String db_file) throws Exception {
        File file = new File(db_file);
        BufferedReader READ = new BufferedReader(new FileReader(file));

        String SIGN;
        SIGN = READ.readLine();
        DB_SIZE = Integer.parseInt(SIGN);

        if (Database.equalsIgnoreCase("staff")) {
            DB_STAFF = new Staff[DB_SIZE+5]; // setiap inisialisasi DB dapat menambpung 5 staff baru

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
            DB_PELANGGAN = new Pelanggan[DB_SIZE+100]; // setiap inisialisasi DB dapat menambpung 100 user baru
            
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
        } else if (Database.equalsIgnoreCase("kamar")) {
            DB_KAMAR = new Kamar[DB_SIZE];//dbsize selalu 100
            
            for (int i = 0; i < DB_SIZE; i++) {
                SIGN = READ.readLine();
                String NOMOR_KAMAR = SIGN;
                SIGN = READ.readLine();
                String STATUS = SIGN;
                SIGN = READ.readLine();
                String JENIS_KAMAR = SIGN;
                SIGN = READ.readLine();
                String HARGA_KAMAR = SIGN;
                DB_KAMAR[i] = new Kamar(NOMOR_KAMAR, STATUS, JENIS_KAMAR,
                        HARGA_KAMAR);
            }
        } else if (Database.equalsIgnoreCase("tamu")) {
            DB_TAMU = new Tamu[100];//karena jumlah kamar 100
            
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
                SIGN = READ.readLine();
                String NO_KAMAR = SIGN;
                SIGN = READ.readLine();
                String TGL_CHECK_IN = SIGN;
                SIGN = READ.readLine();
                String TGL_CHECK_OUT = SIGN;
                DB_TAMU[i] = new Tamu (ID, NIK, NAMA, TEMPAT_LAHIR,
                        TANGGAL_LAHIR, TANGGAL_DAFTAR, AKUMULASI, 
                        NO_KAMAR, TGL_CHECK_IN, TGL_CHECK_OUT);

            }
        }

    }
    
    public Kamar[] GET_DB_KAMAR(){
        return DB_KAMAR;
    }
    public Staff[] GET_DB_STAFF() {
        return DB_STAFF;
    }
    public Tamu[] GET_DB_TAMU(){
        return DB_TAMU;
    }
    public Pelanggan[] GET_DB_PELANGGAN(){
        return DB_PELANGGAN;
    }
    public int GET_DB_SIZE() {
        return DB_SIZE;
    }
}
