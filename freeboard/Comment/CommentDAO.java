package com.osol.freeboard.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.osol.common.JDBCTemplate4;


public class CommentDAO {
	
	public int cmtWrite(String id, int num, String comment) throws Exception {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO CMT VALUES(C_NUM_SEQ.NEXTVAL,?,?,SYSTIMESTAMP,?,C_NUM_SEQ.NEXTVAL,0,0,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setString(2, id);
			pstmt.setInt(3, num);
			pstmt.setString(4, id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
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
	
	public JsonArray getCommentList(int num) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JsonArray array = new JsonArray();
		
		String sql = "SELECT * FROM CMT WHERE BOARD_NUM_SEQ = "+num+" ORDER BY CMT_REPLY_NUM, CMT_DEPTH, CMT_PUBDATE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("왔냐?");
			
			while(rs.next()) {
				JsonObject object = new JsonObject();
				object.addProperty("cmtNum", rs.getInt(1));
				object.addProperty("content", rs.getString(2));
				object.addProperty("writer", rs.getString(3));
				String date = format.format(rs.getDate(4));				
				object.addProperty("pubDate", date);
				object.addProperty("bNum", rs.getInt(5));
				object.addProperty("cmtRnum", rs.getInt(6));
				object.addProperty("state", rs.getInt(7));
				object.addProperty("depth", rs.getInt(8));
				object.addProperty("origin_writer", rs.getString(9));
				array.add(object);
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
		return array;
	}
	
	public int cmtUpdate(String comment, int num) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE CMT SET CMT_CONTENT = ? WHERE CMT_NUM_SEQ = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
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
	
	public int cmtDelete(int cmtState, int cmtNum) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE CMT SET CMT_STATE = ? WHERE CMT_NUM_SEQ = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cmtState);
			pstmt.setInt(2, cmtNum);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
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

	public int getReplyNum(int num) {
		
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "SELECT CMT_DEPTH FROM CMT WHERE CMT_NUM_SEQ = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)==0) {
					result = 1;
					return result;
				}
			}
		} catch (Exception e) {
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
		return result;
	}
	
	public int replyAdd(String originId, int cmtNum, int boardNum, String uId, String comment) {
		Connection conn = JDBCTemplate4.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO CMT VALUES(C_NUM_SEQ.NEXTVAL,?,?,SYSTIMESTAMP,?,?,0,1,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setString(2, uId);
			pstmt.setInt(3, boardNum);
			pstmt.setInt(4, cmtNum);
			pstmt.setString(5, originId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
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
