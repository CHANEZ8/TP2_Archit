import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	private InEtudiantRepo etudRepo;
	private InUniversiteRepo univRepo;

	public EtudiantService(InEtudiantRepo etudRepo, InUniversiteRepo univRepo)
	{
		this.etudRepo = etudRepo;
		this.univRepo = univRepo;
		
	}

	
	boolean inscription (int matricule, String nom, String prenom, String email,String pwd, int id_universite) throws SQLException	
	{
	
	    Etudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
	    Universite univ=univRepo.GetById(id_universite);
	    
	    System.out.println("Log: debut de l'operation d'ajout de l'etudiant avec matricule "+matricule);
	    
	    if(email == null || email.length() == 0)
	    {
	    	return false;
	    }
	    
	    if (etudRepo.Exists(matricule))
	    {
	        return false;
	    }
	    
		if (etudRepo.Exists(email))
	    {
	        return false;
	    }
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 etudRepo.add(stud);
		 System.out.println("Log: Fin de l'operation d'ajout de l'etudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	
	
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
