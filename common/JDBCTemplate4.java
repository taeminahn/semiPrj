package com.osol.common;
/*Common 패키지
* - 공통적으로 사용되는 코드를 모아놓은 패키지
* - 공통적인 코드들을 Template Class 로 만들어서 중복을 제거
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* JDBCTemplate Class
 * - JDBC를 사용하면서 공통적으로 사용되는 코드들을 모아서 만들어 놓은 Class
 * - 드라이버 등록
 * - DBMS 연결 
 * - DBMS 연결 닫기(Connection close)
 * - 트랜잭션 제어 코드 (Commit, Rollback)
 * - Statement, PreparedStatement, ResultSet 닫기(close)
 */

// 방법 3 : 객체를 생성하지 않고 각 메소드를 호출해서 사용(정적 메소드로 구현 = static)
public class JDBCTemplate4 { // 방법 2 : conn 매개변수로 넣기
	// 필드부

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 드라이버 등록 - 생략가능(JDBC 하위버전 호환성을 위해 포함해줌)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SEMIPRJ","2130");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("재밌네 ㅋㅋ");
			e.printStackTrace();
		}
		return conn;
	}
	
	//DBMS 연결 닫기
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 트랜젝션 제어 (COMMIT)
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
			conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 트랜젝션 제어 (ROLLBACK)
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
			conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Statement, PreaparedStatement 닫기
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
			stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet 닫기
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
			rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
