package controller;

import java.sql.*;

public class loginService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean test = loginTest("tester","1234@");

	}
	public static boolean loginTest(String id, String pw) {
		boolean flag = false;
		
		String driverName="com.mysql.jdbc.Driver";
		String dbURL="jdbc:mysql://localhost:3306/user";
		
		
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql=null;
		String getPass =null;
		try {
			
			Class.forName(driverName);
			con=DriverManager.getConnection(dbURL,"root","12345");
			System.out.println("Driver connection success!!");
			sql="select PW from info where id=?"; 
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, id); // 첫번째 물음표에 값 넣기 
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				getPass = rs.getString("PW");
				
				if(getPass.equals(pw)) {
					flag=true;
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

