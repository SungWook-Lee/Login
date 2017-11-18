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
		IDTextField = new JTextField("ID");
		IDTextField.setBounds(100,100,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		IDTextField.setOpaque(false); // �����ϰ� �ϱ� 
		IDTextField.setForeground(Color.green);
		IDTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(IDTextField); // �гο� ���� 

		//��й�ȣ
		passwordField = new JPasswordField("password"); 
		passwordField.setBounds(100,150,280,30); //�н����� �ؽ�Ʈ �ʵ� ��ġ 
		passwordField.setOpaque(false);//�����ϰ��ϱ� 
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ��ϱ� 
		layeredPane.add(passwordField);
		//��й�ȣȮ��
		passwordConfirmField = new JPasswordField("password confirm"); 
		passwordConfirmField.setBounds(100,200,280,30); //�н����� �ؽ�Ʈ �ʵ� ��ġ 
		passwordConfirmField.setOpaque(false);//�����ϰ��ϱ� 
		passwordConfirmField.setForeground(Color.green);
		passwordConfirmField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ��ϱ� 
		layeredPane.add(passwordConfirmField);
		//�̸�
		NameTextField = new JTextField("Name");
		NameTextField.setBounds(100,250,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		NameTextField.setOpaque(false); // �����ϰ� �ϱ� 
		NameTextField.setForeground(Color.green);
		NameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(NameTextField);
		//����
		AgeTextField = new JTextField("Age");
		AgeTextField.setBounds(100,300,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		AgeTextField.setOpaque(false); // �����ϰ� �ϱ� 
		AgeTextField.setForeground(Color.green);
		AgeTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(AgeTextField);
		//��
		rdbt1=new JRadioButton("F");
		rdbt2= new JRadioButton("M");
		ButtonGroup genderButton = new ButtonGroup();
		genderButton.add(rdbt1);
		genderButton.add(rdbt2);
		rdbt1.setBounds(100, 350, 31, 31);
		rdbt2.setBounds(133, 350, 35,31);
		//�ΰ��� üũ�ȵǰ��ϱ� 
		layeredPane.add(rdbt1);
		layeredPane.add(rdbt2);


		//Ű
		HeightTextField = new JTextField("Height");
		HeightTextField.setBounds(100,400,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		HeightTextField.setOpaque(false); // �����ϰ� �ϱ� 
		HeightTextField.setForeground(Color.green);
		HeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(HeightTextField);
		//������
		WeightTextField = new JTextField("Weight");
		WeightTextField.setBounds(100,450,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		WeightTextField.setOpaque(false); // �����ϰ� �ϱ� 
		WeightTextField.setForeground(Color.green);
		WeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(WeightTextField);
		//��ǥ
		GoalTextField = new JTextField("Goal");
		GoalTextField.setBounds(100,500,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		GoalTextField.setOpaque(false); // �����ϰ� �ϱ� 
		GoalTextField.setForeground(Color.green);
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
