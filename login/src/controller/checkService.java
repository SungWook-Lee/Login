package controller;

import java.sql.*;

public class checkService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean test = check("tester");

	}
	
	public static boolean check(String id) {
		// TODO Auto-generated method stub
		boolean flag=false;

		String driverName="com.mysql.jdbc.Driver";
		String dbURL="jdbc:mysql://localhost:3306/user";

		Connection con=null;
		PreparedStatement pstmt =null;		
		String sql=null;
		ResultSet rs = null;
		String getPass=null;
		try {

			Class.forName(driverName);
			con=DriverManager.getConnection(dbURL,"root","12345");
			System.out.println("Driver connection success!!");
			sql="select ID from info where id=?";
			pstmt = con.prepareStatement(sql);


			pstmt.setString(1, id); // 첫번째 물음표에 값 넣기 

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				getPass = rs.getString("ID");
				
				if(getPass.equals(id)) {
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
