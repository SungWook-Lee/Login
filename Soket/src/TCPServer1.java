import java.io.*;
import java.net.*;

public class TCPServer1 {
	public static void main(String argv[]) throws Exception{
		
		String clientSentence;
		String capitalizedSentence;
		
		ServerSocket welcomeSocket = new ServerSocket(5770);
		System.out.println("Servser start..\n");
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			
			BufferedReader inFromClient = 
					new BufferedReader(new 
							InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = 
					new DataOutputStream(connectionSocket.getOutputStream());
			
			clientSentence = inFromClient.readLine();
			System.out.println("FROM CLIENT:"+clientSentence);
			capitalizedSentence=clientSentence.toUpperCase()+'\n';
			outToClient.writeBytes(capitalizedSentence);
		}
	}
}
