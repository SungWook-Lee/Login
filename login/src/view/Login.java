package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.loginService;

public class Login extends JFrame implements ActionListener{

	BufferedImage img =null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton lgbt;
	JButton sgbt;

	//main
	public static void main(String[] args ) {
		new Login();
	}

	//생성자
	public Login() {

		//프레임 초기화 
		setTitle("Kill a Gram");// 실행창 이름 
		setSize(1600,900);// 실행창 크기 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료하고 자원 반환


		//레이아웃 설정
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane(); 
		layeredPane.setBounds(0,0,1600,900);
		layeredPane.setLayout(null);


		//이미지 받아오기
		try {
			img = ImageIO.read(new File("image/login.png")); //이미지 변경부분 
		}catch(IOException e) {
			System.out.println("Fail to load image");
			System.exit(0);
		}

		//패널
		Mypanel panel  = new Mypanel();
		panel.setBounds(0,0,1600,900);

		//로그인
		loginTextField = new JTextField(15);
		loginTextField.setBounds(731,399,280,30); //로그인 텍스트 필드 위치 
		loginTextField.setOpaque(false); // 투명하게 하기 
		loginTextField.setForeground(Color.green);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(loginTextField); // 패널에 놓기 

		//비밀번호
		passwordField = new JPasswordField(15); 
		passwordField.setBounds(731,529,280,30); //패스워드 텍스트 필드 위치 
		passwordField.setOpaque(false);//투명하게하기 
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게하기 
		layeredPane.add(passwordField);//패널에 넣기

		//버튼추가
		lgbt = new JButton(new ImageIcon("image/btLogin_hud.png"));// 버튼에 이미지 추가 
		lgbt.setBounds(755,589,104,48);
		lgbt.setBorderPainted(false);//투명하게하기
		lgbt.setFocusPainted(false);//투명하게하기
		lgbt.setContentAreaFilled(false);//투명하게하기
		layeredPane.add(lgbt);//패널에 넣기 

		//회원가입 버튼 추가ㅣ
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
	
	class Mypanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = loginTextField.getText();
		if(e.getSource()==lgbt) {

			char[] pass = passwordField.getPassword();
			String pw = new String(pass);

			if(id.equals("")|| pw.equals("")) {
				//send message
				JOptionPane.showMessageDialog(null, "text field space!!");
			}
			else {
				boolean islogin= loginService.loginTest(id,pw);
				if(islogin) {
					JOptionPane.showMessageDialog(null, "login success!!");
					new Main(id);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "login fail!!");
				}
			}
		}
		else {
			new Signup();
		}
	}
}
