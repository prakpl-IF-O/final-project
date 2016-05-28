package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Transaksi extends Pelanggan {
    private int sewa;
    private double total;

    public int getSewa() {
        return sewa;
    }

    public void setSewa(int sewa) {
        this.sewa = sewa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean checkInBaru() {
        if (super.checkKamar() == true) {
            super.newPelanggan();
            super.inKamar(super.getIdPelanggan(), getSewa());
            setTotal(super.getHarga() * getSewa());
            updateTransaksi("CHECKIN", getTotal());
            return true;
        } else {
            return false;
        }
    }

    public boolean checkInLama() {
        if (super.checkKamar() == true) {
            try {
                Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
                Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String idPelanggan = Integer.toString(super.getIdPelanggan());
                String sql = "SELECT * FROM PELANGGAN WHERE IDPELANGGAN = " + idPelanggan;
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                setTotal((super.getHarga() - diskon()) * getSewa());
                updateTransaksi("CHECKIN", getTotal());
                rs.updateInt("HARI", rs.getInt("HARI") + 1);
                rs.updateRow();
                super.inKamar(super.getIdPelanggan(), getSewa());
                rs.close();st.close();
                return true;
            } catch (SQLException error) {
                System.out.println(error.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    public double diskon() {
        int hari = super.getHari();
        if (hari >= 10 && hari <= 30) {
            return super.getHarga() * 0.1;
        } else if (hari >= 31 && hari <= 60) {
            return super.getHarga() * 0.15;
        } else if (hari >= 61) {
            return super.getHarga() * 0.25;
        } else {
            return 0;
        }
    }

    public double denda() {
        double denda = (super.diffHour(super.getIdPelanggan()) >= 1) ? 30000 * super.diffHour(super.getIdPelanggan()) : 0;
        return denda;
    }

    public void updateTransaksi(String trx, double total) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel Mantap");
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM TRANSAKSI";
            ResultSet rs = st.executeQuery(sql);
            rs.last();
            int id = rs.getRow() + 1;
            rs.moveToInsertRow();
            rs.updateInt("IDTRANSAKSI", id);
            rs.updateInt("IDPELANGGAN", super.getIdPelanggan());
            rs.updateTimestamp("TGLTRANSAKSI", super.getTimeIn());
            rs.updateDouble("TOTAL", total);
            rs.updateString("JENISTRANSAKSI", trx);
            rs.insertRow();
            rs.close();st.close();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public String detailTransaksi(double bayar, double kembali) {
        return String.format("ID Pelanggan : %d\nNama : %s\nNIK : %s\n\n---CHECK IN---\nKelas Kamar : %s\nNo. Kamar : %d\nLama sewa : %d hari\nCheck In : %s\nCheck Out : %s\n\nTotal : Rp %.2f\nDibayar : Rp %.2f\nKembali : Rp %.2f\n",
        super.getIdPelanggan(), super.getNama(), super.getNik(), super.getKelas(), super.getNoKamar(super.getIdPelanggan()), getSewa(), super.getTimeIn().toString(), super.getTimeOut(getSewa()).toString(), getTotal(), bayar, kembali);
    }
}
