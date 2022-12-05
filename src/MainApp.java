import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IJournal journalClassDate = new MessageClassDate();
		IJournal journalEcran = new MessageEcran();
		IJournal journalFile = new MessageFile();
		
		List<IJournal> listJournal =new ArrayList<IJournal>();
		listJournal.add(journalClassDate);
		listJournal.add(journalEcran);
		listJournal.add(journalFile);
		IJournal affiche = new MessageComposite(listJournal);
		InEtudiantRepo etudRepo = new EtudiantRepository(affiche);
		InUniversiteRepo univRepo = new UniversiteRepository(affiche);

		EtudiantService serv = new EtudiantService(etudRepo, univRepo,affiche);
		try {
			serv.inscription(4, "Guendouz", "wassila", "guenj@gmail.com","xxxx", 123);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
