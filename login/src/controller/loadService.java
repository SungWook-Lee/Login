package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import view.Main;

public class loadService  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] flag = Load("tester");
	}

	public static String[] Load(String id) {
		// TODO Auto-generated method stub
		
		String[] flag=new String[7];
		String driverName="com.mysql.jdbc.Driver";
		String dbURL="jdbc:mysql://localhost:3306/user";

		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql=null;

		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(dbURL,"root","12345");
			sql="select * from staus where id = ?"; 
			pstmt = con.prepareStatement(sql);
			String ID;
			String Name;
			String Age;
			String gender;
			String Height;
			String Weight;
			String Goal;
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();


			while(rs.next()){

				ID = rs.getString("ID");
				Name = rs.getString("Name");
				int temp_age = rs.getInt("Age");
				Age = String.valueOf(temp_age);
				gender = rs.getString("Gender");
				float temp_Height = rs.getFloat("Height");
				Height = String.valueOf(temp_Height);
				float temp_Weight = rs.getFloat("Weight");
				Weight =String.valueOf(temp_Weight);
				float temp_Goal = rs.getFloat("Goal");
				Goal = String.valueOf(temp_Goal);

				if(ID !=null && Name != null && Age !=null&& gender!= null&&Height != null
						&& Weight !=null && Goal !=null){

					flag[0]=ID;
					flag[1]=Name;
					flag[2]=Age;
					flag[3]=gender;
					flag[4]=Height;
					flag[5]=Weight;
					flag[6]=Goal;
					
					return flag;
				}
				else 
					return flag;
			}
			rs.close();
			pstmt.close();
			con.close();
			
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
		return flag;
	}
	
}
