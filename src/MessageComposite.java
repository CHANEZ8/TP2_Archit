import java.util.ArrayList;
import java.util.List;

public class MessageComposite extends IJournal{

    List<IJournal> listJournal=new ArrayList<IJournal>();  
	
    public MessageComposite(List<IJournal> listJournal) {
		this.listJournal = listJournal;
	}

	@Override
	public void outPut_Msg(String message) {
		for (IJournal iJournal : listJournal) {
			iJournal.outPut_Msg(message);
		}
		
	}
    
}
