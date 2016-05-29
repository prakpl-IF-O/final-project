/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.premium.sp;
import static hotel.reguler.s;
import static hotel.suite.ss;
import static hotel.vip.sv;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author HERU A
 */
public class databaseCO {
   public void dbR(){
       try {
           File inputFile = new File("database1\\reguler.txt");
           
             File inputTemp = new File("database1\\Rtemp.txt");
             
             FileWriter writer = new FileWriter(inputTemp, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            for(int x=1;x<=50;x++){
                 bufferedWriter.write(reguler.regnew[x]); 
                 bufferedWriter.newLine();
            }
             bufferedWriter.close();
            inputFile.delete();
            inputTemp.renameTo(inputFile);
            
           
        } catch (IOException e) {
             e.printStackTrace();
        } 
     
    }
        public void dbP(){
       try {
            File inputFile = new File("database1\\premium.txt");
           
             File inputTemp = new File("database1\\Ptemp.txt");
             
             FileWriter writer = new FileWriter(inputTemp, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(sp);
            bufferedWriter.newLine();
            for(int x=1;x<=20;x++){
                 bufferedWriter.write(premium.prenew[x]); 
                 bufferedWriter.newLine();
            }
             bufferedWriter.close();
            inputFile.delete();
            inputTemp.renameTo(inputFile);
            
           
        } catch (IOException e) {
             e.printStackTrace();
        }
        }
     public void dbS(){
       try {
            File inputFile = new File("database1\\suite.txt");
           
             File inputTemp = new File("database1\\Stemp.txt");
             
             FileWriter writer = new FileWriter(inputTemp, true);

           BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(ss);
            bufferedWriter.newLine();
            for(int x=1;x<=20;x++){
                 bufferedWriter.write(suite.suinew[x]); 
                 bufferedWriter.newLine();
            }
             bufferedWriter.close();
            inputFile.delete();
            inputTemp.renameTo(inputFile);
            
           
        } catch (IOException e) {
             e.printStackTrace();
        }
     }
     
        
     public void dbV(){
       try {
            File inputFile = new File("database1\\vip.txt");
           
             File inputTemp = new File("database1\\Vtemp.txt");
             
             FileWriter writer = new FileWriter(inputTemp, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(sv);
            bufferedWriter.newLine();
            for(int x=1;x<=10;x++){
                 bufferedWriter.write(vip.vipnew[x]); 
                 bufferedWriter.newLine();
            }
             bufferedWriter.close();
            inputFile.delete();
            inputTemp.renameTo(inputFile);
            
           
        } catch (IOException e) {
             e.printStackTrace();
        } 
     }
}

     

