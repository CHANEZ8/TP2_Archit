import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
public interface InUniversiteRepo {
    Universite GetById(int universityId) throws SQLException;
    public int getNombreLivreAutoriser(int universityId) throws SQLException, IOException;
}
