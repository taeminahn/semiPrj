package com.osol.foodboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardUpdateDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private int result;


	public BoardUpdateDAO() {
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

	
	
	
	public int update(String kind, String grade, String title, String content, int num) {
		String sql = "UPDATE FOODBOARD SET B_KIND=?, B_GRADE=?, B_TITLE=?, B_CONTENT=? WHERE B_NUM_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			pstmt.setString(2, grade);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setInt(5, num);
			result = pstmt.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	} 
	
	
	
	
	
}

