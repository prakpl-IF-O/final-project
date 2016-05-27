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
}
