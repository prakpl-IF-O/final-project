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
    double bayar;
    double denda = 30000;
    double kembali;
    static double total;
    static byte akumulasi = 0;
    byte sisakamar = 100;
    byte lamasewa;
    
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
