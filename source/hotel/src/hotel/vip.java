/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.reguler.nomorKamarR;
import static hotel.reguler.nomorRe;
import static hotel.suite.sui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HERU A
 */
public class vip extends Hotel {
     
       
    private int vipp=10;
    public static String vipnew[];
    static  String vip[];
    public static int nV;
    public static String sv;
    public static String nomorV;
    public static String v;
    
    
    //contructor yg dipanggil pada saat checkin/checkout kamar suite
    private int nomorSui;
    private String tindakan;
     public vip ( String tindakan,double harga, String kelas,String nomorV) throws FileNotFoundException, IOException{
         super(harga,kelas);
         this.tindakan=tindakan;
         this.nomorV=nomorV;
          if (this.tindakan.equalsIgnoreCase("checkin")) {

            {
                vip = new String[11];
                File file = new File("database1\\vip.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 10; z++) {
                    vip[z] = input.readLine();
                    nV = Integer.parseInt(vip[0]);
                }
                nV--;

                sv = String.valueOf(nV);
               
            }
            {

                int m = 10;
                if (nV < 9) {
                    m = 10;
                }
                for (int i = 0; i <= (m - nV); i++) {
                    if ("kamar kosong".equalsIgnoreCase(vip[i])) {
                        vip[i] = "terisi";
                        nomorKamarR=i;
                        nomorRe = String.valueOf(nomorKamarR);
                    }
                    File file = new File("database1\\vip.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    vipnew = new String[11];
                    for (int y = 0; y <= 10; y++) {
                        vipnew[y] = input.readLine();
                        if (y == i) {
                            if (vip[y].equalsIgnoreCase("kamar kosong")) {
                                break;
                            }
                            vipnew[y] = "terisi";
                            
                        }
                    }
                }
            }

        }
 //code untuk Checkout
    
    }

}  
    