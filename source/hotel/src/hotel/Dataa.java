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
    public static String ar[];
    int n1;
    //contructor untuk memanggil data pada database
    public Dataa(String nik,String nama) throws FileNotFoundException, IOException{
        this.nama=nama;
        this.nik=nik;
        File file = new File("database1\\jumlah.txt");
           BufferedReader input = new BufferedReader(new FileReader(file));
           String str=input.readLine();
           n1=Integer.parseInt(str);
           
        File file1 = new File("database1\\pelanggan.txt");
                BufferedReader input1 = new BufferedReader(new FileReader(file1));
                for (int z = 0; z <= n1; z++) {
                    ar=new String[n1+1];
                    ar[z] = input1.readLine();
                    if(this.nik.equalsIgnoreCase(ar[z])){
                        arr=new String[n1+1];
                        for(int i=z;i<=n1;i++){
 
                        arr[i]=input1.readLine();
                        
                        } 
                    }
    }
    }  
}
