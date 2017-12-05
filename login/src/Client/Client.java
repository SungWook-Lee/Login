package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.Login;

public class Client {
	static BufferedReader in = null;// 서버에서 보내주기
	static PrintWriter out = null; // 서버로 데이타 보내주는
	// 소켓을 두개 만들꺼예요
	public static Socket Socket = null; // 데이타 보내고 받을때 소켓

	static int port=1234;
	public static String id;
	public static String pw;
	JFrame frame = new JFrame("IP Address");

	public Client() {
		try {
			Socket=new Socket("127.0.0.1", port);
	         out = new PrintWriter(Socket.getOutputStream(), true);
	         in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));   
	      } catch (UnknownHostException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } //data 보내고 받을 소켓을 만듬
	}

	private String getServerAddress() {

		return JOptionPane.showInputDialog(frame, "Enter IP Address of the Server:", "Welcome to the Chatter",
				JOptionPane.QUESTION_MESSAGE);

	}
	
	public static String data(String S) throws IOException {
		out = new PrintWriter(Socket.getOutputStream(), true);
		out.println(S);
		in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		S = in.readLine();
		return S;
	}
	
	public static void main(String[] args) throws Exception {

		Client client = new Client();
		
		Login login= new Login();
		login.setVisible(true);
	}

}
