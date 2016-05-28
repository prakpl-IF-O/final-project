/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;


import static hotel.premium.pre;
import static hotel.suite.nS;
import static hotel.suite.sui;
import static hotel.suite.suinew;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static hotel.suite.ss;

/**
 *
 * @author HERU A
 */
public class checkout3 extends Hotel{
   String tindakan,nomorS;
    public checkout3(String tindakan,String id, double harga, String kelas,String nomorS) throws FileNotFoundException, IOException {
        super(harga, kelas);
        this.tindakan = tindakan;
        this.nomorS=nomorS;
        
        if(kelas.equalsIgnoreCase("suite")){
            
//checkout untuk reguler
            sui = new String[21];
                
                File file = new File("database1\\suite.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 20; z++) {
                    sui[z] = input.readLine();
                    nS= Integer.parseInt(sui[0]); 
                }
                nS++;
                if(nS==21){
                    nS=20;
                    
                }

                ss = String.valueOf(nS); 
            }
            {

                int m = 20;
                if (nS < 19) {
                    m = 19;
                }
            int nomorSs = Integer.parseInt(nomorS);
                for (int i = 0; i <= nomorSs; i++) {
                        sui[nomorSs] = "kamar kosong";
                        //nomorKamarR=i;
                        //nomorRe = String.valueOf(nomorKamarR);    
                     
                    File file = new File("database1\\suite.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                suinew = new String[21];
                    for (int y = 0; y <= 20; y++) {
                        suinew[y] = input.readLine();
                        if (y == nomorSs) {
                            if (sui[y].equalsIgnoreCase("terisi")) {
                                break;
                            }
                            suinew[y] = "kamar kosong";
                            
                    }
                }
            }
            }
    
          
                 
          
    }
}

