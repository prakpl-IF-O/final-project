//Package Hotel adalah package dari class/form panel_tabel_transaksi
package Hotel;

/*
Import atau memasukkan fungsi Database sql ke dalam class
Import atau memasukkan fungsi Perubah format tanggal
Memasukkan fungsi tergenerated logging level untuk menentukan set standar dalam mengendalikan output logging utility
Memasukkan fungsi tergenerated logging logger untuk melakukan loging pesan log dari sistem atau komponen aplikasi hotel
Memasukkan fungsi table
Memasukkan fungsi tanggal
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

//@author ltf
//Deklarasi class atau form panel_table_transaksi, yang berfungsi untuk membuat tabel transaksi dan melakukan perubahan didalam tabel tersebut, class ini merupakan gui jframe maka menjadi turunan swing jframe
public class panel_tabel_transaksi extends javax.swing.JFrame {

    /*
    Deklarasi constructor panel_table_transaksi
    Coba 
    initComponent merupakan method yg saat membuat jframe tergenerate otomatis, karena fungsinya sebagai instalator komponen gui dan menghubungkan ke class
    Deklarasi DefaultTabelModel model untuk membuat model tabel dengan nilai mengambil model table_id
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql 
    Deklarasi String select dengan perintah database untuk memilih dari detailTransaksi
    Deklarasi double hasil dengan nilai 0
    Deklarasi ResultSet rset untuk mengeksekusi query dengan perintah select
    Deklarasi SimpleDateFormat sdf (hari/bulan/tahun)
    Selama Eksekusi rset berjalan
    Deklarasi int kode dengan mengambil nilai dari database kolom kodeTransaksi
    Deklarasi int id dengan mengambil nilai dari database kolom idPelanggan
    Deklarasi int nomor dengan mengambil nilai dari database kolom nomoKamar
    Deklarasi String in dengan format sdf mengambil waktu dari kolom Checkin
    Deklarasi String out dengan nilai " "
    Deklarasi int total = 0
    Coba
    Out dengan format sdf mengambil waktu dari kolom checkOut
    Total casting int mengambil nilai double dari kolom total
    Tampilkan pesan error jika inputan salah dan total 0
    Deklarasi array of object row (kode,id,nomor,in,out dan total)
    Tambahkan kolom berdasarkan variable row
    Hasil = hasil + total
    menset variable total dengan hasil
     */
    public panel_tabel_transaksi() {
        try {
            initComponents();
            DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
            Statement stmt = con.createStatement();
            String select = "select * from detailTransaksi";
            double hasil = 0;
            ResultSet rset = stmt.executeQuery(select);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (rset.next()) {
                int kode = rset.getInt("kodeTransaksi");
                int id = rset.getInt("idPelanggan");
                int nomor = rset.getInt("nomorKamar");
                String in = sdf.format(rset.getDate("checkIn"));
                String out = "";
                int total = 0;
                try {
                    out = sdf.format(rset.getDate("checkOut"));
                    total = (int) rset.getDouble("total");
                } catch (NullPointerException a) {
                    out = "Belum CheckOut";
                    total = 0;
                }
                Object[] row = {kode, id, nomor, in, out, total};
                model.addRow(row);
                hasil = hasil + total;
            }
            total.setText(String.format("%.0f", hasil));
        } catch (SQLException ex) {
            Logger.getLogger(panel_tabel_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor. Kode generated dari sistem dan tidak bisa
     * diedit
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        label_tansaksi = new javax.swing.JLabel();
        buton_kalkulasi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        semua = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(660, 450));

        tabel_transaksi.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Transaksi", "ID Pelanggan", "Nomor Kamar", "Check In", "Check Out", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabel_transaksi);

        label_tansaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_tansaksi.setText("Data Transaksi");

        buton_kalkulasi.setText("Kalkulasi Pendapatan Bulan Ini");
        buton_kalkulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_kalkulasiActionPerformed(evt);
            }
        });

        jLabel1.setText("Total");

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        semua.setText("All");
        semua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buton_kalkulasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(semua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(label_tansaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66)))
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_tansaksi)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(semua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buton_kalkulasi)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Deklarasi button_kalkulasi sebagai penampil aksi dari tombol kalkulasi dengan parameter action event
    Coba 
    Deklarasi objek transaksi t
    Deklarasi double hasil dengan nilai memanggil method hasil bulanan
    Set text total dengan format "of " hasil
    Deklarasi DefaultTableModel model dengan nilai getModel dari table transaksi
    Model men set kolom dari 0
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Deklarasi String select dengan perintah memilih dari detailTransaksi
    Deklarasi Resultset rset untuk mengeksekusi queery berdasarkan variable select
    Deklarasi SimpleDateFormat sdf dengan format tanggal (hari/bulan/tahun)
    Deklarasi SimpleDateFormat sdf2 dengan format tanggal (bulan)
    Deklarasi objek Date now
    Deklarasi String bln dengan nilai format sdf2 berdasarkan tanggal sekarang
    Selama rset mengeksekusi
    Deklarasi String in dengan format sdf untuk mengambil tanggal checkIn
    Jika bln sama dengan format sdf2 maka
    Deklarasi int kode dengan mengambil nilai kodeTransaksi
    Deklarasi int id dengan mengambil nilai idPelanggan
    Deklarasi int nomor dengan mengambil nilai nomorKamar
    Deklarasi String out dengan nilai " "
    Deklarasi int total = 0
    Coba out mengambil tanggal checkout dengan format sdf(bulan)
    Total update nilai casting int double dari kolom total, jika salah atau pelanggan masih belum keluar panggil pesan error "belumCheckout"
    Deklarasi array of object row kolom (kode, id, nomor, in, out, total)
    Model table menambah kolom sesuai dengan row
    Tampilkan pesan error     */
    private void buton_kalkulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_kalkulasiActionPerformed
        try {
            Transaksi t = new Transaksi();
            double hasil = t.hasilBulanan();
            total.setText(String.format("%.0f", hasil));
            DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
            model.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
            Statement stmt = con.createStatement();
            String select = "select * from detailTransaksi";
            ResultSet rset = stmt.executeQuery(select);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
            Date now = new Date();
            String bln = sdf2.format(now);
            while (rset.next()) {
                String in = sdf.format(rset.getDate("checkIn"));
                if (bln.equalsIgnoreCase(sdf2.format(rset.getDate("checkIn")))) {
                    int kode = rset.getInt("kodeTransaksi");
                    int id = rset.getInt("idPelanggan");
                    int nomor = rset.getInt("nomorKamar");
                    String out = "";
                    int total = 0;
                    try {
                        out = sdf.format(rset.getDate("checkOut"));
                        total = (int) rset.getDouble("total");
                    } catch (NullPointerException a) {
                        out = "Belum CheckOut";
                        total = 0;
                    }
                    Object[] row = {kode, id, nomor, in, out, total};
                    model.addRow(row);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(panel_tabel_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buton_kalkulasiActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    /*
    Deklarasi method semuaActionPerformed untu menampilkan semua aksi
    Coba 
    Deklarasi DefaultTableModel model dengan nilai getModel dari table transaksi
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Deklarasi String select dengan perintah memilih dari detailTransaksi
    Deklarasi double hasil dengan nilai 0
    Deklarasi ResultSet rset untuk mengeksekusi query dengan perintah select
    Deklarasi SimpleDateFormat sdf (hari/bulan/tahun)
    Selama Eksekusi rset berjalan
    Deklarasi int kode dengan mengambil nilai dari database kolom kodeTransaksi
    Deklarasi int id dengan mengambil nilai dari database kolom idPelanggan
    Deklarasi int nomor dengan mengambil nilai dari database kolom nomoKamar
    Deklarasi String in dengan format sdf mengambil waktu dari kolom Checkin
    Deklarasi String out dengan nilai " "
    Deklarasi int total = 0
    Coba
    Out dengan format sdf mengambil waktu dari kolom checkOut
    Total casting int mengambil nilai double dari kolom total
    Tampilkan pesan error jika inputan salah dan total 0
    Deklarasi array of object row (kode,id,nomor,in,out dan total)
    Tambahkan kolom berdasarkan variable row
    Hasil = hasil + total
    Menset variable total dengan hasil
    Menampilkan pesan error apabila ada error 
    */
    private void semuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semuaActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
            model.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
            Statement stmt = con.createStatement();
            String select = "select * from detailTransaksi";
            double hasil = 0;
            ResultSet rset = stmt.executeQuery(select);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (rset.next()) {
                int kode = rset.getInt("kodeTransaksi");
                int id = rset.getInt("idPelanggan");
                int nomor = rset.getInt("nomorKamar");
                String in = sdf.format(rset.getDate("checkIn"));
                String out = "";
                int total = 0;
                try {
                    out = sdf.format(rset.getDate("checkOut"));
                    total = (int) rset.getDouble("total");
                } catch (NullPointerException a) {
                    out = "Belum CheckOut";
                    total = 0;
                }
                Object[] row = {kode, id, nomor, in, out, total};
                model.addRow(row);
                hasil = hasil + total;
            }
            total.setText(String.format("%.0f", hasil));
        } catch (SQLException ex) {
            Logger.getLogger(panel_tabel_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_semuaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(panel_tabel_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel_tabel_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel_tabel_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel_tabel_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel_tabel_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_kalkulasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label_tansaksi;
    private javax.swing.JButton semua;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
