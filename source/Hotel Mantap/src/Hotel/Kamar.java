package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;

public class Kamar {
    private String kelas;

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getNoKamar(int idPelanggan) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM KAMAR WHERE IDPELANGGAN = " + idPelanggan;
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int noKamar = rs.getInt("NO_KAMAR");
            rs.close();st.close();
            return noKamar;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }
    }

    public double getHarga() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM KAMAR WHERE KELAS = '" + getKelas() + "'";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            double harga = rs.getDouble("HARGA");
            rs.close();st.close();
            return harga;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }
    }

    public boolean checkKamar() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM KAMAR WHERE STATUS = FALSE AND KELAS = '" + getKelas() + "'";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            boolean check = rs.getRow() != 0;
            rs.close();st.close();
            return check;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            System.out.println("checkKamar");
            return false;
        }
    }

    public void inKamar(int idPelanggan, int sewa) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM KAMAR WHERE KELAS = '" + getKelas() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBoolean("STATUS") == false) {
                    rs.updateBoolean("STATUS", true);
                    rs.updateTimestamp("CHECKIN", getTimeIn());
                    rs.updateTimestamp("CHECKOUT", getTimeOut(sewa));
                    rs.updateInt("IDPELANGGAN", idPelanggan);
                    rs.updateRow();
                    break;
                }
            }
            rs.close();st.close();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void outKamar(int idPelanggan) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM KAMAR WHERE IDPELANGGAN = " + idPelanggan;
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            rs.updateBoolean("STATUS", false);
            rs.updateTimestamp("CHECKIN", null);
            rs.updateTimestamp("CHECKOUT", null);
            rs.updateRow();
            sql = "UPDATE KAMAR SET IDPELANGGAN = NULL WHERE NO_KAMAR = " + getNoKamar(idPelanggan);
            st.executeUpdate(sql);
            rs.close();st.close();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public Timestamp getTimeIn() {
        Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        return time;
    }

    public Timestamp getTimeOut(int sewa) {
        Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        time.setDate(time.getDate() + sewa);
        return time;
    }

    public int diffHour(int idPelanggan) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM KAMAR WHERE IDPELANGGAN = " + idPelanggan;
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            Timestamp out1 = rs.getTimestamp("CHECKOUT");
            Timestamp out2 = getTimeIn();
            int date1 = out1.getDate();
            int date2 = out2.getDate();
            int hourOut1 = out1.getHours();
            int hourOut2 = out2.getHours();
            rs.close();st.close();
            if (date2 - date1 >= 0) {
                return hourOut2 - hourOut1;
            } else {
                return 0;
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            System.out.println("diffHour");
            return 0;
        }
    }
}
