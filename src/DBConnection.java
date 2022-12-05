import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements InDBConnection{
		private String BDD = "nomBD";
		private String url = "jdbc:mysql://localhost:3306/" + BDD;
		private String user = "root";
		private String passwd = "";
		private Connection conn;
		public static DBConnection dBConnection;		
	   
	

	   
	    private DBConnection() {
			
		}


		public static DBConnection getDBConnection() {
	    	if ( dBConnection == null ){
	    		dBConnection = new DBConnection();
	    	}
	    	return dBConnection;
	    }
	    @Override
	    public Connection getConn() throws SQLException {
			conn=DriverManager.getConnection(url, user,passwd);
			return conn;
		}


		

		
	
}
