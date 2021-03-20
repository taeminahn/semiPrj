package com.osol.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.osol.foodboard.VO.MemberVO;


public class MyPageDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;
	
	public MyPageDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "SEMIPRJ";
			String dbPW = "2130";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public MemberVO myinfo(String memberID) {
		MemberVO mv = new MemberVO();
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ?";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mv.setMemberId(rset.getString(1));
				mv.setMemberNum(rset.getInt(2));
				mv.setMemberPwd(rset.getString(3));
				mv.setmemberName(rset.getString(4));
				mv.setMemberBirthday(rset.getDate(5));
				mv.setMemberGender(rset.getString(6));
				mv.setMemberEmail(rset.getString(7));
				mv.setMemberPhone(rset.getString(8));
				mv.setMemberAddress(rset.getString(9));
				mv.setMemberRegdate(rset.getDate(10));
				mv.setMemberGrade(rset.getString(11));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				rset.close();
				pstmt.close();
				conn.close();
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return mv;
	}
	
	
	
	
	
	
	
	
	

}
