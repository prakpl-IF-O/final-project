/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irfandi
 */
public class LoginEngine {
    private Staff DATABASE [];
    private int DB_SIZE;
    Database db = new Database();
    
    public LoginEngine() {
        try {
            INIT_DB();
        } catch (Exception ex) {
            Logger.getLogger(LoginEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void INIT_DB()throws Exception{
        db.READ_DATABASE("staff","database\\Staff.database");
        DATABASE = db.GET_DB_STAFF();
        DB_SIZE = db.GET_DB_SIZE();
    }
    
    public boolean LOGIN (String username, String password){
        for (int i = 0; i < DB_SIZE; i++) {
           if (username.equalsIgnoreCase(DATABASE[i].getID()) && password.equalsIgnoreCase(DATABASE[i].getPassword())){
               return true;
           }  
        }
        return false;
    }

    //method sementara buat ngecek
    public String liat() {
        String a = "init \n";
        for (int i = 0; i < DB_SIZE; i++) {
            a = a + "\n" + DATABASE[i].getID();
            a = a + "\n" + DATABASE[i].getPassword();
        }
        return a;
    }
}
