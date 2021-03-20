package com.osol.studyboard.comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.osol.studyboard.VO.CommentVO;

public class BoardCommentDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private int result;
	private ResultSet rs;
	
	public BoardCommentDAO() {
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
	
	
	public int BoardCommentWriter(int bbsNumSeq, String cmtWriter,
			String cmtContent) {
		
		String sql = "INSERT INTO STUDY_COMMENT (CMT_CONTENT, "
				+ "CMT_STATE, CMT_WRITER, CMT_PUBDATE, "
				+ "BOARD_NUM_SEQ) VALUES(?, DEFAULT, ?, DEFAULT, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cmtContent);
			pstmt.setString(2, cmtWriter);
			pstmt.setInt(3, bbsNumSeq);
			result = pstmt.executeUpdate();
			
			if(result != 1) {
				System.out.println("댓글 작성 실패");
				System.out.println("result : "+result);
				return result;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<CommentVO> BoardCommentList(int bbsNumSeq_){
		
		List<CommentVO> cmtList = new ArrayList<>();
		int count = 0;
		
		String sql = "SELECT * FROM STUDY_COMMENT WHERE BOARD_NUM_SEQ = ? "
				+ "ORDER BY CMT_NUM_SEQ ASC";
		
		
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, bbsNumSeq_);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int cmtNumSeq = rs.getInt("CMT_NUM_SEQ");
				String cmtContent = rs.getString("CMT_CONTENT");
				String cmtState = rs.getString("CMT_STATE");
				String cmtWriter = rs.getString("CMT_WRITER");
				Date cmtPubdate = rs.getDate("CMT_PUBDATE");
				int bbsNumSeq = rs.getInt("BOARD_NUM_SEQ");
				
				CommentVO cv = new CommentVO(
						cmtNumSeq,
						cmtContent,
						cmtState,
						cmtWriter,
						cmtPubdate,
						bbsNumSeq
						);
				cmtList.add(cv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cmtList;
	}
	
}
