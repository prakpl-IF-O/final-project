/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.reguler.nomorKamarR;
import static hotel.reguler.nomorRe;
import static hotel.reguler.reg;
import static hotel.reguler.regnew;
import static hotel.reguler.s;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HERU A
 */
public class premium extends Hotel {
      
    private int pree=20;
    public static String prenew[];
    static  String pre[];
    public static String sp;
    public static int nP;
    
    //contructor yg dipanggil pada saat checkin/checkout kamar premium
    private int nomorPre;
    private String tindakan;
    public String nomorP;
     public premium ( String tindakan,double harga, String kelas,String nomorP) throws FileNotFoundException, IOException{
         super(harga,kelas);
         this.tindakan=tindakan;
         this.nomorP=nomorP;
       if (this.tindakan.equalsIgnoreCase("checkin")) {

            {
                pre = new String[21];
                File file = new File("database1\\premium.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 20; z++) {
                    pre[z] = input.readLine();
                    nP = Integer.parseInt(pre[0]);     
                }
                nP--;

                sp = String.valueOf(nP);
               
            }
            {

                int m = 20;
                if (nP < 19) {
                    m = 19;
                }
                for (int i = 0; i <= (m - nP); i++) {
                    if ("kamar kosong".equalsIgnoreCase(pre[i])) {
                        pre[i] = "terisi";
                        nomorKamarR=i;
                        nomorRe = String.valueOf(nomorKamarR);
                    }
                    File file = new File("database1\\premium.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    prenew = new String[21];
                    for (int y = 0; y <=20; y++) {
                        prenew[y] = input.readLine();
                        if (y == i) {
                            if (pre[y].equalsIgnoreCase("kamar kosong")) {
                                break;
                            }
                            prenew[y] = "terisi";
                            
                        }
                    }
                }
            }

        }
//  //code untuk Checkout
        

    }

}  
       