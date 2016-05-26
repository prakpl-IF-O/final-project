package Class;

public class Staff {

    private final String ID;
    private String nama, password;
    private String pertanyaan, jawaban; //pertanyaan dan jawaban lupa password

    public Staff(String ID, String nama, String password, String pertanyaan, String jawaban) {
        this.ID = ID;
        this.nama = nama;
        this.password = password;
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
    }

    public void GANTI_PASSWORD(String NEW_PASSWORD) {
        this.password = NEW_PASSWORD;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the pertanyaan
     */
    public String getPertanyaan() {
        return pertanyaan;
    }

    /**
     * @param pertanyaan the pertanyaan to set
     */
    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    /**
     * @return the jawaban
     */
    public String getJawaban() {
        return jawaban;
    }

    /**
     * @param jawaban the jawaban to set
     */
    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
