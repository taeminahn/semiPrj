package com.osol.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.osol.jobboard.VO.BoardVO;
import com.osol.jobboard.VO.MemberVO;

public class withDrawDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public withDrawDAO() {
		
		
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
	
	public MemberVO withDraw(String id) {
		System.out.println("1지점");
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ?";
		MemberVO MV = new MemberVO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			System.out.println(id+"hi");
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String memberId = rs.getString("M_ID");
				int memberNum = rs.getInt("M_NUM_SEQ");
				String memberPwd = rs.getString("M_PWD");
				String memberName = rs.getString("M_NAME");
				Date memberBirthday = rs.getDate("M_BIRTHDAY");
				String memberGender = rs.getString("M_GENDER");
				String memberEmail = rs.getString("M_EMAIL");
				String memberPhone = rs.getString("M_PHONE");
				String memberAddress = rs.getString("M_ADDRESS");
				Date memberRegdate = rs.getDate("M_REGDATE");
				String memberGrade = rs.getString("M_GRADE");
				
				MV = new MemberVO(
						memberId,
						memberNum,
						memberPwd,
						memberName,
						memberBirthday,
						memberGender,
						memberEmail,
						memberPhone,
						memberAddress,
						memberRegdate,
						memberGrade
						);
				
				
			};
			
			return MV;


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return MV;
	}
	
	public int withDrawAction(String id) {
		String sql = "DELETE FROM MEMBER WHERE M_ID = ?"; 
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);			
			result = pstmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return -1;
	}
}
