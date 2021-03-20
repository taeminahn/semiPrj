package com.osol.studyboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private int result;
	
	public BoardDeleteDAO() {
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
	
	public int BoardDelete(int bbsNumSeq) {
		
		String sql = "DELETE STUDY_BOARD WHERE B_NUM_SEQ = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsNumSeq);
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				return result;
			}else {
				System.out.println("삭제 실패했습니둥..");
				System.out.println("반환값 : "+result);
				return result;
			}
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
