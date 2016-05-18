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
    private static int JUMLAH_TAMU = 0;
    
    public Tamu (String id, String nik, String nama, String tempat_lahir,
            String tanggal_lahir, String tanggal_daftar, String akumulasi,
            String nomor_kamar, String tanggal_check_in, String tanggal_check_out) throws ParseException{

        super(id,nik,nama,tempat_lahir,tanggal_lahir,tanggal_daftar,akumulasi);
        this.NOMOR_KAMAR = nomor_kamar;
        this.CHECK_IN = new SimpleDateFormat("ddMMyyyy", Locale.US).parse(tanggal_check_in);
        this.CHECK_OUT = new SimpleDateFormat("ddMMyyyy", Locale.US).parse(tanggal_check_out);
        JUMLAH_TAMU++;
    }
    
    public String STRING_TANGGAL_LAHIR(){
        TANGGAL.setTime(GET_TANGGAL_LAHIR());
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (TANGGAL+BULAN+TAHUN);
    }
    
    public String STRING_TANGGAL_DAFTAR() {
        TANGGAL.setTime(GET_TANGGAL_DAFTAR());
        String TANGGAL_ = Integer.toString(TANGGAL.get(Calendar.DAY_OF_MONTH));
        String BULAN = dt.CONVERT_INDEX_OF_MONTH(TANGGAL.get(Calendar.MONTH));
        String TAHUN = Integer.toString(TANGGAL.get(Calendar.YEAR));
        return (TANGGAL + BULAN + TAHUN);
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
}
