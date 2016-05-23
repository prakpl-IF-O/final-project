/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ltf
 */
public class panel_new extends javax.swing.JFrame {

    /**
     * Creates new form panel_new
     */
    public panel_new() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2_hari = new javax.swing.JLabel();
        textfield_lama_menginap_in = new javax.swing.JTextField();
        label_lamabermalam = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();
        label_nik = new javax.swing.JLabel();
        label_tempat_lahir = new javax.swing.JLabel();
        label_tanggal_lahir = new javax.swing.JLabel();
        label_pilih_jenis_kamar = new javax.swing.JLabel();
        ComboBox_pilihkamar = new javax.swing.JComboBox();
        textfield_nama = new javax.swing.JTextField();
        textfield_nik = new javax.swing.JTextField();
        textfield_tempat_lahir = new javax.swing.JTextField();
        textfield_tanggal_lahir = new javax.swing.JTextField();
        button_submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        button_cancel = new javax.swing.JButton();
        textfield_no_kamar = new javax.swing.JTextField();
        label_no_kamar = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2_hari.setText("Hari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        getContentPane().add(jLabel2_hari, gridBagConstraints);

        textfield_lama_menginap_in.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 30, 0, 0);
        getContentPane().add(textfield_lama_menginap_in, gridBagConstraints);

        label_lamabermalam.setText("Lama Bermalam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 0, 0);
        getContentPane().add(label_lamabermalam, gridBagConstraints);

        label_nama.setText("Nama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 45;
        gridBagConstraints.ipadx = 713;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 140, 0, 0);
        getContentPane().add(label_nama, gridBagConstraints);

        label_nik.setText("NIK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 601;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 140, 0, 0);
        getContentPane().add(label_nik, gridBagConstraints);

        label_tempat_lahir.setText("Tempat Lahir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.ipadx = 601;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 140, 0, 0);
        getContentPane().add(label_tempat_lahir, gridBagConstraints);

        label_tanggal_lahir.setText("Tanggal Lahir (dd/mm/yyyy)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 34;
        gridBagConstraints.ipadx = 601;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 140, 0, 0);
        getContentPane().add(label_tanggal_lahir, gridBagConstraints);

        label_pilih_jenis_kamar.setText("Jenis Kamar ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 140, 0, 0);
        getContentPane().add(label_pilih_jenis_kamar, gridBagConstraints);

        ComboBox_pilihkamar.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"VIP", "Suite", "Premium", "Reguler" }));
        ComboBox_pilihkamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_pilihkamarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 122;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 140, 0, 0);
        getContentPane().add(ComboBox_pilihkamar, gridBagConstraints);

        textfield_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_namaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 45;
        gridBagConstraints.ipadx = 734;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 140, 0, 0);
        getContentPane().add(textfield_nama, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 45;
        gridBagConstraints.ipadx = 734;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 140, 0, 0);
        getContentPane().add(textfield_nik, gridBagConstraints);

        textfield_tempat_lahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_tempat_lahirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 45;
        gridBagConstraints.ipadx = 734;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 140, 0, 0);
        getContentPane().add(textfield_tempat_lahir, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 45;
        gridBagConstraints.ipadx = 734;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 140, 0, 0);
        getContentPane().add(textfield_tanggal_lahir, gridBagConstraints);

        button_submit.setText("Submit");
        button_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_submitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 35;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 160, 0, 0);
        getContentPane().add(button_submit, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Member Baru HOTEL MANTAB");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.ipadx = 201;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 200, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        button_cancel.setText("Cancel");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 150, 0, 0);
        getContentPane().add(button_cancel, gridBagConstraints);

        textfield_no_kamar.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        getContentPane().add(textfield_no_kamar, gridBagConstraints);

        label_no_kamar.setText("No Kamar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        getContentPane().add(label_no_kamar, gridBagConstraints);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hotel/Untitled-1.jpg"))); // NOI18N
        background.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 46;
        gridBagConstraints.gridheight = 13;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 130, 19, 113);
        getContentPane().add(background, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBox_pilihkamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_pilihkamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_pilihkamarActionPerformed

    private void textfield_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_namaActionPerformed

    private void textfield_tempat_lahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_tempat_lahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_tempat_lahirActionPerformed
    int cek = 0;
    Pelanggan p = new Pelanggan();
    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_submitActionPerformed
        Object select = ComboBox_pilihkamar.getSelectedItem();
        String nama, tempatlahir, tanggallahir, nik;
        int noKamar, hari;
        Transaksi t;
        Kamar k;
        try {
            if (cek == 0) {
                nik = textfield_nik.getText();
                nama = textfield_nama.getText();
                tanggallahir = textfield_tanggal_lahir.getText();
                tempatlahir = textfield_tempat_lahir.getText();
                try {
                    p = new Pelanggan(nik, nama, tempatlahir, tanggallahir);
                    cek = 1;
                    String data = String.format("Pelanggan Terdaftar\n%s\nPilih Kelas Kamar, Nomor Kamar, dan Lama Bermalam\nKemudian"
                            + " Klik Summit", p);
                    JOptionPane.showMessageDialog(this, data);
                    textfield_lama_menginap_in.setEditable(true);
                    textfield_no_kamar.setEditable(true);
                } catch (SQLException ex) {
                    Logger.getLogger(panel_new.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                noKamar = Integer.valueOf(textfield_no_kamar.getText());
                hari = Integer.valueOf(textfield_lama_menginap_in.getText());
                k = new Kamar();
                boolean checkKamar = false;
                try {
                    k.retrieveData(noKamar);
                    checkKamar = k.checkKamar(k.getNoKamar());
                } catch (SQLException ex) {
                    Logger.getLogger(panel_new.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (checkKamar == false) {
                    if (select == "VIP") {
                        if (noKamar < 91 || noKamar > 100) {
                            JOptionPane.showMessageDialog(this, "Kamar VIP no 91-100");
                            textfield_no_kamar.setText("");
                        } else {
                            try {
                                t = new Transaksi(hari, p, k);
                                String data = String.format("Berhasil Check In\n%s", t);
                                JOptionPane.showMessageDialog(this, data);
                                clear();
                            } catch (SQLException ex) {
                                Logger.getLogger(panel_new.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (select == "Suite") {
                        if (noKamar < 71 || noKamar > 90) {
                            JOptionPane.showMessageDialog(this, "Kamar Suite no 71-90");
                            textfield_no_kamar.setText("");
                        } else {
                            try {
                                t = new Transaksi(hari, p, k);
                                String data = String.format("Berhasil Check In\n%s", t);
                                JOptionPane.showMessageDialog(this, data);
                                clear();
                            } catch (SQLException ex) {
                                Logger.getLogger(panel_new.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (select == "Premium") {
                        if (noKamar < 51 || noKamar > 70) {
                            JOptionPane.showMessageDialog(this, "Kamar VIP no 51-70");
                            textfield_no_kamar.setText("");
                        } else {
                            try {
                                t = new Transaksi(hari, p, k);
                                String data = String.format("Berhasil Check In\n%s", t);
                                JOptionPane.showMessageDialog(this, data);
                                clear();
                            } catch (SQLException ex) {
                                Logger.getLogger(panel_new.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (select == "Reguler") {
                        if (noKamar < 1 || noKamar > 50) {
                            JOptionPane.showMessageDialog(this, "Kamar VIP no 1-50");
                            textfield_no_kamar.setText("");
                        } else {
                            try {
                                t = new Transaksi(hari, p, k);
                                String data = String.format("Berhasil Check In\n%s", t);
                                JOptionPane.showMessageDialog(this, data);
                                clear();
                            } catch (SQLException ex) {
                                Logger.getLogger(panel_new.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Kamar Tersewa");
                }
            }
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(this, "Isi Semua kotak sesuai format");
        } catch (NullPointerException a) {
            JOptionPane.showMessageDialog(this, "Isi Semua kotak sesuai format");
        }
    }//GEN-LAST:event_button_submitActionPerformed

    public void clear() {
        cek = 0;
        textfield_nama.setText("");
        textfield_nik.setText("");
        textfield_no_kamar.setText("");
        textfield_tanggal_lahir.setText("");
        textfield_tempat_lahir.setText("");
        textfield_lama_menginap_in.setText("");
        textfield_lama_menginap_in.setEditable(false);
        textfield_no_kamar.setEditable(false);
    }
    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_button_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(panel_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel_new().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox_pilihkamar;
    private javax.swing.JLabel background;
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2_hari;
    private javax.swing.JLabel label_lamabermalam;
    private javax.swing.JLabel label_nama;
    private javax.swing.JLabel label_nik;
    private javax.swing.JLabel label_no_kamar;
    private javax.swing.JLabel label_pilih_jenis_kamar;
    private javax.swing.JLabel label_tanggal_lahir;
    private javax.swing.JLabel label_tempat_lahir;
    private javax.swing.JTextField textfield_lama_menginap_in;
    private javax.swing.JTextField textfield_nama;
    private javax.swing.JTextField textfield_nik;
    private javax.swing.JTextField textfield_no_kamar;
    private javax.swing.JTextField textfield_tanggal_lahir;
    private javax.swing.JTextField textfield_tempat_lahir;
    // End of variables declaration//GEN-END:variables
}
