package Hotel;

import java.sql.*;

public class AddDatabase {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        Kamar kamar;
        String nomor, harga, kelas, status, insert;
        for (int i = 1; i <= 100; i++) {
            if (i <= 50) {
                kamar = new Reguler(i);
                nomor = String.valueOf(kamar.getNoKamar());
                harga = String.valueOf(kamar.getHarga());
                kelas = kamar.getKelas();
                status = String.valueOf(kamar.getIsSewa());
                insert = String.format("insert into kamar values (%s,%s,'%s',%s)", nomor, harga, kelas, status);
                stmt.executeUpdate(insert);
            } else if (i <= 70) {
                kamar = new Premium(i);
                nomor = String.valueOf(kamar.getNoKamar());
                harga = String.valueOf(kamar.getHarga());
                kelas = kamar.getKelas();
                status = String.valueOf(kamar.getIsSewa());
                insert = String.format("insert into kamar values (%s,%s,'%s',%s)", nomor, harga, kelas, status);
                stmt.executeUpdate(insert);
            } else if (i <= 90) {
                kamar = new Suite(i);
                nomor = String.valueOf(kamar.getNoKamar());
                harga = String.valueOf(kamar.getHarga());
                kelas = kamar.getKelas();
                status = String.valueOf(kamar.getIsSewa());
                insert = String.format("insert into kamar values (%s,%s,'%s',%s)", nomor, harga, kelas, status);
                stmt.executeUpdate(insert);
            } else if (i <= 100) {
                kamar = new VIP(i);
                nomor = String.valueOf(kamar.getNoKamar());
                harga = String.valueOf(kamar.getHarga());
                kelas = kamar.getKelas();
                status = String.valueOf(kamar.getIsSewa());
                insert = String.format("insert into kamar values (%s,%s,'%s',%s)", nomor, harga, kelas, status);
                stmt.executeUpdate(insert);
            }
        }
    }
}
