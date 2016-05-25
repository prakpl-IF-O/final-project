/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Husein
 */
import java.util.Calendar;

public class Checkin{
    kamarhotel kh=new kamarhotel();
    Calendar tin = Calendar.getInstance();
    Calendar tout = Calendar.getInstance();
    Calendar tout2 = Calendar.getInstance();
    int bayar;
    int denda = 30000;
    int kembali;
    int total;
    static byte akumulasi;
    byte sisakamar = 100;
    byte lamasewa;

    public static void setAkumulasi(byte akumulasi) {
        Checkin.akumulasi = akumulasi;
    }
    
    public Calendar getTin() {
        return tin;
    }

    public void setTin(Calendar tin) {
        this.tin = tin;
    }

    public Calendar getTout() {
        return tout;
    }

    public void setTout(Calendar tout) {
        this.tout = tout;
    }

    public Calendar getTout2() {
        return tout2;
    }

    public void setTout2(Calendar tout2) {
        this.tout2 = tout2;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public int getKembali() {
        return kembali=bayar-total;
    }

    public int getTotal() {
        return total=kh.getHar()*lamasewa;
    }

    public byte getSisakamar() {
        return sisakamar;
    }

    public void setSisakamar(byte sisakamar) {
        this.sisakamar = sisakamar;
    }

    public double getDiskon() {
        if (akumulasi > 60) {
            return 0.25;
        }
        if (akumulasi > 30) {
            return 0.15;
        }
        if (akumulasi > 9) {
            return 0.1;
        }else{
        return 0;
        }
    }

}
