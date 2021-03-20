package com.osol.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join/reg")
public class JoinMemberController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("여기까지는 잘옴");
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPassword");
		String pwCheck = request.getParameter("userPwCheck");
		String name = request.getParameter("userName");
		String gender = request.getParameter("userGender");
		String birthDay = request.getParameter("userBirth");
		String phone = request.getParameter("userPhoneNumber");
		String address1 = request.getParameter("userAddress1");
		String address2 = request.getParameter("userAddress2");
		String address3 = request.getParameter("userAddress3");
		String email = request.getParameter("userEmail");
		String address = address1+" "+address2+" "+address3;
		
		MemberVO mv = new MemberVO(id, pw, name, birthDay, gender, email, phone, address);
		JoinMemberService jms = new JoinMemberService();
		
		String result = Integer.toString(jms.join(mv));
		
		response.getWriter().append(result);
		
	}
	
}
