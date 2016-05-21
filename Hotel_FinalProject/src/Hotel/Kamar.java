package Hotel;

import java.sql.*;

public class Kamar {

    private int noKamar;
    private double harga;
    private String kelas;
    private boolean isSewa;
    public Kamar(){}
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

    public String toString() {
        return String.format("No Kamar: %d\nHarga Kamar: %.2f\nKelas Kamar: %s\nStatus: %s", noKamar, harga, kelas, (isSewa == true ? "Reserved" : "Free"));
    }

    public void retrieveData(int nomor) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select * from kamar where noKamar = %s", String.valueOf(nomor));
        ResultSet rset = stmt.executeQuery(select);
        while (rset.next()) {
            noKamar = rset.getInt("noKamar");
            harga = rset.getDouble("harga");
            kelas = rset.getString("kelas");
            isSewa = rset.getBoolean("isSewa");                                   
        }
    }

}
