import java.text.SimpleDateFormat;
import java.util.Date;
public class MessageClassDate extends IJournal{
	
	@Override
	public void outPut_Msg(String message) {
		String classNom = Thread.currentThread().getStackTrace()[3].getClassName();
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
	    System.out.println(format.format(date) + " - " + classNom + " - " + message);
    
}
}
