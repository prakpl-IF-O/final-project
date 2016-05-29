/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author HERU A
 */
public class reguler extends Hotel {

    public static int regg = 50;

    //contructor yg dipanggil pada saat checkin
    private String tindakan;
    public static String regnew[];
    public static String reg[];
    public static String s;
    public static int nR;
    public static int nomorKamarR;
    public static String nomorRe;
    public static String nomorR;
    int nomorRr;
   
    public String[] getAr(){
        return regnew;
    }

    public reguler(String tindakan, double harga, String kelas,String nomorR) throws FileNotFoundException, IOException {
        super(harga, kelas);
        this.tindakan = tindakan;
        this.nomorR=nomorR;
        if (this.tindakan.equalsIgnoreCase("checkin")) {
            {
                reg = new String[51];
                
                File file = new File("database1\\reguler.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 50; z++) {
                    reg[z] = input.readLine();
                    nR = Integer.parseInt(reg[0]); 
                  
                }
                nR--;
                
                s = String.valueOf(nR);   
            }
            {
                int m = 50;
                if (nR < 49) {
                    m = 49;
                }
                for (int i = 0; i <= (m - nR); i++) {
                    if ("kamar kosong".equalsIgnoreCase(reg[i])) {
                        reg[i] = "terisi";
                        nomorKamarR=i;
                        nomorRe = String.valueOf(nomorKamarR);   
                    }
                    
                    File file = new File("database1\\reguler.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    regnew = new String[51];
                    for (int y = 0; y <= 50; y++) {
                        regnew[y] = input.readLine();
                        if (y == i) {
                            if (reg[y].equalsIgnoreCase("kamar kosong")) {
                             
                              break;
                            }
                            regnew[y] = "terisi"; 
                            
                        }
                    }
                }
            }
        } 
    
       
    }
}
        

    
    




    




    
         
     

       
     
     
     
    
    

