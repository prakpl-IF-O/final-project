import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SewaHotel extends JFrame implements ActionListener {
 Container konten = getContentPane();

 private final JLabel lblIDPelanggan = new JLabel("ID Pelanggan :");
 private final JLabel lblNama = new JLabel("Nama :");
 private final JLabel lblTgl = new JLabel("Tanggal Cek In :");
 private final JLabel lblAlamat = new JLabel("Alamat :");
 private final JLabel lblJenisKamar = new JLabel("JenisKamar:");
        private JLabel lbllama = new JLabel("Lama Menginap :");
 private JLabel lblTelp = new JLabel("Telp :");
 private JTextField txtIDPelanggan = new JTextField();
 private JTextField txtNama = new JTextField();
        private JTextField txtTgl = new JTextField();
        private JTextField txtAlamat = new JTextField();
 private final JRadioButton Reguler = new JRadioButton("1. Reguler ");
 private final JRadioButton Premium = new JRadioButton("2. Premium ");
 private final JRadioButton Suite = new JRadioButton("3. Suite ");
 private final JRadioButton VIP = new JRadioButton("4. VIP ");
        private final ButtonGroup btnGrup;
 private final ButtonGroup btGrup = new ButtonGroup();
 private JTextField txtlama = new JTextField();
 private JTextField txtTelp = new JTextField();
 private JButton btnTampil = new JButton("Tampil");
 private JButton btnKeluar = new JButton("Keluar");

 public SewaHotel(){
  super("HOTEL CUY");
        this.btnGrup = new ButtonGroup();
  setVisible(true);
  setSize(550,500);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  konten.setLayout(null);

  btnGrup.add(Reguler);
  btnGrup.add(Premium);
  btnGrup.add(Suite);
  btnGrup.add(VIP);

  Reguler.setSelected(true);

  lblIDPelanggan.setBounds(20,20,100,25);
  lblNama.setBounds(20,55,100,25);
  lbllama.setBounds(20,90,120,25);
  lblJenisKamar.setBounds(20,125,100,25);
  
  lblTgl.setBounds(20,195,100,25);
  lblAlamat.setBounds(20,230,100,25);
  lblTelp.setBounds(20,265,100,25);
  txtIDPelanggan.setBounds(150,20,100,25);
  txtNama.setBounds(150,55,100,25);
  txtlama.setBounds(150,90,100,25);
  Reguler.setBounds(150,125,90,25);
  Premium.setBounds(250,125,90,25);
  Suite.setBounds(350,125,90,25);
  VIP.setBounds(450,125,90,25);
  txtTgl.setBounds(150,195,100,25);
  txtAlamat.setBounds(150,230,200,25);
  txtTelp.setBounds(150,265,100,25);
  btnTampil.setBounds(30,300,90,25);
  btnKeluar.setBounds(250,300,90,25);

  konten.add(lblIDPelanggan);
  konten.add(lblNama);
  konten.add(lbllama);
  konten.add(lblJenisKamar);
  konten.add(lblTgl);
  konten.add(lblAlamat);
  konten.add(lblTelp);
  konten.add(txtIDPelanggan);
  konten.add(txtNama);
  konten.add(txtlama);       

  konten.add(Reguler);
  konten.add(Premium);
  konten.add(Suite);
  konten.add(VIP);
 
              
  konten.add(txtTgl);
  konten.add(txtAlamat);
  konten.add(txtTelp);
  konten.add(btnTampil);
  konten.add(btnKeluar);
  btnTampil.addActionListener(this);
  btnKeluar.addActionListener(this);
 }

        @Override
 public void actionPerformed(ActionEvent act) {
 int lama=Integer.parseInt(txtlama.getText());
 int  tarif=0,diskon=0,bayar=0;
  Object obj = act.getSource();
  if (obj==btnTampil) {

   String JenisKamar="";
   
  
   {

   if (Reguler.isSelected()){
   tarif = lama*100000;
   JenisKamar="Reguler";
   }else if (Premium.isSelected()){
   tarif = lama*200000;
   JenisKamar="Premium";
  }else if (Suite.isSelected()){
   tarif = lama*350000;
   JenisKamar="Suite";
   }else if(VIP.isSelected()){
    tarif = lama*750000;
    JenisKamar="VIP";
           }


   if(lama>=0 && lama==9){
    diskon = tarif;
   }else if (lama>=10 && lama==30) {
    diskon = (int) (0.10 * tarif);
   }else if (lama>=31 && lama==60) {
    diskon = (int) (0.15 * tarif);
   }else {
    diskon =(int) (0.25 * tarif);
   }
  

  bayar = tarif-diskon;
}
   JOptionPane.showMessageDialog(null,"ID Pelanggan \t\t: " + txtIDPelanggan.getText() +
            "\nNama \t\t: " + txtNama.getText() +
   "\nJenis Kamar \t\t :"+ JenisKamar +
            "\nTanggal CekIn \t: " + txtTgl.getText() +
            "\n Tarif \t\t: " + tarif +
            " \n diskon \t\t :" + diskon +
            "\n bayar \t\t: " +bayar +
            "\nAlamat \t\t: " + txtAlamat.getText() +
            "\nTelp \t\t: " + txtTelp.getText());
  } else if (obj == btnKeluar) {
   System.exit(0);
  }
 }
public static void main (String [] form) {
            SewaHotel sewaHotel = new SewaHotel();
 
 }
}