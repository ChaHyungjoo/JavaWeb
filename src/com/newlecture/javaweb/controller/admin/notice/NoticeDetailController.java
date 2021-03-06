package com.newlecture.javaweb.controller.admin.notice;

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

@WebServlet("/admin/notice/detail")
public class NoticeDetailController extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String _id = request.getParameter("id");
		String id ="";	//기본값
		
		if(_id!=null && !_id.equals(""))
			id = _id;
		// Model--------------------------------------------------------------------------------------
		NoticeDao noticeDao = new JdbcNoticeDao();
		Notice n = noticeDao.get(id);
		
		request.setAttribute("notice", n);
		
		//response.sendRedirect("notice.jsp");	//새로운 페이지 호출
		request.getRequestDispatcher("/WEB-INF/views/admin/notice/detail.jsp").forward(request, response);	//페이지에 담긴 정보를 가지고 다음 페이지로 넘어감
		
	}
}
