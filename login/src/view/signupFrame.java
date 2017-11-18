package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import view.LoginFrame.Mypanel;

public class signupFrame extends JFrame  implements ActionListener{


	BufferedImage img =null;
	JTextField IDTextField;
	JTextField AgeTextField;
	JTextField NameTextField;
	JTextField HeightTextField;
	JTextField WeightTextField;
	JTextField GoalTextField;
	JPasswordField passwordField;
	JPasswordField passwordConfirmField;
	JRadioButton rdbt1,rdbt2;
	JButton Ybt;
	JButton Nbt;


	public signupFrame() {

		this.setTitle("Sign up");
		this.setSize(750,1334);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//레이아웃
		this.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane(); 
		layeredPane.setBounds(0,0,750,1334);
		layeredPane.setLayout(null);

		try {
			img = ImageIO.read(new File("image/gameOff.png")); //이미지 변경부분 
		}catch(IOException e) {
			System.out.println("Fail to load image");
			System.exit(0);
		}
		//패널
		Mypanel panel  = new Mypanel();
		panel.setBounds(0,0,750,1334);
		//아이디
		IDTextField = new JTextField("ID");
		IDTextField.setBounds(100,100,280,30); //로그인 텍스트 필드 위치 
		IDTextField.setOpaque(false); // 투명하게 하기 
		IDTextField.setForeground(Color.green);
		IDTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(IDTextField); // 패널에 놓기 

		//비밀번호
		passwordField = new JPasswordField("password"); 
		passwordField.setBounds(100,150,280,30); //패스워드 텍스트 필드 위치 
		passwordField.setOpaque(false);//투명하게하기 
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게하기 
		layeredPane.add(passwordField);
		//비밀번호확인
		passwordConfirmField = new JPasswordField("password confirm"); 
		passwordConfirmField.setBounds(100,200,280,30); //패스워드 텍스트 필드 위치 
		passwordConfirmField.setOpaque(false);//투명하게하기 
		passwordConfirmField.setForeground(Color.green);
		passwordConfirmField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게하기 
		layeredPane.add(passwordConfirmField);
		//이름
		NameTextField = new JTextField("Name");
		NameTextField.setBounds(100,250,280,30); //로그인 텍스트 필드 위치 
		NameTextField.setOpaque(false); // 투명하게 하기 
		NameTextField.setForeground(Color.green);
		NameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(NameTextField);
		//나이
		AgeTextField = new JTextField("Age");
		AgeTextField.setBounds(100,300,280,30); //로그인 텍스트 필드 위치 
		AgeTextField.setOpaque(false); // 투명하게 하기 
		AgeTextField.setForeground(Color.green);
		AgeTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(AgeTextField);
		//성
		rdbt1=new JRadioButton("F");
		rdbt2= new JRadioButton("M");
		ButtonGroup genderButton = new ButtonGroup();
		genderButton.add(rdbt1);
		genderButton.add(rdbt2);
		rdbt1.setBounds(100, 350, 31, 31);
		rdbt2.setBounds(133, 350, 35,31);
		//두개다 체크안되게하기 
		layeredPane.add(rdbt1);
		layeredPane.add(rdbt2);


		//키
		HeightTextField = new JTextField("Height");
		HeightTextField.setBounds(100,400,280,30); //로그인 텍스트 필드 위치 
		HeightTextField.setOpaque(false); // 투명하게 하기 
		HeightTextField.setForeground(Color.green);
		HeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(HeightTextField);
		//몸무게
		WeightTextField = new JTextField("Weight");
		WeightTextField.setBounds(100,450,280,30); //로그인 텍스트 필드 위치 
		WeightTextField.setOpaque(false); // 투명하게 하기 
		WeightTextField.setForeground(Color.green);
		WeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(WeightTextField);
		//목표
		GoalTextField = new JTextField("Goal");
		GoalTextField.setBounds(100,500,280,30); //로그인 텍스트 필드 위치 
		GoalTextField.setOpaque(false); // 투명하게 하기 
		GoalTextField.setForeground(Color.green);
		GoalTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(GoalTextField);

		//확인버튼
		Ybt = new JButton("확인");// 버튼에 이미지 추가
		Ybt.setBounds(100,600,60,23);
		Ybt.setBorderPainted(false);//투명하게하기
		Ybt.setFocusPainted(false);//투명하게하기
		Ybt.setContentAreaFilled(false);//투명하게하기
		layeredPane.add(Ybt);//패널에 넣기 

		//취소버튼
		Nbt = new JButton("취소");// 버튼에 이미지 추가 
		Nbt.setBounds(162,600,60,23);
		Nbt.setBorderPainted(false);//투명하게하기
		Nbt.setFocusPainted(false);//투명하게하기
		Nbt.setContentAreaFilled(false);//투명하게하기
		layeredPane.add(Nbt);//패널에 넣기 

		Nbt.addActionListener(this);
		Ybt.addActionListener(this);
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
		
		if(e.getSource()==Ybt) {
			JOptionPane.showMessageDialog(null, "sign up success!!");
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "sign up fail!!");
			dispose();
		}

	}

}
