package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import controller.StatusService;

public class MainFrame extends JFrame{
	BufferedImage img =null;
	JTabbedPane jtp = null;
	JPanel jp = null;
	JPanel status_pan=null;
	JPanel food_pan=null;
	JPanel sport_pan=null;
	JPanel rank_pan=null;
	JButton logout= null;
	JButton modify = null;

	JTextField IDTextField=null;
	JTextField AgeTextField=null;
	JTextField NameTextField=null;
	JTextField GenderTextField=null;
	JTextField HeightTextField=null;
	JTextField WeightTextField=null;
	JTextField GoalTextField=null;

	private String ID = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame("tester");
	}
	public MainFrame(String id){

		ID = id;
		jtp = new JTabbedPane();
		jp =new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료하고 자원 반환

		//로그아웃 버튼
		logout=new JButton("Logout");
		logout.setBounds(1200,5,73,25);
		jp.add(logout);

		//정보수정버튼
		modify = new JButton("Modify");
		modify.setBounds(1120,5,74,25);
		jp.add(modify);

		jp.setBounds(0, 0, 1300, 100);
		jtp.setBounds(0,100,1300,700);

		//패널설정
		status_pan= new status_pan(ID);
		jtp.addTab("STATUS", status_pan);

		//음식
		food_pan=new food_pan();
		jtp.addTab("FOOD",food_pan);

		//스포츠
		sport_pan=new sport_pan();
		jtp.addTab("SPORT",sport_pan);

		//랭킹
		rank_pan=new rank_pan();
		jtp.addTab("RANK",rank_pan);


		this.setLayout(null);
		jp.setLayout(null);

		this.getContentPane().add(jp);
		this.getContentPane().add(jtp);
		this.setTitle("Kill a Gram");
		this.setSize(1300, 800);
		this.setVisible(true);

	}
	class status_pan extends JPanel{

		public status_pan(String id) {
			// TODO Auto-generated constructor stub
			String[] info = new String[7];

			info=StatusService.Status(id);

			if(info!=null){
				add(new StatusFrame(info[0],info[1],info[2],info[3],info[4],info[5],info[6]));
			}
			else{
				System.out.println("ERROR!!");
			}
		}
	}


	class food_pan extends JPanel{

	}
	class sport_pan extends JPanel{

	}
	class rank_pan extends JPanel{

	}


}


