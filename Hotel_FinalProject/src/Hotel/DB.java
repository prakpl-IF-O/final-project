package Hotel;

import java.sql.SQLException;

public interface DB {
    public abstract void savingData() throws  SQLException;
    public abstract void retrieveData(int id) throws  SQLException;
}
