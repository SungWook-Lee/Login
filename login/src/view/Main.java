package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.loadService;

public class Main extends JFrame{
	
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
		new Main("tester");
	}
	public Main(String id){

		ID = id;
		jtp = new JTabbedPane();
		jp =new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �����ϰ� �ڿ� ��ȯ

		//�г� ����
		//�α׾ƿ� ��ư
		logout=new JButton("Logout");
		logout.setBounds(1200,5,73,25);
		jp.add(logout);

		//����������ư
		modify = new JButton("Modify");
		modify.setBounds(1120,5,74,25);
		jp.add(modify);

		jp.setBounds(0, 0, 1300, 100);
		jtp.setBounds(0,100,1300,700);

		//�Ǽ���
		status_pan= new status_pan(ID);
		
		//����
		food_pan=new food_pan();

		//������
		sport_pan=new sport_pan();
	
		//��ŷ
		rank_pan=new rank_pan();
	
		this.setLayout(null);
		jp.setLayout(null);

		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Login();
			}
		});
		
		modify.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = ID;
				String[] info = new String[7];
				info= loadService.Load(id);
				new Modify(info[0],info[1],info[2],info[3],info[4],info[5],info[6]);	
			}
			
		});
		
		this.getContentPane().add(jp);
		this.getContentPane().add(jtp);
		this.setTitle("Kill a Gram");
		this.setSize(1300, 800);
		this.setVisible(true);

	}
	public String getID(){
		return this.ID;
	}
	
	class status_pan extends JPanel{
	
		public status_pan(String id) {
			// TODO Auto-generated constructor stub
			String[] info = new String[7];

			info=loadService.Load(id);
			
			if(info!=null){
				jtp.add("STATUS",new Status(info[0],info[1],info[2],info[3],info[4],info[5],info[6]));
			}
			else{
				System.out.println("ERROR!!");
			}
		}
	}

	class food_pan extends JPanel{
		
		public food_pan(){
			jtp.add("FOOD", new Food());
		}

	}
	class sport_pan extends JPanel{
		
		public sport_pan(){
			jtp.add("SPORT", new Sport());
		}

	}
	class rank_pan extends JPanel{
		
		public rank_pan(){
			
			jtp.add("RANK", new Rank());
		}

	}

}


