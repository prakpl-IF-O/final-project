/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import databaseKamarr.*;
import static databaseKamarr.databaseKamarr.n;
import hotel.*;
import static hotel.reguler.regnew;
import static hotel.reguler.s;
import java.io.*;

/**
 *
 * @author HERU A
 */
public class Dataa {
    String id,nama,nik;
    public static String data;
    public static String arr[];
    public Dataa(String nik,String nama) throws FileNotFoundException, IOException{
        this.nama=nama;
        this.nik=nik;
        
                
                String ar[]=new String[9];
        File file = new File("database1\\pelanggan.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 8; z++) {
                    ar[z] = input.readLine();
                    System.out.println(ar[z]);
                    if(this.nik.equalsIgnoreCase(ar[z])){
                        int i=z;
                        for ( i=z; i<=(i+8);i++){
                        arr=new String[9];
                        arr[i]=input.readLine();
                    }
                        
                    }
    }
    }  
}
