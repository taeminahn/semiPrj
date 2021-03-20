package com.osol.qnaboard.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/qnaboard/write")
public class WriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("userId");
		
		if(userID == null) { // 글쓰기 권한 검증 (비로그인 시 로그인 화면으로 이동)
			response.sendRedirect("/login");
		} else {
			request.getRequestDispatcher("/WEB-INF/qnaboard/write.jsp").forward(request, response);						
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
}
