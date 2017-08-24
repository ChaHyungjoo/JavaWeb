package com.newlecture.javaweb.controller;

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

@WebServlet("/nana")
public class NoticeController extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _title = request.getParameter("title");
		
		//notice?title=aa : title="aa"
		//notice?title=   : title=""
		//notice		  : title=null
		
		String title="";	//�⺻��
		
		if(_title!=null && !_title.equals(""))
			title = _title;

	//-----------------------------------------------------------------------------------------------------------
		List<Notice> list = null;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM Notice WHERE title LIKE ?";

		// jdbc ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ���� /����
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// ����
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+title+"%");

			// ��� ��������
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
		
		//response.sendRedirect("notice.jsp");	//���ο� ������ ȣ��
		request.getRequestDispatcher("notice.jsp").forward(request, response);	//�������� ��� ������ ������ ���� �������� �Ѿ
		
	}
}
