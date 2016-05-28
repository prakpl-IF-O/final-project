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
// DEKLARASI CLASS KAMAR
// mengatur kamar
public class Kamar {
// deklarasi variabel
    private final String NOMOR_KAMAR, JENIS_KAMAR;
    private String STATUS;
    private final int HARGA_KAMAR;

// KONSTRUKTOR CLASS KAMAR
    public Kamar(String nomor_kamar, String status, String jenis_kamar,
            String harga_kamar) {
        this.NOMOR_KAMAR = nomor_kamar;
        this.STATUS = status;
        this.JENIS_KAMAR = jenis_kamar;
        this.HARGA_KAMAR = Integer.parseInt(harga_kamar);
    }

    /**
     * jika menggunakan method ini
     * status = dipesan
     */
    public void CHECK_IN_THIS_ROOM() {
        STATUS = "dipesan";
    }
    /**
     * jika menggunakan method ini
     * status = kosong
     */

    public void CHECK_OUT_THIS_ROOM() {
        STATUS = "kosong";
    }

    /**MRNDAPATKAN NOMOR KAMAR
     * @return the NOMOR_KAMAR
     */
    public String GET_NOMOR_KAMAR() {
        return NOMOR_KAMAR;
    }

    /**MENDAPATKAN JENIS KAMAR
     * @return the JENIS_KAMAR
     */
    public String GET_JENIS_KAMAR() {
        return JENIS_KAMAR;
    }

    /**MENDAPATKAN STATUS KAMAR
     * @return the STATUS
     */
    public String GET_STATUS() {
        return STATUS;
    }

    /**MENDAPATKAN NILAI HARGA KAMAR
     * @return the HARGA_KAMAR
     */
    public int GET_HARGA_KAMAR() {
        return HARGA_KAMAR;
    }
}
