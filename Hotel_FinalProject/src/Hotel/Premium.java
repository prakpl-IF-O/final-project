//Package Hotel adalah package dari class Premium
package Hotel;

/*Deklarasi class Premium yang merupakan inheritance dari class Kamar
  Class ini memiliki fungsi sebagai kelas dari kamar yang menentukan nomor kamar harga output kamar dengan kelas Premium */
public class Premium extends Kamar {

    /*Deklarasi constructor dengan melewatkan 1 parameter int noKamar 
      Pada badan constructor terdapat 3 parameter yang merupakan inheritance dari constructor class Kamar */
    public Premium(int noKamar) {
        super(noKamar, 200000, "Premium");
    }

}
