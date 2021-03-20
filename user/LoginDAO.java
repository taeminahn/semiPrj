package com.osol.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public LoginDAO() {
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
	
	
	public int login(String memberId, String memberPwd) {
		System.out.println(memberId);
		System.out.println(memberPwd);
		
		String sql = "SELECT M_PWD FROM MEMBER WHERE M_ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(memberPwd)) {
					return 1;		// 비밀번호 일치
				}
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -2;
	}
}
