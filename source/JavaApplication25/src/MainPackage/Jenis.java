package MainPackage;

/**abstract class dengan nama Jenis yang mengimplementasi class HotelMantap
 * class Jenis diheritance oleh jenis kamar yang tersedia, 
 * seperti premium, reguler, suite, dan vip agar class tersebut
 * dapat mengoverride method yang telah dioverride class Jenis dari HotelMantap
 */
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
