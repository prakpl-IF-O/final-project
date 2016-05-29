/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.premium.pre;
import static hotel.reguler.nomorKamarR;
import static hotel.reguler.nomorRe;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HERU A
 */
public class suite extends Hotel {
      
    private int suii=20;
    public static String suinew[];
    static  String sui[];
    public static int nS;
    public static String ss;
    public static String nomorS;
    public static String s;
    
    
    //contructor yg dipanggil pada saat checkin/checkout kamar suite
    private int nomorSui;
    private String tindakan;
     public suite ( String tindakan,double harga, String kelas,String nomorS) throws FileNotFoundException, IOException{
         super(harga,kelas);
         this.tindakan=tindakan;
         this.nomorS=nomorS;
          if (this.tindakan.equalsIgnoreCase("checkin")) {

            {
                sui = new String[21];
                File file = new File("database1\\suite.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 20; z++) {
                    sui[z] = input.readLine();
                    nS = Integer.parseInt(sui[0]);
                }
                nS--;

                ss = String.valueOf(nS);
               
            }
            {

                int m = 20;
                if (nS < 19) {
                    m = 19;
                }
                for (int i = 0; i <= (m - nS); i++) {
                    if ("kamar kosong".equalsIgnoreCase(sui[i])) {
                        sui[i] = "terisi";
                        nomorKamarR=i;
                        nomorRe = String.valueOf(nomorKamarR);
                    }
                    File file = new File("database1\\suite.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    suinew = new String[21];
                    for (int y = 0; y <= 20; y++) {
                        suinew[y] = input.readLine();
                        if (y == i) {
                            if (sui[y].equalsIgnoreCase("kamar kosong")) {
                                break;
                            }
                            suinew[y] = "terisi";
                            
                        }
                    }
                }
            }

        }
 //code untuk Checkout
    
    }

}  
       