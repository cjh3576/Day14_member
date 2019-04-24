package com.JH.input;

import java.sql.Date;
import java.util.Scanner;

import com.JH.member.MemberDTO;

public class MemberInput {
	//회원가입
	
	public MemberDTO setMember() {
		Scanner sc = new Scanner(System.in);
		MemberDTO dto = new MemberDTO();
		Date d = null;
		System.out.println("ID 입력");
		dto.setId(sc.next());
		System.out.println("PW 입력");
		dto.setPw(sc.next());
		System.out.println("Name 입력");
		dto.setName(sc.next());
		System.out.println("Age 입력");
		dto.setAge(sc.nextInt());
		System.out.println("Birth 입력");
		String birth = sc.next();
		d = Date.valueOf(birth);
		dto.setBirth(d);
		return dto;
	}
	
	
	public String setNum(String s) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ID를 입력하세요");
		String name = sc.next();
		
		return name;
		
	}
}
