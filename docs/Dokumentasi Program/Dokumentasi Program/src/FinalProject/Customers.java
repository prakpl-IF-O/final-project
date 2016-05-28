/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/*
deklarasi class dengan nama Customers
*/
public class Customers {

    String IDpelanggan, NIK, nama, TTL;
    java.util.Date trdftr = new java.util.Date();
    SimpleDateFormat tampiltrdftr = new SimpleDateFormat("dd/MM/yyyy");

    /*
    mengambil nilai IDpelanggan
    return nilai IDpelanggannya
    */
    public String getIDpelanggan() {
        return IDpelanggan;
    }

    /*
    menyimpan ID pelangggan
    @parameter IDpelanggan untuk disimpan ke IDpelanggan
    */
    public void setIDpelanggan(String IDpelanggan) {
        this.IDpelanggan = IDpelanggan;
    }

    /*
    mengambil nilai NIK
    @return nilai NIKnya
    */
    public String getNIK() {
        return NIK;
    }

    /*
    menyimpan nilai NIK
    @parameter NIK  untuk disimpan ke variabel NIK
    */
    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    /*
    mengambil nilai Nama
    @return nilai Namanya
    */
    public String getNama() {
        return nama;
    }

    /*
    menyimpan nilai Nama
    @parameter nama disimpan ke variabel nama
    */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /*
    mengambil nilai TTL
    @return nilai TTLnya
    */
    public String getTTL() {
        return TTL;
    }

    /*
    menyimpan nilai TTL 
    @parameter TTL disimpan ke variabel TTL
    */
    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    /*
    menentukan tanggal terdaftar pelanggan
    @parameter a,b,c disimpan sesuai format date
    */
    public void terdaftar(int a, int b, int c) {
        trdftr.setDate(a);
        trdftr.setMonth(b);
        trdftr.setYear(c);
    }

    /*
    menampilkan tanggal terdaftar pelanggan
    @return tanggal terdaftar pelanggannya
    */
    public String gettrdftr() {
        return String.format(trdftr.getDate() + "/" + trdftr.getMonth() + "/" + trdftr.getYear());
    }
}
