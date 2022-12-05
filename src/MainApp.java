import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InEtudiantRepo etudRepo = new EtudiantRepository();
		InUniversiteRepo univRepo = new UniversiteRepository();

		EtudiantService serv=new EtudiantService(etudRepo, univRepo);
		try {
			serv.inscription(4, "Guendouziiiii", "wassila", "guenj@gmail.com","xxxx", 123);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
