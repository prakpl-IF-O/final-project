/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Customers {

    String IDpelanggan, NIK, nama, TTL;
    java.util.Date trdftr = new java.util.Date();
    SimpleDateFormat tampiltrdftr = new SimpleDateFormat("dd/MM/yyyy");

    public String getIDpelanggan() {
        return IDpelanggan;
    }

    public void setIDpelanggan(String IDpelanggan) {
        this.IDpelanggan = IDpelanggan;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public void terdaftar(int a, int b, int c) {
        trdftr.setDate(a);
        trdftr.setMonth(b);
        trdftr.setYear(c);
    }

    public String gettrdftr() {
        return String.format(trdftr.getDate() + "/" + trdftr.getMonth() + "/" + trdftr.getYear());
    }
}
