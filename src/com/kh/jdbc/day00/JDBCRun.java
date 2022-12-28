package com.kh.jdbc.day00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCRun {

	public static void main(String[] args) {
		/*
		 * 1. 드라이버 등록
		 * 2. 
		 */
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "Student";
			String password = "STUDENT";
			String sql = "SELECT * FROM STUDENT_TBL";
			
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 연결생성
			Connection conn = DriverManager.getConnection(url, user, password);
			// new~안 쓰고 바로 호출할 수 있는 이유
			// static메소드이기때문에~~~~~
			
			// 3. 쿼리문 실행 준비(Statement 객체 생성)
			Statement stmt = conn.createStatement();
			
			// 4. 쿼리문 실행
			ResultSet rset = stmt.executeQuery(sql);
			
			//후처리 - DB에서 가져온 데이터 사용
			while (rset.next()) {
				System.out.println("사원 아이디  : " + rset.getString("STUDENT_ID"));
			}
			
			// 자원해제
			rset.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
