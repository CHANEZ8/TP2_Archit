import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
public class EtudiantService {
	private InEtudiantRepo etudRepo;
	private InUniversiteRepo univRepo;
	IJournal affiche;


	public EtudiantService(InEtudiantRepo etudRepo, InUniversiteRepo univRepo, IJournal affiche)
	{
		this.etudRepo = etudRepo;
		this.univRepo = univRepo;
		this.affiche = affiche;
	}

	
	boolean inscription (int matricule, String nom, String prenom, String email,String pwd, int id_universite) throws SQLException, IOException	
	{
	
	    Etudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
	    
	    
		affiche.outPut_Msg("Log: debut de l'operation d'ajout de l'etudiant avec matricule "+matricule);
	    
	    if (etudRepo.VerificationMatEmail(stud)){
			return false;
		}
		
		
		
		stud.setNbLivreMensuel_Autorise(univRepo.getNombreLivreAutoriser(stud.getId_universite()));                
		AjouterNombreLivreBonus(stud);
		etudRepo.add(stud);
		affiche.outPut_Msg("Log: Fin de l'operation d'ajout de l'etudiant avec matricule "+matricule);
		 
		 return true;
	    
		
	}
	
	public void AjouterNombreLivreBonus(Etudiant stud) throws SQLException, IOException {
		stud.AjouterBonus(univRepo.getNombreLivreBonus(stud.getId_universite()));
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
