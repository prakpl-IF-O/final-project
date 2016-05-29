/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.reguler.nomorKamarR;
import static hotel.reguler.nomorRe;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author HERU A
 */
public class pelanggan {
    
    private String nama,nik,id;
    private static String tanggalLahir,tanggalBook,jamBook;
    private String tempatLahir,kelas;
    public static String nomorKamar;
    private static Long selisihJam;
    public static double denda;
    public pelanggan(){};
    
    //constructor untuk data pelanggan
    public pelanggan(String nama,String nik,String id,String tanggalLahir,String tempatLahir,String tanggalBook,String jamBook,String kelas,String nomorKamar){
    this.nama=nama;
    this.nik=nik;
    this.id=id;
    this.tanggalLahir=tanggalLahir;
    this.tempatLahir=tempatLahir;
    this.tanggalBook=tanggalBook;
    this.jamBook=jamBook;
    this.kelas=kelas;
    this.nomorKamar=nomorKamar;
    
    
          
    }

    
    public static String getNomorKamar() {
        return nomorKamar;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getId() {
        return id;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public static String getTanggalBook() {
        return tanggalBook;
    }

    

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getKelas() {
        return kelas;
    }
    
    
    public void display(){
        System.out.println(getNama());
    }
    public static void main(String[] args) {
        System.out.println(nomorRe);
    }
     //method untuk konversi input tanggal string ke date
     protected static Date konversiStringkeDate(String tanggalDanWaktuStr,
            String pola, Locale lokal) {
        Date tanggalDate = null;
        SimpleDateFormat formatter;
        if (lokal == null) {
            formatter = new SimpleDateFormat(pola);
        } else {
            formatter = new SimpleDateFormat(pola, lokal);
        }
        try {
            tanggalDate = formatter.parse(tanggalDanWaktuStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return tanggalDate;
    }
     //method untuk menghitung selisih waktu checkin dan checkout
      protected static String selisihDateTime(Date waktuSatu, Date waktuDua) {
        long selisihMS = Math.abs(waktuSatu.getTime() - waktuDua.getTime());
        long selisihDetik = selisihMS / 1000 % 60;
        long selisihMenit = selisihMS / (60 * 1000) % 60;
        selisihJam = selisihMS / (60 * 60 * 1000) % 24;
        long selisihHari = selisihMS / (24 * 60 * 60 * 1000);
        String selisih = selisihHari + " hari " + selisihJam + " Jam "
                + selisihMenit + " Menit " + selisihDetik + " Detik";
        return selisih;
    }
      //method untuk menghitung denda 
      public void getDenda(){
          if(selisihJam>0){
               denda=30000*selisihJam;
          }  
      }
     
}

