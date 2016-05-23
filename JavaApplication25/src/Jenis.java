public abstract class Jenis implements HotelMantap {
    protected String tipe;
    protected boolean status;
    protected double diskon;
    Pelanggan pelanggan=new Pelanggan();
    @Override
    public abstract String tampilTpKamar();
    @Override
    public abstract int tampilJmlKamar();
    @Override
    public abstract double tampilHarga();
    @Override
    public abstract double getDiskon();
}
