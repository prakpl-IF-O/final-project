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
public class Pelanggan {
    Calendar TANGGAL = new GregorianCalendar();
    DateAndTime dt = new DateAndTime();
    
    private final String ID, NIK, NAMA;
    private final Date TANGGAL_LAHIR, TANGGAL_DAFTAR;
    private int AKUMULASI;

    public Pelanggan(String id, String nik, String nama,
            String tanggal_lahir, String tanggal_daftar, String akumulasi) throws ParseException {
        this.ID = id;
        this.NIK = nik;
        this.NAMA = nama;
        this.TANGGAL_LAHIR = new SimpleDateFormat("ddMMyyyy", Locale.US).parse(tanggal_lahir);
        this.TANGGAL_DAFTAR = new SimpleDateFormat("ddMMyyyy", Locale.US).parse(tanggal_daftar);
        this.AKUMULASI = Integer.parseInt(akumulasi);
    }

    /**
     * @return the ID
     */
    public String GET_ID() {
        return ID;
    }

    /**
     * @return the NIK
     */
    public String GET_NIK() {
        return NIK;
    }

    /**
     * @return the NAMA
     */
    public String GET_NAMA() {
        return NAMA;
    }

    /**
     * @return the TANGGAL_LAHIR
     */
    public Date GET_TANGGAL_LAHIR() {
        return TANGGAL_LAHIR;
    }

    /**
     * @return the TANGGAL_DAFTAR
     */
    public Date GET_TANGGAL_DAFTAR() {
        return TANGGAL_DAFTAR;
    }

    /**
     * @return the AKUMULASI
     */
    public int GET_AKUMULASI() {
        return AKUMULASI;
    }
    
    public String STRING_TANGGAL_LAHIR() {
        TANGGAL.setTime(TANGGAL_LAHIR);

        String HARI = dt.CONVERT_DAY_OF_WEEK(TANGGAL.get(Calendar.DAY_OF_WEEK));
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (HARI + ", " + TANGGAL_ + " " + BULAN + " " + TAHUN);
    }
    
    public String STRING_TANGGAL_DAFTAR() {
        TANGGAL.setTime(TANGGAL_DAFTAR);

        String HARI = dt.CONVERT_DAY_OF_WEEK(TANGGAL.get(Calendar.DAY_OF_WEEK));
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (HARI + ", " + TANGGAL_ + " " + BULAN + " " + TAHUN);
    }
}
