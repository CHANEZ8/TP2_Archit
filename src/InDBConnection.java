import java.sql.Connection;

import java.sql.SQLException;

public interface InDBConnection {
    public Connection getConn() throws SQLException;
}
