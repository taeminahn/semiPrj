package com.osol.foodboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardWriteDAO {

		private Connection conn;
		private PreparedStatement pstmt;
		private int result;
		
		public BoardWriteDAO() {
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
		

		
		public int write(String title, String content, String kind, String grade, String memberID) {
			System.out.println(title);
			System.out.println(content);
			String sql = "INSERT INTO FOODBOARD VALUES(1, ?, ?, ?, ?, SYSDATE, 1, '공개', '없음', ?)"; 
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, kind);
				pstmt.setString(2, grade);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				pstmt.setString(5, memberID);				
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

}
