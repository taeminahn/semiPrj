package com.osol.studyboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.osol.studyboard.VO.BoardVO;

public class BoardListDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	public BoardListDAO() {
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
	
	public List<BoardVO> BoardList(String field, String query, int page) {
		
		List<BoardVO> list = new ArrayList<>();
		
//		String sql = "SELECT * FROM BOARD ORDER BY B_NUM_SEQ DESC";
		
		String sql = "SELECT * FROM (" + 
				"    SELECT ROWNUM NUM, B.* " + 
				"    FROM (SELECT * FROM STUDY_BOARD WHERE "+field+" LIKE '%"+query+"%' ORDER BY B_PUBDATE DESC) B" + 
				") " + 
				"WHERE NUM BETWEEN "+(1+(page-1)*10)+" AND "+page*10+"";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int bbsNumSeq = rs.getInt("B_NUM_SEQ");
				String bbsTitle = rs.getString("B_TITLE");
				String bbsContent = rs.getString("B_CONTENT");
				Date bbsPubDate = rs.getDate("B_PUBDATE");
				int bbsHit = rs.getInt("B_HIT");
				String bbsState = rs.getString("B_STATE");
				String bbsFiles = rs.getString("B_ATTACHEDFILE");
				String bbsWriter = rs.getString("B_WRITER");
			
				BoardVO bv = new BoardVO(
						bbsNumSeq,
						bbsTitle,
						bbsContent,
						bbsPubDate,
						bbsHit,
						bbsState,
						bbsFiles,
						bbsWriter
						);
				list.add(bv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return list;
	}
	
	public int getListCount(String field, String query) {
		
		int count = 0;
		
		String sql = "SELECT COUNT(B_WRITER) COUNT FROM "
				+ "(SELECT ROWNUM NUM, B.*FROM "
				+ "(SELECT * FROM STUDY_BOARD WHERE "+field+" LIKE '%"+query+"%' ORDER BY B_PUBDATE DESC) B)";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
			
		return count; 	
	}
}
