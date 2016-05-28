//Package Hotel adalah package dari class Kamar
package Hotel;

//Mengimport atau memasukkan fungsi database pada java
import java.sql.SQLException;

//Deklarasi Interface DB
public interface DB {
// Deklarasi abstract class savingData dan retrieveData yang akan di Implementasikan pada class Transaksi

    public abstract void savingData() throws SQLException;

    public abstract void retrieveData(int id) throws SQLException;
}
