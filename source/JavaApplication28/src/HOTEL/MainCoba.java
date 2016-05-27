package HOTEL;

import java.text.ParseException;

public class MainCoba {
    public static void main(String[] args) throws ParseException {
        Cek ad= new Cek();    
        System.out.println(ad.cekKamar(7));
        System.out.println(ad.cekVIP());
        System.out.println(ad.cekSuite());
        System.out.println(ad.cekReguler());
        System.out.println(ad.cekPremium());
//       
//       Pelanggan a= new Pelanggan ("ad","a","a",5,1);
//       a.Input(); 
//       Transaksi ba= new Transaksi(5,1);
//       ba.Input();
//       ba.hitungBayar("ada", "02-06-2016", "12:00", 1000);
//       System.out.println(ba);
//        Transaksi a= new Transaksi();
//        System.out.println(a.getId("ada"));
//        System.out.println(a.getId("dino"));
//        System.out.println(ba.generate("05"));
//        Premium a=new Premium();
//        a.hitungBayar("ada", "01-06-2016", "12:00");
//        System.out.println(a);
//           
//        //a.search("ada");
//        System.out.println(a);
//        Premium ab= new Premium();
//        System.out.println(ab.denda(1, "01-06-2016", "21:00"));
//        Pelanggan ab= new Pelanggan ("faiz","ayyas","sasas",12,1);
//        ab.Input();
    }
}
