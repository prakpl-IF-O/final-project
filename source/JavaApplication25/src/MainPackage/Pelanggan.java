package MainPackage;

//class pelanggan dipergunakan untuk memasukkan dan mendapatkan nama, nik, dan alamat pelanggan

public class Pelanggan {
    protected String nama,nik,alamat;

    public double getDiskon() {
        return diskon;
    }
    protected int akumulasi;
    protected double diskon;
    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getAkumulasi() {
        return akumulasi;
    }

    public void setDiskon(double diskon) {
        if(getAkumulasi()>60){this.diskon=25;}
        else if(getAkumulasi()<61&&getAkumulasi()>30){this.diskon=15;}
        else if(getAkumulasi()<31&&getAkumulasi()>9){this.diskon=10;}
        else {this.diskon=0;}
    }
    
    public void setNama(String nama) {this.nama = nama;}
    public void setNik(String nik) {this.nik = nik;}
    public void setAlamat(String alamat) {this.alamat = alamat;}
    public void setAkumulasi(int a){this.akumulasi=this.akumulasi+a;}
}
