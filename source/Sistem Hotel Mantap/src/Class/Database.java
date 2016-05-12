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

    private Staff DB_STAFF[];
    private int DB_SIZE = 0;

    public void READ_DATABASE(String Database, String db_file) throws Exception {
        File file = new File(db_file);
        BufferedReader READ = new BufferedReader(new FileReader(file));

        String SIGN;
        SIGN = READ.readLine();
        DB_SIZE = Integer.parseInt(SIGN);

        if (Database.equalsIgnoreCase("staff")) {
            DB_STAFF = new Staff[DB_SIZE];

            for (int i = 0; i < DB_SIZE; i++) {
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
                DB_STAFF[i] = new Staff(ID, NAME, PASSWORD, PERTANYAAN, JAWABAN);
            }
        }

    }

    public Staff[] GET_DB_STAFF() {
        return DB_STAFF;
    }

    public int GET_DB_SIZE() {
        return DB_SIZE;
    }
}
