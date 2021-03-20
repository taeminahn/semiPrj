package com.osol.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pwAuthentication")
public class pwAuthenticationController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// pwFinderCheckController에서 미리 넣어둔 인증번호 세션의 값
		String AuthenticationKey = (String) request.getSession().getAttribute("AuthenticationKey");
		// 사용자가 인증번호 입력한 값
		String AuthenticationUser = request.getParameter("AuthenticationUser");
		
		// 저 두개를 비교해서 맞지 않으면 이전 페이지로 보냄
		if(!AuthenticationKey.equals(AuthenticationUser)) {
			request.getRequestDispatcher("/WEB-INF/user/authenticationError.jsp").forward(request, response);
			return;
		}
		
		// 비밀번호와 비밀번호 확인이 일치하지 않을 경우도 역시 이전페이지로 돌려보냄
		String id = request.getParameter("id");
		String newPw = request.getParameter("newPw");
		String newPwCheck = request.getParameter("newPwCheck");
		
		if(!newPw.equals(newPwCheck)) {
			request.getRequestDispatcher("/WEB-INF/user/authenticationError.jsp").forward(request, response);
			return;
		}
		
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.changePw(id, newPw);
		
		request.getRequestDispatcher("/WEB-INF/user/pwChangeSuccess.jsp").forward(request, response);
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}
