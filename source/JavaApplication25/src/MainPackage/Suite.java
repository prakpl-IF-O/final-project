package MainPackage;

//class untuk pelanggan yang memilih tipe kamar Suite
public class Suite extends Jenis {
    protected final static double harga=350000;
    protected static int kamar=20;
    protected double invoice;
    //method untuk set tipe kamar yaitu Suite
    public void setTipe() {
        this.tipe = "Suite";
    }
    //method untuk set banyaknya hari tinggal di hotel
    public void booking(int days){
        kamar--;
        invoice=days*harga;
        pelanggan.setAkumulasi(days);
    }
    @Override
    //override method dari class Jenis untuk menampilkam tipe kamar
    public String tampilTpKamar() {
        return tipe;
    }
    @Override
    //override method dari class Jenis untuk menampilkan jumlah kamar yang tersedia
    public int tampilJmlKamar() {
        return kamar;
    }
    @Override
    //override method dari class Jenis untuk menampilkan total harga invoice
    public double tampilHarga() {
        return invoice;
    }
    @Override
    //override method dari class Jenis yang memberikan nilai kembali yaitu diskon yang didapatkan sesuai dengan akumulasi
    public double getDiskon() {
        double d;
        if(pelanggan.getAkumulasi()>9&&pelanggan.getAkumulasi()<=30)
            d=invoice*10/100;
        else if(pelanggan.getAkumulasi()>30&&pelanggan.getAkumulasi()<=60)
            d=invoice*15/100;
        else if(pelanggan.getAkumulasi()>60)
            d=invoice*25/100;
        else
            d=0;
        return d;
    }
    //method yang mengembalikan nilai yaitu total pembayaran setelah dipotong diskon
    public double total(){return (invoice-getDiskon());}
}
