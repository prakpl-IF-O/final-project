/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

/**
 *
 * @author ltf
 */
public class panel_member extends javax.swing.JFrame {

    /**
     * Creates new form panel_member
     */
    public panel_member() {
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
        ComboBox_pilihkamar = new javax.swing.JComboBox();
        textfield_lama_menginap_in = new javax.swing.JTextField();
        textfield_no_kamar = new javax.swing.JTextField();
        label_no_kamar = new javax.swing.JLabel();
        label_pilih_jenis_kamar = new javax.swing.JLabel();
        label_id_member = new javax.swing.JLabel();
        textfield_id = new javax.swing.JTextField();
        button_submit_member = new javax.swing.JButton();
        button_cancel_member = new javax.swing.JButton();
        label_lamabermalam = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2_hari.setText("Hari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        getContentPane().add(jLabel2_hari, gridBagConstraints);

        ComboBox_pilihkamar.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"VIP", "Suite", "Premium", "Reguler" }));
        ComboBox_pilihkamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_pilihkamarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 430, 0, 0);
        getContentPane().add(ComboBox_pilihkamar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 27, 0, 0);
        getContentPane().add(textfield_lama_menginap_in, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 430, 0, 0);
        getContentPane().add(textfield_no_kamar, gridBagConstraints);

        label_no_kamar.setText("No Kamar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 430, 0, 0);
        getContentPane().add(label_no_kamar, gridBagConstraints);

        label_pilih_jenis_kamar.setText("Jenis Kamar ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 430, 0, 0);
        getContentPane().add(label_pilih_jenis_kamar, gridBagConstraints);

        label_id_member.setText("Masukan Id Member");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(130, 430, 0, 0);
        getContentPane().add(label_id_member, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.ipadx = 214;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 430, 0, 0);
        getContentPane().add(textfield_id, gridBagConstraints);

        button_submit_member.setText("Submit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        getContentPane().add(button_submit_member, gridBagConstraints);

        button_cancel_member.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 430, 0, 0);
        getContentPane().add(button_cancel_member, gridBagConstraints);

        label_lamabermalam.setText("Lama Bermalam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        getContentPane().add(label_lamabermalam, gridBagConstraints);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hotel/Untitled-3.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(background, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBox_pilihkamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_pilihkamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_pilihkamarActionPerformed

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
            java.util.logging.Logger.getLogger(panel_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel_member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox_pilihkamar;
    private javax.swing.JLabel background;
    private javax.swing.JButton button_cancel_member;
    private javax.swing.JButton button_submit_member;
    private javax.swing.JLabel jLabel2_hari;
    private javax.swing.JLabel label_id_member;
    private javax.swing.JLabel label_lamabermalam;
    private javax.swing.JLabel label_no_kamar;
    private javax.swing.JLabel label_pilih_jenis_kamar;
    private javax.swing.JTextField textfield_id;
    private javax.swing.JTextField textfield_lama_menginap_in;
    private javax.swing.JTextField textfield_no_kamar;
    // End of variables declaration//GEN-END:variables
}
