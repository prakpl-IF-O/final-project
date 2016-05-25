package HOTEL;

public class Kamar {
    private double totalBayar, denda, sewa;
    private String jenisKamar;

    String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";
    
    public Kamar(String jenisKamar, double sewa) {
        this.jenisKamar = jenisKamar;
        this.sewa = sewa;
    }
    
    public Kamar(){
    
    }
}
