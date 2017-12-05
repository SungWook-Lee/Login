package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyService {
	
	public static boolean modify(String id, String pw, String name,int age,String gender,float height, float weight,float goal ){

		int flag = 0;
		boolean str=false;
		String driverName="com.mysql.jdbc.Driver";
		String dbURL="jdbc:mysql://localhost:3306/user";
		String in_age = String.valueOf(age);
		String in_height=String.valueOf(height);
		String in_weight = String.valueOf(weight);
		String in_goal = String.valueOf(goal);

		Connection con=null;
		PreparedStatement pstmt =null;

		String sql=null;

		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(dbURL,"root","12345");

			System.out.println("Driver connection success!!");

			sql="update info set ID=?, PW=?, Name=?, Age=?, Gender=?, Height=?, Weight=?, Goal=? where ID=?"; 

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, in_age);
			pstmt.setString(5, gender);
			pstmt.setString(6, in_height);
			pstmt.setString(7, in_weight);
			pstmt.setString(8, in_goal);
			pstmt.setString(9, id);

			flag=pstmt.executeUpdate();

			if(flag==1){
				str=true;
				return str;
			}
			else
				return str;

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
		return str;
	}

}
