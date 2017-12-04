package controller;

import java.sql.*;

public class loginService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean test = loginTest("tester","1234@");

	}
	public static boolean loginTest(String id, String pw) {
		boolean flag = false;
		
		String driverName="com.mysql.jdbc.Driver";//DB드라이버? 
		String dbURL="jdbc:mysql://localhost:3306/user";// DB주소
		
		
		Connection con=null; 
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql=null;
		String getPass =null;
		try {
			
			Class.forName(driverName);//모름 ㅋ
			con=DriverManager.getConnection(dbURL,"root","12345");//DB연결
			System.out.println("Driver connection success!!");
			sql="select PW from info where id=?"; //쿼리문 세팅 a.k.a총알
			pstmt = con.prepareStatement(sql);// 쿼리문을 디비에 a.k.a 탄집
			
			
			pstmt.setString(1, id); // 첫번째 물음표에 값 넣기 
			
			rs=pstmt.executeQuery();// 쿼리문 실행에서 rs에 저장 a.k.a 발사
			
			while(rs.next()) {//rs에 가 있을때까지 
				getPass = rs.getString("PW");// rs에서 비밀번호 가져와서 getpass에 저장
				
				if(getPass.equals(pw)) {// getpass가 비밀번호랑 같은지 확인
					flag=true;// 리턴 
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

