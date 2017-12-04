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
   private static String ID="11";
   private static String PW="11";
   private boolean flag = true;
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
   
   private String getID(){
      return this.ID;
   }
   private String getPW(){
      return this.PW;
   }
   
   private void getIslogin(boolean flag ){
      this.flag= flag;

   }
   public boolean setIslogin(){
      return this.flag;
   }
   private String getServerAddress() {
		return JOptionPane.showInputDialog(frame,"Enter IP Address of the Server:","Welcome to the Chatter",JOptionPane.QUESTION_MESSAGE);
	}

   public void run() throws IOException{

    //  InetAddress local = InetAddress.getLocalHost();
      String serverAddress = getServerAddress();
      Socket socket = new Socket(serverAddress, 1234);
      in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(),true);
      String idpw= new String();
      
      
//      while(idpw.equals("null,null")){
//         
//      }

      while(true){
         String line = in.readLine();
         Login login = null;
         
         if(line.startsWith("START")){
            out.println("SUCCESS");
            login=new Login();
            System.out.println("로그인화면 보여주기 완료");
            
         }
         
         else if(line.startsWith("REQUEST")){
//          while(Login.flag){
//        	  System.out.println("????");
//          }
            System.out.println("리퀘스트 받음");
            idpw=login.set();
            System.out.println("아이디 비밀번호 설정");
            out.println("IDADNPW"+idpw);
            System.out.println("아이디 잘보냄");
         }
         else if(line.startsWith("ACCESSED")){
        	 System.out.println("결과 잘받음");
            String temp = line.substring(8);
            if(temp.equals("true")){
               flag=true;
               if(flag) {
            	   System.out.println("제발좀 되라");
                  new Main(ID);
               }
               else {
                  System.out.println("안됨ㅋ");
               }
            }
         }
         

      }

   }
   public static void main(String[] args) throws Exception{
      
      Client client = new Client();
      client.run();
   }
}
