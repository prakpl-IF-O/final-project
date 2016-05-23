public class Pelanggan {
    protected String nama,nik,alamat;
    protected int akumulasi;

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

    public void setNama(String nama) {this.nama = nama;}
    public void setNik(String nik) {this.nik = nik;}
    public void setAlamat(String alamat) {this.alamat = alamat;}
    public void setAkumulasi(int a){this.akumulasi=this.akumulasi+a;}
}
