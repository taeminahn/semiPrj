package com.osol.studyboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWriteDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private int result;
	
	public BoardWriteDAO() {
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
	
	public int BoardWrite(String bbstitle, String bbsContent, 
			String bbsWriter) {
		
//		String sql = "INSERT INTO BOARD VALUES(2,?,?,SYSTIMESTAMP,"
//				+ "DEFAULT,DEFAULT,NULL,?)";
		String sql = "INSERT INTO STUDY_BOARD(B_TITLE, B_CONTENT, B_PUBDATE, B_HIT, B_STATE, B_ATTACHEDFILE, B_WRITER) VALUES(?,?,SYSTIMESTAMP,"
				+ "DEFAULT,DEFAULT,NULL,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbstitle);
			pstmt.setString(2, bbsContent);
			pstmt.setString(3, bbsWriter);
			result = pstmt.executeUpdate();
			
			if(result != 1) {
				System.out.println("글쓰기 실패..");
				System.out.println("반환값 : "+result);
				return result;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
		
}
