/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HERU A
 */
public class dataPelanggan {
    static ArrayList<pelanggan>listPelanggan;
    public static String nomorKamarD;
    public dataPelanggan(){
       listPelanggan=new ArrayList();
    }
    public void insertData(String nama,String nik,String id,String tanggalLahir,String tempatLahir,String tanggalBook,String jamBook,String kelas,String nomorKamar){
        pelanggan pl=new pelanggan(nama,nik,id,tanggalLahir,tempatLahir,tanggalBook,jamBook,kelas,nomorKamar);
        listPelanggan.add(pl);
       
    }
    public ArrayList<pelanggan> getData(){
        return listPelanggan;
    }
    public void deletData(int index){
        listPelanggan.remove(index);
    }
     
         
}
