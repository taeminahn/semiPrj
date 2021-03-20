package com.osol.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.osol.studyboard.VO.MemberVO;

public class JoinMemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private int result;
	
	public JoinMemberDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "SEMIPRJ";
			String dbPassword = "2130";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int join(com.osol.user.MemberVO mv) {
		String sql = "INSERT INTO MEMBER(M_ID, M_NUM_SEQ, M_PWD, M_NAME, M_BIRTHDAY, "
				+ "M_GENDER, M_EMAIL, M_PHONE, M_ADDRESS) "
				+ "VALUES(?,SEMI_M_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMbId());
			pstmt.setString(2, mv.getMbPwd());
			pstmt.setString(3, mv.getMbName());
			pstmt.setString(4, mv.getMbBirthday());
			pstmt.setString(5, mv.getMbGender());
			pstmt.setString(6, mv.getMbEmail());
			pstmt.setString(7, mv.getMbPhone());
			pstmt.setString(8, mv.getMbAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("오류 발생 : 관리자에게 문의하세요.");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("오류 발생 : 관리자에게 문의하세요.");
				e.printStackTrace();
			}
		}
		return result;
		
	}
}
