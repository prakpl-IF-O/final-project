/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Class.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irfandi
 */
public class Main extends javax.swing.JFrame {
    Thread UPDATE_TIME;
    DateAndTime dt = new DateAndTime();
    UserEngine user = new UserEngine();
    KamarEngine kamar = new KamarEngine();
    TamuEngine tamu = new TamuEngine();
    Transaksi trans = new Transaksi();
    
    class GET_TIME implements Runnable {

        public void run() {
            try {
                for (int x = 0;; x++) {
                    lbl_jam.setText(dt.GET_CURRENT_TIME("H:M"));
                    Thread.sleep(1000);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        INIT_DATA();
        UPDATE_TIME = new Thread(new GET_TIME());
        UPDATE_TIME.start();
        CLEAR_PANEL();
        PANEL_BERANDA_OVERVIEW.setVisible(true);
        clear_highlight();
        highlight_beranda.setVisible(true);
        System.out.println(user.liat());
        System.out.println(kamar.liat());
        UPDATE_INFO(0,"Tamu");
        txt_akumulasi.setEnabled(false);
    }

    public void INIT_DATA() {
        int jumlah_pelanggan = user.GET_JUMLAH_USER();
        int jumlah_tamu = tamu.GET_JUMLAH_TAMU();
        int total_kamar_tersedia = kamar.GET_TOTAL_KAMAR_TERSEDIA();
        int total_kamar_dipesan = kamar.GET_TOTAL_KAMAR_DIPESAN();
        int reg_kosong = kamar.GET_REG_KOSONG();
        int reg_dipesan = kamar.GET_REG_DIPESAN();
        int pre_kosong = kamar.GET_PRE_KOSONG();
        int pre_dipesan = kamar.GET_PRE_DIPESAN();
        int sui_kosong = kamar.GET_SUI_KOSONG();
        int sui_dipesan = kamar.GET_SUI_DIPESAN();
        int vip_kosong = kamar.GET_VIP_KOSONG();
        int vip_dipesan = kamar.GET_VIP_DIPESAN();
 
        JUMLAH_TAMU.setText(jumlah_tamu+ " Tamu Menginap");
        JUMLAH_REG_TERSEDIA.setText(reg_kosong+ " Kamar Reguler Tersedia");
        JUMLAH_REG_DIPESAN.setText(reg_dipesan+ " Kamar Reguler Dipesan");
        JUMLAH_PRE_TERSEDIA.setText(pre_kosong+" Kamar Premium Tersedia");
        JUMLAH_PRE_DIPESAN.setText(pre_dipesan+" Kamar Premium Dipesan");
        JUMLAH_SUI_TERSEDIA.setText(sui_kosong+" Kamar Suite Tersedia");
        JUMLAH_SUI_DIPESAN.setText(sui_dipesan+" Kamar Suite Dipesan");
        JUMLAH_VIP_TERSEDIA.setText(vip_kosong+" Kamar VIP Tersedia");
        JUMLAH_VIP_DIPESAN.setText(vip_dipesan+" Kamar VIP Dipesan");
        JUMLAH_KAMAR_DIPESAN.setText(total_kamar_dipesan+" Kamar Dipesan");
        JUMLAH_KAMAR_TERSEDIA.setText(total_kamar_tersedia+" Kamar Tersedia");
        JUMLAH_PELANGGAN.setText(jumlah_pelanggan + " Pelanggan");
        lbl_jum_pelanggan.setText(jumlah_pelanggan+ " Pelanggan terdaftar.");
        lbl_tanggal.setText(dt.GET_CURRENT_DATE("D-M-Y"));
        INIT_TABLE();
    }
    
    public void CLEAR_TABLE(){
        DefaultTableModel model_tamu = (DefaultTableModel) TABLE_TAMU.getModel();
        for (int i = 0; i < tamu.GET_JUMLAH_TAMU(); i++) {
            
            model_tamu.removeRow(0);
        }
        
        DefaultComboBoxModel model_cbo = (DefaultComboBoxModel) cbo_daftar_pelanggan.getModel();
        DefaultTableModel model_pelanggan = (DefaultTableModel) TABLE_PELANGGAN.getModel();
        for (int i = 0; i < user.GET_JUMLAH_USER(); i++) {
            model_pelanggan.removeRow(0);
            model_cbo.removeElementAt(1);
        }
        
        
        
    }
    public void INIT_TABLE(){
        DefaultTableModel model_tamu = (DefaultTableModel) TABLE_TAMU.getModel(); 
        DefaultComboBoxModel model_cbo = (DefaultComboBoxModel) cbo_daftar_pelanggan.getModel();
        DefaultComboBoxModel model_cbo_tamu = (DefaultComboBoxModel) cbo_tamu.getModel();
        
        for (int i = 0; i < tamu.GET_JUMLAH_TAMU(); i++) {
            System.out.println("init table tamu "+ i);
            String ID = tamu.GET_ID_BY_INDEX(i);
            String NIK = tamu.GET_NIK_BY_INDEX(i);
            String NAMA = tamu.GET_NAMA_BY_INDEX(i);
            String KAMAR = tamu.GET_KAMAR_BY_INDEX(i);
            String CHK_IN = tamu.GET_STRING_CHECK_IN_BY_INDEX(i);
            String CHK_OUT = tamu.GET_STRING_CHECK_OUT_BY_INDEX(i);
            String[] tamu_ = {ID, NIK, NAMA, KAMAR, CHK_IN, CHK_OUT};
            String Nama_ID = NAMA + " - " + ID;
            model_tamu.addRow(tamu_);
            model_cbo_tamu.addElement(Nama_ID);
        }
        
        DefaultTableModel model_pelanggan = (DefaultTableModel) TABLE_PELANGGAN.getModel();
        for (int i = 0; i < user.GET_JUMLAH_USER(); i++) {
            System.out.println("init table pelanggan "+ i);
            String ID = user.GET_ID_BY_INDEX(i);
            String NIK = user.GET_NIK_BY_INDEX(i);
            String NAMA = user.GET_NAMA_BY_INDEX(i);
            String TGL_DAFTAR = user.GET_TGL_DAFTAR_BY_INDEX(i);
            String AKUMULASI = Integer.toString(user.GET_AKUMULASI(i));
            String[] Pelanggan_ = {ID, NIK, NAMA, TGL_DAFTAR,AKUMULASI};
            model_pelanggan.addRow(Pelanggan_);
            String Nama_ID = NAMA + " - " + ID;
            model_cbo.addElement(Nama_ID);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu_beranda = new javax.swing.JLabel();
        icon_plus = new javax.swing.JLabel();
        icon_plus1 = new javax.swing.JLabel();
        icon_plus2 = new javax.swing.JLabel();
        icon_plus3 = new javax.swing.JLabel();
        menu_transaksi = new javax.swing.JLabel();
        menu_pelanggan = new javax.swing.JLabel();
        menu_keuangan = new javax.swing.JLabel();
        icon_beranda = new javax.swing.JLabel();
        icon_transaksi = new javax.swing.JLabel();
        icon_pelanggan = new javax.swing.JLabel();
        icon_keuangan = new javax.swing.JLabel();
        highlight_beranda = new javax.swing.JLabel();
        highlight_transaksi = new javax.swing.JLabel();
        highlight_pelanggan = new javax.swing.JLabel();
        highlight_keuangan = new javax.swing.JLabel();
        PANEL_TRANSAKSI_CHECKOUT = new javax.swing.JLayeredPane();
        cbo_tamu = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ID_ceck_out = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbl_co_checkin = new javax.swing.JLabel();
        lbl_co_nama = new javax.swing.JLabel();
        lbl_co_lama = new javax.swing.JLabel();
        lbl_co_kamar = new javax.swing.JLabel();
        lbl_co_biaya = new javax.swing.JLabel();
        lbl_co_diskon = new javax.swing.JLabel();
        lbl_kembalian = new javax.swing.JLabel();
        lbl_co_denda = new javax.swing.JLabel();
        lbl_co_total = new javax.swing.JLabel();
        txt_bayar = new javax.swing.JTextField();
        btn_checkout = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        color6 = new javax.swing.JLabel();
        PANEL_BERANDA_OVERVIEW = new javax.swing.JLayeredPane();
        lbl_jam = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        JUMLAH_PELANGGAN = new javax.swing.JLabel();
        JUMLAH_KAMAR_TERSEDIA = new javax.swing.JLabel();
        JUMLAH_KAMAR_DIPESAN = new javax.swing.JLabel();
        JUMLAH_REG_TERSEDIA = new javax.swing.JLabel();
        JUMLAH_REG_DIPESAN = new javax.swing.JLabel();
        JUMLAH_PRE_TERSEDIA = new javax.swing.JLabel();
        JUMLAH_PRE_DIPESAN = new javax.swing.JLabel();
        JUMLAH_SUI_TERSEDIA = new javax.swing.JLabel();
        JUMLAH_SUI_DIPESAN = new javax.swing.JLabel();
        JUMLAH_VIP_TERSEDIA = new javax.swing.JLabel();
        JUMLAH_VIP_DIPESAN = new javax.swing.JLabel();
        JUMLAH_TAMU = new javax.swing.JLabel();
        BG_REG = new javax.swing.JLabel();
        BG_SUITE = new javax.swing.JLabel();
        BG_VIP = new javax.swing.JLabel();
        BG_PRE1 = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        PANEL_TRANSAKSI_CHECK_IN = new javax.swing.JLayeredPane();
        txt_ID = new javax.swing.JTextField();
        txt_nik = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_tempat_lahir = new javax.swing.JTextField();
        txt_tanggal_lahir = new javax.swing.JTextField();
        txt_tanggal_daftar = new javax.swing.JTextField();
        txt_akumulasi = new javax.swing.JTextField();
        cbo_paket_kamar = new javax.swing.JComboBox();
        txt_tanggal_check_in = new javax.swing.JTextField();
        txt_tanggal_check_out = new javax.swing.JTextField();
        lbl_no_kamar3 = new javax.swing.JLabel();
        txt_no_kamar = new javax.swing.JLabel();
        lbl_no_kamar1 = new javax.swing.JLabel();
        lbl_no_kamar2 = new javax.swing.JLabel();
        lbl_no_kamar4 = new javax.swing.JLabel();
        lbl_no_kamar5 = new javax.swing.JLabel();
        lbl_no_kamar6 = new javax.swing.JLabel();
        lbl_no_kamar7 = new javax.swing.JLabel();
        lbl_no_kamar8 = new javax.swing.JLabel();
        lbl_no_kamar9 = new javax.swing.JLabel();
        lbl_no_kamar10 = new javax.swing.JLabel();
        lbl_no_kamar11 = new javax.swing.JLabel();
        tbl_batal = new javax.swing.JLabel();
        tbl_check_in = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbo_daftar_pelanggan = new javax.swing.JComboBox();
        lbl_jum_pelanggan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        color5 = new javax.swing.JLabel();
        PANEL_SUBMENU_TRANSAKSI = new javax.swing.JLayeredPane();
        sub_check_in = new javax.swing.JLabel();
        sub_check_out = new javax.swing.JLabel();
        sub_highlight_check_in = new javax.swing.JLabel();
        sub_highlight_check_out = new javax.swing.JLabel();
        color4 = new javax.swing.JLabel();
        PANEL_SUBMENU_PELANGGAN = new javax.swing.JLayeredPane();
        sub_tamu = new javax.swing.JLabel();
        sub_pelanggan = new javax.swing.JLabel();
        sub_highlight_tamu = new javax.swing.JLabel();
        sub_highlight_pelanggan = new javax.swing.JLabel();
        color3 = new javax.swing.JLabel();
        PANEL_PELANGGAN = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABLE_PELANGGAN = new javax.swing.JTable();
        LABEL6 = new javax.swing.JLabel();
        lbl_tgl_lahir_pelanggan = new javax.swing.JLabel();
        LABEL7 = new javax.swing.JLabel();
        lbl_akumulasi_pelanggan = new javax.swing.JLabel();
        LABEL8 = new javax.swing.JLabel();
        lbl_nama_pelanggan = new javax.swing.JLabel();
        lbl_ID_pelanggan = new javax.swing.JLabel();
        lbl_tgl_daftar_pelanggan = new javax.swing.JLabel();
        LABEL9 = new javax.swing.JLabel();
        lbl_tempat_lahir_pelanggan = new javax.swing.JLabel();
        LABEL10 = new javax.swing.JLabel();
        lbl_nik_pelanggan = new javax.swing.JLabel();
        LABEL11 = new javax.swing.JLabel();
        color2 = new javax.swing.JLabel();
        PANEL_PELANGGAN_TAMU = new javax.swing.JLayeredPane();
        lbl_ID_tamu = new javax.swing.JLabel();
        lbl_nama_tamu = new javax.swing.JLabel();
        lbl_nik_tamu = new javax.swing.JLabel();
        lbl_kamar_tamu = new javax.swing.JLabel();
        lbl_co_tamu = new javax.swing.JLabel();
        lbl_ci_tamu = new javax.swing.JLabel();
        lbl_diskon_tamu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE_TAMU = new javax.swing.JTable();
        LABEL = new javax.swing.JLabel();
        LABEL1 = new javax.swing.JLabel();
        LABEL2 = new javax.swing.JLabel();
        LABEL3 = new javax.swing.JLabel();
        LABEL4 = new javax.swing.JLabel();
        LABEL5 = new javax.swing.JLabel();
        color1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_beranda.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        menu_beranda.setForeground(new java.awt.Color(255, 255, 255));
        menu_beranda.setText("Beranda");
        menu_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_berandaMouseClicked(evt);
            }
        });
        getContentPane().add(menu_beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 120, -1, -1));

        icon_plus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        getContentPane().add(icon_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 122, -1, -1));

        icon_plus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        getContentPane().add(icon_plus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 192, -1, -1));

        icon_plus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        getContentPane().add(icon_plus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 262, -1, -1));

        icon_plus3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        getContentPane().add(icon_plus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 332, -1, -1));

        menu_transaksi.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        menu_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        menu_transaksi.setText("Transaksi");
        menu_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_transaksiMouseClicked(evt);
            }
        });
        getContentPane().add(menu_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 190, -1, -1));

        menu_pelanggan.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        menu_pelanggan.setForeground(new java.awt.Color(255, 255, 255));
        menu_pelanggan.setText("Pelanggan");
        menu_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_pelangganMouseClicked(evt);
            }
        });
        getContentPane().add(menu_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 260, -1, -1));

        menu_keuangan.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        menu_keuangan.setForeground(new java.awt.Color(255, 255, 255));
        menu_keuangan.setText("Keuangan");
        menu_keuangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_keuanganMouseClicked(evt);
            }
        });
        getContentPane().add(menu_keuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 330, -1, -1));

        icon_beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/beranda.png"))); // NOI18N
        getContentPane().add(icon_beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 122, -1, -1));

        icon_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/transaksi.png"))); // NOI18N
        getContentPane().add(icon_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 192, -1, -1));

        icon_pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pelanggan.png"))); // NOI18N
        getContentPane().add(icon_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 262, -1, -1));

        icon_keuangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/keuangan.png"))); // NOI18N
        getContentPane().add(icon_keuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 332, -1, -1));

        highlight_beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/selected.png"))); // NOI18N
        getContentPane().add(highlight_beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 100, 280, 70));

        highlight_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/selected.png"))); // NOI18N
        getContentPane().add(highlight_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 170, 280, 70));

        highlight_pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/selected.png"))); // NOI18N
        getContentPane().add(highlight_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 240, 280, 70));

        highlight_keuangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/selected.png"))); // NOI18N
        getContentPane().add(highlight_keuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 310, 280, 70));

        PANEL_TRANSAKSI_CHECKOUT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbo_tamu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_tamu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Pilih Tamu yang akan Check Out)" }));
        cbo_tamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tamuActionPerformed(evt);
            }
        });
        PANEL_TRANSAKSI_CHECKOUT.add(cbo_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 34, 290, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID :");
        PANEL_TRANSAKSI_CHECKOUT.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("atau");
        PANEL_TRANSAKSI_CHECKOUT.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        txt_ID_ceck_out.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_ID_ceck_out.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ID_ceck_outKeyReleased(evt);
            }
        });
        PANEL_TRANSAKSI_CHECKOUT.add(txt_ID_ceck_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 34, 250, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG_select_checkout.png"))); // NOI18N
        PANEL_TRANSAKSI_CHECKOUT.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        lbl_co_checkin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_co_checkin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_checkin.setText("Senin, 21 September 2016");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        lbl_co_nama.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_co_nama.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_nama.setText("Ricky Irfandi");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 125, -1, -1));

        lbl_co_lama.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_co_lama.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_lama.setText("5 Hari");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_lama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 215, -1, -1));

        lbl_co_kamar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_co_kamar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_kamar.setText("099V - VIP");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_kamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        lbl_co_biaya.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_co_biaya.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_biaya.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_co_biaya.setText("750000");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_biaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 305, 300, -1));

        lbl_co_diskon.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_co_diskon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_diskon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_co_diskon.setText("0");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 300, -1));

        lbl_kembalian.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_kembalian.setForeground(new java.awt.Color(255, 255, 255));
        lbl_kembalian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_kembalian.setText("0");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 290, -1));

        lbl_co_denda.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_co_denda.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_denda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_co_denda.setText("0");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_denda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 290, -1));

        lbl_co_total.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_co_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_co_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_co_total.setText("750000");
        PANEL_TRANSAKSI_CHECKOUT.add(lbl_co_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 300, -1));

        txt_bayar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PANEL_TRANSAKSI_CHECKOUT.add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 290, 40));

        btn_checkout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tombol_checkout.png"))); // NOI18N
        PANEL_TRANSAKSI_CHECKOUT.add(btn_checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 487, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_detail_co.png"))); // NOI18N
        PANEL_TRANSAKSI_CHECKOUT.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_bayar.png"))); // NOI18N
        PANEL_TRANSAKSI_CHECKOUT.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        color6.setBackground(new java.awt.Color(255, 255, 255));
        color6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        color6.setOpaque(true);
        PANEL_TRANSAKSI_CHECKOUT.add(color6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        getContentPane().add(PANEL_TRANSAKSI_CHECKOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 1000, 550));

        PANEL_BERANDA_OVERVIEW.setBackground(new java.awt.Color(255, 255, 255));
        PANEL_BERANDA_OVERVIEW.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_jam.setFont(new java.awt.Font("Segoe UI Light", 0, 72)); // NOI18N
        lbl_jam.setText("23:59");
        PANEL_BERANDA_OVERVIEW.add(lbl_jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 0, -1, -1));

        lbl_tanggal.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        lbl_tanggal.setText("15 Mei 2016");
        PANEL_BERANDA_OVERVIEW.add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 83, -1, -1));

        JUMLAH_PELANGGAN.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_PELANGGAN.setText("99 Pelanggan Terdaftar");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_PELANGGAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        JUMLAH_KAMAR_TERSEDIA.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_KAMAR_TERSEDIA.setText("100 Kamar Tersedia");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_KAMAR_TERSEDIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        JUMLAH_KAMAR_DIPESAN.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_KAMAR_DIPESAN.setText("100 Kamar Dipesan");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_KAMAR_DIPESAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        JUMLAH_REG_TERSEDIA.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_REG_TERSEDIA.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_REG_TERSEDIA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_REG_TERSEDIA.setText("100 Kamar Reguler Tersedia");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_REG_TERSEDIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 460, -1));

        JUMLAH_REG_DIPESAN.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_REG_DIPESAN.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_REG_DIPESAN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_REG_DIPESAN.setText("100 Kamar Reguler Dipesan");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_REG_DIPESAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 460, -1));

        JUMLAH_PRE_TERSEDIA.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_PRE_TERSEDIA.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_PRE_TERSEDIA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_PRE_TERSEDIA.setText("100 Kamar Premium Tersedia");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_PRE_TERSEDIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 460, -1));

        JUMLAH_PRE_DIPESAN.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_PRE_DIPESAN.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_PRE_DIPESAN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_PRE_DIPESAN.setText("100 Kamar Premium Dipesan");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_PRE_DIPESAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 460, -1));

        JUMLAH_SUI_TERSEDIA.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_SUI_TERSEDIA.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_SUI_TERSEDIA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_SUI_TERSEDIA.setText("100 Kamar Suite Tersedia");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_SUI_TERSEDIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 460, -1));

        JUMLAH_SUI_DIPESAN.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_SUI_DIPESAN.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_SUI_DIPESAN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_SUI_DIPESAN.setText("100 Kamar Suite Dipesan");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_SUI_DIPESAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 460, -1));

        JUMLAH_VIP_TERSEDIA.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_VIP_TERSEDIA.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_VIP_TERSEDIA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_VIP_TERSEDIA.setText("100 Kamar VIP Tersedia");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_VIP_TERSEDIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 450, -1));

        JUMLAH_VIP_DIPESAN.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_VIP_DIPESAN.setForeground(new java.awt.Color(255, 255, 255));
        JUMLAH_VIP_DIPESAN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JUMLAH_VIP_DIPESAN.setText("100 Kamar VIP Dipesan");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_VIP_DIPESAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 450, -1));

        JUMLAH_TAMU.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        JUMLAH_TAMU.setText("99 Tamu Menginap");
        PANEL_BERANDA_OVERVIEW.add(JUMLAH_TAMU, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        BG_REG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kamar_reguler.png"))); // NOI18N
        BG_REG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BG_REGMouseClicked(evt);
            }
        });
        PANEL_BERANDA_OVERVIEW.add(BG_REG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        BG_SUITE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kamar_suite.png"))); // NOI18N
        BG_SUITE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BG_SUITEMouseClicked(evt);
            }
        });
        PANEL_BERANDA_OVERVIEW.add(BG_SUITE, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        BG_VIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kamar_vip.png"))); // NOI18N
        BG_VIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BG_VIPMouseClicked(evt);
            }
        });
        PANEL_BERANDA_OVERVIEW.add(BG_VIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, -1, -1));

        BG_PRE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kamar_premium.png"))); // NOI18N
        BG_PRE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BG_PRE1MouseClicked(evt);
            }
        });
        PANEL_BERANDA_OVERVIEW.add(BG_PRE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        color.setBackground(new java.awt.Color(255, 255, 255));
        color.setOpaque(true);
        PANEL_BERANDA_OVERVIEW.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        getContentPane().add(PANEL_BERANDA_OVERVIEW, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 990, 550));

        PANEL_TRANSAKSI_CHECK_IN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_ID.setText("RI123");
        txt_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_IDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_IDKeyReleased(evt);
            }
        });
        PANEL_TRANSAKSI_CHECK_IN.add(txt_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 370, 35));

        txt_nik.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_nik.setText("155150201111274");
        PANEL_TRANSAKSI_CHECK_IN.add(txt_nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 370, 35));

        txt_nama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_nama.setText("Ricky Irfandi");
        PANEL_TRANSAKSI_CHECK_IN.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 370, 35));

        txt_tempat_lahir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_tempat_lahir.setText("Bondowoso");
        PANEL_TRANSAKSI_CHECK_IN.add(txt_tempat_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 370, 35));

        txt_tanggal_lahir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_tanggal_lahir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tanggal_lahir.setText("21/09/1996");
        PANEL_TRANSAKSI_CHECK_IN.add(txt_tanggal_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 170, 35));

        txt_tanggal_daftar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_tanggal_daftar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tanggal_daftar.setText("21/01/2016");
        txt_tanggal_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggal_daftarActionPerformed(evt);
            }
        });
        PANEL_TRANSAKSI_CHECK_IN.add(txt_tanggal_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 170, 35));

        txt_akumulasi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_akumulasi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_akumulasi.setText("15");
        txt_akumulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_akumulasiActionPerformed(evt);
            }
        });
        PANEL_TRANSAKSI_CHECK_IN.add(txt_akumulasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 170, 35));

        cbo_paket_kamar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbo_paket_kamar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Reguler", "Premium", "Suite", "VIP" }));
        cbo_paket_kamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_paket_kamarActionPerformed(evt);
            }
        });
        PANEL_TRANSAKSI_CHECK_IN.add(cbo_paket_kamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 170, 35));

        txt_tanggal_check_in.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_tanggal_check_in.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tanggal_check_in.setText("21/09/1996");
        PANEL_TRANSAKSI_CHECK_IN.add(txt_tanggal_check_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 170, 35));

        txt_tanggal_check_out.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_tanggal_check_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tanggal_check_out.setText("21/09/1996");
        PANEL_TRANSAKSI_CHECK_IN.add(txt_tanggal_check_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 170, 35));

        lbl_no_kamar3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar3.setText("Tanggal Check Out    : ");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 338, 190, 35));

        txt_no_kamar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_no_kamar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_no_kamar.setText("001R");
        PANEL_TRANSAKSI_CHECK_IN.add(txt_no_kamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 170, 35));

        lbl_no_kamar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar1.setText("No Kamar                  : ");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 418, 190, 35));

        lbl_no_kamar2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar2.setText("Paket Kamar              : ");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 378, 190, 35));

        lbl_no_kamar4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar4.setText("Tanggal Check In       : ");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 298, 190, 35));

        lbl_no_kamar5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar5.setText("Akumulasi Menginap : ");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 258, 190, 35));

        lbl_no_kamar6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar6.setText("Tanggal Daftar           :");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 218, 190, 35));

        lbl_no_kamar7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar7.setText("Tanggal Lahir             :");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 178, 190, 35));

        lbl_no_kamar8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar8.setText("Tempat Lahir             :");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 138, 190, 35));

        lbl_no_kamar9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar9.setText("Nama                        :");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, 190, 35));

        lbl_no_kamar10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar10.setText("NIK                            :");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 58, 190, 35));

        lbl_no_kamar11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_no_kamar11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_no_kamar11.setText("ID                              :");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_no_kamar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 190, 35));

        tbl_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tombol_batal.png"))); // NOI18N
        tbl_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_batalMouseClicked(evt);
            }
        });
        PANEL_TRANSAKSI_CHECK_IN.add(tbl_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        tbl_check_in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tombol_checkin.png"))); // NOI18N
        tbl_check_in.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_check_inMouseClicked(evt);
            }
        });
        PANEL_TRANSAKSI_CHECK_IN.add(tbl_check_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("contoh : 17/08/1945");
        PANEL_TRANSAKSI_CHECK_IN.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("format dd/mm/yyyy");
        PANEL_TRANSAKSI_CHECK_IN.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        cbo_daftar_pelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbo_daftar_pelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "( Pilih Satu Pelanggan )" }));
        cbo_daftar_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_daftar_pelangganActionPerformed(evt);
            }
        });
        PANEL_TRANSAKSI_CHECK_IN.add(cbo_daftar_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 380, 40));

        lbl_jum_pelanggan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_jum_pelanggan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jum_pelanggan.setText("2 Pelanggan terdaftar.");
        PANEL_TRANSAKSI_CHECK_IN.add(lbl_jum_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG_pilih_dari_pelanggan.png"))); // NOI18N
        PANEL_TRANSAKSI_CHECK_IN.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        color5.setBackground(new java.awt.Color(255, 255, 255));
        color5.setOpaque(true);
        PANEL_TRANSAKSI_CHECK_IN.add(color5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        getContentPane().add(PANEL_TRANSAKSI_CHECK_IN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 1000, 550));

        PANEL_SUBMENU_TRANSAKSI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sub_check_in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SUBMENU_CHECK_IN.png"))); // NOI18N
        sub_check_in.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_check_inMouseClicked(evt);
            }
        });
        PANEL_SUBMENU_TRANSAKSI.add(sub_check_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 30));

        sub_check_out.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SUBMENU_CHECK_OUT.png"))); // NOI18N
        sub_check_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_check_outMouseClicked(evt);
            }
        });
        PANEL_SUBMENU_TRANSAKSI.add(sub_check_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 130, 30));

        sub_highlight_check_in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/highlight_submenu.png"))); // NOI18N
        PANEL_SUBMENU_TRANSAKSI.add(sub_highlight_check_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 160, 30));

        sub_highlight_check_out.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/highlight_submenu.png"))); // NOI18N
        PANEL_SUBMENU_TRANSAKSI.add(sub_highlight_check_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, 30));

        color4.setBackground(new java.awt.Color(255, 255, 255));
        color4.setOpaque(true);
        PANEL_SUBMENU_TRANSAKSI.add(color4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 100));

        getContentPane().add(PANEL_SUBMENU_TRANSAKSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 800, 100));

        PANEL_SUBMENU_PELANGGAN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sub_tamu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SUBMENU_TAMU.png"))); // NOI18N
        sub_tamu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_tamuMouseClicked(evt);
            }
        });
        PANEL_SUBMENU_PELANGGAN.add(sub_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 30));

        sub_pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SUBMENU_PELANGGAN.png"))); // NOI18N
        sub_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_pelangganMouseClicked(evt);
            }
        });
        PANEL_SUBMENU_PELANGGAN.add(sub_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 130, 30));

        sub_highlight_tamu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/highlight_submenu.png"))); // NOI18N
        PANEL_SUBMENU_PELANGGAN.add(sub_highlight_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 160, 30));

        sub_highlight_pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/highlight_submenu.png"))); // NOI18N
        PANEL_SUBMENU_PELANGGAN.add(sub_highlight_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, 30));

        color3.setBackground(new java.awt.Color(255, 255, 255));
        color3.setOpaque(true);
        PANEL_SUBMENU_PELANGGAN.add(color3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 100));

        getContentPane().add(PANEL_SUBMENU_PELANGGAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 800, 100));

        PANEL_PELANGGAN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TABLE_PELANGGAN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TABLE_PELANGGAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIK", "Nama", "Tanggal Daftar", "Total Menginap"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLE_PELANGGAN.setRowHeight(30);
        TABLE_PELANGGAN.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TABLE_PELANGGAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLE_PELANGGANMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TABLE_PELANGGAN);

        PANEL_PELANGGAN.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 970, 280));

        LABEL6.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL6.setText("Tanggal Daftar :");
        PANEL_PELANGGAN.add(LABEL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, -1, -1));

        lbl_tgl_lahir_pelanggan.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_tgl_lahir_pelanggan.setText("21 September 2015");
        PANEL_PELANGGAN.add(lbl_tgl_lahir_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        LABEL7.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL7.setText("Total      : ");
        PANEL_PELANGGAN.add(LABEL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        lbl_akumulasi_pelanggan.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_akumulasi_pelanggan.setText("5 Hari");
        PANEL_PELANGGAN.add(lbl_akumulasi_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        LABEL8.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL8.setText("NIK        : ");
        PANEL_PELANGGAN.add(LABEL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        lbl_nama_pelanggan.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        lbl_nama_pelanggan.setText("Ricky Irfandi");
        PANEL_PELANGGAN.add(lbl_nama_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        lbl_ID_pelanggan.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_ID_pelanggan.setText("RI123");
        PANEL_PELANGGAN.add(lbl_ID_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        lbl_tgl_daftar_pelanggan.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_tgl_daftar_pelanggan.setText("5 Januari 2015");
        PANEL_PELANGGAN.add(lbl_tgl_daftar_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, -1, -1));

        LABEL9.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL9.setText("Tempat Lahir   :");
        PANEL_PELANGGAN.add(LABEL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 480, -1, -1));

        lbl_tempat_lahir_pelanggan.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_tempat_lahir_pelanggan.setText("Bondowoso");
        PANEL_PELANGGAN.add(lbl_tempat_lahir_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, -1, -1));

        LABEL10.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL10.setText("Tanggal Lahir   :");
        PANEL_PELANGGAN.add(LABEL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        lbl_nik_pelanggan.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_nik_pelanggan.setText("155150201111274");
        PANEL_PELANGGAN.add(lbl_nik_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        LABEL11.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL11.setText("ID          : ");
        PANEL_PELANGGAN.add(LABEL11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        color2.setBackground(new java.awt.Color(255, 255, 255));
        color2.setOpaque(true);
        PANEL_PELANGGAN.add(color2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        getContentPane().add(PANEL_PELANGGAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 1000, 550));

        PANEL_PELANGGAN_TAMU.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ID_tamu.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_ID_tamu.setText("RI123");
        PANEL_PELANGGAN_TAMU.add(lbl_ID_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        lbl_nama_tamu.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        lbl_nama_tamu.setText("Ricky Irfandi");
        PANEL_PELANGGAN_TAMU.add(lbl_nama_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        lbl_nik_tamu.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_nik_tamu.setText("155150201111274");
        PANEL_PELANGGAN_TAMU.add(lbl_nik_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        lbl_kamar_tamu.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_kamar_tamu.setText("099V");
        PANEL_PELANGGAN_TAMU.add(lbl_kamar_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        lbl_co_tamu.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_co_tamu.setText("Senin, 5 Desember 2017");
        PANEL_PELANGGAN_TAMU.add(lbl_co_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        lbl_ci_tamu.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_ci_tamu.setText("Minggu, 5 Januari 2015");
        PANEL_PELANGGAN_TAMU.add(lbl_ci_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, -1, -1));

        lbl_diskon_tamu.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbl_diskon_tamu.setText("50 %");
        PANEL_PELANGGAN_TAMU.add(lbl_diskon_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, -1, -1));

        TABLE_TAMU.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TABLE_TAMU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIK", "Nama", "No Kamar", "Check In", "Check Out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLE_TAMU.setRowHeight(30);
        TABLE_TAMU.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TABLE_TAMU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLE_TAMUMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLE_TAMU);

        PANEL_PELANGGAN_TAMU.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 970, 280));

        LABEL.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL.setText("Kamar    : ");
        PANEL_PELANGGAN_TAMU.add(LABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        LABEL1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL1.setText("Diskon         : ");
        PANEL_PELANGGAN_TAMU.add(LABEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, -1, -1));

        LABEL2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL2.setText("NIK        : ");
        PANEL_PELANGGAN_TAMU.add(LABEL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        LABEL3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL3.setText("ID          : ");
        PANEL_PELANGGAN_TAMU.add(LABEL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        LABEL4.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL4.setText("Check In      : ");
        PANEL_PELANGGAN_TAMU.add(LABEL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, -1));

        LABEL5.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LABEL5.setText("Check Out   : ");
        PANEL_PELANGGAN_TAMU.add(LABEL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        color1.setBackground(new java.awt.Color(255, 255, 255));
        color1.setOpaque(true);
        PANEL_PELANGGAN_TAMU.add(color1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        getContentPane().add(PANEL_PELANGGAN_TAMU, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 1000, 550));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MAIN LAYOUT.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void clear_highlight(){
    highlight_beranda.setVisible(false);
    highlight_transaksi.setVisible(false);
    highlight_pelanggan.setVisible(false);
    highlight_keuangan.setVisible(false);
}
    private void menu_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_transaksiMouseClicked
        clear_highlight();
        highlight_transaksi.setVisible(true);
        CLEAR_PANEL();
        PANEL_TRANSAKSI_CHECK_IN.setVisible(true);
        PANEL_SUBMENU_TRANSAKSI.setVisible(true);
        sub_highlight_check_in.setVisible(true);
        sub_highlight_check_out.setVisible(false);
    }//GEN-LAST:event_menu_transaksiMouseClicked

    private void menu_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_berandaMouseClicked
        clear_highlight();
        highlight_beranda.setVisible(true);
        CLEAR_PANEL();
        PANEL_BERANDA_OVERVIEW.setVisible(true);
    }//GEN-LAST:event_menu_berandaMouseClicked

    private void menu_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_pelangganMouseClicked
        clear_highlight();
        highlight_pelanggan.setVisible(true);
        CLEAR_PANEL();
        PANEL_PELANGGAN_TAMU.setVisible(true);
        PANEL_SUBMENU_PELANGGAN.setVisible(true);
        if (PANEL_PELANGGAN_TAMU.isVisible()) {
            sub_highlight_pelanggan.setVisible(false);
            sub_highlight_tamu.setVisible(true);
        } else {
            sub_highlight_pelanggan.setVisible(true);
            sub_highlight_tamu.setVisible(false);
        }
    }//GEN-LAST:event_menu_pelangganMouseClicked

    private void menu_keuanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_keuanganMouseClicked
        clear_highlight();
        highlight_keuangan.setVisible(true);
    }//GEN-LAST:event_menu_keuanganMouseClicked

    private void TABLE_TAMUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLE_TAMUMouseClicked
        int row = TABLE_TAMU.getSelectedRow();
        int kolom = TABLE_TAMU.getSelectedColumn();
        System.out.println("row : "+row+", kolom : "+kolom+", value : "+TABLE_TAMU.getValueAt(row, kolom));
        UPDATE_INFO(row,"Tamu");
    }//GEN-LAST:event_TABLE_TAMUMouseClicked

    private void sub_tamuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_tamuMouseClicked
        sub_highlight_pelanggan.setVisible(false);
        sub_highlight_tamu.setVisible(true);
        PANEL_PELANGGAN_TAMU.setVisible(true);
        PANEL_PELANGGAN.setVisible(false);
        UPDATE_INFO(0,"Tamu");
    }//GEN-LAST:event_sub_tamuMouseClicked

    private void sub_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_pelangganMouseClicked
        sub_highlight_pelanggan.setVisible(true);
        sub_highlight_tamu.setVisible(false);
        PANEL_PELANGGAN_TAMU.setVisible(false);
        PANEL_PELANGGAN.setVisible(true);
        UPDATE_INFO(0,"Pelanggan");
    }//GEN-LAST:event_sub_pelangganMouseClicked

    private void TABLE_PELANGGANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLE_PELANGGANMouseClicked
        int row = TABLE_PELANGGAN.getSelectedRow();
        int kolom = TABLE_PELANGGAN.getSelectedColumn();
        System.out.println("row : "+row+", kolom : "+kolom+", value : "+TABLE_PELANGGAN.getValueAt(row, kolom));
        UPDATE_INFO(row,"Pelanggan");
    }//GEN-LAST:event_TABLE_PELANGGANMouseClicked

    private void sub_check_inMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_check_inMouseClicked
        sub_highlight_check_in.setVisible(true);
        sub_highlight_check_out.setVisible(false);
        PANEL_TRANSAKSI_CHECK_IN.setVisible(true);
        PANEL_TRANSAKSI_CHECKOUT.setVisible(false);
        
    }//GEN-LAST:event_sub_check_inMouseClicked

    private void sub_check_outMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_check_outMouseClicked
        sub_highlight_check_in.setVisible(false);
        sub_highlight_check_out.setVisible(true);
        PANEL_TRANSAKSI_CHECK_IN.setVisible(false);
        PANEL_TRANSAKSI_CHECKOUT.setVisible(true);
  
    }//GEN-LAST:event_sub_check_outMouseClicked

    private void txt_tanggal_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggal_daftarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggal_daftarActionPerformed

    private void txt_akumulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_akumulasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_akumulasiActionPerformed

    private void tbl_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_batalMouseClicked
        CLEAR_CHECK_IN_FORM();
    }//GEN-LAST:event_tbl_batalMouseClicked
    
    private void CLEAR_CHECK_IN_FORM() {
        txt_ID.setText("");
        txt_nama.setText("");
        txt_akumulasi.setText("0");
        txt_nik.setText("");
        txt_tanggal_check_in.setText("");
        txt_tanggal_check_out.setText("");
        txt_tanggal_daftar.setText("");
        txt_tanggal_lahir.setText("");
        txt_tempat_lahir.setText("");
        txt_tanggal_check_in.setText("");
        txt_tanggal_check_out.setText("");
    }
    
    private void cbo_daftar_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_daftar_pelangganActionPerformed

        int index = cbo_daftar_pelanggan.getSelectedIndex();
        
        if (index > 0) {
            index--;
            txt_ID.setText(user.GET_ID_BY_INDEX(index));
            txt_nik.setText(user.GET_NIK_BY_INDEX(index));
            txt_nama.setText(user.GET_NAMA_BY_INDEX(index));
            txt_tempat_lahir.setText(user.GET_TEMPAT_LAHIR_BY_INDEX(index));
            txt_tanggal_lahir.setText(user.GET_FORMATTED_TGL_LAHIR_BY_INDEX(index));
            txt_tanggal_daftar.setText(user.GET_FORMATTED_TGL_DAFTAR_BY_INDEX(index));
            txt_akumulasi.setText(Integer.toString(user.GET_AKUMULASI(index)));
        }
    }//GEN-LAST:event_cbo_daftar_pelangganActionPerformed

    private void txt_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDKeyPressed

    private void txt_IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IDKeyReleased
        int index = user.scan_ID(txt_ID.getText());
        
        if (index >= 0) {
            txt_ID.setText(user.GET_ID_BY_INDEX(index));
            txt_nik.setText(user.GET_NIK_BY_INDEX(index));
            txt_nama.setText(user.GET_NAMA_BY_INDEX(index));
            txt_tempat_lahir.setText(user.GET_TEMPAT_LAHIR_BY_INDEX(index));
            txt_tanggal_lahir.setText(user.GET_FORMATTED_TGL_LAHIR_BY_INDEX(index));
            txt_tanggal_daftar.setText(user.GET_FORMATTED_TGL_DAFTAR_BY_INDEX(index));
            txt_akumulasi.setText(Integer.toString(user.GET_AKUMULASI(index)));
        }
    }//GEN-LAST:event_txt_IDKeyReleased

    private void cbo_paket_kamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_paket_kamarActionPerformed
        String jenis_kamar = (String) cbo_paket_kamar.getSelectedItem();
        int index_kamar = kamar.GET_KAMAR_KOSONG(jenis_kamar);
        if (index_kamar >= 0) {
            txt_no_kamar.setText(kamar.GET_NO_KAMAR_BY_INDEX(index_kamar));
        } else {
            txt_no_kamar.setText("KAMAR PENUH");
        }
    }//GEN-LAST:event_cbo_paket_kamarActionPerformed

    private void tbl_check_inMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_check_inMouseClicked
        String ID = txt_ID.getText();
        String NIK = txt_nik.getText();
        String NAMA = txt_nama.getText();
        String TEMPAT_LAHIR = txt_tempat_lahir.getText();
        String TANGGAL_LAHIR = txt_tanggal_lahir.getText();
        String TANGGAL_DAFTAR = txt_tanggal_daftar.getText();
        String AKUMULASI = txt_akumulasi.getText();
        String NO_KAMAR = txt_no_kamar.getText();
        String CHECK_IN = txt_tanggal_check_in.getText();
        String CHECK_OUT = txt_tanggal_check_out.getText();
        
        CLEAR_TABLE();
        int jam_check_in = Integer.parseInt(dt.GET_CURRENT_TIME("H"));
        tamu.TAMBAH_TAMU(ID, NIK, NAMA, TEMPAT_LAHIR, TANGGAL_LAHIR, TANGGAL_DAFTAR, AKUMULASI, NO_KAMAR, CHECK_IN, CHECK_OUT, jam_check_in);
        INIT_DATA();
        CLEAR_CHECK_IN_FORM();
        tamu.UPDATE_MASTER_DATABASE();
        user.UPDATE_MASTER_DATABASE();
        kamar.UPDATE_MASTER_DATABASE();
    }//GEN-LAST:event_tbl_check_inMouseClicked

    private void BG_REGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BG_REGMouseClicked
        OPEN_CHECK_IN_FORM(0);
    }//GEN-LAST:event_BG_REGMouseClicked

    private void BG_PRE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BG_PRE1MouseClicked
        OPEN_CHECK_IN_FORM(1);
    }//GEN-LAST:event_BG_PRE1MouseClicked

    private void BG_SUITEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BG_SUITEMouseClicked
        OPEN_CHECK_IN_FORM(2);
    }//GEN-LAST:event_BG_SUITEMouseClicked

    private void BG_VIPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BG_VIPMouseClicked
        OPEN_CHECK_IN_FORM(3);
    }//GEN-LAST:event_BG_VIPMouseClicked

    private void cbo_tamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tamuActionPerformed
          int index = cbo_tamu.getSelectedIndex();
        
        if (index > 0) {
            index--;
            lbl_co_nama.setText(tamu.GET_NAMA_BY_INDEX(index));
            lbl_co_checkin.setText(tamu.GET_STRING_CHECK_IN_BY_INDEX(index));
            lbl_co_lama.setText(Integer.toString(tamu.GET_LAMA_INAP_BY_INDEX(index)) + " Hari");
            lbl_co_kamar.setText(tamu.GET_KAMAR_BY_INDEX(index) + " - "+ kamar.GET_JENIS_KAMAR_BY_NO_KAMAR(tamu.GET_KAMAR_BY_INDEX(index)));
            //String.format("%.0f", Double.toString(trans.GET_BIAYA_KAMAR(index)))
            lbl_co_biaya.setText(Double.toString(trans.GET_BIAYA_KAMAR(index)));
            lbl_co_diskon.setText(Double.toString(trans.GET_DISKON_KAMAR(index)));
            lbl_co_denda.setText(Double.toString(trans.GET_DENDA(index)));
            lbl_co_total.setText(Double.toString(trans.GET_TOTAL(trans.GET_BIAYA_KAMAR(index), trans.GET_DISKON_KAMAR(index), trans.GET_DENDA(index))));
        } 
    }//GEN-LAST:event_cbo_tamuActionPerformed

    private void txt_ID_ceck_outKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ID_ceck_outKeyReleased
        int index = tamu.scan_ID(txt_ID_ceck_out.getText());
        
        if (index >= 0) {
            lbl_co_nama.setText(tamu.GET_NAMA_BY_INDEX(index));
            lbl_co_checkin.setText(tamu.GET_STRING_CHECK_IN_BY_INDEX(index));
            lbl_co_lama.setText(Integer.toString(tamu.GET_LAMA_INAP_BY_INDEX(index)) + " Hari");
            lbl_co_kamar.setText(tamu.GET_KAMAR_BY_INDEX(index) + " - " + kamar.GET_JENIS_KAMAR_BY_NO_KAMAR(tamu.GET_KAMAR_BY_INDEX(index)));
            //String.format("%.0f", Double.toString(trans.GET_BIAYA_KAMAR(index)))
            lbl_co_biaya.setText(Double.toString(trans.GET_BIAYA_KAMAR(index)));
            lbl_co_diskon.setText(Double.toString(trans.GET_DISKON_KAMAR(index)));
            lbl_co_denda.setText(Double.toString(trans.GET_DENDA(index)));
            lbl_co_total.setText(Double.toString(trans.GET_TOTAL(trans.GET_BIAYA_KAMAR(index), trans.GET_DISKON_KAMAR(index), trans.GET_DENDA(index))));
        }
    }//GEN-LAST:event_txt_ID_ceck_outKeyReleased
    
    public void OPEN_CHECK_IN_FORM (int jenis_kamar){
        clear_highlight();
        highlight_transaksi.setVisible(true);
        CLEAR_PANEL();
        PANEL_TRANSAKSI_CHECK_IN.setVisible(true);
        PANEL_SUBMENU_TRANSAKSI.setVisible(true);
        sub_highlight_check_in.setVisible(true);
        sub_highlight_check_out.setVisible(false);
        CLEAR_CHECK_IN_FORM();
        cbo_paket_kamar.setSelectedIndex(jenis_kamar);
    }
    public void UPDATE_INFO(int index, String Table) {
        //atbel tamu
        if (Table.equalsIgnoreCase("Tamu")) {
            lbl_nama_tamu.setText((String) TABLE_TAMU.getValueAt(index, 2));
            lbl_nik_tamu.setText((String) TABLE_TAMU.getValueAt(index, 1));
            lbl_ID_tamu.setText((String) TABLE_TAMU.getValueAt(index, 0));
            lbl_kamar_tamu.setText((String) TABLE_TAMU.getValueAt(index, 3));
            lbl_ci_tamu.setText((String) TABLE_TAMU.getValueAt(index, 4));
            lbl_co_tamu.setText((String) TABLE_TAMU.getValueAt(index, 5));
            lbl_diskon_tamu.setText(tamu.GET_DISKON_BY_INDEX(index));
        } else {
            //tabel pelanggan
            lbl_nama_pelanggan.setText((String) TABLE_PELANGGAN.getValueAt(index, 2));
            lbl_nik_pelanggan.setText((String) TABLE_PELANGGAN.getValueAt(index, 1));
            lbl_ID_pelanggan.setText((String) TABLE_PELANGGAN.getValueAt(index, 0));
            lbl_akumulasi_pelanggan.setText((Integer.toString(user.GET_AKUMULASI(index))) + " Hari");
            lbl_tgl_lahir_pelanggan.setText(user.STRING_TANGGAL_LAHIR(index));
            lbl_tgl_daftar_pelanggan.setText(user.STRING_TANGGAL_DAFTAR(index));
            lbl_tempat_lahir_pelanggan.setText(user.GET_TEMPAT_LAHIR_BY_INDEX(index));
        }
    }

    public void CLEAR_PANEL(){
        PANEL_BERANDA_OVERVIEW.setVisible(false);
        PANEL_PELANGGAN.setVisible(false);
        PANEL_PELANGGAN_TAMU.setVisible(false);
        PANEL_SUBMENU_PELANGGAN.setVisible(false);
        PANEL_SUBMENU_TRANSAKSI.setVisible(false);
        PANEL_TRANSAKSI_CHECK_IN.setVisible(false);
        PANEL_TRANSAKSI_CHECKOUT.setVisible(false);
    }
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_PRE1;
    private javax.swing.JLabel BG_REG;
    private javax.swing.JLabel BG_SUITE;
    private javax.swing.JLabel BG_VIP;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel JUMLAH_KAMAR_DIPESAN;
    private javax.swing.JLabel JUMLAH_KAMAR_TERSEDIA;
    private javax.swing.JLabel JUMLAH_PELANGGAN;
    private javax.swing.JLabel JUMLAH_PRE_DIPESAN;
    private javax.swing.JLabel JUMLAH_PRE_TERSEDIA;
    private javax.swing.JLabel JUMLAH_REG_DIPESAN;
    private javax.swing.JLabel JUMLAH_REG_TERSEDIA;
    private javax.swing.JLabel JUMLAH_SUI_DIPESAN;
    private javax.swing.JLabel JUMLAH_SUI_TERSEDIA;
    private javax.swing.JLabel JUMLAH_TAMU;
    private javax.swing.JLabel JUMLAH_VIP_DIPESAN;
    private javax.swing.JLabel JUMLAH_VIP_TERSEDIA;
    private javax.swing.JLabel LABEL;
    private javax.swing.JLabel LABEL1;
    private javax.swing.JLabel LABEL10;
    private javax.swing.JLabel LABEL11;
    private javax.swing.JLabel LABEL2;
    private javax.swing.JLabel LABEL3;
    private javax.swing.JLabel LABEL4;
    private javax.swing.JLabel LABEL5;
    private javax.swing.JLabel LABEL6;
    private javax.swing.JLabel LABEL7;
    private javax.swing.JLabel LABEL8;
    private javax.swing.JLabel LABEL9;
    private javax.swing.JLayeredPane PANEL_BERANDA_OVERVIEW;
    private javax.swing.JLayeredPane PANEL_PELANGGAN;
    private javax.swing.JLayeredPane PANEL_PELANGGAN_TAMU;
    private javax.swing.JLayeredPane PANEL_SUBMENU_PELANGGAN;
    private javax.swing.JLayeredPane PANEL_SUBMENU_TRANSAKSI;
    private javax.swing.JLayeredPane PANEL_TRANSAKSI_CHECKOUT;
    private javax.swing.JLayeredPane PANEL_TRANSAKSI_CHECK_IN;
    private javax.swing.JTable TABLE_PELANGGAN;
    private javax.swing.JTable TABLE_TAMU;
    private javax.swing.JLabel btn_checkout;
    private javax.swing.JComboBox cbo_daftar_pelanggan;
    private javax.swing.JComboBox cbo_paket_kamar;
    private javax.swing.JComboBox cbo_tamu;
    private javax.swing.JLabel color;
    private javax.swing.JLabel color1;
    private javax.swing.JLabel color2;
    private javax.swing.JLabel color3;
    private javax.swing.JLabel color4;
    private javax.swing.JLabel color5;
    private javax.swing.JLabel color6;
    private javax.swing.JLabel highlight_beranda;
    private javax.swing.JLabel highlight_keuangan;
    private javax.swing.JLabel highlight_pelanggan;
    private javax.swing.JLabel highlight_transaksi;
    private javax.swing.JLabel icon_beranda;
    private javax.swing.JLabel icon_keuangan;
    private javax.swing.JLabel icon_pelanggan;
    private javax.swing.JLabel icon_plus;
    private javax.swing.JLabel icon_plus1;
    private javax.swing.JLabel icon_plus2;
    private javax.swing.JLabel icon_plus3;
    private javax.swing.JLabel icon_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_ID_pelanggan;
    private javax.swing.JLabel lbl_ID_tamu;
    private javax.swing.JLabel lbl_akumulasi_pelanggan;
    private javax.swing.JLabel lbl_ci_tamu;
    private javax.swing.JLabel lbl_co_biaya;
    private javax.swing.JLabel lbl_co_checkin;
    private javax.swing.JLabel lbl_co_denda;
    private javax.swing.JLabel lbl_co_diskon;
    private javax.swing.JLabel lbl_co_kamar;
    private javax.swing.JLabel lbl_co_lama;
    private javax.swing.JLabel lbl_co_nama;
    private javax.swing.JLabel lbl_co_tamu;
    private javax.swing.JLabel lbl_co_total;
    private javax.swing.JLabel lbl_diskon_tamu;
    private javax.swing.JLabel lbl_jam;
    private javax.swing.JLabel lbl_jum_pelanggan;
    private javax.swing.JLabel lbl_kamar_tamu;
    private javax.swing.JLabel lbl_kembalian;
    private javax.swing.JLabel lbl_nama_pelanggan;
    private javax.swing.JLabel lbl_nama_tamu;
    private javax.swing.JLabel lbl_nik_pelanggan;
    private javax.swing.JLabel lbl_nik_tamu;
    private javax.swing.JLabel lbl_no_kamar1;
    private javax.swing.JLabel lbl_no_kamar10;
    private javax.swing.JLabel lbl_no_kamar11;
    private javax.swing.JLabel lbl_no_kamar2;
    private javax.swing.JLabel lbl_no_kamar3;
    private javax.swing.JLabel lbl_no_kamar4;
    private javax.swing.JLabel lbl_no_kamar5;
    private javax.swing.JLabel lbl_no_kamar6;
    private javax.swing.JLabel lbl_no_kamar7;
    private javax.swing.JLabel lbl_no_kamar8;
    private javax.swing.JLabel lbl_no_kamar9;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_tempat_lahir_pelanggan;
    private javax.swing.JLabel lbl_tgl_daftar_pelanggan;
    private javax.swing.JLabel lbl_tgl_lahir_pelanggan;
    private javax.swing.JLabel menu_beranda;
    private javax.swing.JLabel menu_keuangan;
    private javax.swing.JLabel menu_pelanggan;
    private javax.swing.JLabel menu_transaksi;
    private javax.swing.JLabel sub_check_in;
    private javax.swing.JLabel sub_check_out;
    private javax.swing.JLabel sub_highlight_check_in;
    private javax.swing.JLabel sub_highlight_check_out;
    private javax.swing.JLabel sub_highlight_pelanggan;
    private javax.swing.JLabel sub_highlight_tamu;
    private javax.swing.JLabel sub_pelanggan;
    private javax.swing.JLabel sub_tamu;
    private javax.swing.JLabel tbl_batal;
    private javax.swing.JLabel tbl_check_in;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_ID_ceck_out;
    private javax.swing.JTextField txt_akumulasi;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nik;
    private javax.swing.JLabel txt_no_kamar;
    private javax.swing.JTextField txt_tanggal_check_in;
    private javax.swing.JTextField txt_tanggal_check_out;
    private javax.swing.JTextField txt_tanggal_daftar;
    private javax.swing.JTextField txt_tanggal_lahir;
    private javax.swing.JTextField txt_tempat_lahir;
    // End of variables declaration//GEN-END:variables
}
