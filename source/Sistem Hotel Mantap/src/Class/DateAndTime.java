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
        if (format.equalsIgnoreCase("H:M:S")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("H:M")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("H")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH");
            return (sdf.format(cal.getTime()));
        } else {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("mm");
            return (sdf.format(cal.getTime()));
        }
    }

    public String GET_CURRENT_DATE(String format) {
        if (format.equalsIgnoreCase("D-M-Y")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("D-Y")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("D")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("DD");
            return (sdf.format(cal.getTime()));
        } else if (format.equalsIgnoreCase("M")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
            return (sdf.format(cal.getTime()));
        } else {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
            return (sdf.format(cal.getTime()));
        }
    }
}
