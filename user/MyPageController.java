package com.osol.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osol.foodboard.VO.MemberVO;

@WebServlet("/mypage/view")
public class MyPageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pwd = request.getParameter("n");
		HttpSession session = request.getSession();
		
		MyPageDAO md = new MyPageDAO();
		String memberID = (String)session.getAttribute("userId");
		
		MemberVO mv = md.myinfo(memberID);
		
		request.setAttribute("mv", mv);
		
		if(pwd != null) {	
			request.getRequestDispatcher("/WEB-INF/user/MyPageUpdate.jsp").forward(request, response);
		} else {			
			request.getRequestDispatcher("/WEB-INF/user/MyPage.jsp").forward(request, response);
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
