package Hotel;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class Hotel extends javax.swing.JFrame {

    Transaksi trx = new Transaksi();

    public Hotel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Baru = new javax.swing.JRadioButton();
        Lama = new javax.swing.JRadioButton();
        Nama = new javax.swing.JTextField();
        NIK = new javax.swing.JTextField();
        TTL = new javax.swing.JTextField();
        idPelanggan1 = new javax.swing.JTextField();
        Kelas = new javax.swing.JComboBox<>();
        Sewa = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();
        Bayar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idPelanggan2 = new javax.swing.JTextField();
        Denda = new javax.swing.JTextField();
        BayarDenda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Checkin = new javax.swing.JButton();
        Checkout = new javax.swing.JButton();
        Kamar = new javax.swing.JButton();
        Pelanggan = new javax.swing.JButton();
        Transaksi = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Mantap");
        setResizable(false);
        setSize(new java.awt.Dimension(50, 50));

        Baru.setText("Baru");
        Baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaruActionPerformed(evt);
            }
        });

        Lama.setText("Lama");
        Lama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamaActionPerformed(evt);
            }
        });

        Nama.setEnabled(false);

        NIK.setEnabled(false);

        TTL.setEnabled(false);

        idPelanggan1.setEnabled(false);

        Kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler (Rp 100.000,-)", "Premium (Rp 200.000,-)", "Suite (Rp 350.000,-)", "VIP (Rp 750.000,-)" }));
        Kelas.setSelectedIndex(-1);
        Kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KelasActionPerformed(evt);
            }
        });

        Sewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SewaActionPerformed(evt);
            }
        });

        Total.setEditable(false);
        Total.setToolTipText("Tekan \"ENTER\" pada \"Lama Sewa\" untuk mendapatkan nominal \"Total\"");

        jLabel1.setText("Nama");

        jLabel2.setText("NIK");

        jLabel3.setText("TTL");

        jLabel4.setText("ID Pelanggan");

        jLabel5.setText("Kelas");

        jLabel6.setText("Lama Sewa");

        jLabel7.setText("Total");

        jLabel8.setText("Bayar");

        jLabel9.setText("Pelanggan");

        jLabel10.setText("Hari");

        idPelanggan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPelanggan2ActionPerformed(evt);
            }
        });

        Denda.setEditable(false);
        Denda.setToolTipText("Tekan \"ENTER\" pada \"ID Pelanggan\" diatas untuk mendapatkan nominal \"Denda\"");

        BayarDenda.setEnabled(false);

        jLabel11.setText("ID Pelanggan");

        jLabel12.setText("Denda");

        jLabel13.setText("Bayar");

        Checkin.setText("Check In");
        Checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckinActionPerformed(evt);
            }
        });

        Checkout.setText("Check Out");
        Checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutActionPerformed(evt);
            }
        });

        Kamar.setText("Kamar");
        Kamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KamarActionPerformed(evt);
            }
        });

        Pelanggan.setText("Pelanggan");
        Pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PelangganActionPerformed(evt);
            }
        });

        Transaksi.setText("Transaksi");
        Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransaksiActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel14.setText("Tabel Record");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nama)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Baru)
                                .addGap(28, 28, 28)
                                .addComponent(Lama))
                            .addComponent(NIK)
                            .addComponent(TTL)
                            .addComponent(Kelas, 0, 285, Short.MAX_VALUE)
                            .addComponent(idPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Sewa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addComponent(Bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(Total))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BayarDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Denda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idPelanggan2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(Checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Kamar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Pelanggan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Transaksi)))))
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Baru)
                    .addComponent(Lama)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(idPelanggan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Denda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(BayarDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(Checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kamar)
                    .addComponent(Pelanggan)
                    .addComponent(Transaksi))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaruActionPerformed
        if (Baru.isSelected()) {
            Lama.setSelected(false);
            idPelanggan1.setEnabled(false);
            Nama.setEnabled(true);
            NIK.setEnabled(true);
            TTL.setEnabled(true);
        }
    }//GEN-LAST:event_BaruActionPerformed

    private void LamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamaActionPerformed
        if (Lama.isSelected()) {
            Baru.setSelected(false);
            idPelanggan1.setEnabled(true);
            Nama.setEnabled(false);
            NIK.setEnabled(false);
            TTL.setEnabled(false);
        }
    }//GEN-LAST:event_LamaActionPerformed

    private void KelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KelasActionPerformed
        String kelas = null;
        try {
            if (Kelas.getSelectedIndex() != -1) {
                switch (Kelas.getSelectedIndex()) {
                    case 0:kelas = "REGULER";break;
                    case 1:kelas = "PREMIUM";break;
                    case 2:kelas = "SUITE";break;
                    case 3:kelas = "VIP";break;
                    default:
                }
                trx.setKelas(kelas);
                if (idPelanggan1.isEnabled()) {
                    int idPelanggan = Integer.parseInt(idPelanggan1.getText());
                    trx.setIdPelanggan(idPelanggan);
                }
            }
        } catch (NumberFormatException error) {
        }
    }//GEN-LAST:event_KelasActionPerformed

    private void CheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckinActionPerformed
        try {
            double bayar = Double.parseDouble(Bayar.getText());
            double kembali = bayar - trx.getTotal();
            boolean check = false;
            if (bayar >= trx.getTotal()) {
                if (Baru.isSelected()) {
                    trx.setNama(Nama.getText());
                    trx.setNik(NIK.getText());
                    trx.setTtl(TTL.getText());
                    check = trx.checkInBaru();
                } else if (Lama.isSelected()) {
                    trx.setNama(trx.getNama());
                    trx.setNik(trx.getNik());
                    check = trx.checkInLama();
                }
                if (check == true) {
                    JOptionPane.showMessageDialog(rootPane, trx.detailTransaksi(bayar, kembali), "Detail Transaksi", PLAIN_MESSAGE);
                    clearField();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Kelas kamar yang dipesan telah penuh, silahkan pilih kelas kamar yang lain", "Check In gagal", PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Uang yang dibayar kurang dari total bayar, mohon ulangi", "Transaksi gagal", PLAIN_MESSAGE);
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(rootPane, "Transaksi gagal, mohon coba lagi", "Transaksi gagal", PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_CheckinActionPerformed

    private void CheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutActionPerformed
        try {
            int idPelanggan = Integer.parseInt(idPelanggan2.getText());
            double bayarDenda = Double.parseDouble(BayarDenda.getText());
            double kembali = bayarDenda - trx.denda();
            if (trx.denda() != 0) {
                if (bayarDenda - trx.denda() >= 0) {
                    trx.updateTransaksi("CHECKOUT(DENDA)", trx.denda());
                    String message = String.format("---Check Out sukses---\nNama : %s\nID Pelanggan : %d\nNo Kamar : %d\n\nDenda : Rp %.2f\nBayar : Rp %.2f\nKembali : Rp %.2f", trx.getNama(), trx.getIdPelanggan(), trx.getNoKamar(trx.getIdPelanggan()), trx.denda(), bayarDenda, kembali);
                    trx.outKamar(idPelanggan);
                    JOptionPane.showMessageDialog(rootPane, message, "Check Out", PLAIN_MESSAGE);
                    clearField();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Uang yang dibayar kurang dari total bayar, mohon ulangi", "Transaksi gagal", PLAIN_MESSAGE);
                }
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(rootPane, "Check Out gagal, mohon coba lagi", "Check Out gagal", PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_CheckoutActionPerformed

    private void idPelanggan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPelanggan2ActionPerformed
        try {
            int idPelanggan = Integer.parseInt(idPelanggan2.getText());
            trx.setIdPelanggan(idPelanggan);
            String denda = Double.toString(trx.denda());
            Denda.setText(denda);
            if (trx.denda() != 0) {
                BayarDenda.setEnabled(true);
            }
        } catch (NumberFormatException error) {
        }
    }//GEN-LAST:event_idPelanggan2ActionPerformed

    private void SewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SewaActionPerformed
        try {
            trx.setSewa(Integer.parseInt(Sewa.getText()));
            if (idPelanggan1.isEnabled()) {
                trx.setTotal((trx.getHarga() - trx.diskon()) * trx.getSewa());
            } else {
                trx.setTotal(trx.getHarga() * trx.getSewa());
            }
            Total.setText(Double.toString(trx.getTotal()));
        } catch (NumberFormatException error) {
        }
    }//GEN-LAST:event_SewaActionPerformed

    private void KamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KamarActionPerformed
        TabelKamar tabelk = new TabelKamar();
        tabelk.tabelKamar();
        tabelk.setVisible(true);
    }//GEN-LAST:event_KamarActionPerformed

    private void PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PelangganActionPerformed
        TabelPelanggan tabelp = new TabelPelanggan();
        tabelp.tabelPelanggan();
        tabelp.setVisible(true);
    }//GEN-LAST:event_PelangganActionPerformed

    private void TransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransaksiActionPerformed
        TabelTransaksi tabelt = new TabelTransaksi();
        tabelt.tabelTransaksi();
        tabelt.setVisible(true);
    }//GEN-LAST:event_TransaksiActionPerformed

    private void clearField() {
        Nama.setText(null);
        NIK.setText(null);
        TTL.setText(null);
        idPelanggan1.setText(null);
        Kelas.setSelectedIndex(-1);
        Sewa.setText(null);
        Total.setText(null);
        Bayar.setText(null);
        idPelanggan2.setText(null);
        Denda.setText(null);
        BayarDenda.setText(null);
        trx.setIdPelanggan(0);
        trx.setNama(null);
        trx.setNik(null);
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Baru;
    private javax.swing.JTextField Bayar;
    private javax.swing.JTextField BayarDenda;
    private javax.swing.JButton Checkin;
    private javax.swing.JButton Checkout;
    private javax.swing.JTextField Denda;
    private javax.swing.JButton Kamar;
    private javax.swing.JComboBox<String> Kelas;
    private javax.swing.JRadioButton Lama;
    private javax.swing.JTextField NIK;
    private javax.swing.JTextField Nama;
    private javax.swing.JButton Pelanggan;
    private javax.swing.JTextField Sewa;
    private javax.swing.JTextField TTL;
    private javax.swing.JTextField Total;
    private javax.swing.JButton Transaksi;
    private javax.swing.JTextField idPelanggan1;
    private javax.swing.JTextField idPelanggan2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
