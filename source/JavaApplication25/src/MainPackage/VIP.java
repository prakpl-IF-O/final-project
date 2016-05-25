public class VIP extends Jenis{
    protected final static double harga=100000;
    protected static int kamar=50;
    protected double invoice;
    public void setTipe() {
        this.tipe = "Reguler";
    }
    public void booking(int days){
        kamar--;
        invoice=days*harga;
        pelanggan.setAkumulasi(days);
    }
    @Override
    public String tampilTpKamar() {
        return tipe;
    }
    @Override
    public int tampilJmlKamar() {
        return kamar;
    }
    @Override
    public double tampilHarga() {
        return invoice;
    }
    @Override
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
    public double total(){return (invoice-getDiskon());}
}
