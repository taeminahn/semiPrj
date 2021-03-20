package com.osol.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.osol.foodboard.VO.MemberVO;

public class ConfirmDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rset;
	
	public ConfirmDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "SEMIPRJ";
			String dbPassword = "2130";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public MemberVO passwordconfirm(String userId) {
		MemberVO mv = new MemberVO();
		String sql = "SELECT M_PWD FROM MEMBER WHERE M_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mv.setMemberPwd(rset.getString(1));
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
		} return mv;
	
	} 
	
	
	

}
