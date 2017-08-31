package com.newlecture.javaweb.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.NoticeDao;
import com.newlecture.javaweb.dao.jdbc.JdbcNoticeDao;
import com.newlecture.javaweb.entity.Notice;

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeDao noticeDao = new JdbcNoticeDao();
		int result = noticeDao.update(id, title, content);
		
		response.sendRedirect("notice-detail?id="+id);
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String _id = request.getParameter("id");
		String id ="";	//기본값
		
		// Model--------------------------------------------------------------------------------------
		Notice n = null;
		
		if(_id!=null && !_id.equals(""))
			id = _id;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM Notice WHERE id=?";

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
				n = new Notice();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setContent(rs.getString("CONTENT"));
				n.setWriterId(rs.getString("WRITERID"));
				n.setHit(rs.getInt("HIT"));
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("notice", n);
		
		//response.sendRedirect("notice.jsp");	//새로운 페이지 호출
		request.getRequestDispatcher("/WEB-INF/views/customer/notice/edit.jsp").forward(request, response);	//페이지에 담긴 정보를 가지고 다음 페이지로 넘어감
		
	}
}
