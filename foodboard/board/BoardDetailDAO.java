package com.osol.foodboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.osol.foodboard.VO.BoardVO;



public class BoardDetailDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;
	
	
	public BoardDetailDAO() {
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
	
	
	
	public BoardVO detail(int num) {
		BoardVO dv = new BoardVO();
		String sql = "SELECT * FROM FOODBOARD WHERE B_NUM_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				dv.setBbsNum(rset.getInt(1));
				dv.setKind(rset.getString(2));
				dv.setGrade(rset.getString(3));
				dv.setBbsTitle(rset.getString(4));
				dv.setBbsContent(rset.getString(5));
				dv.setBbsTime(rset.getDate(6));
				dv.setBbsHit(rset.getInt(7));
				dv.setBbsState(rset.getString(8));
				dv.setBbsFile(rset.getString(9));		
				dv.setBbsWriter(rset.getString(10));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dv;
	
			
	}
	
	
	
	
	
	
	
	
	
	
}
