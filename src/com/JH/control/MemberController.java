package com.JH.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.JH.input.MemberInput;
import com.JH.member.MemberDAO;
import com.JH.member.MemberDTO;
import com.JH.view.MemberView;

public class MemberController {
	private Scanner sc;
	private MemberInput mi;
	private MemberDAO md;
	private MemberView mv;
	private ArrayList<MemberDTO> ar;
	
	public MemberController() {
		sc = new Scanner(System.in);
		mi = new MemberInput();
		md = new MemberDAO();
		mv = new MemberView();
		ar = new ArrayList<MemberDTO>();
	}
	
	public void start() throws Exception {
		MemberDTO dto = null;
		boolean check = true;
		int num;
		while(check) {
			System.out.println("1. 회원가입      2. 회원탈퇴      3. 회원정보검색    4. 회원전체정보   5. 종료");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				dto = mi.setMember();
				int result = md.insert(dto);
				String message = "등록실패";
				if (result>0) {
					message = "등록성공";
					ar.add(dto);
				}
				mv.view(message);
				break;
				
			case 2:
				String n = mi.setNum("삭제");
				md.delete(n);
				String message2 = "삭제실패";
				if(n != null) {
					message2 = "삭제성공";
				}
				mv.view(message2);
				break;
				
			case 3:
				n = mi.setNum("조회");
				dto = md.selectOne(n);
				if(dto != null) {
					mv.view(dto);
				} else {
					mv.view("없는 ID");
				}
				break;
				
			case 4:
				ar = md.selectList();
				mv.view(ar);
				break;
				default :
					check = !check;
					System.out.println("프로그램 종료");
					break;
			}
		}
	}
}
