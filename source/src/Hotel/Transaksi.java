//Package Hotel adalah package dari class Pelanggan
package Hotel;

/*Import atau memasukkan fungsi kalendar ke dalam class
  Import atau memasukkan fungsi Database sql ke dalam class
  Import atau memasukkan fungsi Perubah format tanggal
  Import atau memasukkan fungsi TimeUnit untuk mereprentasikan waktu milisekon ke jam */
import java.util.Calendar;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/*Deklarasi class transaksi yang mengimplementasi interface DB yang akan mengkonkritkan method (savingdata,retrievedata)
  Class ini memiliki peran sebagai algoritma yang memproses pertransaksian yang terjadi dalam program hotel (CheckIn,out,batas,diskon dan denda)
  Deklarasi instance variable int kodeTransaksi
  Deklarasi instance variable tamu dari class Pelanggan
  Deklarasi instance variable kamar dari class Kamar
  Deklarasi instance variable checkIn dari Fungsi Calendar
  Deklarasi instance variable batasCheckOut dari Fungsi Calendar
  Deklarasi instance variable double totalHarga
  Deklarasi instance variable double diskon
  Deklarasi instance variable double denda
  Deklarasi instance variable double harga
  Deklarasi instance variable sdf yang merupakan peubah format tanggal
 */
public class Transaksi implements DB {

    private int kodeTransaksi;
    Pelanggan tamu;
    Kamar kamar;
    private Calendar checkIn;
    private Calendar batasCheckOut;
    private Calendar checkOut;
    private double totalHarga;
    private double diskon;
    private double denda;
    private double harga;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /*
    Deklarasi constructor Transaksi tanpa parameter, dengan isi badan
    Inisialisasi nilai instance variable tamu dengan instansiasi objek Pelanggan baru
    Inisialisasi nilai instance variable kamar dengan instansiasi objek Kamar baru
    Inisialisasi nilai instance variable CheckIn dengan mengambil waktu dari calendar
    Inisialisasi nilai instance variable BatasCheckOut dengan mengambil waktu dari calendar */
    public Transaksi() {
        tamu = new Pelanggan();
        kamar = new Kamar();
        checkIn = Calendar.getInstance();
        batasCheckOut = Calendar.getInstance();
    }

    /*
    Overload constructor Transaksi dengan melewatkan 3 parameter (hari,tamu dan kamar)
    Instance variable tamu di refer dari parameter atau mendapat nilai dari parameter
    Instance variable kamar di refer dari parameter atau mendapat nilai dari parameter
    Inisialisasi nilai instance variable CheckIn dengan mengambil waktu dari calendar
    Inisialisasi nilai instance variable BatasCheckOut dengan mengambil waktu dari calendar 
    Instance variable batasCheckOut melakukan set tanggal sesuai inputan parameter hari
    Inisialisasi harga dengan nilai dari parameter hari
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Deklarasi String select dengan nilai format String yang merupakan perintah ke database untuk melakukan pemilihan berdasarkan kode dari transaksi
    Deklarasi ResultSet rset untuk mengeksekusi table atau query berdasarkan variable select
    Jika eksekusi dilakukan kodeTransaksi menambahkan nilai 1 pada kolom atau menambah 1 kolom
    Variale tamu melakukan update akumulasi atau lama menginap berdasarkan fungsi getId dan variable hari, id apa dan berapa hari
    Variable kamar memanggil method in, sehingga constructor mencatat transaksi check in
    Dan melakukan savingData */
    public Transaksi(int hari, Pelanggan tamu, Kamar kamar) throws SQLException {
        this.tamu = tamu;
        this.kamar = kamar;
        checkIn = Calendar.getInstance();
        batasCheckOut = Calendar.getInstance();
        batasCheckOut.add(Calendar.DATE, hari);
        harga = hari;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select max(kode) from transaksi");
        ResultSet rset = stmt.executeQuery(select);
        if (rset.next()) {
            kodeTransaksi = rset.getInt(1) + 1;
        }
        tamu.updateAkumulasi(tamu.getId(), hari);
        kamar.in();
        savingData();
    }

    //Deklarasi method getter kodeTransaksi
    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    //Deklarasi method getter totalHarga
    public double getTotalHarga() {
        return totalHarga;
    }

    //Deklarasi method untuk menghitung/check denda
    private void checkDenda() {
        checkOut = Calendar.getInstance();
        long selisih = checkOut.getTimeInMillis() - batasCheckOut.getTimeInMillis();
        long jam = TimeUnit.MILLISECONDS.toHours(selisih);
        if (jam > 0) {
            denda = jam * 30000;
        } else {
            denda = 0;
        }
    }

    //Deklarasi method untuk menghitung/check diskon
    private void checkDiskon() {
        if (tamu.getAkumulasi() < 10) {
            diskon = 1;
        } else if (tamu.getAkumulasi() < 31) {
            diskon = 0.9;
        } else if (tamu.getAkumulasi() < 61) {
            diskon = 0.85;
        } else {
            diskon = 0.75;
        }
    }

//Deklarasi method toString untuk memudahkan proses percetakan data transaksi dengan kembalian format berupa String dan data (kode,id,checkin,tenggang waktu dan nomor kamar)
    public String toString() {
        return String.format("Kode Transaksi %9d\nID Pelanggan %13d\nCheck In %40s\nTenggang Waktu %25s\nNo Kamar %21d",
                kodeTransaksi, tamu.getId(), String.valueOf(sdf.format(checkIn.getTime())),
                String.valueOf(sdf.format(batasCheckOut.getTime())), kamar.getNoKamar());
    }

//Deklarasi method untuk mencetak detail transaksi (kode,id,checkIn,Tenggang waktu, No Kamar, Checkout, harga, denda, diskon dan total)    
    public String showDetail() {
        double sd = (1 - diskon) * 100;
        return String.format("Kode Transaksi %9d\nID Pelanggan %13d\nCheck In %40s\nTenggang Waktu %25s\nNo Kamar %21d"
                + "\nCheck Out %37s\nHarga %33.0f\nDenda %31.0f\nDiskon %27.0f%%\nTotal %36.0f\n",
                kodeTransaksi, tamu.getId(), String.valueOf(sdf.format(checkIn.getTime())),
                String.valueOf(sdf.format(batasCheckOut.getTime())), kamar.getNoKamar(), String.valueOf(sdf.format(checkOut.getTime())),
                harga, denda, sd, totalHarga);
    }

    /*
    Deklarasi method untuk menyimpan data ke database
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Deklarasi variable String kode untuk memasukan nilai kode ke database dari parsing int kodeTransaksi
    Deklarasi variable String id untuk memasukan nilai id ke database dari parsing int getter id
    Deklarasi variable String tanggalMasuk untuk memasukkan nilai checkIn ke database dari parsing kalender getter waktu checkIn
    Deklarasi variable String nomorKamar untuk memasukkan nilai nomorKamar ke database dari parsing nomor kamar
    Deklarasi variable String tanggalMasuk untuk memasukkan nilai batasCheckOut ke database dari parsing kalender getter waktu batasCheckOut
    Deklarasi variable String insert1 yang adalah perintah ke database untuk melakukan pengisian nilai transaksi (kode,id,tanggalMasuk)
    Deklarasi variable String insert2 yang adalah perintah ke database untuk melakukan pengisian detail transaksi (kode,id,nomorkamar,checkin,batas)
    Eksekusi perintah insert1 dan insert2 */
    public void savingData() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String kode = String.valueOf(kodeTransaksi);
        String id = String.valueOf(tamu.getId());
        String tanggalMasuk = String.valueOf(sdf.format(checkIn.getTime()));
        String nomorKamar = String.valueOf(kamar.getNoKamar());
        String batasOut = String.valueOf(sdf.format(batasCheckOut.getTime()));
        String insert1 = String.format("insert into transaksi values (%s,%s,'%s')", kode, id, tanggalMasuk);
        String insert2 = String.format("insert into detailTransaksi(kodeTransaksi,idPelanggan,nomorKamar,checkIn,batas) values(%s,%s,%s,'%s','%s')",
                kode, id, nomorKamar, tanggalMasuk, batasOut);
        stmt.executeUpdate(insert1);
        stmt.executeUpdate(insert2);
    }

    /*
    Deklarasi method untuk melakukan transaksi checkout (harga,denda,diskon dan total)
    Memanggil method checkDenda
    Memanggil method checkDiskon
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Inisalisasi nilai harga dengan operasi harga * getter harga kamar, dimana harga adalah total hari dan dikali oleh harga
    Inisialisasi nilai totalHarga dengan operasi harga ditambah denda dan dikali diskon
    Deklarasi variable String tanggalKeluar yang memasukkan nilai ke database berupa parsing kalender checkout sebagai data waktu checkout
    Deklarasi variable String update berupa format perintah ke database untuk mengupdate detail transaksi berdasarkan set checkout (tanggalKeluar, harga dan kode transaksi)
    Kamar memanggil method out yang berarti checkout dilakukan */
    public void CheckOut() throws SQLException {
        checkDenda();
        checkDiskon();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        harga = harga * kamar.getHarga();
        totalHarga = (harga + denda) * diskon;
        String tanggalKeluar = String.valueOf(sdf.format(checkOut.getTime()));
        String update = String.format("update detailTransaksi set checkOut = '%s', total = %s where kodeTransaksi = %s", tanggalKeluar, totalHarga, kodeTransaksi);
        stmt.executeUpdate(update);
        kamar.out();
    }

    /*
    Deklarasi method retireveData untuk melakukan penyerahan data transaksi berdasarkan parameter int id
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Deklarasi variable String select dengan format perintah ke database utnuk melakukan pemilihan data dari detailTransaksi berdasarkan kodeTransaksi (id)
    Deklarasi rset untuk mengeksekusi tabel berdasarkan perintah variable select
    Deklarasi int ID = 0 dan int nomor = 0
    Selama rset dijalankan 
    Inisialisasi kodeTransaksi dengan mengambil nilai dari kodeTransaksi pada database
    Inisialisasi ID dengan mengambil nilai dari idPelanggan pada database
    Inisialisasi nomor dengan mengambil nilai dari nomorKamar pada database
    Set waktu checkIn dengan mengambil nilai dari checkIn pada database
    Set waktu batasChekout dengan mengambil nilai dari batas pada database
    Inisialisasi totalHarga dengan mengambil nilai dari total pada database
    Deklarasi variable long selisih dengan operasi mengubah waktu batas checkout menjadi milisekon - waktu checkIn milisekon
    Deklarasi variable long hari dengan operasi mengubah waktu selisih yang milisekon menjadi hari
    Inisialisasi nilai harga dengan variable hari
    Mengambil nomor kamar
    Mengambil id tamu
     */
    public void retrieveData(int id) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select * from detailTransaksi where kodeTransaksi = %s", id);
        ResultSet rset = stmt.executeQuery(select);
        int ID = 0, nomor = 0;
        while (rset.next()) {
            kodeTransaksi = rset.getInt("kodeTransaksi");
            ID = rset.getInt("idPelanggan");
            nomor = rset.getInt("nomorKamar");
            checkIn.setTime(rset.getTimestamp("checkIn"));
            batasCheckOut.setTime(rset.getTimestamp("batas"));
            totalHarga = rset.getDouble("total");
        }
        long selisih = batasCheckOut.getTimeInMillis() - checkIn.getTimeInMillis();
        long hari = TimeUnit.MILLISECONDS.toDays(selisih);
        harga = hari;
        kamar.retrieveData(nomor);
        tamu.retrieveData(ID);
    }

    /*
    Deklarasi method double hasilBulanan untuk menghitung penghasilan bulanan hotel
    Deklarasi variable Calendar now dengan nilai waktu saat ini
    Deklarasi variable SimpleDateFormat bulan sebagai peubah format waktu
    Deklarasi variable String skrg yang mengambil waktu dari variable now dan diubah ke format variable bulan
    Deklarasi variable double total dengan nilai 0
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Deklarasi variable String select yang merupakan perintah ke database untuk melakukan pilih dari detailTransaksi
    Deklarasi variable ResultSet rset untuk mengeksekusi table atau query berdasarkan variable select
    Selama rset berjalan
    Inisialisasi data dengan mengambil waktu checkIn
    Inisalisasi d dengan data dengan format bulan
    Jika skrg = d
    Maka total ditambah nilai total dari database
    Mengembalikan variable total
    */
    public double hasilBulanan() throws SQLException {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat bulan = new SimpleDateFormat("MM");
        String skrg = bulan.format(now.getTime());
        double total = 0;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = "select * from detailTransaksi";
        ResultSet rset = stmt.executeQuery(select);
        while (rset.next()) {
            Date data = rset.getDate("checkIn");
            String d = bulan.format(data);
            if (skrg.equalsIgnoreCase(d)) {
                total += rset.getDouble("total");
            }
        }
        return total;
    }

}
