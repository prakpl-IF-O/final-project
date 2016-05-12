/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.*;
import java.util.*;

/**
 *
 * @author Irfandi
 */
public class Database {

    private ArrayList<Staff> DB_STAFF = new ArrayList();

    public void READ_DATABASE(String Database, String db_file) throws Exception {
        File file = new File(db_file);
        BufferedReader READ = new BufferedReader(new FileReader(file));

        String SIGN;
        SIGN = READ.readLine();
        int n = Integer.parseInt(SIGN);

        if (Database.equalsIgnoreCase("staff")) {
            for (int i = 0; i < n; i++) {
                SIGN = READ.readLine();
                String ID = SIGN;
                SIGN = READ.readLine();
                String NAME = SIGN;
                SIGN = READ.readLine();
                String PASSWORD = SIGN;
                SIGN = READ.readLine();
                String PERTANYAAN = SIGN;
                SIGN = READ.readLine();
                String JAWABAN = SIGN;
                LOAD_STAFF(ID, NAME, PASSWORD, PERTANYAAN, JAWABAN);
            }
        }

    }

    public void LOAD_STAFF(String ID, String nama, String password, String pertanyaan, String jawaban) {
        Staff CurrentStaff = new Staff(ID, nama, password, pertanyaan, jawaban);
        DB_STAFF.add(CurrentStaff);
    }

    public ArrayList GET_DB_STAFF() {
        return DB_STAFF;
    }
}
