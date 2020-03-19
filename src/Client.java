import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class Client {
	
	private final static String SERVERNAME = "";
	private final static int PORTNUMBER = 2020;
	
	private final String UserID;
	private String Username;
	private int status;
	LinkedList<Conversation> Conversations = new LinkedList<>();
	
	public Client(String ID, String Username) {
        this.UserID = ID;
        this.Username = Username;
    }
	
	 public void loadData() {

	        try {
	            Scanner sc = new Scanner(new File("UsersData\\" + Username + "\\Conversations.txt"));

	            while(sc.hasNext()) {
	                String ConversationID = sc.nextLine();
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	   }


	

		public static void main(String[] args) {
			
			
			while(true) {
				try {
			        // System.out.println("Connecting to " + serverName + " on port " + portNumber);
			         Socket client = new Socket(SERVERNAME, PORTNUMBER);
			         
			         //tell client where they connected to
			         System.out.println("Just connected to " + client.getRemoteSocketAddress());
			         OutputStream outToServer = client.getOutputStream();
			         DataOutputStream out = new DataOutputStream(outToServer);
			         
			         //capture input for server
			         String msg = "";
			         Scanner input = new Scanner(System.in);
			         System.out.println("\nType a message to send to the server:");
			         msg = input.nextLine();
			         
			         sendMessage(msg, out);
			         
			         InputStream inFromServer = client.getInputStream();
			         DataInputStream in = new DataInputStream(inFromServer);
			         
			         System.out.println("Server says " + in.readUTF());
			         client.close();
			      } catch (IOException e) {
			         e.printStackTrace();
			      }
			  }	
			}
		
		public static void sendMessage(String msg, DataOutputStream out) throws IOException {
			out.writeUTF(msg);
		}
		
		public static void updateMessage() {
			
		}
		
		public static void deleteMessage() {
			
		}
		
		public static void setStatus() {
			
		}
			
		
}
