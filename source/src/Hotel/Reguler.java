//Package Hotel adalah package dari class Reguler
package Hotel;

/*Deklarasi class Reguler yang merupakan inheritance dari class Kamar
  Class ini memiliki fungsi sebagai kelas dari kamar yang menentukan nomor kamar harga output kamar dengan kelas Reguler */
public class Reguler extends Kamar {

    /*Deklarasi constructor dengan melewatkan 1 parameter int noKamar 
      Pada badan constructor terdapat 3 parameter yang merupakan inheritance dari constructor class Kamar */
    public Reguler(int noKamar) {
        super(noKamar, 100000, "Reguler");
    }

}
