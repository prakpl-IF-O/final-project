/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author gunka
 */
public class MenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form MenuFrame
     */
    public MenuFrame() {
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

        wrongIconPass = new javax.swing.JLabel();
        wrongIconUsername = new javax.swing.JLabel();
        trueIconUsername = new javax.swing.JLabel();
        trueIconPass = new javax.swing.JLabel();
        staffMini = new javax.swing.JLabel();
        staffLogin = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        labelUsername = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        labelStaff = new javax.swing.JLabel();
        labelManager = new javax.swing.JLabel();
        labelLoginAwal = new javax.swing.JLabel();
        managerLogin = new javax.swing.JLabel();
        managerMini = new javax.swing.JLabel();
        loginBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wrongIconPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/wrong icon mini.png"))); // NOI18N
        getContentPane().add(wrongIconPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, 40));

        wrongIconUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/wrong icon mini.png"))); // NOI18N
        getContentPane().add(wrongIconUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, 40));

        trueIconUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/true icon mini2.png"))); // NOI18N
        getContentPane().add(trueIconUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, 40));

        trueIconPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/true icon mini2.png"))); // NOI18N
        getContentPane().add(trueIconPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, 40));

        staffMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Staff mini.png"))); // NOI18N
        getContentPane().add(staffMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 100, 110));

        staffLogin.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        staffLogin.setForeground(new java.awt.Color(255, 255, 255));
        staffLogin.setText("STAFF LOGIN");
        getContentPane().add(staffLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        btnLogin.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnLogin.setText("LOGIN");
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 100, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 240, 40));

        passField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 240, 40));

        labelUsername.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(255, 255, 255));
        labelUsername.setText("USERNAME");
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 120, 30));

        labelPass.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelPass.setForeground(new java.awt.Color(255, 255, 255));
        labelPass.setText("PASSWORD");
        getContentPane().add(labelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 120, 30));

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/exit button mini.png"))); // NOI18N
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 30, 40));

        labelLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Panel Login.png"))); // NOI18N
        getContentPane().add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, -10, 530, 390));

        labelStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Staff.png"))); // NOI18N
        getContentPane().add(labelStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 200, 200));

        labelManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Manager.png"))); // NOI18N
        getContentPane().add(labelManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 180));

        labelLoginAwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Panel Pilihan.png"))); // NOI18N
        getContentPane().add(labelLoginAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 590, -1));

        managerLogin.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        managerLogin.setForeground(new java.awt.Color(255, 255, 255));
        managerLogin.setText("MANAGER LOGIN");
        getContentPane().add(managerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        managerMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Manager mini.png"))); // NOI18N
        getContentPane().add(managerMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 110, 100));

        loginBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/BackgroundPolos.jpg"))); // NOI18N
        getContentPane().add(loginBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelLoginAwal;
    private javax.swing.JLabel labelManager;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelStaff;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel loginBackground;
    private javax.swing.JLabel managerLogin;
    private javax.swing.JLabel managerMini;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel staffLogin;
    private javax.swing.JLabel staffMini;
    private javax.swing.JLabel trueIconPass;
    private javax.swing.JLabel trueIconUsername;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel wrongIconPass;
    private javax.swing.JLabel wrongIconUsername;
    // End of variables declaration//GEN-END:variables
}
