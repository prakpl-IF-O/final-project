/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Irfandi
 */
/**
 * deklarasi class Pelanggan
 * mengatur tentang pelanggan
 * @author Andy Wiranto
 */
public class Pelanggan {

    Calendar TANGGAL = new GregorianCalendar();
    DateAndTime dt = new DateAndTime();

    private String ID, NIK, NAMA, TEMPAT_LAHIR;
    private Date TANGGAL_LAHIR, TANGGAL_DAFTAR;
    private int AKUMULASI;
    
// konstruktor class Pelanggan
    public Pelanggan(String id, String nik, String nama, String tempat_lahir,
            String tanggal_lahir, String tanggal_daftar, String akumulasi) throws ParseException {
        this.ID = id;
        this.NIK = nik;
        this.NAMA = nama;
        this.TEMPAT_LAHIR = tempat_lahir;
        this.TANGGAL_LAHIR = new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(tanggal_lahir);
        this.TANGGAL_DAFTAR = new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(tanggal_daftar);
        this.AKUMULASI = Integer.parseInt(akumulasi);
        System.out.println("add pel " + nama);
    }

    /**Mendapatkan nilai ID
     * @return the ID
     */
    public String GET_ID() {
        return ID;
    }

    /**Mendapatkan nilai NIK
     * @return the NIK
     */
    public String GET_NIK() {
        return NIK;
    }

    /**Mendapatkan nilai NAMA
     * @return the NAMA
     */
    public String GET_NAMA() {
        return NAMA;
    }

    /**Mendapatkan nilai TANGGAL_LAHIR
     * @return the TANGGAL_LAHIR
     */
    public Date GET_TANGGAL_LAHIR() {
        return TANGGAL_LAHIR;
    }

    /**Mendapatkan nilai TANGGAL_DAFTAR
     * @return the TANGGAL_DAFTAR
     */
    public Date GET_TANGGAL_DAFTAR() {
        return TANGGAL_DAFTAR;
    }

    /**Mendapatkan nilai AKUMULASI
     * @return the AKUMULASI
     */
    public int GET_AKUMULASI() {
        return AKUMULASI;
    }
/**mengisi tanggal lahir
 * mengisikan hari tanggal bulan tahun lahir
 * konversi hari tanggal bulan tahun agar sesuai kalender
 * @return hari tanggal bulan tahun sesuai kalender 
 */
    public String STRING_TANGGAL_LAHIR() {
        TANGGAL.setTime(TANGGAL_LAHIR);

        String HARI = dt.CONVERT_DAY_OF_WEEK(TANGGAL.get(Calendar.DAY_OF_WEEK));
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (HARI + ", " + TANGGAL_ + " " + BULAN + " " + TAHUN);
    }

    /**
     * format tanggal lahir
     * mengisikan hari tanggal bulan tahun lahir
     * menyesuaikan format tanggal bulan tahun agar dapat di proses
     * @return tanggal bulan tahun sesuai kalender
     */
    public String FORMATED_TANGGAL_LAHIR() {
        TANGGAL.setTime(TANGGAL_LAHIR);
        String TANGGAL_, BULAN;

        int _TANGGAL = TANGGAL.get(Calendar.DAY_OF_MONTH);
        if (_TANGGAL < 10) {
            TANGGAL_ = "0" + Integer.toString(_TANGGAL);
        } else {
            TANGGAL_ = Integer.toString(_TANGGAL);
        }

        int _BULAN = TANGGAL.get(Calendar.MONTH) + 1;
        if (_BULAN < 10) {
            BULAN = "0" + Integer.toString(_BULAN);
        } else {
            BULAN = Integer.toString(_BULAN);
        }

        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (TANGGAL_ + "/" + BULAN + "/" + TAHUN);
    }
/**
 * mengisi tanggal daftar
 * mengkonversikan hari tanggal bulan tahun agar sesuai
 * @return hari tanggal bulan tahun sesuai dengan kalender
 */
    public String STRING_TANGGAL_DAFTAR() {
        TANGGAL.setTime(TANGGAL_DAFTAR);

        String HARI = dt.CONVERT_DAY_OF_WEEK(TANGGAL.get(Calendar.DAY_OF_WEEK));
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (HARI + ", " + TANGGAL_ + " " + BULAN + " " + TAHUN);
    }
/**
 * format tanggal daftar
 * mengisikan hari tanggal bulan tahun lahir
 * menyesuaikan format tanggal bulan tahun agar dapat di proses
 * @return 
 */
    public String FORMATED_TANGGAL_DAFTAR() {
        TANGGAL.setTime(TANGGAL_DAFTAR);
        String TANGGAL_, BULAN;

        int _TANGGAL = TANGGAL.get(Calendar.DAY_OF_MONTH);
        if (_TANGGAL < 10) {
            TANGGAL_ = "0" + Integer.toString(_TANGGAL);
        } else {
            TANGGAL_ = Integer.toString(_TANGGAL);
        }

        int _BULAN = TANGGAL.get(Calendar.MONTH) + 1;
        if (_BULAN < 10) {
            BULAN = "0" + Integer.toString(_BULAN);
        } else {
            BULAN = Integer.toString(_BULAN);
        }

        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (TANGGAL_ + "/" + BULAN + "/" + TAHUN);
    }

    /**Memberi nilai SET_ID
     * @param ID the ID to set
     */
    public void SET_ID(String ID) {
        this.ID = ID;
    }

    /**Memberi nilai SET_NIK
     * @param NIK the NIK to set
     */
    public void SET_NIK(String NIK) {
        this.NIK = NIK;
    }

    /**Memberi nilai SET_NAMA
     * @param NAMA the NAMA to set
     */
    public void SET_NAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    /**Memberi nilai SET_TEMPAT_LAHIR
     * @param TEMPAT_LAHIR the TEMPAT_LAHIR to set
     */
    public void SET_TEMPAT_LAHIR(String TEMPAT_LAHIR) {
        this.TEMPAT_LAHIR = TEMPAT_LAHIR;
    }

    /**Memberi nilai SET_TANGGAL_LAHIR
     * @param TANGGAL_LAHIR the TANGGAL_LAHIR to set
     */
    public void SET_TANGGAL_LAHIR(Date TANGGAL_LAHIR) {
        this.TANGGAL_LAHIR = TANGGAL_LAHIR;
    }

    /**Memberi nilai SET_TANGGAL_DAFTAR
     * @param TANGGAL_DAFTAR the TANGGAL_DAFTAR to set
     */
    public void SET_TANGGAL_DAFTAR(Date TANGGAL_DAFTAR) {
        this.TANGGAL_DAFTAR = TANGGAL_DAFTAR;
    }

    /**Memberi nilai SET_AKUMULASI
     * @param AKUMULASI the AKUMULASI to set
     */
    public void SET_AKUMULASI(int AKUMULASI) {
        this.AKUMULASI = AKUMULASI;
    }

    /**Mendapatkan nilai GET_TEMPAT_LAHIR
     * @return the TEMPAT_LAHIR
     */
    public String GET_TEMPAT_LAHIR() {
        return TEMPAT_LAHIR;
    }
}
