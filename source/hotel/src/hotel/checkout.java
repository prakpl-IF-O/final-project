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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HERU A
 */
public class checkout extends Hotel {
    String tindakan,nomorR;
    public checkout(String tindakan,String id, double harga, String kelas,String nomorR) throws FileNotFoundException, IOException {
        super(harga, kelas);
        this.tindakan = tindakan;
        this.nomorR=nomorR;
        
        if(kelas.equalsIgnoreCase("reguler")){
            
//checkout untuk reguler
            reg = new String[51];
                
                File file = new File("database1\\reguler.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 50; z++) {
                    reg[z] = input.readLine();
                    nR = Integer.parseInt(reg[0]); 
                }
                nR++;
                if(nR==51){
                    nR=50;
                    
                }

                s = String.valueOf(nR); 
            }
            {

                int m = 50;
                if (nR < 49) {
                    m = 49;
                }
            int nomorRr = Integer.parseInt(nomorR);
                for (int i = 0; i <= nomorRr; i++) {
                        reg[nomorRr] = "kamar kosong";
                        //nomorKamarR=i;
                        //nomorRe = String.valueOf(nomorKamarR);    
                     
                    File file = new File("database1\\reguler.txt");
                    BufferedReader input = new BufferedReader(new FileReader(file));
                regnew = new String[51];
                    for (int y = 0; y <= 50; y++) {
                        regnew[y] = input.readLine();
                        if (y == nomorRr) {
                            if (reg[y].equalsIgnoreCase("terisi")) {
                                break;
                            }
                            regnew[y] = "kamar kosong";
                            
                    }
                }
            }
            }
    
          
                 
          
    }
}

