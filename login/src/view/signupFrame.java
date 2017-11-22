package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.checkService;
import controller.signupService;


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
	JButton checkDuplicate;
	ButtonGroup genderButton = new ButtonGroup();


	public signupFrame() {

		this.setTitle("Sign up");
		this.setSize(750,1334);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���̾ƿ�
		this.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane(); 
		layeredPane.setBounds(0,0,750,1334);
		layeredPane.setLayout(null);

		try {
			img = ImageIO.read(new File("image/gameOff.png")); //�̹��� ����κ� 
		}catch(IOException e) {
			System.out.println("Fail to load image");
			System.exit(0);
		}
		//�г�
		Mypanel panel  = new Mypanel();
		panel.setBounds(0,0,750,1334);
		//���̵�
		IDTextField = new JTextField("Pig");
		IDTextField.setBounds(100,100,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		IDTextField.setOpaque(false); // �����ϰ� �ϱ� 
		IDTextField.setForeground(Color.BLACK);
		IDTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(IDTextField); // �гο� ���� 

		//��й�ȣ
		passwordField = new JPasswordField("0000"); 
		passwordField.setBounds(100,150,280,30); //�н����� �ؽ�Ʈ �ʵ� ��ġ 
		passwordField.setOpaque(false);//�����ϰ��ϱ� 
		passwordField.setForeground(Color.BLACK);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ��ϱ� 
		layeredPane.add(passwordField);
		//��й�ȣȮ��
		passwordConfirmField = new JPasswordField("0000"); 
		passwordConfirmField.setBounds(100,200,280,30); //�н����� �ؽ�Ʈ �ʵ� ��ġ 
		passwordConfirmField.setOpaque(false);//�����ϰ��ϱ� 
		passwordConfirmField.setForeground(Color.BLACK);
		passwordConfirmField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ��ϱ� 
		layeredPane.add(passwordConfirmField);
		//�̸�
		NameTextField = new JTextField("����");
		NameTextField.setBounds(100,250,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		NameTextField.setOpaque(false); // �����ϰ� �ϱ� 
		NameTextField.setForeground(Color.BLACK);
		NameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(NameTextField);
		//����
		AgeTextField = new JTextField("45");
		AgeTextField.setBounds(100,300,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		AgeTextField.setOpaque(false); // �����ϰ� �ϱ� 
		AgeTextField.setForeground(Color.BLACK);
		AgeTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(AgeTextField);
		//��
		rdbt1=new JRadioButton("F");
		rdbt2= new JRadioButton("M");
		//��ư �׷�ȭ 
		
		genderButton.add(rdbt1);
		genderButton.add(rdbt2);
		rdbt1.setBounds(100, 350, 31, 31);
		rdbt2.setBounds(133, 350, 35,31);
		layeredPane.add(rdbt1);
		layeredPane.add(rdbt2);


		//Ű
		HeightTextField = new JTextField("175.2");
		HeightTextField.setBounds(100,400,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		HeightTextField.setOpaque(false); // �����ϰ� �ϱ� 
		HeightTextField.setForeground(Color.BLACK);
		HeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(HeightTextField);
		//������
		WeightTextField = new JTextField("125.3");
		WeightTextField.setBounds(100,450,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		WeightTextField.setOpaque(false); // �����ϰ� �ϱ� 
		WeightTextField.setForeground(Color.BLACK);
		WeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(WeightTextField);
		//��ǥ
		GoalTextField = new JTextField("100.3");
		GoalTextField.setBounds(100,500,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		GoalTextField.setOpaque(false); // �����ϰ� �ϱ� 
		GoalTextField.setForeground(Color.BLACK);
		GoalTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(GoalTextField);

		//Ȯ�ι�ư
		Ybt = new JButton("Ȯ��");// ��ư�� �̹��� �߰�
		Ybt.setBounds(100,600,60,23);
		Ybt.setBorderPainted(false);//�����ϰ��ϱ�
		Ybt.setFocusPainted(false);//�����ϰ��ϱ�
		Ybt.setContentAreaFilled(false);//�����ϰ��ϱ�
		layeredPane.add(Ybt);//�гο� �ֱ� 

		//��ҹ�ư
		Nbt = new JButton("���");// ��ư�� �̹��� �߰� 
		Nbt.setBounds(162,600,60,23);
		Nbt.setBorderPainted(false);//�����ϰ��ϱ�
		Nbt.setFocusPainted(false);//�����ϰ��ϱ�
		Nbt.setContentAreaFilled(false);//�����ϰ��ϱ�
		layeredPane.add(Nbt);//�гο� �ֱ� 
		
		//�ߺ�Ȯ��
		checkDuplicate = new JButton("�ߺ�Ȯ��");
		checkDuplicate.setBounds(400,100,90,30);
		layeredPane.add(checkDuplicate);
		

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
		
		String id = IDTextField.getText();
		System.out.println(id);

		if(e.getSource()==Ybt) {
				
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
				boolean success=signupService.signUp(id,pw,name,age,gender,height,weight,goal);
				
				if(success==true){
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Some field EMPTY!!");
				}
			}

		}
		else if(e.getSource()==Nbt) {
			dispose();
		}
		
		else if(e.getSource()==checkDuplicate){
			
			boolean check = checkService.check(id);
		
			if(check==true){
				JOptionPane.showMessageDialog(null, "Already taken ID!!");
			}
			else{
				JOptionPane.showMessageDialog(null, "Available ID!!");
			}
		}

	}

}
