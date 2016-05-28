/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.project.akhir;

/**
 *
 * @author ENGGAR PRATAMA , DWI PRIYANTO , ANDI ROSADI
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UI extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * membuat method user interface
     */
    public UI() {
        initComponents();
        conn = ConnectionSql.ConnectDBS();
        updateTable();
        updateTable2();

    }
     /**
     *membuat method untuk mengambil waktu dari kalender
     */
    public String waktuIn() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        String a = sdf.format(cal.getTime());
        return a;
    }
     /**
     *membuat method untuk mengupdate data di sql
     */
    public void updateTable2() {
        try {
            String sql = "select * from data_pengunjung";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            FTable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     /**
     *membuat method untuk mengubah database dan mengetahui kosong kamar
     */
    public void updateTable() {
        try {
            String sql = "select NoKamar,KelasKamar,Harga,Status from data_kamar where Status = 'Kosong'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            FTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     /**
     *membuat method untuk mengosongkan data pengunjung
     */
    public void tombolRefresh() {
        FNo.setText("");
        FKelas.setText("");
        FNama.setText("");
        FId.setText("");
        FTempat.setText("");
        FTanggal.setDate(null);
        FNIK.setText("");
        FIn.setDate(null);
        FInap.setText("");
        FStatus.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        FLahir = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        FKelas = new javax.swing.JTextField();
        FStatus = new javax.swing.JTextField();
        FNo = new javax.swing.JTextField();
        FCari = new javax.swing.JTextField();
        FNIK = new javax.swing.JTextField();
        FTempat = new javax.swing.JTextField();
        FNama = new javax.swing.JTextField();
        FId = new javax.swing.JTextField();
        FInap = new javax.swing.JTextField();
        FTanggal = new com.toedter.calendar.JDateChooser();
        FIn = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        FTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        FTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        FInap1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bebas", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DAFTAR   KAMAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 30));

        jLabel3.setFont(new java.awt.Font("Bebas", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RESERVASI");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        jLabel4.setFont(new java.awt.Font("Bebas", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DETAIL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 90, 30));

        jLabel5.setFont(new java.awt.Font("Bebas", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CARI   KAMAR");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 90, 30));

        jLabel6.setFont(new java.awt.Font("Bebas", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TRANSAKSI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 90, 30));

        jLabel8.setFont(new java.awt.Font("Bebas", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("BIODATA");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 90, 30));

        jLabel9.setFont(new java.awt.Font("Bebas", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("KAMAR");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 30));

        FLahir.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        FLahir.setForeground(new java.awt.Color(255, 255, 255));
        FLahir.setText("TANGGAL LAHIR");
        getContentPane().add(FLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 170, 30));

        jLabel11.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("KELAS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 80, 30));

        jLabel12.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("status");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 80, 30));

        jLabel13.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NO KAMAR");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 130, 30));

        jLabel15.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("NIK");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 80, 30));

        jLabel16.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TEMPAT LAHIR");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 160, 30));

        jLabel17.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("NAMA");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 80, 30));

        jLabel18.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ID");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 80, 30));

        jLabel19.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("LAMA INAP");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 130, 30));
        getContentPane().add(FKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 140, 30));

        FStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FStatusActionPerformed(evt);
            }
        });
        getContentPane().add(FStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 140, 30));

        FNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNoActionPerformed(evt);
            }
        });
        getContentPane().add(FNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 140, 30));

        FCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FCariActionPerformed(evt);
            }
        });
        FCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FCariKeyReleased(evt);
            }
        });
        getContentPane().add(FCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 200, 50));
        getContentPane().add(FNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 140, 30));

        FTempat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FTempatActionPerformed(evt);
            }
        });
        getContentPane().add(FTempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 140, 30));
        getContentPane().add(FNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 140, 30));
        getContentPane().add(FId, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 140, 30));
        getContentPane().add(FInap, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 140, 30));
        getContentPane().add(FTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 140, 30));
        getContentPane().add(FIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 140, 30));

        FTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(FTable2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 970, 90));

        FTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        FTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(FTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 480, 130));

        jLabel21.setFont(new java.awt.Font("Bebas Neue Book", 0, 21)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CHECK IN");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 110, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/project/akhir/1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/project/akhir/2.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/project/akhir/3.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/project/akhir/4.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/project/akhir/a.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 700));
        getContentPane().add(FInap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNoActionPerformed

    private void FStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FStatusActionPerformed

    private void FTempatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FTempatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FTempatActionPerformed

    private void FCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FCariActionPerformed
     /**
     *membuat method untuk pada saat tabel di klick
     */
    private void FTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FTable1MouseClicked
      
        try {
            int row = FTable1.getSelectedRow();
            String table_click = (FTable1.getModel().getValueAt(row, 0).toString());
            String sql = "select * from data_kamar where NoKamar='" + table_click + "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("NoKamar");
                FNo.setText(add1);
                String add2 = rs.getString("KelasKamar");
                FKelas.setText(add2);
                String add3 = rs.getString("Status");
                FStatus.setText(add3);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_FTable1MouseClicked
     /**
     *membuat method untuk mencari kamar yang kosong
     */
    private void FCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FCariKeyReleased

        // TODO add your handling code here:
        if (FCari.getText().equalsIgnoreCase("")) {
            this.updateTable();
        } else {

            try {
                String sql = "select * from data_kamar where KelasKamar =? and Status=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, FCari.getText());
                ps.setString(2, "Kosong");
                rs = ps.executeQuery();
                FTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }//GEN-LAST:event_FCariKeyReleased
     /**
     *membuat method untuk memproses tabel dan isinya
     */
    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        java.util.Date tanggalLahir = (java.util.Date) this.FTanggal.getDate();
        java.util.Date tanggalIn = (java.util.Date) this.FIn.getDate();

        try {

            String sql2 = "UPDATE data_kamar SET Status = 'Isi' WHERE data_kamar.NoKamar ='" + FNo.getText() + "'";
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            String sql = "insert into data_pengunjung (Kamar, Nama, NIK, TempatLahir, TanggalLahir,ID, LamaInap, CheckIn, JamIn) values (?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, FNo.getText());
            ps.setString(2, FNama.getText());
            ps.setString(3, FNIK.getText());
            ps.setString(4, FTempat.getText());
            ps.setDate(5, new java.sql.Date(tanggalLahir.getTime()));
            ps.setString(6, FId.getText());
            ps.setString(7, FInap.getText());
            ps.setDate(8, new java.sql.Date(tanggalIn.getTime()));
            ps.setString(9, waktuIn());
            ps.execute();
            //backup
            String sql3 = "insert into arsip_pelanggan (NoKamar,KelasKamar,Nama,NIK,TempatLahir,TanggalLahir,ID,CheckIn,JamIn) values (?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql3);
            ps.setString(1, FNo.getText());
            ps.setString(2, FKelas.getText());
            ps.setString(3, FNama.getText());
            ps.setString(4, FNIK.getText());
            ps.setString(5, FTempat.getText());
            ps.setDate(6, new java.sql.Date(tanggalLahir.getTime()));
            ps.setString(7, FId.getText());
            ps.setDate(8, new java.sql.Date(tanggalIn.getTime()));
            ps.setString(9, waktuIn());
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        updateTable();
        updateTable2();
    }//GEN-LAST:event_jLabel14MouseClicked
     /**
     *method untuk merefresh data
     */
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        tombolRefresh();
    }//GEN-LAST:event_jLabel7MouseClicked
     /**
     *membuat method untuk mengambil nilai ketika di klick
     */
    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        int gen = (int) Math.random() * 10000;
        String rate = Integer.toString((int) (Math.random() * 10000));
        FId.setText(rate);

    }//GEN-LAST:event_jLabel22MouseClicked
     /**
     *membuar method untuk keluar dari login
     */
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        dispose();
        LOGIN out = new LOGIN();
        out.show();
    }//GEN-LAST:event_jLabel23MouseClicked

    /**
     * 
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FCari;
    private javax.swing.JTextField FId;
    private com.toedter.calendar.JDateChooser FIn;
    private javax.swing.JTextField FInap;
    private javax.swing.JTextField FInap1;
    private javax.swing.JTextField FKelas;
    private javax.swing.JLabel FLahir;
    private javax.swing.JTextField FNIK;
    private javax.swing.JTextField FNama;
    private javax.swing.JTextField FNo;
    private javax.swing.JTextField FStatus;
    private javax.swing.JTable FTable1;
    private javax.swing.JTable FTable2;
    private com.toedter.calendar.JDateChooser FTanggal;
    private javax.swing.JTextField FTempat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
