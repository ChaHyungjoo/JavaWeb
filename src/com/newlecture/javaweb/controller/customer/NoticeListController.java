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

import com.newlecture.javaweb.entity.Notice;

@WebServlet("/customer/notice-list")
public class NoticeListController extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String _title = request.getParameter("title");
		String title="";	//기본값
		
		if(_title!=null && !_title.equals(""))
			title = _title;

	//-----------------------------------------------------------------------------------------------------------
		List<Notice> list = null;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM Notice WHERE title LIKE ?";

		// jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 /인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+title+"%");

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// Model--------------------------------------------------------------------------------------
			list = new ArrayList<Notice>();

			while (rs.next()) {
				Notice n = new Notice();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setContent(rs.getString("CONTENT"));
				n.setHit(rs.getInt("HIT"));
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
		
		request.setAttribute("list", list);
		
		//response.sendRedirect("notice.jsp");	//새로운 페이지 호출
		request.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp").forward(request, response);	//페이지에 담긴 정보를 가지고 다음 페이지로 넘어감
		
		
	}
}
