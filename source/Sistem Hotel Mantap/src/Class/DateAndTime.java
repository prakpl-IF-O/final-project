/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Irfandi
 */
public class DateAndTime {

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

    public String GET_CURRENT_DATE(String format) {
    Calendar cal = Calendar.getInstance();
        if (format.equalsIgnoreCase("D-M-Y")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("D-Y")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
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
    
    public String CONVERT_INDEX_OF_MONTH (int Index){
        switch (Index){
            case 0 : return "Januari";
            case 1 : return "Februari";
            case 2 : return "Maret";
            case 3 : return "April";
            case 4 : return "Mei";
            case 5 : return "Juni";
            case 6 : return "Juli";
            case 7 : return "Agustus";
            case 8 : return "September";
            case 9 : return "Oktober";
            case 10 : return "November";
            case 11 : return "Desember";
            default : return Integer.toString(Index);
        }
    }
    
        public String CONVERT_DAY_OF_WEEK (int Index){
        switch (Index){
            case 1 : return "Minggu";
            case 2 : return "Senin";
            case 3 : return "Selasa";
            case 4 : return "Rabu";
            case 5 : return "Kamis";
            case 6 : return "Jumat";
            case 7 : return "Sabtu";
            default : return Integer.toString(Index);
        }
    }
}
