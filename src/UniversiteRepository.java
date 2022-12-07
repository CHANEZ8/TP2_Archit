
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;

public class UniversiteRepository implements InUniversiteRepo{
	private InDBConnection BD;
	IJournal affiche;
	UniversiteRepository(IJournal affiche){
		this.affiche = affiche;
	}

	@Override
	public Universite GetById(int universityId) throws SQLException {
		
		BD= DBConnection.getDBConnection();
		Connection connect=BD.getConn(); 
		Statement stmt = connect.createStatement();
		affiche.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e");
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
		
		affiche.outPut_Msg("LogBD : universit� r�cup�r�e");
		
		connect.close();
		return u;	
	
		
	}	
	@Override
	public int getNombreLivreAutoriser(int universityId) throws SQLException, IOException{
		Universite univ=this.GetById(universityId);
		if (univ.getPack() == TypePackage.Standard)
	     {
			Pack typeUniv = new Standard();
			return typeUniv.getNombreLivreAutoriser();
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
			Pack typeUniv = new Premium();
	    	return typeUniv.getNombreLivreAutoriser();
	    	 
	     }
		return 0;
	}
		
	@Override
	public int getNombreLivreBonus(int universityId) throws SQLException, IOException{
		Universite univ=this.GetById(universityId);
		if (univ.getPack() == TypePackage.Standard)
	     {
			

			Pack typepack = new Standard();
			

			return typepack.getNombreLivreBonus();


	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
			

	    	 Pack typepack = new Premium();
			
			 
	    	 return typepack.getNombreLivreBonus();


	     }

		 
		 return 0;
		}
}
