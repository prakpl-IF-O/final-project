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
    
    /*
    * Method get NamaD
    * mengembalikan (return) nilai namaD
    */
    public String getNamaD() {
        return namaD;
    }

    /*
    * Method getNamaB
    * mengembalikan (return) nilai namaB
    */
    public String getNamaB() {
        return namaB;
    }

    /*
    * Method getId
    * mengembalikan (return) nilai id
    */
    public String getId() {
        return id;
    }
    
    /*
    * Method getTTL
    * mengembalikan (return) nilai TTL
    */
    public String getTTL() {
        return TTL;
    }

    /*
    * Method getNIK
    * mengembalikan (return) nilai NIK
    */
    public int getNIK() {
        return NIK;
    }
    
    /*
    * Method Override Input
    * Method input berfungsi sebagai penerima input data dari user yang kemudian disimpan ke dalam database
    */
    
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
    
    /*
    * Method search dengan parameter id
    * method search berfungsi untuk mencari data berdasarkan ID dari dalam database
    */
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
            String as=String.format("%s %s",namaD,namaB);
            nama=as;
        }
        catch (SQLException er) {
            System.out.println(er.getErrorCode());
        }
    }
        public String toString(){
        return String.format("nama: %s\nTTL: %s\nid: %s\nNIK: %d\n",nama,TTL,id,NIK);
        }
}
