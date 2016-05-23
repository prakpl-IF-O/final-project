package Hotel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ltf
 */
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class panel_kamar extends javax.swing.JFrame {

    /**
     * Creates new form panel_kamar
     */
    public panel_kamar() throws SQLException {
        initComponents();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false", "steven", "1111");
        Statement stmt = con.createStatement();
        String select = String.format("select * from kamar");
        ResultSet rset = stmt.executeQuery(select);
        boolean[] cek = new boolean[100];
        int i = 0;
        JLabel[] jl = new JLabel[100];
        while (rset.next()) {
            cek[i] = rset.getBoolean("isSewa");
            if (cek[i] == true) {
                jl[i] = new JLabel();
                jl[i].setBackground(Color.red);
            } else {
                jl[i] = new JLabel();
                jl[i].setBackground(Color.green);
            }
            i++;
        }
        label1.setBackground(jl[0].getBackground());
        label2.setBackground(jl[1].getBackground());
        label3.setBackground(jl[2].getBackground());
        label4.setBackground(jl[3].getBackground());
        label5.setBackground(jl[4].getBackground());
        label6.setBackground(jl[5].getBackground());
        label7.setBackground(jl[6].getBackground());
        label8.setBackground(jl[7].getBackground());
        label9.setBackground(jl[8].getBackground());
        label10.setBackground(jl[9].getBackground());
        label11.setBackground(jl[10].getBackground());
        label12.setBackground(jl[11].getBackground());
        label13.setBackground(jl[12].getBackground());
        label14.setBackground(jl[13].getBackground());
        label15.setBackground(jl[14].getBackground());
        label16.setBackground(jl[15].getBackground());
        label17.setBackground(jl[16].getBackground());
        label18.setBackground(jl[17].getBackground());
        label19.setBackground(jl[18].getBackground());
        label20.setBackground(jl[19].getBackground());
        label21.setBackground(jl[20].getBackground());
        label22.setBackground(jl[21].getBackground());
        label23.setBackground(jl[22].getBackground());
        label24.setBackground(jl[23].getBackground());
        label25.setBackground(jl[24].getBackground());
        label26.setBackground(jl[25].getBackground());
        label27.setBackground(jl[26].getBackground());
        label28.setBackground(jl[27].getBackground());
        label29.setBackground(jl[28].getBackground());
        label30.setBackground(jl[29].getBackground());
        label31.setBackground(jl[30].getBackground());
        label32.setBackground(jl[31].getBackground());
        label33.setBackground(jl[32].getBackground());
        label34.setBackground(jl[33].getBackground());
        label35.setBackground(jl[34].getBackground());
        label36.setBackground(jl[35].getBackground());
        label37.setBackground(jl[36].getBackground());
        label38.setBackground(jl[37].getBackground());
        label39.setBackground(jl[38].getBackground());
        label40.setBackground(jl[39].getBackground());
        label41.setBackground(jl[40].getBackground());
        label42.setBackground(jl[41].getBackground());
        label43.setBackground(jl[42].getBackground());
        label44.setBackground(jl[43].getBackground());
        label45.setBackground(jl[44].getBackground());
        label46.setBackground(jl[45].getBackground());
        label47.setBackground(jl[46].getBackground());
        label48.setBackground(jl[47].getBackground());
        label49.setBackground(jl[48].getBackground());
        label50.setBackground(jl[49].getBackground());
        label51.setBackground(jl[50].getBackground());
        label52.setBackground(jl[51].getBackground());
        label53.setBackground(jl[52].getBackground());
        label54.setBackground(jl[53].getBackground());
        label55.setBackground(jl[54].getBackground());
        label56.setBackground(jl[55].getBackground());
        label57.setBackground(jl[56].getBackground());
        label58.setBackground(jl[57].getBackground());
        label59.setBackground(jl[58].getBackground());
        label60.setBackground(jl[59].getBackground());
        label61.setBackground(jl[60].getBackground());
        label62.setBackground(jl[61].getBackground());
        label63.setBackground(jl[62].getBackground());
        label64.setBackground(jl[63].getBackground());
        label65.setBackground(jl[64].getBackground());
        label66.setBackground(jl[65].getBackground());
        label67.setBackground(jl[66].getBackground());
        label68.setBackground(jl[67].getBackground());
        label69.setBackground(jl[68].getBackground());
        label70.setBackground(jl[69].getBackground());
        label71.setBackground(jl[70].getBackground());
        label72.setBackground(jl[71].getBackground());
        label73.setBackground(jl[72].getBackground());
        label74.setBackground(jl[73].getBackground());
        label75.setBackground(jl[74].getBackground());
        label76.setBackground(jl[75].getBackground());
        label77.setBackground(jl[76].getBackground());
        label78.setBackground(jl[77].getBackground());
        label79.setBackground(jl[78].getBackground());
        label80.setBackground(jl[79].getBackground());
        label81.setBackground(jl[80].getBackground());
        label82.setBackground(jl[81].getBackground());
        label83.setBackground(jl[82].getBackground());
        label84.setBackground(jl[83].getBackground());
        label85.setBackground(jl[84].getBackground());
        label86.setBackground(jl[85].getBackground());
        label87.setBackground(jl[86].getBackground());
        label88.setBackground(jl[87].getBackground());
        label89.setBackground(jl[88].getBackground());
        label90.setBackground(jl[89].getBackground());
        label91.setBackground(jl[90].getBackground());
        label92.setBackground(jl[91].getBackground());
        label93.setBackground(jl[92].getBackground());
        label94.setBackground(jl[93].getBackground());
        label95.setBackground(jl[94].getBackground());
        label96.setBackground(jl[95].getBackground());
        label97.setBackground(jl[96].getBackground());
        label98.setBackground(jl[97].getBackground());
        label99.setBackground(jl[98].getBackground());
        label100.setBackground(jl[99].getBackground());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_premium1 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        label15 = new javax.swing.JLabel();
        label16 = new javax.swing.JLabel();
        label17 = new javax.swing.JLabel();
        label18 = new javax.swing.JLabel();
        label19 = new javax.swing.JLabel();
        label20 = new javax.swing.JLabel();
        label21 = new javax.swing.JLabel();
        label22 = new javax.swing.JLabel();
        label23 = new javax.swing.JLabel();
        label24 = new javax.swing.JLabel();
        label25 = new javax.swing.JLabel();
        label26 = new javax.swing.JLabel();
        label27 = new javax.swing.JLabel();
        label28 = new javax.swing.JLabel();
        label29 = new javax.swing.JLabel();
        label30 = new javax.swing.JLabel();
        label31 = new javax.swing.JLabel();
        label32 = new javax.swing.JLabel();
        label33 = new javax.swing.JLabel();
        label34 = new javax.swing.JLabel();
        label35 = new javax.swing.JLabel();
        label36 = new javax.swing.JLabel();
        label37 = new javax.swing.JLabel();
        label38 = new javax.swing.JLabel();
        label39 = new javax.swing.JLabel();
        label40 = new javax.swing.JLabel();
        label41 = new javax.swing.JLabel();
        label42 = new javax.swing.JLabel();
        label43 = new javax.swing.JLabel();
        label44 = new javax.swing.JLabel();
        label45 = new javax.swing.JLabel();
        label46 = new javax.swing.JLabel();
        label47 = new javax.swing.JLabel();
        label48 = new javax.swing.JLabel();
        label49 = new javax.swing.JLabel();
        label50 = new javax.swing.JLabel();
        label51 = new javax.swing.JLabel();
        label52 = new javax.swing.JLabel();
        label53 = new javax.swing.JLabel();
        label54 = new javax.swing.JLabel();
        label55 = new javax.swing.JLabel();
        label56 = new javax.swing.JLabel();
        label57 = new javax.swing.JLabel();
        label58 = new javax.swing.JLabel();
        label59 = new javax.swing.JLabel();
        label60 = new javax.swing.JLabel();
        label61 = new javax.swing.JLabel();
        label62 = new javax.swing.JLabel();
        label63 = new javax.swing.JLabel();
        label64 = new javax.swing.JLabel();
        label65 = new javax.swing.JLabel();
        label66 = new javax.swing.JLabel();
        label67 = new javax.swing.JLabel();
        label68 = new javax.swing.JLabel();
        label69 = new javax.swing.JLabel();
        label70 = new javax.swing.JLabel();
        label71 = new javax.swing.JLabel();
        label72 = new javax.swing.JLabel();
        label73 = new javax.swing.JLabel();
        label74 = new javax.swing.JLabel();
        label75 = new javax.swing.JLabel();
        label76 = new javax.swing.JLabel();
        label77 = new javax.swing.JLabel();
        label78 = new javax.swing.JLabel();
        label79 = new javax.swing.JLabel();
        label80 = new javax.swing.JLabel();
        label81 = new javax.swing.JLabel();
        label82 = new javax.swing.JLabel();
        label83 = new javax.swing.JLabel();
        label84 = new javax.swing.JLabel();
        label85 = new javax.swing.JLabel();
        label86 = new javax.swing.JLabel();
        label87 = new javax.swing.JLabel();
        label88 = new javax.swing.JLabel();
        label89 = new javax.swing.JLabel();
        label90 = new javax.swing.JLabel();
        label91 = new javax.swing.JLabel();
        label92 = new javax.swing.JLabel();
        label93 = new javax.swing.JLabel();
        label94 = new javax.swing.JLabel();
        label95 = new javax.swing.JLabel();
        label96 = new javax.swing.JLabel();
        label97 = new javax.swing.JLabel();
        label98 = new javax.swing.JLabel();
        label99 = new javax.swing.JLabel();
        label100 = new javax.swing.JLabel();
        label_premium = new javax.swing.JLabel();
        label_reguler = new javax.swing.JLabel();
        label_VIP2 = new javax.swing.JLabel();
        label_suite = new javax.swing.JLabel();

        label_premium1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        label_premium1.setForeground(new java.awt.Color(102, 102, 255));
        label_premium1.setText("Premium");

        setMaximumSize(new java.awt.Dimension(430, 600));
        setMinimumSize(new java.awt.Dimension(430, 600));
        getContentPane().setLayout(null);

        label1.setBackground(new java.awt.Color(0, 255, 102));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("1");
        label1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label1.setOpaque(true);
        getContentPane().add(label1);
        label1.setBounds(10, 440, 30, 18);

        label2.setBackground(new java.awt.Color(0, 255, 102));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("2");
        label2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label2.setOpaque(true);
        getContentPane().add(label2);
        label2.setBounds(50, 440, 30, 18);

        label3.setBackground(new java.awt.Color(0, 255, 102));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setText("3");
        label3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label3.setOpaque(true);
        getContentPane().add(label3);
        label3.setBounds(90, 440, 30, 18);

        label4.setBackground(new java.awt.Color(0, 255, 102));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setText("4");
        label4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label4.setOpaque(true);
        getContentPane().add(label4);
        label4.setBounds(130, 440, 30, 18);

        label5.setBackground(new java.awt.Color(0, 255, 102));
        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setText("5");
        label5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label5.setOpaque(true);
        getContentPane().add(label5);
        label5.setBounds(170, 440, 30, 18);

        label6.setBackground(new java.awt.Color(0, 255, 102));
        label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label6.setText("6");
        label6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label6.setOpaque(true);
        getContentPane().add(label6);
        label6.setBounds(210, 440, 30, 18);

        label7.setBackground(new java.awt.Color(0, 255, 102));
        label7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label7.setText("7");
        label7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label7.setOpaque(true);
        getContentPane().add(label7);
        label7.setBounds(250, 440, 30, 18);

        label8.setBackground(new java.awt.Color(0, 255, 102));
        label8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label8.setText("8");
        label8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label8.setOpaque(true);
        getContentPane().add(label8);
        label8.setBounds(290, 440, 30, 18);

        label9.setBackground(new java.awt.Color(0, 255, 102));
        label9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label9.setText("9");
        label9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label9.setOpaque(true);
        getContentPane().add(label9);
        label9.setBounds(330, 440, 30, 18);

        label10.setBackground(new java.awt.Color(0, 255, 102));
        label10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label10.setText("10");
        label10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label10.setOpaque(true);
        getContentPane().add(label10);
        label10.setBounds(370, 440, 30, 18);

        label11.setBackground(new java.awt.Color(0, 255, 102));
        label11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label11.setText("11");
        label11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label11.setOpaque(true);
        getContentPane().add(label11);
        label11.setBounds(10, 410, 30, 18);

        label12.setBackground(new java.awt.Color(0, 255, 102));
        label12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label12.setText("12");
        label12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label12.setOpaque(true);
        getContentPane().add(label12);
        label12.setBounds(50, 410, 30, 18);

        label13.setBackground(new java.awt.Color(0, 255, 102));
        label13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label13.setText("13");
        label13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label13.setOpaque(true);
        getContentPane().add(label13);
        label13.setBounds(90, 410, 30, 18);

        label14.setBackground(new java.awt.Color(0, 255, 102));
        label14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label14.setText("14");
        label14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label14.setOpaque(true);
        getContentPane().add(label14);
        label14.setBounds(130, 410, 30, 18);

        label15.setBackground(new java.awt.Color(0, 255, 102));
        label15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label15.setText("15");
        label15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label15.setOpaque(true);
        getContentPane().add(label15);
        label15.setBounds(170, 410, 30, 18);

        label16.setBackground(new java.awt.Color(0, 255, 102));
        label16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label16.setText("16");
        label16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label16.setOpaque(true);
        getContentPane().add(label16);
        label16.setBounds(210, 410, 30, 18);

        label17.setBackground(new java.awt.Color(0, 255, 102));
        label17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label17.setText("17");
        label17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label17.setOpaque(true);
        getContentPane().add(label17);
        label17.setBounds(250, 410, 30, 18);

        label18.setBackground(new java.awt.Color(0, 255, 102));
        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("18");
        label18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label18.setOpaque(true);
        getContentPane().add(label18);
        label18.setBounds(290, 410, 30, 18);

        label19.setBackground(new java.awt.Color(0, 255, 102));
        label19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label19.setText("19");
        label19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label19.setOpaque(true);
        getContentPane().add(label19);
        label19.setBounds(330, 410, 30, 18);

        label20.setBackground(new java.awt.Color(0, 255, 102));
        label20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label20.setText("20");
        label20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label20.setOpaque(true);
        getContentPane().add(label20);
        label20.setBounds(370, 410, 30, 18);

        label21.setBackground(new java.awt.Color(0, 255, 102));
        label21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label21.setText("21");
        label21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label21.setOpaque(true);
        getContentPane().add(label21);
        label21.setBounds(10, 380, 30, 18);

        label22.setBackground(new java.awt.Color(0, 255, 102));
        label22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label22.setText("22");
        label22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label22.setOpaque(true);
        getContentPane().add(label22);
        label22.setBounds(50, 380, 30, 18);

        label23.setBackground(new java.awt.Color(0, 255, 102));
        label23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label23.setText("23");
        label23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label23.setOpaque(true);
        getContentPane().add(label23);
        label23.setBounds(90, 380, 30, 18);

        label24.setBackground(new java.awt.Color(0, 255, 102));
        label24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label24.setText("24");
        label24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label24.setOpaque(true);
        getContentPane().add(label24);
        label24.setBounds(130, 380, 30, 18);

        label25.setBackground(new java.awt.Color(0, 255, 102));
        label25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label25.setText("25");
        label25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label25.setOpaque(true);
        getContentPane().add(label25);
        label25.setBounds(170, 380, 30, 18);

        label26.setBackground(new java.awt.Color(0, 255, 102));
        label26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label26.setText("26");
        label26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label26.setOpaque(true);
        getContentPane().add(label26);
        label26.setBounds(210, 380, 30, 18);

        label27.setBackground(new java.awt.Color(0, 255, 102));
        label27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label27.setText("27");
        label27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label27.setOpaque(true);
        getContentPane().add(label27);
        label27.setBounds(250, 380, 30, 18);

        label28.setBackground(new java.awt.Color(0, 255, 102));
        label28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label28.setText("28");
        label28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label28.setOpaque(true);
        getContentPane().add(label28);
        label28.setBounds(290, 380, 30, 18);

        label29.setBackground(new java.awt.Color(0, 255, 102));
        label29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label29.setText("29");
        label29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label29.setOpaque(true);
        getContentPane().add(label29);
        label29.setBounds(330, 380, 30, 18);

        label30.setBackground(new java.awt.Color(0, 255, 102));
        label30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label30.setText("30");
        label30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label30.setOpaque(true);
        getContentPane().add(label30);
        label30.setBounds(370, 380, 30, 18);

        label31.setBackground(new java.awt.Color(0, 255, 102));
        label31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label31.setText("31");
        label31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label31.setOpaque(true);
        getContentPane().add(label31);
        label31.setBounds(10, 350, 30, 18);

        label32.setBackground(new java.awt.Color(0, 255, 102));
        label32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label32.setText("32");
        label32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label32.setOpaque(true);
        getContentPane().add(label32);
        label32.setBounds(50, 350, 30, 18);

        label33.setBackground(new java.awt.Color(0, 255, 102));
        label33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label33.setText("33");
        label33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label33.setOpaque(true);
        getContentPane().add(label33);
        label33.setBounds(90, 350, 30, 18);

        label34.setBackground(new java.awt.Color(0, 255, 102));
        label34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label34.setText("34");
        label34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label34.setOpaque(true);
        getContentPane().add(label34);
        label34.setBounds(130, 350, 30, 18);

        label35.setBackground(new java.awt.Color(0, 255, 102));
        label35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label35.setText("35");
        label35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label35.setOpaque(true);
        getContentPane().add(label35);
        label35.setBounds(170, 350, 30, 18);

        label36.setBackground(new java.awt.Color(0, 255, 102));
        label36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label36.setText("36");
        label36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label36.setOpaque(true);
        getContentPane().add(label36);
        label36.setBounds(210, 350, 30, 18);

        label37.setBackground(new java.awt.Color(0, 255, 102));
        label37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label37.setText("37");
        label37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label37.setOpaque(true);
        getContentPane().add(label37);
        label37.setBounds(250, 350, 30, 18);

        label38.setBackground(new java.awt.Color(0, 255, 102));
        label38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label38.setText("38");
        label38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label38.setOpaque(true);
        getContentPane().add(label38);
        label38.setBounds(290, 350, 30, 18);

        label39.setBackground(new java.awt.Color(0, 255, 102));
        label39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label39.setText("39");
        label39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label39.setOpaque(true);
        getContentPane().add(label39);
        label39.setBounds(330, 350, 30, 18);

        label40.setBackground(new java.awt.Color(0, 255, 102));
        label40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label40.setText("40");
        label40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label40.setOpaque(true);
        getContentPane().add(label40);
        label40.setBounds(370, 350, 30, 18);

        label41.setBackground(new java.awt.Color(0, 255, 102));
        label41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label41.setText("41");
        label41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label41.setOpaque(true);
        getContentPane().add(label41);
        label41.setBounds(10, 320, 30, 18);

        label42.setBackground(new java.awt.Color(0, 255, 102));
        label42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label42.setText("42");
        label42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label42.setOpaque(true);
        getContentPane().add(label42);
        label42.setBounds(50, 320, 30, 18);

        label43.setBackground(new java.awt.Color(0, 255, 102));
        label43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label43.setText("43");
        label43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label43.setOpaque(true);
        getContentPane().add(label43);
        label43.setBounds(90, 320, 30, 18);

        label44.setBackground(new java.awt.Color(0, 255, 102));
        label44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label44.setText("44");
        label44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label44.setOpaque(true);
        getContentPane().add(label44);
        label44.setBounds(130, 320, 30, 18);

        label45.setBackground(new java.awt.Color(0, 255, 102));
        label45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label45.setText("45");
        label45.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label45.setOpaque(true);
        getContentPane().add(label45);
        label45.setBounds(170, 320, 30, 18);

        label46.setBackground(new java.awt.Color(0, 255, 102));
        label46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label46.setText("46");
        label46.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label46.setOpaque(true);
        getContentPane().add(label46);
        label46.setBounds(210, 320, 30, 18);

        label47.setBackground(new java.awt.Color(0, 255, 102));
        label47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label47.setText("47");
        label47.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label47.setOpaque(true);
        getContentPane().add(label47);
        label47.setBounds(250, 320, 30, 18);

        label48.setBackground(new java.awt.Color(0, 255, 102));
        label48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label48.setText("48");
        label48.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label48.setOpaque(true);
        getContentPane().add(label48);
        label48.setBounds(290, 320, 30, 18);

        label49.setBackground(new java.awt.Color(0, 255, 102));
        label49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label49.setText("49");
        label49.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label49.setOpaque(true);
        getContentPane().add(label49);
        label49.setBounds(330, 320, 30, 18);

        label50.setBackground(new java.awt.Color(0, 255, 102));
        label50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label50.setText("50");
        label50.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label50.setOpaque(true);
        getContentPane().add(label50);
        label50.setBounds(370, 320, 30, 18);

        label51.setBackground(new java.awt.Color(0, 255, 102));
        label51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label51.setText("51");
        label51.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label51.setOpaque(true);
        getContentPane().add(label51);
        label51.setBounds(10, 250, 30, 30);

        label52.setBackground(new java.awt.Color(0, 255, 102));
        label52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label52.setText("52");
        label52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label52.setOpaque(true);
        getContentPane().add(label52);
        label52.setBounds(50, 250, 30, 30);

        label53.setBackground(new java.awt.Color(0, 255, 102));
        label53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label53.setText("53");
        label53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label53.setOpaque(true);
        getContentPane().add(label53);
        label53.setBounds(90, 250, 30, 30);

        label54.setBackground(new java.awt.Color(0, 255, 102));
        label54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label54.setText("54");
        label54.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label54.setOpaque(true);
        getContentPane().add(label54);
        label54.setBounds(130, 250, 30, 30);

        label55.setBackground(new java.awt.Color(0, 255, 102));
        label55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label55.setText("55");
        label55.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label55.setOpaque(true);
        getContentPane().add(label55);
        label55.setBounds(170, 250, 30, 30);

        label56.setBackground(new java.awt.Color(0, 255, 102));
        label56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label56.setText("56");
        label56.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label56.setOpaque(true);
        getContentPane().add(label56);
        label56.setBounds(210, 250, 30, 30);

        label57.setBackground(new java.awt.Color(0, 255, 102));
        label57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label57.setText("57");
        label57.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label57.setOpaque(true);
        getContentPane().add(label57);
        label57.setBounds(250, 250, 30, 30);

        label58.setBackground(new java.awt.Color(0, 255, 102));
        label58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label58.setText("58");
        label58.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label58.setOpaque(true);
        getContentPane().add(label58);
        label58.setBounds(290, 250, 30, 30);

        label59.setBackground(new java.awt.Color(0, 255, 102));
        label59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label59.setText("59");
        label59.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label59.setOpaque(true);
        getContentPane().add(label59);
        label59.setBounds(330, 250, 30, 30);

        label60.setBackground(new java.awt.Color(0, 255, 102));
        label60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label60.setText("60");
        label60.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label60.setOpaque(true);
        getContentPane().add(label60);
        label60.setBounds(370, 250, 30, 30);

        label61.setBackground(new java.awt.Color(0, 255, 102));
        label61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label61.setText("61");
        label61.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label61.setOpaque(true);
        getContentPane().add(label61);
        label61.setBounds(10, 210, 30, 30);

        label62.setBackground(new java.awt.Color(0, 255, 102));
        label62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label62.setText("62");
        label62.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label62.setOpaque(true);
        getContentPane().add(label62);
        label62.setBounds(50, 210, 30, 30);

        label63.setBackground(new java.awt.Color(0, 255, 102));
        label63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label63.setText("63");
        label63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label63.setOpaque(true);
        getContentPane().add(label63);
        label63.setBounds(90, 210, 30, 30);

        label64.setBackground(new java.awt.Color(0, 255, 102));
        label64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label64.setText("64");
        label64.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label64.setOpaque(true);
        getContentPane().add(label64);
        label64.setBounds(130, 210, 30, 30);

        label65.setBackground(new java.awt.Color(0, 255, 102));
        label65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label65.setText("65");
        label65.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label65.setOpaque(true);
        getContentPane().add(label65);
        label65.setBounds(170, 210, 30, 30);

        label66.setBackground(new java.awt.Color(0, 255, 102));
        label66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label66.setText("66");
        label66.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label66.setOpaque(true);
        getContentPane().add(label66);
        label66.setBounds(210, 210, 30, 30);

        label67.setBackground(new java.awt.Color(0, 255, 102));
        label67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label67.setText("67");
        label67.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label67.setOpaque(true);
        getContentPane().add(label67);
        label67.setBounds(250, 210, 30, 30);

        label68.setBackground(new java.awt.Color(0, 255, 102));
        label68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label68.setText("68");
        label68.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label68.setOpaque(true);
        getContentPane().add(label68);
        label68.setBounds(290, 210, 30, 30);

        label69.setBackground(new java.awt.Color(0, 255, 102));
        label69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label69.setText("69");
        label69.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label69.setOpaque(true);
        getContentPane().add(label69);
        label69.setBounds(330, 210, 30, 30);

        label70.setBackground(new java.awt.Color(0, 255, 102));
        label70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label70.setText("70");
        label70.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label70.setOpaque(true);
        getContentPane().add(label70);
        label70.setBounds(370, 210, 30, 30);

        label71.setBackground(new java.awt.Color(0, 255, 102));
        label71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label71.setText("71");
        label71.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label71.setOpaque(true);
        getContentPane().add(label71);
        label71.setBounds(10, 150, 30, 30);

        label72.setBackground(new java.awt.Color(0, 255, 102));
        label72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label72.setText("72");
        label72.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label72.setOpaque(true);
        getContentPane().add(label72);
        label72.setBounds(50, 150, 30, 30);

        label73.setBackground(new java.awt.Color(0, 255, 102));
        label73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label73.setText("73");
        label73.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label73.setOpaque(true);
        getContentPane().add(label73);
        label73.setBounds(90, 150, 30, 30);

        label74.setBackground(new java.awt.Color(0, 255, 102));
        label74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label74.setText("74");
        label74.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label74.setOpaque(true);
        getContentPane().add(label74);
        label74.setBounds(130, 150, 30, 30);

        label75.setBackground(new java.awt.Color(0, 255, 102));
        label75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label75.setText("75");
        label75.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label75.setOpaque(true);
        getContentPane().add(label75);
        label75.setBounds(170, 150, 30, 30);

        label76.setBackground(new java.awt.Color(0, 255, 102));
        label76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label76.setText("76");
        label76.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label76.setOpaque(true);
        getContentPane().add(label76);
        label76.setBounds(210, 150, 30, 30);

        label77.setBackground(new java.awt.Color(0, 255, 102));
        label77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label77.setText("77");
        label77.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label77.setOpaque(true);
        getContentPane().add(label77);
        label77.setBounds(250, 150, 30, 30);

        label78.setBackground(new java.awt.Color(0, 255, 102));
        label78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label78.setText("78");
        label78.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label78.setOpaque(true);
        getContentPane().add(label78);
        label78.setBounds(290, 150, 30, 30);

        label79.setBackground(new java.awt.Color(0, 255, 102));
        label79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label79.setText("79");
        label79.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label79.setOpaque(true);
        getContentPane().add(label79);
        label79.setBounds(330, 150, 30, 30);

        label80.setBackground(new java.awt.Color(0, 255, 102));
        label80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label80.setText("80");
        label80.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label80.setOpaque(true);
        getContentPane().add(label80);
        label80.setBounds(370, 150, 30, 30);

        label81.setBackground(new java.awt.Color(0, 255, 102));
        label81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label81.setText("81");
        label81.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label81.setOpaque(true);
        getContentPane().add(label81);
        label81.setBounds(10, 110, 30, 30);

        label82.setBackground(new java.awt.Color(0, 255, 102));
        label82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label82.setText("82");
        label82.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label82.setOpaque(true);
        getContentPane().add(label82);
        label82.setBounds(50, 110, 30, 30);

        label83.setBackground(new java.awt.Color(0, 255, 102));
        label83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label83.setText("83");
        label83.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label83.setOpaque(true);
        getContentPane().add(label83);
        label83.setBounds(90, 110, 30, 30);

        label84.setBackground(new java.awt.Color(0, 255, 102));
        label84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label84.setText("84");
        label84.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label84.setOpaque(true);
        getContentPane().add(label84);
        label84.setBounds(130, 110, 30, 30);

        label85.setBackground(new java.awt.Color(0, 255, 102));
        label85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label85.setText("85");
        label85.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label85.setOpaque(true);
        getContentPane().add(label85);
        label85.setBounds(170, 110, 30, 30);

        label86.setBackground(new java.awt.Color(0, 255, 102));
        label86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label86.setText("86");
        label86.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label86.setOpaque(true);
        getContentPane().add(label86);
        label86.setBounds(210, 110, 30, 30);

        label87.setBackground(new java.awt.Color(0, 255, 102));
        label87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label87.setText("87");
        label87.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label87.setOpaque(true);
        getContentPane().add(label87);
        label87.setBounds(250, 110, 30, 30);

        label88.setBackground(new java.awt.Color(0, 255, 102));
        label88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label88.setText("88");
        label88.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label88.setOpaque(true);
        getContentPane().add(label88);
        label88.setBounds(290, 110, 30, 30);

        label89.setBackground(new java.awt.Color(0, 255, 102));
        label89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label89.setText("89");
        label89.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label89.setOpaque(true);
        getContentPane().add(label89);
        label89.setBounds(330, 110, 30, 30);

        label90.setBackground(new java.awt.Color(0, 255, 102));
        label90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label90.setText("90");
        label90.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label90.setOpaque(true);
        getContentPane().add(label90);
        label90.setBounds(370, 110, 30, 30);

        label91.setBackground(new java.awt.Color(0, 255, 102));
        label91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label91.setText("91");
        label91.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label91.setOpaque(true);
        getContentPane().add(label91);
        label91.setBounds(10, 30, 30, 40);

        label92.setBackground(new java.awt.Color(0, 255, 102));
        label92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label92.setText("92");
        label92.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label92.setOpaque(true);
        getContentPane().add(label92);
        label92.setBounds(50, 30, 30, 40);

        label93.setBackground(new java.awt.Color(0, 255, 102));
        label93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label93.setText("93");
        label93.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label93.setOpaque(true);
        getContentPane().add(label93);
        label93.setBounds(90, 30, 30, 40);

        label94.setBackground(new java.awt.Color(0, 255, 102));
        label94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label94.setText("94");
        label94.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label94.setOpaque(true);
        getContentPane().add(label94);
        label94.setBounds(130, 30, 30, 40);

        label95.setBackground(new java.awt.Color(0, 255, 102));
        label95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label95.setText("95");
        label95.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label95.setOpaque(true);
        getContentPane().add(label95);
        label95.setBounds(170, 30, 30, 40);

        label96.setBackground(new java.awt.Color(0, 255, 102));
        label96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label96.setText("96");
        label96.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label96.setOpaque(true);
        getContentPane().add(label96);
        label96.setBounds(210, 30, 30, 40);

        label97.setBackground(new java.awt.Color(0, 255, 102));
        label97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label97.setText("97");
        label97.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label97.setOpaque(true);
        getContentPane().add(label97);
        label97.setBounds(250, 30, 30, 40);

        label98.setBackground(new java.awt.Color(0, 255, 102));
        label98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label98.setText("98");
        label98.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label98.setOpaque(true);
        getContentPane().add(label98);
        label98.setBounds(290, 30, 30, 40);

        label99.setBackground(new java.awt.Color(0, 255, 102));
        label99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label99.setText("99");
        label99.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label99.setOpaque(true);
        getContentPane().add(label99);
        label99.setBounds(330, 30, 30, 40);

        label100.setBackground(new java.awt.Color(0, 255, 102));
        label100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label100.setText("100");
        label100.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label100.setOpaque(true);
        getContentPane().add(label100);
        label100.setBounds(370, 30, 30, 40);

        label_premium.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        label_premium.setForeground(new java.awt.Color(102, 102, 255));
        label_premium.setText("Suite (350k / day)");
        getContentPane().add(label_premium);
        label_premium.setBounds(10, 90, 160, 14);

        label_reguler.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        label_reguler.setForeground(new java.awt.Color(102, 102, 255));
        label_reguler.setText("Reguler (100k / day)");
        getContentPane().add(label_reguler);
        label_reguler.setBounds(10, 300, 160, 17);

        label_VIP2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        label_VIP2.setForeground(new java.awt.Color(102, 102, 255));
        label_VIP2.setText("VIP (750k / day)");
        getContentPane().add(label_VIP2);
        label_VIP2.setBounds(10, 10, 120, 17);

        label_suite.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        label_suite.setForeground(new java.awt.Color(102, 102, 255));
        label_suite.setText("Premium (200k / day)");
        getContentPane().add(label_suite);
        label_suite.setBounds(10, 190, 160, 17);

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
            java.util.logging.Logger.getLogger(panel_kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel_kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel_kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel_kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new panel_kamar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(panel_kamar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label100;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label19;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label20;
    private javax.swing.JLabel label21;
    private javax.swing.JLabel label22;
    private javax.swing.JLabel label23;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label26;
    private javax.swing.JLabel label27;
    private javax.swing.JLabel label28;
    private javax.swing.JLabel label29;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label30;
    private javax.swing.JLabel label31;
    private javax.swing.JLabel label32;
    private javax.swing.JLabel label33;
    private javax.swing.JLabel label34;
    private javax.swing.JLabel label35;
    private javax.swing.JLabel label36;
    private javax.swing.JLabel label37;
    private javax.swing.JLabel label38;
    private javax.swing.JLabel label39;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label40;
    private javax.swing.JLabel label41;
    private javax.swing.JLabel label42;
    private javax.swing.JLabel label43;
    private javax.swing.JLabel label44;
    private javax.swing.JLabel label45;
    private javax.swing.JLabel label46;
    private javax.swing.JLabel label47;
    private javax.swing.JLabel label48;
    private javax.swing.JLabel label49;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label50;
    private javax.swing.JLabel label51;
    private javax.swing.JLabel label52;
    private javax.swing.JLabel label53;
    private javax.swing.JLabel label54;
    private javax.swing.JLabel label55;
    private javax.swing.JLabel label56;
    private javax.swing.JLabel label57;
    private javax.swing.JLabel label58;
    private javax.swing.JLabel label59;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label60;
    private javax.swing.JLabel label61;
    private javax.swing.JLabel label62;
    private javax.swing.JLabel label63;
    private javax.swing.JLabel label64;
    private javax.swing.JLabel label65;
    private javax.swing.JLabel label66;
    private javax.swing.JLabel label67;
    private javax.swing.JLabel label68;
    private javax.swing.JLabel label69;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label70;
    private javax.swing.JLabel label71;
    private javax.swing.JLabel label72;
    private javax.swing.JLabel label73;
    private javax.swing.JLabel label74;
    private javax.swing.JLabel label75;
    private javax.swing.JLabel label76;
    private javax.swing.JLabel label77;
    private javax.swing.JLabel label78;
    private javax.swing.JLabel label79;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label80;
    private javax.swing.JLabel label81;
    private javax.swing.JLabel label82;
    private javax.swing.JLabel label83;
    private javax.swing.JLabel label84;
    private javax.swing.JLabel label85;
    private javax.swing.JLabel label86;
    private javax.swing.JLabel label87;
    private javax.swing.JLabel label88;
    private javax.swing.JLabel label89;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel label90;
    private javax.swing.JLabel label91;
    private javax.swing.JLabel label92;
    private javax.swing.JLabel label93;
    private javax.swing.JLabel label94;
    private javax.swing.JLabel label95;
    private javax.swing.JLabel label96;
    private javax.swing.JLabel label97;
    private javax.swing.JLabel label98;
    private javax.swing.JLabel label99;
    private javax.swing.JLabel label_VIP2;
    private javax.swing.JLabel label_premium;
    private javax.swing.JLabel label_premium1;
    private javax.swing.JLabel label_reguler;
    private javax.swing.JLabel label_suite;
    // End of variables declaration//GEN-END:variables
}
