package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Pelanggan extends Kamar{
    private String nama, nik, ttl;
    private int idPelanggan, hari;

    public void newPelanggan() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM PELANGGAN";
            ResultSet rs = st.executeQuery(sql);
            rs.last();
            int id = rs.getRow() + 1;
            rs.moveToInsertRow();
            rs.updateInt("IDPELANGGAN", id);
            rs.updateString("NAMA", getNama());
            rs.updateString("NIK", getNik());
            rs.updateString("TTL", getTtl());
            rs.updateInt("HARI", 1);
            rs.insertRow();
            rs.close();st.close();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public String getNama() {
        try {
            if ((this.nama) == null) {
                Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
                Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String sql = "SELECT * FROM PELANGGAN WHERE IDPELANGGAN = " + getIdPelanggan();
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                this.nama = rs.getString("NAMA");
                rs.close();st.close();
                return this.nama;
            } else {
                return this.nama;
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        try {
            if ((this.nik) == null) {
                Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
                Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String sql = "SELECT * FROM PELANGGAN WHERE IDPELANGGAN = " + getIdPelanggan();
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                this.nik = rs.getString("NIK");
                rs.close();st.close();
                return this.nik;
            } else {
                return this.nik;
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public int getIdPelanggan() {
        try {
            if ((this.nama) == null) {
                return this.idPelanggan;
            } else {
                Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
                Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs;
                String sql = "SELECT * FROM PELANGGAN WHERE NAMA = '" + this.nama + "'";
                rs = st.executeQuery(sql);
                rs.next();
                int id = rs.getInt("IDPELANGGAN");
                setIdPelanggan(id);
                rs.close();st.close();
                return id;
            }
        } catch (SQLException error) {
            System.out.println("idPelanggan");
            System.out.println(error.getMessage());
            return 0;
        }
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getHari() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM PELANGGAN WHERE IDPELANGGAN = " + getIdPelanggan();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            setHari(rs.getInt("HARI"));
            rs.close();st.close();
            return hari;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }
    }

    public void setHari(int hari) {
        this.hari = hari;
    }
}
