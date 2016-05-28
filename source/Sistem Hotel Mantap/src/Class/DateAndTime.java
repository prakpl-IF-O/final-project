/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Irfandi
 */
// mengatur dateAndTime
public class DateAndTime {
    
    //get current time
    //mengembalikan nilai waktu saat ini sesuai format yang diinputkan dalam 
    //parameter format
    public String GET_CURRENT_TIME(String format) {
        Calendar cal = Calendar.getInstance();
        if (format.equalsIgnoreCase("H:M:S")) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("H:M")) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("H")) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH");
            return (sdf.format(cal.getTime()));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("mm");
            return (sdf.format(cal.getTime()));
        }
    }
    
    //get different days
    //mengembalikan nilai dari jarak hari  antara dua tanggal yang diinputkan dalam parameter
    public int GET_DIFFERENT_DAYS(int tgl1, int bulan1, int tahun1,
            int tgl2, int bulan2, int tahun2) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(tahun1, bulan1, tgl1);
        end.set(tahun2, bulan2, tgl2);
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        String diff = Long.toString(diffDays);
        return Integer.parseInt(diff);
    }

    //get current date
    //mngembalikan nilai tanggal saat ini sesuai dari format yang diinputkan dalam parameter format
    public String GET_CURRENT_DATE(String format) {
        Calendar cal = Calendar.getInstance();
        if (format.equalsIgnoreCase("D-M-Y")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("D-Y")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("M/Y")) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/YYYY");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("D")) {
            SimpleDateFormat sdf = new SimpleDateFormat("DD");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("M")) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
            return (sdf.format(cal.getTime()));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
            return (sdf.format(cal.getTime()));
        }
    }
    
    //convert index of month
    //mengembalikan nilai string bulan dari index bulan yang diiniputkan dalam parameter
    public String CONVERT_INDEX_OF_MONTH(int Index) {
        switch (Index) {
            case 0:
                return "Januari";
            case 1:
                return "Februari";
            case 2:
                return "Maret";
            case 3:
                return "April";
            case 4:
                return "Mei";
            case 5:
                return "Juni";
            case 6:
                return "Juli";
            case 7:
                return "Agustus";
            case 8:
                return "September";
            case 9:
                return "Oktober";
            case 10:
                return "November";
            case 11:
                return "Desember";
            default:
                return Integer.toString(Index);
        }
    }

    //convert day of week
    //mengembalikan nilai string hari dari index days of week dalam parameter
    public String CONVERT_DAY_OF_WEEK(int Index) {
        switch (Index) {
            case 1:
                return "Minggu";
            case 2:
                return "Senin";
            case 3:
                return "Selasa";
            case 4:
                return "Rabu";
            case 5:
                return "Kamis";
            case 6:
                return "Jumat";
            case 7:
                return "Sabtu";
            default:
                return Integer.toString(Index);
        }
    }
}
