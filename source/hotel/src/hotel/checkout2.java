/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.premium.nP;
import static hotel.premium.pre;
import static hotel.premium.prenew;
import static hotel.vip.vip;
//import static hotel.reguler.s;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static hotel.premium.sp;

/**
 *
 * @author HERU A
 */
public class checkout2 extends Hotel {
    String tindakan,nomorP;
    public checkout2(String tindakan,String id, double harga, String kelas,String nomorP) throws FileNotFoundException, IOException {
        super(harga, kelas);
        this.tindakan = tindakan;
        this.nomorP=nomorP;
        
        if(kelas.equalsIgnoreCase("premium")){
            
//checkout untuk reguler
            pre = new String[21];
                
                File file = new File("database1\\vip.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 20; z++) {
                    pre[z] = input.readLine();
                    nP = Integer.parseInt(pre[0]); 
                }
                nP++;
                if(nP==21){
                    nP=20;
                    
                }

                sp = String.valueOf(nP); 
            }
            {

                int m = 20;
                if (nP < 19) {
                    m = 19;
                }
            int nomorPp = Integer.parseInt(nomorP);
                for (int i = 0; i <= nomorPp; i++) {
                        pre[nomorPp] = "kamar kosong";
                        //nomorKamarR=i;
                        //nomorRe = String.valueOf(nomorKamarR);    
                     
                    File file = new File("database1\\premium.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                prenew = new String[21];
                    for (int y = 0; y <= 20; y++) {
                        prenew[y] = input.readLine();
                        if (y == nomorPp) {
                            if (pre[y].equalsIgnoreCase("terisi")) {
                                break;
                            }
                            prenew[y] = "kamar kosong";
                            
                    }
                }
            }
            }
    
          
                 
          
    }
}

