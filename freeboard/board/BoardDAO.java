package com.osol.freeboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.osol.common.JDBCTemplate4;
import com.osol.freeboard.VO.BoardVO;
import com.osol.freeboard.VO.ListBoardVO;

public class BoardDAO {
	
	public BoardDAO() {
	}
	
	
	// 목록 출력용 DAO
	public List<ListBoardVO> getBoardList(String field, String query, int page) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ListBoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM2, BCC.* FROM "
				+ "(SELECT ROWNUM NUM, BC.* FROM"
				+ "(SELECT B.B_NUM_SEQ, B.B_TITLE, B.B_PUBDATE, B.B_HIT, B.B_WRITER, COUNT"
				+ "(C.CMT_NUM_SEQ) FROM (SELECT * FROM BOARD WHERE "+field+" LIKE ? ORDER BY B_PUBDATE ASC)"
				+ " B LEFT JOIN CMT C ON B.B_NUM_SEQ = "
				+ "C.BOARD_NUM_SEQ GROUP BY B.B_NUM_SEQ, B.B_TITLE, B.B_PUBDATE, B.B_HIT, B.B_WRITER ORDER BY B.B_PUBDATE ASC)"
				+ " BC ORDER BY ROWNUM DESC) BCC) WHERE NUM2 BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			pstmt.setInt(2,1+(page-1)*10);
			pstmt.setInt(3,page*10);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				int boardNum = rs.getInt(2);
				int boardId = rs.getInt(3);
				String boardTitle = rs.getString(4);
				Date boardPubDate = rs.getDate(5);
				int boardHit = rs.getInt(6);
				String boardWriter = rs.getString(7);
				int cmtCount = rs.getInt(8);
				
				ListBoardVO bv = new ListBoardVO(boardNum, boardId, boardTitle, boardPubDate, boardHit, boardWriter, cmtCount);
				list.add(bv);
			}
			
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
		return list;
	}
	
	// 페이징 갯수 구하는 dao
	public int getBoardCount(String field, String query) {
		
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count =0;
		
		
		String sql = "SELECT COUNT(NUM2) COUNT FROM "
				+ "(SELECT ROWNUM NUM2, BC.* FROM (SELECT ROWNUM NUM, B.* FROM "
				+ "(SELECT * FROM BOARD WHERE "+field+" LIKE ? ORDER BY B_PUBDATE ASC)"
				+ " B ORDER BY ROWNUM DESC) BC)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	// 뷰 디테일 구하는 DAO
	public BoardVO getBoard(int id) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO bv = null;
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM2, BC.* FROM "
				+ "(SELECT ROWNUM NUM, B.* FROM (SELECT * FROM BOARD ORDER BY B_PUBDATE ASC)"
				+ " B ORDER BY ROWNUM DESC) BC) WHERE B_NUM_SEQ = ?";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt(2);
				int bid = rs.getInt(3);
				String title = rs.getString(4);
				String content = rs.getString(5);
				Date pubDate = rs.getDate(6);
				int hit = rs.getInt(7);
				String state = rs.getString(8);
				String files = rs.getString(9);
				String writer = rs.getString(10);
				
				bv = new BoardVO(id,bid,title,content,pubDate,hit,state,files,writer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return bv;
	}
	
	public BoardVO getNextBoard(int id) {
		BoardVO bv = null;
		
		return null;
	}
	
	public BoardVO getPrevBoard(int id) {
		BoardVO bv = null;
		
		return null;
	}
	
	// 글 수정하는 DAO
	public int boardUpdate(int num, String title, String content) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET B_TITLE = ?, B_CONTENT = ? WHERE B_NUM_SEQ = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -2;
	}
	
	// 글 작성하는 DAO
	public int write(String title, String content, String id) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD VALUES(B_NUM_SEQ.NEXTVAL,?,?,SYSDATE,0,'공개','nmy.text',?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -2;
	}
	
	public int hitUpdate(int num) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET B_HIT = B_HIT+1 WHERE B_NUM_SEQ = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -2;
	}
	
	public int boardDelete(int id) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM BOARD WHERE B_NUM_SEQ = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -2;
	}
}
