/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;



public class Pelanggan {
private String nama1,nama2, nama, id,TTL;
private int NIK,no;


public Pelanggan(String nama1, String nama2, String TTL, int NIK, int no) {
        this.nama1 = nama2;
        this.nama2 = nama2;
        this.id = nama1+nama2;
        this.TTL = TTL;
        this.NIK = NIK;
        this.no=no;
    }

    public String getNama1() {
        return nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public String getId() {
        return id;
    }
    
    public String getTTL() {
        return TTL;
    }

    public int getNIK() {
        return NIK;
    }}
    
