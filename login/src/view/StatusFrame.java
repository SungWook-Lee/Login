package view;
import view.MainFrame;

import java.awt.Color;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusFrame extends JFrame{

	JTextField IDTextField;
	JTextField AgeTextField;
	JTextField NameTextField;
	JTextField HeightTextField;
	JTextField WeightTextField;
	JTextField GoalTextField;
	JPanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new StatusFrame("tester");
	}
	public StatusFrame(String id){

		String driverName="com.mysql.jdbc.Driver";
		String dbURL="jdbc:mysql://localhost:3306/user";

		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql=null;
		String getPass =null;

		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(dbURL,"root","12345");
			sql="select * from staus where id=?"; 
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			pstmt.setString(1, id);

			while(rs.next()){
				String ID = rs.getString("ID");
				String Name = rs.getString("Name");
				int temp_age = rs.getInt("Age");
				String Age = String.valueOf(temp_age);
				String gender = rs.getString("Gender");
				float temp_Height = rs.getFloat("Height");
				String Height = String.valueOf(temp_Height);
				float temp_Weight = rs.getFloat("Weight");
				String Weight =String.valueOf(temp_Weight);
				float temp_Goal = rs.getFloat("Goal");
				String Gaol = String.valueOf(temp_Goal);
			}
			

			IDTextField = new JTextField("ID");
			NameTextField = new JTextField("Name");
			AgeTextField = new JTextField("Age");
			HeightTextField = new JTextField("Height");
			WeightTextField = new JTextField("Weight");
			GoalTextField= new JTextField("Goal");

			setTitle("Kill a Gram");
			setSize(1300,800);
			setLayout(null);
			panel = new JPanel();
			JLayeredPane layeredPane = new JLayeredPane(); 
			layeredPane.setBounds(0,0,800,1300);
			layeredPane.setLayout(null);
			layeredPane.add(panel);
			
			IDTextField.setBounds(100,100,280,30);
			IDTextField.setOpaque(false); // 투명하게 하기 
			IDTextField.setForeground(Color.BLACK);
			IDTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
			layeredPane.add(IDTextField);
			
			NameTextField.setBounds(100,150,280,30);
			NameTextField.setOpaque(false); // 투명하게 하기 
			NameTextField.setForeground(Color.BLACK);
			NameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
			layeredPane.add(NameTextField);

			AgeTextField.setBounds(100,200,280,30);
			AgeTextField.setOpaque(false); // 투명하게 하기 
			AgeTextField.setForeground(Color.BLACK);
			AgeTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
			layeredPane.add(AgeTextField);
			
			HeightTextField.setBounds(100,250,280,30);
			HeightTextField.setOpaque(false); // 투명하게 하기 
			HeightTextField.setForeground(Color.BLACK);
			HeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
			layeredPane.add(HeightTextField);
			
			WeightTextField.setBounds(100,300,280,30);
			WeightTextField.setOpaque(false); // 투명하게 하기 
			WeightTextField.setForeground(Color.BLACK);
			WeightTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
			layeredPane.add(WeightTextField);
			
			GoalTextField.setBounds(100,350,280,30);
			GoalTextField.setOpaque(false); // 투명하게 하기 
			GoalTextField.setForeground(Color.BLACK);
			GoalTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
			layeredPane.add(GoalTextField);

		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
	}

}
