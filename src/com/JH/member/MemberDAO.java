package com.JH.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.JH.util.DBConnector;

public class MemberDAO {
	//정보전체출력
	public ArrayList<MemberDTO> selectList() throws Exception {
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		Connection con = DBConnector.getConnect();

		String sql = "select * from member";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));

			ar.add(dto);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;

	}
	//id 검색 출력
	public MemberDTO selectOne(String name) throws Exception {
		Connection con = DBConnector.getConnect();
		MemberDTO dto = null;

		String sql = "select * from member where id = ? ";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, name);
		//쿼리실행
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));
		}
		DBConnector.disConnect(rs, st, con);
		return dto;

	}

	//회원탈퇴

	public int delete(String name) throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "delete member where id = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, name);

		result = st.executeUpdate();
		DBConnector.disConnect(st, con);

		return result;

	}
	//회원가입
	public int insert(MemberDTO dto) throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "insert into member values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setInt(4, dto.getAge());
		st.setDate(5, dto.getBirth());

		result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	// 입력한 글자가 포함된 아이디 출력
	public ArrayList<MemberDTO> searchMember(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select id from member where id like ?";
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+ id + "%");

		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id")); 
			ar.add(dto);
		}

		DBConnector.disConnect(rs, st, con);
		return ar;
	}























}
