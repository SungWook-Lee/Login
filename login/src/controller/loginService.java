package controller;

import java.sql.*;

import asset.DBConnectionMgr;


public class loginService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean test = loginTest("test","1234");

	}
	public static boolean loginTest(String id, String pw) {
		boolean flag = false;
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql=null;
		String getPass =null;
		try {
			con=pool.getConnection();
			sql="select password from User_info where id=?"; 
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id); // 첫번째 물음표에 값 넣기 
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				getPass = rs.getString("password");
				
				if(getPass.equals(pw)) {
					flag=true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return flag;
	}

}

