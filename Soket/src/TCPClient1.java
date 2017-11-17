import java.io.*;
import java.net.*;

public class TCPClient1 {
	public static void main(String argv[])throws Exception{

		String sentence;
		String modifiedSentence;
		int a=1;
		int b=1;
		int c=3;
		String dadas;

		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket("127.0.0.1",5770);

		DataOutputStream outToServer =
				new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader inFromServer = 
				new BufferedReader(new 
						InputStreamReader(clientSocket.getInputStream()));

		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence+'\n');
		modifiedSentence = inFromServer.readLine();

		System.out.println("FROM SERVER: "+modifiedSentence);

		clientSocket.close();	
	}
}
