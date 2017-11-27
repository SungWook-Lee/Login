package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import view.LoginFrame.Mypanel;

public class MainFrame extends JFrame{
	BufferedImage img =null;
	JTabbedPane jtp = null;
	JPanel status_pan=null;
	JPanel food_pan=null;
	JPanel sport_pan=null;
	JPanel rank_pan=null;
	Container container=null;
	JPanel main =null;
	JButton logout= null;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame("tester");
	}
	public MainFrame(String id){
		
		String ID=id;
		container = new Container();
		jtp = new JTabbedPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �����ϰ� �ڿ� ��ȯ


		//���̾ƿ� ����
	
		container.add(jtp, BorderLayout.CENTER);
	
		
		//�̹��� �޾ƿ���
		/*try {
			img = ImageIO.read(new File("image/login.png")); //�̹��� ����κ� 
		}catch(IOException e) {
			System.out.println("Fail to load image");
			System.exit(0);
		}*/


		main = new JPanel();
		//����
		status_pan= new JPanel();
		jtp.addTab("STATUS",status_pan);
		//����
		food_pan=new JPanel();
		jtp.addTab("FOOD",food_pan);
		//������
		sport_pan=new JPanel();
		jtp.addTab("SPORT",sport_pan);
		//��ŷ
		rank_pan=new JPanel();
		jtp.addTab("RANK",rank_pan);
		

		getContentPane().add(jtp);
		this.setTitle("Kill a Gram");
		this.setSize(1300, 800);
		this.setVisible(true);
	}

}


