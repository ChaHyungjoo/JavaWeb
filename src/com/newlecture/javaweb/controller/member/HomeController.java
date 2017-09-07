package com.newlecture.javaweb.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.javaweb.dao.MemberRoleDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberRoleDao;


@WebServlet("/member/home")
public class HomeController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();*/
		
		HttpSession session = request.getSession();
		Object _memberId = session.getAttribute("id");
		
		//1. 로그인 한 적이 없다면 일단 로그인하러가
		
		if(_memberId == null)
			response.sendRedirect("login");
		else {
			String memberId = _memberId.toString();
			MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
			
			String defaultRoleId = memberRoleDao.getDefaultRoleId(memberId);
			if(defaultRoleId.equals("ROLE_ADMIN"))
				response.sendRedirect("../admin/index");
			else if(defaultRoleId.equals("ROLE_STUDENT"))
				response.sendRedirect("../student/index");
			else
				response.sendRedirect("../index");
				
			
		}
		
		//2. 왔냐
		
		
	}

}
