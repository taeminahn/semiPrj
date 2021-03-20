package com.osol.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;

public class MyUpdateDAO {

	Connection conn;
	PreparedStatement pstmt;
	int result;
	
	public MyUpdateDAO() {
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
	
	
	public int update(String password, String name, String gender,
						Date birth, String phone, String address, String email, String id) {
		String sql = "UPDATE MEMBER SET M_PWD=?, M_NAME=?, M_GENDER=?, M_BIRTHDAY=?, M_PHONE=?, M_ADDRESS=?, M_EMAIL=? WHERE M_ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setDate(4, birth);
			pstmt.setString(5, phone);
			pstmt.setString(6, address);
			pstmt.setString(7, email);
			pstmt.setString(8, id);
			
			result = pstmt.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return 0;	
	} 
	
}
