/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

public class Hotel {

    public Hotel() {
    }

    public Hotel(String ID, String NIK, String nama, String TTL, int hari) {
        this.ID = ID;
        this.NIK = NIK;
        this.nama = nama;
        this.TTL = TTL;
        this.hari = hari;
    }

    String ID, NIK, nama, TTL, kodeTransaksi;
    static int KamarR = 50, KamarP = 20, KamarS = 20, KamarV = 10;
    double hargaR = 100000, hargaP = 200000, hargaS = 350000, hargaV = 750000, harga;
    String simpan[] = new String[1000];
    String idR[] = new String[50];
    String idP[] = new String[20];
    String idS[] = new String[20];
    String idV[] = new String[10];
    int jumlh, hari;
    static int dataTersimpan = 0;

    public void input(String a, int b) {
        int j = dataTersimpan;
        for (int i = (dataTersimpan + 1); i <= (j + b); i++) {
            simpan[i] = a;
            dataTersimpan++;
        }
    }

    public void check(String a) {
        jumlh = 0;
        for (int i = 1; i <= dataTersimpan; i++) {
            if (a == simpan[i]) {
                jumlh++;
            }
        }
    }

    public void pelanggan() {
        String pelanggan[][] = {{"ID    : " + this.ID},
        {"NIK   : " + this.NIK},
        {"NAMA  : " + this.nama},
        {"TTL   : " + this.TTL}
        };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.print(pelanggan[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
