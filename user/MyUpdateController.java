package com.osol.user;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage/update")
public class MyUpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정하고 제출하기를 눌렀다.(업데이트 페이지로 옴)");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userId");
		
		
		String password = request.getParameter("userPW");
		String name = request.getParameter("userName");
		String gender = request.getParameter("userGender");
		Date birth = Date.valueOf(request.getParameter("userBirth"));
		String phone = request.getParameter("userPhoneNumber");
		String userPost = request.getParameter("userPost");
		String userAddress = request.getParameter("userAddress");
		String subAddress = request.getParameter("subAddress");
		String address = userPost + userAddress + subAddress;
		String email = request.getParameter("userEmail");
		
		System.out.println(password);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(birth);
		System.out.println(phone);
		System.out.println(address);
		System.out.println(email);
		
		
		MyUpdateDAO md = new MyUpdateDAO();
		
		String result = Integer.toString(md.update(password, name, gender, birth, phone, address, email, id));
		
		System.out.println(result+": 수정이 되있는가");
		
		response.getWriter().append(result);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}
