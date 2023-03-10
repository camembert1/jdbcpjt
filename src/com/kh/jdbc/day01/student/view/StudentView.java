package com.kh.jdbc.day01.student.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentView {
	

	
	public void showAll(List<Student> students) {
		System.out.println("=== === 학생 전체 목록 조회 === ===");
		for(Student sOne : students) {
			System.out.print("아이디 : " + sOne.getStudentId());
			System.out.print(", 비밀번호 : " + sOne.getStudentPwd());
			System.out.print(", 이름 : " + sOne.getStudentName());
			System.out.print(", 성별 : " + sOne.getGender());
			System.out.print(", 나이 : " + sOne.getAge());
			System.out.print(", 이메일 : " + sOne.getEmail());
			System.out.print(", 전화번호 : " + sOne.getPhone());
			System.out.print(", 주소 : " + sOne.getAddress());
			System.out.print(", 취미 : " + sOne.getHobby());
			System.out.println("가입날짜 : " + sOne.getEnrollDate());
		}
		System.out.println();
	}
	
	public Student inpuStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String studentId = sc.next();
		System.out.print("이름 : ");
		String studentName = sc.next();
		System.out.print("비밀번호 : ");
		String studentPwd = sc.next();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미(, 로 구분) : ");
		String hobby = sc.next();
		
		Student student = 
				new Student(studentId
							, studentName
							, studentPwd
							, gender
							, age
							, email
							, phone
							, address
							, hobby
							, null);
		
		return student;

	}

	
	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 선택 : ");
		int select = sc.nextInt();
		return select;
	}
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}
	
	public void displaySuccess(String msg) {
		System.out.println("[서비스 성공] : " + msg);
	}
	
	public void displayError(String msg) {
		System.out.println("[서비스 실패] : " + msg);
	}
}
