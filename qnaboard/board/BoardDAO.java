package com.osol.qnaboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.osol.qnaboard.VO.Board;

public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement st;
	private ResultSet rs;
	
	public BoardDAO() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "SEMIPRJ", "2130");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 조회 및 검색 메소드 호출 스택
	public List<Board> getBoardList() {
		return getBoardList("B_TITLE", "", 1);
	}
	
	public List<Board> getBoardList(int page) {
		return getBoardList("B_TITLE", "", page);
	}
	
	public List<Board> getBoardList(String field/*B_TITLE, B_WRITER*/, String query/*%A%*/, int page) {
		
		List<Board> list = new ArrayList<>();
		
		String sql = "SELECT * FROM ("
				+ "SELECT ROWNUM NUM, N.* "
				+ "FROM (SELECT * FROM QNA_BOARD WHERE "+field+" LIKE ? ORDER BY B_NUM_SEQ DESC) N"
				+ ") "
				+ "WHERE NUM BETWEEN ? AND ?";
		
		// 1, 11, 21, 31 -> an = 1 + (page-1)*10
		// 10, 20, 30, 40 -> page*10
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			pstmt.setInt(2, 1+(page-1)*10);
			pstmt.setInt(3, page*10);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("B_NUM_SEQ");
				String title = rs.getString("B_TITLE");
				String writer = rs.getString("B_WRITER");
				String content = rs.getString("B_CONTENT");
				Date pubDate = rs.getDate("B_PUBDATE");
				int hit = rs.getInt("B_HIT");
				String state = rs.getString("B_STATE");
				String attachedFile = rs.getString("B_ATTACHEDFILE");
				
				Board b = new Board(
						num,
						title,
						writer,
						content,
						pubDate,
						hit,
						state,
						attachedFile
						);
				list.add(b);
			}
			
			
			
			/*
			request.setAttribute("num", num);
			request.setAttribute("writer", writer);
			request.setAttribute("title", title);
			request.setAttribute("pubDate", pubDate);
			request.setAttribute("hit", hit);
			*/
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public int getBoardCount() {
		return getBoardCount("B_TITLE", "");
	}
	
	public int getBoardCount(String field, String query) {
		
		int count = 0;
		
		String sql = "SELECT COUNT(B_NUM_SEQ) COUNT FROM "
				+ "(SELECT * FROM QNA_BOARD WHERE "+field+" LIKE ? ORDER BY B_NUM_SEQ DESC)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			rs = pstmt.executeQuery();				
			
			if(rs.next()) count = rs.getInt("count");
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return count;
	}
	
	public Board getBoardDetail(int num) {
		
		Board board = null;
		String sql = "SELECT * FROM QNA_BOARD WHERE B_NUM_SEQ=?";
		
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();		
			
			rs.next();
			int number = rs.getInt("B_NUM_SEQ");
			String title = rs.getString("B_TITLE");
			String writer = rs.getString("B_WRITER");
			String content = rs.getString("B_CONTENT");
			Date pubDate = rs.getDate("B_PUBDATE");
			int hit = rs.getInt("B_HIT");
			String state = rs.getString("B_STATE");
			String attachedFile = rs.getString("B_ATTACHEDFILE");
			
			board = new Board(
						number,
						title,
						writer,
						content,
						pubDate,
						hit,
						state,
						attachedFile
					);
			
			/*
			request.setAttribute("title", title);
			request.setAttribute("writer", writer);
			request.setAttribute("pubDate", pubDate);
			request.setAttribute("content", content);
			*/
			rs.close();
			pstmt.close();
			conn.close();		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return board;
	}	
	
	public void increaseBoardHit(int num) {
		String sql = "UPDATE QNA_BOARD SET B_HIT = B_HIT+1 WHERE B_NUM_SEQ = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
			
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
	
	public void insertBoard(String title, String content, String writer) {
		
		String sql = "INSERT INTO QNA_BOARD(B_TITLE, B_WRITER, B_CONTENT, B_PUBDATE, B_HIT, B_STATE, B_ATTACHEDFILE)"
				+ " VALUES(?,?,?,SYSDATE,DEFAULT,DEFAULT,NULL)";
		
		try {			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
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
	
	public void UpdateBoard(int num, String title, String content) {
		String sql = "UPDATE QNA_BOARD SET B_TITLE = ?, B_CONTENT = ? WHERE B_NUM_SEQ = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
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
	
	public void DeleteBoard(int num) {
		String sql = "DELETE FROM QNA_BOARD WHERE B_NUM_SEQ = ?";
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();			
			
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
