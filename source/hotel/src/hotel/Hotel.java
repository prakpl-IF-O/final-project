/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;


/**
 *
 * @author HERU A
 */
public class Hotel {
  
    private double harga;
    private String kelas;
    public Hotel( double harga, String kelas) {
        
        this.harga = harga;
        this.kelas = kelas;
    }
    public double getHarga() {
        return harga;
    }

    public String getKelas() {
        return kelas;
    }
    public void display(){
        
        System.out.println("harga kamar : "+getHarga());
        System.out.println("kelas kamar : "+getKelas());
    }
    
}
