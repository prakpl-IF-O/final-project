/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Irfandi
 */
public class Kamar {
    private final String NOMOR_KAMAR, JENIS_KAMAR;
    private String STATUS;
    private final int HARGA_KAMAR;
    
    public Kamar(String nomor_kamar, String status, String jenis_kamar, 
                                                  String harga_kamar){
        this.NOMOR_KAMAR = nomor_kamar;
        this.STATUS = status;
        this.JENIS_KAMAR = jenis_kamar;
        this.HARGA_KAMAR = Integer.parseInt(harga_kamar);
    }
    
    public void CHECK_IN_THIS_ROOM (){
        STATUS = "dipesan";
    }
    
    public void CHECK_OUT_THIS_ROOM (){
        STATUS = "kosong";
    }

    /**
     * @return the NOMOR_KAMAR
     */
    public String GET_NOMOR_KAMAR() {
        return NOMOR_KAMAR;
    }

    /**
     * @return the JENIS_KAMAR
     */
    public String GET_JENIS_KAMAR() {
        return JENIS_KAMAR;
    }

    /**
     * @return the STATUS
     */
    public String GET_STATUS() {
        return STATUS;
    }

    /**
     * @return the HARGA_KAMAR
     */
    public int GET_HARGA_KAMAR() {
        return HARGA_KAMAR;
    }
}
