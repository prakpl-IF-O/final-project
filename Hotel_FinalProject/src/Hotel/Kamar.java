//Package Hotel adalah package dari class Kamar
package Hotel;

//Mengimport atau memasukkan fungsi database pada java
import java.sql.*;

/* Deklarasi class kamar 
   Fungsi class ini adalah bagian dari program yang memiliki attribute dan fungsi
   Class ini digunakan sebagai letak dari fungsi check in, check out, check kamar dan penyerahan data kamar (nomor,harga,kelas dan status)
 */
public class Kamar {

    /* Deklarasi instance variable
       noKamar sebagai penomoran kamar
       harga sebagai tarif sewa
       kelas sebagai kelas kelas kamar such as premium VIP etc
       isSewa sebagai boolean yang menentukan true or false status kamar disewa atau tidak */
    private int noKamar;
    private double harga;
    private String kelas;
    private boolean isSewa;

// Deklarasi default constructor
    public Kamar() {
    }

    /* Deklarasi constructor yang melewatkan 3 parameter yang di refer kepada 3 instance variable
       dan pada badan ditambah isSewa dengan nilai false 
       yaitu dengan arti bahwa status awal masih belum tersewa */
    public Kamar(int noKamar, double harga, String kelas) {
        this.noKamar = noKamar;
        this.harga = harga;
        this.kelas = kelas;
        isSewa = false;
    }

// Deklarasi method bertipe int untuk mendapatkan nomor kamar dengan kembalian instance variable noKamar
    public int getNoKamar() {
        return noKamar;
    }

// Deklarasi method bertipe double untuk mendapatkan harga dengan kembalian instance variable harga bertipe double  
    public double getHarga() {
        return harga;
    }

// Deklarasi method bertipe String untuk mendapatkan kelas kamar dengan kembalian instance variable kelas    
    public String getKelas() {
        return kelas;
    }

// Deklarasi method bertipe boolean untuk mendapatkan status sewa dengan kembalian instance variable isSewa     
    public boolean getIsSewa() {
        return isSewa;
    }

// Deklarasi method bertipe void untuk men set status sewa dengan melewatkan 1 parameter boolean isSewa yang merefer pada instance variable isSewa 
    public void setIsSewa(boolean isSewa) {
        this.isSewa = isSewa;
    }

    /* Deklarasi method bertipe void in, yang berfungsi pada saat melakukan check in pada program
       Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
       Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
       String update adalah fungsi pada database sebagai update status kamar menjadi tersewa sehabis check in */
    public void in() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String update = String.format("update kamar set isSewa = true where noKamar = %s ", noKamar);
        stmt.executeUpdate(update);
    }

    /* Deklarasi method bertipe void in, yang berfungsi pada saat melakukan check out pada program
       Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
       Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
       String update adalah fungsi pada database sebagai update status kamar menjadi tersedia sehabis check out */
    public void out() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String update = String.format("update kamar set isSewa = false where noKamar = %s ", noKamar);
        stmt.executeUpdate(update);
    }

    /* Deklarasi method bertipe boolean checkKamar dengan melewatkan 1 parameter int nomor
       Yang berfungsi melakukan check status kamar pada program
       Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
       Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
       String select adalah fungsi database untuk memilih kamar berdasarkan nomor yang dimasukkan
       ResultSet rset berfungsi untuk menangkap data dari statement query pada perintah select
       Deklarasi variable boolean check dengan nilai false
       While berdasarkan rset untuk mendapatkan status kamar dan method mengembalikan nilai check */
    public boolean checkKamar(int nomor) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select isSewa from kamar where noKamar = %s", String.valueOf(nomor));
        ResultSet rset = stmt.executeQuery(select);
        boolean check = false;
        while (rset.next()) {
            check = rset.getBoolean("isSewa");
        }
        return check;
    }

    /* Deklarasi method bertipe String toString 
       Yang berfungsi melakukan pencetakan sesuai format ketika class dipanggil pada perintah mencetak */
    public String toString() {
        return String.format("No Kamar: %d\nHarga Kamar: %.2f\nKelas Kamar: %s\nStatus: %s", noKamar, harga, kelas, (isSewa == true ? "Reserved" : "Free"));
    }

    /* Deklarasi method bertipe void retrieveData dengan melewatkan 1 parameter int nomor
       Yang berfungsi melakukan menyerahkan data kamar(nomor,harga,kelas dan status) berdasarkan nomor dari database yang ditunjuk pada nomor kamar
       Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
       Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
       String select adalah fungsi database untuk memilih kamar berdasarkan nomor yang dimasukkan
       ResultSet rset berfungsi untuk menangkap data dari statement query pada perintah select
       While berdasarkan rset untuk mendapatkan data kamar */
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
