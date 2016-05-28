//Package Hotel adalah package dari class Suite
package Hotel;

/*Deklarasi class Suite yang merupakan inheritance dari class Kamar
  Class ini memiliki fungsi sebagai kelas dari kamar yang menentukan nomor kamar harga output kamar dengan kelas Suite */
public class VIP extends Kamar{

    /*Deklarasi constructor dengan melewatkan 1 parameter int noKamar 
      Pada badan constructor terdapat 3 parameter yang merupakan inheritance dari constructor class Kamar */
    public VIP(int noKamar) {
        super(noKamar, 750000, "VIP");
    }
    
}
