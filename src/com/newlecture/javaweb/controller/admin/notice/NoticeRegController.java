package com.newlecture.javaweb.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.newlecture.javaweb.entity.Notice;

@WebServlet("/admin/notice/reg")
public class NoticeRegController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "insert into Notice(id, title, content, writerId) values((select ifnull(max(cast(id as unsigned)), 0)+1 from Notice n), ?, ?, ?)";

		// jdbc �뱶�씪�씠踰� 濡쒕뱶
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// �뿰寃� /�씤利�
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// �떎�뻾
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, "newlec");

			// 寃곌낵 媛��졇�삤湲�
			int result = st.executeUpdate();
			
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("notice-list");
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null)
			out.print("<script>alert('로그인이 필요한 요청입니다.');location.href='../../member/login?returnURL=../admin/notice/reg';</script>");
		else
			request.getRequestDispatcher("/WEB-INF/views/admin/notice/reg.jsp").forward(request, response);	//�럹�씠吏��뿉 �떞湲� �젙蹂대�� 媛�吏�怨� �떎�쓬 �럹�씠吏�濡� �꽆�뼱媛�
		
		
	}
}
