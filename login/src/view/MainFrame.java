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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료하고 자원 반환


		//레이아웃 설정
	
		container.add(jtp, BorderLayout.CENTER);
	
		
		//이미지 받아오기
		/*try {
			img = ImageIO.read(new File("image/login.png")); //이미지 변경부분 
		}catch(IOException e) {
			System.out.println("Fail to load image");
			System.exit(0);
		}*/


		main = new JPanel();
		//정보
		status_pan= new JPanel();
		jtp.addTab("STATUS",status_pan);
		//음식
		food_pan=new JPanel();
		jtp.addTab("FOOD",food_pan);
		//스포츠
		sport_pan=new JPanel();
		jtp.addTab("SPORT",sport_pan);
		//랭킹
		rank_pan=new JPanel();
		jtp.addTab("RANK",rank_pan);
		

		getContentPane().add(jtp);
		this.setTitle("Kill a Gram");
		this.setSize(1300, 800);
		this.setVisible(true);
	}

}


