package FinalProject;

import java.util.Scanner;
/*
deklarasi class mainHotel
*/
public class mainHotel {
    /*
    method main
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("--------- WELCOME TO HOTEL MANTAP -----------");
        int pilihan = 0;
        /*
        instansiasi class Transaksi
        */
        Transaksi T = new Transaksi();
        /*
        instansiasi class Customers
        */
        Customers C = new Customers();
        /*
        instansiasi class kamar
        */
        Kamar K = new Kamar();
        do {
            System.out.println("");
            T.menu();
            System.out.println("");
            System.out.print("Masukkan pilihan anda : ");
            pilihan = in.nextInt();
            System.out.println("");
            switch (pilihan) {
                /*
                case pertama untuk memanggil method kelas yang menampilkan detail per jenis kamarnya
                */
                case 1:
                    K.kelas();
                    break;
                /*
                    case kedua untuk memanggil method disc yang menampilkan diskon sesuai lama menginap pelanggan   
                */
                case 2:
                    K.disc();
                    break;
                /*
                    case ketiga untuk menginputkan data pelanggan sesuai inputan dari user    
                */
                case 3:
                    System.out.println("Silahkan masukkan data anda di bawah");
                    System.out.print("Masukan lama Menginap :  ");
                    int n = in.nextInt();
                    K.hari = n;
                    String p;
                    System.out.print("Kelas Kamar (reguler,premium,suite,VIP): ");
                    p = in.next();
                    System.out.print("ID kamar : ");
                    String q = in.next();
                    K.IDkamar = q;
                    K.checkkamar(q);
                    System.out.print("Kode transaksi                     : ");
                    String a = in.next();
                    T.setkode(a);
                    System.out.print("Masukkan nama                      : ");
                    String b = in.next();
                    C.nama = b;
                    System.out.print("Masukkan ID                        : ");
                    String c = in.next();
                    C.IDpelanggan = c;
                    System.out.print("Masukkan NIK                       : ");
                    String d = in.next();
                    C.NIK = d;
                    System.out.print("Masukkan T/TL (hari/tglBulanTahun) : ");
                    String e = in.next();
                    C.TTL = e;
                    System.out.println("Tanggal terdaftar ");
                    System.out.print("Tanggal : ");
                    int h = in.nextInt();
                    System.out.print("Bulan   : ");
                    int m = in.nextInt();
                    System.out.print("Tahun   : ");
                    int t = in.nextInt();
                    C.terdaftar(h, m, t);
                    System.out.println("Tanggal CheckIn ");
                    System.out.print("Tanggal : ");
                    int w = in.nextInt();
                    System.out.print("Bulan   : ");
                    int x = in.nextInt();
                    System.out.print("Tahun   : ");
                    int z = in.nextInt();
                    T.setcheckin(w, x, z);
                    T.setcheckout(n);
                    System.out.println("Tanggal Chechk Out : " + T.getcheckout());
                    break;
                /*
                    case 4 untuk memanggil method kosong yang menampilkan kamar yang kosong sesuai kelas masing-masing
                    */
                case 4:
                    K.kosong();
                    break;
                /*
                    case 5 untuk menampilkan Data Transaksi pelanggan sesuai yang telah diinputkan
                    */
                case 5:
                    System.out.println("Data transaksi     ");
                    System.out.println("Kode transaksi       : " + T.kodeTransaksi);
                    System.out.println("Tanggal transaksi    : " + T.gettgl());
                    System.out.println("Nama Pelanggan       : " + C.nama);
                    System.out.println("ID pelanggan         : " + C.IDpelanggan);
                    System.out.println("NIK                  : " + C.NIK);
                    System.out.println("T/TL                 : " + C.TTL);
                    System.out.println("Tanggal terdaftar    : " + C.gettrdftr());
                    System.out.println("Memesan kamar untuk  : " + K.hari + " hari");
                    System.out.println("Tanggal checkIn      : " + T.getcheckin());
                    System.out.println("Tanggal checkOut     : " + T.getcheckout());
                    System.out.println("Kelas kamar          : " + K.kelas);
                    System.out.println("Harga satu hari      : Rp." + K.hargakamar + ",-");
                    System.out.println("ID kamar             : " + K.IDkamar);
                    System.out.println("Total bayar          : Rp." + K.harga + ",-");
                    System.out.println("Total Denda          : Rp." + T.getDenda());
                    break;
            }
        } while (pilihan < 6);
        System.out.println("Terimakasih telah menjadi Pelanggan Hotel Mantap");
        System.out.println("");
    }
}
