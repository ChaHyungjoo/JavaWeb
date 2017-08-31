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

@WebServlet("/customer/notice-detail")
public class NoticeDetailController extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String _id = request.getParameter("id");
		String id ="";	//�⺻��
		
		if(_id!=null && !_id.equals(""))
			id = _id;
		// Model--------------------------------------------------------------------------------------
		NoticeDao noticeDao = new JdbcNoticeDao();
		Notice n = noticeDao.get(id);
		
		request.setAttribute("notice", n);
		
		//response.sendRedirect("notice.jsp");	//���ο� ������ ȣ��
		request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp").forward(request, response);	//�������� ��� ������ ������ ���� �������� �Ѿ
		
	}
}
