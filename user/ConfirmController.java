package com.osol.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osol.foodboard.VO.MemberVO;

@WebServlet("/mypage/password")
public class ConfirmController extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("패스워드 확인페이지");
	 
	 HttpSession session = request.getSession();
	 
	 String userId = (String)session.getAttribute("userId");
	 String userPwd = request.getParameter("userPwd");
	 
	 
	 ConfirmDAO cd = new ConfirmDAO();
	 MemberVO mv = new MemberVO();
	 
	 mv = cd.passwordconfirm(userId);
	 String Pwd = mv.getMemberPwd();
	 
	 int result_ = 0;
	 
	 if(Pwd.equals(userPwd)) {
		result_++;
	 }
	 
	 String result = Integer.toString(result_);
	 System.out.println(result);

	 response.getWriter().append(result);
	 
	 
}
 
 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
}
