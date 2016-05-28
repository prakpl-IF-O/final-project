/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irfandi
 */
/**
 * deklarasi class KamarEngine
 * hal yang diperlukan pada class kamar
 * @author Andy Wiranto
 */
public class KamarEngine {
// deklarasi variabel
    private static Kamar DATABASE[];
    private static int DB_SIZE;

    private static int REG_KOSONG = 0, REG_DIPESAN = 0;
    private static int PRE_KOSONG = 0, PRE_DIPESAN = 0;
    private static int SUI_KOSONG = 0, SUI_DIPESAN = 0;
    private static int VIP_KOSONG = 0, VIP_DIPESAN = 0;

    Database db = new Database();
    
    // konstraktor KamarEngine
    // inisialisasi kamarEngine
    public KamarEngine() {
        try {
            INIT_DB();
        } catch (Exception ex) {
            Logger.getLogger(LoginEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // mengkosongkan kamar
    public void KOSONGKAN_KAMAR(String NO_KAMAR) {
        for (int i = 0; i < DB_SIZE; i++) {
            if (NO_KAMAR.equalsIgnoreCase(DATABASE[i].GET_NOMOR_KAMAR())) {
                DATABASE[i].CHECK_OUT_THIS_ROOM();
                SCAN_DB();
            }
        }
    }
    //untuk memesan kamar
    public void PESAN_KAMAR(String NO_KAMAR) {
        for (int i = 0; i < DB_SIZE; i++) {
            if (NO_KAMAR.equalsIgnoreCase(DATABASE[i].GET_NOMOR_KAMAR())) {
                DATABASE[i].CHECK_IN_THIS_ROOM();
                SCAN_DB();
            }
        }
    }
    //mengembalikan nilai no kamar berdasarkan index
    public String GET_NO_KAMAR_BY_INDEX(int index) {
        return DATABASE[index].GET_NOMOR_KAMAR();
    }
    //mengembalikan nilai jenis kamar brdasarkan no kamar
    public String GET_JENIS_KAMAR_BY_NO_KAMAR(String no_kamar) {
        for (int i = 0; i < DB_SIZE; i++) {
            if (DATABASE[i].GET_NOMOR_KAMAR().equalsIgnoreCase(no_kamar)) {
                return DATABASE[i].GET_JENIS_KAMAR();
            }
        }
        return "-1";
    }
    //mengembalikan nilai harga kamar brdasarkan no kamar
    public int GET_HARGA_KAMAR_BY_NO_KAMAR(String no_kamar) {
        for (int i = 0; i < DB_SIZE; i++) {
            if (DATABASE[i].GET_NOMOR_KAMAR().equalsIgnoreCase(no_kamar)) {
                return DATABASE[i].GET_HARGA_KAMAR();
            }
        }
        return -1;
    }

    //return index kamar
    public int GET_KAMAR_KOSONG(String Jenis_Kamar) {
        if (Jenis_Kamar.equalsIgnoreCase("reguler")) {
            for (int i = 0; i < 49; i++) {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    return i;
                }
            }
            return -1;
        } else if (Jenis_Kamar.equalsIgnoreCase("premium")) {
            for (int i = 50; i < 69; i++) {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    return i;
                }
            }
            return -1;
        } else if (Jenis_Kamar.equalsIgnoreCase("suite")) {
            for (int i = 70; i < 89; i++) {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    return i;
                }
            }
            return -1;
        } else {
            for (int i = 89; i < 99; i++) {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    return i;
                }
            }
            return -1;
        }
    }
// inisialisasi database kamar
    public void INIT_DB() throws Exception {
        db.READ_DATABASE("kamar", "database\\Kamar.database");
        DATABASE = db.GET_DB_KAMAR();
        DB_SIZE = db.GET_DB_SIZE();
        SCAN_DB();
    }
//mengembalikan nilai total kamar tersedia
    public int GET_TOTAL_KAMAR_TERSEDIA() {
        return (GET_REG_KOSONG() + GET_PRE_KOSONG() + GET_SUI_KOSONG() + GET_VIP_KOSONG());
    }
//mengembalikan nilai total kamar dipesan
    public int GET_TOTAL_KAMAR_DIPESAN() {
        return (GET_REG_DIPESAN() + GET_PRE_DIPESAN() + GET_SUI_DIPESAN() + GET_VIP_DIPESAN());
    }
//mencari database kamar
    public void SCAN_DB() {
        REG_KOSONG = 0;
        REG_DIPESAN = 0;
        PRE_KOSONG = 0;
        PRE_DIPESAN = 0;
        SUI_KOSONG = 0;
        SUI_DIPESAN = 0;
        VIP_KOSONG = 0;
        VIP_DIPESAN = 0;
        for (int i = 0; i < DB_SIZE; i++) {
            if (DATABASE[i].GET_JENIS_KAMAR().equalsIgnoreCase("Reguler")) {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    REG_KOSONG++;
                } else {
                    REG_DIPESAN++;
                }
            } else if (DATABASE[i].GET_JENIS_KAMAR().equalsIgnoreCase("Premium")) {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    PRE_KOSONG++;
                } else {
                    PRE_DIPESAN++;
                }
            } else if (DATABASE[i].GET_JENIS_KAMAR().equalsIgnoreCase("Suite")) {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    SUI_KOSONG++;
                } else {
                    SUI_DIPESAN++;
                }
            } else {
                if (DATABASE[i].GET_STATUS().equalsIgnoreCase("kosong")) {
                    VIP_KOSONG++;
                } else {
                    VIP_DIPESAN++;
                }
            }
        }
    }

    //method sementara untuk melihat database
    public String liat() {
        String a = "init\n";
        for (int i = 0; i < DB_SIZE; i++) {
            a = a + "\n" + i + " " + DATABASE[i].GET_NOMOR_KAMAR();
            a = a + " -> " + DATABASE[i].GET_STATUS();
        }
        return a;
    }

    /**mendapatkan kamar regular kosong
     * @return the REG_KOSONG
     */
    public int GET_REG_KOSONG() {
        return REG_KOSONG;
    }

    /**mendapatkan kamar regular dipesan
     * @return the REG_DIPESAN
     */
    public int GET_REG_DIPESAN() {
        return REG_DIPESAN;
    }

    /**mendapatkan kamar premium kosong
     * @return the PRE_KOSONG
     */
    public int GET_PRE_KOSONG() {
        return PRE_KOSONG;
    }

    /**mendapatkan kamar premium dipesan
     * @return the PRE_DIPESAN
     */
    public int GET_PRE_DIPESAN() {
        return PRE_DIPESAN;
    }

    /**mendapatkan kamar Suite kosong
     * @return the SUI_KOSONG
     */
    public int GET_SUI_KOSONG() {
        return SUI_KOSONG;
    }

    /**mendapatkan kamar Suite dipesan
     * @return the SUI_DIPESAN
     */
    public int GET_SUI_DIPESAN() {
        return SUI_DIPESAN;
    }

    /**mendapatkan kamar VIP kosong
     * @return the VIP_KOSONG
     */
    public int GET_VIP_KOSONG() {
        return VIP_KOSONG;
    }

    /**mendapatkan kamar VIP dipesan
     * @return the VIP_DIPESAN
     */
    public int GET_VIP_DIPESAN() {
        return VIP_DIPESAN;
    }

    //mengembalikan master database kamar
    public Kamar[] GET_MASTER_DATABASE() {
        return DATABASE;
    }
    // update master database kamar
    public void UPDATE_MASTER_DATABASE() {
        db.WRITE_DATABASE_KAMAR(GET_MASTER_DATABASE());
    }
}
