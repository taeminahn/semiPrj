package com.osol.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osol.qnaboard.VO.Member;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "SEMIPRJ", "2130");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int login(String memberID, String memberPW) {
		String sql = "SELECT M_PWD FROM MEMBER WHERE M_ID=?";
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(memberPW)) {
					return 1; // 로그인 성공
				} 					
			}					
			return 0; // 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally  {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -2; // sql 오류
	}
	
	public String idFinder(String name, String phone, String email) {
		String sql = "SELECT M_ID FROM MEMBER"
				+ " WHERE M_NAME = ? AND M_PHONE = ? AND M_EMAIL = ?";
		
		String id = null;
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(1);				
			} 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally  {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return id;
	}
	
	public String pwFinder(String id, String email) {
		String _email = null;
		
		String sql = "SELECT M_EMAIL FROM MEMBER" + 
				" WHERE M_ID = ? AND M_EMAIL = ?";
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				_email = rs.getString("M_EMAIL");
			} 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally  {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return _email;
	}
	
	public void changePw(String id, String newPw) {
		String sql = "UPDATE MEMBER SET M_PWD = ? WHERE M_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
