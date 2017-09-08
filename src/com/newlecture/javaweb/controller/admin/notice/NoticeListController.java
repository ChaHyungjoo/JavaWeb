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
		
		// 인증한 적이 있는지 없다면 login 하고 와
		
		// 왔다면 인증정보를 줘서 ROLE_ADMIN이 있는지 확인
		
		MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
		//boolean roleHas = memberRoleDao.hasRole(id, roleName);
		// 없다면 에러-권한없음 페이지로
		
		
		String _query = request.getParameter("title");
		String _page = request.getParameter("p");
		
		int page = 1;
		if(_page!=null && !_page.equals(""))
			page = Integer.parseInt(_page);
		
		String query = "";	//기본값
		
		if(_query!=null && !_query.equals(""))
			query = _query;

	//-----------------------------------------------------------------------------------------------------------

		NoticeDao noticeDao = new JdbcNoticeDao();
		
		request.setAttribute("list", noticeDao.getList(page, query));
		request.setAttribute("count", noticeDao.getCount());
		
		//response.sendRedirect("notice.jsp");	//새로운 페이지 호출
		request.getRequestDispatcher("/WEB-INF/views/admin/notice/list.jsp")
		.forward(request, response);	//페이지에 담긴 정보를 가지고 다음 페이지로 넘어감
		
	}
}
