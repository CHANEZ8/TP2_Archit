import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface InEtudiantRepo {
    void add(Etudiant E) throws SQLException;
    boolean Exists(String email) throws SQLException;
    boolean Exists(int mat) throws SQLException;
    public boolean VerificationMatEmail(Etudiant etud) throws SQLException;
}
