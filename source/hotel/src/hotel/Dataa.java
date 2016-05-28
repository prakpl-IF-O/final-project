/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import databaseKamarr.*;
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
    String ar[]=new String[10];
    public static String arr[];
    public Dataa(String nama,String nik) throws FileNotFoundException, IOException{
        this.nama=nama;
        this.nik=nik;
        File file = new File("database1\\pelanggan.txt");
                BufferedReader input = new BufferedReader(new FileReader(file));
                for (int z = 0; z <= 8; z++) {
                    ar[z] = input.readLine();
                    if(nama.equalsIgnoreCase(ar[z]) && nik.equalsIgnoreCase(ar[z])){
                        int i=z;
                        for ( i=z; i<=(i+8);i++){
                        arr=new String[9];
                        arr[i]=ar[z];
                    }
                        System.out.println(ar[z]);
                    }
    }
    }  
}
