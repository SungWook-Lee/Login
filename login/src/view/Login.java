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
public class Login extends JFrame{

	BufferedImage img =null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton lgbt;
	JButton sgbt;
	String idpw;
	String id,pw;
	public boolean flag=true;
	//main
	String S;

	public Login() {

		setTitle("Kill a Gram"); 
		setSize(1600,900); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane(); 
		layeredPane.setBounds(0,0,1600,900);
		layeredPane.setLayout(null);


		try {
			img = ImageIO.read(new File("image/login.png"));  
		}catch(IOException e) {
			System.out.println("Fail to load image");
			System.exit(0);
		}

		Mypanel panel  = new Mypanel();
		panel.setBounds(0,0,1600,900);

		loginTextField = new JTextField(15);
		loginTextField.setBounds(731,399,280,30);  
		loginTextField.setOpaque(false);  
		loginTextField.setForeground(Color.RED);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); 
		layeredPane.add(loginTextField); 

		passwordField = new JPasswordField(15); 
		passwordField.setBounds(731,529,280,30); 
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); 
		layeredPane.add(passwordField);

		lgbt = new JButton(new ImageIcon("image/btLogin_hud.png"));
		lgbt.setBounds(755,589,104,48);
		lgbt.setBorderPainted(false);
		lgbt.setFocusPainted(false);
		lgbt.setContentAreaFilled(false);
		layeredPane.add(lgbt);


		sgbt = new JButton(new ImageIcon("image/signup_icon.jpg"));
		sgbt.setBounds(735,689,184,35);
		sgbt.setBorderPainted(false);
		sgbt.setFocusPainted(false);
		sgbt.setContentAreaFilled(false);
		layeredPane.add(sgbt);


		//action login
		lgbt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String id = loginTextField.getText();
				char[] pass = passwordField.getPassword();
				pw = new String(pass);

				if (id.equals("") || pw.equals("")) {
					// send message
					JOptionPane.showMessageDialog(null, "text field space!!");
				} else
					try {
						S = "IDANDPW " + id + "," + pw;
						Client.id=id;
						Client.pw=pw;
						S = Client.data(S);
						String temp = S.substring(8);
						if(temp.equals("true")){
							JOptionPane.showMessageDialog(null, "로그인 성공");
							dispose();
							new Main(id);
						}
						else{
							JOptionPane.showMessageDialog(null, "로그인 실패");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}

		});

		//action sign up
		sgbt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Signup();
			}


		});
		//add
		layeredPane.add(panel);
		add(layeredPane);
		setVisible(true);
	}

	class Mypanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
}
