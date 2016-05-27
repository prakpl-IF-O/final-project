/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

public class Kamar extends Customers {

    String IDkamar, kelas;
    int hargakamar;
    int k;
    int jumlh;
    static int dataTersimpan = 0;
    int hari, denda;
    String simpanpelanggan[] = new String[1000];
    String simpan[] = new String[100];
    int kamarR = 50, kamarP = 20, kamarS = 20, kamarV = 10;
    double harga;
    static int a = 0;

    public void kelas() {
        String kelas[][] = {{"KELAS", "      JUMLAH KAMAR", "   HARGA PERMALAM (Rp)", "daftar ID kamar"},
        {"Reguler", "        50", "            100.000", "             R1-R50"},
        {"Premium", "        20", "            200.000", "             P1-P20"},
        {"Suite", "          20", "            350.000", "             S1-S20"},
        {"VIP", "            10", "            750.000", "             V1-V10"},};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(kelas[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void disc() {
        String disc[][] = {{"AKUMULASI LAMA SEWA (hari)", "    DISCOUNT"},
        {"          0-9", "                    0%"},
        {"         10-30", "                   10%"},
        {"         31-60", "                   15%"},
        {"         61-dst", "                  25%"},};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(disc[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void checkkamar(String id) {
        for (int i = 1; i <= 100; i++) {
            if (id == simpan[i]) {
                System.out.println("KETERANGAN : Maaf,Kamar sudah di pesan, Silahkan pilih kamar yang lain");
                simpan[a] = null;
            } else {
                System.out.println("KETERANGAN : Kamar tersedia");
                simpan[a + 1] = id;
                a++;
                break;
            }
        }
    }

    public void kosong() {
        System.out.println("Daftar kamar kosong : ");
        System.out.println("Reguler : " + kamarR + " kamar");
        System.out.println("Premium : " + kamarP + " kamar");
        System.out.println("Suite   : " + kamarS + " kamar");
        System.out.println("VIP     : " + kamarV + " kamar");
    }

    public void input(String a, int b) {
        int j = dataTersimpan;
        for (int i = (dataTersimpan + 1); i <= (j + b); i++) {
            simpanpelanggan[i] = a;
            dataTersimpan++;
        }
    }

    public void checkjmlh(String a) {
        for (int i = 1; i <= dataTersimpan; i++) {
            if (a == simpanpelanggan[i]) {
                jumlh++;
            }
        }
    }

    public int getJumlh() {
        return jumlh;
    }

    public void cekKamar(String a) {
        if ("reguler".equalsIgnoreCase(a)) {
            kamarR--;
        } else if ("premium".equalsIgnoreCase(a)) {
            kamarP--;
        } else if ("suite".equalsIgnoreCase(a)) {
            kamarS--;
        } else if ("VIP".equalsIgnoreCase(a)) {
            kamarV--;
        }
    }

    public int cekKamarReguler() {
        return kamarR;
    }

    public int cekKamarPremium() {
        return kamarP;
    }

    public int cekKamarSuite() {
        return kamarS;
    }

    public int cekKamarVIP() {
        return kamarV;
    }

    public int getDenda() {
        return denda * 30000;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }
}
