package com.newlecture.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.javaweb.dao.MemberRoleDao;
import com.newlecture.javaweb.entity.Member;

public class JdbcMemberRoleDao implements MemberRoleDao {

	@Override
	public String getDefaultRoleId(String memberId) {
		
		String role = "";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT roleId FROM MemberRole where memberId=? and defaultRole=1";
		
		// jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 /인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberId);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				role = rs.getString("roleId");

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return role;
	}
	
}
