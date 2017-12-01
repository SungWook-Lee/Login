package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.Login;
import view.Main;

public class Client {

	BufferedReader in;
	PrintWriter out;	



	private boolean run(String id, String pw) throws IOException{

		InetAddress local = InetAddress.getLocalHost();
		String serverAddress = local.getHostAddress();
		Socket socket = new Socket(serverAddress, 1234);
		in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(),true);
		String idpw= new String();
		idpw = id+","+pw;

		while(true){
			String line= in.readLine();

			if(line.startsWith("LOGINACCESS"))
			{
				String temp = new String();
				temp= line.substring(12, 17);
				if(temp.equals("true"))
					return true;
			}
			else if(line.startsWith("MODIFY"))
			{

			}
			else if(line.startsWith("SIGNUP"))
			{

			}
			else if(line.startsWith("FOOD"))
			{

			}
			else if(line.startsWith("SPORT"))
			{

			}
			else if(line.startsWith("RANK"))
			{

			}
		}

	}


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Client client = new Client();
		client.run("tester","1234@");
	}

}
