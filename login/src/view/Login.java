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

	//������
	public Login() {

		//������ �ʱ�ȭ 
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
		lgbt = new JButton(new ImageIcon("image/btLogin_hud.png"));// ��ư�� �̹��� �߰� 
		lgbt.setBounds(755,589,104,48);
		lgbt.setBorderPainted(false);//�����ϰ��ϱ�
		lgbt.setFocusPainted(false);//�����ϰ��ϱ�
		lgbt.setContentAreaFilled(false);//�����ϰ��ϱ�
		layeredPane.add(lgbt);//�гο� �ֱ� 

		//ȸ������ ��ư �߰���
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
