package com.newlecture.javaweb.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.MemberDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaweb.entity.Member;


@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao memberDao = new JdbcMemberDao();
		
		Member member = memberDao.get(id);
		
		if(member == null)
			response.sendRedirect("login?error");
		else if(!member.getPwd().equals(pwd))
			response.sendRedirect("login?error");
		else {	//인증 성공
			//현재 사용자의 상태 정보를 저장하는 저장소
			//session
			request.getSession().setAttribute("id", id);
			//cookie
			
			//모든 사용자의 상태 정보를 저장하는 저장소
			//application
			
		}
		
		response.sendRedirect("../index");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}
	
}
