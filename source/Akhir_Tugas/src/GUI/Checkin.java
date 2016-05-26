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
    double bayar;
    double denda = 30000;
    double kembali;
    double total;
    static byte akumulasi = 0;
    byte sisakamar = 100;
    byte lamasewa;
    
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

    public double getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public double getKembali() {
        return kembali=bayar-total;
    }

    public double getTotal() {
        return total=kh.getHar()*lamasewa;
    }

    public byte getSisakamar() {
        return sisakamar;
    }

    public void setSisakamar(byte sisakamar) {
        this.sisakamar = sisakamar;
    }

    public double getDiskon(byte a) {
        if (akumulasi+a > 60) {
            return 0.25;
        }
        if (akumulasi+a > 30) {
            return 0.15;
        }
        if (akumulasi+a > 9) {
            return 0.1;
        }else{
        return 0;
        }
    }

}
