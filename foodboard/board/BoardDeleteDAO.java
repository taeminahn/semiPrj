package com.osol.foodboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardDeleteDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private int result; 
	
	public BoardDeleteDAO() {
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
	
	public int delete(int num) {
		String sql = "DELETE FROM FOODBOARD WHERE B_NUM_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return -1;
	} 	

}
