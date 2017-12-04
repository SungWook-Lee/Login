package controller;

import java.sql.*;

public class loginService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean test = loginTest("tester","1234@");

	}
	public static boolean loginTest(String id, String pw) {
		boolean flag = false;
		
		String driverName="com.mysql.jdbc.Driver";//DB����̹�? 
		String dbURL="jdbc:mysql://localhost:3306/user";// DB�ּ�
		
		
		Connection con=null; 
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql=null;
		String getPass =null;
		try {
			
			Class.forName(driverName);//�� ��
			con=DriverManager.getConnection(dbURL,"root","12345");//DB����
			System.out.println("Driver connection success!!");
			sql="select PW from info where id=?"; //������ ���� a.k.a�Ѿ�
			pstmt = con.prepareStatement(sql);// �������� ��� a.k.a ź��
			
			
			pstmt.setString(1, id); // ù��° ����ǥ�� �� �ֱ� 
			
			rs=pstmt.executeQuery();// ������ ���࿡�� rs�� ���� a.k.a �߻�
			
			while(rs.next()) {//rs�� �� ���������� 
				getPass = rs.getString("PW");// rs���� ��й�ȣ �����ͼ� getpass�� ����
				
				if(getPass.equals(pw)) {// getpass�� ��й�ȣ�� ������ Ȯ��
					flag=true;// ���� 
				}
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
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
		return flag;
	}

}

