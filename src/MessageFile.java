import java.io.*;


public class MessageFile extends IJournal{

	@Override
	public void outPut_Msg(String message) {
		File file = new File("message.txt");

	    try {
	        FileWriter Writer = new FileWriter(file, true);
	        Writer.write(message+"\n");
	        Writer.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
		      
		      
		
	}

}
    

