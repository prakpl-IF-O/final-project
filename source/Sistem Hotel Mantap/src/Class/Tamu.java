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

    String NOMOR_KAMAR;
    Date CHECK_IN, CHECK_OUT;
    
    public Tamu (String id, String nik, String nama, String tempat_lahir,
            String tanggal_lahir, String tanggal_daftar, String akumulasi,
            String nomor_kamar, String tanggal_check_in, String tanggal_check_out) throws ParseException{

        super(id,nik,nama,tempat_lahir,tanggal_lahir,tanggal_daftar,akumulasi);
        this.NOMOR_KAMAR = nomor_kamar;
        this.CHECK_IN = new SimpleDateFormat("ddMMyyyy", Locale.US).parse(tanggal_check_in);
        this.CHECK_OUT = new SimpleDateFormat("ddMMyyyy", Locale.US).parse(tanggal_check_out);
    }
}
