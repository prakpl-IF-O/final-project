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
//mengatur database
public class Database {

    private Staff DB_STAFF[];
    private Pelanggan DB_PELANGGAN[];
    private Kamar DB_KAMAR[];
    private Tamu DB_TAMU[];
    private LaporanBulanan DB_LAPORAN[];

    private int DB_SIZE = 0;
    
    
    //write database kamar
    //menulis file database kamar sesuai inputan parameter array objek kamar
    public void WRITE_DATABASE_KAMAR(Kamar[] LIST) {
        int max = 100;
        try {
            File inputFile = new File("database\\Kamar.database");
            File tempFile = new File("database\\KamarTemp.database");
            FileWriter writer = new FileWriter(tempFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            System.out.println("max : " + max);
            bufferedWriter.write(Integer.toString(max));

            for (int i = 0; i < max; i++) {
                System.out.println("write 1 + " + LIST[i].GET_NOMOR_KAMAR());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_NOMOR_KAMAR());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_STATUS());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_JENIS_KAMAR());
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(LIST[i].GET_HARGA_KAMAR()));
            }

            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //write database laporan
    //menulis file database laporan sesuai inputan parameter array objek laporan bulanan
    //dan melakukan perulangan sebanyak banyak objek dalam parameter max

    public void WRITE_DATABASE_LAPORAN(LaporanBulanan[] LIST, int max) {

        try {
            File inputFile = new File("database\\Laporan.database");
            File tempFile = new File("database\\LaporanTemp.database");
            FileWriter writer = new FileWriter(tempFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            System.out.println("max : " + max);
            bufferedWriter.write(Integer.toString(max));

            for (int i = 0; i < max; i++) {
                System.out.println("write 1 + " + LIST[i].GET_BULAN_TRANSAKSI());
                bufferedWriter.newLine();
                bufferedWriter.write(LIST[i].GET_BULAN_TRANSAKSI());
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(LIST[i].GET_JUMLAH_TRANSAKSI()));
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(LIST[i].GET_PENDAPATAN_BULANAN()));
            }

            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //write database pelanggan
    //menulis file database pelanggan sesuai inputan parameter array objek pelanggan
    //dan melakukan perulangan sebanyak banyak objek pelanggan dalam parameter max

    public void WRITE_DATABASE_PELANGGAN(Pelanggan[] LIST, int max) {

        try {
            File inputFile = new File("database\\Pelanggan.database");
            File tempFile = new File("database\\PelangganTemp.database");
            FileWriter writer = new FileWriter(tempFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            System.out.println("max : " + max);
            bufferedWriter.write(Integer.toString(max));

            for (int i = 0; i < max; i++) {
                System.out.println("write 1 + " + LIST[i].GET_ID());
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
            }

            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //write database tamu
    //menulis file database tamu sesuai inputan parameter array objek tamu
    //dan melakukan perulangan sebanyak banyak objek tamu dalam parameter max

    public void WRITE_DATABASE_TAMU(Tamu[] LIST, int max) {

        try {
            File inputFile = new File("database\\Tamu.database");
            File tempFile = new File("database\\TamuTemp.database");
            FileWriter writer = new FileWriter(tempFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            System.out.println("max : " + max);
            bufferedWriter.write(Integer.toHexString(max));

            for (int i = 0; i < max; i++) {
                System.out.println("write 1 + " + LIST[i].GET_ID());
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
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(LIST[i].GET_JAM_CHECK_IN()));
            }

            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //read database
    //membaca database sesuai permintaan dalam parameter database sebagai jenis database
    //dan string dbfile sebagai alamat database. kemudian akan menginstansiasikan objeknya
    //kedalam array objek yang tersedia
    public void READ_DATABASE(String Database, String db_file) throws Exception {
        File file = new File(db_file);
        BufferedReader READ = new BufferedReader(new FileReader(file));

        String SIGN;
        SIGN = READ.readLine();
        DB_SIZE = Integer.parseInt(SIGN);

        if (Database.equalsIgnoreCase("staff")) {
            DB_STAFF = new Staff[DB_SIZE + 5]; // setiap inisialisasi DB dapat menambpung c 5 staff baru

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
            DB_PELANGGAN = new Pelanggan[DB_SIZE + 100]; // setiap inisialisasi DB dapat menambpung 100 user baru

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
                SIGN = READ.readLine();
                String JAM_CHECK_IN = SIGN;
                DB_TAMU[i] = new Tamu(ID, NIK, NAMA, TEMPAT_LAHIR,
                        TANGGAL_LAHIR, TANGGAL_DAFTAR, AKUMULASI,
                        NO_KAMAR, TGL_CHECK_IN, TGL_CHECK_OUT, Integer.parseInt(JAM_CHECK_IN));

            }
        } else if (Database.equalsIgnoreCase("Laporan")) {
            DB_LAPORAN = new LaporanBulanan[DB_SIZE + 1];

            for (int i = 0; i < DB_SIZE; i++) {
                SIGN = READ.readLine();
                String BULAN = SIGN;
                SIGN = READ.readLine();
                String J_TRANS = SIGN;
                SIGN = READ.readLine();
                String J_PENDAPATAN = SIGN;
                DB_LAPORAN[i] = new LaporanBulanan(BULAN, J_TRANS, J_PENDAPATAN);
            }
        }

    }
    
    //get db kamar
    //mengembalikan array of objek kamar
    public Kamar[] GET_DB_KAMAR() {
        return DB_KAMAR;
    }

    //get db staff
    //mengembalikan array of objek staff
    public Staff[] GET_DB_STAFF() {
        return DB_STAFF;
    }

    //get db tamu
    //mengembalikan array of objektamu
    public Tamu[] GET_DB_TAMU() {
        return DB_TAMU;
    }

    //get db pelanggan
    //mengembalikan array of objek pelanggan
    public Pelanggan[] GET_DB_PELANGGAN() {
        return DB_PELANGGAN;
    }

    //get db laporan
    //mengembalikan array of objek laporan
    public LaporanBulanan[] GET_DB_LAPORAN() {
        return DB_LAPORAN;
    }

    //get db size
    //mengembalikan nilai besar / jumlah objek dalam array of object
    public int GET_DB_SIZE() {
        return DB_SIZE;
    }
}
