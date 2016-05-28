//Package Hotel adalah package dari class/form panel_tabel_id
package Hotel;

/*
Import atau memasukkan fungsi Database sql ke dalam class
Import atau memasukkan fungsi Perubah format tanggal
Memasukkan fungsi tergenerated logging level untuk menentukan set standar dalam mengendalikan output logging utility
Memasukkan fungsi tergenerated logging logger untuk melakukan loging pesan log dari sistem atau komponen aplikasi hotel
Memasukkan fungsi table
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

//fungsi dari class ini adalah sebagai tabel id yang tergambar oleh gui
//@author ltf
//Deklarasi class atau form panel_table_id, yang berfungsi untuk table dan memanajemen isinya, class ini merupakan gui jframe maka menjadi turunan swing jframe
public class panel_tabel_id extends javax.swing.JFrame {

    /*
    Deklarasi constructor panel_tabel_id
    Coba
    initComponent merupakan method yg saat membuat jframe tergenerate otomatis, karena fungsinya sebagai instalator komponen gui dan menghubungkan ke class
    Deklarasi DefaultTabelModel model untuk membuat model tabel dengan nilai mengambil model table_id
    Connection con pada badan memiliki fungsi untuk menghubungkan class ke database
    Statement stmt pada badan adalah variable stmt memiliki fungsi untuk menjalankan perintah database mySql
    Deklarasi String select dengan perintah memilih dari pelanggan
    Deklarasi ResultSet rset untuk mengeksekusi query dari perintah select
    Deklarasi format tanggal hari/bulan/tahun
    Selama rset berjalan
    Mengambil nilai (id,nik,nama,tgldaftar dan akumulasi)
    Membuat kolom (id,nik,nama,tgl,akumulasi)
    Menambahkan kolom berdasarkan yang dibuat
    Tampilkan pesan error jika ada kesalahan
     */
    public panel_tabel_id() {
        try {
            initComponents();
            DefaultTableModel model = (DefaultTableModel) tabel_id.getModel();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
            Statement stmt = con.createStatement();
            String select = "select * from pelanggan";
            ResultSet rset = stmt.executeQuery(select);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (rset.next()) {
                int id = rset.getInt("id");
                String nik = rset.getString("nik");
                String nama = rset.getString("nama");
                String tgl = sdf.format(rset.getDate("tglDaftar"));
                int akumulasi = rset.getInt("akumulasi");
                Object[] row = {id, nik, nama, tgl, akumulasi};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(panel_tabel_id.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_id = new javax.swing.JTable();
        label_tansaksi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(660, 500));

        tabel_id.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tabel_id.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIK", "Nama", "Tanggal Daftar", "Akumulasi"
            }
        ));
        jScrollPane1.setViewportView(tabel_id);

        label_tansaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_tansaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_tansaksi.setText("Daftar ID Pelanggan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(label_tansaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(158, 158, 158))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_tansaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(panel_tabel_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel_tabel_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel_tabel_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel_tabel_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel_tabel_id().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_tansaksi;
    private javax.swing.JTable tabel_id;
    // End of variables declaration//GEN-END:variables
}
