//Package Hotel adalah package dari class Kamar
package Hotel;

//Mengimport atau memasukkan fungsi database pada java
import java.sql.*;

//Deklarasi Class AddDatabase, class ini berfungsi sebagai main atau class tempat aplikasi di run
public class AddDatabase {

//Deklarasi Method main yang digunakan untuk run Program
    public static void main(String[] args) throws SQLException {
        //Deklarasi variable con yang berasal dari Connection dari java.sql yang berfungsi sebagai penghubung ke Database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        //Deklarasi variable stmt yang berasal dari Statement dari java.sql yang berfungsi untuk menjalankan perintah-perintah Database    
        Statement stmt = con.createStatement();
        //Deklarasi variable kamar dari class Kamar
        Kamar kamar;
        //Deklarasi variable String nomor,harga,kelas,status dan insert
        String nomor, harga, kelas, status, insert;

        /*Melakukan Looping for dengan syarat nilai awal variable i = 1 , selama i kurang dari samadengan 100 maka i di increment
        Jika i kurang dari sama dengan 50 maka 
          Instansiasi kamar dari class Reguler dengan jumlah berdasarkan variable i
          Variable nomor mengambil nomor kamar dengan nilai String dari fungsi getNoKamar yang berada pada class Kamar
          Variable harga mengambil harga kamar dengan nilai String dari fungsi getHarga yang berada pada class Kamar
          Variable kelas yang mengambil kelas kamar dari fungsi getKelas yang berada pada class Kamar
          Variable status yang mengambil status kamar dengan nilai String dari fungsi boolean getIsSewa pada class Kamar
          Variable insert memasukkan nilai kamar dari nomor,harga,kelas dan status
          Eksekusi update berdasarkan variable insert
        Jika i kurang dari sama dengan 70 maka
          Instansiasi kamar dari class Premium dengan jumlah berdasarkan variable i
          Perintah sisanya sama dengan persyaratan looping sebelumnya
        Jika i kurang dari sama dengan 90 maka
          Instansiasi kamar dari class Suite dengan jumlah berdasarkan variable i
          Perintah sisanya sama dengan persyaratan looping sebelumnya
        Jika i kurang dari sama dengan 100 maka
          Instansiasi kamar dari class VIP dengan jumlah berdasarkan variable i
          Perintah sisanya sama dengan persyaratan looping sebelumnya
        Sehingga pada saat looping jika i mencapai 50 kamar reguler akan tercetak sebanyak 50 kamar
        Dan dari 50 sampai 70 maka akan tercetak kamar Premium sebanyak range 50 - 70 atau sebanyak 20 kamar
        Dan dari 70 sampai 90 maka akan tercetak kamar Suite sebanyak range 70 - 90 atau seanyak 20 kamar
        Dan dari 90 sampai 100 makan akan tercetak kamar VIP sebanyak range 90 - 100 atau sebanyak 10 kamar
         */
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
