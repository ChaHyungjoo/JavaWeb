package com.newlecture.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.javaweb.dao.NoticeDao;
import com.newlecture.javaweb.entity.Notice;
import com.newlecture.javaweb.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao{

	public List<NoticeView> getList(int page, String query) {
		
		int offset = 10*(page-1);
		List<NoticeView> list = null;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM NoticeView WHERE title LIKE ? order by regDate desc limit ?, 10";
		
		// jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 /인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, offset);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// Model--------------------------------------------------------------------------------------
			list = new ArrayList<NoticeView>();

			while (rs.next()) {
				NoticeView n = new NoticeView();
				n.setId(rs.getString("id"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setWriterId(rs.getString("writerId"));
				n.setWriterName(rs.getString("writerName"));
				n.setHit(rs.getInt("hit"));
				n.setCountCmt(rs.getInt("countCmt"));
				list.add(n);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public int getCount() {
		
		int count = 0;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		//String sql = "SELECT * FROM Notice WHERE title LIKE ? order by regDate desc limit ?, 10";
		String sqlCount = "SELECT COUNT(id) count FROM Notice";
		
		// jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 /인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			Statement stCount = con.createStatement();
			ResultSet rsCount = stCount.executeQuery(sqlCount);
			rsCount.next();
			count = rsCount.getInt("count");
			
			rsCount.close();
			stCount.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public NoticeView get(String id) {
		
		NoticeView n=null;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM NoticeView WHERE id=?";
		
		// jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 /인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				n = new NoticeView();
				n.setId(rs.getString("id"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setWriterId(rs.getString("writerId"));
				n.setHit(rs.getInt("hit"));
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int update(String id, String title, String content) {
		
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "update Notice set title=?, content=? where id=?";

		// jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 /인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, id);

			// 결과 가져오기
			result = st.executeUpdate();
			
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
