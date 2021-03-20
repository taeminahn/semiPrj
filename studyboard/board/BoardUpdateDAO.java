package com.osol.studyboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.osol.studyboard.VO.BoardVO;

public class BoardUpdateDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardUpdateDAO() {
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
	
	public BoardVO BoardUpdate(int bbsNumSeq_) {
		
		BoardVO bv = null;
		
		String sql = "SELECT * FROM STUDY_BOARD WHERE B_NUM_SEQ=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsNumSeq_);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bbsNumSeq = rs.getInt("B_NUM_SEQ");
				String bbsTitle = rs.getString("B_TITLE");
				String bbsContent = rs.getString("B_CONTENT");
				Date bbsPubDate = rs.getDate("B_PUBDATE");
				int bbsHit = rs.getInt("B_HIT");
				String bbsState = rs.getString("B_STATE");
				String bbsFiles = rs.getString("B_ATTACHEDFILE");
				String bbsWriter = rs.getString("B_WRITER");
				
				bv = new BoardVO(
					bbsNumSeq,
					bbsTitle,
					bbsContent,
					bbsPubDate,
					bbsHit,
					bbsState,
					bbsFiles,
					bbsWriter
					);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return bv;
	}
}
