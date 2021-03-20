package com.osol.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.studyboard.VO.MemberVO;

@WebServlet("/joinCheck")
public class JoinCheckController extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("mbId");
		
		JoinCheckDAO jcd = new JoinCheckDAO();
		String mbId =  jcd.idCheck(userId);
		
		if(mbId == userId) {
			System.out.println("아이디 중복");
		}else {
			System.out.println("사용가능 아이디");
		}
		
		response.getWriter().append(mbId);
	}
}
