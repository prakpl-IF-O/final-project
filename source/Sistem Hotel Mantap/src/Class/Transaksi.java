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
public class Transaksi {

    TamuEngine tamu = new TamuEngine();
    KamarEngine kamar = new KamarEngine();
    DateAndTime dt = new DateAndTime();

    public double GET_TOTAL(double biaya_kamar, double diskon, double denda) {
        return ((biaya_kamar - diskon) + denda);
    }

    public double GET_BIAYA_KAMAR(int index) {
        double biaya;

        String kamar_ = tamu.GET_KAMAR_BY_INDEX(index);
        int harga = kamar.GET_HARGA_KAMAR_BY_NO_KAMAR(kamar_);
        int lama = tamu.GET_LAMA_INAP_BY_INDEX(index);
        biaya = harga * lama;
        return biaya;
    }

    public double GET_DISKON_KAMAR(int index) {

        double biaya_kamar = GET_BIAYA_KAMAR(index);
        double disk = 0;
        if (tamu.GET_AKUMULASI_BY_INDEX(index) < 10) {
            disk = 0.0;
        } else if (tamu.GET_AKUMULASI_BY_INDEX(index) <= 30) {
            disk = 0.1;
        } else if (tamu.GET_AKUMULASI_BY_INDEX(index) <= 60) {
            disk = 0.15;
        } else {
            disk = 0.25;
        }

        double hasil = (disk * biaya_kamar);
        return hasil;
    }

    public int GET_DENDA(int index) {
        int jam_in = tamu.GET_JAM_CHECK_IN_BY_INDEX(index);
        int jam_out = Integer.parseInt(dt.GET_CURRENT_TIME("H"));

        if (jam_out > jam_in) {
            int diff = jam_out - jam_in;
            return diff * 30000;
        } else {
            return 0;
        }
    }
}
