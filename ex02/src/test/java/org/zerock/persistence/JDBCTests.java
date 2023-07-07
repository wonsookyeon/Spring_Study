package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection conn =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","book","1234")) {
			log.info("conn : {}", conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","book","1234");
//			log.info("conn : {}", conn);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
		
	}

}
