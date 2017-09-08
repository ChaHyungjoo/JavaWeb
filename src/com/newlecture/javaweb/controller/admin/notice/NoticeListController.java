package com.newlecture.javaweb.controller.admin.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.MemberDao;
import com.newlecture.javaweb.dao.MemberRoleDao;
import com.newlecture.javaweb.dao.NoticeDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberRoleDao;
import com.newlecture.javaweb.dao.jdbc.JdbcNoticeDao;
import com.newlecture.javaweb.entity.Notice;

@WebServlet("/admin/notice/list")
public class NoticeListController extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ������ ���� �ִ��� ���ٸ� login �ϰ� ��
		
		// �Դٸ� ���������� �༭ ROLE_ADMIN�� �ִ��� Ȯ��
		
		MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
		//boolean roleHas = memberRoleDao.hasRole(id, roleName);
		// ���ٸ� ����-���Ѿ��� ��������
		
		
		String _query = request.getParameter("title");
		String _page = request.getParameter("p");
		
		int page = 1;
		if(_page!=null && !_page.equals(""))
			page = Integer.parseInt(_page);
		
		String query = "";	//�⺻��
		
		if(_query!=null && !_query.equals(""))
			query = _query;

	//-----------------------------------------------------------------------------------------------------------

		NoticeDao noticeDao = new JdbcNoticeDao();
		
		request.setAttribute("list", noticeDao.getList(page, query));
		request.setAttribute("count", noticeDao.getCount());
		
		//response.sendRedirect("notice.jsp");	//���ο� ������ ȣ��
		request.getRequestDispatcher("/WEB-INF/views/admin/notice/list.jsp")
		.forward(request, response);	//�������� ��� ������ ������ ���� �������� �Ѿ
		
	}
}
