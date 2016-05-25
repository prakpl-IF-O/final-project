package HOTEL;
public class Pelanggan {
private String namaD,namaB,id,TTL;
private int NIK,no;

public Pelanggan(String namaD, String namaB, String TTL, int NIK, int no) {
        this.namaD = namaD;
        this.namaB = namaB;
        this.id = namaD+namaB;
        this.TTL = TTL;
        this.NIK = NIK;
        this.no=no;
    }

    public String getNamaD() {
        return namaD;
    }

    public String getNamaB() {
        return namaB;
    }

    public String getId() {
        return id;
    }
    
    public String getTTL() {
        return TTL;
    }

    public int getNIK() {
        return NIK;
    }
}
