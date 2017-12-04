package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import controller.loadService;
import controller.loginService;
import view.Login;
import view.Main;

public class Server {

	private static final int PORT = 1234;
	private static HashSet<String> ID = new HashSet<String>();
	private static HashSet<String> PW = new HashSet<String>();
	private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		System.out.println("The chat server is running");
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Handler(listener.accept()).start();
			}
		} 
		finally {
			listener.close();
		}

	}
	private static class Handler extends Thread {
		private String IDPW;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;
		String p =",";
		private boolean flag=false;
		private String[] info = new String[2];

		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {

				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				while(true){
					out.println("START");
					String temp = in.readLine();
					if(temp.startsWith("SUCCESS"))
						break;
				}

				out.println("REQUEST");
				System.out.println("¸®Äù½ºÆ® º¸³¿");

				while(true){

					String next = in.readLine();
					System.out.println(next);
					ArrayList<String> tmp =new ArrayList<String>();
					StringTokenizer tokens = new StringTokenizer(next," ");

					while(tokens.hasMoreElements()){
						tmp.add(tokens.nextToken());
					}

					System.out.println(tmp.get(0));
					switch(tmp.get(0)){

					case "IDANDPW":

						System.out.println("¾ÆÀÌµð Àß¹ÞÀ½");
						String IDPW = next.substring(8);
						info = IDPW.split(p);
						System.out.println("ID : "+info[0]);
						System.out.println("PW : "+info[1]);
						if(info[0]!=null&&info[1]!=null){
							flag = loginService.loginTest(info[0], info[1]);
						}
						out.println("ACCESSED"+flag);
						System.out.println("È®ÀÎÇÏ°í °á°úº¸³¿");
						break;
					case "MODIFY":
						break;
					default :
						System.out.println("¹º°¡ Àß¸øµÊ ¤·¤µ¤·");
					}


				}


			} catch (IOException e) {
				System.out.println(e);
			} 
			finally 
			{
				try 
				{
					socket.close();
				} 
				catch (IOException e) {

				}
			}
		}
	}
}
