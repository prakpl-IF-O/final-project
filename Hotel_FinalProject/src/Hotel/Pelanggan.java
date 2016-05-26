//Package Hotel adalah package dari class Pelanggan
package Hotel;

/*
Memasukkan fungsi ParseException sebagai sinyal error ketika melakukan parsing
Memasukkan fungsi Kalender untuk menghitung waktu check in check out pertanggalan yang dibutuhkan untuk transaksi *etc
Memasukkan fungsi SimpleDateFormat untuk mengubah format pertanggalan
Memasukkan fungsi Database kedalam class */
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

/*Deklarasi class Pelanggan yang mengimplementasi interface DB
  Fungsi class ini adalah mengambil peran sebagai class yang menampung proses
  Juga merupakan tempat attribut dan fungsi-fungsi yang digunakan oleh program untuk mengatur data Pelanggan */
public class Pelanggan implements DB {

    /*Deklarasi Variable yang merupakan attribute
      Variable int id sebagai variable yang menyimpan id Pelanggan
      Variable String nik sebagai variable yang menyimpan nomor induk Pelanggan
      Variable String nama sebagai variable yang menyimpan nama Pelanggan
      Variable String tempatLahir sebagai variable yang menyimpan tempat lahir Pelanggan
      Variable String tanggalLahir sebagai variable yang menyimpan tanggal lahir Pelanggan
      Variable int akumulasi sebagai variable yang menyimpan akumulasi waktu lama menginap
      Variable String tempatLahir sebagai variable yang menyimpan tempat lahir Pelanggan
      Variable SimpleDateFormat sdf sebagai variable yang mengubah format waktu menjadi tahun bulan hari
      Variable SimpleDateFormat sdf2 sebagai variable yang mengubah format waktu hari bulan tahun */
    private int id;
    private String nik;
    private String nama;
    private String tempatLahir;
    private Date tanggalLahir;
    private Date tanggalDaftar;
    private int akumulasi;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    //Deklarasi default constructor Pelanggan
    public Pelanggan() {
    }

    /*Deklarasi constructor Pelanggan dengan melewatkan parameter nik,nama,tempatLahir dan tanggalLahir
      Dan pada badan terdapat 3 instance variable(nik,nama,tempatLahir) yang di refer kepada parameter
      Melakukan try pada inisialisasi nilai instance variable dengan parsing tanggal lahir ke format sdf2 berdasarkan tanggalLahir
      Menangkap Exception apabila terdapat error pada saat parsing 
      Menginisialisasi nilai instance variable tanggalDaftar dengan instansiasi dari Date yang menambahkan tanggal baru sebagai nilai
      Inisalisasi nilai instance variable akumulasi = 0
      Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
      Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
      Deklarasi String select dengan nilai format String yang merupakan perintah ke database untuk melakukan pemilihan berdasarkan id dari pelanggan
      Deklarasi Result rset untuk mengeksekusi query atau table berdasarkan select
      Id ditambah satu apabila ada setiap pelanggan masuk
      Menjalankan method savingData */
    public Pelanggan(String nik, String nama, String tempatLahir, String tanggalLahir) throws SQLException {
        this.nik = nik;
        this.nama = nama;
        this.tempatLahir = tempatLahir;

        try {
            this.tanggalLahir = sdf2.parse(tanggalLahir);
        } catch (ParseException ex) {
        }
        this.tanggalDaftar = new Date();
        akumulasi = 0;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select max(id) from pelanggan");
        ResultSet rset = stmt.executeQuery(select);
        if (rset.next()) {
            id = rset.getInt(1) + 1;
        }
        savingData();
    }

// Deklarasi method bertipe int untuk mendapatkan id dengan kembalian instance variable id bertipe int
    public int getId() {
        return id;
    }

// Deklarasi method bertipe String untuk mendapatkan nik dengan kembalian instance variable nik bertipe String
    public String getNik() {
        return nik;
    }

// Deklarasi method bertipe String untuk mendapatkan nama dengan kembalian instance variable nama bertipe String
    public String getNama() {
        return nama;
    }

// Deklarasi method bertipe String untuk mendapatkan tempat lahir dengan kembalian instance variable tempatLahir bertipe String    
    public String getTempatLahir() {
        return tempatLahir;
    }

// Deklarasi method bertipe Date untuk mendapatkan tanggal lahir dengan kembalian instance variable tanggalLahir bertipe Date    
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

// Deklarasi method bertipe Date untuk mendapatkan tanggal daftar dengan kembalian instance variable tanggalDaftar bertipe Date
    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

// Deklarasi method bertipe int untuk mendapatkan akumulasi waktu dengan kembalian instance variable akumulasi bertipe int    
    public int getAkumulasi() {
        return akumulasi;
    }

// Deklarasi method bertipe void untuk men set akumulasi waktu dengan parameter int akumulasi yang di refer 
// Dari instance variable akumulasi yang update nilai ditambah dari parameter akumulasi    
    public void setAkumulasi(int akumulasi) {
        this.akumulasi += akumulasi;

    }

//Deklarasi method bertipe String untuk mengembalikan String dengan format dan mencetak ketika nama class di panggil pada perintah cetak
    public String toString() {
        return String.format("%-29s: %d\n%-38s: %s\n%-34s: %s\n%-21s: %s, %s\n%-28s: %s\n%-31s: %d\n\n", "ID Pelanggan",
                id, "NIK", nik, "Nama", nama, "Tempat/Tanggal Lahir", tempatLahir, String.valueOf(sdf2.format(tanggalLahir)),
                "Tanggal Daftar", String.valueOf(sdf2.format(tanggalDaftar)), "Akumulasi", akumulasi);
    }

    /*Deklarasi method bertipe void untuk melakukan penyimpanan data ke database
      Method ini berfungsi untuk menyimmpan data ke database
      Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
      Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
      Deklarasi variable String id,nik,nama,tlahir,tglLahir,tglDaftar dan akumulasi
      Variable String id inisialisasi nilai dari parsing ke String dari int id 
      Variable String nik inisialisasi nilai dari instance variable nik
      Variable String nama inisialisasi nilai dari instance variable nama
      Variable String tLahir inisialisasi nilai dari instance variable tempatLahir
      Variable String tglLahir inisialisasi nilai dari parsing ke String nilai dari instance variable tanggalLahir yang diubah dengan format dari sdf 
      Variable String tglDaftar inisialisasi nilai dari parsing ke String nilai dari instance variable tanggalDaftar yang diubah dengan format dari sdf
      Variable String akumulasi inisialisasi nilai dari parsing ke String nilai dari instance variable akumuluasi
      Deklarasi Variable String insert yang digunakan sebagai perintah kedalam database yaitu 
      Memasukkan data dari class Pelanggan(id,nik,nama,tLahir,tglLahir,tglDaftar,akumulasi) ke database
      eksekusi update berdasarkan variable insert. */
    public void savingData() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String id, nik, nama, tLahir, tglLahir, tglDaftar, akumulasi;
        id = String.valueOf(this.id);
        nik = this.nik;
        nama = this.nama;
        tLahir = this.tempatLahir;
        tglLahir = String.valueOf(sdf.format(tanggalLahir));
        tglDaftar = String.valueOf(sdf.format(tanggalDaftar));
        akumulasi = String.valueOf(this.akumulasi);
        String insert = String.format("insert into pelanggan values (%s,%s,'%s','%s','%s','%s',%s)", id, nik, nama, tLahir, tglLahir, tglDaftar, akumulasi);
        stmt.executeUpdate(insert);
    }

    /*Deklarasi method bertipe void untuk melakukan pengambilan data pelanggan
      Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
      Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
      Deklarasi variable String select dengan String.format yang berisi perintah untuk memilih pelanggan berdasarkan id
      Deklarasi variable ResultSet rset yang berfungsi untuk menangkap data dari statement query berdasarkan variable perintah select
      While berdasarkan rset untuk mendapatkan data pelanggan */
    public void retrieveData(int id) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select * from pelanggan where id = %s", String.valueOf(id));
        ResultSet rset = stmt.executeQuery(select);
        while (rset.next()) {
            this.id = id;
            nik = rset.getString("nik");
            nama = rset.getString("nama");
            tempatLahir = rset.getString("tempatlahir");
            tanggalLahir = rset.getDate("tglLahir");
            tanggalDaftar = rset.getDate("tglDaftar");
            akumulasi = rset.getInt("akumulasi");
        }
    }

    /*Deklarasi method yang berfungsi untuk melakukan update data lama menginap berdasarkan id, dengan 2 parameter
      Melakukan fungsi retrieveData untuk mengambil data berdasarkan parameter id
      Melakukan fungsi setAkumulasi untuk menginisialisasi akumulasi berdasarkan parameter update
      Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
      Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
      Deklarasi variable String up yang diisi format string perintah untuk melakukan update pelanggan yang men set akumulasi berdasarkan id
      Melakukan eksekusi pengupdate an berdasarkan variable up */
    public void updateAkumulasi(int id, int update) throws SQLException {
        retrieveData(id);
        setAkumulasi(update);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String up = String.format("update pelanggan set akumulasi = %s where id = %s", String.valueOf(akumulasi), String.valueOf(this.id));
        stmt.executeUpdate(up);
    }

}
