package com.osol.studyboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osol.studyboard.VO.BoardVO;

public class BoardModifyDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private int result;
	
	public BoardModifyDAO() {
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
	
	public int BoardModify(int bbsNumSeq, String bbsTitle, String bbsContent) {
		
		int result = 0;
		
		String sql = "UPDATE STUDY_BOARD SET B_TITLE = ?, B_CONTENT = ? WHERE B_NUM_SEQ = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsNumSeq);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
