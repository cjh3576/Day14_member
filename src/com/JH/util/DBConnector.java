package com.JH.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	public static Connection getConnect() throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.25:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//드라이버 로딩
		Class.forName(driver);
		//사용자 정보 입력받아 DB 연결
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public static void disConnect (PreparedStatement st, Connection con) throws Exception {
		st.close();
		con.close();
	}
	public static void disConnect (ResultSet rs, PreparedStatement st, Connection con) throws Exception {
		rs.close();
		DBConnector.disConnect(st, con);
	}
}
