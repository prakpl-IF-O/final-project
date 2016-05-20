package Hotel;
public class Kamar {
    private int noKamar;
    private double harga;
    private String kelas;
    private boolean isSewa;

    public Kamar(int noKamar, double harga, String kelas) {
        this.noKamar = noKamar;
        this.harga = harga;
        this.kelas = kelas;
        isSewa = false;
    }
    public int getNoKamar() {
        return noKamar;
    }
    public double getHarga() {
        return harga;
    }
    public String getKelas() {
        return kelas;
    }
    public boolean getIsSewa() {
        return isSewa;
    }
    public void setIsSewa(boolean isSewa) {
        this.isSewa = isSewa;
    }
    public String toString (){
        return String.format("No Kamar: %d\nHarga Kamar: %.2f\nKelas Kamar: %s\nStatus: %s", noKamar,harga,kelas,(isSewa==true?"Reserved":"Free"));
    }
    
    
}
