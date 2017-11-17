package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.loginSerivce;

public class LoginFrame extends JFrame implements ActionListener{

	BufferedImage img =null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt;

	//main
	public static void main(String[] args ) {
		new LoginFrame();
	}
	
	//������
	public LoginFrame() {
		
		setTitle("Kill a Gram");// ����â �̸� 
		setSize(1600,900);// ����â ũ�� 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �����ϰ� �ڿ� ��ȯ
		
		
		//���̾ƿ� ����
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane(); 
		layeredPane.setBounds(0,0,1600,900);
		layeredPane.setLayout(null);
		
		
		//�̹��� �޾ƿ���
		try {
			img = ImageIO.read(new File("image/login.png")); //�̹��� ����κ� 
		}catch(IOException e) {
			System.out.println("Fail to load image");
			System.exit(0);
		}
		
		//�г�
		Mypanel panel  = new Mypanel();
		panel.setBounds(0,0,1600,900);
		
		//�α���
		loginTextField = new JTextField(15);
		loginTextField.setBounds(731,399,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		loginTextField.setOpaque(false); // �����ϰ� �ϱ� 
		loginTextField.setForeground(Color.green);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(loginTextField); // �гο� ���� 
		
		//��й�ȣ
		passwordField = new JPasswordField(15); 
		passwordField.setBounds(731,529,280,30); //�н����� �ؽ�Ʈ �ʵ� ��ġ 
		passwordField.setOpaque(false);//�����ϰ��ϱ� 
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ��ϱ� 
		layeredPane.add(passwordField);//�гο� �ֱ�
		
		//��ư�߰�
		bt = new JButton(new ImageIcon("image/btLogin_hud.png"));// ��ư�� �̹��� �߰� 
		bt.setBounds(755,689,104,48);
		bt.setBorderPainted(false);//�����ϰ��ϱ�
		bt.setFocusPainted(false);//�����ϰ��ϱ�
		bt.setContentAreaFilled(false);//�����ϰ��ϱ�
		layeredPane.add(bt);//�гο� �ֱ� 
		
		//add
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String id = loginTextField.getText();
		char[] pass = passwordField.getPassword();
		String pw = new String(pass);
		
		if(id.equals("")|| pw.equals("")) {
			//send message
			JOptionPane.showMessageDialog(null, "text field space!!");
		}
		else {
			boolean islogin= loginSerivce.loginTest(id,pw);
			if(islogin) {
				JOptionPane.showMessageDialog(null, "login success!!");
			}
			else {
				JOptionPane.showMessageDialog(null, "login fail!!");
			}
		}
	}
}
