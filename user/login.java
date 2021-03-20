package com.osol.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

 @WebServlet("/login.kh")
public class login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		System.out.println("여기까진 잘옴!");
		System.out.println("id : "+id+" pw : "+pw);
		
		LoginService ls = new LoginService();
		String result = Integer.toString(ls.login(id, pw));
		
		System.out.println("서비스 결과 : "+result);
		if(result.equals("1")) {
			System.out.println("아이디/비밀번호 일치");
			session.setAttribute("userId", id);
		}
		response.getWriter().append(result);
	}
}
