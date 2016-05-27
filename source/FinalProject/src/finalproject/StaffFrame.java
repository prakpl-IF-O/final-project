package finalproject;

import java.sql.SQLException; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class StaffFrame extends javax.swing.JFrame {
    
    String jenisKamar;
    String NIK;
    public StaffFrame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHarga5 = new javax.swing.JTextField();
        txtSub = new javax.swing.JTextField();
        txtDiskon = new javax.swing.JTextField();
        txtDenda = new javax.swing.JTextField();
        txtTot = new javax.swing.JTextField();
        lbDataPem = new javax.swing.JLabel();
        lbHarga1 = new javax.swing.JLabel();
        lbSubTot = new javax.swing.JLabel();
        lbDiskon = new javax.swing.JLabel();
        lbDenda = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        panelHCO = new javax.swing.JLabel();
        lbDataPel2 = new javax.swing.JLabel();
        lbTombolCheckOut = new javax.swing.JLabel();
        txtTTL2 = new javax.swing.JTextField();
        lbTTL1 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        Jenis = new javax.swing.JLabel();
        txtLama2 = new javax.swing.JTextField();
        lbLama1 = new javax.swing.JLabel();
        txtTanggalCI = new javax.swing.JTextField();
        lbTanggalCI = new javax.swing.JLabel();
        txtNama3 = new javax.swing.JTextField();
        lbNama7 = new javax.swing.JLabel();
        txtNoKamar2 = new javax.swing.JTextField();
        lbNoKamar2 = new javax.swing.JLabel();
        txtID3 = new javax.swing.JTextField();
        lbID3 = new javax.swing.JLabel();
        txtNIK3 = new javax.swing.JTextField();
        lbNIK3 = new javax.swing.JLabel();
        panelCOb = new javax.swing.JLabel();
        lbID1 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        lbNama1 = new javax.swing.JLabel();
        txtNama1 = new javax.swing.JTextField();
        lbNIK1 = new javax.swing.JLabel();
        txtNIK1 = new javax.swing.JTextField();
        lbTombolCheck = new javax.swing.JLabel();
        lbKetCek = new javax.swing.JLabel();
        panelCO = new javax.swing.JLabel();
        lbDataPel = new javax.swing.JLabel();
        lbNIK = new javax.swing.JLabel();
        lbNama = new javax.swing.JLabel();
        lbTTL = new javax.swing.JLabel();
        lbLama = new javax.swing.JLabel();
        lbJenis = new javax.swing.JLabel();
        lbHarga = new javax.swing.JLabel();
        lbTombolCI = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        cbJenis = new javax.swing.JComboBox();
        txtLama = new javax.swing.JTextField();
        txtTTL = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtNIK = new javax.swing.JTextField();
        txtNoKamar = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        lbNoKamar = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        panelCI = new javax.swing.JLabel();
        lbOut1 = new javax.swing.JLabel();
        lbCheckOut = new javax.swing.JLabel();
        lbCheckIn = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHarga5.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtHarga5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtHarga5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 370, 50));

        txtSub.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtSub.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 370, 50));

        txtDiskon.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtDiskon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 370, 50));

        txtDenda.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtDenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 370, 50));

        txtTot.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtTot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 370, 50));

        lbDataPem.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbDataPem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDataPem.setText("DATA PEMBAYARAN ");
        getContentPane().add(lbDataPem, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 340, 70));

        lbHarga1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbHarga1.setText("Harga Kamar");
        getContentPane().add(lbHarga1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 180, 70));

        lbSubTot.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbSubTot.setText("Sub Total");
        getContentPane().add(lbSubTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, 70));

        lbDiskon.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbDiskon.setText("Diskon");
        getContentPane().add(lbDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 180, 70));

        lbDenda.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbDenda.setText("Denda");
        getContentPane().add(lbDenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 180, 70));

        lbTotal.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbTotal.setText("Total");
        getContentPane().add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 180, 70));

        panelHCO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Panel.jpg"))); // NOI18N
        getContentPane().add(panelHCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1110, 770));

        lbDataPel2.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbDataPel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDataPel2.setText("DATA PELANGGAN ");
        getContentPane().add(lbDataPel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 310, 70));

        lbTombolCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Check Out.png"))); // NOI18N
        getContentPane().add(lbTombolCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, -1, 100));

        txtTTL2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtTTL2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTTL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 370, 50));

        lbTTL1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbTTL1.setText("Tempat, Tanggal Lahir");
        getContentPane().add(lbTTL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 280, 70));

        txtJenis.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtJenis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 370, 50));

        Jenis.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        Jenis.setText("Jenis Kamar");
        getContentPane().add(Jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 180, 70));

        txtLama2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtLama2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtLama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 370, 50));

        lbLama1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbLama1.setText("Lama Menginap");
        getContentPane().add(lbLama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 180, 70));

        txtTanggalCI.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtTanggalCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTanggalCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 370, 50));

        lbTanggalCI.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbTanggalCI.setText("Tanggal Check In");
        getContentPane().add(lbTanggalCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 230, 70));

        txtNama3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNama3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNama3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 370, 50));

        lbNama7.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNama7.setText("Nama Lengkap");
        getContentPane().add(lbNama7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 180, 70));

        txtNoKamar2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNoKamar2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNoKamar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 370, 50));

        lbNoKamar2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNoKamar2.setText("Nomor Kamar");
        getContentPane().add(lbNoKamar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 180, 70));

        txtID3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtID3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 370, 50));

        lbID3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbID3.setText("ID");
        getContentPane().add(lbID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, 70));

        txtNIK3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNIK3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNIK3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 370, 50));

        lbNIK3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNIK3.setText("NIK");
        getContentPane().add(lbNIK3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 180, 70));

        panelCOb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Panel.jpg"))); // NOI18N
        getContentPane().add(panelCOb, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1110, 770));

        lbID1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbID1.setText("ID");
        getContentPane().add(lbID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 180, 70));

        txtID1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 370, 50));

        lbNama1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNama1.setText("Nama Lengkap");
        getContentPane().add(lbNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, 70));

        txtNama1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNama1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 370, 50));

        lbNIK1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNIK1.setText("NIK");
        getContentPane().add(lbNIK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 170, 70));

        txtNIK1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNIK1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNIK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 370, 50));

        lbTombolCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Cek.png"))); // NOI18N
        getContentPane().add(lbTombolCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, -1, -1));

        lbKetCek.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbKetCek.setText("Check");
        getContentPane().add(lbKetCek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, -1, -1));

        panelCO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Panel.jpg"))); // NOI18N
        getContentPane().add(panelCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1110, 710));

        lbDataPel.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbDataPel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDataPel.setText("DATA PELANGGAN ");
        getContentPane().add(lbDataPel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 310, 70));

        lbNIK.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNIK.setText("NIK");
        getContentPane().add(lbNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 180, 70));

        lbNama.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNama.setText("Nama Lengkap");
        getContentPane().add(lbNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, 70));

        lbTTL.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbTTL.setText("Tempat, Tanggal Lahir");
        getContentPane().add(lbTTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 310, 70));

        lbLama.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbLama.setText("Lama Menginap");
        getContentPane().add(lbLama, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 310, 70));

        lbJenis.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbJenis.setText("Jenis Kamar");
        getContentPane().add(lbJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 310, 70));

        lbHarga.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbHarga.setText("Harga Kamar");
        getContentPane().add(lbHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 310, 70));

        lbTombolCI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Check In (1).png"))); // NOI18N
        lbTombolCI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTombolCIMouseClicked(evt);
            }
        });
        getContentPane().add(lbTombolCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, -1, 80));

        txtHarga.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtHarga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 370, 50));

        cbJenis.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        cbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Reguler", "Premium", "Suite", "VIP" }));
        cbJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisActionPerformed(evt);
            }
        });
        getContentPane().add(cbJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 370, 50));

        txtLama.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtLama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtLama, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 370, 50));

        txtTTL.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtTTL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 370, 50));

        txtNama.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 370, 50));

        txtNIK.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNIK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 370, 50));

        txtNoKamar.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtNoKamar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNoKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 370, 50));

        txtID.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 610, 370, 50));

        lbNoKamar.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbNoKamar.setText("Nomor Kamar");
        getContentPane().add(lbNoKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 310, 70));

        lbID.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lbID.setText("ID");
        getContentPane().add(lbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 310, 70));

        panelCI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Panel.jpg"))); // NOI18N
        getContentPane().add(panelCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1110, 710));

        lbOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Out.png"))); // NOI18N
        getContentPane().add(lbOut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 606, 90, 90));

        lbCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Tombol Check Out.png"))); // NOI18N
        lbCheckOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCheckOutMouseClicked(evt);
            }
        });
        getContentPane().add(lbCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 270, -1));

        lbCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Tombol Check In.png"))); // NOI18N
        lbCheckIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCheckInMouseClicked(evt);
            }
        });
        getContentPane().add(lbCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 270, -1));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/Background.jpg"))); // NOI18N
        getContentPane().add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCheckInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCheckInMouseClicked
        // tombol check in di samping

        // komponen hasil check out
        panelHCO.setVisible(false);
        panelHCO.setVisible(false);
        txtHarga5.setVisible(false);
        txtSub.setVisible(false);
        txtDiskon.setVisible(false);
        txtDenda.setVisible(false);
        txtTot.setVisible(false);
        lbDataPem.setVisible(false);
        lbHarga1.setVisible(false);
        lbDenda.setVisible(false);
        lbDiskon.setVisible(false);
        lbSubTot.setVisible(false);
        lbTotal.setVisible(false);

        // komponen check out
        panelCOb.setVisible(false);
        lbDataPel2.setVisible(false);
        lbNIK3.setVisible(false);
        lbID3.setVisible(false);
        lbNoKamar2.setVisible(false);
        lbNama7.setVisible(false);
        lbTTL1.setVisible(false);
        Jenis.setVisible(false);
        lbLama1.setVisible(false);
        lbTanggalCI.setVisible(false);
        lbTombolCheckOut.setVisible(false);
        txtNIK3.setVisible(false);
        txtID3.setVisible(false);
        txtNoKamar2.setVisible(false);
        txtNama3.setVisible(false);
        txtTTL2.setVisible(false);
        txtJenis.setVisible(false);
        txtLama2.setVisible(false);
        txtTanggalCI.setVisible(false);

        //komponen cek data
        panelCO.setVisible(false);
        lbID1.setVisible(false);
        txtID1.setVisible(false);
        lbNama1.setVisible(false);
        txtNama1.setVisible(false);
        lbNIK1.setVisible(false);
        txtNIK1.setVisible(false);
        lbTombolCheck.setVisible(false);
        lbKetCek.setVisible(false);

        // komponen check in
        panelCI.setVisible(true);
        lbDataPel.setVisible(true);
        lbNIK.setVisible(true);
        lbNama.setVisible(true);
        lbTTL.setVisible(true);
        lbLama.setVisible(true);
        lbJenis.setVisible(true);
        lbHarga.setVisible(true);
        lbTombolCI.setVisible(true);
        cbJenis.setVisible(true);
        txtHarga.setVisible(true);
        txtLama.setVisible(true);
        txtTTL.setVisible(true);
        txtNama.setVisible(true);
        txtNIK.setVisible(true);
        txtNoKamar.setVisible(true);
        txtID.setVisible(true);
        lbNoKamar.setVisible(true);
        lbID.setVisible(true);
    }//GEN-LAST:event_lbCheckInMouseClicked

    private void lbCheckOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCheckOutMouseClicked
        // tombol check out disamping
        panelCO.setVisible(true);
        lbID1.setVisible(true);
        txtID1.setVisible(true);
        lbNama1.setVisible(true);
        txtNama1.setVisible(true);
        lbNIK1.setVisible(true);
        txtNIK1.setVisible(true);
        lbTombolCheck.setVisible(true);
        lbKetCek.setVisible(true);

        txtHarga5.setVisible(false);
        txtSub.setVisible(false);
        txtDiskon.setVisible(false);
        txtDenda.setVisible(false);
        txtTot.setVisible(false);
        lbDataPem.setVisible(false);
        lbHarga1.setVisible(false);
        lbDenda.setVisible(false);
        lbDiskon.setVisible(false);
        lbSubTot.setVisible(false);
        lbTotal.setVisible(false);
        panelHCO.setVisible(false);
        panelCOb.setVisible(false);
        lbDataPel2.setVisible(false);
        lbNIK3.setVisible(false);
        lbID3.setVisible(false);
        lbNoKamar2.setVisible(false);
        lbNama7.setVisible(false);
        lbTTL1.setVisible(false);
        Jenis.setVisible(false);
        lbLama1.setVisible(false);
        lbTanggalCI.setVisible(false);
        lbTombolCheckOut.setVisible(false);
        txtNIK3.setVisible(false);
        txtID3.setVisible(false);
        txtNoKamar2.setVisible(false);
        txtNama3.setVisible(false);
        txtTTL2.setVisible(false);
        txtJenis.setVisible(false);
        txtLama2.setVisible(false);
        txtTanggalCI.setVisible(false);
        lbDataPel.setVisible(false);
        lbNIK.setVisible(false);
        lbNama.setVisible(false);
        lbTTL.setVisible(false);
        lbLama.setVisible(false);
        lbJenis.setVisible(false);
        lbHarga.setVisible(false);
        lbTombolCI.setVisible(false);
        txtHarga.setVisible(false);
        cbJenis.setVisible(false);
        txtLama.setVisible(false);
        txtTTL.setVisible(false);
        txtNama.setVisible(false);
        txtNIK.setVisible(false);
        txtNoKamar.setVisible(false);
        txtID.setVisible(false);
        lbNoKamar.setVisible(false);
        lbID.setVisible(false);
        panelCI.setVisible(false);
    }//GEN-LAST:event_lbCheckOutMouseClicked

    private void cbJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisActionPerformed
        // action performed untuk menampilkan harga kamar dari jenis kamar yang dipilih
        if (cbJenis.getSelectedIndex() == 0) {
            jenisKamar = "reguler";
            txtHarga.setText("Rp. 100.000");
            txtHarga.getText();
        } else if (cbJenis.getSelectedIndex() == 1) {
            jenisKamar = "premium";
            txtHarga.setText("Rp. 200.000");
            txtHarga.getText();
        } else if (cbJenis.getSelectedIndex() == 2) {
            jenisKamar = "suite";
            txtHarga.setText("Rp. 350.000");
            txtHarga.getText();
        } else if (cbJenis.getSelectedIndex() == 3) {
            jenisKamar = "vip";
            txtHarga.setText("Rp. 750.000");
            txtHarga.getText();
        } else {
            txtHarga.setText(" ");
            txtHarga.getText();
        }
    }//GEN-LAST:event_cbJenisActionPerformed

    private void lbTombolCIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTombolCIMouseClicked
        // tombol checkin dibawah untuk generate id dan no kamar        
        Check_In ci = new Check_In();
        ci.setNIK(txtNIK.getText());
        ci.setNAMA(txtNama.getText());
        ci.setLAMA(txtLama.getText());
        ci.setTTL(txtTTL.getText());
        ci.proses(jenisKamar);

        try {
            txtID.setText(ci.getTampilID());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            txtNoKamar.setText(ci.getTampilNmrKmr());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lbTombolCIMouseClicked

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
    private javax.swing.JLabel Jenis;
    private javax.swing.JComboBox cbJenis;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCheckIn;
    private javax.swing.JLabel lbCheckOut;
    private javax.swing.JLabel lbDataPel;
    private javax.swing.JLabel lbDataPel2;
    private javax.swing.JLabel lbDataPem;
    private javax.swing.JLabel lbDenda;
    private javax.swing.JLabel lbDiskon;
    private javax.swing.JLabel lbHarga;
    private javax.swing.JLabel lbHarga1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbID1;
    private javax.swing.JLabel lbID3;
    private javax.swing.JLabel lbJenis;
    private javax.swing.JLabel lbKetCek;
    private javax.swing.JLabel lbLama;
    private javax.swing.JLabel lbLama1;
    private javax.swing.JLabel lbNIK;
    private javax.swing.JLabel lbNIK1;
    private javax.swing.JLabel lbNIK3;
    private javax.swing.JLabel lbNama;
    private javax.swing.JLabel lbNama1;
    private javax.swing.JLabel lbNama7;
    private javax.swing.JLabel lbNoKamar;
    private javax.swing.JLabel lbNoKamar2;
    private javax.swing.JLabel lbOut1;
    private javax.swing.JLabel lbSubTot;
    private javax.swing.JLabel lbTTL;
    private javax.swing.JLabel lbTTL1;
    private javax.swing.JLabel lbTanggalCI;
    private javax.swing.JLabel lbTombolCI;
    private javax.swing.JLabel lbTombolCheck;
    private javax.swing.JLabel lbTombolCheckOut;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel panelCI;
    private javax.swing.JLabel panelCO;
    private javax.swing.JLabel panelCOb;
    private javax.swing.JLabel panelHCO;
    private javax.swing.JTextField txtDenda;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHarga5;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtID3;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtLama;
    private javax.swing.JTextField txtLama2;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNIK1;
    private javax.swing.JTextField txtNIK3;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNama1;
    private javax.swing.JTextField txtNama3;
    private javax.swing.JTextField txtNoKamar;
    private javax.swing.JTextField txtNoKamar2;
    private javax.swing.JTextField txtSub;
    private javax.swing.JTextField txtTTL;
    private javax.swing.JTextField txtTTL2;
    private javax.swing.JTextField txtTanggalCI;
    private javax.swing.JTextField txtTot;
    // End of variables declaration//GEN-END:variables
}
