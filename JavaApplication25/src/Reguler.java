public class Reguler extends Jenis {
    protected final static double harga=100000;
    protected double diskon;
    protected static int kamar=50;
    public void setTipe() {
        this.tipe = "Reguler";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public double getDiskon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
