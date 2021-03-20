package com.osol.jobboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.osol.jobboard.VO.BoardVO;

public class BoardDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;


	public BoardDAO() {
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

	public List<BoardVO> list(String field, String query, int page) {

		List<BoardVO> listBV = new ArrayList<>();
		System.out.println("ㅇㅇㅇ");
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM JOB_BOARD WHERE "+field+" LIKE ? ORDER BY B_PUBDATE DESC) N) WHERE NUM BETWEEN ? AND ?";
		System.out.println("ㅇㅇㅇㅁㄴㅇㅇ");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			pstmt.setInt(2, 1+(page-1)*5);
			pstmt.setInt(3, page*5);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int boardNum = rs.getInt("B_NUM_SEQ");
				String boardTitle = rs.getString("B_TITLE");
				String boardContent = rs.getString("B_CONTENT");
				Date boardPubDate = rs.getDate("B_PUBDATE");
				int boardHit = rs.getInt("B_HIT");
				String boardState = rs.getString("B_STATE");
				String boardFiles = rs.getString("B_ATTACHEDFILE");
				String boardWriter = rs.getString("B_WRITER");


				BoardVO BV = new BoardVO(
						boardNum,
						boardTitle, 
						boardContent, 
						boardPubDate,
						boardHit,
						boardState,
						boardFiles,
						boardWriter
						);
				listBV.add(BV);
			}
			System.out.println("완성");

			return listBV;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listBV;
	}

	public BoardVO detail(int bdNum) {

		String sql = "SELECT * FROM JOB_BOARD WHERE B_NUM_SEQ = ?";
		BoardVO BV = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bdNum);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				int boardNum = rs.getInt(1);
				String boardTitle = rs.getString(2);
				String boardContent = rs.getString(3);
				Date boardPubDate = rs.getDate(4);
				int boardHit = rs.getInt(5);
				String boardState = rs.getString(6);
				String boardFiles = rs.getString(7);
				String boardWriter = rs.getString(8);

				BV = new BoardVO(
						boardNum,
						boardTitle, 
						boardContent, 
						boardPubDate,
						boardHit,
						boardState,
						boardFiles,
						boardWriter
						);
			}


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

		return BV;
	}

	public int delete(int dtNum) {
		String sql = "DELETE FROM JOB_BOARD WHERE B_NUM_SEQ = ?"; 
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dtNum);			
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

		return 0;
	}

	public BoardVO update(int udNum) {

		String sql = "SELECT * FROM JOB_BOARD WHERE B_NUM_SEQ = ?";
		BoardVO BV = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,udNum);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				int boardNum = rs.getInt(1);
				String boardTitle = rs.getString(2);
				String boardContent = rs.getString(3);
				Date boardPubDate = rs.getDate(4);
				int boardHit = rs.getInt(5);
				String boardState = rs.getString(6);
				String boardFiles = rs.getString(7);
				String boardWriter = rs.getString(8);

				BV = new BoardVO(
						boardNum,
						boardTitle, 
						boardContent, 
						boardPubDate,
						boardHit,
						boardState,
						boardFiles,
						boardWriter
						);
			}
			return BV;

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

		return BV;
	}

	public int reWrite(String title, String content, int num) {
		String sql = "UPDATE JOB_BOARD SET B_TITLE = ?, B_CONTENT = ? WHERE B_NUM_SEQ = ?"; 
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			result = pstmt.executeUpdate();
			System.out.println(result);

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

		return result;
	}

	public int write(String title, String content, String id) {
		String sql = "INSERT INTO JOB_BOARD VALUES(B_NUM_SEQ.NEXTVAL,?, ?, SYSDATE, 1, '공개', '없음', ?)"; 
		int result = 0 ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
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

		return result;
	}



}
