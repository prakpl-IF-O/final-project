/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author ACER
 */
public class StaffFrame extends javax.swing.JFrame {

    /**
     * Creates new form StaffFrame
     */
    public StaffFrame() {
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

        lbOut1 = new javax.swing.JLabel();
        lbCheckOut = new javax.swing.JLabel();
        lbCheckIn = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Out.png"))); // NOI18N
        getContentPane().add(lbOut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 606, 90, 90));

        lbCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Tombol Check Out.png"))); // NOI18N
        getContentPane().add(lbCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 270, -1));

        lbCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Tombol Check In.png"))); // NOI18N
        getContentPane().add(lbCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 270, -1));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Background.jpg"))); // NOI18N
        getContentPane().add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

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
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCheckIn;
    private javax.swing.JLabel lbCheckOut;
    private javax.swing.JLabel lbOut1;
    // End of variables declaration//GEN-END:variables
}
