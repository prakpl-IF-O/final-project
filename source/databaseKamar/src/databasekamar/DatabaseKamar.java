/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasekamar;

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
public class DatabaseKamar {

    /**
     * @param args the command line arguments
     */
   // public static void main(String[] args) throws FileNotFoundException, IOException {
    public void db(){ 
    try {
           File inputFile = new File("databasee\\reguler.txt");
           
             File inputTemp = new File("databasee\\Rtemp.txt");
             
             FileWriter writer = new FileWriter(inputTemp, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("50");
            bufferedWriter.newLine();
            for(int x=1;x<=50;x++)
                 bufferedWriter.write("HAHAHA"); 
                 bufferedWriter.newLine();
            
            bufferedWriter.close();
            inputFile.delete();
            inputTemp.renameTo(inputFile);
            
           
        } catch (IOException e) {
             e.printStackTrace();
        } 
     
    }}
       
        
     