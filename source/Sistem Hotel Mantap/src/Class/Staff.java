package Class;

// deklarasi class Staff
// mengatur tentang staff
public class Staff {
    
//deklarasi variabel
    private final String ID; // nilai ID bersifat final
    private String nama, password;
    private String pertanyaan, jawaban; //pertanyaan dan jawaban lupa password

// konstraktor Staff
    public Staff(String ID, String nama, String password, String pertanyaan, String jawaban) {
        this.ID = ID;
        this.nama = nama;
        this.password = password;
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
    }
/**
 * melakukan penggantian password
 * @param NEW_PASSWORD 
 */
    public void GANTI_PASSWORD(String NEW_PASSWORD) {
        this.password = NEW_PASSWORD;
    }

    /**
     * Mendapatkan nilai getID
     *
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Mendapatkan nilai getNama
     *
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * Memberi nilai setNama
     *
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Mendapatkan nilai getPassword
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Memberi nilai setPassword
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Mendapatkan nilai getPertanyaan
     *
     * @return the pertanyaan
     */
    public String getPertanyaan() {
        return pertanyaan;
    }

    /**
     * Memberi nilai setPertanyaan
     *
     * @param pertanyaan the pertanyaan to set
     */
    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    /**
     * Mendapatkan nilai getJawaban
     *
     * @return the jawaban
     */
    public String getJawaban() {
        return jawaban;
    }

    /**
     * Memberi nilai setJawaban
     *
     * @param jawaban the jawaban to set
     */
    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
