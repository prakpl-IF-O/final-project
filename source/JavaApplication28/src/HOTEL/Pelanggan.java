package HOTEL;

import java.sql.*;

public class Pelanggan implements Interface{
private String namaD,namaB, nama, id,TTL;
private int NIK,no;

String host = "jdbc:derby://localhost:1527/SISTEM_HOTEL";
    String uPass = "123";
    String uName = "DRN";

public Pelanggan(String namaD, String namaB, String TTL, int NIK, int no) {
        this.namaD = namaD;
        this.namaB = namaB;
        this.id = namaD+namaB;
        this.TTL = TTL;
        this.NIK = NIK;
        this.no=no;
    }

    public String getNamaD() {
        return namaD;
    }

    public String getNamaB() {
        return namaB;
    }

    public String getId() {
        return id;
    }
    
    public String getTTL() {
        return TTL;
    }

    public int getNIK() {
        return NIK;
    }
    
    @Override
    public void Input(){
    try (
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stm = con.createStatement();) {
            String in = String.format("update DATABASE_INPUT set "
            + "NAMAD='%s', NAMAB='%s', TTL='%s', ID='%s', NIK=%d where NO_KAMAR=%d",namaD, namaB, TTL, id, NIK, no);
            stm.executeUpdate(in);
        } catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    } 
    
    public void search(String id){
        try (
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stm = con.createStatement();) {
            String carii = String.format("SELECT* FROM DATABASE_INPUT where ID='%s'", id);
            ResultSet get = stm.executeQuery(carii);
            while (get.next()) {
                this.id=get.getString("ID");
                NIK=get.getInt("NIK");
                namaD = get.getString("NAMAD");
                namaB=get.getString("NAMAB");
                TTL = get.getString("TTL");
            }
            String a=String.format(namaD+" "+namaB);
            nama=a;
        }
        catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    }
        public String toString(){
        return String.format("nama: %s\nTTL: %s\nid: %s\nNIK: %d\n",nama,TTL,id,NIK);
        }
}
