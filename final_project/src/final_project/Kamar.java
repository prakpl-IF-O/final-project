/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

public class Kamar {
    private double totalBayar, denda, sewa;
    private String jenisKamar;

    public Kamar(String jenisKamar, double sewa) {
        this.jenisKamar = jenisKamar;
        this.sewa = sewa;
    }
}