package com.osol.foodboard.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.osol.foodboard.VO.BoardVO;



public class BoardListDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;
	
	public BoardListDAO() {
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
	      String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM FOODBOARD WHERE "+field+" LIKE ? ORDER BY B_PUBDATE DESC) N) WHERE NUM BETWEEN ? AND ?";
	      System.out.println("ㅇㅇㅇㅁㄴㅇㅇ");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, "%"+query+"%");
	         pstmt.setInt(2, 1+(page-1)*5);
	         pstmt.setInt(3, page*5);
	         rset = pstmt.executeQuery();

	         while(rset.next()) {
	            int bbsNum = rset.getInt("B_NUM_SEQ");
	            String kind = rset.getString("B_KIND");
	            String grade = rset.getString("B_GRADE");
	            String bbsTitle = rset.getString("B_TITLE");
	            String bbsContent = rset.getString("B_CONTENT");
	            Date bbsPubDate = rset.getDate("B_PUBDATE");
	            int bbsHit = rset.getInt("B_HIT");
	            String bbsState = rset.getString("B_STATE");
	            String bbsFiles = rset.getString("B_ATTACHEDFILE");
	            String bbsWriter = rset.getString("B_WRITER");


	            
	            BoardVO BV = new BoardVO(
	    	            bbsNum,
	    	            kind,
	    	            grade,
	    	            bbsTitle,
	    	            bbsContent,
	    	            bbsPubDate,
	    	            bbsHit,
	    	            bbsState,
	    	            bbsFiles,
	    	            bbsWriter
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
	
	
	
	
	
	
}
