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
import controller.modifyService;
import controller.signupService;

public class Server {

	private static final int PORT = 1234;

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
					String[] n=next.split(" ");

					switch(n[0]){
					case "IDANDPW":
						flag=false;

						info = n[1].split(p);
						if(info[0]!=null&&info[1]!=null){
							flag = loginService.loginTest(info[0], info[1]);
						}
						out.println("ACCESSED"+flag);
						break;
					case "SIGNUP":
						flag=false;
						info=n[1].split(p);
						
						if(info[0]!=null&&info[1]!=null&&info[2]!=null&&info[3]!=null&&info[4]!=null&info[5]!=null
								&&info[6]!=null&info[7]!=null){
							int temp_age=Integer.parseInt(info[3]);
							float temp_height=Float.parseFloat(info[5]);
							float temp_weight=Float.parseFloat(info[6]);
							float temp_goal =Float.parseFloat(info[7]);
							
						flag=signupService.signUp(info[0], info[1], info[2], temp_age, info[4], temp_height, temp_weight,temp_goal);
						}
						out.println("COMPLETE"+flag);
						break;

					case "MODIFY":
						flag= false;
						info[1].split(p);
						
						if(info[0]!=null&&info[1]!=null&&info[2]!=null&&info[3]!=null&&info[4]!=null&info[5]!=null
								&&info[6]!=null&info[7]!=null){
							int temp_age=Integer.parseInt(info[3]);
							float temp_height=Float.parseFloat(info[5]);
							float temp_weight=Float.parseFloat(info[6]);
							float temp_goal =Float.parseFloat(info[7]);
							
						flag=modifyService.modify(info[0], info[1], info[2], temp_age, info[4], temp_height, temp_weight,temp_goal);
						}
						out.println("FINISH"+flag);
						
						break;
						
					case "FOOD":
						break;
					case "SPORT":
						break;
					case "RANK":
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
