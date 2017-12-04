package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.Login;
import view.Main;

public class Client {

	BufferedReader in;
	PrintWriter out;   
	private static String ID="11";
	private static String PW="11";
	JFrame frame =new JFrame("IP Address");

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void setID(String id){
		ID = id;
	}

	public static void setPW(String pw){
		PW = pw;
	}

	private String getServerAddress() {

		return JOptionPane.showInputDialog(frame,"Enter IP Address of the Server:","Welcome to the Chatter",JOptionPane.QUESTION_MESSAGE);

	}

	public void run() throws IOException{

		String serverAddress = getServerAddress();
		Socket socket = new Socket(serverAddress, 1234);
		in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(),true);
		String idpw= new String();

		while(true){

			String line = in.readLine();
			Login login = null;

			if(line.startsWith("START")){

				out.println("SUCCESS");
				login=new Login();
				System.out.println("로그인화면열기 성공");
				System.out.println("화면 열었을때 flag"+Login.flag);

			}
			else if((line.startsWith("REQUEST"))&&(Login.flag==0)){
				System.out.println("리퀘스트받음");
				System.out.println("아이디 세팅");
				
				out.println("IDANDPW qeqeqe,qeqeq");
				System.out.println("아이디 보내기 완료");
			}

			else if(line.startsWith("ACCESSED")){
				System.out.println("결과도착");
				String temp = line.substring(8);
				System.out.println("결과는 "+temp);

				if(temp.equals("true")){
					JOptionPane.showMessageDialog(null, "됐다 ㅅㅂ");
					new Main(ID);
				}
				else
					System.out.println("ㅅㅂ");
			}
		}
	}

public static void main(String[] args) throws Exception	{

	Client client = new Client();
	client.	run();
}

}
