package HOTEL;
public class MainCoba {
    public static void main(String[] args) {
        Cek ad= new Cek();    
        System.out.println(ad.cekKamar(7));
        System.out.println(ad.cekVIP());
        System.out.println(ad.cekSuite());
        System.out.println(ad.cekReguler());
        System.out.println(ad.cekPremium());
    }
}
