/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.reguler.nR;
import static hotel.reguler.reg;
import static hotel.reguler.regnew;
import static hotel.reguler.s;
import static hotel.vip.sv;
import static hotel.vip.nV;
import static hotel.vip.vip;
import static hotel.vip.vipnew;
import static hotel.vip.nomorV;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HERU A
 */
public class checkout4 extends Hotel{
     String tindakan,nomorV;
    public checkout4(String tindakan,String id, double harga, String kelas,String nomorV) throws FileNotFoundException, IOException {
        super(harga, kelas);
        this.tindakan = tindakan;
        this.nomorV=nomorV;
        
        if(kelas.equalsIgnoreCase("vip")){
            
//checkout untuk reguler
            vip = new String[11];
                
                File file = new File("database1\\vip.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 10; z++) {
                    vip[z] = input.readLine();
                    nV = Integer.parseInt(vip[0]); 
                }
                nV++;
                if(nV==11){
                    nV=10;
                    
                }

                sv = String.valueOf(nV); 
            }
            {

                int m = 10;
                if (nV < 9) {
                    m = 9;
                }
            int nomorVv = Integer.parseInt(nomorV);
                for (int i = 0; i <= nomorVv; i++) {
                        vip[nomorVv] = "kamar kosong";
                        //nomorKamarR=i;
                        //nomorRe = String.valueOf(nomorKamarR);    
                     
                    File file = new File("database1\\vip.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                vipnew = new String[11];
                    for (int y = 0; y <= 10; y++) {
                        vipnew[y] = input.readLine();
                        if (y == nomorVv) {
                            if (vip[y].equalsIgnoreCase("terisi")) {
                                break;
                            }
                            vipnew[y] = "kamar kosong";
                            
                    }
                }
            }
            }
    
          
                 
          
    }
}

