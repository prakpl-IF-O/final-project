/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;
/*
Deklarasi class Kamar yang mengextends class Customers
*/
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
/*
    menampilkan detail per jenis kamar hotelnya
    */
    public void kelas() {
        String kelas[][] = {{"KELAS", "      JUMLAH KAMAR", "   HARGA PERMALAM (Rp)", "daftar ID kamar"},
        {"Reguler", "        50", "            100.000", "             R1"},
        {"Premium", "        20", "            200.000", "             P1"},
        {"Suite", "          20", "            350.000", "             S1"},
        {"VIP", "            10", "            750.000", "             V1"},};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(kelas[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /*
    menampilkan diskon yang berlaku
    */
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

    /*
    mengecek kamar sudah dipesan atau belum
    @parameter id disimpan dalam array simpan
    */
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

    /*
    untuk menyimpan jumlah data Tersimpan
    @parameter a untuk disimpan dalam variabel array simpan
    @parameter b untuk dijumlahkan dengan variabel j
    */
    public void input(String a, int b) {
        int j = dataTersimpan;
        for (int i = (dataTersimpan + 1); i <= (j + b); i++) {
            simpanpelanggan[i] = a;
            dataTersimpan++;
        }
    }

    /*
    untuk menentukan nilai jumlh
    @parameter a disesuaikan dengan nilai variabel array simpan
    */
    public void checkjmlh(String a) {
        for (int i = 1; i <= dataTersimpan; i++) {
            if (a == simpanpelanggan[i]) {
                jumlh++;
            }
        }
    }

    /*
    menampilkan jumlah kamar yang masih kosong pada tiap jenis kamarnya
    */
    public void kosong() {
        System.out.println("Daftar kamar kosong : ");
        System.out.println("Reguler : " + kamarR + " kamar");
        System.out.println("Premium : " + kamarP + " kamar");
        System.out.println("Suite   : " + kamarS + " kamar");
        System.out.println("VIP     : " + kamarV + " kamar");
    }

    /*
    menampilkan nilai jumlah
    @return nilai jumlah hari menginapnya
    */
    public int getJumlh() {
        return jumlh;
    }

    /*
    menhitung jumlah kamar yang kosong setelah ada yang dipesan
    @parameter a disesuaikan dengan jenis kamarnya
    */
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

    /*
    menampilkan jumlah kamar Reguler yang masih kosong
    @return kamar Reguler yang kosong
    */
    public int cekKamarReguler() {
        return kamarR;
    }

    /*
    menampilkan jumlah kamar Premium yang masih kosong
    @return kamar Premium yang kosong
    */
    public int cekKamarPremium() {
        return kamarP;
    }

    /*
    menampilkan jumlah kamar Suite yang masih kosong
    @return kamar Suite yang kosong
    */
    public int cekKamarSuite() {
        return kamarS;
    }

    /*
    menampilkan jumlah kamar VIP yang masih kosong
    @return kamar VIP yang kosong
    */
    public int cekKamarVIP() {
        return kamarV;
    }

    /*
    menampilkan denda jika telat cek out
    @return nilai dendanya
    */
    public int getDenda() {
        return denda * 30000;
    }

    /*
    menentukan telat denda dalam jam
    @parameter denda disimpan dalam variabel denda
    */
    public void setDenda(int denda) {
        this.denda = denda;
    }
}
