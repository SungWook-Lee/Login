package Server;



import java.io.BufferedReader;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.net.*;

import java.util.HashSet;



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

		boolean flag = false;

		private String[] info = new String[2];



		public Handler(Socket socket) {

			this.socket = socket;

		}



		public void run() {

			try {



				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				out = new PrintWriter(socket.getOutputStream(), true);
				
				while(true){

					String next = in.readLine();

					System.out.println(next);

					String[] n=next.split(" ");
					System.out.println(n[0]);
					System.out.println(n[1]);
					switch(n[0]){

					

					case "IDANDPW":

						System.out.println("아이디 잘받음");


						info = n[1].split(p);

						if(info[0]!=null&&info[1]!=null){

							flag = loginService.loginTest(info[0], info[1]);

						}

						out.println("ACCESSED"+flag);

						System.out.println("확인하고 결과보냄");



					case "MODIFY":

						break;

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
