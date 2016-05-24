/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwiyan
 */
public abstract class Kamar {

    private int no;
    private String Kelas;
    private int harga;
    private String status;

    public Kamar(int no, String Kelas, int harga, String status) {
        this.no = no;
        this.Kelas = Kelas;
        this.harga = harga;
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public String getKelas() {
        return Kelas;
    }

    public int getHarga() {
        return harga;
    }

    public String getStatus() {
        return status;
    }
    
    

  
}
