/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Irfandi
 */
public class Tamu extends Pelanggan {

    Calendar TANGGAL = new GregorianCalendar();
    DateAndTime dt = new DateAndTime();

    private String NOMOR_KAMAR;
    private Date CHECK_IN;
    private Date CHECK_OUT;
    private int JAM_CHECK_IN;
    private static int JUMLAH_TAMU = 0;

    public Tamu(String id, String nik, String nama, String tempat_lahir,
            String tanggal_lahir, String tanggal_daftar, String akumulasi,
            String nomor_kamar, String tanggal_check_in, String tanggal_check_out, int jam_check_in) throws ParseException {

        super(id, nik, nama, tempat_lahir, tanggal_lahir, tanggal_daftar, akumulasi);
        this.NOMOR_KAMAR = nomor_kamar;
        this.CHECK_IN = new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(tanggal_check_in);
        this.CHECK_OUT = new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(tanggal_check_out);
        this.JAM_CHECK_IN = jam_check_in;
        JUMLAH_TAMU++;
    }

    public String FORMATED_CHECK_IN() {
        TANGGAL.setTime(CHECK_IN);
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

    public String FORMATED_CHECK_OUT() {
        TANGGAL.setTime(CHECK_OUT);
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

    public int GET_LAMA_INAP() {
        TANGGAL.setTime(GET_CHECK_IN());
        int tgl1 = TANGGAL.get(Calendar.DAY_OF_MONTH);
        int bulan1 = TANGGAL.get(Calendar.MONTH) + 1;
        int tahun1 = TANGGAL.get(Calendar.YEAR);

        TANGGAL.setTime(GET_CHECK_OUT());
        int tgl2 = TANGGAL.get(Calendar.DAY_OF_MONTH);
        int bulan2 = TANGGAL.get(Calendar.MONTH) + 1;
        int tahun2 = TANGGAL.get(Calendar.YEAR);

        int hasil = dt.GET_DIFFERENT_DAYS(tgl1, bulan1, tahun1, tgl2, bulan2, tahun2);
        return hasil;
    }

    public String STRING_CHECK_IN() {
        TANGGAL.setTime(GET_CHECK_IN());

        String HARI = dt.CONVERT_DAY_OF_WEEK(TANGGAL.get(Calendar.DAY_OF_WEEK));
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (HARI + ", " + TANGGAL_ + " " + BULAN + " " + TAHUN);
    }

    public String STRING_CHECK_OUT() {
        TANGGAL.setTime(GET_CHECK_OUT());

        String HARI = dt.CONVERT_DAY_OF_WEEK(TANGGAL.get(Calendar.DAY_OF_WEEK));
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (HARI + ", " + TANGGAL_ + " " + BULAN + " " + TAHUN);
    }

    /**
     * @return the NOMOR_KAMAR
     */
    public String GET_NOMOR_KAMAR() {
        return NOMOR_KAMAR;
    }

    /**
     * @return the JUMLAH_TAMU
     */
    public static int GET_JUMLAH_TAMU() {
        return JUMLAH_TAMU;
    }

    /**
     * @param NOMOR_KAMAR the NOMOR_KAMAR to set
     */
    public void SET_NOMOR_KAMAR(String NOMOR_KAMAR) {
        this.NOMOR_KAMAR = NOMOR_KAMAR;
    }

    /**
     * @param CHECK_IN the CHECK_IN to set
     */
    public void SET_CHECK_IN(Date CHECK_IN) {
        this.CHECK_IN = CHECK_IN;
    }

    /**
     * @param CHECK_OUT the CHECK_OUT to set
     */
    public void SET_CHECK_OUT(Date CHECK_OUT) {
        this.CHECK_OUT = CHECK_OUT;
    }

    /**
     * @return the CHECK_IN
     */
    public Date GET_CHECK_IN() {
        return CHECK_IN;
    }

    /**
     * @return the CHECK_OUT
     */
    public Date GET_CHECK_OUT() {
        return CHECK_OUT;
    }

    /**
     * @return the JAM_CHECK_IN
     */
    public int GET_JAM_CHECK_IN() {
        return JAM_CHECK_IN;
    }
}
