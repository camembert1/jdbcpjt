package com.kh.jdbc.day01.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.student.model.vo.Student;


public class StudentDAO {
	
	public List<Student> selectAll() {
		
		String  url = "jdbc:oracle:thin:@localhost:1521:xe";
		String  user = "STUDENT";
		String  password = "STUDENT";
		String  sql = "SELECT * FROM STUDENT_TBL";
		Student student = null;
		List<Student> sList = null;
		try {
			// 1. 드라이버 등록 - 시험에서 드라이버 명을 외워야 될까요? 안외워도 돼요~
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 연결 생성
			Connection conn = DriverManager.getConnection(url, user, password);
			
			// 3. 쿼리문 실행준비(STATEMENT 생성)
			Statement stmt = conn.createStatement();
			
			// 4. 쿼리문 실행 및 결과 받기 (SELECT문)
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Student>();
			
			// 5. 후처리
			while(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setGender(rset.getString("GENDER"));
				student.setAge(rset.getInt("AGE")); // getInt 이게 이제 시험문제가 될 수 잇습니다~!~!~!~
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
				sList.add(student); // 상차 ㅋ 이거 맨낼빼먹음 까먹지말기~
			}
			
			// 6. 자원해제
			rset.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sList;
		
	}
	
	public int insertMember(Student student) {
		// 데이터는 이미 준비돼있다고 가정~
		// 원래는 입력받아야됨
//		Student student = new Student();
//		student.setStudentId("khuser02");
//		student.setStudentName("이용자");
//		student.setStudentPwd("pass02");
//		student.setAge(22);
//		student.setGender("M");
		// 데이터 준비 완료
		// 이거를 인제,,, 직접 입력하지 ㅇ낳고,,,
		// 호ㅓㅏ면에서 입력을 받고 싶은 거예요,,,,,,
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "STUDENT";
		String password = "STUDENT";
		
		//여기서 오류가 진짜 많이나요,,,, 쿼리문
		String sql = "INSERT INTO STUDENT_TBL VALUES("
				+ "'" + student.getStudentId() +"',"
				+ "'" + student.getStudentPwd() + "',"
				+ "'" + student.getStudentName() +"',"
				+ "'" + student.getGender() + "',"
				+ ""  + student.getAge() + ","
				+ "'" + student.getEmail()  + "',"
				+ "'" + student.getPhone() + "',"
				+ "'" + student.getAddress() + "',"
				+ "'" + student.getHobby() + "',"
				+ "SYSDATE)";
		
		int result = 0;
		
		try {
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			// 쿼리문 실행 - DML(INSERT, UPDATE, DELETE) !!!!!!!!!!!!!!!!!!!!!!!
			// SELECT아니고~
			result = stmt.executeUpdate(sql);
			// 실패하면 0이들어감 아니면 다른 숫자~ int로 받는다
			// 셤 나올 수도 잇음 ~!~
			// 위에거랑 비교해보기 SELECT할때랑~
			// 후처리 필요없고 걍 result 반환해주면 됨
			// result에 들어가는 값은 n개 행이 삽입/삭제/업뎃되엇슴다
			// 할 때 n인듯 0개 행이 업뎃됏슴다~
			// 만약에 성공을 햇어요,, 1개행이 삭제됏슴다,, 1값은  result에 들어가게 된다,,
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
