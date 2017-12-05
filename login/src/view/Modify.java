
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Client.Client;
import controller.checkService;
import controller.signupService;
import view.Signup.Mypanel;

public class Modify extends JFrame{

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
	JButton checkDuplicate;
	String s;
	ButtonGroup genderButton = new ButtonGroup();

	public Modify(String id,String name, String age, String gender,String height, String weight,String goal) {
		// TODO Auto-generated constructor stub

		this.setTitle("회원정보수정");
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
		IDTextField = new JTextField(id);
		IDTextField.setBounds(100,100,280,30); //로그인 텍스트 필드 위치 
		IDTextField.setOpaque(false); // 투명하게 하기 
		IDTextField.setForeground(Color.BLACK);
		IDTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(IDTextField); // 패널에 놓기 

		//비밀번호
		passwordField = new JPasswordField(); 
		passwordField.setBounds(100,150,280,30); //패스워드 텍스트 필드 위치 
		passwordField.setOpaque(false);//투명하게하기 
		passwordField.setForeground(Color.BLACK);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게하기 
		layeredPane.add(passwordField);
		//비밀번호확인
		passwordConfirmField = new JPasswordField(); 
		passwordConfirmField.setBounds(100,200,280,30); //패스워드 텍스트 필드 위치 
		passwordConfirmField.setOpaque(false);//투명하게하기 
		passwordConfirmField.setForeground(Color.BLACK);
		passwordConfirmField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게하기 
		layeredPane.add(passwordConfirmField);
		//이름
		NameTextField = new JTextField(name);
		NameTextField.setBounds(100,250,280,30); //로그인 텍스트 필드 위치 
		NameTextField.setOpaque(false); // 투명하게 하기 
		NameTextField.setForeground(Color.BLACK);
		NameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(NameTextField);
		//나이
		AgeTextField = new JTextField(age);
		AgeTextField.setBounds(100,300,280,30); //로그인 텍스트 필드 위치 
		AgeTextField.setOpaque(false); // 투명하게 하기 
		AgeTextField.setForeground(Color.BLACK);
		AgeTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(AgeTextField);

		//성	
		rdbt1=new JRadioButton("F");
		rdbt2= new JRadioButton("M");
		//버튼 그룹화 
		genderButton.add(rdbt1);
		genderButton.add(rdbt2);
		rdbt1.setBounds(100, 350, 31, 31);
		rdbt2.setBounds(133, 350, 35,31);
		layeredPane.add(rdbt1);
		layeredPane.add(rdbt2);

		if(gender=="F")
			rdbt1.setSelected(true);
		else
			rdbt2.setSelected(true);

		//키
		HeightTextField = new JTextField(height);
		HeightTextField.setBounds(100,400,280,30); //로그인 텍스트 필드 위치 
		HeightTextField.setOpaque(false); // 투명하게 하기 
		HeightTextField.setForeground(Color.BLACK);
		HeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(HeightTextField);
		//몸무게
		WeightTextField = new JTextField(weight);
		WeightTextField.setBounds(100,450,280,30); //로그인 텍스트 필드 위치 
		WeightTextField.setOpaque(false); // 투명하게 하기 
		WeightTextField.setForeground(Color.BLACK);
		WeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(WeightTextField);
		//목표
		GoalTextField = new JTextField(goal);
		GoalTextField.setBounds(100,500,280,30); //로그인 텍스트 필드 위치 
		GoalTextField.setOpaque(false); // 투명하게 하기 
		GoalTextField.setForeground(Color.BLACK);
		GoalTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(GoalTextField);

		//확인버튼
		Ybt = new JButton("수정완료");// 버튼에 이미지 추가
		Ybt.setBounds(100,600,86,23);
		Ybt.setBorderPainted(false);//투명하게하기
		Ybt.setFocusPainted(false);//투명하게하기
		Ybt.setContentAreaFilled(false);//투명하게하기
		layeredPane.add(Ybt);//패널에 넣기 

		//취소버튼
		Nbt = new JButton("수정취소");// 버튼에 이미지 추가 
		Nbt.setBounds(188,600,86,23);
		Nbt.setBorderPainted(false);//투명하게하기
		Nbt.setFocusPainted(false);//투명하게하기
		Nbt.setContentAreaFilled(false);//투명하게하기
		layeredPane.add(Nbt);//패널에 넣기 

		//중복확인
		checkDuplicate = new JButton("중복확인");
		checkDuplicate.setBounds(400,100,90,30);
		layeredPane.add(checkDuplicate);

		Nbt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

		});
		
		Ybt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = IDTextField.getText();
				String temp_age = AgeTextField.getText();
				int age = Integer.parseInt(temp_age);

				String name = NameTextField.getText();

				String temp_height= HeightTextField.getText();
				float height=Float.parseFloat(temp_height);

				String temp_weight= WeightTextField.getText();
				float weight = Float.parseFloat(temp_weight);

				String temp_goal = GoalTextField.getText();
				float goal = Float.parseFloat(temp_goal);

				char[] pass = passwordField.getPassword();
				String pw = new String(pass);

				char[] passconfirm = passwordConfirmField.getPassword();
				String pwconf=new String(passconfirm);

				Enumeration<AbstractButton> enums= genderButton.getElements();
				String gender=null;

				while(enums.hasMoreElements()){
					AbstractButton ab = enums.nextElement();
					JRadioButton jb =(JRadioButton)ab;

					if(jb.isSelected())
						gender=jb.getText().trim();
				}

				if(id.equals("")){
					JOptionPane.showMessageDialog(null, "ID field EMPTY!!");
				}
				else if(temp_age.equals("")){
					JOptionPane.showMessageDialog(null, "AGE field EMPTY!!");
				}
				else if(name.equals("")){
					JOptionPane.showMessageDialog(null, "NAME field EMPTY!!");
				}
				else if(temp_height.equals("")){
					JOptionPane.showMessageDialog(null, "HEIGHT field EMPTY!!");
				}
				else if(temp_weight.equals("")){
					JOptionPane.showMessageDialog(null, "WEIGHT field EMPTY!!");
				}
				else if(temp_goal.equals("")){
					JOptionPane.showMessageDialog(null, "Goal field EMPTY!!");
				}
				else if(pw.equals("")){
					JOptionPane.showMessageDialog(null, "PASSWORD field EMPTY!!");
				}
				else if(pwconf.equals("")){
					JOptionPane.showMessageDialog(null, "PASSWORDCONFIRM field EMPTY!!");
				}
				else if (pw.equals(pwconf)==false){
					JOptionPane.showMessageDialog(null, "PASSWORDCONFIRM field and PASSWORD field differ!!");
				}
				else{
					try {
						s="MODIFY "+id+","+pw+","+name+","+temp_age+","+gender+","+temp_height+","+temp_weight+","+temp_goal;
						s=Client.data(s);

						String temp = s.substring(6);
						if(temp.equals("true")){
							JOptionPane.showMessageDialog(null, "정보수정완료ㅋ");
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null, "정보수정실패 ㅋ");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		checkDuplicate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = IDTextField.getText();
				boolean check = checkService.check(id);

				if(check){
					JOptionPane.showMessageDialog(null, "중복됨 딴거 쓰셈 ㅋ");
				}
				else{
					JOptionPane.showMessageDialog(null, "쓰셈ㅋ");
				}
			}
		});
		
		


		layeredPane.add(panel);
		add(layeredPane);
		setVisible(true);

	}
	class Mypanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}

}
