package com.JH.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.JH.member.MemberDTO;

public class MemberView {
	public void view (String s) {
		System.out.println(s);
	}
	
	public void view(MemberDTO dto) throws SQLException {
		System.out.println("ID : " + dto.getId());
		System.out.println("PW : " + dto.getPw());
		System.out.println("NAME : " + dto.getName());
		System.out.println("AGE : " + dto.getAge());
		System.out.println("BIRTH : " + dto.getBirth());
		System.out.println("===========================");
	}
	
	public void view(ArrayList<MemberDTO> ar) throws Exception {
		for(MemberDTO dto : ar) {
			this.view(dto);
		}
	}
}
