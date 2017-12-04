package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import Client.Client;
import controller.loginService;
public class Login extends JFrame implements ActionListener{

	BufferedImage img =null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton lgbt;
	JButton sgbt;
	String idpw;
	String id,pw;
	public static int flag=-1;
	//main

	//占쏙옙占쏙옙占쏙옙
	public Login() {

		//占쏙옙占쏙옙占쏙옙 占십깍옙화 
		setTitle("Kill a Gram");// 占쏙옙占쏙옙창 占싱몌옙 
		setSize(1600,900);// 占쏙옙占쏙옙창 크占쏙옙 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 占쏙옙占쏙옙占싹곤옙 占쌘울옙 占쏙옙환


		//占쏙옙占싱아울옙 占쏙옙占쏙옙
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane(); 
		layeredPane.setBounds(0,0,1600,900);
		layeredPane.setLayout(null);


//		//占싱뱄옙占쏙옙 占쌨아울옙占쏙옙
//		try {
//			img = ImageIO.read(new File("image/login.png")); //占싱뱄옙占쏙옙 占쏙옙占쏙옙觀占� 
//		}catch(IOException e) {
//			System.out.println("Fail to load image");
//			System.exit(0);
//		}

		//占싻놂옙
		Mypanel panel  = new Mypanel();
		panel.setBounds(0,0,1600,900);

		//占싸깍옙占쏙옙
		loginTextField = new JTextField(15);
		loginTextField.setBounds(731,399,280,30); //占싸깍옙占쏙옙 占쌔쏙옙트 占십듸옙 占쏙옙치 
		loginTextField.setOpaque(false); // 占쏙옙占쏙옙占싹곤옙 占싹깍옙 
		loginTextField.setForeground(Color.green);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//占쏙옙占쏙옙占싹곤옙 占싹깍옙 
		layeredPane.add(loginTextField); // 占싻널울옙 占쏙옙占쏙옙 

		//占쏙옙橘占싫�
		passwordField = new JPasswordField(15); 
		passwordField.setBounds(731,529,280,30); //占싻쏙옙占쏙옙占쏙옙 占쌔쏙옙트 占십듸옙 占쏙옙치 
		passwordField.setOpaque(false);//占쏙옙占쏙옙占싹곤옙占싹깍옙 
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//占쏙옙占쏙옙占싹곤옙占싹깍옙 
		layeredPane.add(passwordField);//占싻널울옙 占쌍깍옙

		//占쏙옙튼占쌩곤옙
		lgbt = new JButton(new ImageIcon("image/btLogin_hud.png"));// 占쏙옙튼占쏙옙 占싱뱄옙占쏙옙 占쌩곤옙 
		lgbt.setBounds(755,589,104,48);
		lgbt.setBorderPainted(false);//占쏙옙占쏙옙占싹곤옙占싹깍옙
		lgbt.setFocusPainted(false);//占쏙옙占쏙옙占싹곤옙占싹깍옙
		lgbt.setContentAreaFilled(false);//占쏙옙占쏙옙占싹곤옙占싹깍옙
		layeredPane.add(lgbt);//占싻널울옙 占쌍깍옙 

		//회占쏙옙占쏙옙占쏙옙 占쏙옙튼 占쌩곤옙占쏙옙
		sgbt = new JButton(new ImageIcon("image/signup_icon.jpg"));
		sgbt.setBounds(735,689,184,35);
		sgbt.setBorderPainted(false);
		sgbt.setFocusPainted(false);
		sgbt.setContentAreaFilled(false);
		layeredPane.add(sgbt);

		//add
		lgbt.addActionListener(this);
		sgbt.addActionListener(this);
		layeredPane.add(panel);
		add(layeredPane);
		setVisible(true);
	}
	private void setID(String id){
		this.id =id;
	}
	
	private void setPW(String pw){
		this.pw= pw;
	}
	
	public String getID(){
		return this.id;
	}
	public String getPW(){
		return this.pw;
	}

	class Mypanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		id = loginTextField.getText();
		char[] pass = passwordField.getPassword();
		pw = new String(pass);
		//this.setID(id);
		//this.setPW(pw);
		//System.out.println("In login class use this.set"+id+" "+pw);
		
		Client.setID(id);
		Client.setPW(pw);
		System.out.println("In login class use Client "+id+" "+pw);
		
		System.out.println("안눌럿을때 flag "+flag);
		if(e.getSource()==lgbt) {
			flag=0;	
			System.out.println("버튼눌럿을때 flag "+ flag);
			if(id.equals("")|| pw.equals("")) {
				//send message
				JOptionPane.showMessageDialog(null, "text field space!!");
			}
			else {

							
			}
		}
		else {
			new Signup();
		}
	}
}
